/**
 * Created by Administrator on 2016/8/26.
 */
//
define([
    "dojo/_base/declare",
    "dojo/_base/lang",
    "../utils/dseGisUtils"
], function (declare, lang, dseGisUtils) {
    //
    return declare(null, {
        /**
         * show details window.
         * */
        // showInfoDetailsWin: null,
        constructor: function (map, options) {
            //options:
            //map: esri.Map
            //url:  template url.
            //script: template js
            lang.mixin(this, options);
            this._init(map, options);
        },
        //
        _init: function (map, options) {
            //
            var _self = null;
            //
            var _map = null;
            //
            var infoTemplate = null;
            //
            var templateContent = "";
            //
            var currentGra = null;
            //
            _map = map;
            _self = this;
            //
            infoTemplate = options || {};
            /**
             * 设置弹出框模板信息
             * */
            _self.setTemplate = function (info) {
                //
                if (info) {
                    //
                    infoTemplate.url = info.url;
                    infoTemplate.script = info.script;
                    infoTemplate.titleField = info.titleField;
                }
            };
            //
            //是否刷新数据
            _self.isRefreshData = true;
            /**
             * 弹出信息窗口
             * */
            _self.showInfoWindow = function (gra) {
                //
                var point = dseGisUtils.getGeomCenter(gra);
                //
                window.dseGisData.graphic = gra;
                currentGra = gra;
                //
                var content = "";
                var title = "";
                //
                if (gra.data.hasOwnProperty(infoTemplate.titleField)) {
                    //
                    title = gra.data[infoTemplate.titleField];
                }
                //
                if (infoTemplate.visible) {
                    //
                    if (infoTemplate.type === "inner") {
                        //
                        if (_self.isRefreshData) {
                            //
                            require(["dojo/text!" + infoTemplate.url], function (details) {
                                //
                                templateContent = details;
                                //
                                content = _.template(details)(gra.data);
                                _self._showInfoWindow(point, content, title, infoTemplate.width, false);
                                _self.isRefreshData = false;
                            });
                        }
                        else {
                            //
                            content = _.template(templateContent)(gra.data);
                            //
                            this._showInfoWindow(point, content, title, infoTemplate.width, false);
                        }
                    }
                    else if (infoTemplate.type === "outer") {
                        //
                        this._showInfoWindowFrom(infoTemplate.url, title);
                    }
                }
            };
            //
            _self._layerPopupIndex = null;
            /**
             * 隐藏信息框
             * */
            _self.hideInfoWindow = function () {
                //
                if (infoTemplate.type === "inner") {
                    //
                    _map.infoWindow.hide();
                }
                else if (infoTemplate.type === "outer") {
                    //
                    layer.close(this._layerPopupIndex);
                }
            };
            /**
             *
             * */
            _self._showInfoWindow = function (point, content, title, width, iscolse) {
                if (!point || !content) {
                    return;
                }
                _map.infoWindow.setContent(content);
                $(".titlePane").css("backgroundColor", "#1468b4"); //标题栏的背景颜色
                $(".titlePane").css("font-size", "15px"); //标题栏的字体大小
                if (width && width != "") {
                    $(".sizer").css("width", width);
                }
                else {
                    $(".sizer").css("width", "270px");
                }
                _map.infoWindow.setTitle(dseGisUtils.nullToSpace(title));
                if (iscolse && iscolse == true) {
                    $(".close").css("display", "none");
                }
                //移除按钮
                $(".maximize").remove();
                //
                _map.infoWindow.show(point); //new Point(113.343125,23.987933)
                //记载InfoWindow脚本文件
                if (infoTemplate.script) {
                    //
                    _self._loadDynamicJsFile({ id: "templateJs", url: infoTemplate.script });
                }
            };
            /***
             * 调用外部链接，显示详情
             * */
            _self._showInfoWindowFrom = function (url, title) {
                //
                var width = infoTemplate.width || "750";
                var height = infoTemplate.height || "600";
                //
                var geo = dseGisUtils.getGeomCenter(currentGra);
                //
                var pnt = _map.toScreen(geo);
                //
                var left = pnt.x + 13;
                var top = pnt.y - height / 2;
                _self._layerPopupIndex = layer.open({
                    type: 2,
                    title: title,
                    shadeClose: false,
                    shade: 0.3,
                    area: [width + 'px', height + 'px'],
                    content: url,
                    closeBtn: 1,
                    offset: [top + "px", left + "px"]
                });
            };
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
        }
    });
});
//# sourceMappingURL=PopupUtils.js.map