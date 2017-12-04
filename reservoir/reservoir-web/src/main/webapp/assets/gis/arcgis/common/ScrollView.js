/**
 * Created by Administrator on 2016/10/26.
 */
define(["dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/dom",
    "dojo/dom-style",
    "dojo/dom-construct",
    "esri/domUtils",
    "dojo/on",
    "dojo/query",
    "dojo/_base/window"
    // "xstyle!./styles/TestControl.css"
], function (declare, lang, dom, domStyle, domConstruct, domUtils, on, query, win) {
    //
    return declare(null, {
        //
        constructor: function (options) {
            //
            // lang.hitch(this, options);
            // loaded pages.
            this.nodes = options.nodes || [];
            this._init(options);
        },
        _init: function (options) {
            //
            var self = this;
            //
            /**
             * hide
             * */
            self.hideScrollView = function (nodes) {
                //
                nodes.forEach(function (node) {
                    //
                    var target = $(node);
                    // var node = $(node).getNiceScroll();
                    var view = target.getNiceScroll();
                    view.hide();
                    node.resize();
                    //
                    // node.hide();
                    // node.resize();
                });
            };
            /**
             * 切换滚动条状态.
             * */
            self.changeScrollState = function (tabName, isFirstLoaded) {
                //
                var nodes = this.nodes;
                //
                nodes.forEach(function (node) {
                    //
                    var target = $(node);
                    var niceScroll = target.getNiceScroll();
                    if (node === tabName) {
                        //
                        if (isFirstLoaded) {
                            //
                            target.niceScroll();
                            isFirstLoaded = false;
                        }
                        else {
                            //
                            niceScroll.show();
                        }
                    }
                    else {
                        //
                        niceScroll.hide();
                        niceScroll.resize();
                    }
                });
            };
        }
    });
});
//# sourceMappingURL=ScrollView.js.map