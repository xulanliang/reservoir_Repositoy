/**
 * Created by Administrator on 2016/8/18.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../utils/BaseMapUtils",
    "dojo/_base/lang",
    "esri/domUtils",
    "dojo/dom-style",
    "dojo/sniff",
    "esri/layers/TiledMapServiceLayer"
], function (declare, _BaseTool, BaseMapUtils, lang, domUtils, domStyle, sniff, TiledMapServiceLayer) {
    //
    //
    var _map = null;
    //
    var ecLayer = null;
    //
    var handlers = [];
    //
    var config = null;
    var layerUtils = null;
    //
    var mySelf = null;
    return declare([_BaseTool], {
        //
        constructor: function (map) {
            _map = map;
            //
            mySelf = this;
            config = this.configData;
            //
            layerUtils = new BaseMapUtils(_map);
            //
            layerUtils.loadBaseLayers([config.mapSwipe]);
        },
        /**
         * 激活工具
         * */
        activate: function () {
            ///
            if (this.isActive) {
                //
                this._removeEventListeners();
            }
            ecLayer = _map.getLayer(config.mapSwipe.id);
            //浏览器支持则显示.
            if (this._getSupportBrowser()) {
                //
                this._addEventListeners();
            }
            else {
                //
                alert("您的浏览器不支持" + this.config.name + "功能！");
            }
            this.isActive = true;
        },
        isActive: false,
        /**
         * 释放工具
         * */
        deactivate: function () {
            //
            this._removeEventListeners();
            this.isActive = false;
            this._hideSwipeLayer();
        },
        //
        layerNode: null,
        _isPan: false,
        _addEventListeners: function () {
            //
            var handler1 = _map.on("mouse-down", lang.hitch(this, function (event) {
                //
                this._showSwipeLayer();
                var point = event.screenPoint;
                //
                this.layerNode = document.getElementById("map_" + config.mapSwipe.id);
                //
                //获取左上角坐标点
                var origin = this._getBaseLayerTransform();
                //
                var cx = origin.x < 0 ? parseFloat(point.x) + 100 - origin.x : parseFloat(point.x) + 100;
                var cy = origin.y < 0 ? parseFloat(point.y) + 100 - origin.y : parseFloat(point.y) + 100;
                //
                cx = Math.abs(cx);
                cy = Math.abs(cy);
                //
                domStyle.set(ecLayer.getNode(), {
                    //
                    "-webkit-clip-path": "circle(200px at " + cx + "px " + cy + "px)",
                    "clip-path": "circle(200px at " + cx + "px " + cy + "px)"
                });
                //
            }));
            //
            var handler2 = _map.on("mouse-up", lang.hitch(this, function (event) {
                //
                this._hideSwipeLayer();
                //
            }));
            //
            var handler3 = _map.on("pan-start", lang.hitch(this, function (event) {
                //
                this._hideSwipeLayer();
            }));
            handlers = [handler1, handler2, handler3];
        },
        _removeEventListeners: function () {
            //
            handlers.forEach(function (handler) {
                //
                handler.remove();
            });
        },
        _hideSwipeLayer: function () {
            //
            ecLayer && ecLayer.hide();
        },
        _showSwipeLayer: function () {
            //
            ecLayer && ecLayer.show();
        },
        //
        _getSupportBrowser: function () {
            //
            var result = false;
            if (sniff("opera") || sniff("chrome")) {
                //
                result = true;
            }
            //
            return result;
        },
        /**
         * 获取图层右上角的坐标
         * */
        _getLayerTransform: function (layerNode) {
            var ox, oy, layerStyle = layerNode.style;
            //chrome
            if (layerStyle['-webkit-transform']) {
                //格式为"translate(0px, 0px)"
                var s = layerStyle['-webkit-transform'];
                var xyArray = s.replace(/translate\(|px|\s|\)/, '').split(',');
                ox = parseInt(xyArray[0]);
                oy = parseInt(xyArray[1]);
            }
            else if (layerStyle['transform']) {
                var layerTrans = layerStyle['transform'];
                var xyz = layerTrans.replace(/px|\s|translate3d\(|px|\)/g, '').split(',');
                ox = parseInt(xyz[0]);
                oy = parseInt(xyz[1]);
            }
            else {
                ox = parseInt(layerNode.style.left.replace('px', ''));
                oy = parseInt(layerNode.style.top.replace('px', ''));
            }
            return {
                x: ox,
                y: oy
            };
        },
        /**
         * 获取底图坐标点平移量.
         * */
        _getBaseLayerTransform: function () {
            //
            var ids = _map.layerIds;
            var count = ids.length;
            //
            var origin = {
                x: NaN,
                y: NaN
            };
            for (var i = 0; i < count; i++) {
                //
                var lyr = _map.getLayer(ids[i]);
                //
                if (lyr instanceof TiledMapServiceLayer && lyr.visible) {
                    //
                    var node = lyr.getNode();
                    //
                    origin = this._getLayerTransform(node);
                    break;
                }
            }
            //
            return origin;
        }
    });
    //
});
//# sourceMappingURL=SwipeTool.js.map