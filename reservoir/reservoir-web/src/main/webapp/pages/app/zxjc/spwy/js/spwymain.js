/**
 * Created by pc on 2017-7-14.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/zxjc/css/fixZxjc.css');

require_js('spwy_search', 'pages/app/zxjc/js/comm_search', ['eform']);
require_js('spwy_datagrid', 'pages/app/zxjc/spwy/js/spwydatagrid', ['spwy_search', 'datagrid_pager']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
require_shim('stylePage', ['spwy_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('spwymain', function(require, exports, module) {
    var _stylePage = require('stylePage');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        echarts = require('echarts3'),
        comm_echarts = require('comm_echarts'),
        date = require('date'),
        date97 = require('date97'),
        ELEMENT = require('ELEMENT');
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
                minDate: getAddDate(-365,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                title: '', //表单页显示的标题
                loading2: true, //loading 状态显示隐藏
                projcd:"" , //工程部位ID,
                keyword:'',//搜索关键字,
                wrrbm_rbcd:'',//断面编码
                stcds:''
            };
        },

        methods: {
            //日期 change
            changeDateVal: function(value) {
                //this.minDate = value.substring(0, 10);
                //this.maxDate = value.substring(value.length - 10, value.length);
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
                DSE.form.doSearch();
            },
            //添加 param 数据
            addSearchParam: function(_param){
                _param["stm"] = this.minDate;
                _param["etm"] = this.maxDate;
                _param["wrrbm_rbcd"] = this.wrrbm_rbcd;
                _param["stcds"] = this.stcds;
                return _param;
            },
            //查询
            doSearch: function() {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
                DSE.app.minDate= getAddDate(-365,new Date()), //起始日期
                DSE.app.maxDate= getAddDate(0,new Date()), //结束日期
                DSE.form.doReset();
            },

            //导出
            doExport: function() {
                //var exportType = '渗压-观测记录表';
                //$.ajax({
                //    url: DSE.serverPath + '/shenyaCtrl/getGcjlbExcel.do',
                //    async: false,
                //    data: {
                //        year: $('#year_auto').combobox('getValue'),
                //        month: $('#month_auto').combobox('getValue'),
                //        projcd: $('#projcd_auto').val(),                                  //'1',
                //        PROJ_CD: $('#PROJ_CD_auto').combobox('getValue')                  //'1001'
                //    },
                //    type: 'post',
                //    success: function(data) {
                //        $.ajax({
                //            url: DSE.serverPath + '/excelController/exportExcel.do',
                //            async: false,
                //            data: {
                //                exportType: exportType,
                //                rows: JSON.stringify(data)
                //            },
                //            type: 'post',
                //            success: function(data) {
                //                window.location.href = decodeURI(DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=渗压-观测记录表.xlsx');
                //            }
                //        });
                //    }
                //});
            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.doReset();

    /////////////////////////////////  ex5 begin //////////////////////////////
    DSE.form.echarsBean=new echarsBean();
    DSE.form.echarsBean.ele='ex_0';
    DSE.form.echarsBean.title_text='水平位移过程线';
    DSE.form.echarsBean.title_subtext='变形量(mm)';
    DSE.form.echarsBean.xaxis_title='日期';
    DSE.form.echarsBean.yaxis_formatter_value='{value} mm';
    DSE.form.echarsBean.yaxis_min=0;
    DSE.form.echarsBean.yaxis_max=100;
    DSE.form.echarsBean.xaxis_datas=[];//resultData.WRHYDOB_xAxisDatas;
    DSE.form.echarsBean.legend_datas=[]//resultData.WRHYDOB_legendDatas;
    DSE.form.echarsBean.series_datas=[];//seriesDatas;

    create_echarts_mul(echarts,DSE.form.echarsBean);

    /////////////////////////////////  ex5 end //////////////////////////////
});