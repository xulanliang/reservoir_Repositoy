/**
 * Created by pc on 2017-8-2.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
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
                flag: true //防止多次保存
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
                if (data["wh_nm"] == '') {
                    $tips.msg('请填写仓库名称', function() {
                        $('#wh_nm_auto').focus();
                    });
                    return false;
                }else if (data["org_cd"] == '') {
                    $tips.msg('请选择管理单位', function() {
                        $('#wh_nm_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'ckxxglCtrl/saveOrUpdateInfo.do',
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


    if (app.operType == 'add') {
        //表单元素初始化

    } else {
        //同步加载请求
        var data = $ajax({
                url: DSE.serverPath + 'ckxxglCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data, app.operType);

    }
    //隐藏加载图片
    parent.DSE.app.loading2 = false;


    // 执行输入校验
    DSE.form.inputLimit(form);

});