dseDefine('../js/resEdit', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'easyui_valid', 'form'],
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
                    validType : 'maxLength[16]'
                });

                $("#ennm_auto").textbox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[30]'
                });

                $("#encl_auto").combobox({
                    required : true,
                    width : '180px',
                    height : '25px',
                    panelHeight: 'auto',
                    editable: false,
                    url: 'data/encl.json',
                    method: 'get',
                    valueField: 'id',
                    textField: 'text'
                });

                $("#aduncd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[12]'
                });

                $("#adunnm_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#lttd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[12]'
                });

                $("#lgtd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[12]'
                });

                $("#adunadd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#adunzip_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#adunfax_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#aduntel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#depma_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[50]'
                });

                $("#depmacd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[12]'
                });

                $("#depmaadd_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#depmazip_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#depmafax_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#depmatel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#adminnm_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[50]'
                });

                $("#admintel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#prodnm_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[50]'
                });

                $("#prodtel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#skillnm_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[50]'
                });

                $("#skilltel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                $("#safetynm_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[50]'
                });

                $("#safetytel_auto").textbox({
                    width : '180px',
                    height : '25px',
                    validType : 'maxLength[100]'
                });

                var data = basicDataPage.getData();

                if (data != null) {
                    $('#dseForm').autoFillForm(data);
                    $('#oennmcd_auto').val(data.ennmcd);
                    if (basicDataPage.getButtonType() == 1) {
                        $('.red').css("display", "none");
                        $('#dseForm input').attr("readonly", "true");
                        $('#encl_auto').combobox('disable');
                        $("#btns").hide();
                    }
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

                    var url = '';
                    if (data != null) {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (data.ennmcd != ennmcd && row.ennmcd == ennmcd) {
                                layer.msg('水库名称代码【' + ennmcd + '】已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicDataCtl/updateReservoirInfo.do";
                    } else {
                        for (var i = 0; i < rows.length; i++) {
                            var row = rows[i];
                            if (row.ennmcd == ennmcd) {
                                layer.msg('水库名称代码【' + ennmcd + '】已经存在！', {
                                    offset : 10,
                                    shift : 0,
                                    time : 1500,
                                    icon : 5
                                });
                                return false;
                            }
                        }
                        url = window._baseUrl + "BasicDataCtl/saveReservoirInfo.do"
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
                                layer.msg('水库名称代码【' + ennmcd + '】已经存在！', {
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
seajs.use(['../js/resEdit'],
    function(m) {
        page = m;
    });