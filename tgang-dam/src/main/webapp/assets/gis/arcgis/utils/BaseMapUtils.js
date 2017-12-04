/**
 * Created by Administrator on 2016/7/14.
 */
define(["dojo/_base/declare", "dojo/string", "dojo/_base/array",
    "../layers/BaiDuTiledLayer",
    "esri/layers/WebTiledLayer", "esri/layers/FeatureLayer", "esri/layers/GraphicsLayer",
    "esri/layers/ArcGISDynamicMapServiceLayer",
    "esri/layers/WFSLayer",
    "esri/layers/ArcGISTiledMapServiceLayer","../layers/LocalTiledLayer","dojo/_base/lang"
], function (declare, stringUtils, arrayUtils, BaiDuTiledLayer, WebTiledLayer, FeatureLayer, GraphicsLayer,
             ArcGISDynamicMapServiceLayer, WFSLayer,ArcGISTiledMapServiceLayer,LocalTiledLayer,lang) {
    //

    /**
     * ===========================================
     * Tian Di tu Layer Urls.
     * ===========================================
     * */
    /**
     * url template:http://${subDomain}.mqcdn.com/tiles/1.0.0/vx/map/${level}/${col}/${row}.jpg
     * */
    //
    var baseUrl = "http://${subDomain}.tianditu.cn/{layerName}/wmts";
    //
    var subUrl = "?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER={layerId}&STYLE=default&";
    var matrixUrl = "TILEMATRIXSET={matrix}&FORMAT=tiles&TILECOL=${col}&TILEROW=${row}&TILEMATRIX=${level}";


    /**
     * ===========================================
     * Google Layer Urls.
     * ===========================================
     * */
    //
    var dxUrl = "http://${subDomain}.google.cn/vt/lyrs=t@132,r@292013572&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&x=${col}&y=${row}&z=${level}&s=";

    //
    var jtUrl = "http://${subDomain}.google.cn/vt/lyrs=m@297000000&hl=zh-CN&gl=CN&src=app&expIds=201527&rlbl=1&x=${col}&y=${row}&z=${level}&s=";
    //
    var ygUrl = "http://${subDomain}.google.cn/vt/lyrs=y&hl=zh-CN&gl=cn&x=${col}&y=${row}&z=${level}&s=";


    /**
     * ===========================================
     * Bai Du Layer Urls.
     * ===========================================
     * */

    // var bdVecUrl = "http://${subDomain}.map.bdimg.com/tile/?qt=tile&x=${col}&y=${row}&z=${level}&styles=pl&scaler=1&udt=20160708 ";

    //
    //

    /**
     * ===========================================
     * load tile layers from specify url.
     * ===========================================
     * */
    //
    var LayerType = (function () {
        //
        return {
            //
            BD: "bd",// bai du laer.
            TDT: "tdt",// tian di tu  layer..
            GOOGLE: "google"//google layer.

        };
    })();
    var _map = null;
    var _initExtent = null;
    //
    //
    function createSubDomains(count, type) {
        var results = [];
        for (var i = 0; i < count; i++) {
            //
            if (type === LayerType.BD) {
                //bai du layer.
                results.push("online" + i);
            } else if (type === LayerType.GOOGLE) {
                //google layer
                results.push("mt" + i);
            } else if (type === LayerType.TDT) {
                //tian di tu layer.
                results.push("t" + i);
            } else {
            }

        }
        return results;
    }

    return declare(null, {
        /**
         * @param map  Type {esri.Map}
         * */
        constructor: function (map) {

            _map = map;
        },
        //
        _createImgLayer: function (options) {
            //
            var imgUrl = "";
            var imgLabelUrl = "";
            // var wkid = options.wkid;
            var visible = options.visible || false;
            /*if (wkid === "1") {
             //
             imgUrl = this._createUrlTemplate("img_c");
             imgLabelUrl = this._createUrlTemplate("cia_c");
             //
             this._createBaseLayers([imgUrl, imgLabelUrl], LayerType.TDT, visible);
             } else if (wkid === "2") {
             //
             imgUrl = this._createUrlTemplate("img_w");
             imgLabelUrl = this._createUrlTemplate("cia_w");
             this._createBaseLayers([imgUrl, imgLabelUrl], LayerType.TDT, visible);
             }*/
            //
            imgUrl = this._createUrlTemplate("img_w");
            imgLabelUrl = this._createUrlTemplate("cia_w");
            this._createBaseLayers([imgUrl, imgLabelUrl], LayerType.TDT, visible, [options.id, options.id + "w"]);
            //
        },
        _createVecLayer: function (options) {
            //TODO:
            var vecUrl = "";
            var vecLblUrl = "";
            var wkid = options.wkid;
            //
            var visible = options.visible || false;
            //
            /* if (wkid === "1") {
             //经纬度
             vecUrl = this._createUrlTemplate("vec_c");
             vecLblUrl = this._createUrlTemplate("cva_c");
             this._createBaseLayers([vecUrl, vecLblUrl], LayerType.TDT, visible);
             } else if (wkid === "2") {
             //墨卡托
             vecUrl = this._createUrlTemplate("vec_w");
             vecLblUrl = this._createUrlTemplate("cva_w");
             this._createBaseLayers([vecUrl, vecLblUrl], LayerType.TDT, visible);
             }*/
            vecUrl = this._createUrlTemplate("vec_w");
            vecLblUrl = this._createUrlTemplate("cva_w");
            this._createBaseLayers([vecUrl, vecLblUrl], LayerType.TDT, visible, [options.id, options.id + "w"]);
        },
        _createTerrainLayer: function (options) {
            //
            var terUrl = "";
            var terLblUrl = "";
            var wkid = options.wkid;
            var visible = options.visible || false;

            /* if (wkid === "1") {
             //经纬度
             terUrl = this._createUrlTemplate("ter_c");
             terLblUrl = this._createUrlTemplate("cta_c");
             this._createBaseLayers([terUrl, terLblUrl], LayerType.TDT, visible);
             } else if (wkid === "2") {
             //墨卡托
             terUrl = this._createUrlTemplate("ter_w");
             terLblUrl = this._createUrlTemplate("cta_w");
             this._createBaseLayers([terUrl, terLblUrl], LayerType.TDT, visible);
             }*/
            //
            terUrl = this._createUrlTemplate("ter_w");
            terLblUrl = this._createUrlTemplate("cta_w");
            this._createBaseLayers([terUrl, terLblUrl], LayerType.TDT, visible, [options.id, options.id + "w"]);
        },
        //
        _createBaseLayers: function (urls, type, isVisible, ids) {
            //url
            // var layers = [];
            // debugger;
            arrayUtils.forEach(urls, function (url, iindex) {
                //
                //
                var tileLayer = new WebTiledLayer(url, {

                    id: ids[iindex],
                    subDomains: createSubDomains(2, type)
                });
                //
                if (_map) {
                    //
                    _map.addLayer(tileLayer);
                }
                if (!isVisible) {
                    //
                    tileLayer.hide();
                }
            });
            //
            if (_map) {
                //
                // _map.addLayers(layers);
                if (_initExtent) {
                    //
                    _map.setExtent(_initExtent);
                }
            }
        },
        //
        _createUrlTemplate: function (layerName) {
            //
            if (layerName) {
                //
                var parts = layerName.split("_");
                var url1 = baseUrl.replace(/{layerName}/g, layerName);
                //
                var url2 = subUrl.replace(/{layerId}/g, parts[0]);
                //
                var url3 = matrixUrl.replace(/{matrix}/g, parts[1]);
                //
                return url1 + url2 + url3;
            }
        },
        //
        loadTDTLayer: function (options) {
            //
            //
            _initExtent = options.extent;
            if (options.type === "vec") {
                //矢量图
                this._createVecLayer(options);
            } else if (options.type === "img") {
                //影像图
                this._createImgLayer(options);
            } else if (options.type === "ter") {
                //地形图
                this._createTerrainLayer(options);
            } else {
                // TODO:
                alert("底图类型不支持，请输入['ter','img','vec']中的一种。");
            }
        },

        loadGoogleLayer: function (options) {
            //
            _initExtent = options.extent;
            var isVisible = options.visible || false;
            if (options.type === "ter") {
                //地形图
                this._createBaseLayers([dxUrl], LayerType.GOOGLE, isVisible, [options.id]);
            } else if (options.type === "vec") {
                //矢量图
                this._createBaseLayers([jtUrl], LayerType.GOOGLE, isVisible, [options.id]);
            } else if (options.type === "img") {
                //影像图
                this._createBaseLayers([ygUrl], LayerType.GOOGLE, isVisible, [options.id]);
            } else {
                //
                alert("底图类型不支持，请输入['ter','vec','img']中的一种。");
            }
        },
        /**
         * @param options {Object}
         * @example {
         *
         *      extent: esri.Geometry.Extent,
         *      type："vec or img.",
         *      visible:"layer visible."
         * }
         * */
        loadBaiDuLayer: function (options) {
            //
            if (options.type === "vec") {
                //矢量图
                var vecLayer = new BaiDuTiledLayer({
                    id: options.id,
                    type: options.type
                });
                //
                //
                _map.addLayer(vecLayer);
                //
                if (!options.visible) {
                    //
                    vecLayer.hide();
                }
                // this._createBaseLayers([bdVecUrl],LayerType.BD);
            } else if (options.type === "img") {
                //影像图
                var imgLayer = new BaiDuTiledLayer({
                    id: options.id,
                    type: options.type
                });
                var lblLayer = new BaiDuTiledLayer({
                    id: options.id + "w",
                    type: "annotation"
                });
                //

                _map.addLayers([imgLayer, lblLayer]);
                //
                if (!options.visible) {
                    //
                    imgLayer.hide();
                    lblLayer.hide();
                }
            } else {
                //
                alert("底图类型不支持，请输入['vec','img']中的一种。");
            }
            //
            if (options.extent) {
                //
                _map.setExtent(options.extent);
            }
            //
        },

        addLayer: function (options) {
            //
            var type = options.type;
            //
            var dseLayer = null;
            switch (type) {
                //
                case "feature":
                    dseLayer = this._createFeatureLayer(options);
                    break;
                case "graphic":
                    dseLayer = this._createGraLayer(options);
                    break;
                case "wfs":
                    dseLayer = this._createWfsLayer(options);
                    break;
                case "dynamic":
                    //
                    dseLayer = this._createDynamicLayer(options);
                    break;
                default:
                    break;
            }
            if (dseLayer) {
                //
                var layerIndex = options.index || _map.layerIds.length;
                //
                //
                dseLayer.name=options.name|| "Layer"+(Math.random()*100).toFixed(0);
                // dseLayer.legendType="ags";
                dseLayer.isInLayerCtrl=options.isInLayerCtrl;
                _map.addLayer(dseLayer, layerIndex);

            }
            return dseLayer;
        },

        /**
         * 创建 Feature ArcGIS GraphicsLayer.
         * */
        _createGraLayer: function (options) {
            //
            var dseLayer = _map.getLayer(options.id);
            if (!dseLayer) {
                //
                dseLayer = new GraphicsLayer({
                    id: options.id,
                    visible: options.initShow
                });
                //
                dseLayer.legendType="single";
                // var layerIndex = options.index || _map.layerIds.length;
                // _map.addLayer(dseLayer, layerIndex);
            }
            //
            return dseLayer;
        },
        /**
         * 创建 Feature ArcGIS FeatureLayer.
         * */
        _createFeatureLayer: function (options) {
            //
            var dseLayer = _map.getLayer(options.id);
            if (!dseLayer) {
                //
                dseLayer = new FeatureLayer(options.url, {
                    id: options.id,
                    mode: FeatureLayer.MODE_ONDEMAND,
                    visible: options.initShow,
                    showLabels: true
                });
                dseLayer.legendType="ags";
                // var layerIndex = options.index || _map.layerIds.length;
                // _map.addLayer(dseLayer, layerIndex);
            }
            //
            return dseLayer;
        },
        /**
         * 创建 Feature WFS Layer.
         * */
        _createWfsLayer: function (options) {

            var dseLayer = _map.getLayer(options.id);
            //
            if (!dseLayer) {
                //
                dseLayer = new WFSLayer({
                    url: options.url,
                    visible: options.initShow
                });
                dseLayer.id = options.id;
                dseLayer.legendType="ags";
                // var layerIndex = options.index || _map.layerIds.length;
                // _map.addLayer(dseLayer, layerIndex);
            }
            //
            return dseLayer;
        },
        /**
         * 创建ArcGIS dynamic Layer.
         * */
        _createDynamicLayer: function (options) {
            //
            var dseLayer = _map.getLayer(options.id);
            //
            if (!dseLayer) {
                //
                dseLayer = new ArcGISDynamicMapServiceLayer(options.url, {
                    //
                    id: options.id,
                    visible: options.initShow
                });
                //
                // this.name=options.name|| "Layer"+(Math.random()*100).toFixed(0);
                dseLayer.legendType="ags";
                // this.isInLayerCtrl=options.isInLayerCtrl;
                //
                // var layerIndex=options.index||_map.layerIds.length;
                // //
                // _map.addLayer(dseLayer,layerIndex);
            }
            return dseLayer;
        },
        /**
         * 创建信息展示图层.
         * */
        //
        _createQueryDisplayLayer:function(options){
            //

        },
        /**
         * 创建程序底图.
         * */
        //
        loadLBaseLayers:function(layersCfg){
            //
            arrayUtils.forEach(layersCfg,lang.hitch(this,function(cfg){
                //
                var baseLayer = null;
                //
                switch (cfg.type) {
                    //
                    case "baidu":
                        //
                        this.loadBaiDuLayer({
                            //
                            id: cfg.id,
                            type: cfg.url,
                            visible: cfg.initShow
                        });
                        break;
                    case "google":
                        //
                        this.loadGoogleLayer({
                            id: cfg.id,
                            type: cfg.url,
                            visible: cfg.initShow
                        });
                        break;
                    case "tdt":
                        this.loadTDTLayer({
                            id: cfg.id,
                            type: cfg.url,
                            visible: cfg.initShow
                            // wkid:DseGisConfig.mapType
                        });
                        break;
                    case "arcgis":
                        baseLayer = new ArcGISTiledMapServiceLayer(cfg.url, {
                            //
                            id: cfg.id,
                            visible: cfg.initShow
                        });
                        //
                        _map.addLayer(baseLayer);
                        break;
                    case "local":
                        baseLayer = new LocalTiledLayer(cfg.url, {
                            //
                            id: cfg.id,
                            visible: cfg.initShow,
                            // cacheValue:cfg.code,
                            initExtent: cfg.initExtent,
                            fullExtent: cfg.fullExtent
                        });
                        _map.addLayer(baseLayer);
                        break;
                    default:
                        break;
                }
            }));
        }
    });
});  //