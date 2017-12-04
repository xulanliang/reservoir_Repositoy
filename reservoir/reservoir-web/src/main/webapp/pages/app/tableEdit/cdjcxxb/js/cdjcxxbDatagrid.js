DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid =function initDatagrid(params, _data) {

    var _keyId = 'STCD', //主键ID,根据业务修改,删除也是用的此字段
        tm='TM',
        _url = DSE.serverPath + '/tableEditCtrl/getCdjcxxbListInfoByParams.do', //数据请求地址

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
            }, {
                field: 'STNM',
                title: '测点名称',
                width: '10%',
                align: 'center'
            }, {
                field: 'PROJ_NM',
                title: '工程名称',
                width: '10%',
                align: 'center'
            },{
                field: 'MDNAME',
                title: '模块名称',
                width: '10%',
                align: 'center'
            },{
                field: 'ONMEA',
                title: '测点测量状态',    //0 停测  1 测量 2 待修理 3 报废
                width: '10%',
                align: 'center',
                formatter:function(value,rowData,rowIndex){
                    if(value == 0){
                        return "停测";
                    }else if(value == 1){
                        return "测量";
                    }else if(value == 2){
                        return "待修理";
                    }else if(value == 3){
                        return "报废";
                    }else {
                        return value;
                    }
                }
            },{
                field: 'TYPEID',
                title: '监测方式',    //0 自动 1人工
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    if(value == 0){
                        return "自动";
                    }else if(value == 1){
                        return "人工";
                    }else{
                        return value;
                    }
                }
            },{
                field: 'ISJIDIAN',
                title: '是否基点',    //,1：基点，0：测点，展示数据一般只展示测点数据
                width: '10%',
                align: 'center',
                formatter: function (value,rowData,rowIndex) {
                    if(value == 1){
                        return "基点";
                    }else if(value == 0){

                        return "测点";
                    }else{
                        return value;
                    }
                }
            },/*{
                field: 'LGTD',
                title: '经度',
                width: '10%',
                align: 'center'
            },{
                field: 'LTTD',
                title: '纬度',
                width: '10%',
                align: 'center'
            },{
                field: 'HEAD_GC',
                title: '管口高程',
                width: '10%',
                align: 'center'
            },{
                field: 'BOTTOM_GC',
                title: '管底高程',
                width: '10%',
                align: 'center'
            },{
                field: 'ST_TP',
                title: '测点类型',  //(1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降)
                width: '10%',
                align: 'center'
            },{
                field: 'WEIR_WIDTH',
                title: '堰口宽度',
                width: '10%',
                align: 'center'
            },{
                field: 'WEIR_LENGTH',
                title: '堰口至堰槽底距离',
                width: '10%',
                align: 'center'
            },{
                field: 'WEIR_SIZE',
                title: '堰槽尺寸',
                width: '10%',
                align: 'center'
            },{
                field: 'DISPLACE_TP',
                title: '位移类型',
                width: '10%',
                align: 'center'
            },{
                field: 'INITIAL_VALUE',
                title: '始测读数',
                width: '10%',
                align: 'center'
            },*/{
                field: 'TS',
                title: '时间戳',
                width: '10%',
                align: 'center',
                formatter:function(value,rowData,rowIndex){
                    return getTime(value);
                }
            },{
                field: 'NT',
                title: '备注',
                width: '10%',
                align: 'center'
            },{
                field: 'OPER',
                title: '操作',
                width: '8%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId]+ '\',\'编辑测点基础信息\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'tableEditCtrl/deleteCdjcxxbInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId]+'\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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
var showEditOrDetailExtend = function (id,tm, title, operType, url) {
    if (DSE.app) {
        DSE.pageConfig.rowId = id;
        DSE.pageConfig.operType = operType;


        DSE.app.rowId = id;
        DSE.app.tm = getTime(parseInt(tm));
        DSE.app.operType = operType;
        DSE.app.title = title;
        DSE.app.url = url;
    }

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