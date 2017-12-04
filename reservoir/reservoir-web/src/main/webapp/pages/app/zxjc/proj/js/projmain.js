/**
 * Created by pc on 2017-7-17.
 */
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('proj_search', 'pages/app/zxjc/js/comm_search', ['eform']);
require_js('proj_datagrid', 'pages/app/zxjc/proj/js/projdatagrid', ['proj_search', 'datagrid_pager']);
require_shim('stylePage', ['proj_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('projmain', function(require, exports, module) {
    var _stylePage = require('stylePage');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        date = require('date'),
        date97 = require('date97'),
        ELEMENT = require('ELEMENT');
    var type = $.getParam("type");
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
                projcd:"", //工程部位ID
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
                DSE.app.minDate = getAddDate(-30,new Date()), //起始日期
                DSE.app.maxDate = getAddDate(0,new Date()), //结束日期
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

    /**
     *  测点类型
     */
    $("#ckID_auto").combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode.do',
        queryParams: {
            code: '0',
        },
        valueField: 'NAME',
        textField: 'NAME',
        width: '200px',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            //var stcds = $(stcd).combobox('getValues').toString();
            //DSE.app.stcds = stcds;

            var params={
                projcd: DSE.app.projcd,
                type: rec,
                rbcd: DSE.app.wrrbm_rbcd
            };
            $("#stcds_auto").combobox("clear");
            $("#stcds_auto").combobox('reload', params);

            DSE.form.doSearch();
        },
        loadFilter: function(data){
            return data.data;
        }
    });

    //初始化查询
    DSE.form.doReset();

});