//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('gcx_search', 'pages/app/sjfx/szsk/shenLiu/gcx/js/gcxsearch', ['eform']);
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
                minDate: getAddDate(-30,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                title: '', //表单页显示的标题
                loading2: true, //loading 状态显示隐藏
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                wrrbm_rbcd:'',//断面编码
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
                this.projcd=$.getParam("projcd");
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
                /*
                var adcdtree= $('#adcd_auto').combotree('tree');
                if(adcdtree!=null && adcdtree!==undefined){
                    var curnode=adcdtree.tree('getSelected');
                    if(curnode!=null && curnode!==undefined){
                        this.wrrbm_rbcd=curnode.id;
                    }
                }
                this.wrrbm_rbcd='';
                */
                this.projcd= $.getParam("projcd");
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getShenLiuGcxChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd;
                console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData){

                    /////////////////////////////////  ex5 begin //////////////////////////////

                    var echarsbean=new echarsBean();
                    echarsbean.ele='ex_0';
                    echarsbean.title_text='渗流过程线';
                    echarsbean.title_subtext='渗流(l/s)';
                    echarsbean.xaxis_title='日期';
                    echarsbean.yaxis_formatter_value='{value} ';
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
                    echarsbean.yaxis_min=5;
                    echarsbean.yaxis_max=25;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean.yaxis_max= parseFloat(parseFloat(getMaximin(tempDataStr,"max"))+1).toFixed(2);
                        // echarsbean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-1;
                        // 避免出现-0.999999999这样的数据，对最小值 取整处理 或者 保留两位小数 按需处理
                        echarsbean.yaxis_min= parseFloat(parseFloat(getMaximin(tempDataStr,"min"))-1).toFixed(2);
                    }
                    //echarsbean.yaxis_max= parseFloat(echarsbean.yaxis_max);
                    //echarsbean.yaxis_min= parseFloat(echarsbean.yaxis_min);
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean.yaxis_min);
                    create_echarts_mul(echarts,echarsbean);
                    /////////////////////////////////  ex5 end //////////////////////////////
                });


                this.projcd= $.getParam("projcd");
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getShenYaGcxChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd;
                console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData) {
/////////////////////////////////  降雨量 begin //////////////////////////////
                    var echarsbean2=new echarsBean();
                    echarsbean2.ele='ex_jyl_auto';
                    echarsbean2.title_text='降雨量';
                    echarsbean2.title_subtext='雨量(mm)';
                    echarsbean2.xaxis_title='日期';
                    echarsbean2.yaxis_formatter_value='{value} mm';
                    echarsbean2.xaxis_datas=resultData.STPPTNR_TM;
                    echarsbean2.legend_datas=['降雨量'];
                    echarsbean2.series_name='降雨量';
                    echarsbean2.series_type='bar';
                    echarsbean2.series_datas=resultData.STPPTNR_DYP;
                    echarsbean2.yaxis_min=0;
                    echarsbean2.yaxis_max=25;
                    //console.log(' resultData.STPPTNR_DYP: '+resultData.STPPTNR_DYP+' echarsbean2.series_datas：'+echarsbean2.series_datas);
                    if(echarsbean2.series_datas){
                        var tempDataStr=echarsbean2.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean2.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        // echarsbean2.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean2.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean2.yaxis_min);
                    var  curecharts2=create_echarts_single(echarts,echarsbean2,true);

                    /////////////////////////////////  降雨量 end //////////////////////////////

                    /////////////////////////////////  水位 begin //////////////////////////////
                    var echarsbean1=new echarsBean();
                    echarsbean1.ele='ex_sw_auto';
                    echarsbean1.title_text='水位线';
                    echarsbean1.title_subtext='水位(m)';
                    echarsbean1.xaxis_title='日期';
                    echarsbean1.yaxis_formatter_value='{value} m';
                    echarsbean1.xaxis_datas=resultData.STRSVRR_TM;
                    echarsbean1.legend_datas=['水位'];
                    echarsbean1.series_name='水位';
                    echarsbean1.series_type='line';
                    echarsbean1.series_datas=resultData.STRSVRR_RZ;
                    echarsbean1.yaxis_min=20;
                    echarsbean1.yaxis_max=60;
                    //console.log(' resultData.STRSVRR_RZ: '+resultData.STRSVRR_RZ+' echarsbean1.series_datas：'+echarsbean1.series_datas);
                    if(echarsbean1.series_datas){
                        var tempDataStr=echarsbean1.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean1.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        echarsbean1.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-1;
                    }
                    //echarsbean1.yaxis_max= parseFloat(echarsbean1.yaxis_max);
                    //echarsbean1.yaxis_min= parseFloat(echarsbean1.yaxis_min);
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean1.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean1.yaxis_min);
                    var  curecharts1=create_echarts_single(echarts,echarsbean1,true);

                    /////////////////////////////////  水位 end //////////////////////////////

                });

            }
        }
    }).$mount('#app');


    //初始化查询
    DSE.form.initSearch();
    //DSE.form.doReset();

});
