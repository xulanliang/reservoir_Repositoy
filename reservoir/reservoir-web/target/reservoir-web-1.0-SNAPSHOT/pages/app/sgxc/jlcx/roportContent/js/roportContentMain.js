/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/common/css/style.css');

require_js('wrchkredchildSearch', 'pages/app/sgxc/xcsb/roportContent/js/roportContentSearch', ['eform']);
require_js('wrchkredchildDatagrid', 'pages/app/sgxc/jlcx/roportContent/js/roportContentDatagrid', ['wrchkredchildSearch', 'datagrid_pager']);
require_shim('stylePage', ['wrchkredchildDatagrid']);

//执行配置
require.config(DSE.requireConfig);
define('roportContentMain', function (require, exports, module) {
    var _stylePage = require('stylePage');
    var extendDatagrid = require('extendDatagrid');
    var num = $.getParam("isNotSaved");
    var isNotSaved;
    if(num=='0' || num=='1'){
        //未上报
        isNotSaved=true;
    }else {
        isNotSaved=false;
    }

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        wrchkredchildSearch = require('wrchkredchildSearch'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function () {
            return {
                title:'巡查记录项目管理',
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
                ck_re_id:$.getParam("ck_re_id"),//
                ck_obj_id:$.getParam("ck_obj_id"),//
                CK_OBJECT_NAME:$.getParam("CK_OBJECT_NAME"),//
                isNotSaved:isNotSaved,       //是否未上报
            }
        },
        methods: {

            //日期 change
            changeDateVal: function (value) {
                this.minDate = value.substring(0, 10);
                this.maxDate = value.substring(value.length - 10, value.length);
                DSE.form.doSearch();
            },
            doParentCloseWin: function() {
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
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
                this.title = '新增巡查记录项目信息';
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html?ck_re_id='+DSE.app.ck_re_id+'&ck_obj_id='+DSE.app.ck_obj_id;
                }
            },
            //导出
            doExport: function() {
                var grid = $('#datagrid');
                var options = grid.datagrid('getPager').data("pagination").options;
                var page = options.pageNumber;//当前页数
                var rows = options.total;       //总行数
                var CK_OBJECT_NAME = DSE.app.CK_OBJECT_NAME;
                var searchData = [];
                searchData = $("#search").serialize();
                var fileName =  "东深供水工程-"+CK_OBJECT_NAME +"-检查记录表.xls" ;
                var url= DSE.serverPath + '/wrchkredchildCtrl/export2Excel.do?' +searchData + '&rows='+rows+ '&ck_re_id='+DSE.app.ck_re_id + '&fileName='+encodeURIComponent(encodeURIComponent(fileName));
                window.location.href = url ;
            },
            doSave: function () {
                /*
                 * 上报
                 * */
                //执行保存方法
                $ajax({
                    url: DSE.serverPath + 'xcsbCtrl/doSave.do',
                    async: true,
                    data: {
                        //ckID: row.ID,   //内容ID
                        taskID:parent.DSE.app.rowId,    //任务ID
                    },
                    type: 'post',
                    success: function(data) {
                        if(data["data"]) {
                            $tips.suc('操作成功',function() {
                                // 父窗口调用方法刷新
                                if (parent.DSE.form.refreshDatagrid) {
                                    parent.DSE.form.refreshDatagrid();
                                }
                                parent.DSE.app.loading2 = true;
                                parent.DSE.app.operType = '';
                            });
                        } else {
                            //操作失败
                            $tips.err('操作失败');
                        }
                    },
                });

            },
            //关闭
            doCloseWin: function () {
                // 父窗口调用方法刷新
                if (parent.DSE.form.refreshDatagrid) {
                    parent.DSE.form.refreshDatagrid();
                }
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
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
                DSE.form.deleteDatagridRow('所选数据', 'wrchkredchildCtrl/deleteInfoByIds.do', {status: false});
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
    //巡查对象分类
    //$('#search_ck_re_id').val(DSE.app.ck_re_id);
    //console.log(' ck_re_id: '+DSE.app.ck_re_id+' ck_obj_id: '+DSE.app.ck_obj_id);
    //初始化查询
    DSE.form.doReset();

});