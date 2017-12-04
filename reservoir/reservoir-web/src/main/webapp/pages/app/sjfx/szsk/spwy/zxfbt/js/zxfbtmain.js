//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');


require_js('zxfbt_searc', 'pages/app/sjfx/szsk/spwy/zxfbt/js/zxfbtmainSearch', ['eform']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['zxfbt_searc']);

//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('zxfbtmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        zxfbt_searc = require('zxfbt_searc'),
        comm_echarts = require('comm_echarts'),
        date = require('date');

    Vue.use(ELEMENT);

    var showDM = true;
    var projcd= $.getParam("projcd");//工程编码
    var ppcd=$.getParam("ppcd");//一级工程编码
    var st_tp=$.getParam("st_tp");
    if(projcd==3015 && ppcd=='' && st_tp==3){
        showDM =false;
    }

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
                minDate: ((new Date()).getFullYear()-5), //起始日期
                maxDate: ((new Date()).getFullYear()), //结束日期
                sw_auto: true, //
                qw_auto: true, //
                jyl_auto: true, //
                jy_auto: true, //
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                wrrbm_rbcd:'',//断面编码
                title: '', //表单页显示的标题
                showDM:showDM,
                loading2: true //loading 状态显示隐藏
            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                //this.minDate = value.substring(0, 10);
                //this.maxDate = value.substring(value.length - 10, value.length);
                var vdemo=this;
                //vdemo.minDate=$('#stm_auto').val();
                //vdemo.maxDate=$('#etm_auto').val();
                vdemo.projcd=$.getParam("projcd");
                vdemo.ppcd= $.getParam("ppcd");
                this.doReset();
            },
            //日期 change
            changeChkVal: function(vid) {
                $("#ex_"+vid).toggle();
            },
            //查询
            doSearch: function() {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
               // DSE.form.doReset();

                /*
                if(this.projcd=='3' || (this.projcd.indexOf('3')==0)){
                    this.wrrbm_rbcd='';
                }*/

                //var m = new Date().getMonth() + 1;
                var year = $("#stm_auto").val();
                var yearEnd = $("#etm_auto").val();
                var season=$("#season_auto").val();
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getSpwyZxfbtGcxChartData.do?stm='+ year +'&etm='+yearEnd+'&season='+ season +'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd;
                 $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex5 begin //////////////////////////////
                     var echarsbean=new echarsBean();
                     echarsbean.ele='ex_0';
                     echarsbean.title_text='水平位移纵向分布图线';
                     echarsbean.title_subtext='水平位移(mm)';
                     echarsbean.xaxis_title='测点';
                     echarsbean.yaxis_formatter_value='{value} ';
                     echarsbean.xaxis_datas=resultData.WRHYDOB_xAxisDatas;
                     if(resultData.WRHYDOB_legendDatas.length > 10){
                         echarsbean.legend_datas = adjustLegend(resultData.WRHYDOB_legendDatas);
                     }else{
                         echarsbean.legend_datas =resultData.WRHYDOB_legendDatas;
                     }
                     echarsbean.grid_top = setGridTop(resultData.WRHYDOB_legendDatas);

                     var seriesDatas=[];
                     var tempData=[];
                     for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                         var kname=resultData.WRHYDOB_legendDatas[i];
                         tempData.push(resultData.WRHYDOB_Datas[kname+""]);
                         //console.log(' tempData: '+tempData);
                         //stack: '总量', stack: null,
                         seriesDatas.push({
                             name:kname,
                             type:'line',
                             data:resultData.WRHYDOB_Datas[kname+""],
                         });
                     }
                     echarsbean.series_datas=seriesDatas;
                     echarsbean.yaxis_min=20;
                     echarsbean.yaxis_max=100;
                     if(tempData){
                         var tempDataStr=tempData.join(",").split(",");
                         //console.log(' tempDataStr: '+tempDataStr);
                         echarsbean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                         echarsbean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                     }
                     //echarsbean.yaxis_max= parseFloat(echarsbean.yaxis_max);
                     //echarsbean.yaxis_min= parseFloat(echarsbean.yaxis_min);
                     //console.log(' echarsbean.yaxis_max222: '+echarsbean.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean.yaxis_min);
                     create_echarts_mul(echarts,echarsbean);

                });

            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.initSearch();


});
