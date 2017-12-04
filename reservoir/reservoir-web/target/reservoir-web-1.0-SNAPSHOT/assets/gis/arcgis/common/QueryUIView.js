/**
 * Created by Administrator on 2016/10/14.
 */
//本模块用于创建饼图和查询查询列表.
define(["dojo/dom", "dojo/on", "dojo/dom-construct",
    "dojo/string", "dojo/_base/declare",
    "dojo/_base/array",
    "./resolution"
], function (dom, on, domConstruct, string, declare, arrayUtils, res) {
    //
    return declare(null, {
        //
        constructor: function (options) {
            //
            this._ec = window.echarts;
            this.parentCtn = $(options.ctn);
            //
            //
            var ctnWidth = $(this.parentCtn).width();
            var ctnHeight = $(this.parentCtn).height();
            //
            var offsetX = options.offsetX || 0;
            var offsetY = options.offsetY || 46;
            this.contentOffset = options.oc || 1000;
            //
            this.ctnW = ctnWidth;
            this.ctnH = ctnHeight > 0 ? (ctnHeight - offsetY) : 0;
            this.windowWidth = $(window).width();
            this.winHeight = $(window).height() + res.offset;
        },
        //
        setCtnOffset: function (options) {
            //
            var offsetX = options.ox || 0;
            var offsetY = options.oy || 46;
            //
            var defaultWidth = this.getDefaultWidth();
            var defaultHeight = this.getDefaultHeight();
            this.ctnW = ($(this.parentCtn).width() || defaultWidth) - offsetX;
            this.ctnH = ($(this.parentCtn).height() || defaultHeight) - offsetY;
            //
            this.contentOffset = options.oc || 1000;
        },
        /**
         * <description>创建饼图图表展示.</description>
         * */
        loadPieChartView: function (domNode, data, isOneMoreCtn) {
            //
            if (data) {
                //
                var w = this.ctnW || this.getDefaultWidth();
                var h = this.ctnH || this.getDefaultHeight();
                if (isOneMoreCtn) {
                    //
                    $(domNode).css({
                        //
                        width: w + "px",
                        height: (h / 2) + "px"
                    });
                }
                else {
                    $(domNode).css({
                        //
                        width: w + "px",
                        height: h + "px"
                    });
                }
                var pieChart = this._ec.init(domNode);
                pieChart.setOption(data, false);
                this._pieChart = pieChart;
            }
        },
        //
        clearPieChartView: function () {
            this._pieChart.clear();
        },
        //
        setCtnSize: function (domNode, container, isOneMore) {
            var w = this.ctnW || this.getDefaultWidth();
            var h = this.ctnH || this.getDefaultHeight();
            var oc = this.contentOffset;
            if (isOneMore) {
                // two container.
                $(container).css({
                    //
                    width: w + "px",
                    height: (h / 2) + "px"
                });
            }
            else {
                // one container.
                $(container).css({
                    //
                    width: w + "px",
                    height: h + "px"
                });
            }
            //
            $(container).find("table").css({
                width: (w + oc) + "px"
            }).show();
        },
        /**
         * <description>创建查询显示的列表</description>
         * @param data {Javascript Array} 需要显示的数据
         * @param options {Javascript Object}
         * @example options:{
         *
         * domNode:HTMLElement, 承载显示的UI元素.
         * rowViewCallBack:Function 处理需要显示数据
         * dblClickCallBack:Function 双击元素时触发的函数。
         * }
         * */
        _loadListViewData: function (data, options, isResize) {
            //var
            var domNode = options.domNode;
            //
            var listCtn = options.container;
            //
            this.setCtnSize(domNode, listCtn, isResize);
            var infoCallback = options.rowViewCallBack;
            var dblClickHandler = options.dblClickCallBack;
            //
            var clickHandler = options.clickCallBack;
            //
            //清除上一步结果
            // domConstruct.empty();
            // $(domNode).empty();
            var results = data;
            //
            arrayUtils.forEach(results, function (row, iindex) {
                //
                var info = infoCallback(row, iindex);
                var rowItem = domConstruct.create("tr", {
                    //
                    innerHTML: info,
                    style: "cursor: pointer;height: 32px;"
                }, domNode);
                // 修复单击和双击事件失效.
                /*if (dblClickHandler && typeof dblClickHandler === "function") {
                 //
                 on(rowItem, "dblclick", function (event) {
                 // alert("you double click!");
                 dblClickHandler(row);
                 });

                 }
                 //添加单击事件
                 if (clickHandler && typeof clickHandler === "function") {
                 on(rowItem, "click", function (event) {
                 //
                 // alert(" click me");
                 clickHandler(row);
                 });
                 }*/
                //bind events.
                var clicks = 0, self = this;
                $(rowItem).click(function () {
                    clicks++;
                    if (clicks == 1) {
                        setTimeout(function () {
                            if (clicks == 1) {
                                // single click.
                                if (clickHandler && typeof clickHandler === "function") {
                                    clickHandler.call(self, row);
                                }
                                // alert("you single click !");
                            }
                            else {
                                //double click.
                                if (dblClickHandler && typeof dblClickHandler === "function") {
                                    dblClickHandler.call(self, row);
                                }
                                // alert("you double click me !");
                            }
                            clicks = 0;
                        }, 500);
                    }
                });
            });
        },
        //
        /**
         * <description>创建查询显示的列表</description>
         * @param data {Javascript Array} 需要显示的数据
         * @param options {Javascript Object}
         * @example options:{
         *
         * domNode:HTMLElement, 承载显示的UI元素.
         * rowViewCallBack:Function 处理需要显示数据
         * dblClickCallBack:Function 双击元素时触发的函数。
         * }
         * */
        _loadListViewDataWithBtn: function (data, options, isResize) {
            //var
            var domNode = options.domNode;
            //
            var listCtn = options.container;
            //
            this.setCtnSize(domNode, listCtn, isResize);
            var infoCallback = options.rowViewCallBack;
            var dblClickHandler = options.dblClickCallBack;
            //
            var clickHandler = options.clickCallBack;
            //
            //清除上一步结果
            // domConstruct.empty();
            // $(domNode).empty();
            var results = data;
            //
            arrayUtils.forEach(results, function (row, iindex) {
                //
                var info = infoCallback(row, iindex);
                //
                var rowItem = domConstruct.create("tr", {
                    //
                    innerHTML: info,
                    style: "cursor: pointer;height: 32px;"
                }, domNode);
                //
                var btnCtn = domConstruct.create("td", {}, rowItem);
                //
                var loc = domConstruct.create("a", {
                    innerHTML: "定位"
                }, btnCtn);
                //
                $(loc).addClass("u-details-link");
                var details = domConstruct.create("a", {
                    innerHTML: "详情"
                }, btnCtn);
                //
                $(details).addClass("u-details-link");
                //
                on(loc, "click", function (event) {
                    //
                    if (clickHandler && typeof clickHandler === "function") {
                        clickHandler.call(this, row);
                    }
                });
                //
                on(details, "click", function (event) {
                    //
                    if (dblClickHandler && typeof dblClickHandler === "function") {
                        dblClickHandler.call(this, row);
                    }
                });
            });
        },
        /**
         * <description>创建查询显示的列表</description>
         * @param data {Javascript Array} 需要显示的数据
         * @param options {Javascript Object}
         * @example options:{
         *
         * domNode:HTMLElement, 承载显示的UI元素.
         * rowViewCallBack:Function 处理需要显示数据
         * dblClickCallBack:Function 双击元素时触发的函数。
         * }
         * */
        _loadListViewDataWithCheck: function (data, options, isResize) {
            //var
            var domNode = options.domNode;
            //
            var listCtn = options.container;
            //
            this.setCtnSize(domNode, listCtn, isResize);
            var infoCallback = options.rowViewCallBack;
            var dblClickHandler = options.dblClickCallBack;
            //
            var clickHandler = options.clickCallBack;
            //
            var checkStateHandler = options.checkStateCallBack;
            //
            //清除上一步结果
            // domConstruct.empty();
            // $(domNode).empty();
            var results = data;
            //
            arrayUtils.forEach(results, function (row, iindex) {
                //
                var info = infoCallback(row, iindex);
                //
                var rowItem = domConstruct.create("tr", {}, domNode);
                //
                //
                var checkCtn = domConstruct.create("td", {}, rowItem);
                //
                var lbl = domConstruct.create("label", {
                    style: "cursor:pointer;"
                }, checkCtn);
                //
                var chk = domConstruct.create("input", {
                    type: "checkbox"
                }, lbl);
                //
                if (typeof checkStateHandler === "function") {
                    //
                    checkStateHandler(row, chk);
                }
                //
                on(chk, "change", function (event) {
                    //
                    if (clickHandler && typeof clickHandler === "function") {
                        //
                        row.isChecked = this.checked;
                        clickHandler.call(this, row);
                    }
                });
                //
                $(rowItem).append(info);
            });
        },
        /** */
        loadListView: function (columnData, options, tipsNode, isResize) {
            //
            var temp = this._createNoDataTip(tipsNode);
            //
            $(options.domNode).empty();
            // var nodes = $(".u-no-data-ctn");
            if (columnData && columnData.length > 0) {
                this._loadListViewData(columnData, options, isResize);
                // this._changeDataState(nodes, false);
                if (temp) {
                    $(temp).hide();
                }
            }
            else {
                // this._changeDataState(nodes, true);
                if (temp) {
                    $(temp).show();
                }
            }
        },
        //
        /** */
        loadListViewWithBtn: function (columnData, options, tipsNode, isResize) {
            //
            var temp = this._createNoDataTip(tipsNode);
            //
            $(options.domNode).empty();
            // var nodes = $(".u-no-data-ctn");
            if (columnData && columnData.length > 0) {
                this._loadListViewDataWithBtn(columnData, options, isResize);
                // this._changeDataState(nodes, false);
                if (temp) {
                    $(temp).hide();
                }
            }
            else {
                // this._changeDataState(nodes, true);
                if (temp) {
                    $(temp).show();
                }
            }
        },
        /**加载带复选框的列表.*/
        loadListViewWithCheck: function (columnData, options, tipsNode, isResize) {
            //
            var temp = this._createNoDataTip(tipsNode);
            //
            $(options.domNode).empty();
            // var nodes = $(".u-no-data-ctn");
            if (columnData && columnData.length > 0) {
                this._loadListViewDataWithCheck(columnData, options, isResize);
                // this._changeDataState(nodes, false);
                if (temp) {
                    $(temp).hide();
                }
            }
            else {
                // this._changeDataState(nodes, true);
                if (temp) {
                    $(temp).show();
                }
            }
        },
        //
        _createNoDataTip: function (nodeid) {
            //
            if (nodeid) {
                var el = document.getElementById(nodeid + "-tips");
                if (!el) {
                    el = domConstruct.create("div", {
                        //
                        id: nodeid + "-tips",
                        class: "u-no-data-ctn",
                        innerHTML: "没有查询的结果"
                    }, dom.byId(nodeid));
                }
                return el;
            }
            else {
                return null;
            }
        },
        /**加载可伸缩列表*/
        loadMultiLevelListView: function (columnData, options, tipsNode, isResize) {
            //
            var temp = this._createNoDataTip(tipsNode);
            //
            $(options.domNode).empty();
            // var nodes = $(".u-no-data-ctn");
            if (columnData && columnData.length > 0) {
                var cacheData = this._groupDataByCode(columnData);
                //
                if (cacheData) {
                    this._createMultiDataListView(cacheData, options, isResize);
                }
                if (temp) {
                    $(temp).hide();
                }
            }
            else {
                if (temp) {
                    $(temp).show();
                }
            }
        },
        //
        _createMultiDataListView: function (data, options, isResize) {
            //
            var domNode = options.domNode;
            //
            var listCtn = options.container;
            //
            this.setCtnSize(domNode, listCtn, isResize);
            // this._setDomNodeSize(listCtn, isResize);
            var infoCallback = options.rowViewCallBack;
            var dblClickHandler = options.dblClickCallBack;
            //
            var clickHandler = options.clickCallBack;
            //
            var tableHeaderCallBack = options.headViewCallBack;
            //
            var cacheData = data;
            //
            for (var key in cacheData) {
                //
                (function (key) {
                    var d = cacheData[key];
                    //
                    /*var item = "<td>" + d.name + "(" + d.items.length + ")" + "</td>" +
                     "<td>" + d.code + "</td>";*/
                    var item = tableHeaderCallBack(d);
                    //
                    var sub = item.substring(4, item.length);
                    //
                    item = "<td><img src='images/list-left.png'>" + sub;
                    //
                    // console.log(item.substring(4, item.length));
                    var tr = document.createElement("tr");
                    $(tr).addClass("u-data-view");
                    tr.setAttribute("data-flag", "item-" + key);
                    //
                    var itemClicked = true;
                    $(tr).html(item)
                        .on("click", function () {
                        //
                        var self = this;
                        //
                        if (itemClicked) {
                            itemClicked = false;
                            //
                            var items = d.items;
                            //
                            items.forEach(function (d2) {
                                //
                                /*var item1 = "<td>" + d2.name + "</td>" +
                                 "<td>" + d2.code + "</td>";*/
                                var item1 = infoCallback(d2);
                                //
                                var tr1 = document.createElement("tr");
                                $(tr1).addClass("u-data-view-item" + key);
                                tr1.innerHTML = item1;
                                $(tr1).insertAfter(self);
                                //
                                var clicks = 0;
                                $(tr1).click(function () {
                                    clicks++;
                                    if (clicks == 1) {
                                        setTimeout(function () {
                                            if (clicks == 1) {
                                                // single click.
                                                if (clickHandler && typeof clickHandler === "function") {
                                                    clickHandler.call(self, d2);
                                                }
                                                // alert("you single click !");
                                            }
                                            else {
                                                //double click.
                                                if (dblClickHandler && typeof dblClickHandler === "function") {
                                                    dblClickHandler.call(self, d2);
                                                }
                                                // alert("you double click me !");
                                            }
                                            clicks = 0;
                                        }, 500);
                                    }
                                });
                                //
                            });
                        }
                        else {
                            itemClicked = true;
                            //
                            $(".u-data-view-item" + key).each(function (idx, item) {
                                //
                                $(this).remove();
                            });
                        }
                    });
                    //
                    $(domNode).append(tr);
                })(key);
            }
        },
        //
        _groupDataByCode: function (ins) {
            //
            var cacheData = {};
            ins.forEach(function (d) {
                //
                var dataKey = d.code.substring(0, d.code.length - 2);
                //
                if (cacheData.hasOwnProperty(dataKey)) {
                    //
                    cacheData[dataKey].items.push(d);
                }
                else {
                    //
                    var item = $.extend({
                        items: []
                    }, d);
                    //
                    cacheData[dataKey] = item;
                    //
                    cacheData[dataKey].items.push(d);
                }
            });
            //
            return cacheData;
        },
        /* _changeDataState: function (nodes, isVisible) {

         if (nodes && nodes.length > 0) {
         nodes.each(function (index, item) {
         //
         if (isVisible) {
         $(item).show();
         } else {
         $(item).hide();
         }
         });
         }
         },*/
        //
        /**
         * 获取时间
         * */
        createQueryTime: function (domNodeID) {
            //
            //
            var target = $(domNodeID);
            var inTime = target.datebox("getValue");
            var subTimes = inTime.split(" ");
            return subTimes[0];
        },
        /**
         * 初始化时间查询框
         * */
        initQueryTimeBox: function (doms) {
            //
            var self = this;
            if (doms) {
                doms.forEach(function (d) {
                    //
                    var w = self.windowWidth;
                    //
                    var target = $(d);
                    if (w >= res.RES_1600_900.width) {
                        //width:150px;
                        target.css("width", "150px");
                        target.datetimebox({
                            // value: '3/4/2010 2:3',
                            required: true,
                            showSeconds: false,
                            value: new Date().toString(),
                            formatter: self._formatterQueryTime
                        });
                    }
                    else if (w >= res.RES_1360_768.width && w < res.RES_1600_900.width) {
                        //
                        target.css("width", "130px");
                        target.datetimebox({
                            // value: '3/4/2010 2:3',
                            required: true,
                            showSeconds: false,
                            value: new Date().toString(),
                            formatter: self._formatterQueryTime
                        });
                        //
                    }
                    else if (w < res.RES_1360_768.width) {
                        //
                        target.css("width", "120px");
                        target.datetimebox({
                            // value: '3/4/2010 2:3',
                            required: true,
                            showSeconds: false,
                            value: new Date().toString(),
                            formatter: self._formatterQueryTime
                        });
                    }
                    //
                    // $(d).css("width", "120px");
                    // $(d).datetimebox({
                    //     // value: '3/4/2010 2:3',
                    //     required: true,
                    //     showSeconds: false,
                    //     value: new Date().toString(),
                    //     formatter: self._formatterQueryTime
                    // });
                });
            }
        },
        /**
         * 初始化行政区划对话框
         * @param nid required
         * @param cb required
         * */
        initQueryRegionBox: function (/**String node id*/ nid, /**Function */ cb) {
            //
            /**
             * 需要后期与前端框架保持一致，待修改.
             * @author wangsl
             * @date 2017-03-10
             * */
            /*var w = this.windowWidth;
            if (w >= res.RES_1600_900.width) {
                //
                $(nid).combotree({
                    data: divisionInfo,
                    width: '200px',
                    height: "29px",
                    editable: false,
                    parentField: "PID",
                    idFiled: "CODE",
                    textFiled: "NAME",
                    prompt: '-请选择行政区域-',
                    // panelWidth: "268",
                    onLoadSuccess: function (data) {
                        treeSetDefVal($(nid));
                    },
                    onSelect: function (rec) {
                        $(nid).combotree('setValue', rec.ID);
                        cb(rec);
                    },
                    // onChange: cb
                });
            } else if (w >= res.RES_1360_768.width && w < res.RES_1600_900.width) {
                //
                $(nid).combotree({
                    data: divisionInfo,
                    width: '138px',
                    height: "28px",
                    editable: false,
                    parentField: "PID",
                    idFiled: "CODE",
                    textFiled: "NAME",
                    prompt: '-请选择行政区域-',
                    // panelWidth: "268",
                    onLoadSuccess: function (data) {
                        treeSetDefVal($(nid));
                    },
                    onSelect: function (rec) {
                        $(nid).combotree('setValue', rec.ID);
                        cb(rec);
                    },
                    // onChange: cb
                });
                //
            } else if (w < res.RES_1360_768.width) {
                //
                $(nid).combotree({
                    data: divisionInfo,
                    width: '158px',
                    height: "29px",
                    editable: false,
                    parentField: "PID",
                    idFiled: "CODE",
                    textFiled: "NAME",
                    prompt: '-请选择行政区域-',
                    // panelWidth: "268",
                    onLoadSuccess: function (data) {
                        treeSetDefVal($(nid));
                    },
                    onSelect: function (rec) {
                        $(nid).combotree('setValue', rec.ID);
                        cb(rec);
                    },
                    // onChange: cb
                });
            }*/
        },
        //
        _formatterQueryTime: function (date) {
            //
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            var h = date.getHours();
            return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
        },
        /**获取面板默认宽度*/
        getDefaultWidth: function () {
            //
            //
            var winWidth = $(window).width();
            var width = 0;
            if (winWidth >= res.RES_1600_900.width) {
                //
                width = 410;
            }
            else if (winWidth >= res.RES_1360_768.width && winWidth < res.RES_1600_900.width) {
                //
                width = 300;
            }
            else if (winWidth < res.RES_1360_768.width) {
                //
                width = 280;
            }
            return width;
        },
        /**获取面板默认高度*/
        getDefaultHeight: function () {
            //
            var winWidth = $(window).width();
            var width = 0;
            if (winWidth >= res.RES_1600_900.width) {
                //
                width = 874;
            }
            else if (winWidth >= res.RES_1360_768.width && winWidth < res.RES_1600_900.width) {
                //
                width = 694;
            }
            else if (winWidth < res.RES_1360_768.width) {
                //
                width = 562;
            }
            return width;
        },
    });
});
//# sourceMappingURL=QueryUIView.js.map