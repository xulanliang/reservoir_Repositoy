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
            url: DSE.serverPath + '/wrmaWarningbCtrl/updateStautsByIds.do',
            async: true,
            type: 'post',
            data:{
                ids:id,
                status:status,
            },
            success: function(data) {
               // console.log(' resultData: '+displayProp(data));
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

    var _keyId = 'WA_ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wrmaWarningbCtrl/getListInfoByParams.do', //数据请求地址

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
                field: 'WA_ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            }, {
                field: 'ORG_CD_NAME',
                title: '管理部门',
                width: '8%',
                align: 'center'
            }, {
                field: 'WH_NM',
                title: '所属仓库',
                width: '10%',
                align: 'center'
            }, {
                field: 'MA_NM',
                title: '物资名称',
                width: '18%',
                align: 'center',
                /*
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资分类信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                }*/
            }, {
                field: 'WA_DT',
                title: '发生时间',
                width: '10%',
                align: 'center'
            }, {
                field: 'WA_TP_NAME',
                title: '报警类型',
                width: '10%',
                align: 'center'
            }, {
                field: 'WA_VALUE',
                title: '预警值',
                width: '10%',
                align: 'center'
            }, {
                field: 'REAL_VALUE',
                title: '实际值',
                width: '10%',
                align: 'center'
            }, /*{
                field: 'DA_VALUE',
                title: '超预警值',
                width: '10%',
                align: 'center'
            }, */{
                field: 'WA_STATUS_NAME',
                title: '报警状态',
                width: '10%',
                align: 'center'
            }, {
                field: 'NT',
                title: '备注',
                width: '10%',
                align: 'center'
            }, {
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var statusTitle="";
                    var staVal='0';
                    if(rowData['WA_STATUS']=='0'){
                        statusTitle="已读";
                        staVal='1';
                    }else if(rowData['WA_STATUS']=='1'){
                        statusTitle="已处理";
                        staVal='2';
                    }
                    var op = '<div class="operBtns">';
                    if(statusTitle.length>0){
                        op += '<a href="javascript:" class="f-mr10" onclick="doUpdateStautsByIds('+ rowData[_keyId]+',\''+staVal+'\')"><i class="fa fa-edit"></i> '+statusTitle+'</a>';
                    }
                    //op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑物资分类信息\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wrmaWarningbCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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