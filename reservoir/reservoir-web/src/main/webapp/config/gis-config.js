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
            // fullExtent format:[xmin,ymin,xmax,ymax]
            // full extent example :{"type":"extent","xmin":12701016.333804656,"ymin":2575985.9415646303,"xmax":12709352.747202229,"ymax":2580213.8646917655,"spatialReference":{"wkid":102100,"latestWkid":3857}}
            // fullExtent: [1.1418946097397627E7,2712886.7523683254,1.2361563064558089E7,3458633.9138223915],
            // fullExtent: [12691108.670724759, 2571726.374727739, 12727798.444301592, 2590338.7911151545],
            //11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692
            fullExtent: [12597857.097240614,2553570.299319928,12806683.058515796,2654772.92476954],
            // fullExtent: [12576899.019547654,2541707.8205991876,12785724.980822837,2642910.4460487994],
            //投影参数：1：经度坐标系；2：平面坐标系，3：百度坐标系
            mapType: "2",
            /**
             * 是否需要变换坐标.
             * */
            isTransformCoordinate: true,
            //
            minZoom: 10,
            maxZoom: 17,
            zoom: 9,
            minVisibleZoom: 1,
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
                {

                    id: "gimg",
                    type: "google",
                    url: "img",// google url有效值为 vec,img,ter中的一个
                    img_src: styleName + "/img/maptype/yx1.png",
                    name: "影像图",
                    initShow: true
                },
                {

                    id: "gvec",
                    type: "google",
                    url: "vec",// google url有效值为 vec,img,ter中的一个
                    img_src: styleName + "/img/maptype/jt1.png",
                    name: "矢量图",
                    initShow: false
                },

                // ,
                // {
                //
                //     id: "gter",
                //     type: "google",
                //     url: "ter",// google url有效值为 vec,img,ter中的一个
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "地形图",
                //     initShow: true
                // },

                /**
                 * =================================================================
                 * 加载离线地图配置 .demo
                 * =================================================================
                 * */
                // {
                //     id: "szVec",
                //     type: "local",
                //     url: "http://10.100.9.52:8080/mapData/shenZhenVec/v101/Layers",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "地形图",
					// fullExtent:[ 1.2692955691646272E7,2575708.6223917315,1.2700059768354425E7,2579611.2343636216],
					// initExtent:[1.2692955691646272E7,2575708.6223917315,1.2700059768354425E7,2579611.2343636216]
                // },

                //东改工程离线地图
                /*{
                    id: "img",
                    type: "googleOffLine",
                    url: "http://10.100.9.52:8080/mapData/dggcimg",
                    img_src: styleName + "/img/maptype/dx1.png",
                    name: "影像图",
                    initShow: true,
                    initExtent: [12632594.790634327,2562016.3147147233,12738689.38589418,2654505.118963329],
                    fullExtent: [12632594.790634327,2562016.3147147233,12738689.38589418,2654505.118963329],
                    /!**如果切图的服务为标注和底图服务分开的情况下，通过该标签配置标签服务,没有则不需要配置*!/
                    labelInfo: {
                        url: ""
                    }
                },
                {
                    id: "dgvec",
                    type: "googleOffLine",
                    url: "http://10.100.9.52:8080/mapData/dggcvec",
                    img_src: styleName + "/img/maptype/dx1.png",
                    name: "矢量图",
                    initShow: false,
                    initExtent: [12632594.790634327,2562016.3147147233,12738689.38589418,2654505.118963329],
                    fullExtent: [12632594.790634327,2562016.3147147233,12738689.38589418,2654505.118963329],
                    /!**如果切图的服务为标注和底图服务分开的情况下，通过该标签配置标签服务,没有则不需要配置*!/
                    labelInfo: {
                        url: ""
                    }
                },*/
                // {
                //     id: "szImg",
                //     type: "googleOffLine",
                //     url: "http://10.100.9.52:8080/mapData/shenZhenImage",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "地形图",
                //     initShow: true,
                //     initExtent: [12655191.55798678,2540383.717942006,12763743.534919439,2614834.1289121164],
                //     fullExtent: [12655191.55798678,2540383.717942006,12763743.534919439,2614834.1289121164],
                //     /**如果切图的服务为标注和底图服务分开的情况下，通过该标签配置标签服务,没有则不需要配置*/
                //     labelInfo: {
                //         url: ""
                //     }
                // },

                /**
                 * =================================================================
                 * 加载天地图地图配置 .demo
                 * =================================================================
                 * */
                // {
                //     id: "tdtvec",
                //     type: "tdt",
                //     url: "vec",
                //     img_src: styleName + "/img/maptype/jt1.png",
                //     name: "矢量图",
                //     initShow: true
                // },
                // {
                //     id: "tdtTer",
                //     type: "tdt",
                //     url: "ter",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "地形图",
                //     initShow: false
                // },
                // {
                //     id: "tdtImg",
                //     type: "tdt",
                //     url: "img",
                //     img_src: styleName + "/img/maptype/yx1.png",
                //     name: "影像图",
                //     initShow: false
                // },

                /**
                 * =================================================================
                 * 加载ArcGIS底图配置. demo
                 * =================================================================
                 * */
                // {
                //     id: "test",
                //     type: "arcgis",
                //     url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineCommunity/MapServer",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "矢量图",
                //     initShow: true
                // },
                // {
                //     id: "test1",
                //     type: "arcgis",
                //     url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineStreetGray/MapServer",
                //     img_src: styleName + "/img/maptype/jt1.png",
                //     name: "灰色图",
                //     initShow: false
                // },
                // {
                //     id: "test3",
                //     type: "arcgis",
                //     url: "http://thematic.geoq.cn/arcgis/rest/services/ThematicMaps/WorldHydroMap/MapServer",
                //     img_src: styleName + "/img/maptype/yx1.png",
                //     name: "河流图",
                //     initShow: false
                // },
                // {
                //     id: "test4",
                //     type: "arcgis",
                //     url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineStreetPurplishBlue/MapServer",
                //     img_src: styleName + "/img/maptype/jt1.png",
                //     name: "蓝色图",
                //     initShow: false
                // }

                /**
                 * =================================================================
                 * 加载ArcGIS底图配置. demo
                 * =================================================================
                 * */
                // {
                //     id: "test",
                //     type: "dynamic",
                //     url: "http://10.100.9.52:6080/arcgis/rest/services/GZMAPStyleOne/MapServer",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "矢量图",
                //     initShow: true
                // }
                /*{
                 id: "test1",
                 type: "arcgis",
                 url: "http://10.100.9.25:6080/arcgis/rest/services/basin/MapServer",
                 img_src: styleName + "/img/maptype/maptype2.png",
                 name: "灰色图",
                 initShow: true
                 },*/
                /**
                 * =================================================================
                 * 接入超图切片图. demo
                 * =================================================================
                 * */
                // {
                //     id: "test",
                //     type: "smWmts",
                //     url: "http://10.100.9.52:8090/iserver/services/map-world/wmts100",//地图服务地址
                //     img_src: styleName + "/img/maptype/yx1.png", //按钮图标
                //     name: "影像图",
                //     //地图服务比例尺.
                //     scales: [2.9582935545E8, 1.47914677725E8, 7.39573388625E7, 3.697866943125E7, 1.8489334715625E7,
                //         9244667.3578125, 4622333.67890625, 2311166.839453125, 1155583.4197265625, 577791.7098632812, 288895.8549316406,
                //         144447.9274658203, 72223.96373291015, 36111.98186645508, 18055.99093322754, 9027.99546661377, 4513.997733306885,
                //         2256.9988666534423, 1128.4994333267211],
                //     extent: [-180, -90, 180, 90],
                //     wkid: 4326,
                //     identifier: "World",
                //     tileMatrixSet: "GlobalCRS84Scale_World",
                //     resolutionKey: "GlobalCRS84Scale",
                //     initShow: true  //initShow设置为true，则默认显示此图层。
                //     // 以后点击切换图层按钮，通过隐藏其他图层实现
                // }, {
                //     id: "test001",
                //     type: "smWmts",
                //     url: "http://10.100.9.52:8090/iserver/services/map-world/wmts100",//地图服务地址
                //     img_src: styleName + "/img/maptype/yx1.png", //按钮图标
                //     name: "夜色图",
                //     //地图服务比例尺.
                //     scales: [2.9582935545E8, 1.47914677725E8, 7.39573388625E7, 3.697866943125E7, 1.8489334715625E7,
                //         9244667.3578125, 4622333.67890625, 2311166.839453125, 1155583.4197265625, 577791.7098632812, 288895.8549316406,
                //         144447.9274658203, 72223.96373291015, 36111.98186645508, 18055.99093322754, 9027.99546661377, 4513.997733306885,
                //         2256.9988666534423, 1128.4994333267211],
                //     extent: [-180, -90, 180, 90],
                //     wkid: 4326,
                //     identifier: "世界地图_Night",
                //     tileMatrixSet: "GlobalCRS84Scale_世界地图_Night",
                //     resolutionKey: "GlobalCRS84Scale",
                //     initShow: false  //initShow设置为true，则默认显示此图层。
                //     // 以后点击切换图层按钮，通过隐藏其他图层实现
                // },

                /**
                 * =================================================================
                 * 加载天地图以及基于天地图电子地图方案的WMTS服务 坐标系为CGCS2000
                 * =================================================================
                 * */
                /*{
                 id: "test",
                 type: "tdtWmts",
                 url: "http://t0.tianditu.com/vec_c/wmts",//地图服务地址
                 img_src: styleName + "/img/maptype/yx1.png", //按钮图标
                 name: "矢量图",
                 origin: {x: -180, y: 90},
                 //地图服务比例尺.
                 extent: [-180, -90, 180, 90],
                 startIndex: 1,
                 wkid: 4326,
                 identifier: "vec",
                 tileMatrixSet: "c",
                 /!**是否包括标签*!/
                 labelInfo: {
                 url: "http://t0.tianditu.com/cva_c/wmts",
                 identifier: "cva"
                 },
                 initShow: true  //initShow设置为true，则默认显示此图层。
                 // 以后点击切换图层按钮，通过隐藏其他图层实现
                 }, {
                 id: "test001",
                 type: "tdtWmts",
                 url: "http://t0.tianditu.com/img_c/wmts",//地图服务地址
                 img_src: styleName + "/img/maptype/yx1.png", //按钮图标
                 name: "影像图",
                 origin: {x: -180, y: 90},
                 extent: [-180, -90, 180, 90],
                 wkid: 4326,
                 identifier: "img",
                 tileMatrixSet: "c",
                 /!**是否包括标签*!/
                 labelInfo: {
                 url: "http://t0.tianditu.com/cia_c/wmts",
                 identifier: "cia"
                 },
                 startIndex: 1,
                 initShow: false  //initShow设置为true，则默认显示此图层。
                 // 以后点击切换图层按钮，通过隐藏其他图层实现
                 },*/
                /**
                 * =================================================================
                 * 加载google离线地图，支持用太乐地图软件下载的离线图片
                 * =================================================================
                 * */

                // {
                //     id: "tdtTer",
                //     type: "googleOffLine",
                //     url: "http://localhost:8080/gxmap/dixing",
                //     img_src: styleName + "/img/maptype/dx1.png",
                //     name: "地形图",
                //     initShow: false,
                //     format: ".jpg",
                //     initExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692],
                //     fullExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692]
                // },
                // {
                //     id: "tdtJT",
                //     type: "googleOffLine",
                //     url: "http://localhost:8080/gxmap/jiaotong",
                //     img_src: styleName + "/img/maptype/jt1.png",
                //     name: "交通图",
                //     format: ".png",
                //     initShow: true,
                //     initExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692],
                //     fullExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692]
                // },
                // {
                //     id: "tdtImg",
                //     type: "googleOffLine",
                //     url: "http://localhost:8080/gxmap/yaogan",
                //     img_src: styleName + "/img/maptype/yx1.png",
                //     format: ".jpg",
                //     name: "遥感图",
                //     initShow: false,
                //     initExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692],
                //     fullExtent: [11787810.121593211, 2509856.455319883, 12447010.750131978, 2830280.712021692]
                // }
            ],
            /**
             * 图层管理控件配置信息。
             * */
            optionalLayers: [
                // {
                //     name: "东改工程",
                //     checked: true,
                //     layers: [
                //         {
                //             id: "swz",
                //             type: "feature",
                //             url: "http://10.100.9.52:6080/arcgis/rest/services/DGData/MapServer/1",
                //             name: "供水路线",
                //             initShow: true,
                //         }, {
                //             id: "gl",
                //             type: "feature",
                //             url: "http://10.100.9.52:6080/arcgis/rest/services/DGData/MapServer/0",
                //             name: "沿线建筑",
                //             initShow: true
                //         }, {
                //             id: "hx",
                //             type: "feature",
                //             url: "http://10.100.9.52:6080/arcgis/rest/services/DGDataFull/MapServer/2",
                //             name: "水库红线",
                //             initShow: true
                //         }
                //     ]
                // },
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
                sources: [
                    /* {
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
                     },*/

                    /*{
                     url: "http://10.100.9.169:6080/arcgis/rest/services/ChinaPoint/MapServer/0",
                     title: "查询",
                     template: "Owner name: ${NAME}</br>",
                     searchFields: ["NAME"],
                     displayField: "NAME"
                     }*/
                ]
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
                        icon: dseGisPath + styleName + "/img/qsh/A034-0.png",
                        size: [/**width*/48, /**height*/48]
                    }, {
                        //
                        name: "预警测站",
                        icon: dseGisPath + styleName + "/img/qsh/A034-1.png",
                        size: [48, 48]

                    }, {
                        //
                        name: "正常测站",
                        icon: dseGisPath + styleName + "/img/qsh/A034--1.png",
                        size: [48, 48]
                    }, {
                        //
                        name: "数据连接异常测站",
                        icon: dseGisPath + styleName + "/img/qsh/A034--2.png",
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
                url: "http://map.geoq.cn/ArcGIS/rest/services/ChinaOnlineStreetPurplishBlue/MapServer",
                initShow: false
            }
        };
    })();

    return mo;

});