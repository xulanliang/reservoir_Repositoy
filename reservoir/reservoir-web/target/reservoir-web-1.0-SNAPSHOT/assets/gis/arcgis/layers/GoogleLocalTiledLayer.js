/**
 * <p>加载Google离线切片地图</p>
 * @author wangsl
 * @date 2017-03-24
 */
//
define(["dojo/_base/declare", "esri/layers/TiledMapServiceLayer", "esri/geometry/Extent",
    "esri/SpatialReference", "esri/layers/TileInfo", "dojo/_base/lang"], function (declare, TiledMapServiceLayer, Extent, SpatialReference, TileInfo, dojoLang) {
    //
    //
    // var layerUrl = "";
    // var imgExt = ".png";
    var googleLayer = declare([TiledMapServiceLayer], {
        //
        constructor: function (url, options) {
            //
            // layerUrl = url;
            //
            this.layerUrl = url;
            this.imgExt = ".png";
            dojoLang.mixin(this, options);
            this.spatialReference = new SpatialReference({
                //
                wkid: 102113
            });
            //
            if (options.type) {
                //
                this.layerType = options.type;
            }
            //
            //
            var exts = options.initialExtent;
            //
            if (exts) {
                //
                this.initialExtent = this._createExtent(exts);
            }
            else {
                //
                this.initialExtent = this._createExtent([-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787]);
            }
            //full extent.
            var fullExts = options.fullExtent;
            if (fullExts) {
                //
                this.fullExtent = this._createExtent(fullExts);
            }
            else {
                //
                this.fullExtent = this._createExtent([-20037508.342787, -20037508.342787, 20037508.342787, 20037508.342787]);
            }
            //
            //
            if (options.format) {
                //
                // imgExt = options.format;
                this.imgExt = options.format;
            }
            //
            this.tileInfo = new TileInfo({
                // "dpi": "90.71428571427429",
                "dpi": 90.71428571427429,
                "format": "image/png",
                "compressionQuality": 0,
                "spatialReference": {
                    "wkid": 102113
                },
                "rows": 256,
                "cols": 256,
                "origin": {
                    "x": -20037508.342787,
                    "y": 20037508.342787
                },
                // Scales in DPI 96
                "lods": [
                    {"level": 0, "scale": 591657527.591555, "resolution": 156543.033928},
                    {"level": 1, "scale": 295828763.795777, "resolution": 78271.5169639999},
                    {"level": 2, "scale": 147914381.897889, "resolution": 39135.7584820001},
                    {"level": 3, "scale": 73957190.948944, "resolution": 19567.8792409999},
                    {"level": 4, "scale": 36978595.474472, "resolution": 9783.93962049996},
                    {"level": 5, "scale": 18489297.737236, "resolution": 4891.96981024998},
                    {"level": 6, "scale": 9244648.868618, "resolution": 2445.98490512499},
                    {"level": 7, "scale": 4622324.434309, "resolution": 1222.99245256249},
                    {"level": 8, "scale": 2311162.217155, "resolution": 611.49622628138},
                    {"level": 9, "scale": 1155581.108577, "resolution": 305.748113140558},
                    {"level": 10, "scale": 577790.554289, "resolution": 152.874056570411},
                    {"level": 11, "scale": 288895.277144, "resolution": 76.4370282850732},
                    {"level": 12, "scale": 144447.638572, "resolution": 38.2185141425366},
                    {"level": 13, "scale": 72223.819286, "resolution": 19.1092570712683},
                    {"level": 14, "scale": 36111.909643, "resolution": 9.55462853563415},
                    {"level": 15, "scale": 18055.954822, "resolution": 4.77731426794937},
                    {"level": 16, "scale": 9027.977411, "resolution": 2.38865713397468},
                    {"level": 17, "scale": 4513.988705, "resolution": 1.19432856685505},
                    {"level": 18, "scale": 2256.994353, "resolution": 0.597164283559817},
                    {"level": 19, "scale": 1128.497176, "resolution": 0.298582141647617}
                ]
            });
            //
            this.loaded = true;
            this.onLoad(this);
        },
        getTileUrl: function (level, row, col) {
            // tiles/  level+col+row.png
            //http://10.100.9.52:8080/tiegang/yaogan/tiles/7/104/55.png
            return this.layerUrl + "/tiles/" + level + "/" + col + "/" + row + this.imgExt;
        },
        /**
         * @param infos  format is [xmin,ymin,xmax,ymax]
         * @author wangsl
         * @return "esri/geometry/Extent"
         * */
        _createExtent: function (infos) {
            //
            var extent = new Extent(infos[0], infos[1], infos[2], infos[3], this.spatialReference);
            return extent;
        }
    });
    //
    return googleLayer;
});
//# sourceMappingURL=GoogleLocalTiledLayer.js.map