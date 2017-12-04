/**
 * Created by pc on 2017-8-1.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/wralarmparammCtrl/getListInfoByParams.do', //数据请求地址

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
//定义一个全局变量:lastIndex
    var lastIndex,extendValue ;
    var map ={};
    //初始化配置
    var datagridOptions = {
        url: _url,
        data: _data,
        queryParams: params || {},
        idField: _keyId, // 项目ID
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        /*onClickCell: function(index,field,value){
           // debugger;
            if(field == 'OBS_VALUE'){
                //用户点击的跟当前行是一行
                if (lastIndex != index) {
                    //否则开始用户点击行编辑,结束上一行编辑
                    //$(DSE.form.datagrid).datagrid('endEdit', lastIndex);
                    $(DSE.form.datagrid).datagrid('beginEdit', index);
                }
                lastIndex = index;
            }
        },*/
        onBeforeEdit:function(index, row){
            map['"'+index+'"'] = row.OBS_VALUE;
        },
        onAfterEdit:function(index, row, changes) {
            if(changes.OBS_VALUE == undefined){
                changes.OBS_VALUE='';
            }
            var oldLen=(changes.OBS_VALUE).length;
            var newLen=((changes.OBS_VALUE).trim()).length;
            if(changes.OBS_VALUE != map['"'+index+'"'] && oldLen == newLen){
                //执行保存方法
                $ajax({
                    url: DSE.serverPath + 'wralarmparammCtrl/saveOrUpdateInfo.do',
                    async: true,
                    data: {
                        'dataStr': JSON.stringify(row)
                    },
                    type: 'post',
                    dataType:'json',
                    success: function(data) {
                        /*if(data["data"]) {
                            $tips.suc('操作成功',function() {
                                DSE.app.doEscBatchEdit();
                                DSE.form.refreshDatagrid();
                            });
                        } else {
                            //操作失败
                            $tips.err('操作失败');
                        }*/
                    },
                });
            }
        },
        //监听datagrid的点击事件
       /*onClickRow : function(rowIndex) {
            //用户点击的跟当前行是一行
            if (lastIndex != rowIndex) {
                //否则开始用户点击行编辑,结束上一行编辑
                $(DSE.form.datagrid).datagrid('endEdit', lastIndex);
            }
            lastIndex = rowIndex;
        },*/
        columns: [
            [{
                field: 'ck',
                checkbox: true
            }, {
                field: 'ID',
                title: '编码',
                width: '0%',
                align: 'center',
                hidden:true,
            }, {
                field: 'PROJ_CD_NAME',
                title: '工程名称',
                width: '15%',
                align: 'center'
            }, {
                field: 'MON_TP_NAME',
                title: '监测类型',
                width: '10%',
                align: 'center'
            }, {
                field: 'STNM',
                title: '测点名称',
                width: '10%',
                align: 'center'/*,
                formatter: function (value, rowData, rowIndex) {
                    //链接查看详情
                    return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'物资分类信息详情\',\'detail\',\'./addOrEdit/addOrEdit.html\')">' + nullToSpace(value) + '</a>';
                }*/
            },  {
                field: 'OBS_VALUE',
                title: '绝对值',
                width: '10%',
                align: 'center',
                editor:{
                    type:'numberbox',
                    options:{
                        precision:2,
                        min:0
                    }
                },
                /*,
                formatter :function(value, rowData, rowIndex){
                    var html = '<input name="obs_value_auto"  id="obs_value_auto" class="grid-edit-input" value="'+rowData['OBS_VALUE']+'" readonly>';
                    return html;
                }*/
            },{
                field: 'MAX_VALUE',
                title: '历史最大值',
                width: '10%',
                align: 'center'
            }, {
                field: 'CG_VALUE',
                title: '变幅',
                width: '10%',
                align: 'center'
            }/*, {
                field: 'NT',
                title: '备注',
                width: '10%',
                align: 'center'
            },, {
                field: ' ',
                title: '操作',
                width: '20%',
                align: 'center',
                formatter: function (value, rowData, rowIndex) {
                    var op = '<div class="operBtns">';
                    op += '<a href="javascript:" class="f-mr10" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'编辑物资分类信息\',\'edit\',\'./addOrEdit/addOrEdit.html\')"><i class="fa fa-edit"></i> 编辑</a>';
                    op += '<a href="javascript:" onclick="DSE.form.deleteDatagridRow(\'所选数据\', \'wralarmparammCtrl/deleteInfoByIds.do\', {status: false,ids:\'' + rowData[_keyId] + '\'})"><i class="fa fa-trash-o"></i> 删除</a>';
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