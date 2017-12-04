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
    "esri/domUtils"
], function (declare, GraphicsLayer, xhr, JSON, lang, dseGisUtils, dom, domStyle, dseSymbolUtils, DseGraphicUtils, domConstruct, domUtils) {
    //
    //
    var moClass = declare([GraphicsLayer], {
        /**
         * constructor.
         * */
        constructor: function (options) {

            this.geometryType = options.geometryType;
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
            this.template = options.template || {visible: false};
            //默认不显示提示框
            this.tips = options.tips || {visible: false};
            //
            this.labels = options.labels || {visible: false};
            this.__init(options);
            //
            this.on("click", lang.hitch(this, this._layerClickHandler));
            this.on("mouse-over", lang.hitch(this, this._layerMouseOverHandler));
            this.on("mouse-out", lang.hitch(this, this._layerMouseOutHandler));
            //
            var isCreate = this.tips.visible || this.labels.visible;
            this.tipsCtn = this._createTipsContainer(isCreate);
        },
        //d
        setLayerTips: function (tipsInfo) {
            //.
            this.tips = tipsInfo; //
            if (!this.tipsCtn) {
                //
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
        /**
         * <p>批量设置图层配置信息.</p>
         * @author wangsl
         * @date 2017-03-22
         * */
        addLayerConfig: function (config) {
            //
            lang.mixin(this, config);
        },
        /**
         *<p>设置图层标签信息</p>
         * @author wangsl
         * @date 2017-03-22
         * */
        setLayerLabels: function (labels) {
            //
            this.labels = labels;
            if (!this.tipsCtn) {
                //
                this.tipsCtn = this._createTipsContainer(this.labels.visible);
            }
        },
        /**设置图层标签回调函数，当一个图层中需要显示不同标签组时，设置此回调函数，只有一种风格标签时，不需要设置此回调函数
         * @author wangsl
         * @date 2017-03-23
         * */
        setLabelsCallBack: function (callback) {
            this.labelsCallBack = callback;
        },
        /**
         * <p>设置图层弹出框，当一个图层中需要弹出框时，可以设置该回调函数，配置弹出框信息，只有一个弹出框的情况下，不需要设置此回调函数</p>
         *  @author wangsl
         *  @date 2017-03-23
         * */
        setTemplateCallBack: function (callback) {
            //
            this.templateCallBack = callback;
        },
        /**设置提示框回调函数，当一个图层中需要显示不同提示框时，设置此回调函数，只有一种提示时，不需要设置此回调函数
         * @author wangsl
         * @date 2017-03-23
         * */
        setTipsCallBack: function (callback) {
            //
            this.tipsCallBack = callback;
        },
        //
        __init: function (options) {
            //
            var _self = this;
            //
            var _map = options.map;
            //
            var graphicUtils = new DseGraphicUtils({
                map: options.map,
                mapType: options.mapType
            });
            /**当前鼠标位置.*/
            var mousePoint = null;
            //
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
                        var dx = parseFloat(data.geometry.x);
                        var dy = parseFloat(data.geometry.y);
                        //
                        var gra = null;
                        var sym = null;
                        if (_self.symbolCallBack) {
                            //
                            sym = _self.symbolCallBack(data["attributes"]);
                        }
                        else {
                            //
                            sym = dseSymbolUtils.createSimpleMakerSymbol({});
                        }
                        gra = graphicUtils.createPointGra(data["attributes"], dx, dy, sym);
                        //
                        if (_self.label && _self.label.visible) {
                            //显示标签
                            var textSym = dseSymbolUtils.createTextSymbol({
                                content: data.attributes[_self.label.field],
                                offsetX: 10,
                                offsetY: 10,
                                angle: 0.5,
                                fontSize: "11pt",
                                textColor: [255, 250, 250, 1]
                            });
                            //
                            var textGra = graphicUtils.createPointGra(data["attributes"], dx, dy, textSym);
                            _self.add(textGra);
                        }
                        _self.add(gra);
                    });
                }
            };
            //
            _self._parseLineResult = function (results) {
                //
                //获取坐标点数据.
                results.forEach(function (data) {
                    //
                    var geoJson = data.geometry.paths;
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
                        var gra = graphicUtils.createPolylineGra(geoJson, symbol, data["attributes"]);
                        gra.data = data;
                        _self.add(gra);
                    }
                });
            };
            //
            _self._layerClickHandler = function (event) {
                //
                var gra = event.graphic;
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
                var attributes = gra.attributes;
                var name = attributes.NAME;
                var proj_cd = attributes.PROJ_CD;
                var warn_count = attributes.WARN_COUNT;


                /**
                 * 增加图层弹出框回调，支持弹出不同类型的弹出框。
                 * @author wangsl
                 * @date 2017-03-23
                 * */
                if (typeof this.templateCallBack === "function") {
                    //
                    var info = gra.attributes || gra.data;
                    this.template = this.templateCallBack(info);
                }
                if (gra.data.hasOwnProperty(this.template.titleField)) {
                    //
                    title = gra.data[this.template.titleField];
                }
                //
                title += this.template.titleSuffix;
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
                    else if(this.template.type === "warn"){
                        if(proj_cd != "undefined" && warn_count !="undefined" && name && proj_cd && warn_count){
                            this._showInfoWindowFrom(this.template.url+proj_cd, title);
                        }

                    }
                }
            };
            _self._rowItemClickHandler = function (data) {
                //
                var gra = {
                    geometry: {},
                    attributes: data,
                    data: data
                };
                window.graphic = gra;
                var title = "";
                /**设置弹出框回调
                 * @author wangsl
                 * @date 2017-03-23
                 * */
                if (typeof this.templateCallBack === "function") {
                    //
                    this.template = this.templateCallBack(data);
                }
                //
                if (gra.data.hasOwnProperty(this.template.titleField)) {
                    //
                    title = gra.data[this.template.titleField];
                }
                //
                title += this.template.titleSuffix;
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
                var gra = rgs[0];
                if (gra) {
                    this._layerClickHandler({
                        graphic: gra
                    });
                }
                else {
                    //
                    this._rowItemClickHandler(data);
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
                    lblLayer = new GraphicsLayer({id: layerId});
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
                    //
                    if (typeof tipsCallBack === "function") {
                        //
                        //
                        var tipsCb = this._createTipsContent;
                        content = tipsCallBack(event.graphic, _self.tips, tipsCb);
                    }
                    else {
                        //
                        if (_self.tips.type === "img") {
                            //
                            var sub = this._createTipsListItems(event.graphic, _self.tips.fields, _self.tips.height);
                            //
                            var url = event.graphic.attributes[_self.tips.imgField] || _self.tips.imgUrl;
                            content = _self._createImageTipsContent(url, sub, _self.tips.width, _self.tips.height);
                        }
                        else {
                            content = this._createTipsContent(event.graphic, _self.tips.fields);
                        }
                    }
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
                    //
                    //
                    //
                    domStyle.set(domNode, {
                        //
                        height: _self.tips.height + "px"
                    });
                    $(domNode).addClass("u-map-info-tips");
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
                    _self._loadDynamicJsFile({id: "templateJs", url: _self.template.script});
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
                    //
                    if (_self.tips.type === "img") {
                        //
                        var ic = _self._createImageTipsContent(_self.tips.imgUrl, _self.tips.content);
                        //
                        _self._showGraphicTips(mousePoint, ic);
                    }
                    else {
                        //
                        var content = _self._createTipsContent(graphic, _self.tips.fields);
                        //
                        _self._showGraphicTips(mousePoint, content);
                    }
                }
            };
            //
        },
        /**
         * 执行查询.
         * */
        _executeQuery: function (data) {
            //
            var query = {};
            if (this.queryParamsCallback) {
                query = this.queryParamsCallback();
            }
            if (data.url) {
                //
                xhr(data.url, {
                    //
                    method: this.method,
                    handleAs: "json",
                    query: JSON.stringify(query)
                }).then(lang.hitch(this, this._loadDataHandler), lang.hitch(this, this._loadDataErrorHandler));
            }
        },
        /**
         * 用于显示已经获取到的数据.
         * @param data 需要显示的数据,
         * @param isNewData 是否重新显示数据, true 重新加载，false则显示@param data 的值.
         * */
        loadPointData: function (features) {
            //请求新的数据
            this._parsePointResult(features);
        },
        /** load polyline data .*/
        loadPolylineData: function (features) {
            //
            this._parseLineResult(features);
        },
        //
        loadPolygonData: function (features) {
            //
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
                    //
                    if (key) {
                        content += key + ":" + gra.attributes[v] + "<br>";
                    } else {
                        content += key + gra.attributes[v] + "<br>";
                    }

                }
            });
            //
            return content;
        },
        /**
         * <p>增加图片信息提示</p>
         * @author wangsl
         * @date 2017-03-01
         * */
        //
        _createImageTipsContent: function (url, content, width, height) {
            /**
             * <img src="images/icon1.png" alt="NOIMG" class="img-thumbnail" style="float: left; width: 300px; height: 300px;">
             <ul class="list-group" style="float: left; height: 300px;">
             <li class="list-group-item">Cras justo odio</li>
             <li class="list-group-item">Dapibus ac facilisis in</li>
             <li class="list-group-item">Morbi leo risus</li>
             <li class="list-group-item">Porta ac consectetur ac</li>
             <li class="list-group-item">Vestibulum at eros</li>
             </ul>
             * */
            var imgHtml = '<img src="' + url + '" alt="NOIMG" class="img-thumbnail" style="float: left; width:' + width + 'px; height:' + height + 'px;">';
            return imgHtml + content;
        },
        //
        _createTipsListItems: function (gra, fields, height) {
            //
            var content = '<ul class="list-group" style="float: left; height:' + height + 'px;">';
            /**
             * <ul class="list-group" style="float: left; height: 300px;">
             <li class="list-group-item">Cras justo odio</li>
             <li class="list-group-item">Dapibus ac facilisis in</li>
             <li class="list-group-item">Morbi leo risus</li>
             <li class="list-group-item">Porta ac consectetur ac</li>
             <li class="list-group-item">Vestibulum at eros</li>
             * */
            fields.forEach(function (field) {
                //
                for (var key in field) {
                    var v = field[key];
                    if (!gra.attributes[v]) {
                        gra.attributes[v] = "--";
                    }
                    content += '<li class="list-group-item"><spqn>' + key + "</spqn>:" + gra.attributes[v] + '</li>';
                }
            });
            //
            return content;
        },
        //
        _layerMouseOutHandler: function (event) {
            //
            if (this.tipsCtn) {
                //
                domUtils.hide(this.tipsCtn);
                // $(this.tipsCtn).hide();
            }
        },
        //
        isGroupLayer: false,
        /**清除指定组中的图形.
         * @param kf keyField.
         * @param kv keyValue.
         * */
        clearGroup: function (kf, kv) {
            //
            var gs = [].concat(this.graphics);
            var gsc = gs.length;
            for (var i = 0; i < gsc; i++) {
                //
                var g = gs[i];
                if (g.attributes[kf] === kv) {
                    //
                    this.remove(g);
                }
            }
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
            var top = $(window).height() / 2 - height / 2;
            var left = $(window).width() / 2 - width / 2;
            this._openWinIndex = layer.open({
                type: 2,
                title: title,
                // offset: '20px',
                shadeClose: false,
                shade: 0.3,
                area: [width + 'px', height + 'px'],
                content: url,
                closeBtn: 1,
                offset: [top + "px", left + "px"]
            });
            /* layer.open({
             type: 2,// iframe层
             title: title,//row.STNM.trim(),
             offset: '20px',
             shadeClose: false,
             shade: 0.3,
             area: [width + 'px', height + 'px'], // IE，火狐，chrome 1024*768 兼容
             content: url,//$.contextPath() + "/syqjc/dseStRiverR/toHdGisDetailPage.ds",
             closeBtn: 1
             });*/
        },
        hideInfoWindowFrom: function () {
            //
            layer.close(this._openWinIndex);
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
//# sourceMappingURL=QueryDisplayLayer.js.map