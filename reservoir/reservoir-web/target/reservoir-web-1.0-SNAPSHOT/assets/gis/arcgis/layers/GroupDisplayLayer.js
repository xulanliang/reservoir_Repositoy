/**
 * Created by Administrator on 2016/7/18.
 */
//
define([
    "dojo/_base/declare",
    "esri/layers/GraphicsLayer",
    "dojo/request/xhr",
    "dojo/json",
    "dojo/_base/lang",
    "../utils/dseGisUtils",
    "dojo/dom",
    "dojo/dom-style",
    "../utils/dseSymbolUtils",
    "../utils/DseGraphicUtils",
    "dojo/dom-construct",
    "esri/domUtils",
    "esri/graphic",
    "esri/geometry/Point",
    "esri/geometry/Circle"
], function (declare, GraphicsLayer, xhr, JSON, lang, dseGisUtils, dom, domStyle, dseSymbolUtils, DseGraphicUtils, domConstruct, domUtils, Graphic, Point, Circle) {
    //
    var moClass = declare([GraphicsLayer], {
        /**
         * constructor.
         * */
        constructor: function (options) {
            //
            this.url = options.url;
            this.id = options.id || "g_dse_" + (Math.random() * 10000).toFixed(0);
            lang.mixin(this, options);
            //
            var _self = this;
            //
            this.symbolCallBack = options.symbolCallBack;
            //
            this.queryParamsCallback = options.queryParamsCallback;
            //
            //默认不显示信息弹出框
            this.template = options.template || { visible: false };
            //默认不显示提示框
            this.tips = options.tips || { visible: false };
            //
            this.groupKeyField = options.groupKeyField;
            //
            this._cacheData = {};
            this.__init(options);
            //
            this.on("click", lang.hitch(this, this._layerClickHandler));
            this.on("mouse-over", lang.hitch(this, this._layerMouseOverHandler));
            this.on("mouse-out", lang.hitch(this, this._layerMouseOutHandler));
            // load data.
            this.tipsCtn = this._createTipsContainer(this.tips.visible);
        },
        //对数据进行分组
        _groupResultData: function (data) {
            if (data && data.length > 0) {
                var self = this;
                this._cacheData = {};
                var cacheData = this._cacheData;
                data.forEach(function (d) {
                    //
                    var keyValue = d[self.groupKeyField];
                    if (cacheData.hasOwnProperty(keyValue)) {
                        //
                        cacheData[keyValue].push(d);
                    }
                    else {
                        cacheData[keyValue] = [d];
                    }
                });
            }
        },
        //
        setLayerTips: function (tipsInfo) {
            //.
            this.tips = tipsInfo; //
            if (!this.tipsCtn) {
                this.tipsCtn = this._createTipsContainer(this.tips.visible);
            }
        },
        /**set layer template content call back function.*/
        setLayerTemplate: function (templateInfo) {
            //
            this.template = templateInfo;
        },
        /**set layer symbol call back function.*/
        setSymbolCallBack: function (cb) {
            //
            this.symbolCallBack = cb;
        },
        /**set layer tips content call back function.*/
        setTipsCallBack: function (callback) {
            //
            this.tipsCallBack = callback;
        },
        //
        //
        __init: function (options) {
            //
            var _self = this;
            var _map = options.map;
            var graphicUtils = new DseGraphicUtils({
                map: options.map,
                mapType: options.mapType
            });
            /**当前鼠标位置.*/
            var mousePoint = null;
            /**创建统计图标*/
            _self._statisticGra = function (group, sources) {
                //
                if (sources && sources.length > 0) {
                    //
                    var data = sources[0];
                    var lonVal = data[_self.lonField];
                    var latVal = data[_self.latField];
                    //
                    if (lonVal && latVal) {
                        //
                        var attributes = {
                            isGroup: true,
                            groupId: group
                        };
                        var cen = dseGisUtils.WgsToDqzb(lonVal, latVal, options.mapType);
                        //
                        var point = new Point(cen[0], cen[1], this.map.spatialReference);
                        var circle200 = new Circle(point, {
                            // center: cen,
                            radius: 20000,
                        });
                        //
                        var symbol = dseSymbolUtils.createSimpleFillSymbol({
                            fillColor: [255, 182, 193, 0.6],
                            borderColor: [255, 182, 193, 0.9]
                        });
                        //
                        var gra200 = new Graphic(circle200, symbol, attributes);
                        //
                        var textSymbol = dseSymbolUtils.createTextSymbol({
                            content: sources.length + "个",
                            angle: 0.1,
                            fontSize: "14pt",
                            textColor: [255, 255, 255, 1],
                            offsetY: -8
                        });
                        var centerGra = new Graphic(point, textSymbol, attributes);
                        _self.add(gra200);
                        _self.add(centerGra);
                    }
                }
            };
            /**
             * @return Array [esri.Graphic]
             * */
            _self._parsePointResult = function (results) {
                //
                //获取坐标点数据.
                if (Array.isArray(results)) {
                    //
                    results.forEach(function (data) {
                        //
                        var dx = null;
                        var dy = null;
                        if (data.hasOwnProperty(_self.lonField) && data.hasOwnProperty(_self.latField)) {
                            //
                            //
                            var lonVal = data[_self.lonField];
                            var latVal = data[_self.latField];
                            //检测是否有坐标值.
                            if (latVal && lonVal) {
                                //
                                dx = parseFloat(data[_self.lonField]);
                                dy = parseFloat(data[_self.latField]);
                                //
                                var gra = null;
                                if (_self.symbolCallBack) {
                                    //
                                    var sym = _self.symbolCallBack(data);
                                    gra = graphicUtils.createPoint2(data, dx, dy, sym);
                                }
                                else {
                                    //
                                    var icon = dseSymbolUtils.getMarkImg("PP", 1);
                                    gra = graphicUtils.createPoint(data, dx, dy, icon.path, icon.width, icon.height);
                                }
                                // gra.setInfoTemplate(this.template);
                                //显示实时数据.
                                if (_self.isRealTime && _self._currentGra) {
                                    //
                                    if (_self._currentGra.attributes[_self.compareField] === gra.attributes[_self.compareField]) {
                                        //
                                        _self._updateData(gra);
                                    }
                                }
                                _self.add(gra);
                            }
                        }
                    });
                }
            };
            //
            _self._parseLineResult = function (results, isArrow) {
                //获取坐标点数据.
                results.forEach(function (data) {
                    //
                    if (data.hasOwnProperty(_self.polylineField)) {
                        //
                        var geoJson = data[_self.polylineField];
                        //
                        if (geoJson) {
                            //
                            var symbol = null;
                            if (typeof _self.symbolCallBack === "function") {
                                symbol = _self.symbolCallBack(data, "polyline");
                            }
                            else {
                                //
                                symbol = dseSymbolUtils.createSimpleLineSymbol({});
                            }
                            //
                            var gra = graphicUtils.createPolylineGra(geoJson, symbol, data);
                            gra.data = data;
                            _self.add(gra);
                            //
                            var geometry = gra.geometry;
                            if (isArrow) {
                                var paths = geometry.paths;
                                var points = paths[0];
                                //
                                var itemCount = points.length - 1;
                                // var itemIndex = 0;
                                //
                                for (var itemIndex = 0; itemIndex < itemCount; itemIndex++) {
                                    //
                                    var info1 = points[itemIndex];
                                    var info2 = points[itemIndex + 1];
                                    //
                                    var startPoint = new Point(info1[0], info1[1], _map.spatialReference);
                                    //
                                    var endPoint = new Point(info2[0], info2[1], _map.spatialReference);
                                    var angle = _self._getLineAngle(startPoint, endPoint);
                                    var arrowSym = dseSymbolUtils.createSimpleArrowSymbol(symbol.color, angle);
                                    //
                                    var arrow = new Graphic(endPoint, arrowSym, data);
                                    arrow.data = data;
                                    //
                                    _self.add(arrow);
                                }
                            }
                        }
                    }
                });
            };
            //
            _self._getLineAngle = function (starts, ends) {
                // 计算两点之间的方位角.
                var angle = 0;
                var sp = _map.toScreen(starts);
                var ep = _map.toScreen(ends);
                angle = Math.atan2((ep.y - sp.y), (ep.x - sp.x)) * 180 / Math.PI;
                return angle;
            };
            //
            _self._layerSubItemClickHandler = function (gra) {
                //
                var point = dseGisUtils.getGeomCenter(gra);
                //
                var self = this;
                //
                window.graphic = gra;
                // currentGra = gra;
                var templateContent = "";
                // mousePoint = point;
                var content = "";
                var title = "";
                //
                if (gra.data.hasOwnProperty(this.template.titleField)) {
                    //
                    title = gra.data[this.template.titleField];
                }
                //
                title += (this.template.titleSuffix || "");
                //
                if (this.template.visible) {
                    //
                    if (this.template.type === "inner") {
                        //
                        if (templateContent) {
                            //
                            content = _.template(templateContent)(gra.data);
                            //
                            this._showInfoWindow(point, content, title, this.template.width, false);
                        }
                        else {
                            //
                            require(["dojo/text!" + this.template.url], function (details) {
                                //
                                templateContent = details;
                                //
                                content = _.template(details)(gra.data);
                                _self._showInfoWindow(point, content, title, self.template.width, false);
                            });
                        }
                    }
                    else if (this.template.type === "outer") {
                        //
                        this._showInfoWindowFrom(this.template.url, title);
                    }
                }
            };
            //
            _self._layerClickHandler = function (event) {
                //
                var gra = event.graphic;
                //
                //
                var attributes = gra.attributes;
                //
                if (attributes.isGroup) {
                    //
                    attributes.isGroup = false;
                    var groupData = this._cacheData[attributes.groupId];
                    _self._loadDataHandler(groupData);
                }
                else {
                    //
                    _self._layerSubItemClickHandler(gra);
                }
            };
            //
            _self._rowItemClickHandler = function (data) {
                //
                var gra = {
                    geometry: {},
                    attributes: {},
                    data: data
                };
                window.graphic = gra;
                var title = "";
                //
                if (gra.data.hasOwnProperty(this.template.titleField)) {
                    //
                    title = gra.data[this.template.titleField];
                }
                //
                title += "详细信息";
                //
                if (this.template.visible) {
                    //
                    this._showInfoWindowFrom(this.template.url, title);
                }
            };
            /**显示弹出框.*/
            _self.openPopup = function (data, keyField) {
                //
                var gs = this.graphics;
                var graId = data[keyField];
                //
                var rgs = null;
                if (gs && gs.length > 0) {
                    //
                    rgs = gs.filter(function (g) {
                        //
                        return g.data[keyField] === graId;
                    });
                }
                //
                if (rgs && rgs.length > 0) {
                    var gra = rgs[0];
                    this._layerClickHandler({
                        graphic: gra
                    });
                }
                else {
                    this._rowItemClickHandler(data);
                }
            };
            //
            _self.removeGra = function (data, keyField) {
                //
                var gs = this.graphics;
                var graId = data[keyField];
                //
                var rgs = null;
                if (gs && gs.length > 0) {
                    //
                    rgs = gs.filter(function (g) {
                        //
                        return g.data[keyField] === graId;
                    });
                }
                //
                //
                if (rgs && rgs.length > 0) {
                    rgs.forEach(function (g) {
                        _self.remove(g);
                    });
                }
                var gra = rgs[0];
                if (gra) {
                    this.remove(gra);
                }
            };
            /**显示弹出框.*/
            _self.showPopup = function (gra) {
                //
                if (gra) {
                    //
                    this._layerClickHandler({
                        graphic: gra
                    });
                }
            };
            /**显示标签*/
            _self.showLabel = function (layerId, options) {
                //
                var lblLayer = _map.getLayer(layerId);
                //
                if (!lblLayer) {
                    lblLayer = new GraphicsLayer({ id: layerId });
                    //
                    _map.addLayer(lblLayer);
                    //
                    lblLayer.hide();
                }
                //
                lblLayer.clear();
                lblLayer.show();
                //
                var nameField = options.nameField;
                //
                var xOffset = options.offSet.sx;
                var yOffSet = options.offSet.sy;
                //
                var gs = this.graphics;
                //
                if (gs && gs.length > 0) {
                    //
                    gs.forEach(function (g) {
                        //
                        //
                        var g1 = graphicUtils.copyGraphic(g);
                        //
                        var text = "";
                        if (g.data && g.data[nameField]) {
                            text = g.data[nameField];
                        }
                        var sym = dseSymbolUtils.createTextSymbol({
                            content: text
                        });
                        //
                        if (xOffset) {
                            //
                            sym.xoffset = xOffset;
                        }
                        if (yOffSet) {
                            sym.yoffset = yOffSet;
                        }
                        g1.setSymbol(sym);
                        //
                        lblLayer.add(g1);
                    });
                }
                //
                return lblLayer;
            };
            /**隐藏标签.*/
            _self.hideLabel = function (layerId) {
                //
                var lblLayer = _map.getLayer(layerId);
                //
                if (lblLayer) {
                    lblLayer.hide();
                }
            };
            //
            _self.hideTips = function () {
                //
                domUtils.hide(_self.tipsCtn);
            };
            /**
             * 显示提示信息
             * */
            _self._layerMouseOverHandler = function (event) {
                //
                //
                this.attr("style", "cursor: pointer;");
                var screenPoint = event.screenPoint;
                //
                mousePoint = screenPoint;
                //
                _self._currentGra = event.graphic;
                //
                if (_self.tips.visible) {
                    //
                    var content = "";
                    // 设置可修改的tips ，用于图层组显示.
                    var tipsCallBack = this.tipsCallBack;
                    //
                    if (typeof tipsCallBack === "function") {
                        //
                        //
                        var tipsCb = this._createTipsContent;
                        content = tipsCallBack(event.graphic, _self.tips, tipsCb);
                    }
                    else {
                        //
                        content = this._createTipsContent(event.graphic, _self.tips.fields);
                    }
                    //
                    this._showGraphicTips(screenPoint, content);
                }
            };
            //
            _self._createTipsContainer = function (isCreate) {
                //
                var domNode = null;
                if (isCreate) {
                    //
                    domNode = domConstruct.create("div", {}, dom.byId(_self.map.id));
                    domStyle.set(domNode, {
                        "display": "none",
                        "position": "absolute",
                        "z-index": 99,
                        "background": "#fcffd1",
                        "border": "1px solid #0096ff",
                        "padding": "0.1em 0.3em 0.1em",
                        "font-size": "12px",
                        "border-radius": "3px",
                        "box-shadow": "0 0 0.75em #777777",
                        "overflow": "hidden"
                    });
                }
                //
                return domNode;
            };
            //
            /**
             *
             * */
            _self._showInfoWindow = function (point, content, title, width, iscolse) {
                if (!point || !content) {
                    return;
                }
                _self.map.infoWindow.setContent(content);
                $(".titlePane").css("backgroundColor", "#1468b4"); //标题栏的背景颜色
                $(".titlePane").css("font-size", "15px"); //标题栏的字体大小
                if (width && width != "") {
                    $(".sizer").css("width", width);
                }
                else {
                    $(".sizer").css("width", "270px");
                }
                _self.map.infoWindow.setTitle(dseGisUtils.nullToSpace(title));
                if (iscolse && iscolse == true) {
                    $(".close").css("display", "none");
                }
                //移除按钮
                $(".maximize").remove();
                //
                _self.map.infoWindow.show(point); //new Point(113.343125,23.987933)
                //记载InfoWindow脚本文件
                if (this.template.script) {
                    //
                    _self._loadDynamicJsFile({ id: "templateJs", url: _self.template.script });
                }
                //load
                /* require(["dse_gis/demo/Test"], function (Test) {
                 //
                 Test.setGraphic(currentGra);
                 });*/
            };
            //
            _self._updateData = function (graphic) {
                //
                //
                if (_self.tips.visible && this.isRealTime) {
                    //
                    var content = _self._createTipsContent(graphic, _self.tips.fields);
                    //
                    _self._showGraphicTips(mousePoint, content);
                }
            };
        },
        /**
         * 用于显示已经获取到的数据.
         * @param data 需要显示的数据,
         * @param isGroupData 是否分组显示数据, true 显示，false不分组
         * */
        loadData: function (data, isGroupData) {
            //请求新的数据
            if (isGroupData) {
                //扩展.
                this._groupResultData(data);
                var cacheData = this._cacheData;
                for (var keyField in cacheData) {
                    //
                    this._statisticGra(keyField, cacheData[keyField]);
                }
            }
            else {
                //
                this.clear();
                this._loadDataHandler(data);
            }
        },
        /** load polyline data .*/
        loadPolylineData: function (data, isArrow /**line width arrow.*/) {
            //
            this._parseLineResult(data, isArrow);
        },
        /**重新绑定图层实例*/
        bindCallRefReset: function (callRef) {
            //
        },
        //
        _createTipsContent: function (gra, fields) {
            //
            var content = "";
            fields.forEach(function (field) {
                //
                for (var key in field) {
                    var v = field[key];
                    if (!gra.attributes[v]) {
                        gra.attributes[v] = "--";
                    }
                    content += key + ":" + gra.attributes[v] + "<br>";
                }
            });
            //
            return content;
        },
        //
        _layerMouseOutHandler: function (event) {
            //
            this.attr("style", "cursor: default;");
            if (this.tipsCtn) {
                //
                domUtils.hide(this.tipsCtn);
                // $(this.tipsCtn).hide();
            }
        },
        _loadDataHandler: function (data) {
            //解析查询结果，创建Graphic.
            // this.clear();
            this._parsePointResult(data);
            //
        },
        _loadDataErrorHandler: function (error) {
            //
            console.log("query data error in QueryDisplayLayer" + JSON.stringify(error));
        },
        /**
         *
         * */
        _showGraphicTips: function (loc, content) {
            //
            domStyle.set(this.tipsCtn, {
                "left": loc.x + 15 + "px",
                "top": loc.y + 5 + "px"
            });
            this.tipsCtn.innerHTML = content;
            domUtils.show(this.tipsCtn);
        },
        /***
         * 调用外部链接，显示详情
         * */
        _showInfoWindowFrom: function (url, title) {
            //
            var width = this.template.width || "750";
            var height = this.template.height || "600";
            //
            var top = $(document).height() / 2 - height / 2;
            var left = $(document).width() / 2 - width / 2;
            layer.open({
                type: 2,
                title: title,
                shadeClose: false,
                shade: 0.3,
                area: [width + 'px', height + 'px'],
                content: url,
                closeBtn: 1,
                offset: [top + "px", left + "px"]
            });
        },
        _loadDynamicJsFile: function (info) {
            //
            var script = document.getElementById(info.id);
            if (script) {
                document.body.removeChild(script);
            }
            script = document.createElement("script");
            script.src = info.url;
            script.type = "text/javascript";
            script.id = info.id;
            document.body.appendChild(script);
        },
        /**
         * =============================================================
         * 显示实时数据.
         * =============================================================
         * */
        isRealTime: false,
        //
        /**需要显示实时数据的点集合*/
        //
        tipNames: []
    });
    //
    return moClass;
});
//# sourceMappingURL=GroupDisplayLayer.js.map