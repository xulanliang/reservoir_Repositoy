/**
 * Created by Administrator on 2016/8/15.
 * load wxyt.
 */
define([
    "dojo/_base/declare",
    //
    "dojo/_base/lang",
    "esri/geometry/Point",
    "esri/geometry/ScreenPoint",
    "dojo/dom",
    "dojo/on",
    "dojo/request/xhr",
    "dojo/query",
    "esri/domUtils",
    "dojo/dom-construct",
    "esri/layers/GraphicsLayer",
    "dse_gis/utils/dseSymbolUtils",
    "dse_gis/utils/dseGisUtils",
    "esri/graphic",
], function (declare, lang, Point, ScreenPoint, dom, on, xhr, query, domUtils, domConstruct, GraphicsLayer, dseSymbolUtils, dseGisUtils, Graphic) {
    //
    //
    return declare([GraphicsLayer], {
        // name: "EchartsLayer",
        map: null,
        _option: null,
        constructor: function (url, options) {
            // this.map = options.map;
            //
            lang.mixin(this, options);
            //
            this.domNode = document.createElement('div');
            this.domNode.style.position = 'absolute';
            // this.domNode.style.height = this.map.height + 'px';
            // this.domNode.style.width = this.map.width + 'px';
            this.domNode.style.top = 0;
            this.domNode.style.left = 0;
            //
            this.domNode.id = options.id;
            //
            this.baseUrl = url;
            /*var svgCtn = query("#map_layers>svg")[0];
             //
             if (svgCtn) {
             //
             dom.byId("map_layers").insertBefore(this.domNode, svgCtn);
             }*/
            //
            /*var imgSrc = domConstruct.create("img", {
             alt: "noData"
             }, this.domNode);*/
            //
            // this._imgData = imgSrc;
            this.dataIndex = 0;
            //
            /* if (this.map) {
             this.map.addLayer(this);
             }*/
        },
        //
        /*setLayer: function (layer) {
         //


         },*/
        /**
         * 显示图层.
         * */
        show: function () {
            //
            domUtils.show(dom.byId(this.id));
        },
        /**
         * 隐藏图层。
         * */
        hide: function () {
            //
            domUtils.hide(dom.byId(this.id));
        },
        //
        setData: function (data) {
            //
            this.dataSource = data;
        },
        //
        clearData: function () {
            //
            this.dataSource = [];
        },
        //
        /**load next data view.*/
        loadNextFrame: function (keyField, width, height) {
            //
            // var imgCtn = this._imgData;
            //
            var idx = this.dataIndex;
            var source = this.dataSource;
            //
            var sc = source.length - 1;
            var row = {};
            if (idx > sc) {
                //
                this.dataIndex = 0;
                row = this.dataSource[this.dataIndex];
            }
            else {
                //
                row = this.dataSource[this.dataIndex++];
            }
            //
            this.loadCurrentFrame(row, keyField, width, height);
        },
        /** load last data view.*/
        loadBackFrame: function (keyField, width, height) {
            //
            var idx = this.dataIndex;
            var source = this.dataSource;
            //
            var sc = source.length;
            var row = {};
            if (idx < 0) {
                //
                this.dataIndex = sc - 1;
                row = this.dataSource[this.dataIndex];
            }
            else {
                //
                row = this.dataSource[this.dataIndex--];
            }
            //
            this.loadCurrentFrame(row, keyField, width, height);
        },
        //
        loadFirstFrame: function (keyField, width, height) {
            //
            // var idx = this.dataIndex;
            var source = this.dataSource;
            var row = source[0];
            //
            this.loadCurrentFrame(row, keyField, width, height);
            //
            //
            /*var info = {
             //LGTD	106.808056
             // LTTD	26.533889
             x: 106.808056,
             y: 26.533889
             //
             };*/
            /*var info = this.start;
             //
             var xys = dseGisUtils.WgsToDqzb(info.x, info.y, this.mapType);
             //
             var geo = new Point(xys[0], xys[1], this.map.spatialReference);
             //
             var symbol = dseSymbolUtils.createPictureMarkerSymbol({
             url: this.baseUrl + row[keyField],
             width: width,
             height: height
             });
             //
             // symbol.yoffset = (1720/2);
             // symbol.xoffset = (1200/2);
             //
             var gra = new Graphic(geo, symbol);
             //
             this.add(gra);*/
            //
            //
            // $(imgCtn).attr("src", this.baseUrl + row[keyField]);
        },
        //
        //
        loadCurrentFrame: function (row, keyField, width, height) {
            //
            var info = this.start;
            //
            if (row) {
                var xys = dseGisUtils.WgsToDqzb(info.x, info.y, this.mapType);
                //
                var geo = new Point(xys[0], xys[1], this.map.spatialReference);
                //
                var symbol = dseSymbolUtils.createPictureMarkerSymbol({
                    url: this.baseUrl + row[keyField],
                    width: width,
                    height: height
                });
                //
                // symbol.yoffset = (1720/2);
                // symbol.xoffset = (1200/2);
                //
                var gra = new Graphic(geo, symbol);
                //
                // this.add(gra);
                this.layer.add(gra);
            }
        },
        //
        clear: function () {
            //
            this.layer.clear();
        },
        /***/
        resetDataIndex: function () {
            this.dataIndex = 0;
        },
        //
        /**
         * <description>auto play image data.</description>
         * @param data {Javascript Array.}
         * @param delayTime.
         *
         * */
        isPlaying: false,
        autoPlayData: function (keyField, width, height, delayTime, callback) {
            //
            var images = this.dataSource;
            var itemCount = images.length;
            var itemIndex = 0;
            //
            var self = this;
            //
            var ins = setInterval(function () {
                //
                //
                if (itemIndex < itemCount) {
                    if (typeof callback === "function") {
                        //
                        callback(itemIndex);
                    }
                    self.loadNextFrame(keyField, width, height);
                    //
                    itemIndex++;
                    self.isPlaying = true;
                    self._pauseIndex = itemIndex;
                }
                else {
                    clearInterval(ins);
                    self.isPlaying = false;
                }
            }, delayTime);
            //
            //
            this._intervalPlay = ins;
        },
        /**停止播放云图.*/
        stopPlay: function () {
            //
            this.layer.clear();
            clearTimeout(this._intervalPlay);
            this.isPlaying = false;
        },
        //暂停位置.
        _pauseIndex: -1,
        _playIndex: -1,
        isPausePlaying: false,
        /**恢复播放*/
        recoverDataPlay: function (keyField, width, height, delayTime, callback) {
            //
            var images = this.dataSource;
            var itemCount = images.length;
            var itemIndex = this._pauseIndex;
            this.isPausePlaying = false;
            //
            var self = this;
            //
            var ins = setInterval(function () {
                //
                //
                if (itemIndex < itemCount) {
                    if (typeof callback === "function") {
                        //
                        callback(itemIndex);
                    }
                    self.loadNextFrame(keyField, width, height);
                    //
                    itemIndex++;
                    self.isPlaying = true;
                    self._pauseIndex = itemIndex;
                }
                else {
                    clearInterval(ins);
                    self.isPlaying = false;
                }
            }, delayTime);
            //
            //
            this._intervalPlay = ins;
        },
        //
        pausePlay: function () {
            //
            this.isPausePlaying = true;
            clearTimeout(this._intervalPlay);
        }
    });
});
//# sourceMappingURL=WXYTLayer.js.map