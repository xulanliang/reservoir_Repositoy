/**
 * 水工安全GIS模块入口
 * @author wangsl
 * @date 2017-07-05
 */
require_css('css!pages/app/sgaqgis/index.css');
//执行配置
require.config(DSE.requireConfig);
//
define("sgaqgisindex", function (require, exports, module) {
    "use strict";
    //
    var Web2dGisLoader = require("dsegis/DseGisBase");
    //
    var $ = require("jquery");
     var base = require("base");
     var common = require("common");
    var bootstrap = require("bootstrap");
    //
    var layerWin = require("layer");
    var ztree = require("ztree");
    //
    var Vue = require("vue");
    var ELEMENT = require("ELEMENT");
    //
    var GraphicsLayer = require("esri/layers/GraphicsLayer");
    Vue.use(ELEMENT);
    //
    var DataJSONLayer = require("dsegis/layers/DataJSONLayer");
    //
    var dseSymbolUtils = require("dsegis/utils/dseSymbolUtils");
    var menuID = $.getParam('id');
    //
    //
    $(document).ready(function () {
        if(menuID==''){
            $("#fxwzBtn").css("display","none");
        }
        $("html").on("click","#fxwzBtn",function(){
            $("#item"+menuID,window.parent.document).find("div").trigger("click");
        });


        //
        var h = $(document).height();
        var appEvent = window.appEvent;
        //
        if (appEvent) {
            appEvent.addAppEventListener(appEvent.BASE_MAP_LAYER_LOADED, function (data) {
                //
                var map = data.map;
                //
                //
                var hxData = require("custom/data/skHxData");
                var gcData = require("custom/data/dgGcData");
                var jcSbData = require("custom/data/jcSbData");
                var initJcSbData = require("custom/data/initJcSbData");
                //

                var hxLayer = new DataJSONLayer({
                    id: "hx",
                    map: map,
                    mapType: Web2dGisLoader.appConfig.mapType,
                    symbolCallBack: function (data, type) {

                        return dseSymbolUtils.createSimpleLineSymbol({
                            //
                            width: 4,
                            fillColor: [255, 0, 0, 1],
                            style: "solid"
                        });
                    }
                });
                //
                var dgGcLayer = new DataJSONLayer({
                    id: "dggc",
                    map: map,
                    mapType: Web2dGisLoader.appConfig.mapType,
                    symbolCallBack: function (data, type) {

                        return dseSymbolUtils.createSimpleLineSymbol({
                            //
                            width: 4,
                            fillColor: [0, 112, 255, 1],
                            style: "solid"
                        });
                    }
                });

                var jcsbSimpleMarkSymbol =  dseSymbolUtils.createSimpleMakerSymbol({
                    // fillColor:[238, 69, 0, 0.5],
                    size: 15,
                    borderColor: [221, 221, 221, 1],
                    fillColor: [240, 128, 128, 0.5],
                    width: 2
                });

                // 报警测点
                var simplePictureMarkerSymbol = dseSymbolUtils.createPictureMarkerSymbol({
                    url: DSE.baseUrl + "/assets/gis/arcgis/themes/default/img/droplet.gif",
                    width: 25,
                    height: 25
                });

                var jcSbLayer = new DataJSONLayer({
                    id: "jcsb",
                    map: map,
                    mapType: Web2dGisLoader.appConfig.mapType,
                    //是否显示信息提示框
                    tips: {
                        visible: true,
                        fields: [
                            {"": "NAME"}
                        ]
                    },
                    label: {
                        visible: true,
                        field: "NAME"
                    },
                    template : {
                        title:"报警明细"
                        ,url:DSE.baseUrl + "/pages/app/sgaqgis/warn/warnPage.html?projcd_real="
                        ,type : "warn"
                        ,visible : true
                        ,titleSuffix : "报警明细"
                        ,width : 450
                        ,height : 200
                    },
                    symbolCallBack: function (data, type,index) {

                        // return dseSymbolUtils.createPictureMarkerSymbol({
                        //     url: "./images/legend/zc.png",
                        //     width: 16,
                        //     height: 16
                        // });
                        var _data = eval(data);
                        var _proj_cd = _data.PROJ_CD ;
                        if(_proj_cd){
                            // 先查询该工程下是否有报警的数据，如果有，则闪烁
                            var count = ajaxProjAlarmInfo(_proj_cd);
                            if(count ){
                                var features = jcSbData.features;
                                var len = features.length;
                                for (var i = 0; i < len; i++) {
                                    var attibutes = features[i].attributes;
                                    var PROJ_CD = attibutes.PROJ_CD;
                                    if (_proj_cd == PROJ_CD) {
                                        attibutes.WARN_COUNT = count;       //报警数量
                                    }
                                }
                                return simplePictureMarkerSymbol ;
                            }else{
                                return jcsbSimpleMarkSymbol;
                            }
                        }else {
                            return jcsbSimpleMarkSymbol ;
                        }
                    },
                });


                var initJcsbSimpleMarkSymbol = dseSymbolUtils.createSimpleMakerSymbol({
                    // fillColor:[238, 69, 0, 0.5],
                    size: 15,
                    borderColor: [221, 221, 221, 1],
                    fillColor: [240, 128, 128, 0.5],
                    width: 2
                });
                //
                var initJcSbLayer = new DataJSONLayer({
                    id: "initjcsb",
                    map: map,
                    mapType: Web2dGisLoader.appConfig.mapType,
                    //是否显示信息提示框
                    tips: {
                        visible: true,
                        fields: [
                            {"": "NAME"}
                        ]
                    },
                    label: {
                        visible: true,
                        field: "NAME"
                    },
                    template : {
                        title:"报警明细"
                        ,url:DSE.baseUrl + "/pages/app/sgaqgis/warn/warnPage.html?projcd_real="
                        ,type : "warn"
                        ,visible : true
                        ,titleSuffix : "报警明细"
                        ,width : 450
                        ,height : 200
                    },
                    symbolCallBack: function (data, type) {
                        var _data = eval(data);
                        var _proj_cd = _data.PROJ_CD ;
                        if(_proj_cd){
                            // 先查询该工程下是否有报警的数据，如果有，则闪烁
                            var count = ajaxProjAlarmInfo(_proj_cd);
                            if(count ){
                                var features = initJcSbData.features;
                                var len = features.length;
                                for (var i = 0; i < len; i++) {
                                    var attibutes = features[i].attributes;
                                    var PROJ_CD = attibutes.PROJ_CD;
                                    if (_proj_cd == PROJ_CD) {
                                        attibutes.WARN_COUNT = count;       //报警数量
                                    }
                                }
                                 return simplePictureMarkerSymbol;
                            }else{
                                return initJcsbSimpleMarkSymbol;
                            }
                        }else{
                            return initJcsbSimpleMarkSymbol;
                        }


                    }
                });


                //
                jcSbLayer.hide();
                hxLayer.loadPolylineData(hxData.features);
                dgGcLayer.loadPolylineData(gcData.features);
                jcSbLayer.loadPointData(jcSbData.features);
                //
                initJcSbLayer.loadPointData(initJcSbData.features);
                map.addLayer(hxLayer);
                map.addLayer(dgGcLayer);
                map.addLayer(jcSbLayer);
                //
                map.addLayer(initJcSbLayer);
                //
                map.on("zoom-end", function (event) {
                    //
                    console.log(event.level);
                    if (event.level > 14) {
                        //
                        jcSbLayer.show();
                        initJcSbLayer.hide();
                    } else {
                        jcSbLayer.hide();
                        initJcSbLayer.show();
                    }
                });


            });
        }
        //初始化右侧面板
        var app = new Vue({
                //
                el: "#app",
                data: function () {
                    //
                    return {
                        activeName: 'first'
                    };
                },
                methods: {
                    handleClick: function (tab, event) {
                        //派发页面切换事件，更新相关地图模块
                        appEvent.dispatchAppEvent(appEvent.MODULE_LAYER_CHANGE, {tabName: tab.name});
                        if (tab.name == 'first') {
                            $('#sz').attr('src', "./szsk/szskPage.html");
                        } else if (tab.name == 'second') {
                            $('#yt').attr('src', "./ytsk/ytskPage.html");
                        } else if (tab.name == 'third') {
                            $('#dg').attr('src', "./dggc/dggcPage.html");
                        }
                    }
                }
            });


        var demoCtn = new Vue({
            //el: "#demoCtn",
            data: function () {
                //
                return {
                    proj_cd: '',     //工程编号
                    isWarn: {
                        warn_1 : '',
                        warn_2 : '',
                        warn_3 : '',
                    },
                    rateData:'',
                    lostRateData:'',
                    workingHours:'',
                    show:false,
                };
            },
            methods: {
                mouseOver: function (event,value) {
                    this.closeLayer();      //关闭所有的layer，避免出现多个layer层
                    var proj_cd  = value ,      //工程编号
                        isRed = this.isWarn['warn_' + value] ,
                        _left = $('.class_'+value).offset().left,      //报警点的左边距
                        _top = $('.class_'+value).offset().top;        //报警点的上边距

                    if(proj_cd == '2' || proj_cd == '3'){
                        _left = _left - 200 ;
                    }else{
                        _left = _left - 400 ;       //最右边的点需要往左移更多
                    }
                    _top = _top + 38 ;
                    if(isRed){
                        layerWin.open({
                            type:2,
                            title: false,
                            shadeClose: true,
                            closeBtn: 1, //不显示关闭按钮
                            scrollbar:false ,
                            shade: 0.2,
                            maxmin: false, //开启最大化最小化按钮
                            area: ['400px', '154px'],
                            offset:[_top+'px', _left+'px'],
                            //offset:['10%','30%'],
                            content: DSE.baseUrl + "/pages/app/sgaqgis/warn/warnPage.html?projcd="+proj_cd
                        });
                    }
                },
                mouseOut:function (event,value) {
                   // this.closeLayer();
                },
                closeLayer:function () {
                    layer.closeAll('iframe');
                },
                getAlarmInfo :function () {
                    var _this = this;
                    $.ajax({
                        url: DSE.serverPath + '/shouyeCtrl/getAlarmInfo.do',
                        async: false,
                        data: {
                        },
                        type: 'post',
                        contentType:'application/json;charset=UTF-8',
                        success: function (data) {
                            var _data  = eval(data);
                            if(_data != null){
                                for (var i =0 ; i < _data.length;i++){
                                    var obj = _data[i];
                                    var pid = obj.PID;          //工程编号
                                    var total  = obj.TOTAL ;    // 报警数量
                                    if(total ){
                                        _this.isWarn['warn_' + pid] = 'red';
                                        $(".class_"+pid).attr("src",'images/warn.gif');
                                    }else{
                                        _this.isWarn['warn_' + pid] = '';
                                        $(".class_"+pid).attr("src",'images/normal.png');
                                    }
                                }
                            }
                        }
                    });

                    $.ajax({
                        url: DSE.serverPath + 'shouyeCtrl/getRateData.do',
                        async: false,
                        contentType:'application/json;charset=UTF-8',
                        data: {

                        },
                        type: 'post',
                        success: function (data) {
                            var _data  = eval(data.data);

                            var ds = {} ;   //组装东深工程 数据
                            ds.PID = "0" ;
                            ds.ALL_STAT = 0 ;
                            ds.USEABLE_STAT = 0 ;
                            var arr = _data.rateData;
                            for(var i = 0 ;i < arr.length ;i++ ) {
                                var obj = arr[i]
                                ds.ALL_STAT += obj.ALL_STAT ;
                                ds.USEABLE_STAT += obj.USEABLE_STAT ;
                            }
                            _data.rateData.unshift(ds)
                            _this.rateData = _data.rateData;

                            var dsLost = {} ;   //组装东深工程 数据
                            dsLost.PID = "0" ;
                            dsLost.ALL_DATA = 0 ;
                            dsLost.LOST_DATA = 0 ;
                            var lostRateArr = _data.lostRateData;
                            for(var i = 0 ;i < lostRateArr.length ;i++ ) {
                                var obj = lostRateArr[i]
                                dsLost.ALL_DATA += obj.ALL_DATA ;
                                dsLost.LOST_DATA += obj.LOST_DATA ;
                            }
                            _data.lostRateData.unshift(dsLost);
                            _this.lostRateData = _data.lostRateData;

                            var dsWorkHours = {} ;   //组装东深工程 数据
                            dsWorkHours.PID = "0" ;
                            dsWorkHours.WORK_DAYS = 0 ;
                            dsWorkHours.TIMES = 1 ;
                            var workHoursArr = _data.workingHours;
                            for(var i = 0 ;i < workHoursArr.length ;i++ ) {
                                var obj = workHoursArr[i]
                                dsWorkHours.WORK_DAYS += obj.WORK_DAYS *  obj.TIMES ;
                            }
                            _data.workingHours.unshift(dsWorkHours);
                            _this.workingHours = _data.workingHours;

                            _this.show = true;
                        }
                    });

                    /* $.get( DSE.baseUrl + '/shouyeCtrl/getRateData.do',function (data) {
                       console.info(data);
                       s = data;
                       _this.lists = data.lists;
                   });*/
                }
            },
            created :function () {
                var _this = this;
                _this.getAlarmInfo();
                setInterval(function () {
                    _this.getAlarmInfo();
                },1000*60*5) ;


            }
        }).$mount("#demoCtn");

        /**================================================
         * 切换首页示示意图和地图
         * @date 2017-07-19
         * @author wangsl
         * ================================================
         * */
            //
        var isFirstClick = true;
        var isSyt = true;
        $("#btn-nav-change").click(function () {
            layerWin.closeAll();        //切换的时候关闭弹出的layer层
            if (isSyt) {
                //
                $(this).html("查看工程示意图");
                $("#mapCtn").show();
                $("#demoCtn").hide();
                isSyt = false;
            } else {
                //
                $(this).html("查看工程地图");
                $("#mapCtn").hide();
                $("#demoCtn").show();
                isSyt = true;
            }
            //
            if (isFirstClick) {
                //当地图容器隐藏时，初始化范围会出现不正确
                isFirstClick = false;
                Web2dGisLoader.initMap("map", {
                    /**
                     * 显示地图切换控件
                     * */
                    showMapLayerChangeBar: false,
                    /**是否显示工具条*/
                    showToolbars: true,
                    /**是否显示图层管理*/
                    showLayerBar: false,
                    /**是否显示经纬度*/
                    showMapLabel: {
                        visible: true,
                        style: "m-loc-left"
                    },
                    /**是否显示搜索框*/
                    // showSearchBox: false,
                    /**是否显示图例*/
                    showMapLegend: {
                        visible: false,
                        style: "u-map-legend-left"
                    },
                    showMapRegion: {
                        visible: true,
                        position: {
                            left: 255,
                            top: 16
                        },
                    }
                });
            }
        });
        //
        $("#btn-warn").click(function () {
            layerWin.closeAll();
            layerWin.open({
                type: 2,
                title: '报警信息',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['768px', '458px'],
                content: DSE.baseUrl + "/pages/app/bjxx/bjxxindex.html"
            });
        });
        //
        $('.el-tabs__content').height(h - $('.el-tabs__header').height());
    });

    /**
     * 获取工程报警信息
     * @returns {string}
     */
    function ajaxProjAlarmInfo(proj_cd){
        var count = 0;
        $.ajax({
            url: DSE.serverPath + '/shouyeCtrl/getAlarmCount.do',
            async: false,
            data: {
                proj_cd : proj_cd
            },
            type: 'post',
            //contentType:'application/json;charset=UTF-8',
            dataType:'json',
            success: function (data) {
                var _data  = eval(data.data);
                if(_data && _data[0]){
                    count  = _data[0].TOTAL;
                }
            }
        });

        return count;
    }


    function getInfo(){
        alert(1);
    }

});