/**
 * Created by pc on 2017-6-9.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('dnpjtzz_search', 'pages/app/sjfx/dggc/shuiwei/dnpjtzz/js/dnpjtzzsearch', ['eform']);
require_js('dnpjtzz_datagrid', 'pages/app/sjfx/dggc/shuiwei/dnpjtzz/js/dnpjtzzdatagrid', ['dnpjtzz_search', 'datagrid_pager']);
require_shim('stylePage', ['dnpjtzz_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('dnpjtzzmain', function(require, exports, module) {
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
                var exportType = '水位-多年平均特征值';
                $.ajax({
                    url: DSE.serverPath + '/shuiweiCtrl/getDnpjtzzList.do',
                    async: false,
                    data: {
                        syear: $('#syear_auto').combobox('getValue'),
                        eyear: $('#eyear_auto').combobox('getValue'),
                        projcd: $('#projcd_auto').val()
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
                                //window.location.href = decodeURI(DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=水位-多年平均特征值.xlsx');
                                var shortName='水位-多年平均特征值.xlsx';
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