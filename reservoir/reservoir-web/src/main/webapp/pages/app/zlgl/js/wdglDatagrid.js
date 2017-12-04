DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
var _dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

function getDataInfo(url) {
    var $data = [];
    $.ajax({
        url: url,
        async: false,
        contentType:'application/json;charset=UTF-8',
        success: function (data) {
            $data = data;
        }
    });
    return $data;
}

//初始化表格
DSE.form.initDatagrid = function (params, _data) {
    var _keyId = 'DID', //主键ID,根据业务修改,删除也是用的此字段
        _keyIdYa = 'PID', //预案表主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wdglCtrl/getListInfoByParams.do', //数据请求地址
        // _url = '', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 120, //计算列表的高度,根据页面内容调整此处数值

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
    // 1-水库大坝注册，2-建筑物安全鉴定，3-安全评估，4-大事记，5-工程资料，6-防汛管理，7-巡视检查资料

    var type = params["ttype"];
    var data_type;
   switch (type){
       case 'skdb':data_type='注册时间';
           break;
       case 'jzwaq':data_type='鉴定通过时间';
           break;
       case 'aqpg':data_type='评估通过时间';
           break;
       // case 'dsj':data_type='发生时间';
       //     break;
       default   :data_type='发生时间';
           break;
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
                    field: 'INFO_CD',
                    title: '文件编号',
                    width: '8%',
                    align: 'center'
                },{
                    field: 'FILENAME',
                    title: '文件名称',
                    width: '15%',
                    align: 'center',
                    formatter:function(value){
                        return "<span title='" + value + "'>" + value + "</span>";
                    }
                }, {
                field: 'INFO_TITLE',
                title: '文档标题',
                width: '15%',
                align: 'center',
                formatter:function(value){
                    return "<span title='" + value + "'>" + value + "</span>";
                }
            }, {
                field: 'UPDATE_DT',
                title: '上传时间',
                width: '10%',
                align: 'center',
                formatter:function (value,row,index) {
                    if(value !='' && value != null){
                        /**
                         *  格式化时间
                         * @type {Date}
                         */
                        var dt = new Date(value);
                        var year = dt.getFullYear();
                        var month = (dt.getMonth()+1) < 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
                        var day = dt.getDate() < 10 ? '0'+dt.getDate() : dt.getDate();
                        return year + '-' + month + '-' + day;
                    }else {
                        return value;
                    }
                }
            }, {
                field: 'TM',
                title: data_type,
                width: '10%',
                align: 'center',
                formatter:function (value,row,index) {
                    if(value !='' && value != null){
                        /**
                         *  格式化时间
                         * @type {Date}
                         */
                        var dt = new Date(value);
                        var year = dt.getFullYear();
                        var month = (dt.getMonth()+1) < 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
                        var day = dt.getDate() < 10 ? '0'+dt.getDate() : dt.getDate();
                        return year + '-' + month + '-' + day;
                    }else {
                        return value;
                    }
                }
            }, {
                field: 'UPDATE_USER',
                title: '上传人',
                width: '10%',
                align: 'center'
            } ,{
                field: 'FILEID',
                title: '操作',
                width: '18%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    // var filePath = getDataInfo(DSE.serverPath + '/uporDownLoadCtrl/getPdfFilePath.do?pkid=' + rowData["FILEID"])["data"] || '',
                    var filePath = getDataInfo(DSE.serverPath + '/uporDownLoadCtrl/getPdfFilePath.do?pkid=' + value) || '',
                        op = '<div class="operBtns">';
                    if (filePath != '') {
                        var str = filePath.split('\\uploadFiles');
                        filePath = DSE.serverPath + ('/uploadFiles' + str[1]).replace(/\\/g, '/');
                    }
                    // op += '<a href="' + DSE.serverPath + 'assets/print/openPDF.html?url=' + filePath + '" class="link f-mr10" target="_blank"><i class="fa fa-search-plus"></i> 预览</a>';
                    op += '<a href="' + DSE.serverPath + '/uporDownLoadCtrl/download.do?id=' + rowData["FILEID"] + '" class="link f-mr10" target="_blank"><i class="fa fa-download"></i> 下载</a>';
                    // if (divisionCodes.length <= 6){
                    //     op += '<a href="javascript:" onclick="deleteDatagridRow(\'所选数据\', \'wdglCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wdglCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + value + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    // }
                    op += '</div>';
                    return op;
                }
            }
            ]
        ]
    };
        var options = $.extend(DSE.form.singleTableEvents(DSE.form.datagrid, _keyId), datagridOptions);
    //执行渲染
    DSE.form.MyDataGrid = $(DSE.form.datagrid).datagrid(options);
    // }
    //本地数据分页
    //datagridPager(_datagrid, _oldData);

    //本地数据滚动分页
	 //datagridScrollPage(_pageSize, _oldData);

    //ajax请求数据滚动分页
    //datagridScrollPage(_pageSize, _url, params);

};