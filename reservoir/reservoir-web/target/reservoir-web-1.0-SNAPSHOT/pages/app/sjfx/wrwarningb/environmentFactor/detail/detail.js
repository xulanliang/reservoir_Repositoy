/**
 * 报警明细查看
 */
require_css('css!pages/app/common/css/style.css');

//执行配置
require.config(DSE.requireConfig);
//
define("detail", function (require, exports, module) {
    var _eform = require('eform');
    var _operConfig_ = require('oper_config');

    var $ = require("jquery");
    var base = require("base");
    var common = require("common");
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var form = '#m-form';

    //渲染实例
    DSE.app = new Vue({
        data: function () {
            return {
                title: parent.DSE.app.title,
                operType: parent.DSE.app.operType,
                rowId: parent.DSE.app.rowId,
                flag: true ,//防止多次保存
                loading2: true,//loading 状态显示隐藏
                wa_id:$.getParam("wa_id"),//
            }
        },
        methods: {
            doCloseWin: function() {
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
            },
            doSave:function () {
                var data = DSE.form.getAutoObject(form);
                if( data["NT"] == ""){
                    $tips.msg('请填处理意见', function() {
                        $('#NT_auto').focus();
                    });
                    return false;
                }else  if(data["WA_ID"] != "" && data["NT"] != "" && this.flag){
                    this.flag = false ;
                    $.ajax({
                        url: DSE.serverPath + '/wrwarningbCtrl/saveOrUpdateInfo.do',
                        data: {
                            waId: data["WA_ID"] ,
                            nt : data["NT"]
                        },
                        type: 'post',
                        dataType:'json',
                        success: function(data) {

                            if (data["data"] == '1') {
                               // $('#datagrid').datagrid('reload');      // 置为已读之后更新页面状态
                                // 父窗口调用方法刷新
                                if (parent.DSE.form.refreshDatagrid) {
                                    parent.DSE.form.refreshDatagrid();
                                }
                            }/*else{
                                       $tips.err('更新备注失败！');
                                   }*/
                            parent.DSE.app.loading2 = true;
                            parent.DSE.app.operType = '';
                        },
                        error :function (XMLHttpRequest, textStatus, errorThrown) {

                        }
                    });
                }
            }
        }
    }).$mount('#app');

    if (DSE.app.operType == 'add') {
        //表单元素初始化
    } else {
        //同步加载请求
        var data = $ajax({
            url: DSE.serverPath + '/wrwarningbCtrl/getInfoById.do?wa_id=' + DSE.app.rowId
        }) || [];

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], DSE.app.operType);
    }

});