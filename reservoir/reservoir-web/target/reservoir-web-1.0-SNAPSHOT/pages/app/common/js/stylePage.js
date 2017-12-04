/*****=====datagrid通用查询方法=====*****/
//datagrid 默认的通用配置
DSE.form.singleTableEvents = function(_datagrid, _keyId) {
    return {
        width: '100%',
        singleSelect: true, //是否只能单选,默认否
        rownumbers: true, //显示序列号,默认不显示
        striped: true,
        pagination: true,
        onLoadSuccess: function(data) {
            // 没有数据时自动提示无数据
            // 不使用 DSE.form.MyDataGrid 而用 $(_datagrid) 是因为有少数情况会出现加载执行错误的问题
            //DSE.form.doBatchDatagrid(_datagrid, DSE.app.batch, true);
            //DSE.form.datagridLoadSuccess($(_datagrid));
        },
        onLoadError: function() {
            log('datagrid 渲染错误！');
        },
        onSelect: function() {
            DSE.form.dataRowID = DSE.form.getSelectId($(_datagrid), _keyId);
        },
        onSelectAll: function() {
            DSE.form.dataRowID = DSE.form.getSelectId($(_datagrid), _keyId);
        },
        onUnselect: function() {
            DSE.form.dataRowID = DSE.form.getSelectId($(_datagrid), _keyId);
        },
        onUnselectAll: function() {
            DSE.form.dataRowID = DSE.form.getSelectId($(_datagrid), _keyId);
        }
    };
};
//批量操作切换序号和 checkbox 的显示隐藏
DSE.form.doBatchDatagrid = function(obj, flag, isSuc) {
    var info = $(obj).data().datagrid,
        view = info.dc.view,
        view1 = info.dc.view1,
        view2 = info.dc.view2;
    if (!flag) {
        view1.show();
        view2.removeClass('showck');
        $(obj).datagrid('hideColumn', 'ck');
    } else {
        view1.hide();
        view2.addClass('showck');
        $(obj).datagrid('showColumn', 'ck');
    }
    $(obj).datagrid('options').singleSelect = !flag;
    if (!isSuc) {
        $(obj).datagrid('reload').datagrid('clearSelections');
    }
};
DSE.form.doBatchEdit = function(obj, type) {
    var info = $(obj).datagrid("getData");
    var rows = info.rows.length;
    if(rows){
        if('edit' == type){
            for(var i = 0 ; i<rows ;i++)   $(obj).datagrid('beginEdit', i);
        }else {
            for(var i = 0 ; i<rows ;i++) {
                $(obj).datagrid('endEdit', i);
            }
        }
    }
};
//打开编辑或详情页面
DSE.form.showEditOrDetail = function(id, title, operType, url) {
    if (DSE.app) {
        DSE.pageConfig.rowId = id;
        DSE.pageConfig.operType = operType;

        DSE.app.rowId = id;
        DSE.app.operType = operType;
        DSE.app.title = title;
        DSE.app.url = url;
    }
};
//执行查询
DSE.form.doSearch = function() {
    // 获取参数,easyui.dseForm.js里面的方法
    var _param = DSE.form.getAutoObject(DSE.form.sform),
        _data = null;
    if (DSE.app && DSE.app.addSearchParam) {
        //修改参数配置
        _param = DSE.app.addSearchParam(_param);
    }
    if (DSE.app && DSE.app.addSearchData) {
        //设置本地数据
        _data = DSE.app.addSearchData(_data);
    }
    //生成 datagrid
    DSE.form.initDatagrid(_param, _data);
    if (DSE.form.MyDataGrid) {
        DSE.form.MyDataGrid.datagrid('clearSelections');
    }
};
//重新加载所有数据
DSE.form.reload = function() {
    DSE.form.doSearch();
};
//重置
DSE.form.doReset = function() {
    //表单重置
    DSE.form.initSearch();
    $('input[type="text"]').not('.textbox-text').val('');
    DSE.form.reload();
};
//刷新表格
DSE.form.refreshDatagrid = function() {
    DSE.form.reload();
};
/*****=====end datagrid通用查询方法=====*****/
//删除
DSE.form.deleteDatagridRow = function(title, url, o) {
    o = o || {};
    o.deleteId = o.deleteId || 'ids';
    o.status = o.status || 'status';
    o.ids = o.ids || DSE.form.dataRowID;
    var $params = {};
    $params[o.deleteId] = o.ids;
    if (o.params && o.params.length > 0) {
        $.each(o.params, function(i) {
            $params[o.params[i]["key"]] = o.params[i]["value"];
        });
    }
    o.constraint = o.constraint || '2,3,4,6';
    //询问框
    var _selections = DSE.form.MyDataGrid.datagrid('getSelections'),
        _status;
    if (nullToSpace(o.ids) == '') {
        $tips.msg('请选择要删除的数据列');
        return false;
    } else {
        if (o.status) {
            var _c = o.constraint.split(',');
            for (var i in _selections) {
                if (_selections[i][o.status]) {
                    _status = String(_selections[i][o.status]);
                    $.each(_c, function(k) {
                        if (_status == String(_c[k])) {
                            $tips.msg('上报后数据不能删除');
                            return false;
                        }
                    });
                }
            }
        }
        var str = o.ids.split(',');
        if (str.length >= 1) {
            $tips.confirm("确认删除 [ " + title + " ] 吗?", function(index) {
                $.ajax({
                    url: DSE.serverPath + url,
                    data: $params,
                    type: 'post',
                    success: function(data) {
                        if (o.sucType == '2' ? data : data["data"]) {
                            $tips.suc('操作成功', function() {
                                //刷新
                                DSE.form.refreshDatagrid();
                            });
                        } else {
                            //操作失败
                            $tips.err('操作失败');
                        }
                    }
                });
            });
        }
    }
};
//下载
DSE.export.downExcel = function(data,shortName) { //水文气象-气温特征值报表.xlsx
    //console.log(' shortName1: '+shortName);
    shortName=encodeURIComponent(encodeURIComponent(shortName));
    var exportId=encodeURIComponent(data.data);
    //console.log(' encodeURIComponent exportId: '+exportId+'encodeURIComponent shortName2: '+shortName);
    var url=DSE.serverPath + '/excelController/downExcel.do?exportId=' + exportId + '&shortName='+shortName;
    window.location.href = url;
};

$(function () {
    $.extend($.fn.datagrid.methods, {
        addEditor: function (jq, param) {
            if (param instanceof Array) {
                $.each(param, function (index, item) {
                    var e = $(jq).datagrid('getColumnOption', item.field);
                    e.editor = item.editor;
                });
            } else {
                var e = $(jq).datagrid('getColumnOption', param.field);
                e.editor = param.editor;
            }
        },
        removeEditor: function (jq, param) {
            if (param instanceof Array) {
                $.each(param, function (index, item) {
                    var e = $(jq).datagrid('getColumnOption', item);
                    e.editor = {};
                });
            } else {
                var e = $(jq).datagrid('getColumnOption', param);
                e.editor = {};
            }
        }
    });
});

