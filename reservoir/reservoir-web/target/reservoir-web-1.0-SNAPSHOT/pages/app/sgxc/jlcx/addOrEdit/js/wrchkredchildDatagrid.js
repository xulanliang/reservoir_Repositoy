/**
 * Created by  on 2017-8-12.
 */
DSE.form.datagrid = '#datagrid_wrchkredchild'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

function doUpdateStautsByIds (id,status) {
    console.log('id： '+id);
    if (nullToSpace(id) == '') {
        $tips.err('请在列表中选择数据进行操作！');
    }else{
        $.ajax({
            url: DSE.serverPath + '/wrchkredchildCtrl/updateStautsByIds.do',
            async: true,
            type: 'post',
            data:{
                ids:id,
                ch_status:status,
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

    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wrchkredchildCtrl/getListInfoByParamsList.do', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 100, //计算列表的高度,根据页面内容调整此处数值

        _pageSize = 1000;//parseInt((_h - 31) / 31), //列表高度,不用修改 ;滚动分页=_h + 31;普通分页=_h - 31
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
    console.log(' _data:'+_data);
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
                field: 'ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            }, {
                field: 'CK_OBJ_ID',
                title: '巡查点编码',
                width: '10%',
                align: 'center',
                hidden:true,
            }, {
                field: 'CK_OBJ_ID_NAME',
                title: '巡查点名称',
                width: '10%',
                align: 'center'
            },{
                field: 'CK_CNT_DESC',
                title: '巡查内容描述',
                width: '30%',
                align: 'left',
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'巡查任务信息\',\'detail\',\'./addOrEdit/addOrEdit.html?ID='+rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
                }
            } /*, {
                field: 'CK_TAG_DESC',
                title: '巡查标准描述',
                width: '12%',
                align: 'center'
            }*/, {
                field: 'SEQ',
                title: '排序号',
                width: '6%',
                align: 'center'
            }, {
                field: 'CH_STATUS_NAME',
                title: '状态',
                width: '8%',
                align: 'center'
            }, {
                field: 'TS',
                title: '创建日期',
                width: '12%',
                align: 'center'
            }, {
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var statusTitle="";
                    var staVal='0';
                    if(rowData['CH_STATUS']=='0'){
                        statusTitle="开始";
                        staVal='1';
                    }else if(rowData['CH_STATUS']=='1'){
                        statusTitle="完成";
                        staVal='2';
                    }
                    var op = '<div class="operBtns">';
                    if(statusTitle.length>0){
                        op += '<a href="javascript:" class="f-mr10" onclick="doUpdateStautsByIds('+ rowData[_keyId]+',\''+staVal+'\')"><i class="fa fa-edit"></i> '+statusTitle+'</a>';
                    }
                    //op += '<a href="javascript:" class="f-mr10" onclick="app.doUpdateStautsByIds('+ rowData[_keyId]+',\'2\')"><i class="fa fa-edit"></i> 完成</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkredchildCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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