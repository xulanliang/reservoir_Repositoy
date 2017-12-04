//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('gcx_search', 'pages/app/sjfx/dggc/js/comm_dggc_gcxsearch', ['eform']);
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

    var showDM = true;
    var projcd= $.getParam("projcd");//工程编码
    var ppcd=$.getParam("ppcd");//一级工程编码
    var st_tp=$.getParam("st_tp");
    if(projcd==3015 && ppcd=='' && st_tp==8){
        showDM =false;
    }

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
                minDate: getAddDate(-30,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                st_tp:'',
                title: '', //表单页显示的标题
                wrrbm_rbcd:'',
                loading2: true, //loading 状态显示隐藏
                showDM:showDM,

            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
                vdemo.projcd=$.getParam("projcd");
                vdemo.ppcd= $.getParam("ppcd");
                vdemo.wrrbm_rbcd=$('#adcd_auto').val();
                this.doReset();
            },
            //关闭
            doCloseWin: function() {
                //状态初始化为空
                this.operType = '';
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
               // DSE.form.doReset();

                this.projcd= $.getParam("projcd");
                this.wrrbm_rbcd=$('#adcd_auto').val();
                console.log('this.wrrbm_rbcd: '+$('#adcd_auto').val());
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getScwyGcxChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd;
                console.log(' jsonurl: '+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex5 begin //////////////////////////////

                    /*
                    var xAxisDatas=[];
                    xAxisDatas=resultData.WRHYDOB_xAxisDatas;
                    var legendDatas=[];
                    legendDatas=resultData.WRHYDOB_legendDatas;
                    var seriesDatas=[];
                    for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                       var kname=resultData.WRHYDOB_legendDatas[i];
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            stack: '位移',
                            data:resultData.WRHYDOB_Datas[kname+""],
                        });
                    }
                    var option5  = {
                        //color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '水平位移图',
                            subtext: '水平位移(mm)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:legendDatas
                        },
                        toolbox: {
                            show : true,
                            feature : {
                               //mark : {show: true},
                               // dataView : {show: true, readOnly: false},
                               // magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                               // restore : {show: true},
                               // saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : xAxisDatas,
                                name:'测点',
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : seriesDatas
                    };

                   echarts.init($('#ex_0')[0]).setOption(option5);
                    */
                    var echarsbean=new echarsBean();
                    echarsbean.ele='ex_0';
                    echarsbean.title_text='深层位移过程线';
                    echarsbean.title_subtext='位移量(mm)';
                    echarsbean.xaxis_title='测点';
                    echarsbean.yaxis_formatter_value='{value} mm';
                    echarsbean.yaxis_min=20;
                    echarsbean.yaxis_max=100;
                    echarsbean.xaxis_datas=resultData.WRHYDOB_xAxisDatas;
                    echarsbean.legend_datas=resultData.WRHYDOB_legendDatas;
                    var seriesDatas=[];
                    var tempData=[];
                    for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                        var kname=resultData.WRHYDOB_legendDatas[i];
                        tempData.push(resultData.WRHYDOB_Datas[kname+""]);
                        //stack: '总量', stack: null,
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            data:resultData.WRHYDOB_Datas[kname+""],
                        });
                    }
                    echarsbean.series_datas=seriesDatas;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    create_echarts_mul(echarts,echarsbean);

                    /////////////////////////////////  ex5 end //////////////////////////////


                });

            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.initSearch();
    //DSE.form.doReset();

});
