//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('yltzzbb_search', 'pages/app/sjfx/szsk/swqx/yltzzbb/js/yltzzbbsearch', ['eform']);
require_js('yltzzbb_datagrid', 'pages/app/sjfx/szsk/swqx/yltzzbb/js/yltzzbbdatagrid', ['yltzzbb_search', 'datagrid_pager']);
require_shim('stylePage', ['yltzzbb_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('yltzzbbmain', function(require, exports, module) {
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
            doExport: function() {
                var exportType = '水文气象-雨量特征值报表';
                var rows = $('#datagrid').datagrid('getRows');
                $.ajax({
                    url: DSE.serverPath + '/excelController/exportExcel.do',
                    async: false,
                    data: {
                        exportType: exportType,
                        rows: JSON.stringify(rows)
                    },
                    type: 'post',
                    success: function(data) {
                        //window.location.href =decodeURI(DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=水文气象-雨量特征值报表.xlsx');
                        var shortName='水文气象-雨量特征值报表.xlsx';
                        DSE.export.downExcel(data,shortName);
                    }
                });
            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.doReset();

});