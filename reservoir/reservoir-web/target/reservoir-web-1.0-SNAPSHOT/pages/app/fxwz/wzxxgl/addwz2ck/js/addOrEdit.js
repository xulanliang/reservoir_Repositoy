/**
 * Created by pc on 2017-8-3.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
require_js('comm_fxwzSearch', 'pages/app/fxwz/js/comm_fxwzSearch', ['eform']);

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        comm_fxwzSearch = require('comm_fxwzSearch'),
        date = require('date'),
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
                ma_cds: parent.DSE.app.ma_cds, //
                ma_nms: parent.DSE.app.ma_nms, //
                gs_std_quans: parent.DSE.app.gs_std_quans, //
                ma_pc: '', //
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
                if (data["org_cd"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#org_cd_auto').focus();
                    });
                    return false;
                }else if (data["wh_cd"] == '') {
                    $tips.msg('请选择仓库', function() {
                        $('#wh_cd_auto').focus();
                    });
                    return false;
                } else if (data["real_quan"] == '') {
                    $tips.msg('请输入数量', function() {
                        $('#real_quan_auto').focus();
                    });
                    return false;
                }else if (data["ma_pc"] == '') {
                    $tips.msg('请输入物资批次', function() {
                        $('#ma_pc_auto').focus();
                    });
                    return false;
                }else if (data["binnum"] == '') {
                    $tips.msg('请输入货柜', function() {
                        $('#binnum_auto').focus();
                    });
                    return false;
                }else if (data["std_quan"] == '') {
                    $tips.msg('请输入存储定额', function() {
                        $('#std_quan_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'wzkzglCtrl/addwz2ck.do',
                        async: true,
                        data: {
                            dataStr: JSON.stringify(data)
                        },
                        type: 'post',
                        success: function(data) {
                            console.log('data: '+data);
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
        //$("#ma_cds_auto").val($.getParam("ma_cds"));
        //$("#ma_nms_auto").val($.getParam("ma_nms"));
        DSE.form.SearchFlag = false;
        DSE.form.statusModelFlag ="addwz2ck";
        app.ma_pc=getCurentDate();
        DSE.form.initSearch();
        //console.log(' ma_cds:'+$.getParam("ma_cds")+' ma_nms:'+$.getParam("ma_nms"));

    } else {
        //同步加载请求
        var data = $ajax({
                url: DSE.serverPath + 'wzkzglCtrl/getInfoById.do?id=' + app.rowId
            }) || [];

        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data, app.operType);

    }
    //隐藏加载图片
    parent.DSE.app.loading2 = false;

    // 执行输入校验
    DSE.form.inputLimit(form);

});