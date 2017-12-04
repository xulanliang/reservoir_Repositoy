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
    var _self = null;
    //
    var graphicUtils = null;
    /**当前鼠标位置.*/
    var mousePoint = null;
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
            _self = this;
            //
            this.symbolCallBack = options.symbolCallBack;
            //
            this.queryParamsCallback = options.queryParamsCallback;
            //
            //默认不显示信息弹出框
            this.template = options.template || {visible: false};
            // templateInfo=options.template||{visible:false};
            // _self.map = options.map;
            //默认不显示提示框
            // this.tips = options.tips || {visible: false};
            this.tipsCtn = this._createTipsContainer(this.tips.visible);
            graphicUtils = new DseGraphicUtils({
                map: options.map,
                mapType: options.mapType
            });
            //
            // _self.map.infoWindow.isShowing = false;
            //
            this.on("click", lang.hitch(this, this._layerClickHandler));
            this.on("mouse-over", lang.hitch(this, this._layerMouseOverHandler));
            this.on("mouse-out", lang.hitch(this, this._layerMouseOutHandler));
            // load data.
            if (this.url) {
                //
                if (_self.filter) {
                    //
                    this.url += "?" + _self.filter;
                }
                xhr(this.url, {
                    //
                    handleAs: "json",
                    method: this.method
                }).then(
                    lang.hitch(this, this._loadDataHandler),
                    lang.hitch(this, this._loadDataErrorHandler)
                );
            }
            //
            // compareField = options.compareField || "NAME";
        },
        /**
         * @return Array [esri.Graphic]
         * */
        _parseResult: function (results) {
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
                            } else {
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
        },
        _layerClickHandler: function (event) {
            //
            var gra = event.graphic;
            //
            var point = dseGisUtils.getGeomCenter(gra);
            //
            window.dseGisData.graphic = gra;
            // currentGra = gra;
            //
            //
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
            if (this.template.visible) {
                //
                if (this.template.type === "inner") {
                    //
                    if (templateContent) {
                        //
                        content = _.template(templateContent)(gra.data);
                        //
                        this._showInfoWindow(point, content, title, this.template.width, false);
                    } else {
                        //
                        require(["dojo/text!" + this.template.url], function (details) {
                            //
                            templateContent = details;
                            //
                            content = _.template(details)(gra.data);
                            _self._showInfoWindow(point, content, this.template.title, this.template.width, false);
                        });
                    }
                } else if (this.template.type === "outer") {
                    //
                    this._showInfoWindowFrom(this.template.url, this.template.title);
                }
            }
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
                }).then(
                    lang.hitch(this, this._loadDataHandler),
                    lang.hitch(this, this._loadDataErrorHandler)
                );
            }
        },
        /**
         * 用于显示已经获取到的数据.
         * @param data 需要显示的数据,
         * @param isNewData 是否重新显示数据, true 重新加载，false则显示@param data 的值.
         * */
        loadData: function (data, isNewData) {
            //
            // this._loadDataHandler(data);
            //请求新的数据
            if (isNewData) {
                //
                this._executeQuery(data);
            } else {
                //
                this._loadDataHandler(data);
            }
            //
            if (arguments[2]) {
                //
                _self = arguments[2];
            }
            // this._parseResult(data);
        },
        /**重新绑定图层实例*/
        bindCallRefReset: function (callRef) {
            //
            _self = callRef;
        },
        hideTips: function () {
            //
            domUtils.hide(_self.tipsCtn);
        },
        /**
         * 显示提示信息
         * */
        _layerMouseOverHandler: function (event) {
            //
            // var gra = event.graphic;
            var screenPoint = event.screenPoint;
            //
            mousePoint = screenPoint;
            //
            _self._currentGra = event.graphic;
            //
            if (this.tips.visible) {
                //
                var content = this._createTipsContent(event.graphic, this.tips.fields);
                //
                this._showGraphicTips(screenPoint, content);
            }
        },
        //
        _createTipsContent: function (gra, fields) {
            //
            var content = "";
            fields.forEach(function (field) {
                //
                for (var key in  field) {
                    var v = field[key];
                    content += key + ":" + gra.attributes[v] + "<br>";
                }
            });
            //
            return content;
        },
        _createTipsContainer: function (isCreate) {
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
                    "font-size": "10px",
                    "border": "1px solid #0096ff",
                    "padding": "0.1em 0.3em 0.1em",
                    "font-size": "11px",
                    "border-radius": "3px",
                    "box-shadow": "0 0 0.75em #777777",
                    "overflow": "hidden"
                });
            }
            //
            return domNode;
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
        _loadDataHandler: function (data) {
            //解析查询结果，创建Graphic.
            this.clear();
            this._parseResult(data);
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
        /**
         *
         * */
        _showInfoWindow: function (point, content, title, width, iscolse) {
            if (!point || !content) {
                return;
            }
            _self.map.infoWindow.setContent(content);
            $(".titlePane").css("backgroundColor", "#1468b4");//标题栏的背景颜色
            $(".titlePane").css("font-size", "15px");//标题栏的字体大小
            if (width && width != "") {
                $(".sizer").css("width", width);
            } else {
                $(".sizer").css("width", "270px");
            }
            _self.map.infoWindow.setTitle(dseGisUtils.nullToSpace(title));
            if (iscolse && iscolse == true) {
                $(".close").css("display", "none");
            }
            //移除按钮
            $(".maximize").remove();
            //
            _self.map.infoWindow.show(point);//new Point(113.343125,23.987933)
            //记载InfoWindow脚本文件
            if (this.template.script) {
                //
                _self._loadDynamicJsFile({id: "templateJs", url: this.template.script});
            }
            //load
            /* require(["dse_gis/demo/Test"], function (Test) {
             //
             Test.setGraphic(currentGra);
             });*/
        },
        /***
         * 调用外部链接，显示详情
         * */
        _showInfoWindowFrom: function (url, title) {
            //
            //
            var width = this.template.width || "750";
            var height = this.template.height || "600";
            layer.open({
                type: 2,// iframe层
                title: title,//row.STNM.trim(),
                offset: '20px',
                shadeClose: false,
                shade: 0.3,
                area: [width + 'px', height + 'px'], // IE，火狐，chrome 1024*768 兼容
                content: url,//$.contextPath() + "/syqjc/dseStRiverR/toHdGisDetailPage.ds",
                closeBtn: 1
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
        _updateData: function (graphic) {
            //
            //
            if (this.tips.visible && this.isRealTime) {
                //
                var content = this._createTipsContent(graphic, this.tips.fields);
                //
                this._showGraphicTips(mousePoint, content);
            }
        },
        /**需要显示实时数据的点集合*/
        //
        tipNames: [],
        /**是否在集合内**/
        _isInArray: function (name) {
            //
            var state = this.tipNames.some(function (tipName) {
                //
                return name === tipName;
            });
            //
            return state;
        },
        //
        _getScreenPoint: function (graphic) {
            return _self.map.toScreen(graphic.geometry);
        }
    });
    //
    return moClass;

});
