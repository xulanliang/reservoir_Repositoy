dseDefine('../js/sectionEdit', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'easyui_valid', 'form'],
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

                $("#bntrcd_auto").textbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[16]'
                });

                $("#bntr_auto").textbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[30]'
                });

                var data = basicDataPage.getData();

                if (data != null) {
                    $('#dseForm').autoFillForm(data);
                    $('#obntrcd_auto').val(data.bntrcd);
                    if (basicDataPage.getButtonType() == 1) {
                        $('.red').css("display", "none");
                        $('#dseForm input').attr("readonly", "true");
                        $("#btns").hide();
                    }
                } else {
                    $('#ennmcd_auto').val(basicDataPage.getParentInfo().id);
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
                    var bntrcd = $('#bntrcd_auto').textbox('getValue');

                    var url = '';
                    if (data != null) {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (data.bntrcd != bntrcd && row.bntrcd == bntrcd) {
                                layer.msg('堤防(段)横断面代码【' + bntrcd + '】已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicDataCtl/updateSectionInfo.do";
                    } else {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (row.bntrcd == bntrcd) {
                                layer.msg('堤防(段)横断面代码【' + bntrcd + '】已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicDataCtl/saveSectionInfo.do"
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
                                    basicDataPage.loadGrid();
                                    closeWin();
                                });
                            } else {
                                layer.msg('堤防(段)横断面代码【' + bntrcd + '】已经存在！', {
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
seajs.use(['../js/sectionEdit'],
    function(m) {
        page = m;
    });