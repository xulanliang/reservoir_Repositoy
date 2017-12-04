/**
 * Created by pc on 2017-7-14.
 */
DSE.form.datagrid = '#datagrid'; //定义选择器
DSE.form.MyDataGrid = null; //定义表格容器
DSE.form.dataRowID = null; //定义ids容器,存储选中的数据ids,用于删除
DSE.form.echarsBean=null;
//初始化表格
DSE.form.initDatagrid = function(params, _data) {

    var _keyId = 'STCD', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + '/shuiweiCtrl/getDateList.do', //数据请求地址

    //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() - 90, //计算列表的高度,根据页面内容调整此处数值

        _pageSize = parseInt((_h - 90) / 31), //列表高度,不用修改
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
        height: _h/2 + 'px',
        pageSize: _pageSize,
        pageList: _pageList,
        pagination: false,
        singleSelect: false,
        remoteSort:false,
        sortName : 'TM',
        sortOrder : 'desc',
        columns: [
            [{
                field: 'ck',
                checkbox: true
            }, {
                field: 'STCD',
                title: '编号',
                width: '0',
                align: 'center',
                hidden: 'true'
            }, {
                field: 'STNM',
                title: '测点',
                width: '35%',
                sortable :true,
                align: 'center'
            }, {
                field: 'TM',
                title: '采集时间',
                width: '30%',
                sortable :true,
                align: 'center'
            }, {
                field: 'Z',
                title: '水位（m）',
                width: '30%',
                sortable :true,
                align: 'center'
            }]
        ],
        onClickRow: function(rowIndex, rowData){
            var rows = $('#datagrid').datagrid('getSelections');
            var stcdids = "";
            for(var i=0;i<rows.length;i++){
                if(i==rows.length-1){
                    stcdids += rows[i].STCD;
                }else{
                    stcdids += rows[i].STCD + ",";
                }
            }
            calcEchars(stcdids);
        }
        ,onLoadSuccess: function(data){
            //$('#datagrid').datagrid('selectRow',0);
            var stcdids = "";
            if(data!=null&& data.rows!=null &&data.rows.length>0 ){
                stcdids=data.rows[0].STCD;
            }
            calcEchars(stcdids);
        }
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
function calcEchars(stcdids){
    var jsonurl=DSE.baseUrl + '/shuiweiCtrl/getGcxDateList.do?stcdids='+stcdids+'&stm='+ DSE.app.minDate
        +'&etm='+DSE.app.maxDate+'&projcd='+DSE.app.projcd+'&keyword='+DSE.app.stcds+'&wrrbm_rbcd='+DSE.app.wrrbm_rbcd;

    //生成当前Chart
    createChart(stcdids,DSE.form.echarsBean,jsonurl,'line',0.3,0.5);

        /*
        console.log(' jsonurl: '+jsonurl);
        $.getJSON(jsonurl,function(resultData) {
            var seriesDatas=[];
            var tempData=[];
            var legend_datas=[];
            DSE.form.echarsBean.xaxis_datas=resultData.RESULT_xAxisDatas;
            DSE.form.echarsBean.legend_datas=resultData.RESULT_legendDatas;

            for(var i=0;i<resultData.RESULT_legendDatas.length;i++){
                var kname=resultData.RESULT_legendDatas[i];
                tempData.push(resultData.RESULT_Datas[kname+""]);
                //console.log(' tempData: '+tempData);
                //stack: '总量', stack: null,
                seriesDatas.push({
                    name:kname,
                    type:'bar',
                    data:resultData.RESULT_Datas[kname+""],
                });
            }
            DSE.form.echarsBean.series_datas=seriesDatas;
            if(tempData){
                var tempDataStr=tempData.join(",").split(",");
                DSE.form.echarsBean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+0.5;
                DSE.form.echarsBean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-0.3;
            }
            var curoption=calcOption(DSE.form.echarsBean) ;
            DSE.form.echarsBean.curecharts.setOption(curoption);
        });
        */

}