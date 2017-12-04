//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('gcx_search', 'pages/app/sjfx/szsk/shenya/gcx/js/gcxsearch', ['eform']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('gcxmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        gcx_search = require('gcx_search'),
        comm_echarts = require('comm_echarts'),
        date = require('date');

    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function() {
            return {
                url: '', //默认 iframe 不加载 url
                operType: '', //表单状态：add | edit | detail
                rowId: '', //主键 id
                batch: false, //判断显示隐藏
                pickerOptions2: vue_component.pickerOptions2, //使用日期范围组件
                dateVal: '', //日期范围初始化
                minDate: getAddDate(-7,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                sw_auto: true, //
                qw_auto: true, //
                jyl_auto: true, //
                jy_auto: true, //
                title: '', //表单页显示的标题
                loading2: true //loading 状态显示隐藏
            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                //this.minDate = value.substring(0, 10);
                //this.maxDate = value.substring(value.length - 10, value.length);
                //DSE.form.doSearch();
                //DSE.app.doReset();
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
                this.doReset();
            },
            //日期 change
            changeChkVal: function(vid) {
                $("#ex_"+vid).toggle();
            },
            //关闭
            doCloseWin: function() {
                //状态初始化为空
                this.operType = '';
            },
            //退出批量
            doEscBatch: function() {
                this.batch = false;
                DSE.form.doBatchDatagrid(DSE.form.datagrid, this.batch);
            },
            //查询
            doSearch: function() {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
               // DSE.form.doReset();

            //////
                var t = new Date();
                var option1_xAxis= ['周一','周二','周三','周四','周五','周六','周日'];
                var option1_series=[11, 11, 15, 13, 12, 13, 10];
                var wrrbm_rbcd='';
                var adcdtree= $('#adcd_auto').combotree('tree');
                if(adcdtree!=null && adcdtree!==undefined){
                   wrrbm_rbcd=adcdtree.tree('getSelected').id;
                }
                //'&projcd='+projcd
                var  projcd= $.getParam("projcd");

                var jsonurl=DSE.baseUrl + '/gcxCtrl/getShenYaGcxChartData.do?t='+t.getMilliseconds()+'&stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+wrrbm_rbcd+'&projcd='+projcd;

                $.getJSON(jsonurl,function(resultData){
                    option1_xAxis=resultData.STRSVRR_TM;
                    option1_series=resultData.STRSVRR_RZ;
                    /////////////////////////////////  ex1 begin //////////////////////////////
                    var maxVal=100,minVal=20;
                    if(option1_series){
                        var tempData=option1_series.join(",").split(",");//转化为一维数组
                        maxVal= getMaximin(tempData,"max")+1;
                        minVal= getMaximin(tempData,"min")-1;
                    }
                    var option1 = {
                        color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '水位线',
                            subtext: '水位(m)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['水位','水位']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                              //  mark : {show: true},
                              //  dataView : {show: true, readOnly: false},
                              //  magicType : {show: true, type: ['line', 'bar']},
                              //  restore : {show: true},
                             //   saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : option1_xAxis,
                                name:'日期',
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} m',
                                    lineStyle:{
                                        color:"#B03A5B"
                                    },
                                    textStyle:{
                                        fontSize:8,
                                    }
                                },
                            min:minVal,
                            max:maxVal,
                            splitNumber:6,
                            }
                        ],
                        series : [
                            {
                                name:'水位',
                                type:'line',
                                data:option1_series,
                                markPoint : {
                                    data : [
                                        // {type : 'max', name: '最大值'},
                                        //{type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        // {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                            /*
                             {
                             name:'最低气温',
                             type:'line',
                             data:[1, -2, 2, 5, 3, 2, 0],
                             markPoint : {
                             data : [
                             {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                             ]
                             },
                             markLine : {
                             data : [
                             {type : 'average', name : '平均值'}
                             ]
                             }
                             }
                             */
                        ]
                    };

                    echarts.init($('#ex_sw_auto')[0]).setOption(option1);

                    /////////////////////////////////  ex1 end //////////////////////////////

                    /////////////////////////////////  ex2 begin //////////////////////////////

                    var option2 = {
                        color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '降雨量线',
                            subtext: '雨量(mm)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['降雨量']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                               // dataView : {show: true, readOnly: false},
                               // magicType : {show: true, type: ['line', 'bar']},
                              //  restore : {show: true},
                               // saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                data : resultData.STPPTNR_TM
                                //data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                                ,
                                name:'日期',
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} mm',

                                }
                            }
                        ],
                        series : [
                            {
                                name:'降雨量',
                                type:'bar',
                                //data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                                data: resultData.STPPTNR_DYP,
                                markPoint : {
                                    data : [
                                        //{name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                                        //{name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        //{type : 'average', name : '平均值'}
                                    ]
                                }
                            }
                        ]
                    };

                    echarts.init($('#ex_jyl_auto')[0]).setOption(option2);

                    /////////////////////////////////  ex2 end //////////////////////////////

                    /////////////////////////////////  ex3 begin //////////////////////////////

                    var option3 = {
                        color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '温度线',
                            subtext: '温度(℃)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['温度','温度']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                               // mark : {show: true},
                               // dataView : {show: true, readOnly: false},
                               // magicType : {show: true, type: ['line', 'bar']},
                              //  restore : {show: true},
                             //   saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : resultData.STTMPR_TM,
                                name:'日期',
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} ℃'
                                }
                            }
                        ],
                        series : [
                            {
                                name:'温度',
                                type:'line',
                                data:resultData.STTMPR_TM_ATMP,
                                markPoint : {
                                    data : [
                                        // {type : 'max', name: '最大值'},
                                        //{type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        // {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                            /*
                             {
                             name:'最低气温',
                             type:'line',
                             data:[1, -2, 2, 5, 3, 2, 0],
                             markPoint : {
                             data : [
                             {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                             ]
                             },
                             markLine : {
                             data : [
                             {type : 'average', name : '平均值'}
                             ]
                             }
                             }
                             */
                        ]
                    };

                    echarts.init($('#ex_qw_auto')[0]).setOption(option3);

                    /////////////////////////////////  ex3 end //////////////////////////////

                    /////////////////////////////////  ex4 begin //////////////////////////////

                    var option4 = {
                        color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '气压线',
                            subtext: '气压(kPa)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['气压量','气压量']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                               // mark : {show: true},
                               // dataView : {show: true, readOnly: false},
                               // magicType : {show: true, type: ['line', 'bar']},
                               // restore : {show: true},
                               // saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : resultData.STTMPR_TM ,
                                name:'日期',
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} kPa'
                                }
                            }
                        ],
                        series : [
                            {
                                name:'气压量',
                                type:'line',
                                data:resultData.STTMPR_PR_AIRP,
                                markPoint : {
                                    data : [
                                        // {type : 'max', name: '最大值'},
                                        //{type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        // {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                            /*
                             {
                             name:'最低气温',
                             type:'line',
                             data:[1, -2, 2, 5, 3, 2, 0],
                             markPoint : {
                             data : [
                             {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                             ]
                             },
                             markLine : {
                             data : [
                             {type : 'average', name : '平均值'}
                             ]
                             }
                             }
                             */
                        ]
                    };

                    echarts.init($('#ex_jy_auto')[0]).setOption(option4);
                    /////////////////////////////////  ex4 end //////////////////////////////

                    /////////////////////////////////  ex5 begin //////////////////////////////

                    var echarsbean=new echarsBean();
                    echarsbean.ele='ex_0';
                    echarsbean.title_text='渗压过程线';
                    echarsbean.title_subtext='渗压(m)';
                    echarsbean.xaxis_title='日期';
                    echarsbean.yaxis_formatter_value='{value} m';
                    echarsbean.xaxis_datas=resultData.WRHYDOB_xAxisDatas;
                    echarsbean.legend_datas=resultData.WRHYDOB_legendDatas;

                    var seriesDatas=[];
                    var tempData=[];
                    for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                        var kname=resultData.WRHYDOB_legendDatas[i];
                        tempData.push(resultData.WRHYDOB_Datas[kname+""]);
                        //console.log(' tempData: '+tempData);
                        //stack: '总量',
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            data:resultData.WRHYDOB_Datas[kname+""],
                        });
                    }
                    echarsbean.series_datas=seriesDatas;
                    echarsbean.yaxis_min=40.01;
                    echarsbean.yaxis_max=60.01;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-0.1;
                    }
                    //echarsbean.yaxis_max= parseFloat(echarsbean.yaxis_max);
                    //echarsbean.yaxis_min= parseFloat(echarsbean.yaxis_min);
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean.yaxis_min);
                    create_echarts_mul(echarts,echarsbean);
                    /////////////////////////////////  ex5 end //////////////////////////////


                });

                /////////

            }
        }
    }).$mount('#app');


    //初始化查询
    DSE.form.initSearch();
    //DSE.form.doReset();

});
