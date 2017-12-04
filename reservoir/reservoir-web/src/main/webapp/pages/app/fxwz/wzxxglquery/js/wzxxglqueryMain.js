/**
 * Created by pc on 2017-8-3.
 */
require_css('css!pages/app/common/css/style.css');
//require_css('css!pages/app/fxwz/wzxxglquery/css/wzxxglqueryDatagrid.css');

require_js('wzxxglquery_search', 'pages/app/fxwz/js/comm_fxwzSearch',['eform','oper_config']);
require_js('wzxxglquery_datagrid', 'pages/app/fxwz/wzxxglquery/js/wzxxglqueryDatagrid', ['wzxxglquery_search', 'datagrid_pager']);
require_shim('stylePage', ['wzxxglquery_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('wzxxglqueryMain', function (require, exports, module) {
    var _stylePage = require('stylePage');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        wzxxglquery_search = require('wzxxglquery_search'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function () {
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
                loading2: true,//loading 状态显示隐藏
            }
        },
        methods: {
            //日期 change
            changeDateVal: function (value) {
                this.minDate = value.substring(0, 10);
                this.maxDate = value.substring(value.length - 10, value.length);
                DSE.form.doSearch();
            },
            //模拟数据
            /*addSearchData: function (_data) {
             return _data = $ajax({
             url: DSE.serverPath + 'pages/app/data/data_datagrid.json'
             })["rows"];
             },*/
            //新增
            doOpenWin: function () {
                /*
                 *根据业务需求修改
                 * */
                this.operType = 'add';
                this.title = '新增物资基础信息';
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html';
                }
            },doAddWz2Ck: function () {
                /*
                 *根据业务需求修改
                 * */
                if (nullToSpace(this.ma_cds) == '') {
                    $tips.err('请先选择一个物资！');
                    // $.messager.alert('Warning','请在巡查对象树上选择一个对象节点,再进行巡查任务新增操作！');

                }else{
                    this.operType = 'add';
                    this.title = '物资添加到仓库';
                    //if (this.url === '') {
                    //    this.url = './addwz2ck/addOrEdit.html?ma_cds='+this.ma_cds+'&ma_nms='+this.ma_nms;
                    //}
                }
            },
            //关闭
            doCloseWin: function () {
                //状态初始化为空
                this.operType = '';
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
                var fileName =  "物资盘点统计表.xls" ;
                var url= DSE.serverPath + '/wzxxglCtrl/export2Excel.do?' +searchData + '&rows='+rows + '&fileName='+encodeURIComponent(encodeURIComponent(fileName));
                window.location.href = url ;
            },
            //批量操作
            doBatch: function () {
                $('.top-btns-box').removeClass('f-dn');
                this.batch = true;
                DSE.form.doBatchDatagrid(DSE.form.datagrid, this.batch);
            },
            //退出批量
            doEscBatch: function () {
                this.batch = false;
                DSE.form.doBatchDatagrid(DSE.form.datagrid, this.batch);
            },
            //删除
            doBatchDelete: function () {
                //deleteDatagridRow可以传两个参数,title和url
                //注：因为通用删除时可以批量删除的,请求默认传参数名为ids
                //然后删除时一些提交上报后的数据是不能删除的,所以会有默认一个status字段判断选中的数据是否能够删除,constraint为判断条件
                //如：状态名为datastatus,同时判断条件为'0||1||5',表示选中的数据中包含有datastatus状态值为'2,3,4,6'的时候不能删除
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:'datastatus',constraint: '2,3,4,6'});
                //如不需要此判断可以添加参数
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:false});
                //如参数名不同可以加上第三个参数,如：deleteId为后台所需接收的参数名,
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{deleteId:'deleteId'});
                DSE.form.deleteDatagridRow('所选数据', 'wzxxglCtrl/deleteInfoByIds.do', {status: false});
            },
            //查询
            doSearch: function () {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function () {
                this.dateVal = '';
                DSE.form.doReset();
            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.doReset();

});