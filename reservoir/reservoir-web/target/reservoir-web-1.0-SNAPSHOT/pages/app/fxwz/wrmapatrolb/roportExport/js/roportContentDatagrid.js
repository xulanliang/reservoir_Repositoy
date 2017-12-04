/**
 * Created by  on 2017-8-12.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {
    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段

    _url = DSE.serverPath + '/wrmapatrolbCtrl/getWZXCListInfoByParams.do', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 80, //计算列表的高度,根据页面内容调整此处数值

        _pageSize = parseInt((_h - 31) / 31), //列表高度,不用修改 ;滚动分页=_h + 31;普通分页=_h - 31
        _pageList = [10, 20, 30, _pageSize, 50].sort(function (a, b) {
            return a - b; //对_pageSize排序
        });

    //根据_data是否存在选择表格生成方式
    if (nullToSpace(_data) != '' && _data.length > 0) {
        //本地数据方式
        _url = null;
        _data = _oldData.slice(0, _pageSize); //用于本地数据分页
    } else {
        //ajax请求数据方式
        _data = null;
    }


    //定义一个全局变量:lastIndex
    var lastIndex,extendValue ;
    //初始化配置
    var datagridOptions = {
        url: _url,
        data: _data,
        queryParams: params || {},
        idField: _keyId, // 项目ID
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        onClickCell: function(index,field,value){
            //$(this).datagrid('beginEdit', index);
            //var ed = $(this).datagrid('getEditor', {index:index,field:field});
            if(field == 'ISU_DESC'){
                //用户点击的跟当前行是一行
                if (lastIndex != index) {
                    //否则开始用户点击行编辑,结束上一行编辑
                    $(DSE.form.datagrid).datagrid('endEdit', lastIndex);
                    $(DSE.form.datagrid).datagrid('beginEdit', index);
                }
                lastIndex = index;
            }
        },
        onBeforeEdit:function(index, row){
            extendValue=row.ISU_DESC;
            if(extendValue== null || extendValue == undefined){
                extendValue='';
            }
        },
        onAfterEdit:function(index, row, changes) {
            if(changes.ISU_DESC == undefined){
                changes.ISU_DESC='';
            }
            var oldLen=(row.ISU_DESC).length;
            var newLen=((row.ISU_DESC).trim()).length;
            if(row.ISU_DESC !=extendValue && oldLen == newLen){
                //执行保存方法
                $ajax({
                    url: DSE.serverPath + 'wrmapatrolbCtrl/saveXcsb.do',
                    async: true,
                    data: {
                        ckID: row.ID,
                        issue:row.ISU_DESC,
                        issueID:row.ISSUE_ID,
                        taskID:parent.DSE.app.rowId,
                    },
                    type: 'post',
                    success: function(data) {
                        if(data["data"]) {
                            DSE.form.refreshDatagrid();
                        } else {
                            //操作失败
                            $tips.err('操作失败');
                        }
                    },
                });
            }
        },
        //监听datagrid的点击事件
        onClickRow : function(rowIndex) {
            //用户点击的跟当前行是一行
            if (lastIndex != rowIndex) {
                //否则开始用户点击行编辑,结束上一行编辑
                $(DSE.form.datagrid).datagrid('endEdit', lastIndex);
            }
            lastIndex = rowIndex;
        },
        onSelect:function (index, row) {
            //用户点击的跟当前行是一行
            if (lastIndex != index) {
                //否则开始用户点击行编辑,结束上一行编辑
                $(DSE.form.datagrid).datagrid('endEdit', lastIndex);
            }
            lastIndex = index;
        },
        columns: [
            [{
                field: 'ck',
                checkbox: true
            }, {
                field: 'ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            }, {
                field: 'CK_OBJ_ID',
                title: '巡查点编码',
                width: '0%',
                align: 'center',
                hidden:true,
            },/* {
                field: 'CK_OBJ_ID_NAME',
                title: '巡查点名称',
                width: '10%',
                align: 'center',
                //formatter: function (value, rowData, rowIndex) {
                //    //链接查看详情
                //    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'巡查记录项目信息\',\'detail\',\'./addOrEdit/addOrEdit.html?ID='+rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
                //}
            },*/{
                field: 'CK_CNT_DESC',
                title: '巡查内容描述',
                width: '45%',
                align: 'left',
                formatter:function(value){
                    if(value != null){
                        return "<span title='" + value + "'>" + value + "</span>";
                    }else{
                        return value;
                    }
                }
            }/* , {
                field: 'CK_TAG_DESC',
                title: '巡查标准描述',
                width: '12%',
                align: 'center'
            }*/, {
                field: 'TS',
                title: '创建日期',
                width: '12%',
                align: 'center'
            },/* {
                field: 'SEQ',
                title: '排序号',
                width: '5%',
                align: 'center'
            },{
                field: 'CH_STATUS',
                title: '状态',
                width: '5%',
                align: 'center'
            },*/ {
                field: 'ISU_DESC',
                title: '问题',
                width: '40%',
                align: 'left',
                editor:{
                    type:'textarea',
                },
                formatter:function(value){
                    if(value != null){
                        return "<span title='" + value + "'>" + value + "</span>";
                    }else{
                        return value;
                    }
                }
            }, /*{
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑巡查记录项目信息\',\'edit\',\'./addOrEdit/addOrEdit.html?ck_re_id='+ rowData['CK_RE_ID']+'&ck_obj_id='+ rowData['CK_OBJ_ID']+'\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkredchildCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '</div>';
                    return op;
                }
            }*/
            ]
        ]
    };

    //添加通用 event 事件
    var options = $.extend(DSE.form.singleTableEvents(DSE.form.datagrid, _keyId), datagridOptions);

    //执行渲染
    DSE.form.MyDataGrid = $(DSE.form.datagrid).datagrid(options);

    //本地数据分页
    DSE.form.datagridPager(DSE.form.datagrid, _oldData);

    //本地数据滚动分页
    //   DSE.form.datagridScrollPage(_pageSize, _oldData);

    //ajax请求数据滚动分页
    //  DSE.form.datagridScrollPage(_pageSize, _url, params);

};