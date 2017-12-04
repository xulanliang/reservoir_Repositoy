/**
 * Created by pc on 2017-7-7.
 */
require_css('css!pages/app/common/css/style.css');

require_js('bjxx_search', 'pages/app/bjxx/js/bjxxSearch', ['eform']);
require_js('bjxx_datagrid', 'pages/app/bjxx/js/bjxxDatagrid', ['bjxx_search', 'datagrid_pager']);
require_shim('stylePage', ['bjxx_datagrid']);

//执行配置
require.config(DSE.requireConfig);
//
define("bjxxindex", function (require, exports, module) {
    var _stylePage = require('stylePage');

    var $ = require("jquery");
    var base = require("base");
    var common = require("common");
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
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
                projcd:$.getParam("projcd"),//
                mon_tp:$.getParam("mon_tp"),
                wa_status: '0',
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
                this.title = '新增报警信息';
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html';
                }
            },
            //关闭
            doCloseWin: function () {
                //状态初始化为空
                this.operType = '';
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
                DSE.form.deleteDatagridRow('所选数据', 'wrwarningbCtrl/deleteInfoByIds.do', {status: false});
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
    DSE.form.doSearch();


});