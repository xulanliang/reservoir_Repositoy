/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare", "dojo/dom", "dojo/on",
    "dojo/_base/array", "dojo/dom-construct", "dojo/dom-style", "dojo/string",
    "./_BaseWidget", "esri/domUtils"
], function (declare, dom, on, arrayUtils, domConstruct, domStyle, string, _BaseControl, domUtils) {
    //
    var _map = null;
    var loadTools = [];
    var baseDomNode = null;
    var _self = null;
    //下拉菜单是否点击.
    var isDropDownClicked = false;
    /**
     * ============================================================================================
     * 工具条配置信息
     * ============================================================================================
     * */
    var toolsCfg = [
        {
            id: "dtqh",
            name: "底图",
            icon: window.styleName + "/img/toolbars/qp.png",
            tool: "dsegis/tools/LayerSwitchTool",
            isInFrame: false,
            isAutoDown: true // 鼠标移入，显示下拉列表,针对单个工具
        },
        {
            id: "tools",
            name: "工具",
            icon: window.styleName + "/img/toolbars/tool_dn.png",
            items: [
                {
                    id: "cj",
                    name: "测距",
                    icon: window.styleName + "/img/toolbars/cj.png",
                    tool: "dsegis/tools/PolylineTool" // 工具代码. 必填
                },
                {
                    id: "cm",
                    name: "测面",
                    icon: window.styleName + "/img/toolbars/cm.png",
                    tool: "dsegis/tools/PolygonTool"
                },
                {
                    id: "fw1",
                    name: "复位",
                    icon: window.styleName + "/img/toolbars/fw.png",
                    tool: "dsegis/tools/BackTool",
                    split: true
                },
                {
                    id: "qc",
                    name: "清除",
                    icon: window.styleName + "/img/toolbars/ico_qc.png",
                    tool: "dsegis/tools/ClearTool"
                },
                {
                    id: "dtfw",
                    name: "范围",
                    icon: window.styleName + "/img/toolbars/ico_qc.png",
                    tool: "dsegis/tools/MapExtentTool"
                }
            ]
        },
        {
            id: "qp",
            name: "全屏",
            icon: window.styleName + "/img/toolbars/qp.png",
            tool: "dsegis/tools/FullTool",
            isInFrame: true
        }
    ];
    //当前显示的下拉菜单.
    var currentPanel = null;
    /**
     * ============================================================================================
     * 工具条代码.
     * ============================================================================================
     * */
    return declare(null, {
        //
        constructor: function (options) {
            //
            _map = options.map;
            // toolsCfg = options.tools;
            _self = this;
            //
            if (_map) {
                //
                baseDomNode = dom.byId(_map.id);
            }
            //create tools.
            arrayUtils.forEach(toolsCfg, function (cfg) {
                //
                //create tool.
                if (cfg.tool) {
                    //
                    require([cfg.tool], function (Tool) {
                        //
                        var tool = new Tool(_map);
                        //
                        loadTools.push({ id: cfg.id, tool: tool });
                    });
                }
                // create sub tools.
                if (cfg.items) {
                    //
                    var items = cfg.items;
                    items.forEach(function (item) {
                        //
                        if (item.tool) {
                            //
                            require([item.tool], function (Tool) {
                                //
                                var tool = new Tool(_map);
                                //
                                loadTools.push({ id: item.id, tool: tool });
                            });
                        }
                    });
                }
            });
        },
        _findToolBy: function (toolId) {
            //
            var items = arrayUtils.filter(loadTools, function (tool) {
                //
                return tool.id === toolId;
            });
            return items[0].tool;
        },
        //
        init: function () {
            //
            var divCtn = domConstruct.create("div", {
                //
                id: "toolbars",
                class: "u-tool-bar "
            }, baseDomNode);
            //
            var container = domConstruct.create("ul", {
                id: "navigation"
            }, divCtn);
            //
            //
            arrayUtils.forEach(toolsCfg, function (cfg, iindex) {
                //
                var infoTemplate = "";
                //
                if (iindex === 0) {
                    //
                    infoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label><span class='u-split-line' style='display: none;'></span>";
                }
                else {
                    //
                    infoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label><span class='u-split-line'></span>";
                }
                //
                var subInfoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label><span class='u-split-line'></span>";
                //
                var info = string.substitute(infoTemplate, {
                    //
                    name: cfg.name,
                    icon: window.dseGisPath + cfg.icon
                });
                //
                var subInfo = string.substitute(subInfoTemplate, {
                    //
                    name: cfg.name,
                    icon: window.dseGisPath + cfg.icon
                });
                //
                if (cfg.items) {
                    //
                    var subTools = domConstruct.create("li", {
                        innerHTML: subInfo
                    }, container);
                    //
                    var panel = _self._createDropDownMenu(cfg.items, subTools);
                    //
                    on(subTools, "click", function (event) {
                        //
                        currentPanel = panel;
                        if (!isDropDownClicked) {
                            domUtils.show(panel);
                            isDropDownClicked = true;
                        }
                        else {
                            domUtils.hide(currentPanel);
                            isDropDownClicked = false;
                        }
                    });
                    //
                    $(subTools).mouseover(function () {
                        //
                        isDropDownClicked = true;
                        $(panel).show();
                    });
                    $(subTools).mouseout(function () {
                        //
                        isDropDownClicked = false;
                        $(panel).hide();
                    });
                }
                else {
                    //
                    var toolItem = domConstruct.create("li", {
                        innerHTML: info
                    }, container);
                    ////
                    if (cfg.isAutoDown) {
                        //
                        on(toolItem, "mouseover", function (event) {
                            //
                            _self._bindEventToolItem(this, cfg);
                        });
                    }
                    else {
                        //
                        on(toolItem, "click", function (event) {
                            //
                            _self._bindEventToolItem(this, cfg);
                        });
                    }
                }
            });
        },
        //
        _bindEventToolItem: function (domNode, cfg) {
            //
            var cmd = _self._findToolBy(cfg.id);
            if (cmd) {
                //释放上一次激活的按钮.
                _self._deactivate();
                cmd.setDomNode(domNode);
                cmd.setConfig(cfg);
                if (cfg.isInFrame) {
                    //
                    cmd.activate(cfg.isInFrame);
                }
                else {
                    //
                    cmd.activate();
                }
            }
        },
        //
        _createDropDownMenu: function (infos, domNode) {
            var panel = domConstruct.create("ul", {}, domNode);
            //
            //
            var infoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label>";
            //
            arrayUtils.forEach(infos, function (cfg) {
                //
                /**
                 * <ul>
                 <li><label>栏目1->菜单1</label><span></span></li>
                 </ul>
                 * */
                var info = string.substitute(infoTemplate, {
                    //
                    name: cfg.name,
                    icon: window.dseGisPath + cfg.icon
                });
                var liNode = domConstruct.create("li", {
                    //
                    innerHTML: info
                }, panel);
                //
                on(liNode, "click", function (event) {
                    //
                    var cmd = _self._findToolBy(cfg.id);
                    if (cmd) {
                        //隐藏下拉列表
                        domUtils.hide(panel);
                        //释放上一次激活的按钮.
                        _self._deactivate();
                        //
                        cmd.setDomNode(this);
                        cmd.setConfig(cfg);
                        // console.log(JSON.stringify(cmd));
                        // cmd.activate();
                        if (cfg.isInFrame) {
                            //
                            cmd.activate(cfg.isInFrame);
                        }
                        else {
                            //
                            cmd.activate();
                        }
                    }
                });
            });
            //
            return panel;
        },
        /**
         * 释放所有已经激活的工具
         * */
        _deactivate: function () {
            //
            /* arrayUtils.forEach(loadTools, function (info) {
             //
             //
             var tool = info.tool;
             tool.deactivate();
             });*/
        }
    });
});
//# sourceMappingURL=ToolbarControl.js.map