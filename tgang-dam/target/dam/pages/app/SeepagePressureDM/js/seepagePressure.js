seajs.data.alias.easyui_edit = window._baseUrl + "pages/app/damSafety/pointBinding/js/extendEditDatagrid.js";
dseDefine('../js/seepagePressure', ['jquery', 'easyui', 'easyui_lang', 'common','zTree', 'layer', 'easyui_edit'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('zTree');

        var egrid = require('easyui_edit');
        var extendDatagrid = egrid.editorCell1;
        var layer = require('layer');
        layer.config({
            path: window._baseUrl+'assets/win/layer/' //layer.js所在的目录，可以是绝对目录，也可以是相对目录
        });

        var h = $(window).height(), cfg, nodeId, queryTime = 0, oldData, oldValue, newValue, flag = true;
        var myModule = {

            iniZtree:function(){
                var h = $(window).height();
                $('#container').css("height",h-10);
                //ztree树配置
                cfg = {
                    view: {
                        selectedMulti: false
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pid"
                        },
                        key: {
                            name: 'name'// 设置数据的label字段
                        }
                    },
                    callback: {
                        beforeClick: beforeClick,
                        onClick: onClick// 用户单击查看详情
                    }
                };

                // 点击节点看详情的事件
                function onClick(event, treeId, treeNode) {
                    nodeId = treeNode.id;
                    myModule.loadGrid();
                }

                function beforeClick(treeId, treeNode) {
                    if (treeNode.type != "4") {
                        return false;
                    } else{
                        return true;
                    }
                }

                myModule.loadData();
            },

            loadData: function() {
                $.ajax({
                    url : window._baseUrl + "BasicDataCtl/queryData.do",
                    dataType : "json",
                    success : function(data) {
                        $.fn.zTree.init($("#tree"), cfg, data);
                        var treeObj = $.fn.zTree.getZTreeObj("tree");
                        treeObj.expandAll(true);
                        var nodes = treeObj.getNodes();
                        if (nodes.length > 0) {
                            nodes[0].isParent = true;
                            nodes[0].iconSkin = 'org';
                            nodes[0].nocheck = true;
                        }
                        if (flag) {
                            flag = false;
                            var parentNode = treeObj.getNodes(), node;
                            var nodes = treeObj.transformToArray(parentNode);
                            for (var i = 0; i < nodes.length; i++) {
                                if (nodes[i].type == 4) {
                                    node = nodes[i];
                                    break;
                                }
                            }
                            treeObj.selectNode(node);
                            nodeId = node.id;
                            myModule.loadGrid();
                        }
                    }
                });

            },

            loadGrid: function() {
                $.ajax({
                    url : window._baseUrl + "BasicDataCtl/getPreMonitorList.do",
                    dataType : "json",
                    data:  JSON.stringify({
                        bntrcd : nodeId
                    }),
                    contentType: 'application/json',
                    success : function(result) {
                        if (result.length > 0) {
                            queryTime += 2;
                            var fields = [];
                            for (var i = 0; i < result.length; i++) {
                                var obj = new Object();
                                obj.field = result[i].pointcd;
                                obj.title = result[i].pointcd;
                                obj.width = 80;
                                obj.editor = {
                                    type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                    }
                                }
                                fields.push(obj);
                            }
                            $('#datagrid').datagrid({
                                width: '99.9%',
                                striped: true,
                                singleSelect: true,
                                rownumbers: true,
                                fitColumns: true,
                                autoRowHeight: true,
                                columns:[[
                                    {field:'tm',title:'日期',rowspan:2,width:80},
                                    {title:'监测点代码及渗压水位（m)',colspan:result.length}
                                ],fields]
                            });
                        }

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
                            url: window._baseUrl + 'HydOrigDataCtrl/queryData.do',
                            type: "post",
                            data:  JSON.stringify({
                                bntrcd : nodeId,
                                startTm: sdate + ' 00:00:00',
                                endTm: edate + ' 23:59:59'
                            }),
                            contentType: 'application/json',
                            success: function(data) {
                                //小于10填充0
                                function getzf(num){
                                    if (parseInt(num) < 10) {
                                        num = '0' + num;
                                    }
                                    return num;
                                }

                                //通过毫妙转换成日期
                                function getMyDate(str){
                                    var oDate = new Date(str),
                                        oYear = oDate.getFullYear(),
                                        oMonth = oDate.getMonth()+1,
                                        oDay = oDate.getDate(),
                                        oHour = oDate.getHours(),
                                        oMin = oDate.getMinutes(),
                                        oTime = oYear + '-' + getzf(oMonth) + '-' + getzf(oDay) + ' ' + getzf(oHour) + ':' + getzf(oMin) + ':' + '00';//最后拼接时间
                                    return oTime;
                                };

                                var timeArr = [];//时间数组
                                for(var s = 0;s<data.length;s++){
                                    var tm = getMyDate(data[s].TM);
                                    data[s].TM = tm;
                                    timeArr.push(tm); //把所有时间放进数组里
                                }

                                //时间数组去重
                                var distinctTimeArr = [];//时间数组去重
                                for(var n=0;n<timeArr.length;n++){
                                    if(distinctTimeArr.indexOf(timeArr[n])==-1){
                                        distinctTimeArr.push(timeArr[n]);
                                    }
                                }

                                var rows = new Array();
                                for(var k=0;k<distinctTimeArr.length;k++){
                                    var obj = new Object();
                                    for(var i=0;i<data.length;i++){ //把相同时间点的数据放在一个集合
                                        if(distinctTimeArr[k] == data[i].TM){
                                            var field = data[i].HYDCD;
                                            obj.tm = data[i].TM;
                                            obj[field] = data[i].ORIGDATA;
                                        }
                                    }
                                    rows.push(obj);
                                }
                                var rowData = new Object();
                                rowData.total = rows.length;
                                rowData.rows = rows;
                                oldData = myModule.clone(rows);
                                $('#datagrid').datagrid({
                                    data: rowData,
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
                        });
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
                        tm: year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + '00'
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
                            url : window._baseUrl + 'BasicDataCtl/deleteData.do',
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify({
                                key: tm
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
                        url: window._baseUrl + 'BasicDataCtl/updateData.do',
                        dataType: "json",
                        type: "post",
                        data: JSON.stringify({
                            updated: updated,
                            changed: changed
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

                for (var fieldname in row) {
                    if (index < oldData.length) {
                        oldValue = oldData[index][fieldname];
                        newValue = row[fieldname];
                        if (oldValue != newValue) {
                            var pEle = document.getElementById("datagrid-row-r" + queryTime + "-2-" + index);
                            var oEle = pEle.getElementsByTagName("div");
                            for (i = 0; i < oEle.length; i++) {
                                if (oEle[i].className.indexOf('datagrid-cell-c' + queryTime + '-' + fieldname) > 0) {
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
                            if (oEle[i].className.indexOf('datagrid-cell-c' + queryTime + '-' + fieldname) > 0) {
                                var oldCss = oEle[i].className;
                                oEle[i].className = oldCss + ' updated';
                                break;
                            }
                        };
                    }

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
            myModule.iniZtree();   //初始化zTree树
            myModule.initSearchTm();//初始化时间控件及时间
            myModule.doSearch();//查询功能
        });
    });

var page;
seajs.use(['../js/seepagePressure'],
    function(m) {
        page = m;
    });