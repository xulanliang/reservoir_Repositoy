//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/singletable/css/style.css');

require_js('sygcx_search', 'pages/app/sjfx/dggc/shenya/sygcx/js/sygcxsearch', ['eform']);
//require_shim('vue', ['gcx_search']);
//require_shim('stylePage', []);

//执行配置
require.config(DSE.requireConfig);
define('sygcxmain', function(require, exports, module) {
    // var _stylePage = require('stylePage');
    var jquery = require('jquery');
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT'),
        echarts = require('echarts3'),
        date97 = require('date97'),
        gcx_search = require('sygcx_search'),
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
                minDate: getAddDate(-7,new Date()), //起始日期
                maxDate: getAddDate(0,new Date()), //结束日期
                wrprojb_proj_cd: '', //
                projcd_auto:'',
                title: '', //表单页显示的标题
                loading2: true //loading 状态显示隐藏
            };
        },
        methods: {
            //日期 change
            changeDateVal: function(value) {
                var vdemo=this;
                vdemo.minDate=$('#stm_auto').val();
                vdemo.maxDate=$('#etm_auto').val();
                vdemo.projcd_auto=$("#projcd_auto").val();
                /*
                var wrprojb_proj_cdData= $('#wrprojb_proj_cd').combobox('getData');
                if(wrprojb_proj_cdData!=null && wrprojb_proj_cdData.length>0){
                   vdemo.wrprojb_proj_cd=wrprojb_proj_cdData[0].PROJ_CD;
                }
                */
                this.doReset();
            },
            //关闭
            doCloseWin: function() {
                //状态初始化为空
                this.operType = '';
            },
            //恢复为默认
            doReset: function() {
                this.dateVal = '';
               // DSE.form.doReset();

                //
                var t = new Date();
                /*
                var wrprojb_proj_cd='';
                var wrprojb_proj_cdData= $('#wrprojb_proj_cd').combobox('getData');
                if(wrprojb_proj_cdData!=null && wrprojb_proj_cdData.length>0){
                    wrprojb_proj_cd=wrprojb_proj_cdData[0].PROJ_CD;
                }
                */
                //'&wrprojb_proj_cd='+wrprojb_proj_cd
                var  projcd= $.getParam("projcd");
                //console.log(' wrprojb_proj_cd:'+wrprojb_proj_cd+' projcd: '+projcd);
                var jsonurl=DSE.baseUrl + '/gcxCtrl/getSyGcxChartData.do?t='+t.getMilliseconds()+'&stm='+ this.minDate+'&etm='+this.maxDate+'&wrprojb_proj_cd='+this.wrprojb_proj_cd+'&projcd='+projcd;
                console.log(' jsonurl: '+jsonurl);
                $.getJSON(jsonurl,function(resultData){
                    // alert(1111+'resultData:'+resultData+'TM'+ resultData.TM+''+ resultData.RZ+' JSON.stringify： '+JSON.stringify(resultData));

                    /////////////////////////////////  ex5 begin //////////////////////////////
                    var xAxisDatas=[];
                    xAxisDatas=resultData.WRHYDOB_xAxisDatas;
                    var legendDatas=[];
                    legendDatas=resultData.WRHYDOB_legendDatas;
                    var seriesDatas=[];
                    for(var i=0;i<resultData.WRHYDOB_legendDatas.length;i++){
                       var kname=resultData.WRHYDOB_legendDatas[i];
                        seriesDatas.push({
                            name:kname,
                            type:'line',
                            stack: '渗压',
                            data:resultData.WRHYDOB_Datas[kname+""],
                        });
                    }
                    var option5  = {
                        //color: ['#3398DB'],
                        grid:{
                            left:'60',
                            right:'60'
                        },
                        title : {
                            text: '渗压过程线',
                            subtext: '渗压(m)'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:legendDatas
                        },
                        toolbox: {
                            show : true,
                            feature : {
                              /*  mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                                restore : {show: true},
                                saveAsImage : {show: true} */
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : xAxisDatas,
                                name:'日期',

                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : seriesDatas
                    };

                   echarts.init($('#ex_0')[0]).setOption(option5);


                    /////////////////////////////////  ex5 end //////////////////////////////


                });

            }
        }
    }).$mount('#app');

    //初始化查询
    DSE.form.initSearch();
    //DSE.form.doReset();

});
