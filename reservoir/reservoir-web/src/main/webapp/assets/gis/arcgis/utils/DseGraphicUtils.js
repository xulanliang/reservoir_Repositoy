/**
 * Created by Administrator on 2016/7/25.
 */
define([
    "dojo/_base/declare",
    "esri/geometry/Polygon",
    "esri/geometry/Point",
    "esri/geometry/Polyline",
    "esri/SpatialReference",
    "./dseSymbolUtils",
    "./dseGisUtils",
    "esri/graphic",
    "esri/symbols/jsonUtils",
    "esri/geometry/jsonUtils",
    "esri/InfoTemplate",
    "dojo/json"
], function (declare, Polygon, Point, Polyline, SpatialReference, dseSymbolUtils, dseGisUtils, Graphic, symbolJsonUtils, geometryJsonUtils, InfoTemplate, JSON) {
    //
    //
    //
    return declare(null, {
        //
        constructor: function (options) {
            //
            this.__init(options);
        },
        __init: function (options) {
            var self = this;
            var _map = options.map;
            this.mapType = options.mapType;
            self._map = _map;
            //
            /**
             *<strong>主要考虑广州水资源项目兼容.</strong>
             *
             * 创建点公共方法(data属性：Object，经度(lgtd),纬度(lttd),
             * 要素风格图片路径(imgpath), 宽度（imgwidth),高度(imgheigth))
             * @return Graphic
             **/
            self.createPoint = function (data, lgtd, lttd, imgpath, imgwidth, imgheigth) {
                var dqzb = dseGisUtils.WgsToDqzb(lgtd, lttd, this.mapType); //经纬度转换成当前投影下的坐标，gis_Datacommon
                var p = new Point(dqzb[0], dqzb[1], _map.spatialReference);
                var symPoint = dseSymbolUtils.PMS(imgpath, imgwidth, imgheigth);
                var graphic = new Graphic(p, symPoint, data);
                graphic.data = data;
                return graphic;
            };
            //
            /**
             * 创建点公共方法(data属性：Object，经度(lgtd),纬度(lttd),
             *
             * @param symbol graphic 的符号信息.
             * @return Graphic
             **/
            self.createPoint2 = function (data, lgtd, lttd, symbol) {
                //
                var dqzb = dseGisUtils.WgsToDqzb(lgtd, lttd, this.mapType); //经纬度转换成当前投影下的坐标，gis_Datacommon
                var p = new Point(dqzb[0], dqzb[1], _map.spatialReference);
                var graphic = new Graphic(p, symbol, data);
                graphic.data = data;
                return graphic;
            };
            self.createPointGra = function (data, lgtd, lttd, symbol) {
                //

                var p = new Point(lgtd, lttd, _map.spatialReference);
                var graphic = new Graphic(p, symbol, data);
                graphic.data = data;
                return graphic;
            };
            /**
             * 创建线图形，不执行坐标转换.
             * */
            self.createPolylineGra = function (geojson, symbol, attributes, infoTemplate) {
                //
                var json = $.isArray(geojson) ? geojson : JSON.parse(geojson);
                var polyline = new Polyline(_map.spatialReference);
                json.forEach(function (path) {
                    polyline.addPath(path);
                });
                return new Graphic(polyline, symbol, attributes, infoTemplate);
            };
        },
        /**
         * 创建线公共方法，参数说明：（data属性:Object,坐标集xy:String,
         * 线风格(Ltype)：数值类型,颜色rgb数组(Colors)如：[255,255,255]，线宽(width):数值类型）
         * 线风格包含的值：STYLE_DASH:1    实-虚线；STYLE_DASHDOT:2 实-点-虚线；STYLE_DASHDOTDOT:3 实-点-点-虚线；STYLE_DOT 点-虚线:4
         * STYLE_LONGDASH:5    长实-虚；STYLE_LONGDASHDOT:6    长实-点-虚；STYLE_NULL:7    空样式；STYLE_SHORTDASH:8    长实-虚（间隔小）
         * STYLE_SHORTDASHDOT:9    长实-点-虚（间隔小）；STYLE_SHORTDASHDOTDOT:10    长实-点-虚（间隔小）；STYLE_SHORTDOT:11    点-虚（间隔小）；STYLE_SOLID:12 实线
         * @return Graphic
         *
         **/
        createPolyline: function (data, xy, Ltype, Colors, width) {
            var pl = new Polyline(dseGisUtils.getLineDate(xy, this.mapType));
            //
            pl.spatialReference = this._map.spatialReference;
            var lineSymbol = dseSymbolUtils.SLineSymbol(Ltype, Colors, width);
            var graphic = new Graphic(pl, lineSymbol, data);
            graphic.data = data;
            return graphic;
        },
        /**
         * 创建面公共方法(属性，坐标集合，符号,
         * 面填充风格(目前常用的为1，实体填充)：数值类型,颜色rgb+透明度 数组如：[255,255,255,0.5]
         * 边框线风格(Ltype)：数值类型,边框线颜色rgb数组(Colors)如：[255,255,255]，边框线宽(width):数值类型）
         * @return Graphic
         *
         */
        createPolygon: function (data, xy, Ptype, PColors, Ltype, Colors, width) {
            var gl = new Polygon(dseGisUtils.getLineDate(xy, this.mapType));
            gl.spatialReference = this._map.spatialReference;
            var lineSymbol = dseSymbolUtils.SLineSymbol(Ltype, Colors, width);
            var fillSymbol = dseSymbolUtils.SFillSymbol(Ptype, lineSymbol, PColors);
            var graphic = new Graphic(gl, fillSymbol, data);
            graphic.data = data;
            return graphic;
        },
        /**
         *从JSON创建Graphic.
         * */
        createGraFromJson: function (grajson) {
            //
            var newGra = null;
            //
            if (grajson) {
                //
                var gra = JSON.parse(grajson);
                //
                var geo = geometryJsonUtils.fromJson(gra.geometry);
                var sym = symbolJsonUtils.fromJson(gra.symbol);
                //
                var attributes = gra.attributes;
                var info = new InfoTemplate(gra.infoTemplate);
                //
                newGra = new Graphic(geo, sym, attributes, info);
            }
            //
            return newGra;
        },
        /**copy graphics*/
        copyGraphic: function (gra) {
            //
            return new Graphic(gra.geometry, gra.symbol, gra.attributes, gra.infoTemplate);
        }
    });
});
//# sourceMappingURL=DseGraphicUtils.js.map