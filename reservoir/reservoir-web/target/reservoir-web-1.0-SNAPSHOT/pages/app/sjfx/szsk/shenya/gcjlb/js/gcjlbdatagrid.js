/**
 * Created by pc on 2017-6-8.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除

//初始化表格
DSE.form.initDatagrid = function(params, _data) {
    params.st_tp=$.getParam("st_tp");
    var _keyId = 'ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/shenyaCtrl/getGcjlbList.do', //数据请求地址

    //可以删除或注释
    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 90, //计算列表的高度,根据页面内容调整此处数值

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
        url: getUrl(),
        //data: _data,
        queryParams: params || {},
        idField: _keyId, // 项目ID
        height: _h + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        columns: getColumns()
    };

    function getUrl(){
        var type = $('#type').val();
        if(type == 1){
            return _url;
        }else if(type == 2){
            return DSE.serverPath + '/shenyaCtrl/getGcjlbTJList.do';
        }
        return _url;
    }

    function getColumns(){
        var columns = [];
        $.ajax({
            url: DSE.serverPath + '/shenyaCtrl/getPointByRb.do',
            async: false,
            data: {
                rbcd: $('#RB_CD_auto').val(),
                st_tp:$.getParam("st_tp"),
                projcd:$.getParam("projcd"),
            },
            type: 'post',
            success: function(data) {
                var length = data.data.length;
                if(length == 0){
                    columns = [
                        [{
                            field: 'XM',
                            title: '项目',
                            width: '20%',
                            align: 'left'
                        }, {
                            field: 'RZ',
                            title: '水库水位(m)',
                            width: '18%',
                            align: 'center'
                        }, {
                            field: 'DYP',
                            title: '降雨量(mm)',
                            width: '18%',
                            align: 'center'
                        }, {
                            field: 'AIRP',
                            title: '气压(kpa)',
                            width: '18%',
                            align: 'center'
                        }, {
                            field: 'ATMP',
                            title: '气温(℃)',
                            width: '18%',
                            align: 'center'
                        }]
                    ];
                }else if(length > 0){
                    var colData1 = [{
                        field: 'XM',
                        title: '项目',
                        width: '10%',
                        align: 'center',
                        rowspan: 2
                    }, {
                        field: 'RZ',
                        title: '水库水位(m)',
                        width: '10%',
                        align: 'center',
                        rowspan: 2
                    }, {
                        field: 'DYP',
                        title: '降雨量(mm)',
                        width: '10%',
                        align: 'center',
                        rowspan: 2
                    }, {
                        field: 'AIRP',
                        title: '气压(kpa)',
                        width: '10%',
                        align: 'center',
                        rowspan: 2
                    }, {
                        field: 'ATMP',
                        title: '气温(℃)',
                        width: '10%',
                        align: 'center',
                        rowspan: 2
                    },{
                        title:'测点名称（单位：m）',
                        colspan:length
                    }];
                    var colData2 = [];
                    for(var i = 0;i < length;i++){
                        var w;
                        if(40/length > 10){
                            w = 40/length;
                        }else{
                            w = 10;
                        }
                        colData2[i] = {
                            field: data.data[i].STCD,
                            title: data.data[i].STNM,
                            width: w+'%',
                            align: 'center',
                            rowspan: 1,
                            formatter:function(value){
                                var arr = value+'';
                                if(arr.substring(0,1)=='.'){
                                    var datas= '0'+value;
                                    log(datas);
                                    return datas.toFixed(2);
                                }
                             //else if(value != null && value !='') {
                             //       //判断是否为数字
                             //       //if(!isNaN(value.num.value())){
                             //       //    return value.toFixed(2);
                             //       //}
                             //   }
                                else{
                                    return value;
                                }
                            }
                        };
                    }
                    columns = [colData1,colData2];
                }
            }
        });
        return columns;
    }

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