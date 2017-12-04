/**
 * Created by   on 2017-08-30.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        date = require('date'),
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
                wh_cd:$.getParam("wh_cd"),
                ma_cd:$.getParam("ma_cd"),
                ma_pc:$.getParam("ma_pc"),
                binnum:$.getParam("binnum"),
                ma_nm:$.getParam("ma_nm"),
                wh_nm:$.getParam("wh_nm"),
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
                //console.log(' data: ' +data);
                //字段校验
                if (data["MA_PC"] == '') {
                    $tips.msg('请填写物资批次', function() {
                        $('#MA_PC_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'wzkzglCtrl/saveOrUpdateWrmaquanbInfo.do',
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

    if (app.operType == 'add') {
        //表单元素初始化
        //console.log('  app.wh_cd:'+app.wh_cd+'  app.ma_cd:'+app.ma_cd+'  app.ma_pc:'+app.ma_pc+'  app.binnum:'+app.binnum);
        /*
            app.wh_cd=$.getParam("wh_cd");
            app.ma_cd=$.getParam("ma_cd");
            app.ma_pc=$.getParam("ma_pc");
            app.binnum=$.getParam("binnum");
        */
        app.ma_pc=getCurentDate();
        $("#WH_CD_auto").val($.getParam("wh_cd"));
        $("#MA_CD_auto").val($.getParam("ma_cd"));
        $("#MA_NM_auto").val($.getParam("ma_nm"));
        $("#WH_NM_auto").val($.getParam("wh_nm"));

    } else {
        //同步加载请求
        //console.log('  app.wh_cd:'+app.wh_cd+'  app.ma_cd:'+app.ma_cd+'  app.ma_pc:'+app.ma_pc+'  app.binnum:'+app.binnum);

        var data = $ajax({
                url: DSE.serverPath + 'wzkzglCtrl/getWrmaquanbInfoById.do?wh_cd=' + app.wh_cd+'&ma_cd=' + app.ma_cd+'&ma_pc=' + app.ma_pc+'&binnum=' + app.binnum
            }) || [];
        //console.log(' data: ' +displayProp(data.data)+ '  app.operType: '+app.operType);
        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], app.operType);
        $("#MA_PC_auto").attr("readonly","readonly");
        $("#BINNUM_auto").attr("readonly","readonly");

    }
    //隐藏加载图片
    parent.DSE.app.loading2 = false;

});