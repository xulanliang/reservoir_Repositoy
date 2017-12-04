/**
 * Created by Administrator on 2016/8/15.
 */
define([
    "dojo/_base/declare",
    //
    "dojo/_base/lang",
    "esri/geometry/Point",
    "esri/geometry/ScreenPoint",
    "dojo/dom",
    "dojo/on",
    "dojo/request/xhr",
    "dojo/query",
    "esri/domUtils",
    "dojo/dom-construct",
    "dojo/dom-style",
    "esri/SpatialReference",
], function (declare, lang, Point, ScreenPoint, dom, on, xhr, query, domUtils, domConstruct, domStyle, SpatialReference) {
    //

    //
    // var mySelf = null;
    //
    // var domNode = null;
    //
    // var handlers = null;
    return declare(null, {
        // name: "EchartsLayer",
        map: null,
        _ec: null,
        _geoCoord: [],
        _option: null,
        constructor: function (url, options) {
            // this.map = options.map;
            //
            lang.mixin(this, options);
            //
            //
            this.domNode = document.createElement('div');
            this.domNode.style.position = 'absolute';
            this.domNode.style.height = this.map.height + 'px';
            this.domNode.style.width = this.map.width + 'px';
            this.domNode.style.top = 0;
            this.domNode.style.left = 0;
            //
            this.domNode.id = options.id;
            //
            //
            var svgCtn = query("#map_layers>svg")[0];
            //
            if (svgCtn) {
                //
                dom.byId("map_layers").insertBefore(this.domNode, svgCtn);
            }
           /* document.body.appendChild(this.domNode);
            //
            on(this.domNode, "mousedown", function (event) {
                //
                domUtils.hide(this);
            });
            //
            on(this.domNode, "mouseup", function (event) {
                //
                domUtils.show(this);
            });
            //
            on(this.domNode, "mousewheel", function (event) {
                //
                domUtils.hide(this);
            });*/
            //
            // document.getElementById("map_layers").appendChild(this.domNode);
            //
            this._init(this.map, options.charts);
            //
        },
        //
        _init: function (map, ec) {
            var self = this;
            self.map = map;
            /**
             * 获取map实例
             *
             * @return {map.Map}
             * @public
             */
            self.getMap = function () {
                return self.map;
            };
            /**
             * 经纬度转换为屏幕像素
             *
             * @param {Array.<number>} geoCoord  经纬度
             * @return {Array.<number>}
             * @public
             */
            self.geoCoord2Pixel = function (geoCoord) {
                var point = new Point(geoCoord[0], geoCoord[1], new SpatialReference({
                    //
                    wkid: 4326
                }));
                var pos = self.map.toScreen(point);
                //
                return [pos.x, pos.y];
            };

            /**
             * 屏幕像素转换为经纬度
             *
             * @param {Array.<number>} pixel  像素坐标
             * @return {Array.<number>}
             * @public
             */
            self.pixel2GeoCoord = function (pixel) {
                var point = self.map.toMap(new ScreenPoint(pixel[0], pixel[1]));
                //
                return [point.lng, point.lat];
            };
            //
            self._charts = [];
            //
            self._handlers = [];
            //
            self.setPieSize = function (width, height) {
                //
                self._w = width || 300;
                self._h = height || 200;
            };
            //
            self._clear = function () {
                //
                var ecDiv = document.getElementById(self.id);
                //
                if (ecDiv) {
                    //
                    domConstruct.empty(self.id);
                    self._charts.forEach(function (ct) {
                        //
                        ct.clear();
                    });
                }
            };
            /**
             * 绑定地图事件的处理方法
             *
             * @private
             */
            self._bindEvent = function (handlers) {
                //
                self._unbindEvent(handlers);
                //
                var handler1 = self.map.on('zoom-end', function (e) {
                    self.setOption(self._option);
                    // domUtils.show(dom.byId(self.id));
                    self.show();
                });
                var handler2 = self.map.on('zoom-start', function (e) {
                    // self._ec.clear();
                    self._clear();
                });
                var handler3 = self.map.on('pan', function (e) {
                    // self._ec.clear();
                    // domConstruct.empty(self.id);
                    // self.show();
                    self._clear();
                });
                var handler4 = self.map.on('pan-end', function (e) {
                    self.setOption(self._option);
                    //
                    self.show();
                });
                //
                var handler5 = self.map.on("pan-start", function (event) {
                    //
                    // self.hide();
                    // domConstruct.empty(self.id);
                    self._clear();
                });
                //
                var handler6 = self.map.on("mouse-wheel", function (event) {
                    //
                    self._clear();
                });
                //
                //
                self.domNode.onclick = function (event) {
                    //
                    alert("you click");
                };
                //
                //

                /*self._ec.getZrender().on('dragstart', function (e) {
                 self.map.disablePan();
                 //self._ec.clear();
                 });
                 self._ec.getZrender().on('dragend', function (e) {

                 //self.setOption(self._option);
                 });
                 self._ec.getZrender().on('mousewheel', function (e) {
                 self._ec.clear();
                 self.map.emit('mouse-wheel', e.event)
                 });*/


                handlers = [handler1, handler2, handler3, handler4, handler5, handler6];
            };
            //
            self._bindECEvent = function (charts) {
                //
                charts.forEach(function (ec) {
                    //
                    ec.getZrender().on("dragstart", self._ecDragStartHandler);
                    ec.getZrender().on("dragend", self._ecDragEndHandler);
                    //
                    // ec.on("CLICK", self._ecClickHandler);
                    //
                    on(ec, "click", function (event) {
                        //
                        alert("tests");
                    });
                });
                //

            };
            //
            self._unBindECEvent = function (charts) {
                //
                charts.forEach(function (ec) {
                    //
                    ec.getZrender().un("dragstart", self._ecDragStartHandler);
                    ec.getZrender().un("dragend", self._ecDragEndHandler);
                });
            };

            //

            //

            self._ecDragStartHandler = function (event) {
                //
                self.map.disablePan();
            };

            self._ecDragEndHandler = function (event) {
                //
                self.map.enablePan();
            };
            //
            self._ecClickHandler = function (event) {
                //
                alert(event.id);
            };
            //
            //
            /**
             * 创建单个饼图实例.
             * */
            self._createPieChart = function (config) {
                //
                var ecCtn = domConstruct.create("div", {
                    //
                }, this.domNode);
                //

                //
                var pos = this.geoCoord2Pixel(config.geoCoord);
                //
                // px;
                var left = pos[0] - self._w / 2;
                var top = pos[1] - self._h / 2;
                //
                domStyle.set(ecCtn, {
                    position: "absolute",
                    left: left + "px",
                    top: top + "px",
                    width: self._w + "px",
                    height: self._h + "px"
                });
                //
                var ec = echarts.init(ecCtn, "macarons");
                //

                //
                ec.setOption(config);
                //
                //
                /* on(ecCtn,"click",function(event){
                 //

                 });*/
                self._charts.push(ec);
                //
                return ec;
            };
            /**
             * 创建饼图.
             * */
            self.setOption = function (option) {
                //
                this._unbindEvent(self._handlers);
                //
                this._unBindECEvent(self._charts);

                var chartsInfo = option.charts;
                //
                self._option = option;
                self._charts = [];
                //
                if (chartsInfo && Array.isArray(chartsInfo)) {
                    //
                    chartsInfo.forEach(function (config) {
                        //
                        self._createPieChart(config);
                        //
                    });
                }
                //
                /* self._bindEvent(self._handlers);
                 self._bindECEvent(self._charts);*/
            };
            //
            self._bindEvent(self._handlers);
            self._bindECEvent(self._charts);
        },
        //
        on: function (eventName, handler) {
            //
            //
            $("#" + this.domNode.id + ">div").on(eventName, handler);
            // on(this.domNode, eventName, handler);
        },
        //
        _unbindEvent: function (handlers) {
            //
            if (handlers.length > 0) {
                //
                handlers.forEach(function (handler) {
                    //
                    handler.remove();
                });
            }
        },
        /**
         * 显示图层.
         * */
        show: function () {
            //
            domUtils.show(dom.byId(this.id));
        },
        /**
         * 隐藏图层。
         * */
        hide: function () {
            //
            domUtils.hide(dom.byId(this.id));

        },
        /***/
        remove: function () {
            //remove events.
            this._handlers.forEach(function (handler) {
                handler.remove();
            });
            //
            this._unBindECEvent(this._charts);

            this._clear();
            //
            domConstruct.destroy(this.domNode.id);
            // domNode.remove();
        }
    });
});