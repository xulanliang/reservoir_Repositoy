/**
 * Created by Administrator on 2016/7/12.
 */
//
//
require(["dojo/dom", "esri/map", "dse_gis/DseGisBase",
    "esri/geometry/Extent", "esri/SpatialReference", "dojo/on",
    "esri/toolbars/navigation",
    "dse_gis/layers/QueryDisplayLayer",
    "dse_gis/utils/dseSymbolUtils",
    "dse_gis/utils/DseGPUtils",
    "esri/dijit/util/busyIndicator",
    "dojo/_base/html",
    "dse_gis/controls/TestControl",
    "dojo/dom-construct",
    "dojo/_base/window",
    "dijit/registry",
    "dse_gis/common/GraphicSyncService",
    //
    "dojo/domReady!"], function (dom, EsriMap, DseGisBase, Extent, SpatialReference, on,
                                 Navigation, QueryDisplayLayer, dseSymbolUtils, DseGPUtils, busyIndicator, html,
                                 TestControl, domConstruct, win, registry, GraphicSyncService) {
    //
    var dseMap = DseGisBase.initMap("map", {
        /**
         * 显示地图切换控件
         * */
        showMapLayerChangeBar: true,
        /**是否显示工具条*/
        showToolbars: true,
        /**是否显示图层管理*/
        showLayerBar: true,
        /**是否显示经纬度*/
        showMapLabel: true,
        /**是否显示搜索框*/
        showSearchBox: true,
        /**是否显示图例*/
        showMapLegend: true,
        showMapRegion: true
    });

    //

    /**
     * 信息查询图层使用方法。
     * */
    var infoLayer = new QueryDisplayLayer({
        //
        method: "GET",
        url: "./data/test.json",
        lonField: "LGTD",//经度字段
        latField: "LTTD",//纬度字段
        mapType: DseGisBase.appConfig.mapType,
        map: dseMap,
        name: "显示图层",
        //
        // template: infoTemplate,
        //需要显示的InfoWindow 内容信息
        template: {
            //
            type: "inner",
            visible: false,
            width: 400,
            height: 320,
            titleField: "STNM",
            url: "./details.html",
            script: "./popup.js"
        },
        //是否显示信息提示框
        tips: {
            visible: true,
            fields: [
                {"测站": "STCD"},
                {"呵呵": "STNM"}
            ]
        },
        /**
         * 回调函数，用于设置点图形的符号信息。
         * */
        symbolCallBack: function (data) {
            //
            var icon = null;
            if (data.STTP === "ZZ") {
                //
                icon = dseSymbolUtils.getMarkImg("QSH", 0);
            } else if (data.STTP === "ZQ") {
                icon = dseSymbolUtils.getMarkImg("QSH", 1);
            } else if (data.STTP === "RR") {
                //
                icon = dseSymbolUtils.getMarkImg("QSH", "-1");
            } else {
                //
                icon = dseSymbolUtils.getMarkImg("QSH", "-2");
            }
            //
            return dseSymbolUtils.PMS(icon.path, icon.width, icon.height);
        }
        // infoTemplate:infoTemplate
    });
    //
    infoLayer.isInLayerCtrl = true;
    infoLayer.legendType = "single";
    infoLayer.name = "信息图层";
    // infoLayer.visible=true;
    dseMap.addLayer(infoLayer);

    var gpUtils = new DseGPUtils({
        //
        urls: DseGisBase.appConfig.gpUrls,
        map: dseMap
    });

    /**
     * 添加组件
     * */
    /* DseGisBase.addMapControl({
     //
     url: "dse_gis/controls/TestControl",
     map: dseMap,
     //位置
     position: {
     right: 100,
     top: 100
     },
     //大小
     /!*size:{
     width:300,
     height:400
     },*!/
     config: DseGisBase.appConfig.baseMapLayers
     // uri:"./data/test.json"
     });*/
    /**
     * 生成等值线
     * */
    on(dom.byId("dzLine"), "click", function (event) {
        //
        gpUtils.createDZXMResults({
            //
            //获取等值线面分析,
            type: "dzx",
            url: "http://localhost:8080/sygqpr/sygq/MapCtrl/gpDzxmfx.ds",
            startTime: "2016-08-03 08:00",
            endTime: "2016-08-03 10:00",
            //清除分析缓存数据
            logUrl: "http://localhost:8080/sygqpr/sygq/MapCtrl/insertDzLogBySql.ds",
        });

    });
    /**
     * 生成等值面工具.
     * */
    on(dom.byId("dzPolygon"), "click", function (event) {
        //
        gpUtils.createDZXMResults({
            //
            //获取等值线面分析,
            type: "dzm",
            //
            isProcess: false,//是否需要生成分析数据。 当取值为false时, url，startTime，endTime 三个参数不需要设置,取值为true时，需要shezhi
            isClear: false,//是否需要清除缓存数据. 当取值为false时, 不需要设置logUrl,当设置为true时需要.
            url: "http://localhost:8080/sygqpr/sygq/MapCtrl/gpDzxmfx.ds",
            startTime: "2016-08-03 08:00",
            endTime: "2016-08-03 10:00",
            //清除分析缓存数据
            logUrl: "http://localhost:8080/sygqpr/sygq/MapCtrl/insertDzLogBySql.ds",
        });
        //
    });
    /**
     * 添加地图组件.
     * */
    on(html.byId("btn-add"), "click", function (event) {
        //
        var testCtrl = dom.byId("testId");
        //
        if (!testCtrl) {
            //
            var testCtrl = new TestControl({
                //
                url: "dse_gis/controls/TestControl",
                map: dseMap,
                id: "testId",
                //位置
                position: {
                    right: 100,
                    top: 100
                },
                //大小
                /*size:{
                 width:300,
                 height:400
                 },*/
                config: DseGisBase.appConfig.baseMapLayers
                // uri:"./data/test.json"
            });
            testCtrl.placeAt(document.body);
            //
        }
    });
    /**
     * 移除地图组件.
     * */
    on(html.byId("btn-del"), "click", function (event) {
        //
        //
        DseGisBase.removeControl("testId");
    });

    //
    var geo = DseGisBase.utils.geo;
    geo.setGeoTemplate({
        //
        type: "inner",
        visible: true,
        width: 400,
        height: 320,
        titleField: "STNM",
        url: "./geoedit.html",
        script: "./geoedit.js",
    });
    //
    geo.setGeoAttribute({
        //
        title: "新绘制",
        STCD: "test",
        STNM: "haoa"
    });
    /**
     * 编辑图形
     * */
    on(dom.byId("btn-edit"), "click", function (event) {
        //
        //
        DseGisBase.utils.geo.changeEditType("edit");
    });
    //
    on(dom.byId("btn-draw"), "click", function (event) {
        //
        DseGisBase.utils.geo.drawGraphic("polygon", true);
    });

    /**
     * 显示编辑后的图形.
     * */
    on(dom.byId("btn-save"), "click", function (event) {
        //
        var gra = DseGisBase.utils.geo.getGraphic();
        //
        var geoJson = JSON.stringify(gra.geometry);
        //
        var attri = JSON.stringify(gra.attributes);
        //
        alert("geometry : " + geoJson + "\n" + "attributes: " + attri);

    });
    /**
     * 切换图层
     * */
        //
    var isDefault = false;
    on(dom.byId("btn-change"), "click", function (event) {
        //
        //
        if (isDefault) {
            //
            isDefault = false;
            DseGisBase.utils.geo.changeEditLayer(DseGisBase.utils.geo.defaultLayer);
        } else {
            //
            DseGisBase.utils.geo.changeEditLayer(infoLayer);
            isDefault = true;
        }

    });
    //
    on(dom.byId("btn-clear"), "click", function (event) {
        //
        DseGisBase.utils.geo.deactivate();
    });
    /**
     * 显示闪烁符号并定位.
     * */
    on(dom.byId("loc"), "click", function (event) {

        DseGisBase.showCenterAt(100.008900, 26.326390);
    });
    /**
     * 查询远程数据，并显示，
     * */
    on(dom.byId("show-data-r"), "click", function (event) {
        //
        //
        infoLayer.bindCallRefReset(infoLayer);
        infoLayer.loadData({
            url: "./data/test.json"
        }, true);
        //
        window.appEvent.dispatchAppEvent(window.appEvent.LAYER_STATE_CHANGE, {
            //
            type: "single",
            layer: infoLayer
        });
    });
    /**
     * 显示已经加载好的数据.
     * */
    on(dom.byId("show-data"), "click", function (event) {
        //
        infoLayer.loadData(data, false);
    });
    /**
     * 将新增的图层添加至图层管理控件。
     * */
    on(dom.byId("add-layer"), "click", function (event) {
        //
        window.appEvent.dispatchAppEvent(window.appEvent.LAYER_INTO_MANAGER, {
            id: "hp1",
            type: "dynamic",
            url: "http://10.100.9.25:6080/arcgis/rest/services/gdmap/MapServer",
            name: "湖泊测试",
            initShow: true,
            group: "临时分组"
        });

    });
    /**===================================================================
     * 实时数据显示.
     * ===================================================================
     * */
    var shiShiLayer = new QueryDisplayLayer({
        //
        // method: "GET",
        // url: "./data/test.json",
        lonField: "LGTD",//经度字段
        latField: "LTTD",//纬度字段
        name: "实时数据图层",
        mapType: DseGisBase.appConfig.mapType,
        map: dseMap,
        // 显示实时数据时需要配置.
        compareField: "NAME",
        //是否显示信息提示框
        tips: {
            // GNID,NAME,PINYIN,GB,CLASS,LGTD,LTTD
            visible: true,
            fields: [
                {"更新时间": "UPDATE"},
                {"名称": "NAME"},
                {"拼音": "PINYIN"},
                {"国标": "GB"},
                {"类别": "TypeClass"}
            ]
        },
        /**
         * 回调函数，用于设置点图形的符号信息。
         * */
        symbolCallBack: function (data) {
            //
            return dseSymbolUtils.createSimpleMakerSymbol({});
        }
        // infoTemplate:infoTemplate
    });
    shiShiLayer.isRealTime = true;
    // shiShiLayer.tipNames = ["大龙林", "小迷田", "冬瓜林", "马草河", "大独田", "马草河新寨"];
    //
    dseMap.addLayer(shiShiLayer);
    //
    var websocket = null;
    //开启同步数据功能
    var socketUrl = "ws://localhost:8080/websocket/testService";
    on(dom.byId("btn-sync"), "click", function (event) {
        //
        websocket = new GraphicSyncService({
            //
            url: socketUrl,
            layer: shiShiLayer
        });
        //
        websocket.startSync();
    });
    //停止同步数据功能
    on(dom.byId("btn-stop"), "click", function (event) {
        //
        websocket.stopSync();
    });
    //
    on(dom.byId("btn-test"), "click", function (event) {
        //
        console.log(JSON.stringify(dseMap.extent));

    });

});


