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
            this._loadedTabViews = {};
            //
            this._init(domNode, options);
            // var legend
        },
        //
        _init: function (domNode, options) {
            //
            var self = this;
            //
            //
            self.lgnSuffix = "lgn_tab";
            //
            self.addLegendAttr = function (data, lgn11) {
                //
                if (data.legendShare) {
                    lgn11.legendShare = data.legendShare;
                }
                var layerId = lgn11.legendShare ? lgn11.legendShare.legendId : lgn11.layerId;
                var layerName = lgn11.legendShare ? lgn11.legendShare.layerName : lgn11.layerName;
                self.loadLegendTabView({
                    lgn11: lgn11,
                    domTitle: self.domTitle,
                    domContent: self.domContent,
                    layerItem: data.layerItem,
                    id: layerId,
                    visible: data.layerItem.checked,
                    name: layerName
                });
            };
            //
            self.activeLastTab = function (info) {
                this._hideTabPageView(info);
                //
                var visibleItem = this._findVisibleTabPages();
                //
                if (visibleItem) {
                    $(visibleItem).addClass("active");
                    //
                    var content = $(visibleItem).attr("data-flag");
                    $("#" + content)
                        .addClass("in active")
                        .show();
                }
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
                            self._removeLayerLegend(layerId + self.lgnSuffix);
                            //
                            self.activeLastTab({ id: layerId });
                        }
                    }
                    else {
                        //check layer legend information.
                        var info = dseLayer.legendInfo;
                        if (data.isCanLoaded) {
                            //
                            var lgn11 = self._queryLegendInfoFomCache(dseLayer.id);
                            //
                            if (lgn11) {
                                //
                                self.addLegendAttr(data, lgn11);
                                // self._createLayerLegend(domNode, lgn11);
                            }
                            else {
                                //
                                if (info) {
                                    self.addLegendAttr(data, info);
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
                var layerId = lgn11.legendShare ? lgn11.legendShare.legendId : lgn11.layerId;
                var item = document.getElementById(layerId + "_legend");
                if (!item) {
                    //
                    var ins = lgn11.sources;
                    //
                    if (ins && ins.length > 0) {
                        //
                        var list = domConstruct.create("ul", {
                            id: layerId + "_legend"
                        }, domNode);
                        var listItem = domConstruct.create("li", {}, list);
                        //
                        var innerHtml = "";
                        //
                        /*if (lgn11.layerName) {
                         innerHtml = "<strong>" + lgn11.layerName + "</strong>:";
                         }*/
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
                var $title = $("[data-flag=" + layerId + "]").remove();
                var $content = $("#" + layerId).remove();
            };
            //
            self._initMapLayersLegend = function (lgns) {
                //
                lgns.forEach(function (lgn) {
                    //
                    if (lgn.initShow) {
                        //
                        var data = {
                            layerItem: { checked: true }
                        };
                        self.addLegendAttr(data, lgn);
                    }
                });
            };
            //
            this._initMapLayersLegend(this.config);
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
        },
        /**
         *  <div id="zhjs-content" class="tab-content">

         <div class="tab-pane fade in active" id="hqfbt-nyhq">
         * */
        _createTabPageContent: function (info) {
            //
            var domNode = info.domContent;
            var contentPanel = domConstruct.create("div", {
                //
                id: info.id + this.lgnSuffix
            }, domNode);
            //
            // $(contentPanel).addClass("tab-pane fade");
            if (info.visible) {
                //
                $(contentPanel).addClass("tab-pane fade in active");
            }
            else {
                $(contentPanel).addClass("tab-pane fade");
            }
            return contentPanel;
        },
        /**
         *  <li class="active"><a href="#hqfbt-nyhq" data-toggle="tab">
         农业旱情
         </a>
         </li>
         * */
        _createTabPageTitle: function (info) {
            //
            var template = '<a href="#${id}" data-toggle="tab">${name}</a>';
            //
            var domNode = info.domTitle;
            var innerHtml = string.substitute(template, {
                id: info.id + this.lgnSuffix,
                name: info.name
            });
            var liNode = domConstruct.create("li", {
                //
                innerHTML: innerHtml,
                "data-flag": info.id + this.lgnSuffix,
            }, domNode);
            //
            return liNode;
        },
        /**创建图层tab page.*/
        loadLegendTabView: function (info) {
            //
            var self = this;
            if (info.layerItem.checked) {
                //
                var tab = document.getElementById(info.id + self.lgnSuffix);
                if (tab) {
                    //
                    self._activateTabPage(info);
                }
                else {
                    //
                    var tabTitle = this._createTabPageTitle(info);
                    //
                    on(tabTitle, "click", function (event) {
                        //
                        var tabId = this.getAttribute("data-flag");
                        self._hideOtherTabPage(tabId);
                    });
                    var contentView = this._createTabPageContent(info);
                    //
                    this._createLayerLegend(contentView, info.lgn11);
                    this._activateTabPage(info);
                }
            }
            else {
                //
                this._hideTabPageView(info);
                //
                var visibleItem = this._findVisibleTabPages();
                //
                if (visibleItem) {
                    $(visibleItem).addClass("active");
                    //
                    var content = $(visibleItem).attr("data-flag");
                    $("#" + content)
                        .addClass("in active")
                        .show();
                }
            }
        },
        _hideOtherTabPage: function (tabId) {
            //
            var tabs = $("#legend-tabs>.tab-pane");
            //
            tabs.each(function (idx, tab) {
                //
                if (tab.id !== tabId) {
                    //
                    $(tab).hide();
                }
                else {
                    $(tab).show();
                }
            });
        },
        _findVisibleTabPages: function () {
            //
            var results = [];
            var tabs = $("#legend-tabs li[data-flag]");
            tabs.each(function (iindex, item) {
                //
                if ($(item).css("display") === "block") {
                    //
                    $(item).removeClass("active");
                    results.push(item);
                }
                //
            });
            return (results && results.length > 0) ? results[results.length - 1] : null;
        },
        _hideTabPageView: function (info) {
            //
            var id = "#" + info.id + this.lgnSuffix;
            var tabTitle = $("#legend-tabs li[data-flag='" + info.id + this.lgnSuffix + "']");
            //
            var tabContent = $(id);
            //
            tabTitle.removeClass("active");
            tabContent.removeClass().addClass("tab-pane fade");
            //
            tabContent.hide();
            tabTitle.hide();
        },
        _activateTabPage: function (info) {
            //
            // this._showTabPageView(info);
            this._hideOtherTabPage(info.id + this.lgnSuffix);
            var idx = this._findTabIndex(info.id + this.lgnSuffix);
            // console.log("title id: "+info.domTitle.id);
            if (idx !== -1) {
                var target = $('#' + info.domTitle.id + ' li:eq(' + idx + ') a');
                target.tab("show");
                // $('#' + info.domTitle.id + ' li:eq(' + idx + ') a').tab('show');
            }
        },
        _findTabIndex: function (id) {
            var index = -1;
            //
            var cid = "#" + id;
            var tabs = $("#legend-tabs a[data-toggle='tab']");
            if (tabs && tabs.length > 0) {
                var ct = tabs.length;
                //
                for (var i = 0; i < ct; i++) {
                    //
                    var tab = tabs[i];
                    //
                    if (tab.hash === cid) {
                        index = i;
                        break;
                    }
                }
            }
            return index;
        },
    });
});
//# sourceMappingURL=LegendTabMan.js.map