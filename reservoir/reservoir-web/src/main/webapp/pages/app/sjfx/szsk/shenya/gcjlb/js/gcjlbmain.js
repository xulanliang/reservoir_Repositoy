/**
 * Created by pc on 2017-6-8.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/sjfx/szsk/shenya/gcjlb/css/gcjlbPage.css');

require_js('gcjlb_search', 'pages/app/sjfx/szsk/shenya/gcjlb/js/gcjlbsearch', ['eform']);
require_js('gcjlb_datagrid', 'pages/app/sjfx/szsk/shenya/gcjlb/js/gcjlbdatagrid', ['gcjlb_search', 'datagrid_pager']);
require_shim('stylePage', ['gcjlb_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('gcjlbmain', function(require, exports, module) {
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
                projcd:$.getParam("projcd"), //工程部位ID
                st_tp:$.getParam("st_tp") //工程部位ID
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
                /*$.ajax({
                    url: DSE.serverPath + 'excelController/downExcel2.do',
                    async: false,
                    type: 'get',
                    success: function(data) {
                        console.log(data);
                    }
                });*/
                var grid = $('#datagrid');
                var options = grid.datagrid('getPager').data("pagination").options;
                var page = options.pageNumber;//当前页数
                var rows = options.total;       //总行数
                var searchData = [];
                searchData = $("#search").serialize();
                searchData = searchData+"&st_tp="+DSE.app.st_tp;

                var fileName =  localStorage.getItem("excelPrefix") +"_观测记录表.xls" ;
                var url= DSE.serverPath + '/shenyaCtrl/export2Excel.do?' +searchData + '&rows='+rows + '&fileName='+encodeURIComponent(encodeURIComponent(fileName));
                window.location.href = url ;
            }
        }
    }).$mount('#app');

    $('#jcdata').click(function(){
        $('#jcdata').css('background-color','#ccc');
        $('#tjdata').css('background-color','#fff');
        $('#type').val(1);
        DSE.form.doSearch();
    });

    $('#tjdata').click(function(){
        $('#tjdata').css('background-color','#ccc');
        $('#jcdata').css('background-color','#fff');
        $('#type').val(2);
        DSE.form.doSearch();
    });

    //$('#jcdata').click();

    //初始化查询
    DSE.form.doReset();

});
