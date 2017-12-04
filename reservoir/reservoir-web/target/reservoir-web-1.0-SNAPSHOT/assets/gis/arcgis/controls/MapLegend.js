/**
 * Created by Administrator on 2016/8/6.
 */
define(["dojo/_base/declare",
    "./_BaseControl",
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
    "esri/layers/TiledMapServiceLayer"
    // "xstyle!./styles/TestControl.css"
], function (declare, _BaseControl, lang, dom, domStyle, domConstruct, domUtils, on, FeatureLayer, InfoTemplate, Search, query, win, Legend, string, TiledMapServiceLayer) {
    //
    // var self = null;
    //
    // var this.legendWidget = null;
    //
    // var this.legendType = "";//multi || single.
    //
    // var this.baseCtn = null;
    // var this.customCtn = null;
    // var this.legendState = true;
    // var this._domNode = null;
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
            this.legendType = options.legendType;
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
                    if (data.type === "ags") {
                        //
                        //
                        if (self.legendWidget) {
                            domUtils.show(self.legendWidget);
                            //
                            var layers = self._queryLegendLayers();
                            //
                            self.legendWidget.refresh(layers);
                        }
                        //
                    }
                    else if (data.type === "single") {
                        //
                        if (data.visible || data.isStateChanged) {
                            //
                            //
                            // domConstruct.empty(self._domNode);
                            if (self.customCtn) {
                                domConstruct.destroy(self.customCtn);
                            }
                            self.customCtn = domConstruct.create("ul", {
                                //
                                class: "m-map-legend"
                            }, self._domNode);
                            //
                            self.config = self._createLegendConfig();
                            self._createCustomLegend(self.config, self.customCtn);
                            domUtils.show(self.customCtn);
                        }
                        else {
                            //
                            domUtils.hide(self.customCtn);
                        }
                        //
                    }
                });
            };
            //
            /**
             *
             * */
            //
            //
            self._createCustomLegend = function (infos, domNode) {
                //
                // domConstruct.empty(domNode);
                //
                var isNoData = false;
                //
                infos.forEach(function (info) {
                    //
                    //
                    /*var template = "<img src='${url}' alt='noData' width='${width}' height='${height}'><span>${name}</span>";
                     var li = domConstruct.create("li", {

                     //
                     innerHTML: string.substitute(template, {
                     url: info.icon,
                     name: info.name,
                     width: info.size[0] + "px",
                     height: info.size[1] + "px"
                     })
                     }, domNode);*/
                    //
                    if (self.itemStyle === "color") {
                        //以颜色作为图例
                        var template = "<div style='${mStyle}'></div><div class='u-legend-label'>${name}</div>";
                        var li = domConstruct.create("li", {
                            innerHTML: string.substitute(template, {
                                mStyle: "display: inline-block;background:" + info.color + ";width: " + info.size[0] + "px;height:" + info.size[1] + "px;",
                                name: info.name
                            })
                        }, domNode);
                    }
                    else if (self.itemStyle === "icon") {
                        //以图片作为图例
                        var template2 = "<img src='${url}' alt='noData' width='${width}' height='${height}'><span>${name}</span>";
                        var li = domConstruct.create("li", {
                            //
                            innerHTML: string.substitute(template2, {
                                url: info.icon,
                                name: info.name,
                                width: info.size[0] + "px",
                                height: info.size[1] + "px"
                            })
                        }, domNode);
                    }
                    else {
                        isNoData = true;
                    }
                    /*var template = "<div style='${mStyle}'></div><div class='u-legend-label'>${name}</div>";
                     var li = domConstruct.create("li", {

                     /!**
                     *     background: green;
                     width: 32px;
                     height: 23px;
                     display: inline-block;
                     *
                     * *!/
                     //
                     innerHTML: string.substitute(template, {
                     mStyle: "display: inline-block;background:" + info.color + ";width: " + info.size[0] + "px;height:" + info.size[1] + "px;",
                     name: info.name
                     })
                     }, domNode);*/
                    //
                });
                if (isNoData) {
                    var li = domConstruct.create("li", {
                        //
                        innerHTML: "无图例信息",
                        style: "margin-left: 12%;font-size: 16px;color: red;"
                    }, domNode);
                }
                //
                return domNode;
            };
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
                //
                var closeBtn = domConstruct.create("div", {
                    innerHTML: "<h4>图例</h4>",
                    // src:dseGisPath+styleName+"/img/clear.png",
                    class: "m-legend-title"
                }, domNode);
                //
                this.customCtn = domConstruct.create("ul", {
                    //
                    class: "m-map-legend"
                }, domNode);
                //
                on(closeBtn, "click", function (event) {
                    //
                    if (self.legendState) {
                        //
                        domUtils.hide(self.customCtn);
                        self.legendState = false;
                    }
                    else {
                        domUtils.show(self.customCtn);
                        self.legendState = true;
                    }
                });
                var info = this.config;
                this._createCustomLegend(info, this.customCtn);
            }
            //
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
            this._createCustomLegend(layers, this.customCtn);
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
//# sourceMappingURL=MapLegend.js.map