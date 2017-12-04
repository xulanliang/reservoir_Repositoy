/**
 * Created by pc on 2017-8-1.
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

    // 执行输入校验
    DSE.form.inputLimit(form);

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
                console.log(data);
                //字段校验
                if (data["ma_type_name"] == '') {
                    $tips.msg('请填写物资分类名称', function() {
                        $('#ma_type_name_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'wzflglCtrl/saveOrUpdateInfo.do',
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
    var type = '#ma_type_pid_auto';

    var id = $('#ma_type_id_auto').val();

    var data = getDataInfo(DSE.serverPath + '/wzflglCtrl/getfl.do?id='+id)["data"];

    $(type).combotree({
        data: data,
        parentField: "MA_TYPE_PID",
        idFiled: "MA_TYPE_ID",
        textFiled: "MA_TYPE_NAME",
        width: '100%',
        editable: false,
        panelHeight: '300px',
        prompt: '-请选择-'
    });

    $('#ma_type_id_auto').blur(function(){
        if($('#ma_type_id_auto').val() != "") {
            $.ajax({
                url: DSE.serverPath + '/wzflglCtrl/checkId.do',
                async: false,
                data: {
                    id: $('#ma_type_id_auto').val()
                },
                type: 'post',
                success: function (data) {
                    if (data["data"].length > 0) {
                        $tips.err('该ID已存在！');
                        $('#ma_type_id_auto').val("");
                    }
                }
            });
        }
    });

    if (app.operType == 'add') {
        //表单元素初始化

    } else {
        //同步加载请求
        var data = $ajax({
                url: DSE.serverPath + 'wzflglCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data, app.operType);
        if(app.operType != 'add'){
            $('#ma_type_id_auto').hide();
            $('.ma_type_id_ori').text($('#ma_type_id_auto').val()).show();
        }
    }
    //隐藏加载图片
    parent.DSE.app.loading2 = false;

});
