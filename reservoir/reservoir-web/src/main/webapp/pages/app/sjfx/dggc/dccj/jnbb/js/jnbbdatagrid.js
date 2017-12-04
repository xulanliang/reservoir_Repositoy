DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/dccjCtrl/getjnbbList.do', //数据请求地址

        //可以删除或注释
        //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 40, //计算列表的高度,根据页面内容调整此处数值

        _pageSize = parseInt((_h - 31) / 31), //列表高度,不用修改
        _pageList = [10, 20, 30, _pageSize, 50].sort(function(a, b) {
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
        //data: _data,
        queryParams: params || {},
        idField: _keyId, // 项目ID
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        columns: [
            [{
                field: 'STNM',
                title: '项目',
                width: '8%',
                align: 'center',
                rowspan:2
            }, {
                field: 'UNIT',
                title: '单位',
                width: '6%',
                align: 'center',
                rowspan:2
            }, {
                title:'本季（年）度监测情况',
                colspan:5
            }, {
                title:'历史监测情况',
                colspan:4
            }, {
                field: 'CKZ',
                title: '参考值',
                width: '6%',
                align: 'center',
                rowspan:2
            }],[{
                field: 'MAXDATA',
                title: '最大值',
                width: '7%',
                align: 'center',
                rowspan:1
            }, {
                field: 'MAXTM',
                title: '相应日期',
                width: '8%',
                align: 'center',
                rowspan:1
            }, {
                field: 'MINDATA',
                title: '最小值',
                width: '7%',
                align: 'center',
                rowspan:1
            }, {
                field: 'MINTM',
                title: '相应日期',
                width: '8%',
                align: 'center',
                rowspan:1
            }, {
                field: 'LASTDATA',
                title: '最后一天测值',
                width: '7%',
                align: 'center',
                rowspan:1
            }, {
                field: 'LSMAXDATA',
                title: '最大值',
                width: '7%',
                align: 'center',
                rowspan:1
            }, {
                field: 'LSMAXTM',
                title: '相应日期',
                width: '8%',
                align: 'center',
                rowspan:1
            }, {
                field: 'LSMINDATA',
                title: '最小值',
                width: '7%',
                align: 'center',
                rowspan:1
            }, {
                field: 'LSMINTM',
                title: '相应日期',
                width: '8%',
                align: 'center',
                rowspan:1
            }]
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
