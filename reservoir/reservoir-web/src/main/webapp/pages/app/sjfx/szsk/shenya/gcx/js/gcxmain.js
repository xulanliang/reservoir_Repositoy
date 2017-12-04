//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');
require_css('css!pages/app/sjfx/css/fixSjfx.css');

require_js('gcx_search', 'pages/app/sjfx/szsk/shenya/gcx/js/gcxsearch', ['eform']);
require_js('comm_echarts', 'pages/app/common/js/comm_echarts', ['echarts3']);
//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('gcxmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        gcx_search = require('gcx_search'),
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
                rb_type:'',//断面类型
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
                /*
                var adcdtree= $('#adcd_auto').combotree('tree');
                if(adcdtree!=null && adcdtree!==undefined){
                    var curnode=adcdtree.tree('getSelected');
                    if(curnode!=null && curnode!==undefined){
                        this.wrrbm_rbcd=curnode.id;
                    }
                }
                */
                this.projcd= $.getParam("projcd");
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getShenYaGcxChartData.do?stm='+ this.minDate+'&etm='+this.maxDate+'&wrrbm_rbcd='+this.wrrbm_rbcd+'&projcd='+this.projcd;
                console.log(' jsonurl:'+jsonurl);
                $.getJSON(jsonurl,function(resultData){
                    //option1_xAxis=resultData.STRSVRR_TM;
                    //option1_series=resultData.STRSVRR_RZ;
                    /////////////////////////////////  ex1 begin //////////////////////////////
                    var echarsbean1=new echarsBean();
                    echarsbean1.ele='ex_sw_auto';
                    echarsbean1.title_text='水位线';
                    echarsbean1.title_subtext='水位(m)';
                    echarsbean1.xaxis_title='日期';
                    echarsbean1.yaxis_formatter_value='{value} m';
                    echarsbean1.xaxis_datas=resultData.STRSVRR_TM;
                    echarsbean1.legend_datas=['水位'];
                    echarsbean1.series_name='水位';
                    echarsbean1.series_type='line';
                    echarsbean1.series_datas=resultData.STRSVRR_RZ;
                    echarsbean1.yaxis_min=20;
                    echarsbean1.yaxis_max=60;
                    //console.log(' resultData.STRSVRR_RZ: '+resultData.STRSVRR_RZ+' echarsbean1.series_datas：'+echarsbean1.series_datas);
                    if(echarsbean1.series_datas){
                        var tempDataStr=echarsbean1.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean1.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        echarsbean1.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-1;
                    }
                    //echarsbean1.yaxis_max= parseFloat(echarsbean1.yaxis_max);
                    //echarsbean1.yaxis_min= parseFloat(echarsbean1.yaxis_min);
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean1.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean1.yaxis_min);
                    var  curecharts1=create_echarts_single(echarts,echarsbean1,true);

                    /////////////////////////////////  ex1 end //////////////////////////////

                    /////////////////////////////////  ex2 begin //////////////////////////////
                    var echarsbean2=new echarsBean();
                    echarsbean2.ele='ex_jyl_auto';
                    echarsbean2.title_text='降雨量';
                    echarsbean2.title_subtext='雨量(mm)';
                    echarsbean2.xaxis_title='日期';
                    echarsbean2.yaxis_formatter_value='{value} mm';
                    echarsbean2.xaxis_datas=resultData.STPPTNR_TM;
                    echarsbean2.legend_datas=['降雨量'];
                    echarsbean2.series_name='降雨量';
                    echarsbean2.series_type='bar';
                    echarsbean2.series_datas=resultData.STPPTNR_DYP;
                    echarsbean2.yaxis_min=0;
                    echarsbean2.yaxis_max=25;
                    //console.log(' resultData.STPPTNR_DYP: '+resultData.STPPTNR_DYP+' echarsbean2.series_datas：'+echarsbean2.series_datas);
                    if(echarsbean2.series_datas){
                        var tempDataStr=echarsbean2.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean2.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"))+1;
                        // echarsbean2.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean2.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean2.yaxis_min);
                    var  curecharts2=create_echarts_single(echarts,echarsbean2,true);

                    /////////////////////////////////  ex2 end //////////////////////////////
                    /*
                    /////////////////////////////////  ex3 begin //////////////////////////////
                    var echarsbean_wd=new echarsBean();
                    echarsbean_wd.ele='ex_qw_auto';
                    echarsbean_wd.title_text='温度线';
                    echarsbean_wd.title_subtext='温度(℃)';
                    echarsbean_wd.xaxis_title='日期';
                    echarsbean_wd.yaxis_formatter_value='{value} ℃';
                    echarsbean_wd.xaxis_datas=resultData.STTMPR_TM;
                    echarsbean_wd.legend_datas=['温度'];
                    echarsbean_wd.series_name='温度';
                    echarsbean_wd.series_type='line';
                    echarsbean_wd.series_datas=resultData.STTMPR_TM_ATMP;
                    echarsbean_wd.yaxis_min=0;
                    echarsbean_wd.yaxis_max=30;
                    //console.log(' resultData.STTMPR_TM_ATMP: '+resultData.STTMPR_TM_ATMP+' echarsbean_wd.series_datas：'+echarsbean_wd.series_datas);
                    if(echarsbean_wd.series_datas){
                        var tempDataStr=echarsbean_wd.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean_wd.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        // echarsbean_wd.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean_wd.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean_wd.yaxis_min);
                    var  curecharts_wd=create_echarts_single(echarts,echarsbean_wd);

                    /////////////////////////////////  ex3 end //////////////////////////////

                    /////////////////////////////////  ex4 begin //////////////////////////////
                    var echarsbean_qy=new echarsBean();
                    echarsbean_qy.ele='ex_jy_auto';
                    echarsbean_qy.title_text='气压线';
                    echarsbean_qy.title_subtext='气压(kPa)';
                    echarsbean_qy.xaxis_title='日期';
                    echarsbean_qy.yaxis_formatter_value='{value} kPa';
                    echarsbean_qy.xaxis_datas=resultData.STTMPR_TM;
                    echarsbean_qy.legend_datas=['气压量'];
                    echarsbean_qy.series_name='气压量';
                    echarsbean_qy.series_type='line';
                    echarsbean_qy.series_datas=resultData.STTMPR_PR_AIRP;
                    echarsbean_qy.yaxis_min=20;
                    echarsbean_qy.yaxis_max=100;
                    //console.log(' resultData.STPPTNR_DYP: '+resultData.STTMPR_PR_AIRP+' echarsbean_qy.series_datas：'+echarsbean_qy.series_datas);
                    if(echarsbean_qy.series_datas){
                        var tempDataStr=echarsbean_qy.series_datas.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean_qy.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean_qy.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    //console.log(' echarsbean_qy.yaxis_max: '+echarsbean_qy.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean_qy.yaxis_min);
                    var  curecharts_qy=create_echarts_single(echarts,echarsbean_qy);

                    /////////////////////////////////  ex4 end //////////////////////////////
                    */
                    /////////////////////////////////  ex5 begin //////////////////////////////

                    var echarsbean=new echarsBean();
                    echarsbean.ele='ex_0';
                    echarsbean.title_text='渗压过程线';
                    echarsbean.title_subtext='渗压(m)';
                    echarsbean.xaxis_title='日期';
                    echarsbean.yaxis_formatter_value='{value} m';
                    echarsbean.xaxis_datas=resultData.WRHYDOB_xAxisDatas;
                    echarsbean.legend_datas=resultData.WRHYDOB_legendDatas;
                    echarsbean.grid_top = '25%';

                    var seriesDatas=[];
                    var tempData=[];
                    for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                        var kname=resultData.WRHYDOB_legendDatas[i];
                        tempData.push(resultData.WRHYDOB_Datas[kname+""]);
                        //console.log(' tempData: '+tempData);
                        //stack: '总量',
                        seriesDatas.push({
                            name:kname,
                            symbolSize: 2,//拐点大小
                            type:'line',
                            data:resultData.WRHYDOB_Datas[kname+""],
                            itemStyle : {
                                normal : {
                                    lineStyle:{
                                        width:1,//折线宽度
                                    }
                                }
                            },
                        });
                    }
                    echarsbean.series_datas=seriesDatas;
                    //echarsbean.splitLine=true;
                    echarsbean.yaxis_min=40.01;
                    echarsbean.yaxis_max=60.01;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr: '+tempDataStr);
                        echarsbean.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"))-0.1;
                    }
                    //echarsbean.yaxis_max= parseFloat(echarsbean.yaxis_max);
                    //echarsbean.yaxis_min= parseFloat(echarsbean.yaxis_min);
                    //console.log(' echarsbean.yaxis_max222: '+echarsbean.yaxis_max+' echarsbean.yaxis_min222:'+echarsbean.yaxis_min);
                    create_echarts_mul(echarts,echarsbean,true);
                    /////////////////////////////////  ex5 end //////////////////////////////


                    /////////////////////////////////  ex6 begin //////////////////////////////
                    /*
                    var echarsbean6=new echarsBean();
                    echarsbean6.ele='ex_6';
                    echarsbean6.title_text='水位降雨渗压过程线';
                    echarsbean6.title_subtext='渗压(m)/雨量(mm)/水位(m)';
                    echarsbean6.xaxis_title='日期';
                    //echarsbean6.yaxis_formatter_value='{value} m';

                    var legend_datas=[];
                    legend_datas.push('水位');
                    legend_datas.push('降雨');

                    var seriesDatas=[];
                    var tempData=[];
                    tempData.push(resultData.RESULT_sySwdataVal);
                    tempData.push(resultData.RESULT_syJydataVal);
                    seriesDatas.push({
                        name:'水位',
                        type:'line',
                        data:resultData.RESULT_sySwdataVal,
                    });
                    seriesDatas.push({
                        name:'降雨',
                        type:'bar',
                        data:resultData.RESULT_syJydataVal,
                    });
                    for(var i=0;i<resultData.RESULT_Map_Key.length;i++){
                        var kname=resultData.RESULT_Map_Key[i];
                        legend_datas.push(kname);
                        tempData.push(resultData.RESULT_Map_sydataVal[kname+""]);
                        //console.log(' tempData: '+tempData);
                        //stack: '总量',
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            data:resultData.RESULT_Map_sydataVal[kname+""],
                        });
                    }
                    //console.log(' legend_datas:'+legend_datas);
                    echarsbean6.xaxis_datas=resultData.RESULT_tmKeys;
                    echarsbean6.legend_datas=legend_datas;
                    echarsbean6.series_datas=seriesDatas;
                    //console.log(' seriesDatas:'+seriesDatas);
                    echarsbean6.yaxis_min=0;
                    echarsbean6.yaxis_max=100;
                    if(tempData){
                        var tempDataStr=tempData.join(",").split(",");
                        //console.log(' tempDataStr:'+tempDataStr);
                        echarsbean6.yaxis_max= parseFloat(getMaximin(tempDataStr,"max"));
                        echarsbean6.yaxis_min= parseFloat(getMaximin(tempDataStr,"min"));
                    }
                    //console.log(' echarsbean6:'+displayProp(echarsbean6));
                    create_echarts_mul(echarts,echarsbean6);
                    /////////////////////////////////  ex6 begin //////////////////////////////
                    */
                });

            },
            //保存合并的数据图
            doMergeSave:function(){
                var saveAs=saveAs||function(e){"use strict";if(typeof e==="undefined"||typeof navigator!=="undefined"&&/MSIE [1-9]\./.test(navigator.userAgent)){return}var t=e.document,n=function(){return e.URL||e.webkitURL||e},r=t.createElementNS("http://www.w3.org/1999/xhtml","a"),o="download"in r,a=function(e){var t=new MouseEvent("click");e.dispatchEvent(t)},i=/constructor/i.test(e.HTMLElement)||e.safari,f=/CriOS\/[\d]+/.test(navigator.userAgent),u=function(t){(e.setImmediate||e.setTimeout)(function(){throw t},0)},s="application/octet-stream",d=1e3*40,c=function(e){var t=function(){if(typeof e==="string"){n().revokeObjectURL(e)}else{e.remove()}};setTimeout(t,d)},l=function(e,t,n){t=[].concat(t);var r=t.length;while(r--){var o=e["on"+t[r]];if(typeof o==="function"){try{o.call(e,n||e)}catch(a){u(a)}}}},p=function(e){if(/^\s*(?:text\/\S*|application\/xml|\S*\/\S*\+xml)\s*;.*charset\s*=\s*utf-8/i.test(e.type)){return new Blob([String.fromCharCode(65279),e],{type:e.type})}return e},v=function(t,u,d){if(!d){t=p(t)}var v=this,w=t.type,m=w===s,y,h=function(){l(v,"writestart progress write writeend".split(" "))},S=function(){if((f||m&&i)&&e.FileReader){var r=new FileReader;r.onloadend=function(){var t=f?r.result:r.result.replace(/^data:[^;]*;/,"data:attachment/file;");var n=e.open(t,"_blank");if(!n)e.location.href=t;t=undefined;v.readyState=v.DONE;h()};r.readAsDataURL(t);v.readyState=v.INIT;return}if(!y){y=n().createObjectURL(t)}if(m){e.location.href=y}else{var o=e.open(y,"_blank");if(!o){e.location.href=y}}v.readyState=v.DONE;h();c(y)};v.readyState=v.INIT;if(o){y=n().createObjectURL(t);setTimeout(function(){r.href=y;r.download=u;a(r);h();c(y);v.readyState=v.DONE});return}S()},w=v.prototype,m=function(e,t,n){return new v(e,t||e.name||"download",n)};if(typeof navigator!=="undefined"&&navigator.msSaveOrOpenBlob){return function(e,t,n){t=t||e.name||"download";if(!n){e=p(e)}return navigator.msSaveOrOpenBlob(e,t)}}w.abort=function(){};w.readyState=w.INIT=0;w.WRITING=1;w.DONE=2;w.error=w.onwritestart=w.onprogress=w.onwrite=w.onabort=w.onerror=w.onwriteend=null;return m}(typeof self!=="undefined"&&self||typeof window!=="undefined"&&window||this.content);if(typeof module!=="undefined"&&module.exports){module.exports.saveAs=saveAs}else if(typeof define!=="undefined"&&define!==null&&define.amd!==null){define("FileSaver.js",function(){return saveAs})}
                var canvas = $("div[_echarts_instance_]:visible>div>canvas");
                console.log(canvas)
                var heightNum=0,widthNum=parseInt(canvas.eq(0).attr("width"));
                //name为页面标题
                var name=$(document).get(0).title;
                for(var i=0;i<canvas.length;i++){
                    heightNum+=parseInt(canvas.eq(i).attr("height"));
                }
                $("body").append('<canvas style="display: none" class="mergeCanvas"></canvas>');
                var mycanvas = $(".mergeCanvas");
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
