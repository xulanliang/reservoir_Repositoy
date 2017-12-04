/**
 * Created by Administrator on 2016/8/4.
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
    "dojo/_base/window"

    // "xstyle!./styles/TestControl.css"
], function (declare, _BaseControl, lang, dom, domStyle, domConstruct, domUtils, on, FeatureLayer, InfoTemplate, Search,
             query, win) {
    //
    //
    //
    // var domNode=null;
    /**
     * widget events: onmouseenter||onmouseleave
     *
     * */

    var appConfig = null;
    //
    var resultsPanel = null;
    //
    var searchWidget = null;
    var self = null;
    //
    return declare([_BaseControl], {
        //
        user: "wangsl",
        baseClass: "",
        constructor: function (options, domNode) {
            //
            lang.mixin(this, options);
            self = this;
            //
            var sources = [];
            var srcCfgs = this.config.sources;
            if (srcCfgs) {
                //
                srcCfgs.forEach(function (info) {
                    //
                    var item = self._createQuerySource(info);
                    //
                    sources.push(item);
                });
            }
            //
            this.sources = options.sources = sources;
            searchWidget = new Search(options, domNode);
            //
            if (this.showMultiResults) {
                //
                searchWidget.on("search-results", lang.hitch(this, this._handleSearchResult));
                searchWidget.on("clear-search", lang.hitch(this, this._handleResultsClear));
                //

            }
            //
            searchWidget.startup();
        },
        //
        _createQuerySource: function (info) {
            //
            //info Object:
            // url: http://
            // title: "",//
            // template:  "Owner name: ${NAME}</br>River ID: ${RIVERID}"
            // search field: ["NAME", "RIVERID"]
            // displayField
            var item = {
                featureLayer: new FeatureLayer(info.url, {
                    //
                    infoTemplate: new InfoTemplate(info.title, info.template)
                }),
                searchFields: info.searchFields,
                // suggestionTemplate: "${NAME}, RIVERID: ${RIVERID}",
                exactMatch: false,
                outFields: ["*"],
                // name: "一级河流",
                // labelSymbol: dseSymbolUtils.createTextSymbol("${Name}"),
                placeholder: "输入查询地址",
                maxResults: 6,
                displayField: info.displayField,
                maxSuggestions: 6,
                enableSuggestions: false,
                minCharacters: 0,
                searchQueryParams: {
                    distance: 5000,
                    outSpatialReference: this.map.spatialReference,
                    returnGeometry: true
                },
                zoomScale: 100000
            };
            //
            return item;
        },
        //
        configDataLoaded: function (data) {
            // this.inherited(arguments);
            // debugger;
            // console.log(data);
        },
        //
        _handleSearchResult: function (event) {
            //
            var panels = query(".searchMenu.noResultsMenu");
            //
            domUtils.show(panels[0]);
            //
            if (!event.results) {
                //
                return;
            }
            //
            var activeSourceIndex = event.activeSourceIndex;
            //
            var resultBody = domConstruct.create("ul", {
                //
                class: "noResultBody"
            }, panels[0]);
            //
            if (activeSourceIndex === "all") {
                //
                this.sources.forEach(function (src, iindex) {
                    //
                    var key = iindex.toString();
                    var results = event.results[key];
                    //
                    if (results && results.length > 0) {
                        //
                        results.forEach(function (item, iindex) {
                            //
                            var gra = domConstruct.create("li", {
                                //
                                innerHTML: item.feature.attributes[src.displayField]
                            }, resultBody);
                            // console.log(iindex);
                            on(gra, "click", function (event) {
                                //
                                self.map.setExtent(item.extent);
                                //
                                // item.feature.setSymbol(self.highlightSymbol);
                                // item.feature.setInfoTemplate(src.featureLayer.infoTemplate);
                                // self.layer.clear();
                                //
                                // self.layer.add(item.feature);
                            });
                        });
                    }
                });
            } else {
                //
                var key = activeSourceIndex.toString();
                //
                var results = event.results[key];
                //
                results.forEach(function (item) {
                    //
                    // console.log(JSON.stringify(item.extent));
                    //
                    var item = domConstruct.create("div", {
                        //
                        innerHTML: JSON.stringify(item.extent)
                    }, resultBody);
                });

            }
        },
        //
        _handleResultsClear: function (event) {
            //
            if (this.showMultiResults) {
                //
                var ns = query(".searchMenu.noResultsMenu");
                //
                domConstruct.empty(ns[0]);
                //
                domUtils.hide(ns[0]);
            }
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

