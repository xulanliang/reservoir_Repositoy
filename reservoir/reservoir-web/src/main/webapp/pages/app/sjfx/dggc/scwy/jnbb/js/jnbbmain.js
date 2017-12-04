//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('jnbb_search', 'pages/app/sjfx/dggc/scwy/jnbb/js/jnbbsearch', ['eform']);
require_js('jnbb_datagrid', 'pages/app/sjfx/dggc/scwy/jnbb/js/jnbbdatagrid', ['jnbb_search', 'datagrid_pager']);
require_shim('stylePage', ['jnbb_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('jnbbmain', function(require, exports, module) {
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
                loading2: true //loading 状态显示隐藏
            };
        },
        methods: {
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
            doExport: function () {
                var exportType = '深层位移-季年报表';
                $.ajax({
                    url: DSE.serverPath + '/scwyCtrl/getjnbbList.do',
                    async: false,
                    data: {
                        type: $('#type_auto').combobox('getValue'),
                        year: $('#year_auto').combobox('getValue'),
                        season: $('#season_auto').combobox('getValue'),
                        projcd: $('#projcd_auto').val(),
                        rows: 10000
                    },
                    type: 'post',
                    success: function (data) {
                        $.ajax({
                            url: DSE.serverPath + '/excelController/exportExcel.do',
                            async: false,
                            data: {
                                exportType: exportType,
                                rows: JSON.stringify(data.rows)
                            },
                            type: 'post',
                            success: function (data) {
                               // window.location.href = decodeURI(DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=深层位移-季年报表.xlsx');
                                var shortName='深层位移-季年报表.xlsx';
                                DSE.export.downExcel(data,shortName);
                            }
                        });
                    }
                });

            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.doReset();

});
