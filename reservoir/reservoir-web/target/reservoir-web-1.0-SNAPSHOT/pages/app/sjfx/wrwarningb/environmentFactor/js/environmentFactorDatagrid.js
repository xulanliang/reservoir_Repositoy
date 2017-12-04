/**
 * Created by pc on 2017-8-1.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wrwarningbCtrl/getListInfoByParams.do', //数据请求地址

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
                field: 'WA_ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            }, {
                field: 'PROJ_CD_NAME',
                title: '工程名称',
                width: '8%',
                align: 'center'/*,
                formatter:function(value, rowData, rowIndex){
                    var pro = rowData['PROJ_CD'];
                    if("1" == pro){
                        return "深圳水库";
                    }else if("2" == pro) {
                        return "雁田水库";
                    }else if("3" == pro){
                        return "东改工程";
                    }else{
                        return "";
                    }
                 }*/
            }, {
                field: 'MON_TP_NAME',
                title: '监测类型',
                width: '8%',
                align: 'center'/*,
                formatter:function(value, rowData, rowIndex){
                    var mon_tp = rowData['MON_TP'];
                    if("1" == mon_tp){
                        return "渗透压力";
                    }else if("2" == mon_tp){
                        return "渗流量";
                    }else if("3" == mon_tp){
                        return "水平位移";
                    }else if("4" == mon_tp){
                        return "垂直位移";
                    }else if("5" == mon_tp || "6" == mon_tp || "7" == mon_tp){
                        return "环境量";
                    }else{
                        return "";
                    }
                }*/
            }, {
                field: 'STNM',
                title: '测点名称',
                width: '10%',
                align: 'center'/*,
                 formatter: function (value, rowData, rowIndex) {
                 //链接查看详情
                 return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资分类信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                 }*/
            }, {
                field: 'WA_DT',
                title: '发生时间',
                width: '10%',
                align: 'center'
            }, {
                field: 'WA_TP_NAME',
                title: '报警类型',
                width: '10%',
                align: 'center'
            }, {
                field: 'WA_VALUE',
                title: '预警值',
                width: '8%',
                align: 'center'
            }, {
                field: 'REAL_VALUE',
                title: '实际值',
                width: '8%',
                align: 'center'
            }, {
                field: 'DA_VALUE',
                title: '超预警值',
                width: '8%',
                align: 'center'
            }, {
                field: 'WA_STATUS_NAME',
                title: '报警状态',
                width: '5%',
                align: 'center'
            }, {
                field: 'NT',
                title: '处理意见',
                width: '10%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    if(value){
                        return "<span title='" + value + "'>" + value + "</span>";
                    }else{
                        return "";
                    }
                }
            }, {
                field: ' ',
                title: '操作',
                width: '6%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData['WA_ID'] + '\',\'处理\',\'edit\',\'./detail/detail.html\')"><i class="fa fa-edit"></i> 处理</a>';
                    //op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wrwarningbCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
                    op += '</div>';
                    return op;
                }
            }
            ]
        ],
        onDblClickRow:function (rowIndex,rowData) {
            var _wa_id  = rowData.WA_ID;
            if( _wa_id ){

                DSE.form.showEditOrDetail(_wa_id,'报警详情','detail','./detail/detail.html');
                /*layer.open({
                    type: 2,
                    title: '报警详情',                 //弹窗标题
                    shadeClose: true,
                    closeBtn:false,
                    shade: 0.2,
                    maxmin: false,                  //开启最大化最小化按钮
                    area: ['768px', '378px'],
                    btn:['确定','取消'],              //按钮
                    btnAlign:'c',                    //按钮位置
                    content: DSE.baseUrl + "/pages/app/sjfx/wrwarningb/environmentFactor/detail/detail.html?wa_id="+_wa_id,
                    yes:function (index, layero) {              //点击确定按钮
                        var body = layer.getChildFrame('body', index);
                       var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：
                       var wa_id = body.find("input[id='WA_ID_auto']").val();          //得到id
                       var wa_status = body.find("#WA_STATUS_auto").val();              //已读未读
                       var nt = body.find("#NT_auto").val();                            //备注
                       if(wa_id != ""){   //如果当前这条数据是未读状态，关闭的时候置为已读
                           $.ajax({
                               url: DSE.serverPath + '/wrwarningbCtrl/saveOrUpdateInfo.do',
                               data: {
                                   waId: wa_id,
                                   nt : nt
                               },
                               type: 'post',
                               dataType:'json',
                               success: function(data) {
                                   if (data["data"] == '1') {
                                       $('#datagrid').datagrid('reload');      // 置为已读之后更新页面状态
                                   }/!*else{
                                       $tips.err('更新备注失败！');
                                   }*!/
                                   layer.close(index);                          //关闭弹层
                               },
                               error :function (XMLHttpRequest, textStatus, errorThrown) {

                               }
                           });
                       }
                    },

                    cancel:function (index,layero) {
                        return false ;
                    }
                });*/
            }
        }
    };

    //添加通用 event 事件
    var options = $.extend(DSE.form.singleTableEvents(DSE.form.datagrid, _keyId), datagridOptions);

    //执行渲染
    DSE.form.MyDataGrid = $(DSE.form.datagrid).datagrid(options);

    //本地数据分页
    DSE.form.datagridPager(DSE.form.datagrid, _oldData);


};