/**
 * Created by Administrator on 2017/6/9.
 */

function echarsBean(ele,title_text,title_subtext,
                    legend_datas,xaxis_datas,xaxis_title,series_name,series_type,series_datas,
                    yaxis_formatter_value,yaxis_min,yaxis_max,eoption,curecharts,xaxis_min,
                    xaxis_max,yaxis_name,data,grid_top)
{
    this.ele=ele;
    this.title_text=title_text;
    this.title_subtext=title_subtext;

    this.legend_datas=legend_datas;
    this.xaxis_datas=xaxis_datas;
    this.xaxis_title=xaxis_title;
    this.series_name=series_name;

    this.series_datas=series_datas;
    this.series_type=series_type;
    this.yaxis_formatter_value=yaxis_formatter_value;
    this.yaxis_min=yaxis_min;

    this.yaxis_max=yaxis_max;
    this.eoption=eoption;
    this.yaxis_splitNumber=5;
    this.curecharts=curecharts;

    this.xaxis_min=xaxis_min;
    this.xaxis_max=xaxis_max;
    this.yaxis_name=yaxis_name;
    this.data=data;
    this.grid_top = grid_top;


}

/***
 *
 * @param echarts
 * @param echarsBean
 * @returns {*}
 */
function create_echarts_single(echarts,echarsBean,toolBoxHide){
    var option1 = {
        color: ['#3398DB'],
        grid:{
            left:'68',
            right:'40',
            x:25,
            y:45,
            x2:5,
            y2:20,
            borderWidth:1,
        },
        textStyle:{
            fontSize: 12,
        },
        title : {
            text: echarsBean.title_text+'['+echarsBean.title_subtext+']',
            //subtext: echarsBean.title_subtext,
            align: 'right',
            textStyle:{
                fontSize: 12,
            },
            /*
            subtextStyle:{
                fontSize: 8,
            },*/

        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            //padding: 5,                             // 图例内边距，单位px，默认上下左右内边距为5
            //itemGap: 2,
            data:echarsBean.legend_datas
        },
        toolbox: {
            show : true,
            feature : {
                 //mark : {show: true},
                 dataView : {show: true, readOnly: false},
                 //magicType : {show: true, type: ['line', 'bar']},
                 restore : {show: true},
                 saveAsImage : {show: true}
            },
            //padding:5,
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap: true,
                data : echarsBean.xaxis_datas,
                name:echarsBean.xaxis_title,
            }
        ],
        yAxis : [
            {
                type : 'value',
                boundaryGap: [0, 0],
                axisLabel : {
                    formatter: echarsBean.yaxis_formatter_value,
                    lineStyle:{
                        color:"#B03A5B"
                    },
                    textStyle:{
                        fontSize: 8,
                    },

                },
                min:echarsBean.yaxis_min,
                max:echarsBean.yaxis_max,
                splitNumber:echarsBean.yaxis_splitNumber,
                //minInterval: 0.5,
                /*
                 nameTextStyle: {
                 fontSize: 8,
                 },
                 */
            }
        ],
        //series : echarsBean.series_datas,
        // 这个dataZoom组件，默认控制y轴
         /*
        dataZoom: [
            {
                type: 'slider',
                yAxisIndex: 0,
                start: echarsBean.yaxis_min,
                end: echarsBean.yaxis_max
            },
            {
                type: 'inside',
                yAxisIndex: 0,
                start: echarsBean.yaxis_min,
                end: echarsBean.yaxis_max
            }
        ],
        */
        series : [
            {
                name:echarsBean.series_name,
                type:echarsBean.series_type||'line',
                data:echarsBean.series_datas,
                markPoint : {
                    data : [
                        // {type : 'max', name: '最大值'},
                        //{type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        // {type : 'average', name: '平均值'}
                    ]
                }
            },
            /*
             {
             name:'最低气温',
             type:'line',
             data:[1, -2, 2, 5, 3, 2, 0],
             markPoint : {
             data : [
             {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
             ]
             },
             markLine : {
             data : [
             {type : 'average', name : '平均值'}
             ]
             }
             }
             */
        ],
        noDataLoadingOption: {
        text: '暂无数据',
            x: 'center',
            y: 'center',
            textStyle: {
            fontSize: 8,
                fontStyle: 'normal',
                fontWeight: 'normal',
        },
        effect: 'bubble',
            effectOption: null,
            progress: null,
        }
    };
    if(toolBoxHide){
        option1.toolbox.show=false;
    }
    echarsBean.curecharts= echarts.init($('#'+echarsBean.ele)[0]);
    echarsBean.curecharts.setOption(option1,true);
    echarsBean.eoption=option1;

}


/***
 * 创建多条线
 * @param echarts
 * @param echarsBean
 * pages/app/sjfx/szsk/shenya/gcx/js/*main.js
 * @returns {*}
 */
function create_echarts_mul(echarts,echarsBean,toolBoxHide){

    var option5  =calcOption(echarsBean) ;
    if(toolBoxHide){
        option5.toolbox.show=false;
    }
    echarsBean.curecharts= echarts.init($('#'+echarsBean.ele)[0]);
    echarsBean.curecharts.setOption(option5,true);
    echarsBean.eoption=option5;
}

function calcOption (bean){
    return {
        //color: ['#3398DB'],
        grid:{
            left:'68',
            right:'40',
            x:25,
            y:45,
            x2:5,
            y2:20,
            borderWidth:1,
            top:bean.grid_top || '20%'
        },
        textStyle:{
            fontSize: 12,
        },
        title : {
            text: bean.title_text+'['+bean.title_subtext+']',
            //subtext: bean.title_subtext,
            textStyle:{
                fontSize: 12,
            },
            /*
            subtextStyle:{
                fontSize: 8,
            },*/
        },
        tooltip : {
            trigger: 'axis',
            confine:true
        },
        legend: {
            //padding: 1,
            data:bean.legend_datas
        },
        toolbox: {
            show : true,
            feature : {
                //  mark : {show: true},
                 dataView : {
                     show: true,
                     readOnly: true,
                     height : '180px',
                     textAlign: 'center',
                    // backgroundColor: '#E6F6F6',
                     optionToContent: function(opt) {
                         var axisData = opt.xAxis[0].data;
                         var series = opt.series;
                         var firstColName = opt.xAxis[0].name
                         if(series.length <1 ){
                             return '<div style="width:100%; height:100%; text-align: center">暂无数据</div>'
                         }
                         var table = '<div style="width:100%; height:100%; overflow:scroll;"><table style="width:100%; height:100%;text-align:center;"><tbody><tr>'
                             + '<th style="font-size: larger">'+firstColName+'</th>';
                             for(var i = 0 ,len = series.length; i< len; i++){
                                 table += '<th style="font-size: larger">' + series[i].name + '</th>'
                             }

                             + '</tr>';
                         for (var i = 0, l = axisData.length; i < l; i++) {
                             table += '<tr>'
                                 + '<td>' + axisData[i] + '</td>';
                                 for(var j = 0 ,len = series.length; j< len; j++){
                                     table += '<td>' + (series[j].data && series[j].data[i] || '--') + '</td>'
                                 }
                                 + '</tr>';
                         }
                         table += '</tbody></table></div>';
                         return table;
                     }
                 },
                //  magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                  restore : {show: true},
                  saveAsImage : {show: true},

            },
            //padding: 1,
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                //boundaryGap : false,
                boundaryGap: true,
                data : bean.xaxis_datas,
                name:bean.xaxis_title,
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: bean.yaxis_formatter_value,
                    textStyle:{
                        fontSize:8,
                    },
                },
                min:bean.yaxis_min,
                max:bean.yaxis_max,
                //splitLine:{
                //    show:bean.splitLine,
                //}
                // splitNumber:6,

            }
        ],
        //series : bean.series_datas,
        // 这个dataZoom组件，默认控制y轴
        /*
         dataZoom: [
         {
         type: 'slider',
         yAxisIndex: 0,
         start: bean.yaxis_min,
         end: bean.yaxis_max
         },
         {
         type: 'inside',
         yAxisIndex: 0,
         start: bean.yaxis_min,
         end: bean.yaxis_max
         }
         ],
         */
        series : bean.series_datas,
        noDataLoadingOption: {
            text: '暂无数据',
            x: 'center',
            y: 'center',
            textStyle: {
                fontSize: 8,
                fontStyle: 'normal',
                fontWeight: 'normal',
            },
            effect: 'bubble',
            effectOption: null,
            progress: null,
        },
    };
}
/***
 * 清空绘画内容，清空后实例可用
 * @param echarsBean
 */
function clearChart(echarsBean){
    echarsBean.xaxis_datas=[];
    echarsBean.legend_datas=[];
    echarsBean.series_datas=[];
    echarsBean.eoption.series=[];
    echarsBean.eoption.legend.data=[];
    echarsBean.eoption.xAxis.data=[];
    echarsBean.curecharts.setOption(echarsBean.eoption,true);
}

/***
 * 清空绘画内容，清空后实例可用
 * @param stcdids
 * @param echarsBean
 * @param jsonurl
 * @param series_type
 * @param min
 * @param max
 */
function createChart(stcdids,echarsBean,jsonurl,series_type,min,max){

    //console.log(' stcdids.length: '+stcdids.length);
    if(stcdids.length<1){
        clearChart(echarsBean);
    }else{
        console.log(' jsonurl: '+jsonurl);
        $.getJSON(jsonurl,function(resultData) {
            echarsBean.xaxis_datas=resultData.RESULT_xAxisDatas;
            //echarsBean.legend_datas=resultData.RESULT_legendDatas
            if(resultData.RESULT_legendDatas.length > 10){
                echarsBean.legend_datas = adjustLegend(resultData.RESULT_legendDatas);
            }else{
                echarsBean.legend_datas =resultData.RESULT_legendDatas;
            }
            echarsBean.grid_top = setGridTop(resultData.RESULT_legendDatas);
            var seriesDatas=[];
            var tempData=[];
            for(var i=0;i<resultData.RESULT_legendDatas.length;i++){
                var kname=resultData.RESULT_legendDatas[i];
                tempData.push(resultData.RESULT_Datas[kname+""]);
                //console.log(' tempData: '+tempData);
                //stack: '总量', stack: null,
                seriesDatas.push({
                    name:kname,
                    type:series_type,
                    data:resultData.RESULT_Datas[kname+""]
                });
            }
            // console.log(' barGap: barCategoryGap:111 ');
            echarsBean.series_datas=seriesDatas;
            if(tempData){
                var tempDataStr=tempData.join(",").split(",");
                echarsBean.yaxis_max= parseFloat(parseFloat(getMaximin(tempDataStr,"max"))+max).toFixed(2);
                // echarsBean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-min;
                // echarsBean.yaxis_min= Math.floor(parseFloat(getMaximin(tempDataStr,"min"))-min);
                echarsBean.yaxis_min= parseFloat(parseFloat(getMaximin(tempDataStr,"min"))-min).toFixed(2);
            }
            var curoption=calcOption(echarsBean) ;
            echarsBean.curecharts.clear();
            echarsBean.curecharts.setOption(curoption);
        });

    }

}
/***
 * 清空绘画内容，清空后实例可用
 * @param stcdids
 * @param echarsBean
 * @param jsonurl
 * @param series_type
 * @param min
 * @param max
 */
function createChart_QY(stcdids,echarsBean,jsonurl,series_type,min,max){

    //console.log(' stcdids.length: '+stcdids.length);
    if(stcdids.length<1){
        clearChart(echarsBean);
    }else{
        console.log(' jsonurl: '+jsonurl);
        $.getJSON(jsonurl,function(resultData) {
            echarsBean.xaxis_datas=resultData.RESULT_xAxisDatas;
            echarsBean.legend_datas=resultData.RESULT_legendDatas;
            var seriesDatas=[];
            var tempData=[];
            for(var i=0;i<resultData.RESULT_legendDatas.length;i++){
                var kname=resultData.RESULT_legendDatas[i];
                tempData.push(resultData.RESULT_Datas_QY[kname+""]);
                //console.log(' tempData: '+tempData);
                //stack: '总量', stack: null,
                seriesDatas.push({
                    name:kname,
                    type:series_type,
                    data:resultData.RESULT_Datas_QY[kname+""],
                });
            }
            echarsBean.series_datas=seriesDatas;
            if(tempData){
                var tempDataStr=tempData.join(",").split(",");
                echarsBean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+max;
                echarsBean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-min;
            }
            var curoption=calcOption(echarsBean) ;
            echarsBean.curecharts.clear();
            echarsBean.curecharts.setOption(curoption);
        });

    }
}

/***
 * 创建相关图
 * @param ecStat
 * @param echarts
 * @param echarsBean
 */
function create_echarts_xgt(ecStat,echarts,echarsBean,toolBoxHide){

    var myRegression = ecStat.regression('linear', echarsBean.data);

    myRegression.points.sort(function(a, b) {
        return a[0] - b[0];
    });
    var myChart=echarts.init($('#'+echarsBean.ele)[0]);
    var optionObj={
        grid:{
            left:'5%',
            right:'20%',
            x:25,
            y:45,
            x2:5,
            y2:20,
            borderWidth:1,
        },
        textStyle:{
            fontSize: 12,
        },
        symbolSize: echarsBean.pointSize,//拐点大小
        title: {
            text: echarsBean.title_text,
            left: 'center',
            top: 21,
            textStyle:{
                fontSize: 12,
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        toolbox: {
            show : true,
            feature : {
                //mark : {show: true},
                dataView : {show: true, readOnly: false},
                //magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            },
            //padding:5,
        },
        xAxis: {
            type: 'value',
            splitLine: {
                lineStyle: {
                    type: 'dashed'
                }
            },
            splitNumber: 20,
            min:echarsBean.xaxis_min,
            max:echarsBean.xaxis_max,
            name:echarsBean.xaxis_title,
        },
        yAxis: {
            type: 'value',
            splitLine: {
                lineStyle: {
                    type: 'dashed'
                }
            },
            min:echarsBean.yaxis_min,
            max:echarsBean.yaxis_max,
            name:echarsBean.yaxis_name,
        },
        series: [{
            name: echarsBean.series_name,
            type: 'scatter',
            label: {
                emphasis: {
                    show: true
                }
            },
            symbolSize: echarsBean.pointSize,//拐点大小
            data: echarsBean.data,
        }, {
            name: 'line',
            type: 'line',
            showSymbol: false,
            smooth: true,
            data: myRegression.points,

             markPoint: {
             itemStyle: {
             normal: {
             color: 'transparent'
             }
             },
             label: {
             normal: {
             show: true,
             position: 'left',
             formatter: myRegression.expression,
             textStyle: {
             color: '#333',
             fontSize: 14
             }
             }
             },
             data: [{
             coord: myRegression.points[myRegression.points.length - 1]
             }]
             }

        }]
    }
    if(toolBoxHide){
        optionObj.toolbox.show=false;
    }
    //debugger
    var expression = myRegression.expression;
    var expressionArr = expression.match(/-?\d{1,}(\.\d{0,})?/g);   //用正则 取出一次项和常数项
    if(expressionArr && expressionArr.length > 1){
        $("#"+echarsBean.ele+"_linear_term").text(expressionArr[0]);
        $("#"+echarsBean.ele+"_constant_term").text(expressionArr[1]);
    }else{
        $("#"+echarsBean.ele+"_linear_term").text("无数据");
        $("#"+echarsBean.ele+"_constant_term").text("无数据");
    }
    myChart.setOption(optionObj,true);
}

var LINE_NUM_EACH_ROW              = 10;  //图例中每行显示的线条数目；
var DEFAULT_LINE_NUM               = 10;  //采用默认grid.top值的默认线条数目；
var DEFAULT_GRID_TOP_PECENTAGE     = 16; //默认的grid.top百分比（整数部分）；
var DELTA_GRID_TOP_PECENTAGE       = 8;  //超出默认线条数时的grid.top百分比增量（整数部分）；
var MAX_GRID_TOP_PECENTAGE         = 50; //最大的grid.top百分比（整数部分）；

/**
 * 自适应换行
 * @param beforeLegend
 * @param lineNumEachRow
 * @returns {Array}
 */
function adjustLegend (beforeLegend,lineNumEachRow) {
    // 图例太多时，Echarts文档注明【特殊字符串 ''（空字符串）或者 '\n' (换行字符串)用于图例的换行。】
    var afterLegend = new Array();
    var index = 0;
    var len = beforeLegend.length;
    if(typeof lineNumEachRow != undefined && lineNumEachRow != "" && lineNumEachRow != null ) {
          LINE_NUM_EACH_ROW = lineNumEachRow ;
    }
    for ( var i = 0; i < len;  i++) {
        if ((index+1) % (LINE_NUM_EACH_ROW + 1)=== 0) {
            afterLegend[index] = '';
            index++;
            afterLegend[index] = beforeLegend[i];
        } else {
            afterLegend[index] = beforeLegend[i];
        }
        index++;
    }

    return afterLegend;
}

/**
 * 调整上边距
 * @param arrLegend
 * @returns {string}
 */
function setGridTop(arrLegend) {
    var len = arrLegend.length;

    // 如果图例太多，需要调整option中的grid.top值才能避免重叠
    var topInt = len >  DEFAULT_LINE_NUM ?
        DEFAULT_GRID_TOP_PECENTAGE + DELTA_GRID_TOP_PECENTAGE
        * (Math.ceil((len - DEFAULT_LINE_NUM)/LINE_NUM_EACH_ROW))
        : DEFAULT_GRID_TOP_PECENTAGE;
    if (topInt >= MAX_GRID_TOP_PECENTAGE) {
        topInt = MAX_GRID_TOP_PECENTAGE;
    }
    var gridTop = topInt+"%";

    return gridTop;
}