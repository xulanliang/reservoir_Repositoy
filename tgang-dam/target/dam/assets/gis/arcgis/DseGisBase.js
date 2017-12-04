define([
    // "./DseGisConfig",
    "./utils/dseGisUtils",
    "esri/map",
    "dojo/parser",
    'esri/urlUtils',
    "esri/symbols/SimpleLineSymbol",
    "esri/symbols/SimpleMarkerSymbol",
    "esri/graphic",
    "esri/symbols/Font",
    "dojo/_base/Color",
    "esri/geometry/Point",
    "esri/geometry/Extent",
    "dojo/_base/array",
    "./utils/BaseMapUtils",
    "./utils/DseGraphicUtils",
    "./utils/dseSymbolUtils",
    "dojo/dom",
    "dojo/on",
    "dojo/dom-construct",

    "config/gis-config",
    "dse_gis/utils/DseGPUtils",
    "dse_gis/utils/DseGeoUtils",
    "./appEvent",
    "dijit/registry",

    "dojo/domReady!"
], function (dseGisUtils, Map, parser, urlUtils, SimpleLineSymbol, SimpleMarkerSymbol, Graphic, Font, Color, Point, Extent,
             arrayUtils, BaseMapUtils, DseGraphicUtils, dseSymbolUtils, dom, on, domConstruct, DseGisConfig,
             DseGPUtils, DseGeoUtils, appEvent, registry) {

    //
    parser.parse();
    //
    var dseMap = null;
    var flashInteval = '',//闪烁定时器
        flash_layer = '';//闪烁图层
    //
    var layerUtils = null;
    //
    // var graUtils = null;
    //
    window.dseGisConfig = DseGisConfig;
    window.dseGisUtils = dseGisUtils;
    window.dseGisData = {};
    //
    window.appEvent = appEvent;
    /**
     * 启动代理
     */
    if (Object.prototype.toString.call(DseGisConfig.urlPrefixs) === '[object Array]') {
        for (var i = 0; i < DseGisConfig.urlPrefixs.length; i++) {
            urlUtils.addProxyRule({
                urlPrefix: DseGisConfig.urlPrefixs[i],
                proxyUrl: DseGisConfig.proxyUrl
            });
        }
    }
    //
    var getMap = function () {
            //Arcgis server跨域问题，如果你的浏览器和web服务器不支持CORS，请设置esri.config.defaults.io.corsDetection=false;！！！不然会报这个错：XMLHttpRequest cannot load http://server/arcgis/rest/info?f=json. Origin http://localhost:8080 is not allowed by Access-Control-Allow-Origin
            esri.config.defaults.io.corsDetection = false;
            return new Map(arguments[0], {
                minZoom: DseGisConfig.minZoom,
                maxZoom: DseGisConfig.maxZoom,
                logo: false,
                zoom: DseGisConfig.zoom,
                slider: false
            });
        },
        /**
         * 地图定位lgtd(经度),lttd(纬度) level(地图缩放级别)
         */
        showCenterAt = function (lgtd, lttd, level) {
            var pts = dseGisUtils.WgsToDqzb(lgtd, lttd, DseGisConfig.mapType);
            if (pts.length < 2) {
                return;
            }
            if (level) {
                dseMap.setLevel(level);
            }
            var pt = new Point(pts[0], pts[1], dseMap.spatialReference);
            dseMap.centerAt(pt);
            showLocalCircle(pt, 10000);
        },

        /**
         * 将地图平移到指定范围arrExtent(数组[最小经度，最小纬度，最大经度，最大纬度])
         */
        showExtent = function (arrExtent) {
            if (arrExtent && arrExtent.length > 3) {
                //
                var minEx = dseGisUtils.WgsToDqzb(arrExtent[0], arrExtent[1], DseGisConfig.mapType);
                var maxEx = dseGisUtils.WgsToDqzb(arrExtent[2], arrExtent[3], DseGisConfig.mapType);

                var extent = new Extent(Number(minEx[0]),
                    Number(minEx[1]), Number(maxEx[0]),
                    Number(maxEx[1]), dseMap.spatialReference);
                dseMap.setExtent(extent);
            }
        },
        /**
         * 光圈效果
         *    point
         * time 闪烁层持续时间 单位毫秒  如果不设置将持续闪烁
         */
        showLocalCircle = function (point, time) {
            flash_layer.clear();
            clearInterval(flashInteval);
            var min = 5, max = 40, tmp = min,
                symbol = new SimpleMarkerSymbol(
                    SimpleMarkerSymbol.STYLE_CIRCLE, tmp,
                    new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, new Color([255, 0, 0]), 2),
                    new Color([0, 0, 0, 0]));
            var graphic = new Graphic(point, symbol);
            flash_layer.add(graphic);

            flashInteval = setInterval(function () {
                tmp += 3;
                symbol.setSize(tmp = tmp <= max ? tmp : min);
                graphic.setSymbol(symbol);
            }, 100);

            if (time && $.isNumeric(time)) {
                setTimeout(function () {
                    flash_layer.clear();
                }, Number(time));
            }
        },
        /*
         * showInfoWindow属性窗体的创建(lgtd:显示位置的经度;lttd:显示位置的纬度;content:窗体html信息;
         * title:窗体标题;width:宽度,默认270px;iscolse:是否关闭，默认false显示)
         */
        showInfoWindow = function (lgtd, lttd, content, title, width, iscolse) {
            if (!lgtd || !lttd || !content) {
                return;
            }
            dseMap.infoWindow.setContent(content);
            $(".titlePane").css("backgroundColor", "#1468b4");//标题栏的背景颜色
            $(".titlePane").css("font-size", "15px");//标题栏的字体大小
            if (width && width != "") {
                $(".sizer").css("width", width);
            } else {
                $(".sizer").css("width", "270px");
            }

            dseMap.infoWindow.setTitle(dseGisUtils.nullToSpace(title));
            if (iscolse && iscolse == true) {
                $(".close").css("display", "none");
            }
            //移除按钮
            $(".maximize").remove();
            dseMap.infoWindow.show(new Point(lgtd, lttd, dseMap.spatialReference));//new Point(113.343125,23.987933)
        },
        /**
         * 弹出对话框，弹出框内容可引入其它html页面
         * */
        showInfoWindowFrom = function (title, url, width, height) {
            //
            var top = $(document).height() / 2 - height / 2;
            //
            console.log(top);
            //
            var left = $(document).width() / 2 - width / 2;
            layer.open({
                type: 2,// iframe层
                title: title,//row.STNM.trim(),
                offset: '20px',
                shadeClose: false,
                shade: 0.3,
                area: [width + 'px', height + 'px'], // IE，火狐，chrome 1024*768 兼容
                content: url,//$.contextPath() + "/syqjc/dseStRiverR/toHdGisDetailPage.ds",
                closeBtn: 1,
                offset: [top + "px", left + "px"]
            });
        };

    //
    // var gpUtils = null;
    //
    // var geoUtils = null;
    //
    var module = (function () {
        //
        return {
            //几何图形处理工具
            geo: null,
            //符号创建通用工具
            sym: null,
            //gp服务通用工具
            gp: null,
            //几何图形辅助工具
            gra: null,
        };
    })();
    //
    return {
        initMap: function (container, opt) {
            dseMap = getMap(container);
            //
            dseMap.on("load", function (event) {
                //底图加载完成后平移到指定位置
                if (DseGisConfig.fullExtent) {
                    showExtent(DseGisConfig.fullExtent);
                }
                /**
                 * 通知其他模块可以加载Graphicslayer图层.
                 * */
                appEvent.dispatchAppEvent(appEvent.BASE_MAP_LAYER_LOADED, {
                    //
                    msg: "base map loaded."
                });
            });
            //
            dseMap.on("error", function (event) {
                //
                console.log("无法连接底图服务");
                //
            });
            //layers util.
            layerUtils = new BaseMapUtils(dseMap);
            //gp utils.
            module.gp = new DseGPUtils({
                //
                urls: DseGisConfig.gpUrls,
                map: dseMap
            });
            //
            module.geo = new DseGeoUtils({
                //
                map: dseMap,//Required
                editLayer: null,//Option
                url: ""//
            });
            //
            module.gra = new DseGraphicUtils({
                map: dseMap,
                mapType: DseGisConfig.mapType
            });
            //
            module.sym = dseSymbolUtils;
            //
            layerUtils.loadLBaseLayers(DseGisConfig.baseMapLayers);
            //显示地图切换控件 不显示设置false
            if (opt.showMapLayerChangeBar) {
                // changeMapType.init();
                //
                require(["dse_gis/controls/LayerSwitchControl"], function (LayerSwitchControl) {
                    //
                    var layerSwitcher = new LayerSwitchControl({
                        map: dseMap,
                        layers: DseGisConfig.baseMapLayers
                    });
                    //
                    layerSwitcher.init();
                });
            }
            //显示经纬度控件. 不显示设置为false.
            if (opt.showMapLabel) {
                //
                require(["dse_gis/controls/MapLabelControl"], function (MapLabelControl) {
                    //
                    var mapLabel = new MapLabelControl({
                        map: dseMap,//Required
                        type: DseGisConfig.mapType//Required
                    });
                    //
                    mapLabel.init();
                });
            }
            //显示工具条控件，不显示设置false
            if (opt.showToolbars) {
                //
                require(["dse_gis/controls/ToolbarControl"], function (ToolbarTool) {
                    //
                    var bar = new ToolbarTool({
                        //
                        map: dseMap,//Required
                        // tools: DseGisConfig.tools//Required
                    });
                    //
                    bar.init();
                });
            }
            //显示图层管理换控件 不显示设置false
            if (opt.showLayerBar) {
                //
                require(["dse_gis/controls/LayerManControl"], function (LayerManControl) {
                    //
                    var layerCtrl = new LayerManControl({
                        //
                        map: dseMap,//Required
                        layers: DseGisConfig.optionalLayers,//Required
                        util: layerUtils//Required
                    });
                    //
                    layerCtrl.init();
                });

            }
            //显示查询框控件，不显示设置false.
            if (opt.showSearchBox) {
                //
                require(["dse_gis/controls/SearchControl"], function (Search) {
                    //
                    var schCtn = domConstruct.create("div", {
                        id: "search"
                    }, document.body);
                    //
                    var ctrl = new Search({
                        map: dseMap,
                        // sources: sources,
                        config: DseGisConfig.mapSearch,
                        layer: layerUtils.addLayer({
                            type: "graphic",
                            id: "g_dse_sch_layer"
                        }),
                        outFields: ["*"],
                        enableSourcesMenu: false,//
                        enableLabel: true,
                        // zoomScale: 10000,
                        activeSourceIndex: "all",
                        showMultiResults: DseGisConfig.mapSearch.showMultiResults
                    }, schCtn);
                    //
                    ctrl.startup();
                });
            }

            //显示图例控件，不显示设置false.
            if (opt.showMapLegend) {
                //
                //
                require(["dse_gis/controls/MapLegend"], function (MapLegend) {
                    //
                    var legendCtn = domConstruct.create("div", {
                        id: "legend"
                    }, document.body);
                    //

                    var legend = new MapLegend({
                        map: dseMap,
                        config: DseGisConfig.mapLegend.sources,
                        autoUpdate: false,
                        legendType: DseGisConfig.mapLegend.type
                    }, legendCtn);

                });

            }
            //加载行政区划导航控件
            if (opt.showMapRegion) {
                //
                require(["dse_gis/controls/RegionControl"], function (RegionControl) {
                    //
                    var domCtn = domConstruct.create("div", {
                        //
                    }, document.body);
                    var testCtrl = new RegionControl(domCtn, {
                        //
                        map: dseMap,
                        id: "regionCtr",
                        mapType: DseGisConfig.mapType,
                        //位置
                        position: {
                            right: 100,
                            top: 300
                        },
                        //大小
                        /*size:{
                         width:300,
                         height:400
                         },*/
                        // config: DseGisBase.appConfig.baseMapLayers
                        // uri:"./data/test.json"
                    });
                    // testCtrl.placeAt(document.body);

                });
            }
            //添加闪烁图层.
            flash_layer = layerUtils.addLayer({
                id: 'flash_layer',
                type: "graphic"
            });
            //设置全局变量，供其他模块引用地图。
            window.dseMap = dseMap;
            return dseMap;
        },
        addLayer: function (options) {

            return layerUtils.addLayer(options);
        },
        //用于创建点、线、面不同类型的Graphic.
        /*getGraUtil: function () {
         //
         return graUtils;
         },*/
        /* createPoint: CreatPoint,//添加点
         createPolyline: CreatPolyline,//添加线
         CreatePolygon: CreatePolygon,//添加面*/
        //
        //用于创建常用的符号
        // sym: dseSymbolUtils,
        /*PMS: PMS,//点风格
         SLineSymbol: SLineSymbol,//线风格
         SFillSymbol: SFillSymbol,//面风格*/
        showInfoWindow: showInfoWindow,//属性窗体
        showCenterAt: showCenterAt,//定位
        // getMarkImg: dseSymbolUtils.getMarkImg,
        showLocalCircle: showLocalCircle,//光圈效果
        showExtent: showExtent,//地图平移到指定范围,
        /**
         * @param options {Object}
         * @example:
         * {
         *      url:"",
         *      position:[left,top,right,bottom]
         * }
         *
         * */
        addMapControl: function (options) {
            //
            if (options.url) {
                //
                require([options.url], function (Control) {
                    //
                    var control = dom.byId(options.id);
                    //
                    if (!control) {
                        //
                        delete options.url;
                        control = new Control(options);
                        //
                        control.placeAt(dom.byId(dseMap.id));
                    }
                });
                //
            }
        },
        /**
         * 移除地图组件
         * @param widgetId {String}
         *
         * **/
        removeControl: function (widgetId) {
            //
            if (widgetId) {
                //
                registry.forEach(function (widget) {
                    //
                    //
                    if (widget.id === widgetId) {
                        //
                        widget.destroyRecursive();
                    }
                });
            }
        },
        /**
         * 添加地图工具
         * */
        addMapTool: function (options) {
            //
        },
        /**
         * 获取框架配置文件
         * */
        appConfig: DseGisConfig,
        /**
         * 框架通用工具类.
         * */
        utils: module,
        showInfoWindowFrom: showInfoWindowFrom
    };

});