/**
 * Created by pc on 2017-6-8.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/sjfx/dggc/scwy/gcjlb/css/gcjlbPage.css');

require_js('gcjlb_search', 'pages/app/sjfx/dggc/scwy/gcjlb/js/gcjlbsearch', ['eform']);
require_js('gcjlb_datagrid', 'pages/app/sjfx/dggc/scwy/gcjlb/js/gcjlbdatagrid', ['gcjlb_search', 'datagrid_pager']);
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
                projcd:"" //工程部位ID
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
                var grid = $('#datagrid');
                var options = grid.datagrid('getPager').data("pagination").options;
                var page = options.pageNumber;//当前页数
                var rows = options.total;       //总行数
                var searchData = [];
                searchData = $("#search").serialize();


                var fileName =  localStorage.getItem("excelPrefix") +"_观测记录表.xls" ;
                var url= DSE.serverPath + '/dccjCtrl/exportGcjlbExcel.do?' +searchData+'&pointType=8' + '&rows='+rows + '&fileName='+encodeURIComponent(encodeURIComponent(fileName));
                window.location.href = url ;

                /*var exportType = '深层位移-观测记录表';
                $.ajax({
                    url: DSE.serverPath + '/scwyCtrl/getGcjlbExcel.do',
                    async: false,
                    data: {
                        year: $('#year_auto').combobox('getValue'),
                        month: $('#month_auto').combobox('getValue'),
                        projcd: $('#projcd_auto').val(),
                        PROJ_CD: $('#PROJ_CD_auto').combobox('getValue')
                    },
                    type: 'post',
                    success: function(data) {
                        $.ajax({
                            url: DSE.serverPath + '/excelController/exportExcel.do',
                            async: false,
                            data: {
                                exportType: exportType,
                                rows: JSON.stringify(data)
                            },
                            type: 'post',
                            success: function(data) {
                              //  window.location.href = decodeURI(DSE.serverPath + '/excelController/downExcel.do?exportId=' + data.data + '&shortName=深层位移-观测记录表.xlsx');
                                var shortName='深层位移-观测记录表.xlsx';
                                DSE.export.downExcel(data,shortName);
                            }
                        });
                    }
                });*/
            }
        }
    }).$mount('#app');

    $('#jcdata').click(function(){
        $('#jcdata').css('background-color','#ccc');
        $('#tjdata').css('background-color','#fff');
        $('#type').val(1);
        DSE.app.doSearch();
    });

    $('#tjdata').click(function(){
        $('#tjdata').css('background-color','#ccc');
        $('#jcdata').css('background-color','#fff');
        $('#type').val(2);
        DSE.app.doSearch();
    });

    $('#jcdata').click();

    //初始化查询
    DSE.form.doReset();

});
