/**
 * Created by gaoq on 2017-4-18.
 */
dseDefine('../js/basicFeature', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'datagridTip'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        var showtips = require('datagridTip');

        var layer = require('layer');
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });
        var h = $(window).height(), data, buttonType, stcd;

        var myModule = {

            init: function() {
                $('#datagrid').datagrid({
                    width: '99.8%',
                    height: h - 100,
                    striped: true,
                    singleSelect:true,
                    rownumbers: true,
                    columns: [[
                        {
                            field: 'ennmcd',
                            title: '水库名称代码',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'ennm',
                            title: '水库名称',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'dsfllv',
                            title: '设计水位',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'fldlim',
                            title: '汛限水位',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'wsgtlv',
                            title: '供水保障水位',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'utm',
                            title: '开始使用时间',
                            width: "16%",
                            halign: 'center',
                            align: 'center'
                        }
                    ]]
                });
                $.ajax({
                    url: window._baseUrl + 'BasicDataCtl/getReservoirList.do',
                    type: "post",
                    data: JSON.stringify({
                        ennm : ''
                    }),
                    contentType: 'application/json',
                    success: function (data) {
                        $('#reservoir').combobox({
                            width: '150px',
                            height: '25px',
                            editable: false,
                            valueField: 'ennmcd',
                            panelHeight: 'auto',
                            textField: 'ennm',
                            data: data,
                            onChange: function(n, o) {
                                stcd = n;
                                myModule.loadData();
                            },
                            onLoadSuccess: function () {
                                var data = $('#reservoir').combobox('getData');
                                stcd = data[0].ennmcd;
                                $("#reservoir").combobox('setValue', stcd);
                            }
                        });
                    }
                });
            },

            loadData: function() {
                $.ajax({
                    url: window._baseUrl + 'BasicFeatureCtl/getList.do',
                    type: "post",
                    data:  JSON.stringify({
                        ennmcd : stcd
                    }),
                    contentType: 'application/json',
                    success: function(data) {
                        var d = new Object();
                        d.total = data.length;
                        d.rows = data;
                        $('#datagrid').datagrid({
                            data: d,
                            onLoadSuccess : function(data) {
                                datagridNoData($('#datagrid'));
                                showtips('#datagrid');
                            },
                            onSelect: function (index, row) {
                                var rows = $('#datagrid').datagrid('getChecked');
                                if (rows.length == 1) {
                                    $('#tool input').removeAttr('disabled');
                                } else {
                                    $('#tool input').attr("disabled", "true");
                                    $('#add').removeAttr("disabled");
                                }
                            }
                        });
                    }
                });
                $('#tool input').attr("disabled", "true");
                $('#add').removeAttr("disabled");
            },

            listen: function() {

                $('#lookup').click(function() {
                    buttonType = 1;
                    var datagrid = $('#datagrid');
                    var rows = datagrid.datagrid('getChecked');
                    data = rows[0];
                    var title = '查看-特征值',url = window._baseUrl + 'pages/app/damSafety/basicFeature/featureEdit.html';
                    layer.open({
                        type : 2,
                        title : title,
                        scrollbar: false,
                        area : [ '60%', '80%' ],
                        content : url
                    });
                });
                $('#add').click(function() {
                    buttonType = 2;
                    var title = '添加-特征值',url = window._baseUrl + 'pages/app/damSafety/basicFeature/featureEdit.html';
                    data = null;
                    layer.open({
                        type : 2,
                        title : title,
                        scrollbar: false,
                        area : [ '60%', '80%' ],
                        content : url
                    });
                });
                $('#edit').click(function() {
                    buttonType = 3;
                    var datagrid = $('#datagrid');
                    var rows = datagrid.datagrid('getChecked');
                    data = rows[0];
                    var title = '编辑-特征值',url = window._baseUrl + 'pages/app/damSafety/basicFeature/featureEdit.html';
                    layer.open({
                        type : 2,
                        title : title,
                        scrollbar: false,
                        area : [ '60%', '80%' ],
                        content : url
                    });

                });
                $('#del').click(function() {
                    var rows = $('#datagrid').datagrid('getChecked');
                    if (rows.length < 1) {
                        layer.msg('请选择要删除的信息!', {
                            offset : 10,
                            shift : 0,
                            time : 1500,
                            icon : 5
                        });
                    } else {
                        var obj = new Object(), url = '';
                        url = window._baseUrl + 'BasicFeatureCtl/deleteInfo.do';
                        obj.ennmcd = rows[0].ennmcd;
                        obj.utm = rows[0].utm;

                        layer.confirm("你确认删除选择的信息吗？", {
                            title : '确认提示',
                            shade : 0.3
                        }, function() {
                            $.ajax({
                                url : url,
                                type: "post",
                                data : JSON.stringify(obj),
                                contentType : "application/json",
                                success : function(data) {
                                    if (data.flag != 1) {
                                        layer.msg(data.msg, {
                                            icon : 1,
                                            time : 1000
                                        });
                                        myModule.loadData();
                                    } else {
                                        layer.msg(data.msg, {
                                            icon : 5,
                                            time : 1000
                                        });
                                    }
                                }
                            });
                        });
                    }
                });
            },

            getData: function() {
                return data;
            },

            getParentInfo: function() {
                var parentInfo = new Object();
                parentInfo.ennm = $('#reservoir').combobox('getText');
                parentInfo.ennmcd = $('#reservoir').combobox('getValue');
                return parentInfo;
            },
            getButtonType: function() {
                return buttonType;
            },

            getRows: function() {
                var allPosidData = $('#datagrid').datagrid('getData').rows;
                return allPosidData;
            }

        };
        module.exports = myModule;

        $(function() {
            myModule.init();
            myModule.listen();
        });
    });

var page;
seajs.use(['../js/basicFeature'],
    function(m) {
        page = m;
    });