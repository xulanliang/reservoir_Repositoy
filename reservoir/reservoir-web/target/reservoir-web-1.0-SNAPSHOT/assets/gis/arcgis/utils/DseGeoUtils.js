/**
 * Created by Administrator on 2016/8/3.
 */
define([
    "dojo/_base/declare",
    "esri/toolbars/edit",
    "esri/geometry/geometryEngine",
    "esri/layers/FeatureLayer",
    "esri/units",
    "dojo/_base/lang",
    "dojo/on",
    "dojo/dom",
    "dojo/_base/event",
    "esri/toolbars/draw",
    "./BaseMapUtils",
    "./dseSymbolUtils",
    "esri/graphic",
    "./dseGisUtils",
    "./PopupUtils",
    "dojo/request/xhr",
    "esri/geometry/Point"
], function (declare, Editor, geometryEngine, FeatureLayer, units, lang, on, dom, eventTool, DrawTool, BaseMapUtils, dseSymbolUtils, Graphic, dseGisUtils, PopupUtils, xhr, Point) {
    //
    var _map = null;
    //
    var editor = null;
    //
    var featureLayer = null;
    //
    var editLayer = null;
    //
    var handlers = [];
    //
    var mySelf = null;
    //
    var editType = ""; //
    var editGra = null;
    //
    var drawTool = null;
    //
    var _isSingle = false;
    //
    var popupUtils = null;
    //
    var GeoType = {
        //
        point: "point",
        line: "polyline",
        polygon: "polygon"
    };
    //
    var appEvent = null;
    //
    //
    var attributes = {};
    //
    return declare(null, {
        //
        constructor: function (options) {
            //options:
            //
            lang.mixin(this, options);
            _map = options.map;
            editor = new Editor(_map);
            //
            editLayer = this.editLayer;
            //
            //
            //
            popupUtils = new PopupUtils(_map, options.template);
            mySelf = this;
            //
            if (options.url) {
                //用于保存编辑后的图形
                featureLayer = new FeatureLayer(options.url);
            }
            appEvent = window.appEvent;
            //
            appEvent.addAppEventListener(appEvent.BASE_MAP_LAYER_LOADED, lang.hitch(this, this._baseMapLayerLoaded));
            //
            //
            appEvent.addAppEventListener(appEvent.DEACTIVATE_EDITOR, function (data) {
                //
                mySelf.deactivate();
            });
            //
            appEvent.addAppEventListener(appEvent.SAVE_EDIT_GRAPHIC, function (data) {
                //
                editGra = data;
            });
        },
        //
        _baseMapLayerLoaded: function (data) {
            //默认内置GraphicsLayer,可以在地图中绘制图形，然后再执行编辑.
            var layerUtils = new BaseMapUtils(_map);
            this.defaultLayer = layerUtils.addLayer({
                id: "edit_g_layer",
                type: "graphic",
                visible: true
            });
            //
            editLayer = this.defaultLayer;
            drawTool = new DrawTool(_map);
            // bind events.
            this._addEventListeners();
        },
        //
        /**
         * ================================================================================================
         * 绑定事件处理器.
         * ================================================================================================
         * */
        _layerClickHandler: function (event) {
            //
            var gra = event.graphic;
            this._editGraphic(gra, editType);
            //
            // popupUtils.showInfoWindow(gra);
        },
        //
        _isPopupShow: false,
        //
        _graphicMoveEndHandler: function (event) {
            //
            editGra = event.graphic;
            //
            if (!this._isPopupShow) {
                popupUtils.showInfoWindow(editGra);
                this._isPopupShow = true;
            }
        },
        //
        _graphicMoveStartHandler: function (event) {
            //
            editGra = event.graphic;
            _map.infoWindow.hide();
            this._isPopupShow = false;
        },
        //
        _graDeactivateHandler: function (event) {
            //
            editor.deactivate();
            editGra = event.graphic;
            //
            //
            if (!this._isPopupShow) {
                popupUtils.showInfoWindow(editGra);
                this._isPopupShow = true;
            }
            // popupUtils.showInfoWindow(editGra);
        },
        //
        _editGraphic: function (graphic, type) {
            //
            if (type === "move") {
                //
                this._moveGra(graphic);
            }
            else if (type === "edit") {
                //
                if (graphic.geometry.type === GeoType.point) {
                    //
                    this._moveGra(graphic);
                }
                else {
                    //
                    this._editGra(graphic);
                }
            }
        },
        //
        _removeEventListeners: function () {
            //
            handlers.forEach(function (handler) {
                //
                handler.remove();
            });
            //
            handlers = [];
        },
        //
        _addEventListeners: function () {
            //
            if (editLayer) {
                //
                var handler1 = editLayer.on("click", lang.hitch(this, this._layerClickHandler));
                //
                handlers.push(handler1);
            }
            //
            if (drawTool) {
                //
                var handler2 = drawTool.on("draw-complete", lang.hitch(this, this._drawGeometryCompletedHandler));
                //
                handlers.push(handler2);
            }
            var handler3 = editor.on("graphic-move-stop", lang.hitch(this, this._graphicMoveEndHandler));
            //
            var handler4 = editor.on("deactivate", lang.hitch(this, this._graDeactivateHandler));
            //
            var handler5 = editor.on("graphic-move-start", lang.hitch(this, this._graphicMoveStartHandler));
            //
            var handler6 = editor.on("vertex-move-stop", lang.hitch(this, this._graphicMoveStartHandler));
            //
            var handler7 = editor.on("vertex-add", lang.hitch(this, this._graphicMoveStartHandler));
            //
            var handler8 = editor.on("activate", lang.hitch(this, this._graphicMoveEndHandler));
            //
            handlers.concat([handler3, handler4, handler5, handler6, handler7, handler8]);
        },
        _callback: null,
        //
        _drawGeometryCompletedHandler: function (event) {
            //
            if (_isSingle) {
                //
                drawTool.deactivate();
            }
            var geometry = event.geometry;
            //
            var sym = null; //this._getSymbol(geometry.type);
            //
            if (typeof editLayer.symbolCallBack === "function") {
                //
                sym = editLayer.symbolCallBack(attributes, geometry.type);
            }
            else {
                sym = this._getSymbol(geometry.type);
            }
            //
            //
            var gra = new Graphic(geometry, sym, attributes);
            //
            gra.data = attributes;
            //
            editLayer.add(gra);
            editGra = gra;
            //
            //
            if (this.isArrow) {
                //
                var paths = geometry.paths;
                var points = paths[0];
                //
                var itemCount = points.length - 1;
                var itemIndex = 0;
                //
                for (var itemIndex = 0; itemIndex < itemCount; itemIndex++) {
                    //
                    var info1 = points[itemIndex];
                    var info2 = points[itemIndex + 1];
                    //
                    //
                    //
                    var startPoint = new Point(info1[0], info1[1], _map.spatialReference);
                    //
                    var endPoint = new Point(info2[0], info2[1], _map.spatialReference);
                    var angle = this._getLineAngle(startPoint, endPoint);
                    var arrowSym = dseSymbolUtils.createSimpleArrowSymbol(sym.color, angle);
                    //
                    var arrow = new Graphic(endPoint, arrowSym);
                    //
                    editLayer.add(arrow);
                }
                //
                /*var angle = this._getLineAngle(startPoint, endPoint);
                 var arrowSym = dseSymbolUtils.createSimpleArrowSymbol(sym.color, angle);
                 //
                 var arrow = new Graphic(endPoint, arrowSym);
                 //
                 editLayer.add(arrow);*/
            }
            if (this._callback && typeof this._callback === "function") {
                this._callback(gra);
            }
        },
        //
        _getSymbol: function (geometryType) {
            //
            var sym = null;
            if (geometryType === GeoType.point) {
                //
                sym = this.markerSymbol || dseSymbolUtils.createSimpleMakerSymbol({});
                //
            }
            else if (geometryType === GeoType.line) {
                //
                sym = this.lineSymbol || dseSymbolUtils.createSimpleLineSymbol({});
            }
            else if (geometryType === GeoType.polygon) {
                //
                //
                sym = this.fillSymbol || dseSymbolUtils.createSimpleFillSymbol({});
            }
            else {
                //
            }
            //
            return sym;
        },
        // get line angle.
        _getLineAngle: function (starts, ends) {
            // 计算两点之间的方位角.
            var angle = 0;
            var sp = _map.toScreen(starts);
            var ep = _map.toScreen(ends);
            angle = Math.atan2((ep.y - sp.y), (ep.x - sp.x)) * 180 / Math.PI;
            //
            return angle;
        },
        /**
         * 移动几何图形
         * */
        _moveGra: function (graphic) {
            //
            editor.activate(Editor.MOVE, graphic, {
                //
                allowAddVertices: false,
                allowDeleteVertices: false
            });
            //
        },
        _editGra: function (graphic) {
            //
            editor.activate(Editor.EDIT_VERTICES, graphic, {
                allowAddVertices: true,
                allowDeleteVertices: true
            });
        },
        /**
         * ================================================================================================
         * 定义公用方法.
         * ================================================================================================
         * */
        /**
         * 设置可编辑图层.
         * */
        changeEditLayer: function (layer) {
            this._removeEventListeners();
            editLayer = layer;
            //
            this._addEventListeners();
        },
        isActive: false,
        isArrow: false,
        /**
         * 切换编辑类型. type 取值为 move 或者 edit
         * */
        changeEditType: function (type) {
            //
            if (!this.isActive) {
                //
                this.isActive = true;
                this._addEventListeners();
            }
            editType = type;
            //
        },
        /**
         * @param type 绘制的几何图形类型,取值为: point||polyline||polygon.
         * @return void  可以调用this.getGraphic() 获取绘制的几何图形。
         * */
        drawGraphic: function (type, isSingle, cb) {
            //
            this.changeEditLayer(editLayer);
            _isSingle = isSingle;
            if (type === GeoType.point) {
                //
                drawTool.activate(DrawTool.POINT);
            }
            else if (type === GeoType.line) {
                //
                drawTool.activate(DrawTool.POLYLINE);
            }
            else if (type === GeoType.polygon) {
                //
                drawTool.activate(DrawTool.POLYGON);
            }
            //
            this._callback = cb;
        },
        /**
         * 释放工具
         * */
        deactivate: function () {
            //
            editor.deactivate();
            //
            drawTool.deactivate();
            //
            handlers.forEach(function (handler) {
                //
                handler.remove();
            });
            //
            this.isActive = false;
            //
        },
        /**
         * 设置几何图形属性编辑模板信息
         * */
        setGeoTemplate: function (options) {
            //
            popupUtils.setTemplate(options);
        },
        /**
         * 设置新建几何图形属性信息。
         * */
        //
        setGeoAttribute: function (options) {
            //
            attributes = options;
        },
        /**
         * ================================================================================================
         * 几何图形操作
         * ================================================================================================
         * */
        /**
         * 创建缓冲区
         * */
        buffer: function (geometry, distance) {
            //
            return geometryEngine.buffer(geometry, distance, units.METERS, false);
        },
        /**
         * 裁剪几何图形
         * */
        clip: function (geometry, env) {
            //
            //
            return geometryEngine.clip(geometry, env);
        },
        //
        /**
         * @param geometry typeis {esri/geometry/Polygon or esri/geometry/Polyline}
         * @param line type is {esri/geometry/Polyline}
         * @return Geometry[]
         * */
        cut: function (geometry, line) {
            //
            return geometryEngine.cut(geometry, line);
        },
        /**
         * 合并几何对象.
         * */
        union: function (geometries) {
            //
            //
            return geometryEngine.union(geometries);
        },
        /**
         * 获取编辑后的Graphic.
         * */
        getGraphic: function () {
            //
            return editGra;
        },
    });
});
//# sourceMappingURL=DseGeoUtils.js.map