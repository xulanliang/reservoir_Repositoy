DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid =function initDatagrid(params, _data) {

    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        tm='TM',
        _url = DSE.serverPath + '/tableEditCtrl/getShenyaStatsParamList.do', //数据请求地址

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
                checkbox: true,
                hidden : true
            },
            {
                field: 'STNM',
                title: '测点名称',
                width: '5%',
                align: 'center',
                // formatter: function (value, rowData, rowIndex) {
                //     //链接查看详情
                //     return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'仓库信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                // }
            }/*, {
                field: 'PROJ_NM',
                title: '工程名称',
                width: '5%',
                align: 'center',
            }*/, {
                field: 'B0',
                title: 'B0',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X1',
                title: 'X1',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X2',
                title: 'X2',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X3',
                title: 'X4',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X4',
                title: 'X4',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X5',
                title: 'X5',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X6',
                title: 'X6',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X7',
                title: 'X7',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X8',
                title: 'X8',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X9',
                title: 'X9',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X10',
                title: 'X10',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X11',
                title: 'X11',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X12',
                title: 'X12',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X13',
                title: 'X13',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X14',
                title: 'X14',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X15',
                title: 'X15',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X16',
                title: 'X16',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X17',
                title: 'X17',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'X18',
                title: 'X18',
                width: '4%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value){
                        return parseFloat(value).toFixed(5);
                    }else {
                        return '/';
                    }
                }
            }, {
                field: 'TS',
                title: '时间',
                width: '8%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    if(value != null){
                        return getTime(value);
                    }else{
                        return value;
                    }
                }
            },{
                field: 'OPER',
                title: '操作',
                width: '8%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑渗压统计模型回归系数\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    //op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'tableEditCtrl/deleteProjectBaseInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId]+'\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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


    //ajax请求数据滚动分页
    //  DSE.form.datagridScrollPage(_pageSize, _url, params);

};

var getTime = function (tm) {
    var dt = new Date(tm);
    var year = dt.getFullYear();
    var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
    var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
    var hour = dt.getHours() <10 ? '0'+dt.getHours() : dt.getHours();
    var min = dt.getMinutes() <10 ? '0'+dt.getMinutes() : dt.getMinutes();
    var second = dt.getSeconds() <10 ? '0'+dt.getSeconds(): dt.getSeconds();
    return year+'-'+month+'-'+day+' '+ hour +':'+ min +':'+ second;
};

var getDate = function (tm) {
    var dt = new Date(tm);
    var year = dt.getFullYear();
    var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
    var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
    return year+'-'+month+'-'+day;
};