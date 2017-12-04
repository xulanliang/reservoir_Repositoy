/**
 * Created by Administrator on 2016/10/13.
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
    "./resolution",
    "dojo/string"
    // "xstyle!./styles/TestControl.css"
], function (declare, lang, dom, domStyle, domConstruct, domUtils, on, query, win, res, string) {
    //
    /***/
    return declare(null, {
        //
        constructor: function (domNode, options) {
            //
            // lang.hitch(this, options);
            // loaded pages.
            this._loadPages = [];
            //
            this.domNode = domNode;
            //
            this.appEvent = options.appEvent;
            /**
             * {
             *      tabid:{
             *          title:"",
             *          content.
             *      }
             * }
             *
             * */
            this._loadedTabViews = {};
            //
            this._isExpand = false;
            //
            //
            this.windowWidth = $(window).width();
        },
        _init: function () {
            //
            var self = this;
            //
        },
        /**
         * <pre>切换页面.</pre>
         * @param info {Object}
         * @example {
         *            id:"",
         *            url:""}
         * */
        loadPageView: function (info, callback) {
            //
            //
            this._hideAllPageView();
            var pageView = this._findPageViewBy(info.id);
            //
            if (pageView) {
                //
                $(pageView.content).show();
            }
            else {
                //
                var widgetCtn = domConstruct.create("div", {
                    class: "u-view-ctn",
                    id: info.id
                }, this.domNode);
                //
                $(widgetCtn).load(info.url);
                //
                this._loadPages.push({
                    //
                    id: info.id,
                    content: widgetCtn
                });
            }
            if (typeof callback == 'function') {
                callback();
            }
        },
        /***/
        _findPageViewBy: function (widgetId) {
            //
            var items = this._loadPages;
            //
            var results = items.filter(function (item) {
                //
                return item.id === widgetId;
            });
            //
            return results.length > 0 ? results[0] : null;
        },
        _hideAllPageView: function () {
            //
            var views = this._loadPages;
            //array
            views.forEach(function (view) {
                //
                $(view.content).hide();
            });
        },
        /**
         * 激活当前点击的按钮.
         * */
        changeItemStateToActive: function (domNode) {
            //
            $(".u-hq-item").each(function (iindex, item) {
                //
                if ($(item).hasClass("u-hq-item-active")) {
                    //
                    $(item).removeClass("u-hq-item-active");
                }
            });
            //
            $(domNode).addClass("u-hq-item-active");
        },
        /**切换右侧面板状态*/
        changePanelState: function (arrowId, panelId) {
            //
            if (arrowId && panelId) {
                //
                var domArrow = $(arrowId);
                var domPanel = $(panelId);
                if (this._isExpand) {
                    //
                    this._isExpand = false;
                    $(domPanel).hide();
                    $(domArrow).attr("src", "./images/list-right.png").css("right", "1px");
                }
                else {
                    //
                    this._isExpand = true;
                    $(domPanel).show();
                    // change width of panel.
                    this._setArrowAndPanelPosition(domArrow, domPanel);
                }
            }
        },
        //
        _isLegendExpand: true,
        changeLegendPanelState: function (legendId, panelId) {
            //
            if (legendId && panelId) {
                var domLegend = $(legendId);
                var domPanel = $(panelId);
                //
                if (this._isLegendExpand) {
                    this._isLegendExpand = false;
                    $(domPanel).hide();
                    $(domLegend).removeClass("u-legend-open")
                        .addClass("u-legend-close")
                        .html("展开&gt;");
                }
                else {
                    this._isLegendExpand = true;
                    $(domPanel).show();
                    //right: 15px;
                    $(domLegend).removeClass("u-legend-close")
                        .addClass("u-legend-open")
                        .html("&lt;收起");
                }
            }
        },
        //
        _setArrowAndPanelPosition: function (arrow, panel) {
            //
            if (this.windowWidth >= res.RES_1600_900.width) {
                //
                $(arrow).attr("src", "./images/list-left.png").css("right", "410px");
                $(panel).css("width", "410px");
            }
            else if (this.windowWidth >= res.RES_1360_768.width && this.windowWidth < res.RES_1600_900.width) {
                //
                $(arrow).attr("src", "./images/list-left.png").css("right", "300px");
                $(panel).css("width", "300px");
            }
            else if (this.windowWidth < res.RES_1360_768.width) {
                //
                $(arrow).attr("src", "./images/list-left.png").css("right", "280px");
                $(panel).css("width", "280px");
            }
        },
        setupMainLayout: function (arrowId, panelId) {
            //
            var arrow = $(arrowId);
            var panel = $(panelId);
            //
            this._setArrowAndPanelPosition(arrow, panel);
        },
        /**
         * <pre>切换Tab页面.</pre>
         * @param info {Object}
         * @example {
         *            id:"",
         *            url:""}
         * */
        loadTabPageView: function (info, callback) {
            //
            //
            var self = this;
            var app = this.appEvent;
            if (info.layerItem.checked) {
                //
                var tab = document.getElementById(info.id);
                if (tab) {
                    //
                    this._activateTabPage(info);
                }
                else {
                    //
                    var cacheData = this._loadedTabViews[info.id];
                    //
                    if (!cacheData) {
                        var tabTitle = this._createTabPageTitle(info);
                        //
                        on(tabTitle, "click", function (event) {
                            //
                            var tabId = this.getAttribute("data-flag");
                            self._hideOtherTabPage(tabId);
                            app.dispatchAppEvent(app.PAGE_VIEW_STATE_CHANGE, info);
                            //
                        });
                        var contentView = this._createTabPageContent(info);
                        $(contentView).load(info.url);
                        //
                        //cache data.
                        this._loadedTabViews[info.id] = {
                            title: tabTitle,
                            content: contentView
                        };
                        this._activateTabPage(info);
                    }
                    else {
                        //
                        this._activateTabPage(info);
                    }
                }
            }
            else {
                //
                //
                this._hideTabPageView(info);
                //
                var visibleItem = this._findVisibleTabPages();
                //
                if (visibleItem) {
                    $(visibleItem).addClass("active");
                    //
                    var content = $(visibleItem).attr("data-flag");
                    //
                    var infoData = {
                        id: content,
                        layerItem: { checked: true }
                    };
                    app.dispatchAppEvent(app.PAGE_VIEW_STATE_CHANGE, infoData);
                    $("#" + content)
                        .addClass("in active")
                        .show();
                }
            }
            //
            // notify other module update it's states.
            //
            app.dispatchAppEvent(app.PAGE_VIEW_STATE_CHANGE, info);
            //
        },
        loadTabPageViewWithFrame: function (info, callback) {
            //
            //
            var self = this;
            if (info.layerItem.checked) {
                //
                var tab = document.getElementById(info.id);
                if (tab) {
                    //
                    this._activateTabPage(info);
                }
                else {
                    //
                    var cacheData = this._loadedTabViews[info.id];
                    //
                    if (!cacheData) {
                        var tabTitle = this._createTabPageTitle(info);
                        //
                        on(tabTitle, "click", function (event) {
                            //
                            var tabId = this.getAttribute("data-flag");
                            self._hideOtherTabPage(tabId);
                            app.dispatchAppEvent(app.PAGE_VIEW_STATE_CHANGE, info);
                            //
                        });
                        var contentView = this._createTabPageContent(info);
                        //<iframe width="100%" height="100%" frameborder="none" name="widgetContainer" ></iframe>
                        var iframe = document.createElement("iframe");
                        iframe.frameborder = "none";
                        iframe.name = "widgetContainer";
                        iframe.src = info.url;
                        iframe.width = "100%";
                        iframe.height = "100%";
                        $(iframe).addClass("u-widget-ctn");
                        contentView.appendChild(iframe);
                        // $(contentView).load(info.url);
                        //
                        //cache data.
                        this._loadedTabViews[info.id] = {
                            title: tabTitle,
                            content: contentView
                        };
                        this._activateTabPage(info);
                    }
                    else {
                        //
                        this._activateTabPage(info);
                    }
                }
            }
            else {
                //
                //
                this._hideTabPageView(info);
                //
                var visibleItem = this._findVisibleTabPages();
                //
                if (visibleItem) {
                    $(visibleItem).addClass("active");
                    //
                    var content = $(visibleItem).attr("data-flag");
                    //
                    $("#" + content)
                        .addClass("in active")
                        .show();
                }
            }
            //
            // notify other module update it's states.
            var app = this.appEvent;
            //
            app.dispatchAppEvent(app.PAGE_VIEW_STATE_CHANGE, info);
            //
        },
        //
        _findVisibleTabPages: function () {
            //
            var results = [];
            var tabs = $("#zhjs-tabs li[data-flag]");
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
        //
        _hideTabPageView: function (info) {
            //
            var id = "#" + info.id;
            var tabTitle = $("#zhjs-tabs li[data-flag='" + info.id + "']");
            //
            var tabContent = $(id);
            //
            tabTitle.removeClass("active");
            tabContent.removeClass().addClass("tab-pane fade");
            //
            /*var cacheData = this._loadedTabViews[info.id];
             if (!cacheData) {
             //
             this._loadedTabViews[info.id] = {
             title: tabTitle,
             content: tabContent
             };
             }*/
            //
            // tabTitle.remove();
            // tabContent.remove();
            //
            tabContent.hide();
            tabTitle.hide();
        },
        //
        _hideOtherTabPage: function (tabId) {
            //
            var tabs = $("#zhjs-content>.tab-pane");
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
        //
        _showTabPageView: function (info) {
            //
            var cacheData = this._loadedTabViews[info.id];
            //
            if (cacheData) {
                //
                /*$(info.domTitle).append(cacheData.title);
                 $(info.domContent).append(cacheData.content);*/
                $(cacheData.title).show();
                $(cacheData.content).show();
            }
        },
        //
        _findTabIndex: function (id) {
            var index = -1;
            //
            var cid = "#" + id;
            var tabs = $("#zhjs-tabs a[data-toggle='tab']");
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
        //
        _activateTabPage: function (info) {
            //
            this._showTabPageView(info);
            this._hideOtherTabPage(info.id);
            var idx = this._findTabIndex(info.id);
            //
            if (idx !== -1) {
                //
                var target = $('#' + info.domTitle.id + ' li:eq(' + idx + ') a');
                target.tab("show");
                // $('#' + info.domTitle.id + ' li:eq(' + idx + ') a').tab('show');
            }
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
                id: info.id,
                name: info.name
            });
            var liNode = domConstruct.create("li", {
                //
                innerHTML: innerHtml,
                "data-flag": info.id,
            }, domNode);
            //
            return liNode;
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
                id: info.id
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
        }
    });
});
//# sourceMappingURL=ViewManager.js.map