//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/sjfx/css/fixSjfx.css');

require_js('xgt_search', 'pages/app/sjfx/szsk/shenya/xgt/js/xgtsearch', ['eform']);
require_js('ecStat', 'assets/chart/echarts/echarts-stat/ecStat.min', ['echarts3']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('xgtmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        xgt_search = require('xgt_search'),
        ecStat = require('ecStat'),
        comm_echarts = require('comm_echarts'),
        date = require('date');

    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function() {
            return {
                url: '', //默认 iframe 不加载 url
                operType: '', //表单状态：add | edit | detail
                rowId: '', //主键 id
                batch: false, //判断显示隐藏
                pickerOptions2: vue_component.pickerOptions2, //使用日期范围组件
                dateVal: '', //日期范围初始化
                minDate:getAddDate(-30,new Date()), //起始日期
                maxDate:getAddDate(0,new Date()), //结束日期
                sw_auto: true, //
                qw_auto: true, //
                jyl_auto: true, //
                jy_auto: true, //
                title: '', //表单页显示的标题
                loading2: true, //loading 状态显示隐藏
                ppcd:'',//一级工程编码
                projcd:'',//工程编码
                wrrbm_rbcd:'',//断面编码
                stcd:'',//
                stnm:'',//
            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                //this.minDate = value.substring(0, 10);
                //this.maxDate = value.substring(value.length - 10, value.length);
                //DSE.form.doSearch();
                //DSE.app.doReset();
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
                this.projcd=$.getParam("projcd");
                this.doReset();
            },
            //日期 change
            changeChkVal: function(vid) {
                $("#ex_"+vid).toggle();
            },
            //关闭
            doCloseWin: function() {
                //状态初始化为空
                this.operType = '';
            },
            //退出批量
            doEscBatch: function() {
                this.batch = false;
                DSE.form.doBatchDatagrid(DSE.form.datagrid, this.batch);
            },
            //查询
            doSearch: function() {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
               // DSE.form.doReset();

                var adcdtree= $('#adcd_auto').combotree('tree');
                if(adcdtree!=null && adcdtree!==undefined){
                    var curnode=adcdtree.tree('getSelected');
                    if(curnode!=null && curnode!==undefined){
                        this.wrrbm_rbcd=curnode.id;
                    }
                }
                this.projcd= $.getParam("projcd");
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getShenYaXgtChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd+'&stcd='+this.stcd;

                $.getJSON(jsonurl,function(resultData){
                    //option1_xAxis=resultData.RESULT_Datas;
                    //option1_series=resultData.RESULT_Datas;

                    /////////////////////////////////  ex5 begin //////////////////////////////

                    //ecStat 是 ECharts 的统计扩展，需要额外添加扩展脚本，参加上方“脚本”
                    // 详情请移步 https://github.com/ecomfe/echarts-stat
                    // 图中的曲线是通过指数回归拟合出的
                    /*
                    var data = [
                        [1, 4862.4],
                        [2, 5294.7],
                        [3, 5934.5],
                        [4, 7171.0],
                        [5, 8964.4],
                        [6, 10202.2],
                        [7, 11962.5],
                        [8, 14928.3],
                        [9, 16909.2],
                        [10, 18547.9],
                        [11, 21617.8],
                        [12, 26638.1],
                        [13, 34634.4],
                        [14, 46759.4],
                        [15, 58478.1],
                        [16, 67884.6],
                        [17, 74462.6],
                        [18, 79395.7]
                    ];*/

                    var echarsbean_sysw=new echarsBean();
                    echarsbean_sysw.ele='ex_0';
                    echarsbean_sysw.title_text='测点['+DSE.app.stnm+']—'+DSE.app.minDate+'—'+ DSE.app.maxDate+' 渗压水位相关图';
                    echarsbean_sysw.data=resultData.RESULT_Datas_sySw;
                    console.log(resultData.RESULT_Datas_sySw);
                    echarsbean_sysw.xaxis_min=20;
                    echarsbean_sysw.xaxis_max=60;
                    echarsbean_sysw.yaxis_min=20;
                    echarsbean_sysw.yaxis_max=60;
                    echarsbean_sysw.pointSize=6;
                    echarsbean_sysw.xaxis_title='水位(m)';
                    echarsbean_sysw.yaxis_name='渗压(m)';
                    echarsbean_sysw.series_name= '测点['+DSE.app.stnm+']水位(m)/渗压(m)';

                    var echarsbean_syyl=new echarsBean();
                    echarsbean_syyl.ele='ex_1';
                    echarsbean_syyl.title_text='测点['+DSE.app.stnm+']—'+DSE.app.minDate+'—'+ DSE.app.maxDate+' 渗压降雨量相关图';
                    echarsbean_syyl.data=resultData.RESULT_Datas_syJy;
                    echarsbean_syyl.xaxis_min=20;
                    echarsbean_syyl.xaxis_max=60;
                    echarsbean_syyl.yaxis_min=20;
                    echarsbean_syyl.yaxis_max=60;
                    echarsbean_syyl.pointSize=6;
                    echarsbean_syyl.xaxis_title='降雨量(mm)';
                    echarsbean_syyl.yaxis_name='渗压(m)';
                    echarsbean_syyl.series_name= '测点['+DSE.app.stnm+']降雨量(mm)/渗压(m)';

                    var echarsbean_syqw=new echarsBean();
                    echarsbean_syqw.ele='ex_2';
                    echarsbean_syqw.title_text='测点['+DSE.app.stnm+']—'+DSE.app.minDate+'—'+ DSE.app.maxDate+' 渗压气温相关图';
                    echarsbean_syqw.data=resultData.RESULT_Datas_syQw;
                    echarsbean_syqw.xaxis_min=20;
                    echarsbean_syqw.xaxis_max=60;
                    echarsbean_syqw.yaxis_min=20;
                    echarsbean_syqw.yaxis_max=60;
                    echarsbean_syqw.pointSize=6;
                    echarsbean_syqw.xaxis_title='气温(℃)';
                    echarsbean_syqw.yaxis_name='渗压(m)';
                    echarsbean_syqw.series_name= '测点['+DSE.app.stnm+']气温(℃)/渗压(m)';


                    if(resultData.RESULT_rsDataVal){
                        var tempDataStr=resultData.RESULT_rsDataVal.join(",").split(",");
                        echarsbean_sysw.xaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean_sysw.xaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    if(resultData.RESULT_yaDataVal){
                        var tempDataStr=resultData.RESULT_yaDataVal.join(",").split(",");
                        echarsbean_sysw.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean_sysw.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));

                        echarsbean_syyl.yaxis_max= echarsbean_sysw.yaxis_max;
                        echarsbean_syyl.yaxis_min=echarsbean_sysw.yaxis_min;

                        echarsbean_syqw.yaxis_max=echarsbean_sysw.yaxis_max;
                        echarsbean_syqw.yaxis_min=echarsbean_sysw.yaxis_min;

                    }

                    if(resultData.RESULT_jyDataVal){
                        var tempDataStr=resultData.RESULT_jyDataVal.join(",").split(",");
                        echarsbean_syyl.xaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean_syyl.xaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }

                    if(resultData.RESULT_qwDataVal){
                        var tempDataStr=resultData.RESULT_qwDataVal.join(",").split(",");
                        echarsbean_syqw.xaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean_syqw.xaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }

                    //创建相关图
                    create_echarts_xgt(ecStat,echarts,echarsbean_sysw,true);

                    //创建相关图
                    create_echarts_xgt(ecStat,echarts,echarsbean_syyl,true);

                    //创建相关图
                    create_echarts_xgt(ecStat,echarts,echarsbean_syqw,true);

                    $("#syCoefficient").text(parseFloat(resultData.swCoefficient || 0).toFixed(2));
                    $("#standardDeviation").text(parseFloat(resultData.swStandard || 0).toFixed(2));

                    $("#jyCoefficient").text(parseFloat(resultData.jyCoefficient || 0).toFixed(2));
                    $("#jyStandardDeviation").text(parseFloat(resultData.jyStandard || 0).toFixed(2));

                    $("#qwCoefficient").text(parseFloat(resultData.qwCoefficient || 0).toFixed(2));
                    $("#qwStandardDeviation").text(parseFloat(resultData.qwStandard || 0).toFixed(2));

                    /*
                    var data= resultData.RESULT_Datas;
                    var xAxis_min=20;
                    var xAxis_max=60;
                    if(resultData.RESULT_rsDataVal){
                        var tempDataStr=resultData.RESULT_rsDataVal.join(",").split(",");
                        console.log(' tempDataStr: '+tempDataStr);
                        xAxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        xAxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    var yAxis_min=20;
                    var yAxis_max=60;
                    if(resultData.RESULT_yaDataVal){
                        var tempDataStr=resultData.RESULT_yaDataVal.join(",").split(",");
                        console.log(' tempDataStr: '+tempDataStr);
                        yAxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        yAxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }

                    var myRegression = ecStat.regression('exponential', data);

                    myRegression.points.sort(function(a, b) {
                        return a[0] - b[0];
                    });
                    var myChart=echarts.init($('#ex_0')[0]);
                    myChart.setOption({
                        title: {
                            text: '测点['+DSE.app.stnm+']—'+DSE.app.minDate+'—'+ DSE.app.maxDate+' 渗压水位相关图',
                            left: 'center',
                            top: 21
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
                            min:xAxis_min,
                            max:xAxis_max,
                            name:'水位(m)',
                        },
                        yAxis: {
                            type: 'value',
                            splitLine: {
                                lineStyle: {
                                    type: 'dashed'
                                }
                            },
                            min:yAxis_min,
                            max:yAxis_max,
                            name:'渗压(mm)',
                        },
                        series: [{
                            name: '测点['+DSE.app.stnm+']渗压(mm)/水位(m)',
                            type: 'scatter',
                            label: {
                                emphasis: {
                                    show: true
                                }
                            },
                            data: data
                        }, {
                            name: 'line',
                            type: 'line',
                            showSymbol: false,
                            smooth: true,
                            data: myRegression.points,

                            //markPoint: {
                            //    itemStyle: {
                            //        normal: {
                            //            color: 'transparent'
                            //        }
                            //    },
                            //    label: {
                            //        normal: {
                            //            show: true,
                            //            position: 'left',
                            //            formatter: myRegression.expression,
                            //            textStyle: {
                            //                color: '#333',
                            //                fontSize: 14
                            //            }
                            //        }
                            //    },
                            //    data: [{
                            //        coord: myRegression.points[myRegression.points.length - 1]
                            //    }]
                            //}

                        }]
                    },true);
                             */



                    /////////////////////////////////  ex5 end //////////////////////////////

                });

            },
            //保存合并的数据图
            doMergeSave:function(){
                var saveAs=saveAs||function(e){"use strict";if(typeof e==="undefined"||typeof navigator!=="undefined"&&/MSIE [1-9]\./.test(navigator.userAgent)){return}var t=e.document,n=function(){return e.URL||e.webkitURL||e},r=t.createElementNS("http://www.w3.org/1999/xhtml","a"),o="download"in r,a=function(e){var t=new MouseEvent("click");e.dispatchEvent(t)},i=/constructor/i.test(e.HTMLElement)||e.safari,f=/CriOS\/[\d]+/.test(navigator.userAgent),u=function(t){(e.setImmediate||e.setTimeout)(function(){throw t},0)},s="application/octet-stream",d=1e3*40,c=function(e){var t=function(){if(typeof e==="string"){n().revokeObjectURL(e)}else{e.remove()}};setTimeout(t,d)},l=function(e,t,n){t=[].concat(t);var r=t.length;while(r--){var o=e["on"+t[r]];if(typeof o==="function"){try{o.call(e,n||e)}catch(a){u(a)}}}},p=function(e){if(/^\s*(?:text\/\S*|application\/xml|\S*\/\S*\+xml)\s*;.*charset\s*=\s*utf-8/i.test(e.type)){return new Blob([String.fromCharCode(65279),e],{type:e.type})}return e},v=function(t,u,d){if(!d){t=p(t)}var v=this,w=t.type,m=w===s,y,h=function(){l(v,"writestart progress write writeend".split(" "))},S=function(){if((f||m&&i)&&e.FileReader){var r=new FileReader;r.onloadend=function(){var t=f?r.result:r.result.replace(/^data:[^;]*;/,"data:attachment/file;");var n=e.open(t,"_blank");if(!n)e.location.href=t;t=undefined;v.readyState=v.DONE;h()};r.readAsDataURL(t);v.readyState=v.INIT;return}if(!y){y=n().createObjectURL(t)}if(m){e.location.href=y}else{var o=e.open(y,"_blank");if(!o){e.location.href=y}}v.readyState=v.DONE;h();c(y)};v.readyState=v.INIT;if(o){y=n().createObjectURL(t);setTimeout(function(){r.href=y;r.download=u;a(r);h();c(y);v.readyState=v.DONE});return}S()},w=v.prototype,m=function(e,t,n){return new v(e,t||e.name||"download",n)};if(typeof navigator!=="undefined"&&navigator.msSaveOrOpenBlob){return function(e,t,n){t=t||e.name||"download";if(!n){e=p(e)}return navigator.msSaveOrOpenBlob(e,t)}}w.abort=function(){};w.readyState=w.INIT=0;w.WRITING=1;w.DONE=2;w.error=w.onwritestart=w.onprogress=w.onwrite=w.onabort=w.onerror=w.onwriteend=null;return m}(typeof self!=="undefined"&&self||typeof window!=="undefined"&&window||this.content);if(typeof module!=="undefined"&&module.exports){module.exports.saveAs=saveAs}else if(typeof define!=="undefined"&&define!==null&&define.amd!==null){define("FileSaver.js",function(){return saveAs})}
                var canvas = $("div[_echarts_instance_]:visible>div>canvas");
                var heightNum=0,widthNum=parseInt(canvas.eq(0).attr("width"));
                //name为页面标题
                var name=$(document).get(0).title;
                for(var i=0;i<canvas.length;i++){
                    heightNum+=parseInt(canvas.eq(i).attr("height"));
                }
                $("body").append('<canvas style="display: none" id="mergeCanvas"></canvas>');
                var mycanvas = $("#mergeCanvas");
                mycanvas.attr({ height:heightNum, width: widthNum });
                var cxt=mycanvas.get(0).getContext("2d");
                cxt.fillStyle="#fff";
                cxt.fillRect(0,0,widthNum,heightNum);
                for(var j=0;j<canvas.length;j++){
                    var Y=0;
                    for(var k=0;k<j;k++){
                        Y+=parseInt(canvas.eq(k).attr("height"));
                    }
                    cxt.drawImage(canvas.eq(j).get(0),0,Y);
                }
                //判断是否为ie浏览器
                if (!!window.ActiveXObject || "ActiveXObject" in window){
                    var blob = mycanvas.get(0).msToBlob();
                    navigator.msSaveBlob(blob, name+".jpeg");
                }else{
                    mycanvas.get(0).toBlob(function(blob) {
                        saveAs(blob, name+".jpeg");
                    });
                }
            }

        }
    }).$mount('#app');


    //初始化查询
    DSE.form.initSearch();

    //DSE.form.doReset();

});
