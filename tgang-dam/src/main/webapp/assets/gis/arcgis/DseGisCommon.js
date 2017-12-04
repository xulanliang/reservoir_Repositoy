//define("dse_gis/DseGisCommon",["dse_gis/DseGisBase"], function(DseGisBase) {
/**
 * Created by xiangqx on 2016/5/31
 *  业务类封装类
 *
 */

define("dse_gis/DseGisCommon", [
    "dse_gis/DseGisBase",
    "esri/map",
    "esri/toolbars/draw",
    "dojo/parser",
    "esri/toolbars/edit",
    'esri/urlUtils',
    "dojo/_base/event",
    "esri/symbols/SimpleFillSymbol",
    "esri/symbols/SimpleLineSymbol",
    "esri/toolbars/draw",
    "esri/graphic",
    "esri/symbols/Font",
    "dojo/_base/Color",
    "esri/symbols/TextSymbol",
    "esri/symbols/PictureMarkerSymbol",
    "esri/layers/GraphicsLayer",
    "esri/geometry/Polygon",
    "esri/geometry/Point",
    "esri/SpatialReference",
    "esri/layers/ArcGISTiledMapServiceLayer",
    "esri/tasks/query",
    "esri/tasks/QueryTask",
    "esri/tasks/LengthsParameters",
    "esri/tasks/AreasAndLengthsParameters",
    "esri/tasks/GeometryService",
    "dse_gis/utils/dseSymbolUtils",
    "dojo/domReady!"
], function (DseGisBase,
             Map, Draw, parser, Edit, urlUtils, event, SimpleFillSymbol, SimpleLineSymbol, Draw, Graphic, Font, Color, TextSymbol, PictureMarkerSymbol, GraphicsLayer, Polygon, Point, SpatialReference,
             ArcGISTiledMapServiceLayer, Query, QueryTask, LengthsParameters, AreasAndLengthsParameters, GeometryService, domAttr,
             dseSymbolUtils) {


    var dsemap = '';
    var Dsegiscommon = {};
    //
    /**
     * 添加点集合
     * opt.sttp:需要构建的点类型 (PP:雨量类型、QSH:取水户类型) 必须
     * opt.datas:数据集(datas.lgtd:要素经度,datas.lttd：要素纬度)
     * opt.type:该要素根据哪个变量(datas中的属性：如datas中有flag属性，则设置为：opt.type:'flag')来渲染,如果没有设置, 非必须
     */
    var addPoints = function (layer, opt) {
        var dataArr = opt.datas;
        for (var i = 0; i < dataArr.length; i++) {
            var arr = dataArr[i];
            var markimg = dseSymbolUtils.getMarkImg(opt.sttp, arr[opt.type]);//DseGisBase.getMarkImg(opt.sttp, arr[opt.type]);
            if (arr.lgtd && arr.lttd) {
                var graphic = DseGisBase.gra.createPoint(arr, arr.lgtd, arr.lttd, markimg.path, markimg.width, markimg.heigth);
                layer.add(graphic);
            }
        }

    };
    /**
     * 通用要素点的构建
    * opt.sttp:需要构建的点类型 (PP:雨量类型、QSH:取水户类型) 必须
    * opt.datas(datas.lgtd:要素经度 必须,datas.lttd：要素纬度 必须，datas.type:该要素类型下的不同划分,主要用于渲染不同的点要素图标 非必须)必须
    * opt.type:该要素根据哪个变量(datas中的属性：如datas中有flag属性，则设置为：opt.type:'flag')来渲染,如果没有设置, 非必须
    * opt.clear:是否清空，默认清空，false：新建，true:追加
    * opt.twinkle:是否单击闪烁，默认不闪烁，true:闪烁，false:不闪烁
    * opt.twtime 闪烁时间(opt.twinkle设置为true才生效) 单位：毫秒，默认10秒
    * opt.clickCallBack：要素单击事件回调函数 非必须
    * opt.moverCallBack:鼠标进入要素事件回调函数 非必须
    * opt.moutCallBack：鼠标移出要素事件回调函数 非必须
    */
        var buildPoint = function (opt) {
        if (!opt)return false;
        var layerId = 'DSE_' + opt.sttp,
            layer = dsemap.getLayer(layerId);

        if (!layer) {//图层不存在存在 则新建
            layer = DseGisBase.addLayer({id: layerId});
            layer.on('mouse-over', function (e) {
                dsemap.setMapCursor('pointer');//改变鼠标的状态

                //typeof opt.moverCallBack ==="function"
                if (opt.moverCallBack) {//鼠标进入回调函数：e.graphic.geometry:地理要素，e.graphic.data:属性数据
                    opt.moverCallBack(e.graphic);
                }
            });
            layer.on('mouse-out', function (e) {
                dsemap.setMapCursor('default');
                if (opt.moutCallBack) {
                    opt.moutCallBack();
                }
            });
            layer.on('click', function (e) {//单击事件
                var data = e.graphic.data;
                if (opt.clickCallBack) {//单击回调函数：e.graphic.geometry:地理要素，e.graphic.data:属性数据
                    opt.clickCallBack(e.graphic);
                }
                if (opt.twinkle) {//是否闪烁
                    DseGisBase.showLocalCircle(new Point(data.lgtd, data.lttd), $.extend(true, {twtime: 10000}, opt).twtime);
                }
            });
        } else {
            if (!opt.clear) {//默认清空图层
                layer.clear();
            }
        }
        //创建要素点
        addPoints(layer, opt);
        return {
            //返回点所在的图层
            PointLayer: layer
        };
    };


    return Dsegiscommon = {
        initMap: function (container, opt) {
            dsemap = DseGisBase.initMap(container, opt);
            Dsegiscommon.dsemap = dsemap;//把dsemap公开发布出去，便于不同模块都可以快速访问dsemap
            return dsemap;
        },
        /**
         * 添加图层
         * */
        addLayer: DseGisBase.addLayer,
        //添加点
        /*createPoint: DseGisBase.getGraUtil().createPoint,
        //添加线
        createPolyline: DseGisBase.getGraUtil().createPolyline,
        //添加面
        CreatePolygon: DseGisBase.getGraUtil().createPolygon,*/
        //属性窗体
        showInfoWindow: DseGisBase.showInfoWindow,
        //定位
        showCenterAt: DseGisBase.showCenterAt,
        //显示闪烁符号
        showLocalCircle: DseGisBase.showLocalCircle,
        //创建业务点
        buildPoint: buildPoint,
        //地图平移到指定范围
        showExtent: DseGisBase.showExtent,
        //
        geo:DseGisBase.getGeoUtil(),
        //
        gra:DseGisBase.getGraUtil(),
        //
        gp:DseGisBase.getGpUtil(),
        appConfig:DseGisBase.appConfig,
        //
        addMapControl:DseGisBase.addMapControl

    };

});