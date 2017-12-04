/**
 * Created by pc on 2017-8-1.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除


function doUpdateStautsByIds (id,status) {
    if (nullToSpace(id) == '') {
        $tips.err('请在列表中选择数据进行操作！');
    }else{
        $.ajax({
            url: DSE.serverPath + '/wrchkRecordCtrl/updateStautsByIds.do',
            async: true,
            type: 'post',
            data:{
                ids:id,
                status:status,
            },
            success: function(data) {
                console.log(' resultData: '+displayProp(data));
                $tips.suc('操作成功', function() {
                    // 父窗口调用方法刷新
                    if (DSE.form.refreshDatagrid) {
                        DSE.form.refreshDatagrid();
                    }
                });
            }
        });
    }
}

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'CK_RE_ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wrchkRecordCtrl/getListInfoByParams.do', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 100, //计算列表的高度,根据页面内容调整此处数值

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

    //初始化配置
    var datagridOptions = {
        url: _url,
        data: _data,
        queryParams: params || {},
        idField: _keyId, // 项目ID
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        columns: [
            [{
                field: 'ck',
                checkbox: true
            }, {
                field: 'CK_RE_ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            },{
                field: 'CK_TK_DESC',
                title: '任务描述',
                width: '15%',
                align: 'left',
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'巡查任务信息\',\'detail\',\'./addOrEdit/addOrEdit.html?ck_re_id='+ rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
                }
            }, {
                field: 'CK_ORG_NAME',
                title: '管理部门',
                width: '8%',
                align: 'center'
            }, {
                field: 'CK_TYPE_NAME',
                title: '巡查类型',
                width: '8%',
                align: 'center'
            },{
                field: 'CK_OBJ_ID_NAME',
                title: '巡检对象',
                width: '8%',
                align: 'center'
            },/* {
                field: 'CK_USERS',
                title: '巡查人员',
                width: '10%',
                align: 'center'
            },*/ {
                field: 'CK_BEGIN',
                title: '起始日期',
                width: '13%',
                align: 'center'
            }, {
                field: 'CK_RE_PCOUNT',
                title: '巡查点数',
                width: '8%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                //链接查看详情
                return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'巡查任务信息\',\'detail\',\'../wrchkredchild/wrchkredchildPage.html?ck_re_id='+ rowData[_keyId]+'&ck_obj_id='+ rowData['CK_OBJ_ID']+'\')">' + nullToSpace(value) + '</a>';
                }
            }, {
                field: 'CK_RE_ECOUNT',
                title: '异常点数',
                width: '8%',
                align: 'center'
            }, {
                field: 'STATUS_NAME',
                title: '状态',
                width: '8%',
                align: 'center'
            }, {
                field: ' ',
                title: '操作',
                width: '12%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var statusTitle="";
                    var staVal='0';
                    if(rowData['STATUS']=='0'){
                        statusTitle="开始";
                        staVal='1';
                    }else if(rowData['STATUS']=='1'){
                        statusTitle="完成";
                        staVal='2';
                    }
                    var op = '<div class="operBtns">';
                    if(statusTitle.length>0){
                        op += '<a href="javascript:" class="f-mr10" onclick="doUpdateStautsByIds('+ rowData[_keyId]+',\''+staVal+'\')"><i class="fa fa-edit"></i> '+statusTitle+'</a>';
                    }
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑巡查任务信息\',\'edit\',\'./addOrEdit/addOrEdit.html?ck_re_id='+ rowData[_keyId]+'&ck_obj_id='+ rowData['CK_OBJ_ID']+'\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkRecordCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '</div>';
                    return op;
                }
            }
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