/**
 * Created by Administrator on 2016/11/15.
 * <description>图层管理控件.</description>
 */
define(["dojo/_base/declare", "dojo/dom", "dojo/on",
    "dse_gis/controls/_BaseWidget", "dojo/_base/array", "dojo/dom-construct", "dojo/dom-style", "dojo/string", "dojo/_base/lang",
    "dojo/query"
], function (declare, dom, on, _BaseWidget, arrayUtils, domConstruct, domStyle, string, lang, query) {
    return declare([_BaseWidget], {
        //
        constructor: function (nodeId, options) {
            //
            // this.__init(nodeId, options);
            //
            if (options.map) {
                this.__init(nodeId, options);
            }
        },
        //
        __init: function (nodeId, options) {
            //
            //
            var _dseMap = options.map;
            var _layers = options.layers || [];
            var _domNode = dom.byId(nodeId);
            //
            var _self = this;
            //
            var layerUtils = options.util;
            //
            // var zTreeNodes = [];
            var setting = null;
            //
            //内部事件，不需模块外部调用
            var _LAYER_INTO_MANAGER = "layerIntoManager001";
            //
            //
            /**基础图层不可清除*/
            _self._baseConfig = [];
            //
            _layers.forEach(function (cfg) {
                //
                if (cfg.layers) {
                    cfg.layers.forEach(function (info) {
                        //
                        var item = {
                            id: info.id,
                            name: info.name,
                            checked: info.initShow
                            // url: cfg.url
                        };
                        _self._baseConfig.push(item);
                    });
                }
                else {
                    cfg.visible = cfg.initShow;
                    var item1 = {
                        id: cfg.id,
                        name: cfg.name,
                        checked: cfg.initShow
                        // url: cfg.url
                    };
                    _self._baseConfig.push(item1);
                }
            });
            //
            _self._isInArray = function (nodes, current) {
                //
                if (nodes && nodes.length > 0) {
                    var state = nodes.some(function (node) {
                        //
                        return node.name === current.name;
                    });
                    return state;
                }
                else {
                    return false;
                }
            };
            //
            _self._layerMaxIndex = 5;
            _self._layerCount = 0;
            /**
             * 向图层管理中添加新图层
             * */
            _self._addNewLayers = function (layers) {
                // var itemNode = _self._addTreeNodeItem(data);
                // zTreeNodes.push(itemNode);//
                var nodes = _self._createLayerItems();
                //
                if (layers && layers instanceof Array) {
                    // nodes = nodes.concat(layers);
                    layers.forEach(function (layer) {
                        //
                        if (!_self._isInArray(nodes, layer)) {
                            //
                            nodes.push(layer);
                        }
                    });
                }
                //
                $("#layerCtrlBar").empty();
                $.fn.zTree.init($("#layerCtrlBar"), setting, nodes);
            };
            //
            _self._selectedItems = {};
            /**
             * 当有图层加载到地图中时，刷新图层列表.
             * */
            this.appEvent.addAppEventListener(_LAYER_INTO_MANAGER, function (data) {
                _self._addNewLayers(data.layers);
            });
            /***/
            _self._createLayerItems = function () {
                //
                var ids = _dseMap.graphicsLayerIds;
                var results = [];
                if (ids && ids.length > 0) {
                    //
                    var lc = ids.length;
                    for (var i = 0; i < lc; i++) {
                        //
                        var gl = _dseMap.getLayer(ids[i]);
                        if (gl && gl.visible && gl.isInLayerCtrl) {
                            //
                            var item = {
                                id: gl.id,
                                name: gl.name,
                                checked: gl.visible
                                // url: cfg.url
                            };
                            //
                            results.push(item);
                        }
                    }
                }
                //
                var rc = _self._baseConfig.concat(results);
                return rc;
            };
            //
            /**
             * 响应业务图层变化
             * */
            this.appEvent.addAppEventListener(this.appEvent.MODULE_LAYER_CHANGE, function (data) {
                //
                /**
                 * 刷新图层管理事件
                 * **/
                _self._addNewLayers(data.layers);
            });
            //
            //module layer cache data.
            var layerCacheConfig = {};
            //
            //
            _self.init = function (options) {
                //
                //
            };
            //
            _self._compare = null;
            //
            _self._changeOptionalLayerState = function (cfg, domInfo) {
                var state = domInfo.checked;
                if (cfg) {
                    //
                    var dseLayer = _dseMap.getLayer(cfg.id);
                    cfg.layer = dseLayer;
                    //
                    cfg.visible = dseLayer.visible;
                    //
                    cfg.layerItem = domInfo;
                    //
                    if (cfg.group) {
                        // dispatch group layer state change event.
                        //
                        if (!dseLayer.visible) {
                            dseLayer.show();
                        }
                        _self.appEvent.dispatchAppEvent(_self.appEvent.GROUP_LAYER_CHANGE, cfg);
                    }
                    else {
                        // dispatch single layer state change event.
                        this._changeLayerState(dseLayer, state);
                    }
                    //
                    var share = cfg.legendShare;
                    //
                    if (share) {
                        var groups = lgnData[share.groupId];
                        if (groups && groups.length > 0) {
                            var group = groups[cfg.index];
                            //
                            group.state = state;
                            //控制共享图例的状态.
                            cfg.isShowShareLegend = _self.isShareLegendShow(share.groupId);
                        }
                    }
                    //
                    _self.appEvent.dispatchAppEvent(_self.appEvent.LEGEND_STATE_CHANGE, cfg);
                    _self.appEvent.dispatchAppEvent(_self.appEvent.MODULE_LAYER_CHANGE, cfg);
                }
            };
            //
            var lgnData = {};
            _self._groupLegendData = function (data) {
                //
                var share = data.legendShare;
                //
                if (share) {
                    if (lgnData.hasOwnProperty(share.groupId)) {
                        lgnData[share.groupId].push({
                            state: data.initShow
                        });
                    }
                    else {
                        lgnData[share.groupId] = [{
                                state: data.initShow
                            }];
                    }
                }
            };
            /**获取图例分组.*/
            _self.isShareLegendShow = function (lgnKey) {
                //
                var groups = lgnData[lgnKey];
                var results = false;
                if (groups) {
                    var gc = groups.length;
                    for (var i = 0; i < gc; i++) {
                        //
                        if (groups[i].state) {
                            results = true;
                            break;
                        }
                    }
                }
                return results;
            };
            //
            //创建ArcGIS Layer 图层
            _self._createOptionalLayers = function (layersCfg) {
                //
                if (layersCfg) {
                    layersCfg.forEach(function (cfg) {
                        var layers = cfg.layers;
                        //
                        var group = _self._createLayerGroup(_domNode, cfg);
                        if (layers) {
                            //create group panel.
                            //create layer items.
                            layers.forEach(function (lyrCfg) {
                                //
                                var layer = null;
                                var chk = null;
                                //group layer.
                                if (lyrCfg.group) {
                                    //
                                    layer = _dseMap.getLayer(lyrCfg.shareId);
                                    chk = _self._createSubGroupItem(group, lyrCfg);
                                    //
                                    if (!layer) {
                                        //
                                        lyrCfg.id = lyrCfg.group.shareId;
                                        lyrCfg.groupIds = [lyrCfg.group.groupId];
                                        //
                                        lyrCfg.checkBoxes = [chk];
                                        layer = layerUtils.addLayer(lyrCfg);
                                    }
                                    //
                                    lyrCfg.groupIds.push(lyrCfg.group.groupId);
                                    lyrCfg.checkBoxes.push(chk);
                                    //
                                }
                                else {
                                    //single layer.
                                    layer = layerUtils.addLayer(lyrCfg);
                                    chk = _self._createSubGroupItem(group, lyrCfg);
                                }
                                //
                                if (lyrCfg.legendShare) {
                                    //
                                    _self._groupLegendData(lyrCfg);
                                }
                                // set share legend.
                                if (lyrCfg.initShow) {
                                    lyrCfg.layer = layer;
                                    lyrCfg.layerItem = chk;
                                    // _self._layerCount++;
                                    _self._itemCache[chk.id] = chk.checked;
                                    //
                                    lyrCfg.isCanLoaded = (_self._layerCount <= _self._layerMaxIndex);
                                    _self.appEvent.dispatchAppEvent(_self.appEvent.LEGEND_STATE_CHANGE, lyrCfg);
                                    _self.appEvent.dispatchAppEvent(_self.appEvent.MODULE_LAYER_CHANGE, lyrCfg);
                                    //
                                }
                            });
                        }
                    });
                }
            };
            /**
             *<li class="active">
             <a href="#"> 实时信息 </a>
             <div> ...内容...</div>
             </li>
             *
             * */
            _self._createLayerGroup = function (domNode, cfg) {
                //
                var group = domConstruct.create("li", {}, domNode);
                //
                //
                var ln = domConstruct.create("a", {
                    style: " cursor: pointer;text-decoration: none;",
                    innerHTML: cfg.name
                }, group);
                //
                // expand the layer panel.
                if (cfg.checked) {
                    // only one active.
                    $(domNode).find("li").removeClass("active");
                    $(group).addClass("active");
                }
                on(ln, "click", function (event) {
                    //
                    //
                    // $("#layer-list li").removeClass("active");
                    //
                    $(domNode).find("li").removeClass("active");
                    //
                    if ($(group).hasClass("active")) {
                        //
                        $(group).removeClass("active");
                    }
                    else {
                        $(group).addClass("active");
                    }
                });
                var wrapper = domConstruct.create("div", {
                    //
                    class: "u-lgn-panel u-lgn-panel-default"
                }, group);
                return wrapper;
            };
            //
            _self._itemCache = {};
            //
            _self.isCanLoaded = function (obj) {
                //
                var results = [];
                if (obj) {
                    for (var key in obj) {
                        //
                        results.push(key);
                    }
                }
                //
                return (results.length <= _self._layerMaxIndex);
            };
            /***/
            _self._clearSingleCache = function (items) {
                //
                if (items && items.length > 0) {
                    //
                    items.each(function (iindex, item) {
                        //
                        if (_self._itemCache.hasOwnProperty(item.id)) {
                            delete _self._itemCache[item.id];
                            //
                            console.log("delete item: " + item.id);
                        }
                    });
                }
            };
            /**设置模块UI*/
            _self._changeModuleUIState = function (domNode, layerCfg) {
                //
                if (domNode.checked) {
                    //
                    _self._itemCache[domNode.id] = domNode.checked;
                }
                else {
                    //
                    if (_self._itemCache.hasOwnProperty(domNode.id)) {
                        delete _self._itemCache[domNode.id];
                    }
                }
                //
                layerCfg.isCanLoaded = _self.isCanLoaded(_self._itemCache);
                if (!layerCfg.isCanLoaded) {
                    domNode.checked = false;
                    delete _self._itemCache[domNode.id];
                }
                _self._changeOptionalLayerState(layerCfg, domNode);
                //
                // console.log(JSON.stringify(_self._itemCache));
            };
            /**
             *
             * <div class="checkbox">
             <label><input type="checkbox"> Check me out</label>
             </div>
             *
             * */
            //
            var lastRadio = null;
            _self._createSubGroupItem = function (groupNode, layerCfg) {
                if (layerCfg) {
                    var node = domConstruct.create("div", {}, groupNode);
                    if (layerCfg.isRadioBox) {
                        //
                        $(node).addClass("radio");
                    }
                    else {
                        $(node).addClass("checkbox");
                    }
                    //
                    var lbl = domConstruct.create("label", {}, node);
                    //
                    var ch = null;
                    //
                    var flagId = "chk" + (Math.random() * 10000).toFixed(0);
                    //save config data to cahce.
                    layerCacheConfig[flagId] = layerCfg;
                    if (layerCfg.initShow) {
                        //是否可多选
                        if (layerCfg.isRadioBox) {
                            ch = domConstruct.create("input", {
                                checked: "checked",
                                type: "radio",
                                name: layerCfg.radioName,
                                id: flagId
                            }, lbl);
                        }
                        else {
                            //单选
                            ch = domConstruct.create("input", {
                                checked: "checked",
                                type: "checkbox",
                                id: flagId
                            }, lbl);
                        }
                    }
                    else {
                        if (layerCfg.isRadioBox) {
                            ch = domConstruct.create("input", {
                                type: "radio",
                                id: flagId,
                                name: layerCfg.radioName,
                            }, lbl);
                        }
                        else {
                            ch = domConstruct.create("input", {
                                type: "checkbox",
                                id: flagId
                            }, lbl);
                        }
                    }
                    //
                    $(lbl).append(layerCfg.name);
                    on(ch, "click", function (event) {
                        //
                        //
                        if (this.type === "radio") {
                            //只能单选的图层.
                            var group = layerCfg.radioName;
                            //
                            var items = $("input[name=" + group + "]");
                            //
                            _self._clearSingleCache(items);
                            //
                            items.each(function (iindex, item) {
                                //
                                var cfg = layerCacheConfig[item.id];
                                //可以多选的图层.
                                _self._changeModuleUIState(item, cfg);
                            });
                        }
                        else {
                            //可以多选的图层.
                            _self._changeModuleUIState(this, layerCfg);
                        }
                    });
                }
                //
                return ch;
            };
            //
            if (_layers && _layers.length > 0) {
                //
                this._createOptionalLayers(_layers);
            }
        },
        /**change layer state.*/
        _changeLayerState: function (dseLayer, state) {
            //
            if (dseLayer) {
                //
                if (state) {
                    dseLayer.show();
                }
                else {
                    dseLayer.hide();
                }
            }
        },
        //
        resize: function (width, height) {
            //
            $("#layerCtrlBar").css({
                width: width + "px",
                height: height + "px"
            });
        }
    });
});
//# sourceMappingURL=LayerAccMan.js.map