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
    /**天地图默认切图比例尺*/
    var scales = [2.958293554545656E8, 1.479146777272828E8, 7.39573388636414E7, 3.69786694318207E7, 1.848933471591035E7, 9244667.357955175,
        4622333.678977588, 2311166.839488794, 1155583.419744397, 577791.7098721985, 288895.85493609926, 144447.92746804963, 72223.96373402482,
        36111.98186701241, 18055.990933506204, 9027.995466753102, 4513.997733376551, 2256.998866688275, 1128.4994333441375];
    //
    return declare([TiledMapServiceLayer], {
        //
        constructor: function (url, options) {
            //
            lang.mixin(this, options);
            this.tileUrl = url;
            this.spatialReference = new SpatialReference({ wkid: options.wkid });
            this.initialExtent = this.fullExtent = this._createExtent(options.extent);
            //
            var layerScales = options.scales || scales;
            var tiles = this._createLayerTileLOD(layerScales, options.startIndex);
            this.tileInfo = new TileInfo({
                dpi: (options.dpi || 96),
                rows: 256,
                cols: 256,
                compressionQuality: 0,
                //set tile origin
                // origin: options.origin,
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
            var fullUrl = this.tileUrl + "?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=" + this.identifier + "&STYLE="
                + this.style + "&TILEMATRIXSET=" + this.tileMatrixSet + "&FORMAT=" + this.format + "&TILECOL=" + col +
                "&TILEROW=" + row + "&TILEMATRIX=" + level;
            return fullUrl;
        },
        //
        _createLayerTileLOD: function (scales, startIndex) {
            //
            var tiles = [];
            var resolutions = this._getLayerResolutions("test");
            //
            scales.forEach(function (d, iindex) {
                //
                // var res = d * 0.0254000508 / 96 / 111194.872221777;
                //
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
        //
        _getLayerResolutions: function (type) {
            //
            var resolutions = [0.7031249999891485,
                0.35156249999999994, 0.17578124999999997, 0.08789062500000014,
                0.04394531250000007, 0.021972656250000007, 0.01098632812500002,
                0.00549316406250001, 0.0027465820312500017, 0.0013732910156250009,
                0.000686645507812499, 0.0003433227539062495,
                0.00017166137695312503, 0.00008583068847656251,
                0.000042915344238281406, 0.000021457672119140645,
                0.000010728836059570307, 0.000005364418029785169];
            /**
             * web 墨卡托下分辨率率.
             * [ 78271.51696402048,
             39135.75848201024, 19567.87924100512, 9783.93962050256,
             4891.96981025128, 2445.98490512564, 1222.99245256282,
             611.49622628141, 305.748113140705, 152.8740565703525,
             76.43702828517625, 38.21851414258813, 19.109257071294063,
             9.554628535647032, 4.777314267823516, 2.388657133911758,
             1.194328566955879, 0.5971642834779395 ]
             * */
            /**
             *  国家2000坐标系下的分辨率
             *  [0.7031249999891485,
             0.35156249999999994, 0.17578124999999997, 0.08789062500000014,
             0.04394531250000007, 0.021972656250000007, 0.01098632812500002,
             0.00549316406250001, 0.0027465820312500017, 0.0013732910156250009,
             0.000686645507812499, 0.0003433227539062495,
             0.00017166137695312503, 0.00008583068847656251,
             0.000042915344238281406, 0.000021457672119140645,
             0.000010728836059570307, 0.000005364418029785169]
             * */
            return resolutions;
        }
    });
});
//# sourceMappingURL=TdtWMTSLayer.js.map