/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
require_js('wrchktask_search', 'pages/app/sgxc/js/comm_sgxcAddOrEdit', ['eform']);

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        wrchkobject_search = require('wrchktask_search'),
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
                ck_obj_id:$.getParam("ck_obj_id"),//对象,
                ck_obj_id_name:parent.DSE.app.ck_obj_id_name,//对象,
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
                console.log(data);
                //字段校验
                if (data["CK_TK_DESC"] == '') {
                    $tips.msg('请输入计划描述', function() {
                        $('#CK_TK_DESC_auto').focus();
                    });
                    return false;
                } else if (data["CK_ORG"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#CK_ORG_auto').focus();
                    });
                    return false;
                } else if (data["CK_TYPE"] == '') {
                    $tips.msg('请选择巡查类型', function() {
                        $('#CK_TYPE_auto').focus();
                    });
                    return false;
                } else if (data["CK_OBJECT"] == '') {
                    $tips.msg('请选择对象分类', function() {
                        $('#CK_OBJECT_auto').focus();
                    });
                    return false;
                } else if (data["CK_OBJECT"] == '') {
                    $tips.msg('请选择对象分类', function() {
                        $('#CK_OBJECT_auto').focus();
                    });
                    return false;
                } else if (data["CK_OBJ_ID"] == '') {
                    $tips.msg('请选择巡查对象', function() {
                        $('#CK_OBJ_ID_auto').focus();
                    });
                    return false;
                } else if (data["CK_BEGIN"] == '') {
                    $tips.msg('请选择起始日期', function() {
                        $('#CK_BEGIN_auto').focus();
                    });
                    return false;
                } else if (data["CK_END"] == '') {
                    $tips.msg('请选择结束日期', function() {
                        $('#CK_END_auto').focus();
                    });
                    return false;
                } else if (data["CK_CYCLE"] == '') {
                    $tips.msg('请选择巡查周期', function() {
                        $('#CK_CYCLE_auto').focus();
                    });
                    return false;
                } else if (data["CK_FREQUENCY"] == '') {
                    $tips.msg('请输入巡查次数', function() {
                        $('#CK_FREQUENCY_auto').focus();
                    });
                    return false;
                } else if (data["LAST_CREATE_DATE"] == '') {
                    $tips.msg('请选择下次生成时间', function() {
                        $('#LAST_CREATE_DATE_auto').focus();
                    });
                    return false;
                } else if (data["STATUS"] == '') {
                    $tips.msg('请选择状态', function() {
                        $('#STATUS_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + '/wrchkTaskCtrl/saveOrUpdateInfo.do',
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
    var inp_ck_obj_id="#CK_TK_ID_auto";
    /*
     var id_ck_obj_pid = '#CK_OBJ_ID_auto';
     var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do?notckobjid='+app.rowId+'&ck_item=0')["data"];
     //console.log(' data :'+data);
     $(id_ck_obj_pid).combotree({
     data: data,
     parentField: "CK_OBJ_PID",
     idFiled: "CK_OBJ_ID",
     textFiled: "CK_NAME",
     width: '100%',
     editable: false,
     panelHeight: 'auto',
     prompt: '-请选择-'
     });
     */

    $(inp_ck_obj_id).blur(function(){
        if($(inp_ck_obj_id).val() != "") {
            $.ajax({
                url: DSE.serverPath + '/wrchkTaskCtrl/getWrchkTaskCount.do',
                async: false,
                data: {
                    'ck_obj_id': $(inp_ck_obj_id).val(),
                    'bean.ck_obj_id': $(inp_ck_obj_id).val(),
                },
                type: 'post',
                success: function (data) {
                    var rsdata=data["data"];
                    //console.log('rsdata : '+rsdata+' rsdata[0].NUM: '+rsdata[0].NUM);
                    if (rsdata.length > 0 && rsdata[0].NUM>0 ) {
                        $tips.err('['+$(inp_ck_obj_id).val()+']编码已存在！');
                        $(inp_ck_obj_id).val("");
                    }
                }
            });
        }
    });

    if (app.operType == 'add') {
        //表单元素初始化
        //设定
        DSE.form.SearchFlag =false;
        DSE.form.statusModelFlag ='wrchktask';
        DSE.form.initSearch();

        //$("#ck_obj_id_name").text(app.ck_obj_id_name);
        //$("#ck_obj_id_name").show();
        //console.log('app.ck_obj_id: '+app.ck_obj_id);
        console.log('app.ck_obj_id: '+app.ck_obj_id+' getParam: '+$.getParam("ck_obj_id"));
        //$("#CK_OBJ_ID_auto").val(app.ck_obj_id);

    } else {
        //同步加载请求

        //console.log(' app.rowId: '+app.rowId);

        var data = $ajax({
                url: DSE.serverPath + '/wrchkTaskCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        if('edit'==app.operType){
            DSE.form.SearchFlag =false;
            DSE.form.statusModelFlag ='wrchktask';
            DSE.form.initSearch();
        }else{
            DSE.form.SearchFlag =false;
            DSE.form.statusModelFlag ='wrchktask';
            DSE.form.initSearch();

            $("#CK_ORG_auto").hide();
            $("#CK_TYPE_auto").hide();
            $("#CK_OBJECT_auto").hide();
            $("#STATUS_auto").hide();
            $("#CK_CYCLE_auto").hide();
        }

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], app.operType);

        if(app.operType != 'add'){
            //  $(inp_ck_obj_id).hide();
            // $('.CK_TK_ID_ori').text($(inp_ck_obj_id).val()).show();
        }
    }

    //隐藏加载图片
    parent.DSE.app.loading2 = false;

    // 执行输入校验
    DSE.form.inputLimit(form);

});
