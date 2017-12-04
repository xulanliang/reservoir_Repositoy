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
            id: "cj",//工具ID 必填
            name: "测距",//工具名称  必填
            icon: styleName + "/img/toolbars/cj.png",// 工具图标 ,
            tool: "dse_gis/tools/PolylineTool"// 工具代码. 必填
        },
        {
            id: "cm",
            name: "测面",
            icon: styleName + "/img/toolbars/cm.png",
            tool: "dse_gis/tools/PolygonTool"
        },
        {
            id: "qp",
            name: "全屏",
            icon: styleName + "/img/toolbars/qp.png",
            tool: "dse_gis/tools/FullTool",
            isInFrame: true,
        },
        {

            id: "tools",
            name: "工具",
            icon: styleName + "/img/toolbars/tool_dn.png",
            items: [
                {
                    id: "fw1",
                    name: "复位",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/BackTool",
                    split: true
                },
                {
                    id: "fw5",
                    name: "地图对比",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/CompareTool",
                    split: true
                },
                {
                    id: "fw6",
                    name: "闪烁图",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/ChartCircleTool",
                    split: true
                },
                {
                    id: "fw7",
                    name: "线状图",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/ChartLineTool",
                    split: true
                },
                /*{
                 id: "fw8",
                 name: "热力图",
                 icon: styleName + "/img/toolbars/fw.png",
                 tool: "dse_gis/tools/HeatMapTool",
                 split: true
                 },*/
                {
                    id: "fw9",
                    name: "透视镜",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/SwipeTool",
                    split: true
                }
            ]
        },
        {
            id: "fw",
            name: "图表",
            icon: styleName + "/img/toolbars/fw.png",
            // tool: "dse_gis/tools/BackTool",
            items: [
                {
                    id: "fw10",
                    name: "复位",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/BackTool",
                    split: true
                }, {
                    id: "fw11",
                    name: "饼状图",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/PieChartTool",
                    split: true
                },
                {
                    id: "fw12",
                    name: "柱状图",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/ColumnChartTool",
                    split: true
                },
                {
                    id: "fw13",
                    name: "仪表盘",
                    icon: styleName + "/img/toolbars/fw.png",
                    tool: "dse_gis/tools/CompositeChartTool",
                    split: true
                }

            ]
        },
        {
            id: "qc",
            name: "清除",
            icon: styleName + "/img/toolbars/ico_qc.png",
            tool: "dse_gis/tools/ClearTool"
        },
        {
            id: "dtqh",
            name: "底图",
            icon: styleName + "/img/toolbars/qp.png",
            tool: "dse_gis/tools/LayerSwitchTool",
            isInFrame: false,
        },
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
                        loadTools.push({id: cfg.id, tool: tool});
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
                                loadTools.push({id: item.id, tool: tool});
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
                } else {
                    //
                    infoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label><span class='u-split-line'></span>";
                }
                //
                var subInfoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label><span class='u-split-line'></span>";
                //
                var info = string.substitute(infoTemplate, {
                    //
                    name: cfg.name,
                    icon: "../" + cfg.icon
                });
                //
                var subInfo = string.substitute(subInfoTemplate, {
                    //
                    name: cfg.name,
                    icon: "../" + cfg.icon
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
                        //
                        currentPanel = panel;
                        if (!isDropDownClicked) {
                            domUtils.show(panel);
                            isDropDownClicked = true
                        } else {
                            domUtils.hide(currentPanel);
                            isDropDownClicked = false;
                        }
                        //
                    });
                    //
                    /*on(subTools, "mouseover", function (event) {
                     //
                     domUtils.hide(currentPanel);
                     });*/
                    //
                    on(panel, "mouseout", function (event) {
                        //
                        setTimeout(function () {
                            domUtils.hide(panel);
                            isDropDownClicked = false;
                        }, 3000);
                    });
                } else {
                    //
                    var toolItem = domConstruct.create("li", {
                        innerHTML: info
                    }, container);

                    on(toolItem, "click", function (event) {
                        //
                        var cmd = _self._findToolBy(cfg.id);
                        if (cmd) {
                            //释放上一次激活的按钮.
                            _self._deactivate();
                            cmd.setDomNode(this);
                            cmd.setConfig(cfg);
                            if (cfg.isInFrame) {
                                //
                                cmd.activate(cfg.isInFrame);
                            } else {
                                //
                                cmd.activate();
                            }
                        }
                    });
                }
            });
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
                    icon: "../" + cfg.icon
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
                        } else {
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
            arrayUtils.forEach(loadTools, function (info) {
                //
                //
                var tool = info.tool;
                tool.deactivate();
            });
        }
    });

});
