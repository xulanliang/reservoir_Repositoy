dseDefine('../js/basicDataPage', ['jquery', 'layer','easyui', 'easyui_lang', 'common', 'zTree', 'formValidate' ,'formBootstrap', 'datagridTip'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        require('zTree');
        require('formValidate');
        require('formBootstrap');
        var showtips = require('datagridTip');

        var layer = require('layer');
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });
        var h = $(window).height(), cfg, nodeType, nodeId, data, parentInfo, buttonType, flag = true;

        var myModule = {

            init: function() {

                $('#reservoir').textbox({
                    width: '150px',
                    heigth: '30px'
                });

                cfg = {
                    view: {
                        selectedMulti: false
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "id",
                            pIdKey: "pid"
                        },
                        key: {
                            name: 'name'// 设置数据的label字段
                        }
                    },
                    callback: {
                        beforeClick: beforeClick,
                        onClick: myModule.onClick// 用户单击查看详情
                    }
                };

                function beforeClick(treeId, treeNode) {
                    if (treeNode.type == "5") {
                        return false;
                    } else{
                        return true;
                    }
                }

                myModule.loadData();

            },

            loadData: function() {
                $.ajax({
                    url : window._baseUrl + "BasicDataCtl/queryData.do",
                    dataType : "json",
                    success : function(data) {
                        $.fn.zTree.init($("#tree"), cfg, data);
                        var treeObj = $.fn.zTree.getZTreeObj("tree");
                        treeObj.expandAll(true);
                        var nodes = treeObj.getNodes();
                        if (nodes.length > 0) {
                            nodes[0].isParent = true;
                            nodes[0].iconSkin = 'org';
                            nodes[0].nocheck = true;
                        }
                        if (flag) {
                            flag = false;
                            var node = treeObj.getNodeByParam("id", "-1");
                            treeObj.selectNode(node);
                            myModule.onClick(null, -1, node);
                        }
                    }
                });
            },


            loadGrid: function() {
                var obj, url = '';
                if (nodeType == 1) {
                    obj = JSON.stringify({
                        ennm : $('#reservoir').textbox('getValue').trim()
                    });
                    url = window._baseUrl + 'BasicDataCtl/getReservoirList.do';
                } else if (nodeType == 2) {
                    obj = JSON.stringify({
                        ennmcd : nodeId
                    });
                    url = window._baseUrl + 'BasicDataCtl/getDykeList.do';
                } else if (nodeType == 3) {
                    obj = JSON.stringify({
                        ennmcd : nodeId
                    });
                    url = window._baseUrl + 'BasicDataCtl/getSectionList.do';
                } else if (nodeType == 4) {
                    obj = JSON.stringify({
                        bntrcd : nodeId
                    });
                    url = window._baseUrl + 'BasicDataCtl/getMonitorList.do';
                }
                $.ajax({
                    url: url,
                    type: "post",
                    data:  obj,
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
                            }
                        });
                    }
                });
                $('#tool input').attr("disabled", "true");
                $('#add').removeAttr("disabled");
            },

            listen: function() {

                $('#query').click(function(){
                    myModule.loadGrid();
                });

                $('#lookup').click(function() {
                    buttonType = 1;
                    var datagrid = $('#datagrid');
                    var rows = datagrid.datagrid('getChecked');
                    data = rows[0];
                    if (nodeType == 1) {
                        title = '查看-水库';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/resEdit.html';
                    } else if (nodeType == 2) {
                        title = '查看-堤防(段)';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/dyKeEdit.html';
                    } else if (nodeType == 3) {
                        title = '查看-堤防(段)横断面';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/sectionEdit.html';
                    } else if (nodeType == 4) {
                        title = '查看-监测点';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/monitorEdit.html';
                    }
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
                    var title = '', url = '';
                    if (nodeType == 1) {
                        title = '添加-水库';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/resEdit.html';
                    } else if (nodeType == 2) {
                        title = '添加-堤防(段)';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/dyKeEdit.html';
                    } else if (nodeType == 3) {
                        title = '添加-堤防(段)横断面';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/sectionEdit.html';
                    } else if (nodeType == 4) {
                        title = '添加-监测点';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/monitorEdit.html';
                    }
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
                    if (nodeType == 1) {
                        title = '编辑-水库';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/resEdit.html';
                    } else if (nodeType == 2) {
                        title = '编辑-堤防(段)';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/dyKeEdit.html';
                    } else if (nodeType == 3) {
                        title = '编辑-堤防(段)横断面';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/sectionEdit.html';
                    } else if (nodeType == 4) {
                        title = '编辑-监测点';
                        url = window._baseUrl + 'pages/app/damSafety/basicData/monitorEdit.html';
                    }
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
                        if (nodeType == 1) {
                            url = window._baseUrl + 'BasicDataCtl/deleteReservoirInfo.do';
                            obj.ennmcd = rows[0].ennmcd;
                        } else if (nodeType == 2) {
                            url = window._baseUrl + 'BasicDataCtl/deleteDykeInfo.do';
                            obj.ennmcd = rows[0].ennmcd;
                        } else if (nodeType == 3) {
                            url = window._baseUrl + 'BasicDataCtl/deleteSectionInfo.do';
                            obj.ennmcd = rows[0].bntrcd;
                        } else if (nodeType == 4) {
                            url = window._baseUrl + 'BasicDataCtl/deleteMonitorInfo.do';
                            obj.ennmcd = rows[0].pointcd;
                        }
                        // 询问框
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
                                        myModule.loadGrid();
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
                return parentInfo;
            },
            getButtonType: function() {
                return buttonType;
            },

            getRows: function() {
                var allPosidData = $('#datagrid').datagrid('getData').rows;
                return allPosidData;
            },

            // 点击节点看详情的事件
            onClick: function(event, treeId, treeNode) {
            var type = treeNode.type;
            parentInfo = treeNode;
            $('#search').show();
            if (type == 1) {
                $('#res').show();
                $('#datagrid').datagrid({
                    width: '99.8%',
                    height: h - 100,
                    striped: true,
                    singleSelect:true,
                    rownumbers: true,
                    onSelect: function (index, row) {
                        var rows = $('#datagrid').datagrid('getChecked');
                        if (rows.length == 1) {
                            $('#tool input').removeAttr('disabled');
                        } else {
                            $('#tool input').attr("disabled", "true");
                            $('#add').removeAttr("disabled");
                        }
                    },
                    columns: [[
                        {
                            field: 'ennmcd',
                            title: '水库名称代码',
                            width: "20%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'ennm',
                            title: '水库名称',
                            width: "20%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'encl',
                            title: '工程等别',
                            width: "20%",
                            halign: 'center',
                            align: 'center',
                            formatter: function(value,row,index){
                                if (value == 1) {
                                    return '大(１)型';
                                } else if (value == 2) {
                                    return '大(２)型';
                                } else if (value == 3) {
                                    return '中型';
                                } else if (value == 4) {
                                    return '小(１)型';
                                } else if (value == 5) {
                                    return '小(２)型';
                                }
                            }
                        },
                        {
                            field: 'aduncd',
                            title: '管理单位代码',
                            width: "20%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'depma',
                            title: '主管部门名称',
                            width: "19.5%",
                            halign: 'center',
                            align: 'center'
                        }
                    ]]
                });
            } else if (type == 2) {
                $('#res').hide();
                $('#datagrid').datagrid({
                    width: '99%',
                    height: h - 100,
                    striped: true,
                    singleSelect:true,
                    rownumbers: true,
                    onSelect: function (index, row) {
                        var rows = $('#datagrid').datagrid('getChecked');
                        if (rows.length == 1) {
                            $('#tool input').removeAttr('disabled');
                        } else {
                            $('#tool input').attr("disabled", "true");
                            $('#add').removeAttr("disabled");
                        }
                    },
                    columns: [[
                        {
                            field: 'ennmcd',
                            title: '堤防(段)名称代码',
                            width: "49.5%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'ennm',
                            title: '堤防(段)名称',
                            width: "49.5%",
                            halign: 'center',
                            align: 'center'
                        }
                    ]]
                });
            } else if (type == 3) {
                $('#res').hide();
                $('#datagrid').datagrid({
                    width: '99%',
                    height: h - 100,
                    striped: true,
                    singleSelect:true,
                    rownumbers: true,
                    onSelect: function (index, row) {
                        var rows = $('#datagrid').datagrid('getChecked');
                        if (rows.length == 1) {
                            $('#tool input').removeAttr('disabled');
                        } else {
                            $('#tool input').attr("disabled", "true");
                            $('#add').removeAttr("disabled");
                        }
                    },
                    columns: [[
                        {
                            field: 'bntrcd',
                            title: '堤防(段)横断面代码',
                            width: "49.5%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'bntr',
                            title: '堤防(段)横断面',
                            width: "49.5%",
                            halign: 'center',
                            align: 'center'
                        }
                    ]]
                });
            } else if (type == 4) {
                $('#res').hide();
                $('#datagrid').datagrid({
                    width: '99%',
                    height: h - 100,
                    striped: true,
                    singleSelect:true,
                    rownumbers: true,
                    onSelect: function (index, row) {
                        var rows = $('#datagrid').datagrid('getChecked');
                        if (rows.length == 1) {
                            $('#tool input').removeAttr('disabled');
                        } else {
                            $('#tool input').attr("disabled", "true");
                            $('#add').removeAttr("disabled");
                        }
                    },
                    columns: [[
                        {
                            field: 'pointcd',
                            title: '监测点代码',
                            width: "25%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'point',
                            title: '监测点名称',
                            width: "25%",
                            halign: 'center',
                            align: 'center'
                        },
                        {
                            field: 'category',
                            title: '监测方法',
                            width: "24.5%",
                            halign: 'center',
                            align: 'center',
                            formatter: function(value,row,index){
                                if (value == 1) {
                                    return '水平位移';
                                } else if (value == 2) {
                                    return '垂直位移';
                                } else if (value == 3) {
                                    return '渗压';
                                } else if (value == 4) {
                                    return '渗流';
                                }
                            }
                        },
                        {
                            field: 'ptype',
                            title: '监测点类型',
                            width: "24.5%",
                            halign: 'center',
                            align: 'center',
                            formatter: function(value,row,index){
                                if (value == 1) {
                                    return '人工采集';
                                } else {
                                    return '自动采集';
                                }
                            }
                        }
                    ]]
                });
            }
            nodeType = type;
            nodeId = treeNode.id;
            myModule.loadGrid();
        }
        };
        module.exports = myModule;

        $(function() {
            myModule.init();
            myModule.listen();
        });
    });

var page;
seajs.use(['../js/basicDataPage'],
    function(m) {
        page = m;
    });