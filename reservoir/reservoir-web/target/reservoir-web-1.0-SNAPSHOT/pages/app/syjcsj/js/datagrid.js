DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除
//初始化表格
DSE.form.initDatagrid =function initDatagrid(params, _data) {

    var _keyId = 'STCD',//主键ID,根据业务修改,删除也是用的此字段
   　 _tm='TM',
        _url = DSE.serverPath + '/cdgcController/getSyjcList.do', //数据请求地址
    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 60, //计算列表的高度,根据页面内容调整此处数值

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
        idField: _keyId,
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        columns: [
            [{
                field: 'ck',
                checkbox: true
            }, {
                field: 'STCD',
                title: '测点编号',
                width: '8%',
                align: 'center',
            },{
                field: 'STNM',
                title: '测点名称',
                width: '10%',
                align: 'center',
            }, {
                field: 'TM',
                title: '采集时间',
                width: '10%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                    var date = new Date(value);
                    var y = date.getFullYear();
                    var m = date.getMonth() + 1;
                    m = m < 10 ? ('0' + m) : m;
                    var d = date.getDate();
                    d = d < 10 ? ('0' + d) : d;
                    var h = date.getHours();
                    h = h < 10 ? ('0' + h) : h;
                    var minute = date.getMinutes();
                    var second = date.getSeconds();
                    minute = minute < 10 ? ('0' + minute) : minute;
                    second = second < 10 ? ('0' + second) : second;
                    return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
                }
            }, {
                field: 'ORIGDATA',
                title: '监测值',
                width: '8%',
                align: 'center'
            }, /*{
                field: 'CALCDATA',
                title: '校验值',
                width: '8%',
                align: 'center'
            }, {
                field: 'JCL',
                title: '监测量',
                width: '8%',
                align: 'center'
            }, {
                field: 'TRANSST',
                title: '转换状态',
                width: '8%',
                align: 'center'
            }, {
                field: 'OTDESC',
                title: '其他',
                width: '10%',
                align: 'center',
            }, */ {
                field: 'GETTYPE',
                title: '采集方式',
                width: '8%',
                align: 'center',
                formatter:function (value, rowData, rowIndex) {
                   switch (parseInt(value)){
                       case 0 :return  '手动';break;
                       case 1 :return  '自动';break;
                   }
                }
            },  {
                field: 'NT',
                title: '备注',
                width: '8%',
                align: 'center',
            },  {
                field: 'OPER',
                title: '操作',
                width: '8%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] +"tm"+rowData[_tm]+ '\',\'渗压监测数据编辑\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/cdgcController/deleteSyjcByIds.do\', {ids:\'' + rowData[_keyId]+"tm" + rowData[_tm]+'\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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