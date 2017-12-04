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
    "esri/layers/TiledMapServiceLayer",

    // "xstyle!./styles/TestControl.css"
], function (declare, _BaseControl, lang, dom, domStyle, domConstruct, domUtils, on, FeatureLayer, InfoTemplate, Search,
             query, win, Legend, string, TiledMapServiceLayer) {
    //
    var appConfig = null;
    //
    var resultsPanel = null;
    //
    var searchWidget = null;
    var self = null;
    //
    var legendWidget = null;
    //
    var legendType = "";//multi || single.

    //
    var baseCtn = null;
    var customCtn = null;
    var legendState = true;
    var _domNode = null;
    //
    return declare([_BaseControl], {
        //
        baseClass: "",
        constructor: function (options, domNode) {
            //
            lang.mixin(this, options);
            self = this;
            //
            legendType = this.legendType;
            _domNode = domNode;
            // var legend
            if (legendType === "ags") {
                //
                //
                baseCtn = domConstruct.create("div", {
                    //
                    class: "m-map-legend"
                }, domNode);
                legendWidget = new Legend(options, baseCtn);
                //
                legendWidget.startup();
                //
                legendWidget.refresh([]);
                //
            } else if (legendType === "single") {
                //
                //
                var closeBtn = domConstruct.create("div", {
                    innerHTML: "<h4>图例</h4>",
                    // src:arcgisPath+styleName+"/img/clear.png",
                    class: "m-legend-title"
                }, domNode);

                //
                customCtn = domConstruct.create("ul", {
                    //
                    class: "m-map-legend"
                }, domNode);
                //
                on(closeBtn, "click", function (event) {
                    //
                    if (legendState) {
                        //
                        domUtils.hide(customCtn);
                        legendState = false;
                    } else {
                        domUtils.show(customCtn);
                        legendState = true;
                    }

                });
                var info = this.config;
                this._createCustomLegend(info, customCtn);
            }
            //
            //
            this._bindLayerChangeEvent();

        },
        /**
         * 读取配置文件，生成图例信息.
         * */
        _queryLegendLayers: function () {
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
        },
        //
        //
        _bindLayerChangeEvent: function () {
            //
            this.appEvent.addAppEventListener(this.appEvent.LAYER_STATE_CHANGE, function (data) {
                //
                if (data.type === "ags") {
                    //
                    domUtils.show(legendWidget);
                    //
                    var layers = self._queryLegendLayers();
                    //
                    legendWidget.refresh(layers);
                    //
                } else if (data.type === "single") {
                    //
                    if (data.visible) {
                        //
                        customCtn = domConstruct.create("ul", {
                            //
                            class: "m-map-legend"
                        }, _domNode);
                        self._createCustomLegend(self.config, customCtn);
                        domUtils.show(customCtn);
                    } else {
                        //
                        domUtils.hide(customCtn);
                    }
                    //
                }

            });
        },
        //
        //
        _createCustomLegend: function (infos, domNode) {
            //
            //
            // debugger;
            /* var ctn = domConstruct.create("ul", {
             //
             class: "maplegend"
             }, domNode);*/
            //
            domConstruct.empty(domNode);
            /**
             * <ul class="legendul">
             <li>
             <label for="BJ" style="color: red"><input name="xkzlegend" type="checkbox" checked="true" value="-1" id="BJ" style="vertical-align: middle;">
             <img src="../img/A034-K.png"><span id="alertCount"> 报警(25 户)</span></label>
             </li>
             <li>
             <label for="YJ" style="color: #E55200;"><input name="xkzlegend" type="checkbox" checked="true" value="0" id="YJ" style="vertical-align: middle;">
             <img src="../img/A034-Y.png"><span id="warnCount"> 预警(3 户)</span></label>
             </li>
             <li>
             <label for="ZC" style="color: #05a43d;"><input name="xkzlegend" type="checkbox" checked="true" value="1" id="ZC" style="vertical-align: middle;">
             <img src="../img/A034-e.png"><span id="normalCount"> 正常(96 户)</span></label>
             </li>
             <li>
             <label for="SJYC" style="color: #999999"><input name="xkzlegend" type="checkbox" checked="true" value="-2" id="SJYC" style="vertical-align: middle;">
             <img src="../img/A034-g.png"><span id="abnormalCount"> 数据异常(124 户)</span></label>
             </li>
             </ul>
             *
             *
             * */
            //
            infos.forEach(function (info) {
                //
                //
                var template = "<img src='${url}' alt='noData' width='${width}' height='${height}'><span>${name}</span>";
                var li = domConstruct.create("li", {

                    //
                    innerHTML: string.substitute(template, {
                        url: info.icon,
                        name: info.name,
                        width: info.size[0] + "px",
                        height: info.size[1] + "px"
                    })
                }, domNode);
                //
            });
            //
            return domNode;
        },
        /**
         * 刷新图层.
         * */
        refresh: function (lyr) {
            //
            // lyr.setReaderer();
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
        }
    });

});

