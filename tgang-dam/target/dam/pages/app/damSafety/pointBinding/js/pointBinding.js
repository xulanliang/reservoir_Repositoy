seajs.data.alias.easyui_edit = window._baseUrl + "pages/app/damSafety/pointBinding/js/extendEditDatagrid.js";
dseDefine('../js/pointBinding', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'easyui_valid', 'easyui_edit', 'highcharts', 'highchartsMore'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('easyui_valid');
        require('highcharts');
        require('highchartsMore');
        var egrid = require('easyui_edit');
        var extendDatagrid1 = egrid.editorCell1;
        var extendDatagrid2 = egrid.editorCell2;
        var extendDatagrid3 = egrid.editorCell3;
        var layer = require('layer'), ennmcd, dyKe, bntrcd;
        var oldValue1, newValue1, oldData1, oldValue2, newValue2, oldData2,  oldValue3, newValue3, oldData3, queryTime = -1;
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });

        var myModule = {

            init: function() {
                myModule.loadReservoir();

                $('#container').highcharts({
                    title: {
                        text: ""
                    },
                    subtitle: {
                        text: '<br/>',
                        useHTML: true
                    },
                    xAxis: {
                        gridLineWidth: 0,
                        labels: {
                            enabled: true
                        },
                        lineWidth: 1,
                        tickLength: 5
                    },
                    exporting:{
                        enabled:true
                    },
                    yAxis: {
                        gridLineWidth: 0
                    },
                    legend: {
                        enabled: false
                    },
                    credits: {
                        enabled: false
                    },
                    tooltip: {
                        enabled: false
                    },
                    plotOptions: {
                        series: {
                            lineWidth: 1
                        }
                    },
                    chart: {
                        backgroundColor: {
                            linearGradient: [0, 0, 0, 500],
                            stops: [
                                [0, 'rgb(255, 255, 255)'],
                                [1, 'rgb(192, 224, 255)']
                            ]
                        }
                    }

                });

                $("#fsX").numberbox({
                    min: 0,
                    width: '40px',
                    height:'25px'
                });
                $("#bottomY").numberbox({
                    min: 0,
                    width: '40px',
                    height:'25px'
                });
                $("#topY").numberbox({
                    min: 0,
                    width: '40px',
                    height:'25px'
                });
                $("#flX").numberbox({
                    min: 0,
                    width: '40px',
                    height:'25px'
                });
                $("#flY").numberbox({
                    min: 0,
                    width: '40px',
                    height:'25px'
                });
            },

            query: function() {
                $('#addBtd').click(function() {
                    if (extendDatagrid1.lastIndex != undefined) {
                        $('#jkdTab').datagrid('endEdit', extendDatagrid1.lastIndex);
                    }
                    if (extendDatagrid2.lastIndex != undefined) {
                        $('#btdTab').datagrid('endEdit', extendDatagrid2.lastIndex);
                    }
                    if (extendDatagrid3.lastIndex != undefined) {
                        $('#fsqTab').datagrid('endEdit', extendDatagrid3.lastIndex);
                    }
                    $('#btdTab').datagrid('appendRow',{
                        xwidth: '',
                        yheight: ''
                    });
                    var rowData = $('#btdTab').datagrid('getRows');
                    $('#btdTab').datagrid('clearSelections');
                    $('#btdTab').datagrid('selectRow',rowData.length - 1);
                    //$('#btdTab').datagrid('beginEdit',rowData.length - 1);
                    document.getElementsByTagName('BODY')[0].scrollTop=document.getElementsByTagName('BODY')[0].scrollHeight;
                });

                $('#add').click(function() {
                    if (extendDatagrid1.lastIndex != undefined) {
                        $('#jkdTab').datagrid('endEdit', extendDatagrid1.lastIndex);
                    }
                    if (extendDatagrid2.lastIndex != undefined) {
                        $('#btdTab').datagrid('endEdit', extendDatagrid2.lastIndex);
                    }
                    if (extendDatagrid3.lastIndex != undefined) {
                        $('#fsqTab').datagrid('endEdit', extendDatagrid3.lastIndex);
                    }
                    $('#fsqTab').datagrid('appendRow',{
                        x: '',
                        buttomy: '',
                        topy: ''
                    });
                    var rowData = $('#fsqTab').datagrid('getRows');
                    $('#fsqTab').datagrid('clearSelections');
                    $('#fsqTab').datagrid('selectRow',rowData.length - 1);
                });

                $("#fsqBtn").click(function () {
                    myModule.doSave(2);
                });

                $("#jkdBtn").click(function () {
                    myModule.doSave(0);
                });

                $("#btdBtn").click(function () {
                    myModule.doSave(1);
                });

                $("#delBtn").click(function () {
                    var datagrid = $('#btdTab');
                    var row = datagrid.datagrid('getSelected');
                    if (row == null) {
                        return;
                    }
                    var sn = row.sn;
                    if (sn == null || sn == '' || sn == undefined) {
                        var index = $('#btdTab').datagrid('getRowIndex',row)
                        datagrid.datagrid('deleteRow', index);
                        return;
                    }
                    datagrid.datagrid('clearSelections');
                    // 询问框
                    layer.confirm("您确认删除选择的信息吗？", {
                        title : '确认提示',
                        shade : 0.3
                    }, function() {
                        $.ajax({
                            url : window._baseUrl + 'BasicDataCtl/deletePoint.do',
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify({
                                key: sn
                            }),
                            contentType: 'application/json;charset=UTF-8',
                            success : function(data) {
                                if (data != 1) {
                                    layer.msg(data.msg, {
                                        icon : 1,
                                        time : 1000
                                    });
                                    myModule.loadData();
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

                $("#del").click(function () {
                    var datagrid = $('#fsqTab');
                    var row = datagrid.datagrid('getSelected');
                    if (row == null) {
                        return;
                    }
                    var id = row.id;
                    if (id == null || id == '' || id == undefined) {
                        var index = $('#fsqTab').datagrid('getRowIndex',row)
                        datagrid.datagrid('deleteRow', index);
                        return;
                    }
                    datagrid.datagrid('clearSelections');
                    // 询问框
                    layer.confirm("您确认删除选择的信息吗？", {
                        title : '确认提示',
                        shade : 0.3
                    }, function() {
                        $.ajax({
                            url : window._baseUrl + 'BasicDataCtl/deleteFsq.do',
                            type: "post",
                            dataType: "json",
                            data: JSON.stringify({
                                key: id
                            }),
                            contentType: 'application/json;charset=UTF-8',
                            success : function(data) {
                                if (data != 1) {
                                    layer.msg(data.msg, {
                                        icon : 1,
                                        time : 1000
                                    });
                                    myModule.loadData();
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
            },

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
                                myModule.loadDyKe();
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

            loadDyKe: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/queryDyKe.do',
                    type: "post",
                    data: JSON.stringify({
                        ennmcd : ennmcd
                    }),
                    contentType: 'application/json',
                    success: function (data) {
                        $('#dyKe').combobox({
                            width: '150px',
                            height: '25px',
                            editable: false,
                            valueField: 'ennmcd',
                            panelHeight: 'auto',
                            textField: 'ennm',
                            data: data,
                            onChange: function(n, o) {
                                dyKe = n;
                                myModule.loadSection();
                            },
                            onLoadSuccess: function () {
                                var data = $('#dyKe').combobox('getData');
                                dyKe = data[0].ennmcd
                                $("#dyKe").combobox('setValue', dyKe);
                            }
                        });
                    }
                });
            },

            loadSection: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/querySectionByEnnmcd.do',
                    type: "post",
                    data: JSON.stringify({
                        ennmcd : dyKe
                    }),
                    contentType: 'application/json',
                    success: function (data) {
                        $('#section').combobox({
                            width: '150px',
                            height: '25px',
                            editable: false,
                            valueField: 'bntrcd',
                            panelHeight: 'auto',
                            textField: 'bntr',
                            data: data,
                            onChange: function(n, o) {
                                bntrcd = n;
                                myModule.loadData();
                            },
                            onLoadSuccess: function () {
                                var data = $('#section').combobox('getData');
                                bntrcd = data[0].bntrcd
                                $("#section").combobox('setValue', bntrcd);
                            }
                        });
                    }
                });
            },

            loadData: function() {
                queryTime = queryTime + 3;
                $("#fsX").textbox('setValue', '');
                $("#bottomY").textbox('setValue', '');
                $("#topY").textbox('setValue', '');
                $.ajax({
                    url: window._baseUrl + "BasicDataCtl/getDbInfo.do",
                    data: {
                        ennmcd: ennmcd,
                        bntrcd: bntrcd
                    },
                    success: function (result) {
                        if (result.flag == "1") {
                            layer.msg(result.msg, {
                                icon: 4,
                                time: 3000,
                                offset: '10%'
                            });
                        } else {
                            var chart = $("#container").highcharts();
                            while (chart.series.length > 0) {
                                chart.series[0].remove();
                            }

                            chart.xAxis[0].addPlotLine({
                                value: 0,
                                color: 'rgb(9, 108, 199)',
                                width: 6,
                                id: 'plot-line-1'
                            });

                            //画坝体
                            if(result.BT){
                                var min = 999999999;
                                var max = -99999999;
                                var btArray = new Array();
                                for (var i = 0; i < result.BT.length; i++) {
                                    btArray.push([Number(result.BT[i].xwidth), Number(result.BT[i].yheight)]);
                                    min = Math.min(min, Number(result.BT[i].yheight));
                                    max = Math.max(max, Number(result.BT[i].yheight));
                                }

                                chart.addSeries({
                                    data: btArray,
                                    color: 'rgb(67, 153, 231)',
                                    type: 'line',
                                    zIndex: 1
                                });

                                chart.yAxis[0].update({
                                    title: {
                                        text:'断面高(m)'
                                    },
                                    min: min - 2,
                                    max: max + 2
                                });
                            }

                            //---------------------------
                            //防浪墙和防渗墙
                              if (result.FSQ && result.FSQ.length > 0) {

                                for (var i = 0; i < result.FSQ.length; i++) {
                                    var fsq = new Array();
                                    var k = 0;
                                    if (result.FSQ[i].flq_x) {
                                        for (; k < Number(result.FSQ[i].flq_x); k++) {
                                            fsq.push([min, min-10]);
                                        }
                                        fsq.push([Number(result.FSQ[i].flq_y), Number(result.FSQ[i].flq_y + 1)]);
                                    }
                                    chart.addSeries({
                                        pointWidth: 8,
                                        type: 'columnrange',
                                        data: fsq,
                                        color: '#000000',
                                        borderColor: 'rgb(182, 182, 182)',
                                        zIndex: 2
                                    });
                                    var fsq = new Array();
                                    var k = 0;
                                    if (result.FSQ[i].x) {
                                        for (; k < Number(result.FSQ[i].x); k++) {
                                            fsq.push([min, min-10]);
                                        }
                                        fsq.push([Number(result.FSQ[i].buttomy), Number(result.FSQ[i].topy)]);
                                    }

                                    chart.addSeries({
                                        pointWidth: 8,
                                        type: 'columnrange',
                                        data: fsq,
                                        color: '#000000',
                                        borderColor: 'rgb(182, 182, 182)',
                                        zIndex: 2
                                    });
                                }

                            }
                            //----------------------------------------
                            //画渗压管及管中水位
                               if (result.SY) {
                                    var maxZ = -99999;
                                    var minZ = 99999;
                                    var sy = new Array();
                                    var kk = 0;
                                    for (var i = 0; i < result.SY.length; i++) {
                                        for (; kk < Number(result.SY[i].xlabel); kk++) {
                                            sy.push([min, min-10]);
                                        }
                                        sy.push([Number(result.SY[i].ppbtmel), Number(result.SY[i].pptopel)]);
                                        kk++;
                                        minZ = Math.min(minZ, Number(result.SY[i].origdata));
                                        maxZ = Math.max(maxZ, Number(result.SY[i].origdata));
                                    }

                                    chart.addSeries({
                                       borderColor: 'rgb(182, 182, 182)',
                                       color: '#FFFFFF',
                                       pointWidth: 8,
                                       type: 'columnrange',
                                       data: sy,
                                       zIndex: 3
                                   });
                                }

                        }
                        /**
                         *  表格数据
                         */
                        var jkdData = new Object();
                        oldData1 = myModule.clone(result.SY);
                        jkdData.total = result.SY.length;
                        jkdData.rows = result.SY;
                        $('#jkdTab').datagrid({
                            width: '99%',
                            striped: true,
                            data: jkdData,
                            singleSelect:true,
                            autoRowHeight: true,
                            onClickCell: extendDatagrid1.onClickCell,
                            onAfterEdit: myModule.onAfterEdit1,
                            columns: [[
                                {
                                    field: 'point',
                                    title: '监控点',
                                    width: "25%",
                                    halign: 'center',
                                    align: 'center',
                                    formatter: function(value,row,index){
                                        return  nullToSpace(value);
                                    }
                                },
                                {
                                    field: 'xlabel',
                                    title: 'X轴(断面宽)',
                                    width: "25%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                },
                                {
                                    field: 'pptopel',
                                    title: '管口高程',
                                    width: "25%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                },
                                {
                                    field: 'ppbtmel',
                                    title: '管底高程',
                                    width: "25%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                }
                            ]]
                        });

                        var btData = new Object();
                        oldData2 = myModule.clone(result.BT);
                        btData.total = result.BT.length;
                        btData.rows = result.BT;
                        $('#btdTab').datagrid({
                            width: '99%',
                            striped: true,
                            data: btData,
                            singleSelect:true,
                            autoRowHeight: true,
                            onClickCell: extendDatagrid2.onClickCell,
                            onAfterEdit: myModule.onAfterEdit2,
                            onSelect: function() {
                                $('#delBtn').removeAttr("disabled");
                            },
                            columns: [[
                                {
                                    field: 'xwidth',
                                    title: 'X轴(断面宽)',
                                    width: "50%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                },
                                {
                                    field: 'yheight',
                                    title: 'Y轴(断面高)',
                                    width: "50%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                }
                            ]]
                        });

                        $('#delBtn').attr('disabled',"true");

                        var fsqData = new Object();
                        oldData3 = myModule.clone(result.FSQ);
                        fsqData.total = result.FSQ.length;
                        fsqData.rows = result.FSQ;
                        $('#fsqTab').datagrid({
                            width: '99%',
                            striped: true,
                            data: fsqData,
                            singleSelect:true,
                            autoRowHeight: true,
                            onClickCell: extendDatagrid3.onClickCell,
                            onAfterEdit: myModule.onAfterEdit3,
                            onSelect: function() {
                                $('#del').removeAttr("disabled");
                            },
                            columns: [[
                                {
                                    field: 'x',
                                    title: '防渗墙X轴',
                                    width: "33%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                },
                                {
                                    field: 'buttomy',
                                    title: '底高程(m)',
                                    width: "33%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                }
                                ,
                                {
                                    field: 'topy',
                                    title: '顶高程(m)',
                                    width: "33%",
                                    halign: 'center',
                                    align: 'center',
                                    editor: {
                                        type: 'numberbox',
                                        options: {
                                            precision: 2,
                                            max: 9999.99
                                        }
                                    }
                                }
                            ]]
                        });

                        $('#del').attr('disabled',"true");

                        $(document).on('click', function (e) {
                            var target = $(e.target);
                            var divTarget = $('.datagrid-wrap');
                            if (target.closest(divTarget).length === 0) {
                                if (extendDatagrid1.lastIndex != undefined && extendDatagrid1.lastIndex != extendDatagrid1.penultIndex) {
                                    $('#jkdTab').datagrid('endEdit', extendDatagrid1.lastIndex);
                                }
                                if (extendDatagrid2.lastIndex != undefined && extendDatagrid2.lastIndex != extendDatagrid2.penultIndex) {
                                    $('#btdTab').datagrid('endEdit', extendDatagrid2.lastIndex);
                                }
                                if (extendDatagrid3.lastIndex != undefined && extendDatagrid3.lastIndex != extendDatagrid3.penultIndex) {
                                    $('#fsqTab').datagrid('endEdit', extendDatagrid3.lastIndex);
                                }
                            }
                        });
                    }
                });
            },

            doSave: function(flag) {

                if (extendDatagrid1.lastIndex != undefined) {
                    $('#jkdTab').datagrid('endEdit', extendDatagrid1.lastIndex);
                }
                if (extendDatagrid2.lastIndex != undefined) {
                    $('#btdTab').datagrid('endEdit', extendDatagrid2.lastIndex);
                }
                if (extendDatagrid3.lastIndex != undefined) {
                    $('#fsqTab').datagrid('endEdit', extendDatagrid3.lastIndex);
                }

                var uData = [];

                if (flag == 2) {
                    var rowData = $('#fsqTab').datagrid('getRows');
                    for (var i = 0; i < rowData.length; i++) {
                        var row = rowData[i];
                        for (var o in row) {
                            if(row[o] == '' && row[o] != '0') {
                                layer.msg("防渗墙信息请填写完整!", {
                                    icon: 4,
                                    time: 3000,
                                    offset: '10%'
                                });
                                $('#fsqTab').datagrid('selectRow',i);
                                return false;
                            }
                        }
                    }
                    var fsqUPdate = $('#fsqTab').datagrid('getChanges', 'updated');
                    var fsqChange = $('#fsqTab').datagrid('getChanges', 'inserted');
                    var rdata = [];
                    for (var i = 0; i < fsqUPdate.length; i++) {
                        var datas = [];
                        datas.push(bntrcd);
                        datas.push(fsqUPdate[i].x);
                        datas.push(fsqUPdate[i].buttomy);
                        datas.push(fsqUPdate[i].topy);
                        datas.push(fsqUPdate[i].id);
                        rdata.push(datas.join(","));
                    }
                    for (var i = 0; i < fsqChange.length; i++) {
                        var datas = [];
                        datas.push(bntrcd);
                        datas.push(fsqChange[i].x);
                        datas.push(fsqChange[i].buttomy);
                        datas.push(fsqChange[i].topy);
                        rdata.push(datas.join(","));
                    }
                    if (rdata.length == 0) {
                        return false;
                    } else {
                        for (var i = 0; i < rdata.length; i++) {
                            var strs = rdata[i].split(',');
                            for (var j = 0; j < strs.length; j++) {
                                if(strs[j] == ""){
                                    layer.msg("防渗墙信息请填写完整!", {
                                        icon: 4,
                                        time: 3000,
                                        offset: '10%'
                                    });
                                    return false;
                                }
                            }
                        }
                    }
                    uData = rdata.join("@@");
                } else if (flag == 0) {
                    var jkdUPdate = $('#jkdTab').datagrid('getChanges', 'updated');
                    var rdata = [];
                    for (var i = 0; i < jkdUPdate.length; i++) {
                        var datas = [];
                        datas.push(jkdUPdate[i].xlabel);
                        datas.push(jkdUPdate[i].pptopel);
                        datas.push(jkdUPdate[i].ppbtmel);
                        datas.push(jkdUPdate[i].pointcd);
                        for (var j = 0; j < datas.length; j++){
                            if(datas[j] == ""){
                                layer.msg("监控点信息请填写完整!", {
                                    icon: 4,
                                    time: 3000,
                                    offset: '10%'
                                });
                                return false;
                            }
                        }
                        rdata.push(datas.join(","));
                    }
                    if (rdata.length == 0) {
                        return false;
                    }
                    uData = rdata.join("@@");
                } else if (flag == 1) {
                    var rowData = $('#btdTab').datagrid('getRows');
                    for (var i = 0; i < rowData.length; i++) {
                        var row = rowData[i];
                        for (var o in row) {
                            if(row[o] == '' && row[o] != '0') {
                                layer.msg("坝体关键点信息请填写完整!", {
                                    icon: 4,
                                    time: 3000,
                                    offset: '10%'
                                });
                                $('#btdTab').datagrid('selectRow',i);
                                return false;
                            }
                        }
                    }
                    var btdUPdate = $('#btdTab').datagrid('getChanges', 'updated');
                    var btdChange = $('#btdTab').datagrid('getChanges', 'inserted');
                    var rdata = [];
                    for (var i = 0; i < btdUPdate.length; i++) {
                        var datas = [];
                        datas.push(bntrcd);
                        datas.push(btdUPdate[i].xwidth);
                        datas.push(btdUPdate[i].yheight);
                        datas.push(btdUPdate[i].sn);
                        rdata.push(datas.join(","));
                    }
                    for (var i = 0; i < btdChange.length; i++) {
                        var datas = [];
                        datas.push(bntrcd);
                        datas.push(btdChange[i].xwidth);
                        datas.push(btdChange[i].yheight);
                        rdata.push(datas.join(","));
                    }
                    if (rdata.length == 0) {
                        return false;
                    } else {
                        for (var i = 0; i < rdata.length; i++) {
                            var strs = rdata[i].split(',');
                            for (var j = 0; j < strs.length; j++) {
                                if(strs[j] == ""){
                                    layer.msg("坝体关键点信息请填写完整!", {
                                        icon: 4,
                                        time: 3000,
                                        offset: '10%'
                                    });
                                    return false;
                                }
                            }
                        }
                    }
                    uData = rdata.join("@@");
                }

                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/updateConfig.do',
                    dataType: "json",
                    type: "post",
                    data: JSON.stringify({
                        uData: uData,
                        flag: flag
                    }),
                    contentType: 'application/json;charset=UTF-8',
                    success: function (data) {
                        if (data.flag != 1) {
                            layer.msg(data.msg, {
                                icon: 1,
                                time: 2000,
                                offset: '10%'
                            }, function(){
                                myModule.loadData();
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
            },

            onAfterEdit1: function(index, row, changes) {

                for (var fieldname in row) {
                    oldValue1 = oldData1[index][fieldname];
                    newValue1 = row[fieldname];
                    if (oldValue1 != newValue1) {
                        var pEle = document.getElementById("datagrid-row-r" + (queryTime - 1) + "-2-" + index);
                        var oEle = pEle.getElementsByTagName("div");
                        for (i = 0; i < oEle.length; i++) {
                            if (oEle[i].className.indexOf('datagrid-cell-c' + (queryTime - 1) + '-' + fieldname) > 0) {
                                var oldCss = oEle[i].className;
                                oEle[i].className = oldCss + ' updated';
                                break;
                            }
                        };
                    }
                }

            },

            onAfterEdit2: function(index, row, changes) {

                for (var fieldname in row) {
                    if (index < oldData2.length) {
                        oldValue2 = oldData2[index][fieldname];
                        newValue2 = row[fieldname];
                        if (oldValue2 != newValue2) {
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

            onAfterEdit3: function(index, row, changes) {

                for (var fieldname in row) {
                    if (index < oldData3.length) {
                        oldValue3 = oldData3[index][fieldname];
                        newValue3 = row[fieldname];
                        if (oldValue3 != newValue3) {
                            var pEle = document.getElementById("datagrid-row-r" + (queryTime + 1) + "-2-" + index);
                            var oEle = pEle.getElementsByTagName("div");
                            for (i = 0; i < oEle.length; i++) {
                                if (oEle[i].className.indexOf('datagrid-cell-c' + (queryTime + 1) + '-' + fieldname) > 0) {
                                    var oldCss = oEle[i].className;
                                    oEle[i].className = oldCss + ' updated';
                                    break;
                                }
                            };
                        }
                    } else {
                        var pEle = document.getElementById("datagrid-row-r" + (queryTime + 1) + "-2-" + index);
                        var oEle = pEle.getElementsByTagName("div");
                        for (i = 0; i < oEle.length; i++) {
                            if (oEle[i].className.indexOf('datagrid-cell-c' + (queryTime + 1) + '-' + fieldname) > 0) {
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
            myModule.init();
            myModule.query();
        });
    });

var page;
seajs.use(['../js/pointBinding'],
    function(m) {
        page = m;
    });