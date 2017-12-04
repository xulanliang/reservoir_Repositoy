/**
 * Created by pc on 2017-8-1.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'CK_OBJ_ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wrchkobjectCtrl/getListInfoByParams.do', //数据请求地址

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
        columns: [getColums()],
        //columns: [
        //    [{
        //        field:'lj',
        //        title:'名称'
        //    }],[{
        //        field:'jjj',
        //        title:'记录'
        //    }]
        //]
    };

    //获取列
    function getColums(){
        var colums =[];
        var colum1 =[{
            field: 'ck',
            checkbox: true
        }, {
            field: 'CK_NAME',
            title: DSE.app.ck_item_name,//'巡查点'
            width: '15%',
            align: 'center',
            formatter: function (value, rowData, rowIndex) {
                //链接查看详情
                return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\''+DSE.app.ck_item_name+'信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html?ck_item='+DSE.app.ck_item+'\')">' + nullToSpace(value) + '</a>';
            }
        }, {
            field: 'CK_ORG_NAME',
            title: '管理部门',
            width: '10%',
            align: 'center'
        }, {
            field: 'CK_TYPE_NAME',
            title: '巡查类型',
            width: '10%',
            align: 'center'
        } ];
        //colums.push(colum1);
        var str ='';
        var colum2 =[];
        if(DSE.app.ck_item==0){
            //对象分类
            str = '对象分类'
            var colum1 =[{
                field: 'ck',
                checkbox: true
            }, {
                field: 'CK_NAME',
                title: DSE.app.ck_item_name,//'巡查点'
                width: '15%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\''+DSE.app.ck_item_name+'信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html?ck_item='+DSE.app.ck_item+'\')">' + nullToSpace(value) + '</a>';
                }
            }, {
                field: 'CK_ORG_NAME',
                title: '管理部门',
                width: '10%',
                align: 'center'
            }, {
                field: 'CK_TYPE_NAME',
                title: '巡查类型',
                width: '10%',
                align: 'center'
            } ,{
                field: 'CK_OBJECT_NAME',
                title: str,
                width: '10%',
                align: 'center'
            },{
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑'+DSE.app.ck_item_name+'信息\',\'edit\',\'./addOrEdit/addOrEdit.html?ck_item='+DSE.app.ck_item+'\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkobjectCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '</div>';
                    return op;
                }
            }]
        }else{
            //巡查对象
            str = '巡查对象';
            var colum1 =[{
                field: 'ck',
                checkbox: true
            }, {
                field: 'CK_NAME',
                title: DSE.app.ck_item_name,//'巡查点'
                width: '15%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\''+DSE.app.ck_item_name+'信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html?ck_item='+DSE.app.ck_item+'\')">' + nullToSpace(value) + '</a>';
                }
            }, {
                field: 'CK_ORG_NAME',
                title: '管理部门',
                width: '10%',
                align: 'center'
            }, {
                field: 'CK_TYPE_NAME',
                title: '巡查类型',
                width: '10%',
                align: 'center'
            } ,{
                field: 'CK_OBJECT_NAME',
                title: str,
                width: '10%',
                align: 'center'
            },{
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑'+DSE.app.ck_item_name+'信息\',\'edit\',\'./addOrEdit/addOrEdit.html?ck_item='+DSE.app.ck_item+'\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkobjectCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '</div>';
                    return op;
                }
            }]
        }
        return colum1;
    }


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