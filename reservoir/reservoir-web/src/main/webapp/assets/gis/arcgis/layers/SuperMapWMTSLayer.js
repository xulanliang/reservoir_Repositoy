/**
 * Created by Administrator on 2016/12/29.
 */
define(["dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/_base/array",
    "dojox/xml/parser",
    "esri/layers/TiledMapServiceLayer",
    "esri/geometry/Extent",
    "esri/layers/TileInfo",
    "esri/SpatialReference",
], function (declare, lang, arrayUtils, parser, TiledMapServiceLayer, Extent, TileInfo, SpatialReference) {
    //
    //
    var layerDpi = 0;
    return declare([TiledMapServiceLayer], {
        //
        constructor: function (url, options) {
            //
            lang.mixin(this, options);
            this.tileUrl = url;
            this.spatialReference = new SpatialReference({ wkid: options.wkid });
            this.initialExtent = this.fullExtent = this._createExtent(options.extent);
            //
            layerDpi = this.dpi || 96;
            var tiles = this._createLayerTileLOD(options.scales, options.startIndex);
            //
            this.tileInfo = new TileInfo({
                dpi: layerDpi,
                rows: 256,
                cols: 256,
                compressionQuality: 0,
                origin: {
                    x: -180,
                    y: 90
                },
                spatialReference: {
                    wkid: options.wkid
                },
                lods: tiles
            });
            this.loaded = true;
            //
            this.opts = options;
            this.onLoad(this);
        },
        //
        getTileUrl: function (level, row, col) {
            //
            //
            var fullUrl = "";
            if (this.serviceMode === "RESTful") {
                // http://10.100.9.52:8090/iserver/services/map-world/wmts-china/World/default/ChinaPublicServices_World/{TileMatrix}/{TileRow}/{TileCol}.png
                //
                fullUrl = this.tileUrl + "/" + this.identifier + "/" + this.style + "/" + this.tileMatrixSet + "/" + level + "/" + row + "/" + col + ".png";
            }
            else {
                /**
                 * http://localhost:8090/iserver/services/map-world/wmts100?
                 * SERVICE=WMTS&REQUEST=GetTile&
                 * VERSION=1.0.0&
                 * LAYER=World&
                 * STYLE=default&
                 * TILEMATRIXSET=GlobalCRS84Scale_World&
                 * TILEMATRIX=4&
                 * TILEROW=3&
                 * TILECOL=12&
                 * FORMAT=image/png
                 * */
                fullUrl = this.tileUrl + "?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=" + this.identifier + "&STYLE="
                    + this.style + "&TILEMATRIXSET=" + this.tileMatrixSet + "&TILEMATRIX=" + level + "&TILEROW=" + row +
                    "&TILECOL=" + col + "&FORMAT=" + this.format;
            }
            return fullUrl;
        },
        //
        _createLayerTileLOD: function (scales, startIndex) {
            //
            var tiles = [];
            //
            var type = this.resolutionKey; //this.tileMatrixSet.split("_")[0];
            var resolutions = this._getLayerResolutions(type);
            //
            var self = this;
            scales.forEach(function (d, iindex) {
                //
                var res = d * 0.0254000508 / layerDpi / 111194.872221777;
                tiles.push({
                    level: startIndex + iindex,
                    resolution: resolutions[iindex],
                    scale: d
                });
            });
            //
            return tiles;
        },
        //
        _createExtent: function (ins) {
            //
            if (ins && ins.length === 4) {
                //
                return new Extent(ins[0], ins[1], ins[2], ins[3], this.spatialReference);
            }
            else {
                return null;
            }
        },
        /**获取图层分辨率集合*/
        _getLayerResolutions: function (type) {
            /**
             * 设置此属性，否则在出图时可能会出现地图偏差等问题。 用户自定义缩放级别时须同时设置resolutions和matrixIds信息，并保证两者信息一一对应。
             * 各个标准比例尺集对应的分辨率数组如下
             * */
            var resolutions = [];
            if (type === "GlobalCRS84Scale") {
                resolutions = [1.25764139776733, 0.628820698883665, 0.251528279553466,
                    0.125764139776733, 0.0628820698883665, 0.0251528279553466, 0.0125764139776733, 0.00628820698883665,
                    0.00251528279553466, 0.00125764139776733, 0.000628820698883665, 0.000251528279553466,
                    0.000125764139776733, 0.0000628820698883665, 0.0000251528279553466, 0.0000125764139776733,
                    0.00000628820698883665, 0.00000251528279553466, 0.00000125764139776733, 0.000000628820698883665,
                    0.00000025152827955346];
            }
            else if (type === "GlobalCRS84Pixel") {
                resolutions = [240000, 120000, 60000, 40000,
                    20000, 10000, 4000, 2000,
                    1000, 500, 166, 100,
                    33, 16, 10, 3,
                    1, 0.33];
            }
            else if (type === "GoogleCRS84Quad") {
                resolutions = [1.40625000000000, 0.703125000000000, 0.351562500000000, 0.175781250000000,
                    0.0878906250000000, 0.0439453125000000, 0.0219726562500000, 0.0109863281250000,
                    0.00549316406250000, 0.00274658203125000, 0.00137329101562500, 0.000686645507812500,
                    0.000343322753906250, 0.000171661376953125, 0.0000858306884765625,
                    0.0000429153442382812, 0.0000214576721191406, 0.0000107288360595703, 0.00000536441802978516];
                //
            }
            else if (type === "GoogleMapsCompatible") {
                resolutions = [156543.0339280410, 78271.51696402048, 39135.75848201023,
                    19567.87924100512, 9783.939620502561, 4891.969810251280, 2445.984905125640,
                    1222.992452562820, 611.4962262814100, 305.7481131407048, 152.8740565703525,
                    76.43702828517624, 38.21851414258813, 19.10925707129406, 9.554628535647032,
                    4.777314267823516, 2.388657133911758, 1.194328566955879, 0.5971642834779395];
            }
            else {
                //
            }
            return resolutions;
        }
    });
});
//# sourceMappingURL=SuperMapWMTSLayer.js.map