/**
 * Created by pc on 2017-8-3.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'MA_CD', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wzxxglCtrl/getListWzCkPcBinInfoByParamsNew.do', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 40, //计算列表的高度,根据页面内容调整此处数值

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
            },{
                field: 'MA_NM',
                title: '物资名称',
                width: '12%',
                align: 'left',
                //formatter: function (value, rowData, rowIndex) {
                //    //return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资基础信息\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                //    var wh_cd=rowData['WH_CD'];
                //    var ma_cd=rowData['MA_CD'];
                //    var ma_pc= rowData['MA_PC'];
                //    if(ma_pc==null){
                //        ma_pc='';
                //    }
                //    var binnum= rowData['BINNUM'];
                //    if(binnum==null){
                //        binnum='';
                //    }
                //    //链接查看详情
                //    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资基础信息\',\'detail\',\'./addOrEdit/addOrEdit.html?wh_cd='+wh_cd+'&ma_cd='+ ma_cd+'&ma_pc='+ ma_pc+'&binnum='+ binnum+'&ma_nm='+rowData['MA_NM']+'&wh_nm='+rowData['WH_NM']+'\')">' + nullToSpace(value) + '</a>';
                //},
            }, {
                field: 'NAME',
                title: '管理部门',
                width: '6%',
                align: 'left'
            }, {
                field: 'WH_NM',
                title: '仓库名称',
                width: '12%',
                align: 'left'
            },  {
                field: 'MODEL',
                title: '规格或型号',
                width: '10%',
                align: 'left'
            }, {
                field: 'MU',
                title: '单位',
                width: '4%',
                align: 'center'
            },/* {
                field: 'MA_PC',
                title: '物资批次',
                width: '10%',
                align: 'left'
            }, */{
                field: 'BINNUM',
                title: '货柜',
                width: '10%',
                align: 'left'
            },/* {
                field: 'SREAL_QUAN',
                title: '库存总量',
                width: '6%',
                align: 'center'
            }, */{
                field: 'REAL_QUAN',
                title: '库存量',
                width: '6%',
                align: 'center'
            }, /*{
                field: 'TS',
                title: '入库时间',
                width: '8%',
                align: 'center'
            },*/{
                field: 'LOC',
                title: '所在地点',
                width: '15%',
                align: 'left',
                /*
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资库存详情\',\'detail\',\'./addOrEdit/addOrEdit.html?id='+rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
                }*/
            }, {
                field: 'STD_YEAR',
                title: '参考储备年限',
                width: '10%',
                align: 'center'
            },/*  {
             field: 'MANUFACTURER',
             title: '生产厂家',
             width: '10%',
             align: 'center'
             },*/ {
                field: 'STD_QUAN',
                title: '仓库存储定额',
                width: '8%',
                align: 'center'
            },{
                field: 'GS_STD_QUAN',
                title: '公司储备定额',
                width: '8%',
                align: 'center',
                //formatter: function (value, rowData, rowIndex) {
                //    //链接查看详情
                //    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资库存详情\',\'detail\',\'./addOrEdit/addOrEdit.html?id='+rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
                //}
            },{
                field: 'SL_STD_QUAN',
                title: '水利部定额',
                width: '10%',
                align: 'center'
            },/* {
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑物资基础信息\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wzxxglCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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