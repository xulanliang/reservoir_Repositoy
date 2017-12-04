/**
 * Created by Administrator on 2016/10/14.
 */
//执行所有的业务查询操作.
define(["dojo/dom", "dojo/on", "dojo/Evented",
    "dojo/_base/declare", "dojo/request/xhr",
    "dojo/_base/lang"
], function (dom, on, Evented, declare, xhr, lang) {
    //return
    //
    /**
     * ajax请求，系统中所有的$.ajax用dse.ajax替代 url：请求地址 contentType：内容类型
     * 默认application/json;charset=UTF-8 formid：表单ID，用于获取from表单数据自动组装成json数据
     * type：POST GET target：当前触发的事件对象 progressBar：是否显示进度条，默认显示，true显示 false不显示
     */
    var dse = {};
    dse.ajax = (function () {
        var ajax = function (cfg) {
            // 进度条背景div，进度提示div
            //var ajaxbg = $("#progressBarBackground,#progressBar");
            //var ajaxbg = $("#progressBarBackground,#progressBar", window.parent.document);
            //if (cfg.progressBar == undefined || cfg.progressBar == true) {
            //	ajaxbg.show();
            //} else {
            //	ajaxbg.hide();
            //}
            var cfg = $.extend({}, cfg);
            // 防止缓存
            cfg.url += (cfg.url.indexOf('?') == -1 ? '?' : '&') + '___=' + Math.random();
            // 防止重复提交
            if (cfg.target) {
                cfg.target.attr('disabled', 'disabled');
            }
            if (cfg.type == undefined) {
                cfg.type = "POST";
            }
            if (cfg.contentType == "json") {
                cfg.contentType = "application/json;charset=UTF-8";
            }
            /* 自动获取form中的表单数据，以json格式传输 */
            /*  if (cfg.formid) {
             cfg.data = $.extend(cfg.data, formToJson(cfg.formid));
             }*/
            // 执行请求
            //
            var target = $.ajax(cfg);
            return target.complete(function () {
                // 隐藏进度条
                //ajaxbg.hide();
                if (cfg.target) {
                    cfg.target.attr('disabled', false);
                }
            }).error(function () {
                // 隐藏进度条
                //ajaxbg.hide();
                if (cfg.target) {
                    cfg.target.attr('disabled', false);
                }
            });
        };
        return ajax;
    })();
    return declare([Evented], {
        //
        QUERY_LIST_VIEW_COMPLETED: "queryListViewCompleted",
        QUERY_PIE_CHART_COMPLETED: "queryPieChartCompleted",
        QUERY_ERROR: "queryError",
        method: "GET",
        /**
         * Call back
         * */
        pieDataParser: null,
        /**
         * Call back
         * */
        columnDataParser: null,
        //
        constructor: function (url, options) {
            //
            lang.mixin(this, options);
            this.url = url;
        },
        //
        loadData: function (paramOpt, pieCb, colCb) {
            //
            var params = {
                handleAs: "json",
                method: this.method,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                },
                data: paramOpt
            };
            //
            this._pieCb = (typeof pieCb === "function") ? pieCb : null;
            this._colCb = (typeof colCb === "function") ? colCb : null;
            xhr(this.url, params).then(lang.hitch(this, this._queryInfoRightHandler), lang.hitch(this, this._queryInfoErrorHandler));
        },
        /**jQuery 获取数据*/
        loadAjaxData: function (paramOpt, pieCb, colCb) {
            //
            var self = this;
            //
            this._pieCb = (typeof pieCb === "function") ? pieCb : null;
            this._colCb = (typeof colCb === "function") ? colCb : null;
            dse.ajax({
                url: this.url,
                data: JSON.stringify(paramOpt),
                contentType: 'json',
                success: function (data) {
                    //
                    self._queryInfoRightHandler(data.data);
                    /* if (data.success == "true") {
                     self._queryInfoRightHandler(data.data);
                     } else {
                     self._queryInfoErrorHandler(data.data);
                     }*/
                },
                error: function (error) {
                    //
                    self._queryInfoRightHandler(error);
                }
            });
        },
        //
        _queryInfoRightHandler: function (data) {
            //
            if (this.pieDataParser && typeof this.pieDataParser === "function") {
                //
                var pieData = this.pieDataParser(data);
                //
                if (this._pieCb) {
                    //
                    this._pieCb(pieData);
                }
                else {
                    //
                    this.emit(this.QUERY_PIE_CHART_COMPLETED, pieData);
                }
            }
            //
            if (this.columnDataParser && typeof this.columnDataParser === "function") {
                //
                var columnData = this.columnDataParser(data);
                //
                if (this._colCb) {
                    //
                    this._colCb(columnData);
                }
                else {
                    //
                    this.emit(this.QUERY_LIST_VIEW_COMPLETED, columnData);
                }
            }
        },
        _queryInfoErrorHandler: function (error) {
            //
            this.emit(this.QUERY_ERROR, error);
        }
    });
});
//# sourceMappingURL=QueryInfoTask.js.map