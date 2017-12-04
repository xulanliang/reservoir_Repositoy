/****
 *
 */
require_css('css!pages/app/common/css/style.css');
require_css('css!pages/app/sjfx/wralarmparamm/environmentfactor/css/editGrid.css');


require_js('environmentfactor_search', 'pages/app/sjfx/wralarmparamm/environmentfactor/js/environmentfactorSearch', ['eform']);
require_js('environmentfactor_datagrid', 'pages/app/sjfx/wralarmparamm/environmentfactor/js/environmentfactorDatagrid', ['environmentfactor_search', 'datagrid_pager']);
require_shim('stylePage', ['environmentfactor_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('environmentfactorMain', function (require, exports, module) {
    var _stylePage = require('stylePage');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        environmentfactor_search = require('environmentfactor_search'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function () {
            return {
                title:'报警设置',
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
                this.title = '新增'+DSE.app.ck_item_name+'信息';
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html?projcd='+DSE.app.projcd;
                }
            },
            //日期 change
            changeChkVal: function(vid) {
                this.mon_tp = vid;
                $("#mon_tp_auto").val(vid);
                console.log(' vid:'+vid);
                DSE.form.doSearch();
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
                //deleteDatagridRow可以传两个参数,title和url
                //注：因为通用删除时可以批量删除的,请求默认传参数名为ids
                //然后删除时一些提交上报后的数据是不能删除的,所以会有默认一个status字段判断选中的数据是否能够删除,constraint为判断条件
                //如：状态名为datastatus,同时判断条件为'0||1||5',表示选中的数据中包含有datastatus状态值为'2,3,4,6'的时候不能删除
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:'datastatus',constraint: '2,3,4,6'});
                //如不需要此判断可以添加参数
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:false});
                //如参数名不同可以加上第三个参数,如：deleteId为后台所需接收的参数名,
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{deleteId:'deleteId'});
                DSE.form.deleteDatagridRow('所选数据', 'wralarmparammCtrl/deleteInfoByIds.do', {status: false});
            },
            //查询
            doSearch: function () {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function () {
                this.dateVal = '';
                DSE.form.doReset();
            },
            //批量编辑
           doBatchEdit : function() {
               $('.top-btns-box').removeClass('f-dn');
               this.operType = 'edit';
               DSE.form.doBatchEdit(DSE.form.datagrid, this.operType);
           },
           doEscBatchEdit: function () {
                this.operType = '';
               // DSE.form.doBatchEdit(DSE.form.datagrid, false);
               DSE.form.reload();
           },
            doSave:function(){
                DSE.form.doBatchEdit(DSE.form.datagrid, false);
                DSE.form.refreshDatagrid();
               this.doEscBatchEdit();
            }
        }
    }).$mount('#app');
    //巡查对象分类

    //初始化查询
    DSE.form.doReset();

});
