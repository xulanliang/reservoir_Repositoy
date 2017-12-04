/**
 * Created by pc on 2017-8-2.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
require_js('comm_fxwzSearch', 'pages/app/fxwz/js/comm_addOrEdit', ['eform']);

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        comm_fxwzSearch = require('comm_fxwzSearch'),
        date97 = require('date97'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var form = '#m-form';



    //渲染实例
    var app = new Vue({
        data: function() {
            return {
                title: parent.DSE.app.title,
                operType: parent.DSE.app.operType,
                rowId: parent.DSE.app.rowId,
                flag: true, //防止多次保存
                isflood: parent.DSE.app.isflood,
            }
        },
        methods: {
            doCloseWin: function() {
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
            },
            doSave: function() {
                //获取表单值,easyui.dseForm.js的方法
                var data = DSE.form.getAutoObject(form);

                //字段校验
                if (data["ORG_CD"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#ORG_CD_auto').focus();
                    });
                    return false;
                }else if (data["WH_CD"] == '') {
                    $tips.msg('请选择仓库', function() {
                        $('#WH_CD_auto').focus();
                    });
                    return false;
                }else if (data["PATROL_DESC"] == '') {
                    $tips.msg('请输入巡查内容', function() {
                        $('#PATROL_DESC_auto').focus();
                    });
                    return false;
                }else if (data["PATROL_DATE"] == '') {
                    $tips.msg('请选择巡查时间', function() {
                        $('#PATROL_DATE_auto').focus();
                    });
                    return false;
                }else if (data["PA_STATUS"] == '') {
                    $tips.msg('请选择状态', function() {
                        $('#PA_STATUS_auto').focus();
                    });
                    return false;
                }else if (data["CREATE_USER"] == '') {
                    $tips.msg('请输入创建人员', function() {
                        $('#CREATE_USER_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'wrmapatrolbCtrl/saveOrUpdateInfo.do',
                        async: true,
                        data: {
                            dataStr: JSON.stringify(data)
                        },
                        type: 'post',
                        success: function(data) {
                            if (data["data"]) {
                                $tips.suc('操作成功', function() {
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
                }
            }
        }
    }).$mount('#app');

    //初始化表单元素
    var org = '#org_cd_auto',
        status = '#wh_status_auto';
    /*
    var data = getDataInfo(DSE.serverPath + '/ckxxglCtrl/getOrg.do')["data"];

    $(org).combobox({
        data: data,
        valueField: 'ID',
        textField: 'NAME',
        width: '100%',
        panelHeight: 'auto',
        prompt: '-请选择-',
        editable: false
    });

    $(status).combobox({
        data: [
            { id: "0", text: "活动" },
            { id: "1", text: "暂挂" },
            { id: "2", text: "停止使用" }
        ],
        valueField: 'id',
        textField: 'text',
        width: '100%',
        panelHeight: 'auto',
        prompt: '-请选择-',
        editable: false
    });
     */



    if (app.operType == 'add') {
        //表单元素初始化
        DSE.form.SearchFlag = false;
        DSE.form.statusModelFlag ="addwrmapatrolbPage";
        DSE.form.initSearch();

    } else {
        //同步加载请求
        var data = $ajax({
                url: DSE.serverPath + 'wrmapatrolbCtrl/getInfoById.do?id=' + app.rowId
            }) || [];
        //填充数据到表单元素,easyui.dseForm.js里的方法
        if(data.data[0].PA_STATUS==0){
            data.data[0].PA_NAME='未开始';
        }else if(data.data[0].PA_STATUS==1){
            data.data[0].PA_NAME='进行中';
        }else if(data.data[0].PA_STATUS==2){
            data.data[0].PA_NAME='已完成';
        }
        DSE.form.showFormContent(data.data[0], app.operType);

        if(app.operType=='edit'){
            DSE.form.SearchFlag = false;
            DSE.form.statusModelFlag ="addwrmapatrolbPage";
            DSE.form.initSearch();
        }else{
            $("#ORG_CD_auto").hide();
            $("#WH_CD_auto").hide();
        }

    }
    //隐藏加载图片
    parent.DSE.app.loading2 = false;


    // 执行输入校验
    DSE.form.inputLimit(form);

});