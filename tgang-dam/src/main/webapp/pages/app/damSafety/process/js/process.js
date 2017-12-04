dseDefine('../js/process', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'extendDatagrid', 'highcharts', 'highchartsMore'],
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
                $('#sdate').datebox({
                    width: '150px',
                    height: '25px',
                    editable: false
                });
                $('#edate').datebox({
                    width: '150px',
                    height: '25px',
                    editable: false
                });
                var d = new Date();
                var sMonth = parseInt(d.getMonth()) < parseInt('9') ? '0' + parseInt(d.getMonth()) : parseInt(d.getMonth());
                var eMonth = parseInt(d.getMonth() + 1) < parseInt('9') ? '0' + parseInt(d.getMonth() + 1) : parseInt(d.getMonth() + 1);
                $('#sdate').datebox('setValue', d.getFullYear() + '-' + sMonth + '-' + d.getDate());
                $('#edate').datebox('setValue', d.getFullYear() + '-' + eMonth + '-' + d.getDate());
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
                var sdate = $('#sdate').datebox('getValue');
                var edate = $('#edate').datebox('getValue');
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
                    url: window._baseUrl + "BasicDataCtl/getLevelInfo.do",
                    data: {
                        bntrcd: bntrcd,
                        sdate: sdate,
                        edate: edate,
                        ennmcd: ennmcd
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
                            var xData = [], series = [], pointcd = [], names = [];
                            for (var i = 0; i < result.length; i++) {
                                if (pointcd.length == 0 || $.inArray(result[i].pointcd, pointcd) == -1) {
                                    pointcd.push(result[i].pointcd);
                                    names.push(result[i].point);
                                }
                                if (xData.length == 0 || $.inArray(result[i].tm, xData) == -1) {
                                    xData.push(result[i].tm);
                                }
                            }
                            for (var i = 0; i < names.length; i++) {
                                var obj = new Object(), yData = new Array();
                                for (var k = 0; k < xData.length; k ++) {
                                    var val = null, temp = new Array();
                                    for (var j = 0; j < result.length; j++) {
                                        if (result[j].pointcd == pointcd[i] && result[j].tm == xData[k]) {
                                            val = result[j].origdata;
                                            break;
                                        }
                                    }
                                    var str = xData[k];
                                    str = str.replace(/-/g,"/");
                                    var date = new Date(str );
                                    temp.push(date.getTime(), val);
                                    yData.push(temp);
                                }

                                obj.name = names[i];
                                obj.data = yData;
                                obj.connectNulls = true;
                                series.push(obj);
                            }
                            var options = $('#container').highcharts({
                                title: {
                                    text: ""
                                },
                                subtitle: {
                                    text: '<br/>',
                                    useHTML: true
                                },
                                xAxis: {
                                    type:"datetime",//时间轴要加上这个type，默认是linear
                                    dateTimeLabelFormats: {
                                        second: '%H:%M:%S',
                                        minute: '%H:%M',
                                        day: '%m-%d',
                                        week: '%y-%m-%d',
                                        month: '%y-%m',
                                        year: '%y'
                                    }
                                },
                                yAxis: {
                                    title: {
                                        text: '水位 (m)'
                                    },
                                    plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }],
                                    allowDecimals:false
                                },
                                credits: {
                                    enabled: false
                                },
                                tooltip: {
                                    shared: true,
                                    useHTML: true,
                                    formatter: function () {
                                        var time = this.x;
                                        var date = timeStampFormatDateTime(time);
                                        var s = '<b>' + date + '</b>';

                                        $.each(this.points, function () {
                                            s += '<br/>' + this.series.name + ': ' +
                                                this.y + 'm';
                                        });

                                        return s;
                                    },
                                    //dateTimeLabelFormats:{
                                    //    second: '%y-%m-%d %H:%M:%S',
                                    //    minute: '%y-%m-%d %H:%M:%S',
                                    //    day: '%y-%m-%d %H:%M:%S',
                                    //    week: 'y-%m-%d %H:%M:%S',
                                    //    month: 'y-%m-%d %H:%M:%S',
                                    //    year: 'y-%m-%d %H:%M:%S'
                                    //},
                                },
                                legend: {
                                    layout: 'vertical',
                                    align: 'right',
                                    verticalAlign: 'middle',
                                    borderWidth: 0
                                },
                                series: series
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
seajs.use(['../js/process'],
    function(m) {
        page = m;
    });