/**
 * Created by Administrator on 2016/11/15.
 */
define(["dojo/_base/declare",
    "dse_gis/controls/_BaseControl",
    "dojo/_base/lang",
    "dojo/dom",
    "dojo/dom-style",
    "dojo/dom-construct",
    "esri/domUtils",
    "dojo/on",
    "esri/layers/FeatureLayer",
    "esri/InfoTemplate",
    "esri/dijit/Search",
    "dojo/query",
    "dojo/_base/window",
    "esri/dijit/Legend",
    "dojo/string",
    "esri/layers/TiledMapServiceLayer",
    "dojo/_base/array"
    // "xstyle!./styles/TestControl.css"
], function (declare, _BaseControl, lang, dom, domStyle, domConstruct, domUtils, on, FeatureLayer, InfoTemplate, Search, query, win, Legend, string, TiledMapServiceLayer, arrayUtils) {
    //
    return declare([_BaseControl], {
        //
        baseClass: "",
        constructor: function (options, domNode) {
            //
            lang.mixin(this, options);
            // self = this;
            //
            this._baseConfig = lang.clone(options.config);
            // console.log(JSON.stringify(this._baseConfig));
            this.legendType = options.config[0].type;
            this._domNode = domNode;
            //
            this.legendState = true;
            //
            this._init(domNode, options);
            // var legend
        },
        //
        _init: function (domNode, options) {
            //
            var self = this;
            //
            self._createLegendConfig = function () {
                //
                var ids = self.map.graphicsLayerIds;
                var results = self._baseConfig;
                //
                if (ids && ids.length > 0) {
                    var lc = ids.length;
                    for (var i = 0; i < lc; i++) {
                        //
                        var gl = self.map.getLayer(ids[i]);
                        //
                        if (gl && gl.visible && gl.legendInfo) {
                            results = results.concat(gl.legendInfo);
                        }
                    }
                }
                return results;
            };
            //
            self._bindLayerChangeEvent = function () {
                //
                self.appEvent.addAppEventListener(self.appEvent.LEGEND_STATE_CHANGE, function (data) {
                    //
                    var dseLayer = data.layer;
                    //
                    if (!data.layerItem.checked) {
                        //remove layer legend.
                        if (!data.isShowShareLegend) {
                            //
                            var layerId = data.legendShare ? data.legendShare.legendId : data.id;
                            self._removeLayerLegend(layerId);
                        }
                    }
                    else {
                        //check layer legend information.
                        var info = dseLayer.legendInfo;
                        //
                        if (data.isCanLoaded) {
                            //
                            var lgn11 = self._queryLegendInfoFomCache(dseLayer.id);
                            //
                            if (lgn11) {
                                //
                                if (data.legendShare) {
                                    lgn11.legendShare = data.legendShare;
                                }
                                self._createLayerLegend(domNode, lgn11);
                            }
                            else {
                                //
                                if (info) {
                                    if (data.legendShare) {
                                        info.legendShare = data.legendShare;
                                    }
                                    var lgn = self._createLayerLegend(domNode, info);
                                }
                            }
                        }
                    }
                });
            };
            //
            self._queryLegendInfoFomCache = function (layerId) {
                //
                var lgns = self._baseConfig;
                //
                var items = lgns.filter(function (lgn) {
                    //
                    return lgn.layerId === layerId;
                });
                //
                return (items && items.length > 0) ? items[0] : null;
            };
            /**
             * create legend  for layer.
             * */
            self._createLayerLegend = function (domNode, lgn11) {
                //
                //
                //
                //
                var layerId = lgn11.legendShare ? lgn11.legendShare.legendId : lgn11.layerId;
                var item = document.getElementById(layerId + "_legend");
                if (!item) {
                    //
                    var ins = lgn11.sources;
                    //
                    if (ins && ins.length > 0) {
                        //
                        var listItem = domConstruct.create("li", {
                            id: layerId + "_legend"
                        }, domNode);
                        //
                        var innerHtml = "";
                        //
                        if (lgn11.layerName) {
                            innerHtml = "<strong>" + lgn11.layerName + "</strong>:";
                        }
                        //
                        arrayUtils.forEach(ins, function (info, iindex) {
                            //
                            if (lgn11.itemStyle === "color") {
                                //以颜色作为图例
                                var template = "<div style='${mStyle}'></div><div class='u-lgn-lbl'>${name}</div>";
                                var lgn = string.substitute(template, {
                                    mStyle: "display: inline-block;border-radius: " + info.size[0] + "px;" + "background:" + info.color + ";width: " + info.size[0] + "px;height:" + info.size[1] + "px;",
                                    name: info.name
                                });
                                //
                                innerHtml += lgn;
                            }
                            else if (lgn11.itemStyle === "icon") {
                                //以图片作为图例
                                var template2 = "<img src='${url}' alt='noData' width='${width}' height='${height}'><span>${name}</span>";
                                //
                                var lgn2 = string.substitute(template2, {
                                    url: info.icon,
                                    name: info.name,
                                    width: info.size[0] + "px",
                                    height: info.size[1] + "px"
                                });
                                innerHtml += lgn2;
                            }
                        });
                    }
                    //
                    $(listItem).html(innerHtml)
                        .addClass("list-group-item");
                    item = listItem;
                }
                return item;
            };
            //
            self._removeLayerLegend = function (layerId) {
                //
                var legendId = "#" + layerId + "_legend";
                var legend = $(legendId);
                //
                if (legend) {
                    legend.remove();
                }
            };
            //
            //
            /**
             * 读取配置文件，生成图例信息.
             * */
            self._queryLegendLayers = function () {
                //
                var results = [];
                //
                var ids = self.map.layerIds;
                //
                ids.forEach(function (id) {
                    //
                    var lyr = self.map.getLayer(id);
                    if (lyr.visible && !(lyr instanceof TiledMapServiceLayer)) {
                        //
                        results.push({
                            layer: lyr,
                            title: " "
                        });
                    }
                });
                return results;
            };
            //
            self._initMapLayersLegend = function (lgns) {
                //
                lgns.forEach(function (lgn) {
                    //
                    if (lgn.initShow) {
                        self._createLayerLegend(domNode, lgn);
                    }
                });
            };
            /******创建图例控件UI信息.****/
            if (this.legendType === "ags") {
                //
                //
                this.baseCtn = domConstruct.create("div", {
                    //
                    class: "m-map-legend"
                }, domNode);
                this.legendWidget = new Legend(options, this.baseCtn);
                //
                this.legendWidget.startup();
                //
                this.legendWidget.refresh([]);
                //
            }
            else if (this.legendType === "single") {
                //
                var info = this.config;
                // add new layer legend.
                this._initMapLayersLegend(info);
            }
            //
            this._bindLayerChangeEvent();
            //
        },
        /**
         * 刷新图例.
         * */
        refresh: function (layers, itemStyle) {
            //
            // lyr.setReaderer();
            this.itemStyle = itemStyle;
            //
            this._baseConfig = layers;
            domConstruct.empty(this.customCtn);
        },
        //
        /**
         * 添加需要显示的图层.
         * */
        addLegendLayer: function (lyr) {
            //
        },
        //
        startup: function () {
            //
        },
        //
        destroy: function () {
            //
            this.inherited(arguments);
        },
        //
        resize: function (width, height) {
            //
            $(this._domNode).css({
                width: width + "px",
                height: height + "px"
            });
        }
    });
});
//# sourceMappingURL=LegendAccMan.js.map