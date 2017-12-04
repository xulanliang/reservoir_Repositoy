dseDefine('../js/infiltrationLinePage', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'extendDatagrid', 'highcharts', 'highchartsMore'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('highcharts');
        require('highchartsMore');

        var layer = require('layer'), ennmcd, bntrcd,selectDate, flag = true;
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });
        //二级工程
        var projcd = $.getParam("projcd");
        //一级工程
        var ppcd = $.getParam("ppcd");
        //var height_frm = '';
        var height_frm = $(".g-mn1c").height();
        //if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth)
        //{
        //    height_frm = document.documentElement.clientHeight;
        //}
        //alert(height_frm);

        var myModule = {

            init: function() {

                $("#date").datebox({
                   editable:false,
                    onChange:function (newValue, oldValue) {
                        selectDate=newValue;
                        myModule.loadData();
                    }
                });
                $("#date").datebox('setValue',myModule.getCurrentTime());
                myModule.loadSection();

                //myModule.loadReservoir();
                myModule.loadWaterInfo();
            },
            getCurrentTime: function () {
                var value = new Date();
                var year = value.getFullYear();
                var month = value.getMonth()+1;
                var day = value.getDate();
                return year+'-'+month+'-'+day;
            },

            loadWaterInfo: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/getWaterInfo.do',
                    type: "post",
                    contentType: 'application/json',
                    success: function (data) {
                        var tgksw, tgkr = 0, tgst, tgll, tgwd, syksw, sykr = 0, syst, syll, sywd;
                        if(data.length > 3){
                            tgksw = parseFloat(data[0].c1).toFixed(2);
                            tgst = parseFloat(data[0].J1).toFixed(2);
                            tgll = parseFloat(data[0].J2).toFixed(3);
                            tgwd = parseFloat(data[1].J2).toFixed(2);
                            syksw = parseFloat(data[3].c1).toFixed(2);
                            syst = parseFloat(data[3].J1).toFixed(2);
                            syll = parseFloat(data[3].J2).toFixed(3);
                            sywd = parseFloat(data[2].J2).toFixed(2);
                            if (tgst < 0 || tgll < 0) {
                                tgst = '0.00';
                                tgll = '0.000';
                            }
                            if (syst < 0 || syll < 0) {
                                syst = '0.00';
                                syll = '0.000';
                            }
                            //$.ajax({
                            //    url: window._baseUrl + 'BasicDataCtl/getKrInfo.do',
                            //    data: {
                            //        stcd: 'tg',
                            //        rz: tgksw
                            //    },
                            //    success: function (data) {
                            //        if (data.length > 0) {
                            //            tgkr = data[0].W;
                            //        }
                            //        var tgInfo = '<table><tr><td class="res"><strong>铁岗水情</strong></td><td>库水位(m)：' + tgksw + '</td><td>库容(万m³)：' + tgkr + '</td><td>堰上水头(mm)：' + tgst
                            //            + '</td><td>渗流量(L/s)：' + tgll + '</td><td>温度(℃)：' + tgwd + '</td></tr></table>';
                            //        $('#tgInfo').html(tgInfo);
                            //    }
                            //});
                            //$.ajax({
                            //    url: window._baseUrl + 'BasicDataCtl/getKrInfo.do',
                            //    data: {
                            //        stcd: 'sy',
                            //        rz: syksw
                            //    },
                            //    success: function (data) {
                            //        if (data.length > 0) {
                            //            sykr = data[0].W;
                            //        }
                            //        var syInfo =  '<table><tr><td class="res"><strong>石岩水情</strong></td><td>库水位(m)：' + syksw + '</td><td>库容(万m³)：' + sykr +  '</td><td>堰上水头(mm)：' + syst
                            //            + '</td><td>渗流量(L/s)：' + syll + '</td><td>温度(℃)：' + sywd + '</td></tr></table>';
                            //        $('#syInfo').html(syInfo);
                            //    }
                            //});
                        }
                    }
                });
            },

            //水库
            //loadReservoir: function() {
            //    $.ajax({
            //        url: window._baseUrl + 'BasicDataCtl/getReservoirList.do',
            //        type: "post",
            //        data: JSON.stringify({
            //            ennm : ''
            //        }),
            //        contentType: 'application/json',
            //        success: function (data) {
            //            $('#reservoir').combobox({
            //                width: '150px',
            //                height: '25px',
            //                editable: false,
            //                valueField: 'ENNMCD',
            //                panelHeight: 'auto',
            //                textField: 'ENNM',
            //                data: data,
            //                onChange: function(n, o) {
            //                    ennmcd = n;
            //                    myModule.loadDyKe();
            //                },
            //                onLoadSuccess: function () {
            //                    var data = $('#reservoir').combobox('getData');
            //                    ennmcd = data[0].ENNMCD;
            //                    $("#reservoir").combobox('setValue', ennmcd);
            //                }
            //            });
            //        }
            //    });
            //},

            //大坝
            //loadDyKe: function() {
            //    $.ajax({
            //        url: window._baseUrl + 'BasicDataCtl/queryDyKe.do',
            //        type: "post",
            //        data: JSON.stringify({
            //            ennmcd : ennmcd
            //        }),
            //        contentType: 'application/json',
            //        success: function (data) {
            //            $('#dyKe').combobox({
            //                width: '150px',
            //                height: '25px',
            //                editable: false,
            //                valueField: 'ENNMCD',
            //                panelHeight: 'auto',
            //                textField: 'ENNM',
            //                data: data,
            //                onChange: function(n, o) {
            //                    dyKe = n;
            //                    myModule.loadSection();
            //                },
            //                onLoadSuccess: function () {
            //                    var data = $('#dyKe').combobox('getData');
            //                    dyKe = data[0].ENNMCD
            //                    $("#dyKe").combobox('setValue', dyKe);
            //                }
            //            });
            //        }
            //    });
            //},

            //断面
            loadSection: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/querySectionByEnnmcd.do',
                    type: "post",
                    data: JSON.stringify({
                        ennmcd : projcd,
                    }),
                    contentType: 'application/json',
                    success: function (data) {
                        $('#section').combobox({
                            width: '150px',
                            height: '25px',
                            editable: false,
                            valueField: 'BNTRCD',
                            panelHeight: 'auto',
                            textField: 'BNTR',
                            data: data,
                            onChange: function(n, o) {
                                bntrcd = n;
                                myModule.loadData();
                            },
                            onLoadSuccess: function () {
                                var data = $('#section').combobox('getData');
                                bntrcd = data[0].BNTRCD
                                $("#section").combobox('setValue', bntrcd);
                            }
                        });
                    }
                });
            },

            loadData: function() {
                $.ajax({
                    url: window._baseUrl + "BasicDataCtl/getDbInfo.do",
                    data: {
                        ennmcd: ppcd,
                        bntrcd: bntrcd,
                        date: selectDate
                    },
                    success: function (result) {
                        if (result.flag == "1") {
                            layer.msg(result.msg, {
                                icon: 4,
                                time: 3000,
                                offset: '10%'
                            });
                        } else {
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
                                    tickLength: 0
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
                                    column:{
                                        grouping:false
                                    },
                                    series: {
                                        lineWidth: 1,
                                        marker: {
                                            enabled: false
                                        },
                                        enableMouseTracking: false,
                                        animation: false
                                    }
                                },
                                chart: {
                                    backgroundColor: {
                                        linearGradient: [0, 0, 0, 500],
                                        stops: [
                                            [0, 'rgb(255, 255, 255)'],
                                            [1, 'rgb(192, 224, 255)']
                                        ]
                                    },
                                    //height:height_frm/3,
                                    height:200,
                                }
                            });

                            var waterColor = "rgb(22, 151, 252)"; //水颜色

                            var pArrs = []; //存放浸润线特殊坐标点
                            var bArrs = []; //存放标注特殊点
                            var texts = []; //存放监测点名称

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
                            var min = 999999999;
                            var max = -99999999;
                            var btArray = [];
                            for (var i = 0; i < result.BT.length; i++) {
                                btArray.push([Number(result.BT[i].XWIDTH), Number(result.BT[i].YHEIGHT)]);
                               /* min = Math.min(min, Number(result.BT[i].yheight));
                                max = Math.max(max, Number(result.BT[i].yheight));*/
                            }

                            /**
                             * 根据防渗墙和渗压的最小点，画y轴的最小值
                             */
                            /*for(var i = 0,len = result.FSQ.length; i < len; i++) min = Math.min(min,result.FSQ[i].buttomy);
                            for(var i = 0,len = result.SY.length; i < len; i++) min = Math.min(min, result.SY[i].ppbtmel);
                            // 如果最小值大于5，则再减去5
                            if (min - 5 > 0){
                                min -= 5;
                            }*/

                            chart.addSeries({
                                data: btArray,
                                type: 'area',
                                color: 'rgb(238,202,108)',
                                animation: false,
                                fillOpacity: 1,
                                zIndex: 1,
                            });

                            if (ppcd == 1) {
                                min = 0;
                                max = 35;
                                if(bntrcd>24&&bntrcd<29){
                                    min = -1;
                                }
                            } else {
                                //雁田水库
                                min = 35;
                                max = 55;
                            }

                            chart.yAxis[0].update({
                                title: {
                                    text: '断<br>面<br>高<br>(m)',
                                    rotation:0
                                },
                                tickInterval: 1,
                                min: min,
                                max: max
                            });

                            //防浪墙和防渗墙
                            if (result.FSQ && result.FSQ.length > 0) {
                                //debugger;
                                for (var i = result.FSQ.length -1; i < result.FSQ.length; i++) {
                                    var fsq = new Array();
                                    var k = 0;
                                    if (result.FSQ[i].FLQ_X) {
                                        for (; k < Number(result.FSQ[i].FLQ_X); k++) {
                                            fsq.push([min, min-10]);
                                        }
                                        fsq.push([Number(result.FSQ[i].FLQ_Y), Number(result.FSQ[i].FLQ_Y + 1)]);
                                    }
                                    if (result.FSQ[i].X) {
                                        for (; k < Number(result.FSQ[i].X); k++) {
                                            fsq.push([min, min-10]);
                                        }
                                        fsq.push([Number(result.FSQ[i].BUTTOMY), Number(result.FSQ[i].TOPY)]);
                                    }

                                    chart.addSeries({
                                        pointWidth: 8,
                                        type: 'columnrange',
                                        animation: false,
                                        data: fsq,
                                        color: '#000000',
                                        borderColor: 'rgb(182, 182, 182)',
                                        zIndex: 2
                                    });
                                }
                            }

                            //画渗压管及管中水位
                            if (result.SY.length > 0) {
                                var maxZ = -99999;
                                var minZ = 99999;
                                var sy = new Array();
                                var sw = new Array();
                                var kk = 0;
                                for (var i = 0; i < result.SY.length; i++) {
                                    for (; kk < Number(result.SY[i].XLABEL); kk++) {
                                        sy.push([min, min-10]);
                                        sw.push([min, min-10]);
                                    }

                                    sy.push([Number(result.SY[i].PPBTMEL), Number(result.SY[i].PPTOPEL)]);
                                    sw.push([Number(result.SY[i].PPBTMEL), Number(result.SY[i].ORIGDATA) < Number(result.SY[i].PPBTMEL)? Number(result.SY[i].PPBTMEL): Number(result.SY[i].ORIGDATA)]);
                                    //sw.push([Number(result.SY[i].PPBTMEL), Number(result.SY[i].ORIGDATA) < Number(result.SY[i].PPBTMEL)? Number(result.SY[i].ORIGDATA): Number(result.SY[i].PPBTMEL)]);
                                    bArrs.push(kk);
                                    texts.push(result.SY[i].POINT);
                                    kk++;
                                    //添加液位特殊点
                                        pArrs.push({
                                        x: Number(result.SY[i].XLABEL) + 0.5,// 画在渗压中间
                                        y: Number(result.SY[i].ORIGDATA) < Number(result.SY[i].PPBTMEL)? Number(result.SY[i].PPBTMEL): Number(result.SY[i].ORIGDATA)
                                    });
                                }
                                //添加添加防渗墙特殊点 管中水位最高减去最低 中间值（偏移） 作为防渗墙点
                                if (result.FSQ && result.FSQ.length){
                                    // 获取x轴最大的防渗墙
                                   /* var maxFSQX = '';
                                    for(var i = 0,len = result.FSQ.length; i < len; i++) maxFSQX = Math.max(maxFSQX,result.FSQ[i].x);*/
                                    // 根据maxFSQX获取在其前后的SY
                                    if (result.SY && result.SY.length >= 2){
                                        for (var j = 0; j < result.FSQ.length; j++) {
                                            var prevSY = '',afterSY = '', up = '', down = '', lineX;
                                            var maxFSQX = result.FSQ[j].X;
                                            if (j == 0 && result.FSQ.length > 1) {
                                                up = result.SW[0].Z - (result.SW[0].Z - (result.SY[0].ORIGDATA || result.SY[0].PPBTMEL)) /3;
                                                down = (result.SY[0].ORIGDATA || result.SY[0].PPBTMEL) + (result.SW[0].Z - (result.SY[0].ORIGDATA || result.SY[0].PPBTMEL)) /3;
                                                lineX = result.FSQ[0].X + 0.5;
                                            } else {
                                                for(var i = 0,len = result.FSQ.length; i < len; i++) maxFSQX = Math.max(maxFSQX,result.FSQ[i].X);
                                                for (var i = 0,len = result.SY.length; i < len; i++){
                                                    // 取得差值
                                                    var curSub = result.SY[i].XLABEL - maxFSQX;
                                                    // 在后面
                                                    if (curSub > 0){
                                                        if (!afterSY) afterSY = result.SY[i];
                                                        if (afterSY.xlabel > result.SY[i].XLABEL) afterSY = result.SY[i];
                                                    }else{// 在前面
                                                        if (!prevSY) prevSY = result.SY[i];
                                                        if (prevSY.xlabel < result.SY[i].XLABEL) prevSY = result.SY[i];
                                                    }
                                                    up = (prevSY.ORIGDATA || prevSY.PPBTMEL) - ((prevSY.ORIGDATA || prevSY.PPBTMEL) - (afterSY.ORIGDATA || afterSY.PPBTMEL)) / 3;
                                                    down = (afterSY.ORIGDATA || afterSY.PPBTMEL) + ((prevSY.ORIGDATA || prevSY.PPBTMEL) - (afterSY.ORIGDATA || afterSY.PPBTMEL)) / 3;
                                                    lineX = (prevSY.ORIGDATA + afterSY.XLABEL) / 2 + 0.4;
                                                }
                                            }
                                            // 将其添加到水位线
                                             pArrs.push({
                                                 x: lineX,
                                                 y: up,
                                             });
                                             pArrs.push({
                                                 x: lineX,
                                                 y: down,
                                             });
                                        }
                                    }
                                }

                                chart.addSeries({
                                    borderColor: 'rgb(182, 182, 182)',
                                    color: '#FFFFFF',
                                    pointWidth: 8,
                                    type: 'columnrange',
                                    animation: false,
                                    grouping:false,
                                    data: sy,
                                    zIndex: 3
                                });

                                chart.addSeries({
                                    borderColor: waterColor,
                                    color: waterColor,
                                    pointWidth: 6,
                                    animation: false,
                                    grouping:false,
                                    type: 'columnrange',
                                    data: sw,
                                    zIndex: 4
                                });

                                //添加渗压管标注
                                var bztool = {
                                    point: null,
                                    color: "#0000ff",
                                    postion: "right",
                                    text: null,
                                    draw: function () {
                                        if(this.point.high==0) return;
                                        var bX = this.point.plotX + chart.plotLeft;
                                        var bY = this.point.plotY + chart.plotTop + this.point.plotHigh - this.point.plotLow;
                                        var tx, px1, px2;
                                        if (this.postion == "left") {
                                            tx = bX - 80;
                                            px1 = bX - 10;
                                            px2 = bX - 80;
                                            chart.renderer.text(
                                                '▽' + this.text + '管口高程：' +  this.point.high + 'm',
                                                tx,
                                                bY - 14).attr({
                                                zIndex: 60
                                            }).css({
                                                color: this.color
                                            }).add();
                                        } else {
                                            tx = bX + 20;
                                            px1 = bX + 10;
                                            px2 = bX + 80;
                                            chart.renderer.text(
                                                '▽' + this.text + '水位：' +  this.point.high + 'm',
                                                tx,
                                                bY - 14).attr({
                                                zIndex: 60
                                            }).css({
                                                color: this.color
                                            }).add();
                                        }


                                        chart.renderer.path(['M', bX,
                                                bY, 'L',
                                                px1,
                                                bY - 10,
                                                px1,
                                                bY - 10,
                                                px2,
                                                bY - 10])
                                            .attr({
                                                'stroke-width': 1,
                                                stroke: this.color,
                                                zIndex: 61
                                            }).add();
                                    }
                                };

                                if (chart.series.length >= 3) {
                                    var t_points = chart.series[chart.series.length - 1].data; //液位
                                    var p_points = chart.series[chart.series.length - 2].data; //渗压管
                                    for (var i = 0; i < result.SY.length; i++) {
                                        //液位标注
                                        bztool.point = t_points[bArrs[i]];
                                        bztool.postion = "right";
                                        bztool.text = texts[i];
                                        bztool.draw();
                                        //渗压管标注
                                        bztool.point = p_points[bArrs[i]];
                                        bztool.postion = "left";
                                        bztool.draw();
                                    }
                                }
                            }

                            //水位线
                            if (result.SW.length > 0) {

                                var swReal = [];
                                // 根据水位的值即高度，找出其同坝体的交叉点，该点为水位点
                                var sw = result.SW[0].Z;
                                var prevBT = '',afterBT = '';
                                // 获取最后一个小于水位的点
                                for(var i =0, len = result.BT.length ; i < len; i++){
                                    if (result.BT[i].YHEIGHT < sw){
                                        if (result.BT[i + 1] && result.BT[i + 1].YHEIGHT >= sw){
                                            prevBT = result.BT[i];
                                            afterBT = result.BT[i + 1];
                                            break;
                                        }
                                    }
                                }
                                // 如果全部都小于水位则拿最后一个最为最低点和最高点
                                if (!prevBT) prevBT = result.BT[result.BT.length - 1];
                                if (!afterBT) afterBT = result.BT[result.BT.length - 1];

                                // 求出直线方程 y = a * x + b
                                var a = (afterBT.YHEIGHT - prevBT.YHEIGHT) / (afterBT.XWIDTH - prevBT.XWIDTH);
                                var b = afterBT.YHEIGHT - a * afterBT.XWIDTH;
                                var swX = (sw - b) / a;

                                swReal.push([0,sw],[swX,sw]);
                                pArrs.push({x:swX, y:sw});

                                chart.addSeries({
                                    // type: 'arearange',
                                    type: 'area',
                                    zoomType: 'x',
                                    animation: false,
                                    color: waterColor,
                                    name: '当前水位',
                                    title: {
                                        text: '当前水位'
                                    },
                                    data: swReal,
                                    dataLabels: {
                                        enabled: true, //开启数据提示
                                        useHTML: true, //支持html格式
                                        formatter: function () {
                                            if (this.x == 0) {
                                                return '<div style="color:blue;padding-left:50px;">' + this.series.name +
                                                    "：" + this.point.y + 'm</div>';
                                            }
                                        }
                                    },
                                    zIndex: 0

                                });
                            }

                            //汛限水位XXSW  FSLTDZ
                            /*if (result.XXSW.length > 0) {
                                var p3 = {
                                    x: 0,
                                    y: Number(result.XXSW[0].fsltdz)
                                }; //汛限水位关键点
                                p3.x = ((p3.y - p2.y) / (p1.y - p2.y)) * (p1.x - p2.x) + p2.x;
                                for (var i = 0; i < 2; i++) {
                                    chart.addSeries({
                                        type: 'spline',
                                        color: 'rgb(44, 131, 189)'
                                    });
                                }

                                chart.series[5].addPoint([0, p3.y]);
                                chart.series[6].addPoint([p3.x, p3.y]);

                                //添加series顺序不可乱
                                var point = chart.series[5].data[0];
                                var point1 = chart.series[6].data[0];

                                chart.renderer.text(
                                    '汛限水位：' + p3.y + 'm',
                                    point.plotX + chart.plotLeft + 10,
                                    point.plotY + chart.plotTop - 10).attr({
                                    zIndex: 5
                                }).css({
                                    color: '#ff0000'
                                }).add();

                                chart.renderer.path(['M', point.plotX + chart.plotLeft,
                                        point.plotY + chart.plotTop, 'L',
                                        point1.plotX + chart.plotLeft,
                                        point1.plotY + chart.plotTop])
                                    .attr({
                                        'stroke-width': 1,
                                        stroke: '#ff0000',
                                        dashstyle: 'Dash'
                                    }).add();
                            }*/




                            //连接水位、渗压管、防渗墙 的线
                            //pArrs按照X轴排序
                            for (var i = 0; i < pArrs.length; i++) {
                                for (var j = pArrs.length - 2; j >= i; j--) {
                                    if (pArrs[j].x > pArrs[j + 1].x) {
                                        var temp = pArrs[j + 1];
                                        pArrs[j + 1] = pArrs[j];
                                        pArrs[j] = temp;
                                    }
                                }
                            }
                            chart.addSeries({
                                data: pArrs,
                                lineWidth: 1,
                                type: 'spline',
                                color: 'rgb(35, 182, 52)',
                                animation: false,
                                zIndex: 6
                            });

                            if (result.FSQ.length > 1) {
                                var fsq = new Array();
                                var k = 0;
                                if (result.FSQ[0].FLQ_X) {
                                    for (; k < Number(result.FSQ[0].FLQ_X); k++) {
                                        fsq.push([min, min-10]);
                                    }
                                    fsq.push([Number(result.FSQ[0].FLQ_Y), Number(result.FSQ[0].FLQ_Y + 1)]);
                                }
                                if (result.FSQ[0].X) {
                                    for (; k < Number(result.FSQ[0].X); k++) {
                                        fsq.push([min, min-10]);
                                    }
                                    fsq.push([Number(result.FSQ[0].BUTTOMY), Number(result.FSQ[0].TOPY)]);
                                }

                                chart.addSeries({
                                    pointWidth: 8,
                                    type: 'columnrange',
                                    data: fsq,
                                    animation: false,
                                    color: '#000000',
                                    borderColor: 'rgb(182, 182, 182)',
                                    zIndex: 2
                                });
                            }
                        }


                        //if (bntrcd == 'DMM001' || bntrcd == 'DMM006') {
                        //    document.getElementById('img').src = 'img/m1.jpg';
                        //} else if (bntrcd == 'DMM002' || bntrcd == 'DMM007') {
                        //    document.getElementById('img').src = 'img/m2.jpg';
                        //} else if (bntrcd == 'DMM003' || bntrcd == 'DMM008') {
                        //    document.getElementById('img').src = 'img/m3.jpg';
                        //} else if (bntrcd == 'DMM004' || bntrcd == 'DMM009') {
                        //    document.getElementById('img').src = 'img/m4.jpg';
                        //} else if (bntrcd == 'DMM005' || bntrcd == 'DMM0010') {
                        //    document.getElementById('img').src = 'img/m5.jpg';
                        //} else if (bntrcd == 'DMS001') {
                        //    document.getElementById('img').src = 'img/s1.jpg';
                        //} else if (bntrcd == 'DMS002') {
                        //    document.getElementById('img').src = 'img/s2.jpg';
                        //} else if (bntrcd == 'DMS003') {
                        //    document.getElementById('img').src = 'img/s3.jpg';
                        //} else if (bntrcd == 'DMU001') {
                        //    document.getElementById('img').src = 'img/dm01.jpg';
                        //} else if (bntrcd == 'DMU002') {
                        //    document.getElementById('img').src = 'img/dm02.jpg';
                        //} else if (bntrcd == 'DMU003') {
                        //    document.getElementById('img').src = 'img/dm03.jpg';
                        //} else if (bntrcd == 'DMU004') {
                        //    document.getElementById('img').src = 'img/dm04.jpg';
                        //} else if (bntrcd == 'DMU005') {
                        //    document.getElementById('img').src = 'img/dm05.jpg';
                        //} else if (bntrcd == 'DMU006') {
                        //    document.getElementById('img').src = 'img/dm06.jpg';
                        //} else if (bntrcd == 'DMU007') {
                        //    document.getElementById('img').src = 'img/dm07.jpg';
                        //}
                        /**
                         *  表格数据
                         */
                        if (!flag) {
                            $('#datagrid').datagrid('loadData',{total:0,rows:[]});
                        } else {
                            flag = false;
                        }

                        var data = new Object();
                        data.total = result.SY.length;
                        data.rows = result.SY;
                        $('#datagrid').datagrid({
                            width: '100%',
                            striped: true,
                            data: data,
                            singleSelect:true,
                            height:165,
                            autoRowHeight: false,
                            onLoadSuccess: function(data){
                                var panel = $(this).datagrid('getPanel');
                                var tr = panel.find('div.datagrid-body tr');
                                tr.each(function(){
                                    var td = $(this).children('td[field="userNo"]');
                                    td.children("div").css({
                                        //"text-align": "right"
                                        "height": "22px"
                                    });
                                });
                            },
                            columns: [[
                                {
                                    field: 'POINT',
                                    title: '监控点',
                                    width: "16%",
                                    halign: 'center',
                                    align: 'center'
                                },
                                {
                                    field: 'TM',
                                    title: '时间',
                                    width: "16%",
                                    halign: 'center',
                                    align: 'center'
                                },
                                {
                                    field: 'ORIGDATA',
                                    title: '渗压水位(m)',
                                    width: "16%",
                                    halign: 'center',
                                    align: 'center'
                                },
                                {
                                    field: 'PPTOPEL',
                                    title: '管口高程',
                                    width: "16%",
                                    halign: 'center',
                                    align: 'center'
                                },
                                {
                                    field: 'PPBTMEL',
                                    title: '管底高程',
                                    width: "16%",
                                    halign: 'center',
                                    align: 'center'
                                },
                                {
                                    field: 'PTYPE',
                                    title: '采集方式',
                                    width: "16%",
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
                });
            }
        };
        module.exports = myModule;

        $(function() {
            myModule.init();
        });
    });

var page;
seajs.use(['../js/infiltrationLinePage'],
    function(m) {
        page = m;
    });