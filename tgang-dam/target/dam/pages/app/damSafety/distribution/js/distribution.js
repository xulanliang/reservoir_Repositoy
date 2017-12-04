dseDefine('../js/distribution', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'extendDatagrid', 'highcharts', 'highchartsMore'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('highcharts');
        require('highchartsMore');

        var layer = require('layer'), ennmcd, dyKe, bntrcd;
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });

        var myModule = {

            init: function() {
                myModule.loadReservoir();
                $('#date').datebox({
                    width: '150px',
                    height: '25px',
                    editable: false
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

            loadData: function() {
                $.ajax({
                    url: window._baseUrl + "BasicDataCtl/getDisInfo.do",
                    data: {
                        bntrcd: bntrcd,
                        date: $('#date').datebox('getValue')
                    },
                    success: function (result) {
                        if (result.flag == "1") {
                            layer.msg(result.msg, {
                                icon: 4,
                                time: 3000,
                                offset: '10%'
                            });
                        } else {
                            /**
                             *  折线数据
                             */
                            var xData = [], yData = [];
                            for (var i = 0; i < result.length; i++) {
                                xData.push(result[i].point);
                                yData.push(result[i].origdata);
                            }
                            $('#container').highcharts({
                                title: {
                                    text: ""
                                },
                                subtitle: {
                                    text: '<br/>',
                                    useHTML: true
                                },
                                xAxis: {
                                    categories: xData
                                },
                                yAxis: {
                                    title: {
                                        text: '水位 (m)'
                                    },
                                    plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                                },
                                credits: {
                                    enabled: false
                                },
                                tooltip: {
                                    backgroundColor: '#FCFFC5',   // 背景颜色
                                    borderColor: 'black',         // 边框颜色
                                    borderRadius: 10,             // 边框圆角
                                    borderWidth: 3,               // 边框宽度
                                    shadow: true,                 // 是否显示阴影
                                    animation: true,               // 是否启用动画效果
                                    style: {                      // 文字内容相关样式
                                        color: "#ff0000",
                                        fontSize: "12px",
                                        fontWeight: "blod",
                                        fontFamily: "Courir new"
                                    },
                                    shared: true,
                                    useHTML: true,
                                    headerFormat: '<small>{point.key}</small><table>',
                                    pointFormat: '<tr><td style="text-align: right"><b>{point.y} m</b></td></tr>',
                                    footerFormat: '</table>',
                                    valueDecimals: 2
                                },
                                legend: {
                                    layout: 'vertical',
                                    align: 'right',
                                    verticalAlign: 'middle',
                                    borderWidth: 0
                                },
                                series: [{
                                    name: '监控点',
                                    connectNulls: true,
                                    data: yData
                                }]
                            });

                            /**
                             *  表格数据
                             */
                            var data = new Object();
                            data.total = result.length;
                            data.rows = result;
                            $('#datagrid').datagrid({
                                width: '99%',
                                striped: true,
                                data: data,
                                singleSelect:true,
                                autoRowHeight: true,
                                columns: [[
                                    {
                                        field: 'point',
                                        title: '监控点',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center'
                                    },
                                    {
                                        field: 'tm',
                                        title: '时间',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center'
                                    },
                                    {
                                        field: 'origdata',
                                        title: '渗压水位(m)',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center'
                                    },
                                    {
                                        field: 'pptopel',
                                        title: '管口高程',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center'
                                    },
                                    {
                                        field: 'ppbtmel',
                                        title: '管底高程',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center'
                                    },
                                    {
                                        field: 'ptype',
                                        title: '采集方式',
                                        width: "16.6%",
                                        halign: 'center',
                                        align: 'center',
                                        formatter: function(value,row,index){
                                            if (value == 1) {
                                                return '人工采集';
                                            } else {
                                                return '自动采集';
                                            }
                                        }
                                    }
                                ]]
                            });
                        }
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

            listen: function () {
                $('#search').click(function() {
                    myModule.loadData();
                });
            }
        };
        module.exports = myModule;

        $(function() {
            myModule.init();
            myModule.listen();
        });
    });

var page;
seajs.use(['../js/distribution'],
    function(m) {
        page = m;
    });