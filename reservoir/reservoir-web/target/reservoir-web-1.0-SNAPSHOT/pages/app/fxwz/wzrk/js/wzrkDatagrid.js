/**
 * Created by pc on 2017-8-1.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {
    /**
     *  0:出库  1:入库
     * @type {number}
     */
    params.type = 1;
    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wzkzglCtrl/getCrkListInfoByParams.do', //数据请求地址

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
                field: 'NAME',
                title: '管理部门',
                width: '6%',
                align: 'center',
                //formatter: function (value, rowData, rowIndex) {
                //    //链接查看详情
                //    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资分类信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                //}
            }, {
                field: 'WH_NM',
                title: '仓库名称',
                width: '8%',
                align: 'center'
            }, {
                field: 'MA_NM',
                title: '物资名称',
                width: '8%',
                align: 'center'
            }, {
                field: 'MODEL',
                title: '规格或型号',
                width: '8%',
                align: 'center'
            },{
                field: 'MU',
                title: '单位',
                width: '4%',
                align: 'center'
            }, {
                field: 'INOUT_QUAN',
                title: '入库数量',
                width: '8%',
                align: 'center'
            }, {
                field: 'KC',
                title: '当前库存量',
                width: '8%',
                align: 'center'
            }, {
                field: 'INOUT_DATE',
                title: '入库时间',
                width: '14%',
                align: 'center',
                formatter:function(value){
                    var dt = new Date(value);
                    var year = dt.getFullYear();
                    var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
                    var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
                    var hour = dt.getHours() <10 ? '0'+dt.getHours() : dt.getHours();
                    var min = dt.getMinutes() <10 ? '0'+dt.getMinutes() : dt.getMinutes();
                    var second = dt.getSeconds() <10 ? '0'+dt.getSeconds(): dt.getSeconds();
                    return year+'-'+month+'-'+day+' '+ hour +':'+ min +':'+ second;
                }
            }, {
                field: 'INPUT_USER',
                title: '登记人',
                width: '8%',
                align: 'center'
            }/*,{
                field: 'STATUS',
                title: '状态',
                width: '8%',
                align: 'center',
                formatter:function(value){
                    //出入库状态(0:创建，1:审批中，2:待收发料，3:已完成,4:取消)
                    if(value == '0'){
                        return '创建';
                    }else if(value == '1'){
                        return '审批中';
                    }else if(value == '2'){
                        return '代收发材';
                    }else if(value == '3'){
                        return '完成';
                    }else if(value == '4'){
                        return '取消';
                    }else{
                        return value;
                    }
                }
            }*/, {
                field: ' ',
                title: '操作',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'查看物资入库信息\',\'detail\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 查看</a>';
                    /*if(rowData.STATUS != 3){
                        op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑物资入库信息\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                        op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wzkzglCtrl/delCrkInfoByByIds.do\', {status: false,ids:\'' + rowData["WR_INOUT_ID"] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    }else {
                        op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'查看物资入库信息\',\'detail\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 查看</a>';
                    }*/
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