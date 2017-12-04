/**
 * Created by Administrator on 2016/7/26.
 */
define(function () {

    var local = window.location, contextPath = local.pathname.split("/")[1],
        basePath = local.protocol + "//" + local.host + "/" + contextPath;

    //
    var mo = (function () {
        //
        return {
            //初始化范围,注意：在有些项目中可能会出现不同权限需要显示不同的地图范围，在程序中直接动态设置该值即可
            fullExtent: [97.65, 23.97, 104.83, 24.81],
            //投影参数：1：经度坐标系；2：平面坐标系，3：百度坐标系
            mapType: "2",
            //
            minZoom: 2,
            maxZoom: 16,
            zoom: 6,
            minVisibleZoom: 7,
            urlPrefixs: [],//代理服务器 地址前缀 如果不需要代理，数组置空
            proxyUrl: basePath + "/proxy.jsp", //代理地址
            /**
             *
             * 底图配置信息.
             *
             */
            baseMapLayers: [
                /**
                 * @item Item {Object}
                 *
                 * type: google || arcgis||tdt||baidu||local
                 * url: img||vec||ter, 注意，type="baidu"时，url只能取值 img,vec, type=arcgis 或者 local 时，url取实际服务地址,
                 * type="local"时，用于加载离线瓦片地图.
                 * */
                /**
                 * =================================================================
                 * 加载百度底图配置.demo
                 * =================================================================
                 * */
                /*{

                 id: "bimg", // 图层ID
                 type: "baidu", //图层类型
                 url: "img",// google url有效值为 vec,img,ter中的一个 //服务地址
                 img_src: styleName + "/img/maptype/maptype1.png", //底图切换图标
                 name: "影像图", //地图切换标记名称
                 initShow: false //地图是否可见.
                 },
                 {
                 id: "bvec",
                 type: "baidu",
                 url: "vec",
                 img_src: styleName + "/img/maptype/maptype2.png",
                 name: "矢量图",
                 initShow: true
                 },*/

                /**
                 * =================================================================
                 * 加载Google底图配置.demo
                 * =================================================================
                 * */
                /*{

                 id: "gvec",
                 type: "google",
                 url: "vec",// google url有效值为 vec,img,ter中的一个
                 img_src: styleName + "/img/maptype/maptype1.png",
                 name: "矢量图",
                 initShow: true
                 },
                 {

                 id: "gimg",
                 type: "google",
                 url: "img",// google url有效值为 vec,img,ter中的一个
                 img_src: styleName + "/img/maptype/maptype1.png",
                 name: "影像图",
                 initShow: false
                 },
                 {

                 id: "gter",
                 type: "google",
                 url: "ter",// google url有效值为 vec,img,ter中的一个
                 img_src: styleName + "/img/maptype/maptype1.png",
                 name: "地形图",
                 initShow: true
                 },*/

                /**
                 * =================================================================
                 * 加载离线地图配置 .demo
                 * =================================================================
                 * */

                /* {
                 id: "tdtTer",
                 type: "local",
                 url: "http://localhost:8080/yn/Layers",
                 img_src: styleName + "/img/maptype/maptype3.png",
                 name: "地形图",
                 initShow: true,
                 initExtent: [10480762.7498279, 2294038.25974672, 12374654.0376105, 3432278.03622627],
                 fullExtent: [10866949.9145482, 2450191.28563275, 11753662.3128358, 3315051.15489307]
                 }*/

                /**
                 * =================================================================
                 * 加载天地图地图配置 .demo
                 * =================================================================
                 * */
                /*{
                 id: "tdtTer",
                 type: "tdt",
                 url: "ter",
                 img_src: styleName + "/img/maptype/maptype1.png",
                 name: "地形图",
                 initShow: true
                 },
                 {
                 id: "tdtImg",
                 type: "tdt",
                 url: "img",
                 img_src: styleName + "/img/maptype/maptype2.png",
                 name: "影像图",
                 initShow: false
                 },
                 {
                 id: "tdtvec",
                 type: "tdt",
                 url: "vec",
                 img_src: styleName + "/img/maptype/maptype3.png",
                 name: "矢量图",
                 initShow: false
                 },*/

                /**
                 * =================================================================
                 * 加载ArcGIS底图配置. demo
                 * =================================================================
                 * */
                {
                    id: "test",
                    type: "arcgis",
                    url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer",
                    img_src: styleName + "/img/maptype/maptype1.png",
                    name: "矢量图",
                    initShow: false
                },
                {
                    id: "test1",
                    type: "arcgis",
                    url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineStreetGray/MapServer",
                    img_src: styleName + "/img/maptype/maptype2.png",
                    name: "灰色图",
                    initShow: false
                },
                {
                    id: "test3",
                    type: "arcgis",
                    url: "http://thematic.geoq.cn/arcgis/rest/services/ThematicMaps/WorldHydroMap/MapServer",
                    img_src: styleName + "/img/maptype/maptype3.png",
                    name: "河流图",
                    initShow: false
                },
                {
                    id: "test4",
                    type: "arcgis",
                    url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineStreetPurplishBlue/MapServer",
                    img_src: styleName + "/img/maptype/maptype1.png",
                    name: "蓝色图",
                    initShow: true
                }
                /*{
                 id: "test1",
                 type: "arcgis",
                 url: "http://10.100.9.25:6080/arcgis/rest/services/basin/MapServer",
                 img_src: styleName + "/img/maptype/maptype2.png",
                 name: "灰色图",
                 initShow: true
                 },*/
            ],
            /**
             * 图层管理控件配置信息。
             * */
            optionalLayers: [
                {
                    name: "图层管理",
                    checked: true,
                    layers: [
                        {
                            id: "swz",
                            type: "feature",
                            url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/2",
                            name: "水文站",
                            initShow: false,
                        },
                        {
                            id: "hp",
                            type: "feature",
                            url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/15",
                            name: "湖泊",
                            initShow: true,
                        },
                        /*{
                         id: "hp1",
                         type: "dynamic",
                         url: "http://10.100.9.25:6080/arcgis/rest/services/gdmap/MapServer",
                         name: "湖泊测试",
                         initShow: true,
                         }*/
                    ]
                }, {
                    name: "临时分组",
                    checked: false,
                    layers: [
                        {
                            id: "gl",
                            type: "feature",
                            url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/9",
                            name: "高速公路",
                            initShow: false
                        }
                    ]
                }
            ],
            /**
             * GP服务地址配置信息.
             * */
            gpUrls: [
                //等值面
                {
                    type: "dzxm",
                    url: "http://10.100.9.23/arcgis/rest/services/GZ_DZM_IDW/GPServer/SP_DZM",
                    params: {
                        cell: "400",
                        interval: 5,
                        ExpressionDzx: "CONTOUR =5 OR CONTOUR=10 OR CONTOUR=25 OR CONTOUR=50 OR CONTOUR=100 OR CONTOUR=250 OR CONTOUR>250",
                        ExpressionAD: "ADCODE='530000'",
                        DB: '520000',
                        Reclassification: "-1000 0 0;0.00001 10 1;10.00001 25 2;25.00001 50 3;50.00001 100 4;100.00001 250 5;250.00001 10000 6;10000 1000000000 7"
                    }
                },
                //降雨量距平图
                {
                    type: "jpt",
                    url: "http://10.100.9.23/arcgis/rest/services/GZ_DZM_IDW/GPServer/SP_DZM",
                    params: {
                        cell: "2223.00758842292",
                        Expression: "QUERYID='4ab032a8-a278-44ec-be8c-8c4d43235d34'",
                        ExpressionAD: "ADCODE='520000'",
                        DB: "520000",
                        Reclassification: "-2017 -50 0;-49.99999999 -20 1;-19.999999 0 2;0.0000001 20 3;20.000001 50 4;50.0000001 100 5;100.0000001 200 6;200.000001 1000 7;NODATA 8"
                    }
                },
                //
            ],
            /**
             * 地图查询组件配置信息
             * */
            mapSearch: {
                //是否显示结果列表.
                showMultiResults: false,
                // domId:"search",
                sources: [{
                    //需要查询的服务地址
                    url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/13",
                    //弹出框标题.
                    title: "查询",
                    //弹出信息配置
                    template: "Owner name: ${NAME}</br>River ID: ${RIVERID}",
                    //搜索字段
                    searchFields: ["NAME", "RIVERID"],
                    //显示字段
                    displayField: "NAME"
                }, {
                    url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/4",
                    title: "查询",
                    template: "Owner name: ${Name}</br>",
                    searchFields: ["Name"],
                    displayField: "Name"
                }, {
                    url: "http://10.100.9.57/ArcGIS/rest/services/SYMAP11/MapServer/0",
                    title: "查询",
                    template: "Owner name: ${NAME}</br>",
                    searchFields: ["NAME"],
                    displayField: "NAME"
                }]
            },
            /**
             * 地图对比信息
             * */

            mapCompare: {
                //
                id: "compareLayer",//图层ID
                type: "arcgis",// 图层类型
                url: "http://thematic.geoq.cn/arcgis/rest/services/ThematicMaps/WorldHydroMap/MapServer",
                initShow: true
            },
            /**
             * 地图图例配置信息.
             * */
            //
            mapLegend: {
                //
                type: "single",
                sources: [
                    //在配置了图例的情况下，对应的查询结果渲染从从图例中读取符号信息.
                    {
                        name: "报警测站",
                        icon: arcgisPath+  styleName + "/img/qsh/A034-0.png",
                        size: [/**width*/48, /**height*/48]
                    }, {
                        //
                        name: "预警测站",
                        icon: arcgisPath+ styleName + "/img/qsh/A034-1.png",
                        size: [48, 48]

                    }, {
                        //
                        name: "正常测站",
                        icon: arcgisPath+ styleName + "/img/qsh/A034--1.png",
                        size: [48, 48]
                    }, {
                        //
                        name: "数据连接异常测站",
                        icon: arcgisPath+ styleName + "/img/qsh/A034--2.png",
                        size: [48, 48]
                    }
                ]

            },
            /**
             *
             * */
            mapSwipe: {
                //
                //
                id: "swipeLayer",//图层ID
                type: "arcgis",// 图层类型
                url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer",
                initShow: false
            }
        };
    })();

    return mo;

});