/**
 * Created by Administrator on 2016/8/9.
 *
 * 实现底图分屏展示功能.
 */
define(["dojo/dom", "dojo/on", "dojo/_base/declare",
        "dojo/_base/array",
        "dojo/dom-construct",
        "dojo/string",
        "dojo/_base/lang",
        "dojo/sniff",
        "dojo/mouse",
        "./_BaseTool",
        "../utils/BaseMapUtils",
        "esri/map",
        "esri/domUtils",
        "dojo/dom-style",


    ],
    function (dom, on, declare, arrayUtils, domConstruct, string, lang, sniff, mouse, _BaseTool, BaseMapUtils,
              AgsMap, domUtils, domStyle) {
        //
        // var _map = null;
        //
        var polySelf = null;

        //
        var mapCtn = null;
        var splitCtn = null;
        var maskCtn = null;
        //
        //
        var map1 = null;
        var map2 = null;
        //
        var baseMapUtils = null;
        //
        var appConfig = null;
        /**
         * events.
         *
         * */
        var mapExtentHandler = null;
        var map1ExtentChangeHandler = null;
        var map2ExtentChangeHandler = null;
        /***/
        var handlers = [];

        var maskMouseMoveHandler = null;

        var module = declare([_BaseTool], {
            //
            constructor: function (options) {
                //
                map1 = this.map;
                lang.mixin(this, options);
                //
                //
                polySelf = this;
                /***/
                appConfig = this.configData;
                // baseMapUtils = new BaseMapUtils(map2);
                //
                //
               /* mapCtn = this._createCompareMapCtn(document.body);
                splitCtn = this._createSplitCtn(document.body);*/
            },
            //
            _addEventListeners: function () {

                var handler1 = map1.on("mouse-over", lang.hitch(this, this._map1MouseEnterHandler));
                var handler2 = map1.on("mouse-out", lang.hitch(this, this._map1MouseOutHandler));
                //
                var handler3 = map2.on("mouse-over", lang.hitch(this, this._map2MouseEnterHandler));
                var handler4 = map2.on("mouse-out", lang.hitch(this, this._map2MouseOutHandler));
                //
                handlers = [handler1, handler2, handler3, handler4];
            },
            //
            _map1MouseEnterHandler: function (event) {
                //
                map1ExtentChangeHandler = map1.on("extent-change", lang.hitch(this, function (event) {
                    //
                    var $extent = event.extent;
                    //
                    if (this._checkMapExtent($extent)) {
                        //
                        map2.setExtent($extent);
                    }
                }));

            },
            _map1MouseOutHandler: function (evt) {
                //
                if (map1ExtentChangeHandler) {
                    //
                    map1ExtentChangeHandler.remove();
                }
            },
            //
            //
            _map2MouseEnterHandler: function (evt) {
                //
                map2ExtentChangeHandler = map2.on("extent-change", lang.hitch(this, function (event) {
                    /**
                     * set map extent.
                     * */
                    var $extent = event.extent;
                    //
                    if (this._checkMapExtent($extent)) {
                        //
                        map1.setExtent($extent);
                    }
                }));
            },
            _map2MouseOutHandler: function (evt) {
                //
                if (map2ExtentChangeHandler) {
                    //
                    map2ExtentChangeHandler.remove();
                }
            },
            //
            _removeEventListeners: function () {
                //
                handlers.forEach(function (handler) {
                    handler.remove();
                });
                //
                if (map1ExtentChangeHandler) {
                    //
                    map1ExtentChangeHandler.remove();
                }
                //
                if (map2ExtentChangeHandler) {
                    //
                    map2ExtentChangeHandler.remove();
                }
            },
            /**
             *
             * */
            _stateChange: function (state) {
                if (state) {
                    //
                    domUtils.show(splitCtn);
                    domUtils.show(mapCtn);
                    //
                    domStyle.set(dom.byId(map1.id), {
                        //
                        width: "50%",
                        // position:"absolute"
                    });
                    //
                    if(map2){
                        //
                        map2.setExtent(map1.extent);
                    }
                } else {
                    //
                    domUtils.hide(splitCtn);
                    domUtils.hide(mapCtn);
                    domStyle.set(dom.byId(map1.id), {
                        //
                        width: "100%",
                        // position:"relative"

                    });
                }
            },
            //
            /**
             * 创建分隔条.
             * */
            _createSplitCtn: function (domNode) {
                //
                var split = domConstruct.create("div", {
                    //
                    class: "m-split-compare"
                    // style:"display:none;"
                }, domNode);
                //
                return split;
            },
            _createCompareMapCtn: function (domNode) {
                //
                var mapCtn = domConstruct.create("div", {
                    //
                    class: "m-map-compare"
                    // style:"display:none;"
                }, domNode);
                // n
                //
                map2 = new AgsMap(mapCtn, {
                    logo: false,
                    slider: false
                });
                //
                baseMapUtils = new BaseMapUtils(map2);

                baseMapUtils.loadLBaseLayers([appConfig.mapCompare]);
                //
                //
                map2.on("load", lang.hitch(this, function (event) {
                    //
                    map2.setExtent(map1.extent);
                }));
                return mapCtn;
            },
            //
            _getMousePosition: function (event) {
                //
                var e = event || window.event;
                var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
                var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
                var x = e.pageX || e.clientX + scrollX;
                var y = e.pageY || e.clientY + scrollY;
                return {'x': x, 'y': y};
            },
            //
            isActive: false,
            activate: function () {
                //
                if(!mapCtn){
                    //
                    mapCtn = this._createCompareMapCtn(document.body);
                }
                if(!splitCtn){
                    //
                    splitCtn = this._createSplitCtn(document.body);
                }
                if (this.isActive) {
                    //
                    this._removeEventListeners();
                }
                //
                this._addEventListeners();
                this._stateChange(true);
                this.isActive=true;
                //
            },
            //
            deactivate: function () {
                //
                this._stateChange(false);
                this._removeEventListeners();
                this.isActive=false;
            },
            /**
             * <code>检测当前范围是否有效</code>
             * */
            _checkMapExtent: function (extent) {
                //
                var checkState = false;
                if (extent) {
                    //
                    if (!isNaN(extent.xmin) && !isNaN(extent.ymin) && !isNaN(extent.xmax) && !isNaN(extent.ymax)) {
                        //
                        checkState = true;
                    }
                }
                //
                return checkState;
            },
            getMap:function(){
                return map2;
            }
        });
        //
        return module;
        //
    });