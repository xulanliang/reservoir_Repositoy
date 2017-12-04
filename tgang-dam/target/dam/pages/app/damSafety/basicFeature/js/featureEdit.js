/**
 * Created by gaoq on 2017-4-18.
 */
dseDefine('../js/featureEdit', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'easyui_valid', 'form'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('easyui_valid');
        require('form');

        var basicDataPage = window.parent.page;
        var layer = require('layer');
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });

        var myModule = {

            init: function() {

                var form = $('#dseForm');

                $("#ennmcd_auto").textbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    editable: false,
                    validType : 'maxLength[16]'
                });

                $("#ennm_auto").textbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    editable: false,
                    validType : 'maxLength[30]'
                });

                $("#utm_auto").datetimebox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    editable: false
                });

                $("#ctm_auto").datetimebox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    editable: false
                });

                $("#dsfllv_auto").numberbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    max: 100.00,
                    min: 0,
                    precision: 2
                });

                $("#fldlim_auto").numberbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    max: 100.00,
                    min: 0,
                    precision: 2
                });

                $("#wsgtlv_auto").numberbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    max: 100.00,
                    min: 0,
                    precision: 2
                });

                var data = basicDataPage.getData();

                if (data != null) {
                    $('#dseForm').autoFillForm(data);
                    $('#outm_auto').val(data.utm);
                    if (basicDataPage.getButtonType() == 1) {
                        $('.red').css("display", "none");
                        $('#dseForm input').attr("readonly", "true");
                        $("#btns").hide();
                    }
                } else {
                    $('#ennmcd_auto').textbox('setValue', basicDataPage.getParentInfo().ennmcd);
                    $('#ennm_auto').textbox('setValue', basicDataPage.getParentInfo().ennm);
                }

                form.visible();// 新增模式直接显示
            },

            query: function() {
                $('#subBtn').click(function() {
                    // 校验
                    var form = $("#dseForm");
                    if (!form.form('validate')) {
                        layer.msg('校验失败！', {
                            offset : 10,
                            shift : 0,
                            time : 1500,
                            icon : 5
                        });
                        return;
                    }

                    var data = basicDataPage.getData(), rows = basicDataPage.getRows();
                    var ennmcd = $('#ennmcd_auto').textbox('getValue');
                    var ennm = $('#ennm_auto').textbox('getValue');
                    var utm = $('#utm_auto').datetimebox('getValue');

                    var url = '';
                    if (data != null) {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (data.ennmcd != ennmcd && row.utm == utm) {
                                layer.msg(ennm + '\n开始使用时间：' + utm + '已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicFeatureCtl/updateInfo.do";
                    } else {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (row.utm == utm) {
                                layer.msg(ennm + '\n开始使用时间：' + utm + '已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicFeatureCtl/saveInfo.do"
                    }

                    $.ajax({
                        url: url,
                        type: "post",
                        data: JSON.stringify($("#dseForm").getFormData()),
                        contentType: "application/json",
                        success: function (data) {
                            if (data.flag != 1) {
                                layer.msg('保存成功', {
                                    icon: 1,
                                    time: 2000,
                                    offset: '10%'
                                }, function(){
                                    basicDataPage.loadData();
                                    closeWin();
                                });
                            } else {
                                layer.msg(ennm + ' 开始使用时间：' + utm + '已经存在！', {
                                    icon: 4,
                                    time: 3000,
                                    offset: '10%'
                                });
                            }
                        }
                    });

                });
                $('#closeBtn').click(function() {
                    closeWin();
                });
            }

        };
        module.exports = myModule;

        $(function() {
            myModule.init();
            myModule.query();
        });
    });

var page;
seajs.use(['../js/featureEdit'],
    function(m) {
        page = m;
    });
