/**
 * 图层管理控件,主要用于实现地图中的图层显示与隐藏操作。
 *
 * 依赖:
 *
 */
define(["dojo/_base/declare", "dojo/dom", "dojo/on",
    "./_BaseWidget", "dojo/_base/array", "dojo/dom-construct", "dojo/dom-style", "dojo/string"
], function (declare, dom, on, _BaseWidget, arrayUtils, domConstruct, domStyle, string) {
    //
    //
    var _dseMap = null;
    var _layers = null;
    var _domNode = null;
    //
    var _treeNodes = null;
    var _self = null;
    //
    var layerUtils = null;
    //
    var zTreeNodes = [];

    var setting = null;
    //

    return declare([_BaseWidget], {
        //
        constructor: function (options) {
            //
            _dseMap = options.map;
            _layers = options.layers || [];
            _treeNodes = [];
            _domNode = dom.byId(_dseMap.id);
            _self = this;
            //
            layerUtils = options.util;
            //
            if (_layers) {
                //
                this._createOptionalLayers(_layers);
            }
            /**
             * 当有图层加载到地图中时，刷新图层列表.
             * */
            this.appEvent.addAppEventListener(this.appEvent.LAYER_INTO_MANAGER, function (data) {
                //
                if (data.group) {
                    //
                    var ctn = _self._queryLayerGroupBy(data.group);
                    //
                    var items = ctn.children || [];
                    //
                    // items.push(data);
                    items.push({
                        name:data.name,
                        id:data.id,
                        checked:data.initShow,
                        open:data.initShow
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
                    zTreeNodes.push(newGroup);
                }
                $.fn.zTree.init($("#layerCtrlBar"), setting, zTreeNodes);
            });
            /**
             * 是否将新添加的图层添加到图层管理中.
             * */

            this.map.on("layer-add", function (event) {
                //
                var lyr = event.layer;
                //
                //添加到图层管理.
                if (lyr.isInLayerCtrl) {
                    _self.appEvent.dispatchAppEvent(_self.appEvent.LAYER_INTO_MANAGER, {
                        //
                        id: lyr.id,
                        name: lyr.name,
                        initShow: lyr.visible,
                        group: "临时分组"
                    });
                }
            });
        },
        /**
         * 根据名称查找图层组.
         * */
        _queryLayerGroupBy: function (groupName) {
            var results = zTreeNodes.filter(function (treeNode) {
                //
                return treeNode.name === groupName;
            });
            //
            return results[0];
        },
        init: function (options) {
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
        },
        //
        _treeOnCheckHandler: function (event, treeId, treeNode) {
            //
            if (treeNode.checked) {
                //
                _self._changeOptionalLayerState(treeNode, true);

            } else {
                //
                _self._changeOptionalLayerState(treeNode, false);
            }
        },
        //
        _changeOptionalLayerState: function (cfg, state) {
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
            } else {
                //
                dseLayer = _dseMap.getLayer(cfg.id);
                this._changeLayerState(dseLayer, state);
            }
        },

        _changeLayerState: function (dseLayer, state) {
            //
            if (dseLayer) {
                //
                if (state) {
                    dseLayer.show();
                } else {
                    dseLayer.hide();
                }
            }
            //
            this.appEvent.dispatchAppEvent(this.appEvent.LAYER_STATE_CHANGE, {
                //图例类型.
                type: dseLayer.legendType,
                //图层对象
                layer: dseLayer,
                //图层是否可见
                visible: state
            });
        },

        //创建ArcGIS Layer 图层
        _createOptionalLayers: function (layersCfg) {
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
                    var subs = [];
                    var layers = cfg.layers;
                    if (layers) {
                        //
                        layers.forEach(function (lyrCfg) {
                            //
                            layerUtils.addLayer(lyrCfg);
                            var node = _self._addTreeNodeItem(lyrCfg);
                            //
                            subs.push(node);
                        });
                        //
                        //
                        if (layers.length > 0) {
                            //
                            nodeInfo.children = subs;
                            zTreeNodes.push(nodeInfo);
                        }
                    }
                });
            }
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
            // _treeNodes.push(item);
            //
        }
    });
});
