/**
 * Created by pc on 2017-7-14.
 */
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/zxjc/css/fixZxjc.css');

require_js('shenLiusearch', 'pages/app/fzjc/shenLiu/js/shenLiuSearch', ['eform']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
//执行配置
require.config(DSE.requireConfig);
define('shenLiuStats', function(require, exports, module) {
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        comm_echarts = require('comm_echarts'),
        shenLiusearch = require('shenLiusearch'),
        date = require('date');

    Vue.use(ELEMENT);


    var projcd= $.getParam("projcd");//工程编码
    var ppcd=$.getParam("ppcd");//一级工程编码
    var st_tp=$.getParam("st_tp");
    var stcd = $.getParam("stcds");

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
                minDate: getAddDate(-30,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                stcd : '',
                st_tp : '',
                title: '', //表单页显示的标题
                loading2: true //loading 状态显示隐藏
            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
            /*    vdemo.projcd=$.getParam("projcd");
                vdemo.ppcd= $.getParam("ppcd");
                vdemo.stcd= $.getParam("stcds");
                vdemo.st_tp = $.getParam("st_tp");*/
                this.doReset();
            },
            //日期 change
            changeChkVal: function(vid) {
                $("#ex_"+vid).toggle();
            },
            //查询
            doSearch: function() {
                // DSE.form.doSearch();
                this.doReset();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';

               /* var _stcd = DSE.app.stcd;
                var _exp = "";
                if(_stcd){
                    if(_stcd === 'S0000078'){       //主坝 M2 测点
                        _exp = "Q = -5.5748 + 0.41568H1 - 0.20095H1-15 + 0.04780R1-1 + 0.19698R1-15 + 0.04334R16-30 +0.04425R31-60 -0.02216T1-1 -0.03216T16-30 +0.05707T31-60 +0.02429T61-90 -0.20955T1 +2.81168ln(t1+1) - 3.53523(l-e-t1)";

                    }else if(_stcd === 'S0000096'){     //左副坝 L测点

                        _exp = "Q = -3.16450 + 0.03807H1 + 0.03979H1-15 + 0.01123H16-30 + 0.01335H31-60 +0.01399H61-90 + 0.00168R1 + 0.00810R1-15 + 0.00194R16-30 + 0.00320R31-60 + 0.00100R61-90 -0.00098T1 + " +
                            "0.00420T61-90 - 0.06704t1 - 0.75661ln(t1+1) +1.29256(1-e-t1)";
                    }else if(_stcd === 'S0000097'){     //左副坝 L4测点
                        _exp = "Q = -0.63390 + 0.08854H1 - 0.02851H31-60 -0.01877H61-90 + 0.00896R1 + 0.01584R1-15 - 0.00594T16-30 +0.00816t1 - 0.40115ln(t1+1) + 1.06368(1-e-t1)";

                    }else if(_stcd === 'S0000113'){     // 右副坝R 测点
                        _exp = "Q =  -9.8324 + 0.38652H1 - 0.08217H1-15 -0.08494H61-90 + 0.01842R1 + 0.02025R1-15 +0.00464R31-60 - 0.01358T1 - 0.00828T16-30 + 0.00842T31-60 + 0.00579T61-90 - " +
                            "0.08407t1 - 0.50059ln(t1+1) + 0.63857(1-e-t1)"
                    }else{

                    }
                }
                $("#mode_factor_auto").val(_exp);*/
               /* var jsonurl=DSE.baseUrl + '/fzjcCtrl/getStatsData.do?statsType=SL&stm='+ DSE.app.minDate
                    +'&etm='+DSE.app.maxDate+'&projcd='+DSE.app.projcd+'&stcd='+DSE.app.stcd+'&st_tp='+st_tp;
                console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex0 begin //////////////////////////////

                    var echarsbean=new echarsBean();
                    var echarsbean1=new echarsBean();
                    echarsbean1.ele='ex_0';
                    // echarsbean.xaxis_datas=resultData.Axis_Data;

                    echarsbean1.title_text='统计模型';
                    echarsbean1.title_subtext='渗流(l/s)';
                    echarsbean1.xaxis_title='日期';
                    echarsbean1.yaxis_formatter_value='{value} ';
                    echarsbean1.xaxis_datas=resultData.xList;
                    // echarsbean1.legend_datas=['水位'];
                    echarsbean1.series_name='渗流';
                    echarsbean1.series_type='line';
                    echarsbean1.series_datas=resultData.yList;
                    // echarsbean1.yaxis_min=20;
                    // echarsbean1.yaxis_max=60;
                    if(echarsbean1.series_datas){
                        var tempDataStr=echarsbean1.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean1.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        echarsbean1.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-1;
                    }
                    create_echarts_single(echarts,echarsbean1,true);

                });*/

               /* var jsonurl=DSE.baseUrl + '/fzjcCtrl/getStatsData.do?statsType=SL&stm='+ DSE.app.minDate
                    +'&etm='+DSE.app.maxDate+'&projcd='+DSE.app.projcd+'&stcd='+DSE.app.stcd+'&st_tp='+st_tp;
                // console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex0 begin //////////////////////////////
                    var echarsbean=new echarsBean();
                    var echarsbean1=new echarsBean();
                    echarsbean1.ele='ex_0';
                    echarsbean1.title_text='统计模型';
                    echarsbean1.title_subtext='渗流(l/s)';
                    echarsbean1.xaxis_title='日期';
                    echarsbean1.yaxis_formatter_value='{value} ';
                    echarsbean1.xaxis_datas=resultData.xList;
                    echarsbean1.legend_datas=resultData.legendList;
                    echarsbean1.series_name='渗流';
                    echarsbean1.series_type='line';
                    echarsbean1.grid_top = setGridTop(resultData.legendList);

                    var seriesDatas=[];
                    var tempData=[];
                    for(var i=0;i<resultData.legendList.length;i++){
                        var kname=resultData.legendList[i];
                        tempData.push(resultData.Axis_Data[kname+""]);
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            data:resultData.Axis_Data[kname+""],
                        });
                    }
                    echarsbean1.series_datas=seriesDatas;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean1.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        echarsbean1.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-1;
                    }
                    create_echarts_mul(echarts,echarsbean1);

                });*/

                var jsonurl=DSE.baseUrl + '/fzjcCtrl/getStatsData.do?statsType=SL&stm='+ DSE.app.minDate
                    +'&etm='+DSE.app.maxDate+'&projcd='+DSE.app.projcd+'&stcd='+DSE.app.stcd+'&st_tp='+st_tp;
                console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    if(JSON.stringify(resultData) != "{}"){
                        /////////////////////////////////  ex_4 begin //////////////////////////////
                        var rzLegend = resultData.legendMap['legend_rz'] ;
                        var echarsbean1=new echarsBean();
                        echarsbean1.ele='ex_4';
                        // echarsbean.xaxis_datas=resultData.Axis_Data;
                        echarsbean1.title_text='统计模型';
                        echarsbean1.title_subtext=rzLegend+'(m)';
                        echarsbean1.xaxis_title='日期';
                        echarsbean1.yaxis_formatter_value='{value} ';
                        echarsbean1.xaxis_datas=resultData.xList;
                        echarsbean1.legend_datas=rzLegend;
                        echarsbean1.series_name=rzLegend;
                        echarsbean1.series_type='line';
                        echarsbean1.series_datas=resultData.Axis_Data[rzLegend];
                        // echarsbean1.yaxis_min=20;
                        // echarsbean1.yaxis_max=60;
                        if(echarsbean1.series_datas){
                            var tempDataStr=echarsbean1.series_datas.join(",").split(",");
                            echarsbean1.yaxis_max= parseFloat(getMaximin(tempDataStr,"max")).toFixed(2)+1;
                            echarsbean1.yaxis_min= parseFloat(getMaximin(tempDataStr,"min")).toFixed(2)-1;
                        }
                        create_echarts_single(echarts,echarsbean1,true);
                        /////////////////////////////////  ex_4 end //////////////////////////////

                        /////////////////////////////////  ex1 begin //////////////////////////////
                        var pptnLegend = resultData.legendMap['legend_pptn'] ;
                        var echarsbean2=new echarsBean();
                        echarsbean2.ele='ex_1';
                        echarsbean2.title_text='统计模型';
                        echarsbean2.title_subtext= pptnLegend+'(mm)';
                        echarsbean2.xaxis_title='日期';
                        echarsbean2.yaxis_formatter_value='{value} ';
                        echarsbean2.xaxis_datas=resultData.xList;
                        echarsbean2.legend_datas=pptnLegend;
                        echarsbean2.series_name=pptnLegend;
                        echarsbean2.series_type='line';
                        echarsbean2.series_datas=resultData.Axis_Data[pptnLegend];
                        if(echarsbean2.series_datas){
                            var tempDataStr=echarsbean2.series_datas.join(",").split(",");
                            echarsbean2.yaxis_max= parseFloat(getMaximin(tempDataStr,"max")).toFixed(2)+1;
                            echarsbean2.yaxis_min= parseFloat(getMaximin(tempDataStr,"min")).toFixed(2)-1;
                        }
                        create_echarts_single(echarts,echarsbean2,true);
                        /////////////////////////////////  ex1 end //////////////////////////////

                        /////////////////////////////////  ex2 begin //////////////////////////////
                        var tmpLegend = resultData.legendMap['legend_tmp'] ;
                        var echarsbean3=new echarsBean();
                        echarsbean3.ele='ex_2';
                        echarsbean3.title_text='统计模型';
                        echarsbean3.title_subtext= tmpLegend+'(℃)';
                        echarsbean3.xaxis_title='日期';
                        echarsbean3.yaxis_formatter_value='{value} ';
                        echarsbean3.xaxis_datas=resultData.xList;
                        echarsbean3.legend_datas=tmpLegend;
                        echarsbean3.series_name=tmpLegend;
                        echarsbean3.series_type='line';
                        echarsbean3.series_datas=resultData.Axis_Data[tmpLegend];
                        if(echarsbean3.series_datas){
                            var tempDataStr=echarsbean3.series_datas.join(",").split(",");
                            echarsbean3.yaxis_max= parseFloat(getMaximin(tempDataStr,"max")).toFixed(2);
                            echarsbean3.yaxis_min= parseFloat(getMaximin(tempDataStr,"min")).toFixed(2) ;
                        }
                        create_echarts_single(echarts,echarsbean3,true);
                        /////////////////////////////////  ex2 end //////////////////////////////

                        /////////////////////////////////  ex3 begin //////////////////////////////
                        var timeLegend = resultData.legendMap['legend_time'] ;
                        var echarsbean4=new echarsBean();
                        echarsbean4.ele='ex_3';
                        echarsbean4.title_text='统计模型';
                        echarsbean4.title_subtext= timeLegend+'';
                        echarsbean4.xaxis_title='日期';
                        echarsbean4.yaxis_formatter_value='{value} ';
                        echarsbean4.xaxis_datas=resultData.xList;
                        echarsbean4.legend_datas=timeLegend;
                        echarsbean4.series_name=timeLegend;
                        echarsbean4.series_type='line';
                        echarsbean4.series_datas=resultData.Axis_Data[timeLegend];
                        // echarsbean4.yaxis_min=20;
                        // echarsbean4.yaxis_max=60;
                        if(echarsbean4.series_datas){
                            var tempDataStr=echarsbean4.series_datas.join(",").split(",");
                            echarsbean4.yaxis_max= parseFloat(getMaximin(tempDataStr,"max")).toFixed(2);
                            echarsbean4.yaxis_min= parseFloat(getMaximin(tempDataStr,"min")).toFixed(2) ;
                        }
                        create_echarts_single(echarts,echarsbean4,true);
                        /////////////////////////////////  ex3 end //////////////////////////////

                    }

                });

            }
        }
    }).$mount('#app');
    //初始化查询
    DSE.form.initSearch();

    /////////////////////////////////  ex5 end //////////////////////////////
});
