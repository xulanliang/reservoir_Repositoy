/**
 * Created by pc on 2017-7-14.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('czwy_search', 'pages/app/zxjc/czwy/js/czwysearch', ['eform']);
require_js('czwy_datagrid', 'pages/app/zxjc/czwy/js/czwydatagrid', ['czwy_search', 'datagrid_pager']);
require_shim('stylePage', ['czwy_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('czwymain', function(require, exports, module) {
    var _stylePage = require('stylePage');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
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
                minDate: '', //起始日期
                maxDate: '', //结束日期
                title: '', //表单页显示的标题
                loading2: true, //loading 状态显示隐藏
                projcd:"" //工程部位ID
            };
        },

        methods: {
            //日期 change
            changeDateVal: function(value) {
                this.minDate = value.substring(0, 10);
                this.maxDate = value.substring(value.length - 10, value.length);
                DSE.form.doSearch();
            },
            //添加 param 数据
            addSearchParam: function(_param){
                _param["stm"] = this.minDate;
                _param["etm"] = this.maxDate;
                return _param;
            },
            //查询
            doSearch: function() {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
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
                //                window.location.href = DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=渗压-观测记录表.xlsx';
                //            }
                //        });
                //    }
                //});
            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.doReset();

});