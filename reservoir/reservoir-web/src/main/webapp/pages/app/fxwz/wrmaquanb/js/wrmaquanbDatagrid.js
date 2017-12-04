/**
 * Created by  on 2017-8-12.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'WH_CD', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wzkzglCtrl/getWzkzylListInfoByParams.do', //数据请求地址

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
            },/* {
                field: 'WH_CD',
                title: '仓库编码',
                width: '12%',
                align: 'center'
            },*/ {
                field: 'WH_NM',
                title: '仓库名称',
                width: '12%',
                align: 'center'
            },/* {
                field: 'MA_CD',
                title: '物资编码',
                width: '12%',
                align: 'center'
            },*/ {
                field: 'MA_NM',
                title: '物资名称',
                width: '12%',
                align: 'center'
            }, {
                field: 'MA_PC',
                title: '物资批次',
                width: '12%',
                align: 'center'
            }, {
                field: 'BINNUM',
                title: '货柜',
                width: '12%',
                align: 'center'
            }, {
                field: 'REAL_QUAN',
                title: '当次数量',
                width: '12%',
                align: 'center'
            }, {
                field: 'TS',
                title: '入库时间',
                width: '12%',
                align: 'center'
            }, {
                field: 'NT',
                title: '备注',
                width: '12%',
                align: 'center'
            }, {
                field: ' ',
                title: '操作',
                width: '12%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    var wh_cd=rowData['WH_CD'];
                    var ma_cd=rowData['MA_CD'];
                    var ma_pc= rowData['MA_PC'];
                    if(ma_pc==null){
                        ma_pc='';
                    }
                    var binnum= rowData['BINNUM'];
                    if(binnum==null){
                        binnum='';
                    }
                    //console.log(' ma_pc2: '+ma_pc+ ' binnum2:'+binnum);
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑库存余量信息\',\'edit\',\'./addOrEdit/addOrEdit.html?wh_cd='+wh_cd+'&ma_cd='+ ma_cd+'&ma_pc='+ ma_pc+'&binnum='+ binnum+'&ma_nm='+rowData['MA_NM']+'&wh_nm='+rowData['WH_NM']+'\')"><i class="fa fa-edit"></i> 编辑</a>';
                    //op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'/wrchkredchildCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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