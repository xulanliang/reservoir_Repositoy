//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('swgcx_search', 'pages/app/sjfx/dggc/js/comm_dggc_gcxsearch', ['eform']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('swgcxmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        gcx_search = require('swgcx_search'),
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
                minDate: getAddDate(-30,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                title: '', //表单页显示的标题
                wrrbm_rbcd:'',
                loading2: true //loading 状态显示隐藏
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
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getSwGcxChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&projcd='+this.projcd;
                console.log(' jsonurl: '+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex5 begin //////////////////////////////
                    var echarsbean=new echarsBean();
                    echarsbean.ele='ex_0';
                    echarsbean.title_text='水位过程线';
                    echarsbean.title_subtext='水位(m)';
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

                    /////////////////////////////////  ex5 end //////////////////////////////

                });

            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.initSearch();
    //DSE.form.doReset();

});
