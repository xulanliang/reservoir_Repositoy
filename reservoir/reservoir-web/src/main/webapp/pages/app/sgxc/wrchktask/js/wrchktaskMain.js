/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/common/css/style.css');
//require_css('css!pages/app/sgxc/css/sgxcPage.css');

require_js('wrchktask_search', 'pages/app/sgxc/js/comm_sgxcSearch', ['eform']);
require_js('wrchktask_datagrid', 'pages/app/sgxc/wrchktask/js/wrchktaskDatagrid', ['wrchktask_search', 'datagrid_pager']);
require_shim('stylePage', ['wrchktask_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('wrchktaskMain', function (require, exports, module) {
    var _stylePage = require('stylePage');
    var _common = require('common');
    //var _ztree = require('ztree');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        wrchkobject_search = require('wrchktask_search'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);



    //渲染实例
    DSE.app = new Vue({
        data: function () {
            return {
                title:'巡查计划管理',
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
                ck_obj_id:'',//巡查对象
                ck_obj_id_name:'',//对象,
                taskids:'',//对象,
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
                if (nullToSpace(DSE.app.ck_obj_id) == '') {
                     $tips.err('请在巡查对象树上选择一个对象节点,再进行巡查计划新增操作！');
                    // $.messager.alert('Warning','请在巡查对象树上选择一个对象节点,再进行巡查任务新增操作！');
                    return ;
                }
                */
                /*
                 *根据业务需求修改
                 * */
                this.operType = 'add';
                this.title = '新增巡查计划信息';
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html?ck_obj_id='+DSE.app.ck_obj_id;
                }
            },
            doexecCreateTaskRecord: function () {
                if (nullToSpace(this.taskids) == '') {
                    $tips.err('请在巡查计划列表中选择一个巡查计划,再进行生成巡查任务操作！');
                    // $.messager.alert('Warning','请在巡查对象树上选择一个对象节点,再进行巡查任务新增操作！');

                }else{
                    execCreateTaskRecord(this.taskids);
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
            },doBatchCreateTaskRecord: function () {
                //DSE.form.dataRowID = DSE.form.getSelectId($("#datagrid"), "CK_TK_ID");
                console.log('  DSE.form.dataRowID： '+ DSE.form.dataRowID);
                execCreateTaskRecord(DSE.form.dataRowID);

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
                DSE.form.deleteDatagridRow('所选数据', 'wrchkTaskCtrl/deleteInfoByIds.do', {status: false});
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

    /*
    var ztreeObj;
    var h = $(document).height() - 0;
    if( h<500){
        h=500;
    }
    // console.log('  h:'+ h);
    $('.g-bd1').height(h);
    $('.g-mn1c').height(h-30);
    $('.myztree').height(h-20);

    function zTreeOnClick(event, treeId, treeNode) {
        //if(treeNode.isParent){
        //    return ;
        //}
        // url = DSE.baseUrl + treeNode.CK_OBJ_ID;
        //$('#iframe').attr("src",url);
        DSE.app.ck_obj_id=treeNode.CK_OBJ_ID;
        DSE.app.ck_obj_id_name=treeNode.CK_NAME;
        //巡查对象
        $('#ck_obj_id_auto').val(DSE.app.ck_obj_id);
        $('#ck_obj_id_name').val(DSE.app.ck_obj_id_name);
        // console.log('DSE.app.ck_obj_id: '+ DSE.app.ck_obj_id);
        DSE.form.doSearch();
    };

    var setting = {
        data: {
            key : {
                title : "CK_NAME", //鼠标悬停显示的信息
                name : "CK_NAME" //网页上显示出节点的名称
            },
            simpleData: {
                enable: true,
                idKey: "CK_OBJ_ID", //修改默认的ID为自己的ID
                pIdKey: "CK_OBJ_PID",//修改默认父级ID为自己数据的父级ID
                rootPId: null     //根节点的ID
            }
        },
        callback: {
            onClick: zTreeOnClick
        }
    };

    $.ajax({
        url: DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do',
        async: false,
        type: 'post',
        success: function(data) {
            ztreeObj= $.fn.zTree.init($("#chkobjtree"), setting, data.data);
            //ztreeObj.expandAll(true);
            //url = DSE.baseUrl + data[0].CK_OBJ_ID;
            var nodes = ztreeObj.getNodes();
            if (nodes.length>0) {
                ztreeObj.expandNode(nodes[0], true, true, true);
            }
        }
    });
    */
    //初始化查询
    DSE.form.doReset();


    function execCreateTaskRecord(taskidsStr){
        if(taskidsStr!=null && taskidsStr.length>0){
            $.ajax({
                url: DSE.serverPath + '/wrchkTaskCtrl/execCreateTaskRecord.do',
                async: true,
                type: 'post',
                data:{
                    taskids:taskidsStr,
                },
                success: function(data) {
                    console.log(' resultData: '+displayProp(data));
                    // $tips.suc('操作成功!');
                    $tips.msg('操作成功!');
                }
            });
        }
    }

});