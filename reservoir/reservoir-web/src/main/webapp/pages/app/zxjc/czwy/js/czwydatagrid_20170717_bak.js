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
        _url = DSE.serverPath + '/czwyCtrl/getDateList.do', //数据请求地址

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
        columns: [
            [{
                field: 'ck',
                checkbox: true
            },{
                field: 'STCD',
                title: '编号',
                width: '0',
                align: 'center',
                hidden: 'true'
            }, {
                field: 'STNM',
                title: '测点',
                width: '35%',
                align: 'center'
            }, {
                field: 'TM',
                title: '采集时间',
                width: '30%',
                align: 'center'
            }, {
                field: 'DATA',
                title: '垂直位移（mm）',
                width: '30%',
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
            setEchars(stcdids);
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

function setEchars(stcdids){
    //'&projcd='+projcd
    var jsonurl=DSE.baseUrl + '/czwyCtrl/getGcxDateList.do?stcdids='+stcdids+'&stm='+ DSE.app.minDate
        +'&etm='+DSE.app.maxDate+'&projcd='+DSE.app.projcd+'&keyword='+DSE.app.keyword;
    console.log(' jsonurl: '+jsonurl);


    $.getJSON(jsonurl,function(resultData) {
        console.log(' resultData: '+resultData);
        var seriesDatas=[];
        var tempData=[];
        var legend_datas=[];
        DSE.form.echarsBean.xaxis_datas=[];//resultData.WRHYDOB_xAxisDatas;
        DSE.form.echarsBean.legend_datas=[];//resultData.WRHYDOB_legendDatas;
        DSE.form.echarsBean.series_datas=[];
        DSE.form.echarsBean.xaxis_datas=resultData.RESULT_xAxisDatas;
        DSE.form.echarsBean.legend_datas=resultData.RESULT_legendDatas;
        var seriesDatas=[];
        var tempData=[];

         for(var i=0;i<resultData.RESULT_legendDatas.length;i++){
             var kname=resultData.RESULT_legendDatas[i];
             tempData.push(resultData.RESULT_Datas[kname+""]);
             //console.log(' tempData: '+tempData);
             //stack: '总量', stack: null,
             seriesDatas.push({
                 name:kname,
                 type:'line',
                 data:resultData.RESULT_Datas[kname+""],
             });
         }

         DSE.form.echarsBean.series_datas=seriesDatas;
         if(tempData){
         var tempDataStr=tempData.join(",").split(",");
         //console.log(' tempDataStr: '+tempDataStr);
             DSE.form.echarsBean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
            DSE.form.echarsBean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
         }
        //echarsbean.yaxis_max= parseFloat(echarsbean.yaxis_max);
        //echarsbean.yaxis_min= parseFloat(echarsbean.yaxis_min);
        //console.log(' echarsbean.yaxis_max222: '+echarsbean.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean.yaxis_min);
        // create_echarts_mul(echarts,DSE.form.echarsBean);

        var curoption=calcOption(DSE.form.echarsBean) ;
        DSE.form.echarsBean.curecharts.setOption(curoption);
    });

    /*
    var rows = $('#datagrid').datagrid('getSelections');
    var i=0;
    var k=0;
    var dcolumns=$('#datagrid').datagrid('getColumnFields');
    console.log('dcolumns:'+dcolumns);
    var klength=dcolumns.length;
    if(rows.length>0){
        for(i=0;i<rows.length;i++){
            DSE.form.echarsBean.xaxis_datas.push(rows[i].STNM);
            legend_datas.push(rows[i].TM);
            tempData.push(rows[i].DATA);
            //stack: '总量', stack: null,
            var rowData=[];
            for(k=0;k<klength;k++){
                rowData.push(rows[i].DATA);
            }
            console.log('rowData:'+rowData);
            seriesDatas.push({
                name:rows[i].STNM,
                type:'line',
                data:rowData,
            });
        }


    }else{
        DSE.form.echarsBean.xaxis_datas=[];
        legend_datas=[];
        seriesDatas=[];
    }
    */
    /*
    DSE.form.echarsBean.legend_datas=legend_datas;
    DSE.form.echarsBean.series_datas=seriesDatas;//seriesDatas;
    console.log(' xaxis_datas>>>>'+ DSE.form.echarsBean.xaxis_datas+'legend_datas>>>>'+ DSE.form.echarsBean.legend_datas+ 'series_datas >>>> '+ DSE.form.echarsBean.series_datas);
    */
    /*
     for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
     var kname=resultData.WRHYDOB_legendDatas[i];
     tempData.push(resultData.WRHYDOB_Datas[kname+""]);
     //console.log(' tempData: '+tempData);
     //stack: '总量', stack: null,
     seriesDatas.push({
     name:kname,
     type:'line',
     data:resultData.WRHYDOB_Datas[kname+""],
     });
     }
     */

    /*
    if(tempData){
        var tempDataStr=tempData.join(",").split(",");
        console.log(' tempDataStr: '+tempDataStr);
        DSE.form.echarsBean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
        DSE.form.echarsBean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
    }

    console.log(' echarsbean.yaxis_max222: '+DSE.form.echarsBean.yaxis_max+' echarsbean.yaxis_min222:'+DSE.form.echarsBean.yaxis_min);

    // console.log(' DSE.form.curEcharts:'+DSE.form.echarsBean.curecharts);

    DSE.form.echarsBean.eoption.legend.data=DSE.form.echarsBean.xaxis_datas;
    DSE.form.echarsBean.eoption.xAxis.data=DSE.form.echarsBean.xaxis_datas;
    DSE.form.echarsBean.eoption.series=DSE.form.echarsBean.series_datas;
    DSE.form.echarsBean.eoption.yAxis.min= DSE.form.echarsBean.yaxis_min;
    DSE.form.echarsBean.eoption.yAxis.max= DSE.form.echarsBean.yaxis_max;
    */
    /*
     // 增加些数据------------------
     DSE.form.echarsBean.eoption.legend.data.push('win');
     DSE.form.echarsBean.eoption.series.push({
     name: 'win',                            // 系列名称
     type: 'line',                           // 图表类型，折线图line、散点图scatter、柱状图bar、饼图pie、雷达图radar
     data: [12, 23, 45, 56, 33, 22, 11, 89, 66, 55, 45, 22]
     });
     */
    /*
    DSE.form.echarsBean.curecharts.setOption(DSE.form.echarsBean.eoption);
     */

}