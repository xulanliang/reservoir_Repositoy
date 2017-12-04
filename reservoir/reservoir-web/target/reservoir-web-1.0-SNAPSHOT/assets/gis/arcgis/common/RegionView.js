/**
 * Created by Administrator on 2016/10/20.
 */
define(["dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/dom",
    "dojo/dom-style",
    "dojo/dom-construct",
    "esri/domUtils",
    "dojo/on",
    "dojo/query",
    "dojo/_base/window",
    "esri/tasks/QueryTask",
    "esri/tasks/query",
    "dse_gis/utils/PopupUtils",
    "dse_gis/utils/dseSymbolUtils",
    "dojo/_base/array",
    "esri/layers/GraphicsLayer",
    "esri/graphicsUtils"
], function (declare, lang, dom, domStyle, domConstruct, domUtils, on, query, win, QueryTask, Query, PopupUtils, dseSymbolUtils, arrayUtils, GraphicsLayer, graphicsUtils) {
    //
    return declare(null, {
        //
        constructor: function (url, options) {
            //
            lang.mixin(this, options);
            this._init(url, options);
        },
        _init: function (url, options) {
            //
            var self = this;
            //
            var displayLayer = new GraphicsLayer({
                //
                id: "g_region_hq"
            });
            //
            self.map.addLayer(displayLayer);
            var queryTask = new QueryTask(url);
            var query = new Query();
            query.outFields = ["ADCD", "NAME"];
            query.returnGeometry = true;
            self._loadedRegions = {};
            //
            var popupUtils = new PopupUtils(this.map, options);
            //
            self._queryCompleted = function (data) {
                //
                // self._loadedRegions = {};
                var graphic = data.features.length > 0 ? data.features[0] : null;
                if (graphic) {
                    //
                    self._loadedRegions[self.code] = graphic;
                    self._showGra(graphic);
                }
                //
            };
            //
            self._showGra = function (graphic) {
                //
                if (graphic) {
                    //
                    graphic.data = self.infoData;
                    //
                    var symbol = dseSymbolUtils.createSimpleFillSymbol({});
                    graphic.setSymbol(symbol);
                    if (self.visible) {
                        //
                        popupUtils.showInfoWindow(graphic);
                    }
                    //
                    var extent = graphic.geometry.getExtent();
                    //
                    self.map.setExtent(extent);
                    //
                    if (self._isGraVisible) {
                        //
                        self.map.graphics.clear();
                        //
                        self.map.graphics.add(graphic);
                    }
                }
                //
            };
            self._queryError = function (error) {
                //
                console.log("error in RegionView.js file \n" + JSON.stringify(error));
            };
            //
            self._loadSingleRegion = function (code) {
                //
                if (code) {
                    query.where = "ADCD  = '" + code + "'";
                    //
                    queryTask.execute(query, self._queryCompleted, self._queryError);
                }
            };
            self._loadBatchRegions = function (codes) {
                //
                if (codes && codes.length > 0) {
                    query.where = "ADCD in" + self._createQueryParam(codes);
                    //
                    queryTask.execute(query, lang.hitch(this, function (data) {
                        //
                        // displayLayer.clear();
                        var features = data.features;
                        if (features && features.length > 0) {
                            //
                            arrayUtils.forEach(features, function (feature, iindex) {
                                //
                                //
                                var regionCode = feature.attributes["ADCD"];
                                feature.data = self._cacheData[regionCode];
                                var symbol = self.hqSymbolParser(feature.data);
                                //
                                if (!symbol) {
                                    symbol = dseSymbolUtils.createSimpleFillSymbol({});
                                }
                                feature.setSymbol(symbol);
                                //
                                //
                                displayLayer.add(feature);
                            });
                            //缩放到结果集
                            //
                            var viewExtent = graphicsUtils.graphicsExtent(features);
                            self.map.setExtent(viewExtent);
                        }
                    }), lang.hitch(this, function (error) {
                        //
                        console.log("获取行政区划信息失败： " + JSON.stringify(error));
                    }));
                }
            };
            //
            self.setInfoTips = function (template) {
                //
            };
            //
            self.hqSymbolParser = function (data) {
                //
            };
            /**
             * 导航到指定行政区划。
             * */
            self.skipToRegionView = function (data, isGraShowing, isInfoShowing) {
                //
                //
                self.code = data["CODE"];
                self._isGraVisible = isGraShowing;
                //
                var gra = self._loadedRegions[self.code];
                //
                self.visible = isInfoShowing;
                // delete data.adcd;
                //
                self.infoData = data;
                // self.isShowing = isShowing;
                if (gra) {
                    //navigate to map view.
                    self._showGra(gra);
                }
                else {
                    //load remote data.
                    self._loadSingleRegion(self.code);
                }
            };
            //设置弹出框模板。
            self.setRegionViewPopup = function (template) {
                //
                if (self._lastTemplate.url != template.url) {
                    popupUtils.setTemplate(template);
                    popupUtils.isRefreshData = true;
                    self._lastTemplate = template;
                }
            };
            //
            self._lastTemplate = {
                url: "test"
            };
            /**显示旱情分布地图信息*/
            self.showHqInfoToMapView = function (regions, isShowing) {
                //
                var codes = [];
                // self._isBatch = isBatch;
                //
                displayLayer.clear();
                self._cacheData = {};
                self.showTips = isShowing;
                //
                arrayUtils.forEach(regions, function (region) {
                    //
                    self._cacheData[region["CODE"]] = region;
                    codes.push(region["CODE"]);
                });
                //
                self._loadBatchRegions(codes);
            };
            /**构造查询参数.*/
            self._createQueryParam = function (codes) {
                //
                var queryString = "(";
                codes.forEach(function (info) {
                    //
                    if (info) {
                        queryString += "'" + info + "',";
                    }
                });
                //
                return queryString.substring(0, queryString.length - 1) + ")";
            };
            //
            self._createTipsContainer = function (isCreate) {
                //
                var domNode = null;
                if (isCreate) {
                    //
                    domNode = domConstruct.create("div", {}, dom.byId(self.map.id));
                    domStyle.set(domNode, {
                        "display": "none",
                        "position": "absolute",
                        "z-index": 99,
                        // "background": "#fcffd1",
                        "font-size": "14px",
                        "border": "1px solid #0096ff",
                        "padding": "0.1em 0.3em 0.1em",
                        "border-radius": "3px",
                        "box-shadow": "0 0 0.75em #777777",
                        "overflow": "hidden",
                    });
                }
                //
                return domNode;
            };
            //
            self._showGraphicTips = function (loc, content) {
                //
                domStyle.set(self.tipsCtn, {
                    "left": loc.x + 15 + "px",
                    "top": loc.y + 5 + "px"
                });
                this.tipsCtn.innerHTML = content;
                domUtils.show(self.tipsCtn);
            };
            //
            self._layerMouseMoveHandler = function (event) {
                //
                // console.log("test");
                var graphic = event.graphic;
                var screenPoint = event.screenPoint;
                //
                var content = self._createTipsContent(graphic, self.showFields);
                self._showGraphicTips(screenPoint, content);
            };
            self.showFields = [];
            //
            self.tipsCtn = self._createTipsContainer(true);
            //
            self._handlers = [];
            //
            self._addEventListeners = function () {
                //
                if (displayLayer) {
                    var h1 = displayLayer.on("mouse-move", self._layerMouseMoveHandler);
                    var h2 = displayLayer.on("mouse-out", function (event) {
                        //
                        if (self.tipsCtn) {
                            //
                            domUtils.hide(self.tipsCtn);
                            // $(this.tipsCtn).hide();
                        }
                    });
                    //
                    self._handlers = [h1, h2];
                }
            };
            self._removeEventListeners = function () {
                //
                var hs = self._handlers;
                //
                if (hs && hs.length > 0) {
                    hs.forEach(function (handler) {
                        //
                        handler.remove();
                    });
                }
            };
            //
            self.clearLayer = function () {
                //
                displayLayer.clear();
            };
            //
            self.saveCacheData = function () {
                //
                var results = [];
                var gs = displayLayer.graphics;
                if (gs && gs.length > 0) {
                    //
                    gs.forEach(function (g) {
                        //
                        results.push(g);
                    });
                }
                return results;
            };
            self.restoreCacheData = function (gs) {
                //
                displayLayer.clear();
                if (gs && gs.length > 0) {
                    gs.forEach(function (g) {
                        displayLayer.add(g);
                    });
                }
            };
            //
            self.clearCacheData = function (cacheData) {
                //
                if (cacheData) {
                    for (var key in cacheData) {
                        //
                        cacheData[key] = [];
                    }
                }
            };
            //
            self._changeLayerState = function (layerId) {
                //
                var ids = self.map.graphicsLayerIds;
                self._changeLayerStateById(ids, layerId);
                self._changeLayerStateById(self._extraIds, layerId);
            };
            //
            self._changeLayerStateById = function (extras, layerId) {
                //
                if (extras && extras.length > 0) {
                    //
                    extras.forEach(function (extra) {
                        //
                        var layer = self.map.getLayer(extra);
                        if (layer) {
                            if (layer.id === layerId) {
                                layer.show();
                            }
                            else {
                                layer.hide();
                            }
                        }
                    });
                }
            };
            //
            self.setExtraLayerIds = function (ids) {
                //
                self._extraIds = ids;
            };
            /**
             * 设置显示图层状态
             * */
            self.changeGraLayerState = function (layer) {
                //
                //
                // self._extraLayers = [];
                self._removeEventListeners();
                displayLayer = layer;
                self._changeLayerState(displayLayer.id);
                self._addEventListeners();
                //
                var app = window.appEvent;
                app.dispatchAppEvent(app.MODULE_LAYER_CHANGE, { state: true });
            };
            /***/
            self.setNoBindingInfoLayer = function (layer) {
                //
                displayLayer = layer;
                self._changeLayerState(displayLayer.id);
            };
            //
            self.isInArray = function (items, flag) {
                var results = items.some(function (item) {
                    //
                    return item === flag;
                });
                return results;
            };
            //
            /**
             * 设置动态图层状态
             * */
            self.changeDynamicLayerState = function (ids, showIds) {
                if (ids && ids.length > 0) {
                    //
                    //
                    var items = [];
                    var ic = ids.length;
                    for (var i = 0; i < ic; i++) {
                        //
                        var dl = self.map.getLayer(ids[i]);
                        if (dl) {
                            //
                            if (self.isInArray(showIds, ids[i])) {
                                //
                                dl.show();
                                items.push({
                                    id: dl.id,
                                    name: dl.name,
                                    checked: dl.visible
                                });
                            }
                            else {
                                dl.hide();
                            }
                        }
                    }
                    //
                    var app = window.appEvent;
                    //
                    app.dispatchAppEvent(app.MODULE_LAYER_CHANGE, {
                        layers: items
                    });
                }
            };
            //
            self._addEventListeners();
        },
        //
        getObjectValues: function (obj) {
            var items = [];
            if (obj) {
                for (var key in obj) {
                    //
                    if (obj.hasOwnProperty(key)) {
                        items.push(obj[key]);
                    }
                }
            }
            return items;
        },
        getObjectKeys: function (obj) {
            //
            var items = [];
            if (obj) {
                for (var key in obj) {
                    //
                    if (obj.hasOwnProperty(key)) {
                        items.push(key);
                    }
                }
            }
            return items;
        },
        _createTipsContent: function (gra, fields) {
            //
            var content = "";
            fields.forEach(function (field) {
                //
                for (var key in field) {
                    var v = field[key];
                    content += key + ":" + gra.data[v] + "<br>";
                }
            });
            //
            return content;
        }
    });
});
//# sourceMappingURL=RegionView.js.map