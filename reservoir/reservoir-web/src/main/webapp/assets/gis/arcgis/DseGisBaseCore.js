/**
 * <description>
 *     框架基础核心了,返回核心对象的构造函数，在应用中使用首先需要使用new 关键字创建示例后，才可以调用,
 *     在一个应用中需要创建多幅地图的情况下使用,例如:  var dseMapCoreOne = new DseGisBaseCore();
 * </description>
 *
 * @author wangsl
 * @date 2016-10-17
 * **/
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
    "./utils/DseGPUtils",
    "./utils/DseGeoUtils",
    "./appEvent",
    "dijit/registry",
    "dojo/_base/declare",
    "./ResLoader",
    "dojo/domReady!"
], function (dseGisUtils, Map, parser, urlUtils, SimpleLineSymbol, SimpleMarkerSymbol, Graphic, Font, Color, Point, Extent, arrayUtils, BaseMapUtils, DseGraphicUtils, dseSymbolUtils, dom, on, domConstruct, DseGisConfig, DseGPUtils, DseGeoUtils, appEvent, registry, declare, ResLoader) {
    //
    parser.parse();
    //
    //
    // var graUtils = null;
    //
    window.dseGisConfig = DseGisConfig;
    window.dseGisUtils = dseGisUtils;
    window.dseGisData = {};
    //
    window.appEvent = appEvent;
    //
    //加载样式.
    var loader = new ResLoader();
    //
    loader.loadStyle("arcgis", "claro");
    //
    var clazzO = declare(null, {
        //
        constructor: function (mapId, options) {
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
            //
            this._init(mapId, options);
        },
        //
        _init: function (mapId, options) {
            //
            var self = this;
            //
            var dseMap = null;
            var flashInteval, //闪烁定时器
            flash_layer = ''; //闪烁图层
            //
            var layerUtils = null;
            //
            self.getMap = function () {
                //
                //Arcgis server跨域问题，如果你的浏览器和web服务器不支持CORS，请设置esri.config.defaults.io.corsDetection=false;！！！不然会报这个错：XMLHttpRequest cannot load http://server/arcgis/rest/info?f=json. Origin http://localhost:8080 is not allowed by Access-Control-Allow-Origin
                // esri.config.defaults.io.corsDetection = false;
                return new Map(arguments[0], {
                    minZoom: DseGisConfig.minZoom,
                    maxZoom: DseGisConfig.maxZoom,
                    logo: false,
                    zoom: DseGisConfig.zoom,
                    slider: false
                });
            };
            //
            /**
             * 地图定位lgtd(经度),lttd(纬度) level(地图缩放级别)
             */
            self.showCenterAt = function (lgtd, lttd, level) {
                var pts = dseGisUtils.WgsToDqzb(lgtd, lttd, DseGisConfig.mapType);
                if (pts.length < 2) {
                    return;
                }
                if (level) {
                    dseMap.setLevel(level);
                }
                var pt = new Point(pts[0], pts[1], dseMap.spatialReference);
                dseMap.centerAt(pt);
                //
                self.showLocalCircle(pt, 10000);
                // showLocalCircle(pt, 10000);
            };
            //
            /**
             * 将地图平移到指定范围arrExtent(数组[最小经度，最小纬度，最大经度，最大纬度])
             */
            self.showExtent = function (arrExtent, level) {
                //
                //debugger;
                if (level) {
                    //
                    dseMap.setLevel(level);
                }
                if (arrExtent && arrExtent.length > 3) {
                    //地图范围不执行转换.
                    /* var minEx = dseGisUtils.WgsToDqzb(arrExtent[0], arrExtent[1], DseGisConfig.mapType);
                     var maxEx = dseGisUtils.WgsToDqzb(arrExtent[2], arrExtent[3], DseGisConfig.mapType);

                     var extent = new Extent(Number(minEx[0]),
                     Number(minEx[1]), Number(maxEx[0]),
                     Number(maxEx[1]), dseMap.spatialReference);
                     dseMap.setExtent(extent);*/
                    //
                    var extent = new Extent(Number(arrExtent[0]), Number(arrExtent[1]), Number(arrExtent[2]), Number(arrExtent[3]), dseMap.spatialReference);
                    dseMap.setExtent(extent);
                }
            };
            /**
             * 光圈效果
             *    point
             * time 闪烁层持续时间 单位毫秒  如果不设置将持续闪烁
             */
            self.showLocalCircle = function (point, time) {
                // 添加到临时图层
                // flash_layer.clear();
                dseMap.graphics.clear();
                clearInterval(flashInteval);
                var min = 5, max = 40, tmp = min, symbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CIRCLE, tmp, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, new Color([255, 0, 0]), 2), new Color([0, 0, 0, 0]));
                var graphic = new Graphic(point, symbol);
                // flash_layer.add(graphic);
                dseMap.graphics.add(graphic);
                flashInteval = setInterval(function () {
                    tmp += 3;
                    symbol.setSize(tmp = tmp <= max ? tmp : min);
                    graphic.setSymbol(symbol);
                }, 100);
                if (time && $.isNumeric(time)) {
                    setTimeout(function () {
                        // flash_layer.clear();
                        dseMap.graphics.clear();
                    }, Number(time));
                }
            };
            //
            /*
             * showInfoWindow属性窗体的创建(lgtd:显示位置的经度;lttd:显示位置的纬度;content:窗体html信息;
             * title:窗体标题;width:宽度,默认270px;iscolse:是否关闭，默认false显示)
             */
            self.showInfoWindow = function (lgtd, lttd, content, title, width, iscolse) {
                if (!lgtd || !lttd || !content) {
                    return;
                }
                dseMap.infoWindow.setContent(content);
                $(".titlePane").css("backgroundColor", "#1468b4"); //标题栏的背景颜色
                $(".titlePane").css("font-size", "15px"); //标题栏的字体大小
                if (width && width != "") {
                    $(".sizer").css("width", width);
                }
                else {
                    $(".sizer").css("width", "270px");
                }
                dseMap.infoWindow.setTitle(dseGisUtils.nullToSpace(title));
                if (iscolse && iscolse == true) {
                    $(".close").css("display", "none");
                }
                //移除按钮
                $(".maximize").remove();
                dseMap.infoWindow.show(new Point(lgtd, lttd, dseMap.spatialReference)); //new Point(113.343125,23.987933)
            };
            /**
             * 弹出对话框，弹出框内容可引入其它html页面
             * */
            self.showInfoWindowFrom = function (title, url, width, height) {
                //
                var top = $(document).height() / 2 - height / 2;
                //
                console.log(top);
                //
                var left = $(document).width() / 2 - width / 2;
                layer.open({
                    type: 2,
                    title: title,
                    shadeClose: false,
                    shade: 0.3,
                    area: [width + 'px', height + 'px'],
                    content: url,
                    closeBtn: 1,
                    offset: [top + "px", left + "px"]
                });
                //
                self.layerUtils = layerUtils;
            };
            //
            self._legend = null;
            self._layerCtrl = null;
            self._layerCtrlAsync = null;
            //
            self.initMap = function (container, opt) {
                dseMap = self.getMap(container);
                //
                dseMap.on("load", function (event) {
                    //底图加载完成后平移到指定位置
                    if (DseGisConfig.fullExtent) {
                        self.showExtent(DseGisConfig.fullExtent);
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
                this.utils.gp = new DseGPUtils({
                    //
                    urls: DseGisConfig.gpUrls,
                    map: dseMap
                });
                //
                this.utils.geo = new DseGeoUtils({
                    //
                    map: dseMap,
                    editLayer: null,
                    url: "" //
                });
                //
                this.utils.gra = new DseGraphicUtils({
                    map: dseMap,
                    mapType: DseGisConfig.mapType
                });
                //
                this.utils.sym = dseSymbolUtils;
                //
                this.utils.layer = layerUtils;
                //
                layerUtils.loadBaseLayers(DseGisConfig.baseMapLayers);
                //显示地图切换控件 不显示设置false
                if (opt.showMapLayerChangeBar) {
                    // changeMapType.init();
                    //
                    require(["dsegis/controls/LayerSwitchControl"], function (LayerSwitchControl) {
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
                if (opt.showMapLabel.visible) {
                    //
                    require(["dsegis/controls/MapLabelControl"], function (MapLabelControl) {
                        //
                        var mapLabel = new MapLabelControl({
                            map: dseMap,
                            type: DseGisConfig.mapType //Required
                        });
                        //
                        mapLabel.init(opt.showMapLabel.style);
                    });
                }
                //显示工具条控件，不显示设置false
                if (opt.showToolbars) {
                    //
                    require(["dsegis/controls/ToolbarControl"], function (ToolbarTool) {
                        //
                        var bar = new ToolbarTool({
                            //
                            map: dseMap,
                        });
                        //
                        bar.init();
                    });
                }
                //显示图层管理换控件 不显示设置false
                if (opt.showLayerBar) {
                    //
                    require(["dsegis/controls/LayerManControl"], function (LayerManControl) {
                        //
                        var layerCtrl = new LayerManControl({
                            //
                            map: dseMap,
                            layers: DseGisConfig.optionalLayers,
                            util: layerUtils //Required
                        });
                        //
                        layerCtrl.init();
                        //
                        self._layerCtrl = layerCtrl;
                        //
                        if (self._layerCtrlAsync && typeof self._layerCtrlAsync === "function") {
                            self._layerCtrlAsync(layerCtrl);
                        }
                    });
                }
                //显示查询框控件，不显示设置false.
                if (opt.showSearchBox) {
                    //
                    require(["dsegis/controls/SearchControl"], function (Search) {
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
                            enableSourcesMenu: false,
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
                if (opt.showMapLegend.visible) {
                    //
                    //
                    require(["dsegis/controls/MapLegend"], function (MapLegend) {
                        //
                        var legendCtn = domConstruct.create("div", {
                            // id: "legend"
                            class: opt.showMapLegend.style
                        }, document.body);
                        //
                        var legend = new MapLegend({
                            map: dseMap,
                            config: DseGisConfig.mapLegend.sources,
                            autoUpdate: false,
                            legendType: DseGisConfig.mapLegend.type,
                            itemStyle: DseGisConfig.mapLegend.itemStyle
                        }, legendCtn);
                        //
                        self._legend = legend;
                        //
                        if (self._legendAsync && typeof self._legendAsync === "function") {
                            self._legendAsync(legend);
                        }
                    });
                }
                //加载行政区划导航控件
                if (opt.showMapRegion) {
                    //
                    require(["dsegis/controls/RegionControl"], function (RegionControl) {
                        //
                        var domCtn = domConstruct.create("div", {}, document.body);
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
                        });
                        // testCtrl.placeAt(document.body);
                    });
                }
                //添加闪烁图层.
                /*flash_layer = layerUtils.addLayer({
                 id: 'flash_layer',
                 type: "graphic"
                 });*/
                //设置全局变量，供其他模块引用地图。
                window.dseMap = dseMap;
                return dseMap;
            };
        },
        //
        utils: {
            //几何图形处理工具
            geo: null,
            //符号创建通用工具
            sym: null,
            //gp服务通用工具
            gp: null,
            //几何图形辅助工具
            gra: null,
            layer: null
        },
        //
        addLayer: function (options) {
            return this.layerUtils.addLayer(options);
        },
        //
        addMapControl: function (options) {
            //
            //
            var dseMap = window.dseMap;
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
        //
        /**同步方式刷新图例*/
        showLegendView: function (layers, itemStyle, cb) {
            //
            if (this._legend) {
                this._legend.refresh(layers, itemStyle);
            }
            else {
                this._legendAsync = cb;
            }
        },
        /**设置图例大小*/
        resizeLegend: function (width, height, cb) {
            //
            //
            if (this._legend) {
                this._legend.resize(width, height);
            }
            else {
                //
                this._legendAsync = cb;
            }
        },
        /**设置图层管理器大小*/
        resizeLayerCtrl: function (width, height, cb) {
            if (this._layerCtrl) {
                this._layerCtrl.resize(width, height);
            }
            else {
                this._layerCtrlAsync = cb;
            }
        }
        /**
         * 框架通用工具类.
         * */
        // showInfoWindowFrom: showInfoWindowFrom
    });
    //
    return clazzO;
});
//# sourceMappingURL=DseGisBaseCore.js.map