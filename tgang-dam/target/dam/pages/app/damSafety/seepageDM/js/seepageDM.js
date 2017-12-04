seajs.data.alias.easyui_edit = window._baseUrl + "pages/app/damSafety/pointBinding/js/extendEditDatagrid.js";
dseDefine('../js/seepageDM', ['jquery', 'easyui', 'easyui_lang', 'common', 'layer', 'easyui_edit'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');

        var egrid = require('easyui_edit');
        var extendDatagrid = egrid.editorCell1;
        var layer = require('layer');
        layer.config({
            path: window._baseUrl+'assets/win/layer/' //layer.js所在的目录，可以是绝对目录，也可以是相对目录
        });

        var queryTime = 1, oldData, oldValue, ennmcd, newValue, stcd;
        var myModule = {

            loadReservoir: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/getReservoirList.do',
                    type: "post",
                    data: JSON.stringify({
                        ennm : ''
                    }),
                    contentType: 'application/json',
                    success: function (data) {
                        $('#reservoir').combobox({
                            width: '150px',
                            height: '25px',
                            editable: false,
                            valueField: 'ennmcd',
                            panelHeight: 'auto',
                            textField: 'ennm',
                            data: data,
                            onChange: function(n, o) {
                                ennmcd = n;
                                myModule.loadGrid();
                            },
                            onLoadSuccess: function () {
                                var data = $('#reservoir').combobox('getData');
                                ennmcd = data[0].ennmcd;
                                $("#reservoir").combobox('setValue', ennmcd);
                            }
                        });
                    }
                });
            },

            loadGrid: function() {
                var sdate = $('#start').datebox('getValue');//获取开始日期
                var edate = $('#end').datebox('getValue');//获取结束日期
                var arrStartDate = sdate.split("-");
                var arrEndDate = edate.split("-");
                var d1 = new Date(arrStartDate[0], arrStartDate[1], arrStartDate[2]);
                var d2 =  new Date(arrEndDate[0], arrEndDate[1], arrEndDate[2]);
                if (d1.getTime() > d2.getTime() ) {
                    layer.msg('开始时间不能大于结束时间!', {
                        offset : '30%',
                        shift : 0,
                        time : 1500,
                        icon : 5
                    });
                    return false;
                }
                $.ajax({
                    url: window._baseUrl + "BasicDataCtl/getSeepageList.do",
                    data: JSON.stringify({
                        ennmcd : ennmcd,
                    }),
                    contentType: 'application/json',
                    success: function (result) {
                        if (result != null) {
                            stcd = result[0].stcd;
                            $.ajax({
                                url : window._baseUrl + "BasicDataCtl/getSeepageList.do",
                                data:  JSON.stringify({
                                    ennmcd : ennmcd,
                                    sdate: sdate,
                                    edate: edate
                                }),
                                contentType: 'application/json',
                                success : function(result) {
                                    if (result.length > 0) {
                                        queryTime += 1;
                                        oldData = myModule.clone(result);
                                        var obj = new Object();
                                        obj.rows = result;
                                        obj.total = result.length;
                                        $('#datagrid').datagrid({
                                            data: obj,
                                            onClickCell: extendDatagrid.onClickCell,
                                            onAfterEdit: myModule.onAfterEdit,
                                            onSelect: function (index, row) {
                                                $('#tool input').removeAttr('disabled');
                                            },
                                        });

                                        $(document).on('click', function (e) {
                                            var target = $(e.target);
                                            var divTarget = $('.datagrid-wrap');
                                            if (target.closest(divTarget).length === 0) {
                                                if (extendDatagrid.lastIndex != undefined && extendDatagrid.lastIndex != extendDatagrid.penultIndex) {
                                                    $('#datagrid').datagrid('endEdit', extendDatagrid.lastIndex);
                                                }
                                            }
                                        });

                                        $('#tool input').attr("disabled", "true");
                                        $('#search').removeAttr("disabled");
                                        $('#addBtd').removeAttr("disabled");

                                    }
                                }
                            });
                        }
                    }
                });

            },

            initSearchTm:function(){
                //初始化开始日期控件
                $("#start").datebox({
                    editable:false
                });
                //初始化结束日期控件
                $("#end").datebox({
                    editable:false
                });
                var nowTm = new Date();//获取当前时间
                var year = nowTm.getFullYear();//获取年份
                var month = nowTm.getMonth()+1;//获取月份
                var day = nowTm.getDate();//获取日
                var lastTm='';
                if(month<10){
                    month='0'+month;
                }
                if(day<10){
                    day = '0'+day;
                }
                lastTm = year+'-'+month+'-'+day;


                nowTm.setDate(day-7);
                var year7 = nowTm.getFullYear();//七天前的年份
                var month7 = nowTm.getMonth()+1;//七天前的月份
                var day7 = nowTm.getDate();//七天前的日
                var beginTm7=''
                if(month7<10){
                    month7='0'+month7;
                }
                if(day7<10){
                    day7='0'+day7;
                }
                beginTm7=year7+'-'+month7+'-'+day7;
                $('#start').datebox('setValue',beginTm7);
                $('#end').datebox('setValue',lastTm);
                $('#tool input').attr("disabled", "true");
                $('#search').removeAttr("disabled");

                var h = $(window).height(); // 动态计算窗体当前高度

                $('#datagrid').datagrid({
                    height: h - 50,
                    width: '99.9%',
                    striped: true,
                    singleSelect: true,
                    rownumbers: true,
                    fitColumns: true,
                    autoRowHeight: true,
                    columns:[[{
                        field: 'tm',
                        title: '时间',
                        width: '33%',
                        align: 'center'
                        },
                        {
                            field: 'stcd',
                            title: '测站编码',
                            width: '33%',
                            align: 'center'
                        },
                        {
                            field: 'sht',
                            title: '渗流量',
                            width: '33%',
                            align: 'center',
                            editor: {
                                type: 'numberbox',
                                options: {
                                    precision: 3
                                }
                            }
                        }]]
                });
                myModule.loadReservoir();
            },

            doSearch:function(){
                $('#search').click(function(){
                    myModule.loadGrid();
                });

                $('#addBtd').click(function() {
                    if (extendDatagrid.lastIndex != undefined) {
                        $('#datagrid').datagrid('endEdit', extendDatagrid.lastIndex);
                    }
                    var date = new Date();
                    var year = date.getFullYear();
                    var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
                    var day = date.getDate() < 10 ? "0" + date.getDate() : (date.getDate());
                    var hour = date.getHours() < 10 ? "0" + date.getHours() : (date.getHours());
                    var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : (date.getMinutes());
                    $('#datagrid').datagrid('appendRow',{
                        tm: year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + '00',
                        stcd: stcd
                    });
                    var rowData = $('#datagrid').datagrid('getRows');
                    $('#datagrid').datagrid('clearSelections');
                    $('#datagrid').datagrid('selectRow',rowData.length - 1);
                    document.getElementsByTagName('BODY')[0].scrollTop=document.getElementsByTagName('BODY')[0].scrollHeight;
                });

                $("#delBtn").click(function () {
                    var datagrid = $('#datagrid');
                    var row = datagrid.datagrid('getSelected');
                    var index = $('#datagrid').datagrid('getRowIndex',row);
                    var tm = row.tm;
                    datagrid.datagrid('clearSelections');
                    // 询问框
                    layer.confirm("您确认删除选择的信息吗？", {
                        title : '确认提示',
                        shade : 0.3
                    }, function() {
                        $.ajax({
                            url : window._baseUrl + 'BasicDataCtl/deleteSeepage.do',
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify({
                                key: tm,
                                ennmcd: ennmcd
                            }),
                            contentType: 'application/json;charset=UTF-8',
                            success : function(data) {
                                if (data.flag != 1) {
                                    layer.msg(data.msg, {
                                        icon : 1,
                                        time : 1000
                                    });
                                    datagrid.datagrid('deleteRow', index);
                                } else {
                                    layer.msg(data.msg, {
                                        icon : 5,
                                        time : 1000
                                    });
                                }
                            }
                        });
                    });
                });

                $("#saveBtn").click(function () {
                    if (extendDatagrid.lastIndex != undefined) {
                        $('#datagrid').datagrid('endEdit', extendDatagrid.lastIndex);
                    }

                    var updated = $('#datagrid').datagrid('getChanges', 'updated');
                    var changed = $('#datagrid').datagrid('getChanges', 'inserted');
                    if (updated.length == 0 && changed.length == 0) {
                        return false;
                    }

                    $.ajax({
                        url: window._baseUrl + 'BasicDataCtl/saveSeepage.do',
                        dataType: "json",
                        type: "post",
                        data: JSON.stringify({
                            updated: updated,
                            changed: changed,
                            ennmcd: ennmcd
                        }),
                        contentType: 'application/json;charset=UTF-8',
                        success: function (data) {
                            if (data.flag != 1) {
                                layer.msg(data.msg, {
                                    icon: 1,
                                    time: 2000,
                                    offset: '10%'
                                }, function(){
                                    myModule.loadGrid();
                                });
                            } else {
                                layer.msg(data.msg, {
                                    icon: 4,
                                    time: 3000,
                                    offset: '10%'
                                });
                            }
                        }
                    });
                });
            },

            onAfterEdit: function(index, row, changes) {

                if (index < oldData.length) {
                    oldValue = oldData[index].sht;
                    newValue = row.sht;
                    if (oldValue != newValue) {
                        var pEle = document.getElementById("datagrid-row-r" + queryTime + "-2-" + index);
                        var oEle = pEle.getElementsByTagName("div");
                        for (i = 0; i < oEle.length; i++) {
                            if (oEle[i].className.indexOf('datagrid-cell-c' + queryTime + '-' + 'sht') > 0) {
                                var oldCss = oEle[i].className;
                                oEle[i].className = oldCss + ' updated';
                                break;
                            }
                        };
                    }
                } else {
                    var pEle = document.getElementById("datagrid-row-r" + queryTime + "-2-" + index);
                    var oEle = pEle.getElementsByTagName("div");
                    for (i = 0; i < oEle.length; i++) {
                        if (oEle[i].className.indexOf('datagrid-cell-c' + queryTime + '-' + 'sht') > 0) {
                            var oldCss = oEle[i].className;
                            oEle[i].className = oldCss + ' updated';
                            break;
                        }
                    };
                }
            },

            clone: function(obj) {
                var o;
                switch (typeof obj) {
                    case 'undefined':
                        break;
                    case 'string':
                        o = obj + '';
                        break;
                    case 'number':
                        o = obj - 0;
                        break;
                    case 'boolean':
                        o = obj;
                        break;
                    case 'object':
                        if (obj === null) {
                            o = null;
                        } else {
                            if (obj instanceof Array) {
                                o = [];
                                for (var i = 0,
                                         len = obj.length; i < len; i++) {
                                    o.push(myModule.clone(obj[i]));
                                }
                            } else {
                                o = {};
                                for (var k in obj) {
                                    o[k] = myModule.clone(obj[k]);
                                }
                            }
                        }
                        break;
                    default:
                        o = obj;
                        break;
                }
                return o;
            }
        };
        module.exports = myModule;
        $(function() {
            myModule.initSearchTm();//初始化时间控件及时间
            myModule.doSearch();//查询功能
        });
    });

var page;
seajs.use(['../js/seepageDM'],
    function(m) {
        page = m;
    });