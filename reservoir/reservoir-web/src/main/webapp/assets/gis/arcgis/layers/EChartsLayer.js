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
    "esri/domUtils"
], function (declare, lang, Point, ScreenPoint, dom, on, xhr, query, domUtils) {
    //
    //
    var mySelf = null;
    //
    var layerCtn = null;
    //
    var handlers = null;
    return declare(null, {
        // name: "EchartsLayer",
        map: null,
        _ec: null,
        _geoCoord: [],
        _option: null,
        _mapOffset: [0, 0],
        constructor: function (url, options) {
            // this.map = options.map;
            //
            handlers = [];
            lang.mixin(this, options);
            //
            layerCtn = this._echartsContainer = document.createElement('div');
            layerCtn.style.position = 'absolute';
            layerCtn.style.height = this.map.height + 'px';
            layerCtn.style.width = this.map.width + 'px';
            layerCtn.style.top = 0;
            layerCtn.style.left = 0;
            //
            layerCtn.id = options.id;
            //
            mySelf = this;
            var svgCtn = query("#map_layers>svg")[0];
            //
            if (svgCtn) {
                //
                dom.byId("map_layers").insertBefore(layerCtn, svgCtn);
            }
            // map.__container.appendChild(div);
            this._init(this.map, options.charts);
            //
            if (url) {
                //
                xhr(url, {
                    handleAs: "json",
                    method: "GET"
                }).then(function (data) {
                    //
                    mySelf.setOption(data);
                }, function (error) {
                    //
                    console.log(JSON.stringify(error));
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
            handlers.forEach(function (handler) {
                handler.remove();
            });
            //
            layerCtn.remove();
        },
        _init: function (map, ec) {
            var self = this;
            self.map = map;
            //初始化mapoverlay
            /**
             * 获取echarts容器
             *
             * @return {HTMLElement}
             * @public
             */
            self.getEchartsContainer = function () {
                return self._echartsContainer;
            };
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
                var point = new Point(geoCoord[0], geoCoord[1]);
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
            /**
             * 初始化echarts实例
             *
             * @return {ECharts}
             * @public
             */
            self.initECharts = function () {
                self._ec = ec.init.apply(self, arguments);
                self._bindEvent();
                self._addMarkWrap();
                return self._ec;
            };
            // addMark wrap for get position from baidu map by geo location
            self._addMarkWrap = function () {
                function _addMark(seriesIdx, markData, markType) {
                    var data;
                    if (markType == 'markPoint') {
                        var data = markData.data;
                        if (data && data.length) {
                            for (var k = 0, len = data.length; k < len; k++) {
                                if (!(data[k].name && this._geoCoord.hasOwnProperty(data[k].name))) {
                                    data[k].name = k + 'markp';
                                    self._geoCoord[data[k].name] = data[k].geoCoord;
                                }
                                self._AddPos(data[k]);
                            }
                        }
                    }
                    else {
                        data = markData.data;
                        if (data && data.length) {
                            for (var k = 0, len = data.length; k < len; k++) {
                                if (!(data[k][0].name && this._geoCoord.hasOwnProperty(data[k][0].name))) {
                                    data[k][0].name = k + 'startp';
                                    self._geoCoord[data[k][0].name] = data[k][0].geoCoord;
                                }
                                if (!(data[k][1].name && this._geoCoord.hasOwnProperty(data[k][1].name))) {
                                    data[k][1].name = k + 'endp';
                                    self._geoCoord[data[k][1].name] = data[k][1].geoCoord;
                                }
                                self._AddPos(data[k][0]);
                                self._AddPos(data[k][1]);
                            }
                        }
                    }
                    self._ec._addMarkOri(seriesIdx, markData, markType);
                }
                self._ec._addMarkOri = self._ec._addMark;
                self._ec._addMark = _addMark;
            };
            /**
             * 获取ECharts实例
             *
             * @return {ECharts}
             * @public
             */
            self.getECharts = function () {
                return self._ec;
            };
            /**
             * 获取地图的偏移量
             *
             * @return {Array.<number>}
             * @public
             */
            self.getMapOffset = function () {
                return self._mapOffset;
            };
            /**
             * 对echarts的setOption加一次处理
             * 用来为markPoint、markLine中添加x、y坐标，需要name与geoCoord对应
             *
             * @public
             * @param option
             * @param notMerge
             */
            self.setOption = function (option, notMerge) {
                self._option = option;
                var series = option.series || {};
                // 记录所有的geoCoord
                for (var i = 0, item; item = series[i++];) {
                    var geoCoord = item.geoCoord;
                    if (geoCoord) {
                        for (var k in geoCoord) {
                            self._geoCoord[k] = geoCoord[k];
                        }
                    }
                }
                // 添加x、y
                for (var i = 0, item; item = series[i++];) {
                    var markPoint = item.markPoint || {};
                    var markLine = item.markLine || {};
                    var data = markPoint.data;
                    if (data && data.length) {
                        for (var k1 = 0, len = data.length; k1 < len; k1++) {
                            if (!(data[k1].name && this._geoCoord.hasOwnProperty(data[k1].name))) {
                                data[k1].name = k1 + 'markp';
                                self._geoCoord[data[k1].name] = data[k1].geoCoord;
                            }
                            self._AddPos(data[k1]);
                        }
                    }
                    data = markLine.data;
                    if (data && data.length) {
                        for (var k2 = 0, len = data.length; k2 < len; k2++) {
                            if (!(data[k2][0].name && this._geoCoord.hasOwnProperty(data[k2][0].name))) {
                                data[k2][0].name = k2 + 'startp';
                                self._geoCoord[data[k2][0].name] = data[k2][0].geoCoord;
                            }
                            if (!(data[k2][1].name && this._geoCoord.hasOwnProperty(data[k2][1].name))) {
                                data[k2][1].name = k2 + 'endp';
                                self._geoCoord[data[k2][1].name] = data[k2][1].geoCoord;
                            }
                            self._AddPos(data[k2][0]);
                            self._AddPos(data[k2][1]);
                        }
                    }
                }
                self._ec.setOption(option, notMerge);
            };
            /**
             * 增加x、y坐标
             *
             * @param {Object} obj  markPoint、markLine data中的项，必须有name
             * @param {Object} geoCoord
             */
            self._AddPos = function (obj) {
                var coord = self._geoCoord[obj.name];
                var pos = self.geoCoord2Pixel(coord);
                obj.x = pos[0]; //- self._mapOffset[0];
                obj.y = pos[1]; //- self._mapOffset[1];
            };
            /**
             * 绑定地图事件的处理方法
             *
             * @private
             */
            self._bindEvent = function () {
                var handler1 = self.map.on('zoom-end', function (e) {
                    self.setOption(self._option);
                });
                var handler2 = self.map.on('zoom-start', function (e) {
                    self._ec.clear();
                });
                var handler3 = self.map.on('pan', function (e) {
                    self._ec.clear();
                });
                var handler4 = self.map.on('pan-end', function (e) {
                    self.setOption(self._option);
                });
                self._ec.getZrender().on('dragstart', function (e) {
                    self.map.disablePan();
                    //self._ec.clear();
                });
                self._ec.getZrender().on('dragend', function (e) {
                    self.map.enablePan();
                    //self.setOption(self._option);
                });
                self._ec.getZrender().on('mousewheel', function (e) {
                    self._ec.clear();
                    self.map.emit('mouse-wheel', e.event);
                });
                //
                handlers = [handler1, handler2, handler3, handler4];
            };
        }
    });
});
//# sourceMappingURL=EChartsLayer.js.map