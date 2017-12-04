/**
 * 图层管理控件,主要用于实现地图中的图层显示与隐藏操作。
 *
 * 依赖:
 *
 */
define(["dojo/_base/declare", "dojo/dom", "dojo/on",
    "./_BaseWidget", "dojo/_base/array", "dojo/dom-construct", "dojo/dom-style", "dojo/string", "dojo/_base/lang"
], function (declare, dom, on, _BaseWidget, arrayUtils, domConstruct, domStyle, string, lang) {
    return declare([_BaseWidget], {
        //
        constructor: function (options) {
            //
            this.__init(options);
        },
        //
        __init: function (options) {
            //
            //
            var _dseMap = options.map;
            var _layers = options.layers || [];
            var _domNode = dom.byId(_dseMap.id);
            //
            var _self = this;
            //
            var layerUtils = options.util;
            //
            var zTreeNodes = [];
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
            /**
             * 当有图层加载到地图中时，刷新图层列表.
             * */
            this.appEvent.addAppEventListener(_LAYER_INTO_MANAGER, function (data) {
                /**
                 * 去掉图层分组
                 * **/
                /*if (data.group) {
                 //
                 var ctn = _self._queryLayerGroupBy(data.group);
                 //
                 var items = ctn.children || [];
                 //
                 // items.push(data);
                 items.push({
                 name: data.name,
                 id: data.id,
                 checked: data.initShow,
                 open: data.initShow
                 });
                 } else {
                 //
                 var newGroup = {
                 //
                 name: data.name,
                 checked: data.initShow,
                 open: data.initShow,
                 children: [data]
                 };
                 //

                 //
                 zTreeNodes.push(newGroup);
                 }*/
                /**
                 * 刷新图层管理事件
                 * **/
                _self._addNewLayers(data.layers);
            });
            /**
             * 是否将新添加的图层添加到图层管理中.
             * */
            this.map.on("layer-add", function (event) {
                //
                var lyr = event.layer;
                //
                //添加到图层管理.
                if (lyr.isInLayerCtrl && lyr.visible) {
                    _self.appEvent.dispatchAppEvent(_LAYER_INTO_MANAGER, {
                        //
                        layers: [
                            {
                                id: lyr.id,
                                name: lyr.name,
                                checked: lyr.visible,
                            }
                        ]
                    });
                }
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
            //
            _self.init = function (options) {
                //
                //
                var ctn = domConstruct.create("div", {
                    class: "panel panel-default u-layer-ctrl-bar"
                }, _domNode);
                //
                var ztree = domConstruct.create("div", {
                    class: "ztree",
                    id: "layerCtrlBar"
                }, ctn);
                //
                //
                setting = {
                    //是否显示节点间的连线
                    showLine: false,
                    //每个节点上是否显示 CheckBox
                    check: {
                        enable: true,
                        chkStyle: "checkbox"
                    },
                    edit: {
                        showRemoveBtn: true,
                        drag: {
                            isMove: true
                        }
                    },
                    //回调check事件
                    callback: {
                        onCheck: this._treeOnCheckHandler
                    }
                };
                //
                var $node = $("#layerCtrlBar");
                $.fn.zTree.init($node, setting, zTreeNodes);
            };
            //
            /**
             * 根据名称查找图层组.
             * */
            _self._queryLayerGroupBy = function (groupName) {
                var results = zTreeNodes.filter(function (treeNode) {
                    //
                    return treeNode.name === groupName;
                });
                //
                return results[0];
            };
            //
            //
            _self._treeOnCheckHandler = function (event, treeId, treeNode) {
                //
                if (treeNode.checked) {
                    //
                    _self._changeOptionalLayerState(treeNode, true);
                }
                else {
                    //
                    _self._changeOptionalLayerState(treeNode, false);
                }
            };
            //
            //
            _self._changeOptionalLayerState = function (cfg, state) {
                //
                var layers = cfg.children;
                //
                var dseLayer = null;
                if (layers) {
                    //
                    layers.forEach(function (lyr) {
                        //
                        dseLayer = _dseMap.getLayer(lyr.id);
                        _self._changeLayerState(dseLayer, state);
                    });
                }
                else {
                    //
                    dseLayer = _dseMap.getLayer(cfg.id);
                    this._changeLayerState(dseLayer, state);
                }
            };
            //
            //创建ArcGIS Layer 图层
            _self._createOptionalLayers = function (layersCfg) {
                //
                if (layersCfg) {
                    layersCfg.forEach(function (cfg) {
                        var nodeInfo = {
                            // id:"oo",
                            name: cfg.name,
                            // type:"yq",
                            open: true,
                            checked: cfg.checked
                        };
                        var layers = cfg.layers;
                        if (layers) {
                            //
                            layers.forEach(function (lyrCfg) {
                                //
                                layerUtils.addLayer(lyrCfg);
                                var node = _self._addTreeNodeItem(lyrCfg);
                                //
                                zTreeNodes.push(node);
                            });
                        }
                    });
                }
            };
            //
            if (_layers) {
                //
                this._createOptionalLayers(_layers);
            }
        },
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
                this.appEvent.dispatchAppEvent(this.appEvent.LEGEND_STATE_CHANGE, {
                    //图例类型.
                    type: dseLayer.legendType,
                    //图层对象
                    layer: dseLayer,
                    //图层是否可见
                    visible: state,
                    id: dseLayer.id,
                    isStateChanged: true
                });
            }
            //
            // this.appEvent.dispatchAppEvent(this.appEvent.LEGEND_STATE_CHANGE, {
            //     //图例类型.
            //     type: dseLayer.legendType,
            //     //图层对象
            //     layer: dseLayer,
            //     //图层是否可见
            //     visible: state,
            //     id: dseLayer.id,
            //     isStateChanged: true
            // });
        },
        /**
         * 创建目录节点项
         * */
        _addTreeNodeItem: function (cfg) {
            //
            var item = {
                id: cfg.id,
                name: cfg.name,
                checked: cfg.initShow
                // url: cfg.url
            };
            //
            return item;
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
//# sourceMappingURL=LayerManControl.js.map