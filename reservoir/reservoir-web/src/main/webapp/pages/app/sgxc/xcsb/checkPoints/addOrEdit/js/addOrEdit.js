/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
require_js('comm_sgxcSearch', 'pages/app/sgxc/js/comm_sgxcSearch', ['eform']);

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        comm_sgxcSearch = require('comm_sgxcSearch'),
        date97 = require('date97'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var form = '#m-form';

    // 执行输入校验
    DSE.form.inputLimit(form);

    //渲染实例
    var app = new Vue({
        data: function() {
            return {
                title: parent.DSE.app.title,
                operType: parent.DSE.app.operType,
                rowId: parent.DSE.app.rowId,
                flag: true, //防止多次保存
                ck_obj_id:$.getParam("ck_obj_id"),//对象,
                ck_re_id:$.getParam("ck_re_id"),//对象,
                hasQues:parent.DSE.app.hasQues,
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
                if (data["CK_CNT_ID"] == '') {
                    $tips.msg('请填写巡查内容编码', function() {
                        $('#CK_CNT_ID').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + '/wrchkredchildCtrl/saveOrUpdateInfo.do',
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
    var inp_ck_obj_id="#ID_auto";
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
                url: DSE.serverPath + '/wrchkredchildCtrl/getCount.do',
                async: false,
                data: {
                    'id': $(inp_ck_obj_id).val(),
                    'bean.id': $(inp_ck_obj_id).val(),
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
        DSE.form.statusModelFlag ='wrchkredchild';

        DSE.form.initSearch();

        //$("#CK_OBJ_ID_auto").val(app.ck_obj_id);

    } else {
        //同步加载请求

        //console.log(' app.rowId: '+app.rowId);

        var data = $ajax({
                url: DSE.serverPath + '/wrchkredchildCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        if('edit'==app.operType){
            DSE.form.SearchFlag =false;
            DSE.form.statusModelFlag ='wrchkredchild';
            DSE.form.initSearch();
        }else{
           $("#CH_STATUS_auto").hide();
        }
        //判断是否有异常点
        if(data.data[0].ISSUE_ID == null){
            //无异常
            app.hasQues=false;
        }
        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], app.operType);

        if(app.operType != 'add'){
            $(inp_ck_obj_id).hide();
            $('.ID_ori').text($(inp_ck_obj_id).val()).show();
        }
    }

    //隐藏加载图片
    parent.DSE.app.loading2 = false;

});
