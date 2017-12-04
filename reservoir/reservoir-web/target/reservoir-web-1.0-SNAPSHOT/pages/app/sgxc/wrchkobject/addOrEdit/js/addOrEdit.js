/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
require_js('comm_sgxcSearch', 'pages/app/sgxc/js/comm_sgxcAddOrEdit', ['eform']);
//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        wrchkobject_search = require('comm_sgxcSearch'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var form = '#m-form';
    var show = $.getParam("ck_item");

    // 执行输入校验
    DSE.form.inputLimit(form);
    //$("#CK_OBJ_ID_auto").hide();

    //渲染实例
    var app = new Vue({
        data: function() {
            return {
                title: parent.DSE.app.title,
                operType: parent.DSE.app.operType,
                rowId: parent.DSE.app.rowId,
                flag: true, //防止多次保存
                ck_item:show,//巡查对象分类(0:巡查对象,1:巡查点)
                type:parent.DSE.app.type,
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
                //console.log(data);
                //字段校验
                if (data["CK_NAME"] == '') {
                    $tips.msg('请输入对象名称', function() {
                        $('#CK_NAME_auto').focus();
                    });
                    return false;
                }else if (data["CK_ORG"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#CK_ORG_auto').focus();
                    });
                    return false;
                } else if (data["CK_TYPE"] == '') {
                    $tips.msg('请选择巡查类型', function() {
                        $('#CK_TYPE_auto').focus();
                    });
                    return false;
                }else if (data["CK_OBJECT"] == '') {
                    if(show==0){
                        $tips.msg('请选择对象分类', function() {
                            $('#CK_OBJECT_auto').focus();
                        });
                    }else if(show ==1){
                        $tips.msg('请选择巡查对象', function() {
                            $('#CK_OBJECT_auto').focus();
                        });
                    }
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + '/wrchkobjectCtrl/saveOrUpdateInfo.do',
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
    var inp_ck_obj_id="#CK_OBJ_ID_auto";


    $(inp_ck_obj_id).blur(function(){
        if($(inp_ck_obj_id).val() != "") {
            $.ajax({
                url: DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectCount.do',
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
        $('#CK_ITEM_auto').val(app.ck_item);
        DSE.form.SearchFlag =false;
        DSE.form.statusModelFlag ="wrchkobject";

        DSE.form.initSearch();

    } else {
        //同步加载请求

        //console.log(' app.rowId: '+app.rowId);

        var data = $ajax({
                url: DSE.serverPath + '/wrchkobjectCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        if('edit'==app.operType){
            DSE.form.SearchFlag =false;
            DSE.form.statusModelFlag ="wrchkobject";
            DSE.form.initSearch();
        }else{
            DSE.form.SearchFlag =false;
            DSE.form.statusModelFlag ="wrchkobject";
            DSE.form.initSearch();

            $("#CK_ORG_auto").hide();
            $("#CK_TYPE_auto").hide();
            $("#CK_OBJECT_auto").hide();
        }

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], app.operType);

        if(app.operType != 'add'){
            //$(inp_ck_obj_id).hide();
            //$('.CK_OBJ_ID_ori').text($(inp_ck_obj_id).val()).show();
        }
    }

    //隐藏加载图片
    parent.DSE.app.loading2 = false;
});
