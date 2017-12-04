/**
 * Created by Esri on 2015/4/1.
 */
//
define(["dojo/dom", "dojo/on", "dojo/_base/declare",
        "dojo/_base/array",
        "dojo/dom-construct",
        "dojo/string",
        "dojo/_base/lang",
        "dojo/sniff",

        "esri/toolbars/draw",
        "esri/graphic",
        "esri/geometry/Point",
        "esri/layers/GraphicsLayer",
        "esri/geometry/geometryEngine",
        "esri/symbols/Font",
        "esri/symbols/SimpleLineSymbol",
        "esri/symbols/SimpleFillSymbol",
        "esri/symbols/TextSymbol",
        "esri/symbols/PictureMarkerSymbol",
        "esri/symbols/SimpleMarkerSymbol",
        "./_BaseTool",
        "esri/geometry/webMercatorUtils",
    ],
    function (dom, on, declare, Array, domConstruct, string, lang, sniff, Draw, Graphic, Point, GraphicsLayer,
              geometryEngine, Font, SimpleLineSymbol, SimpleFillSymbol, TextSymbol, PictureMarkerSymbol, SimpleMarkerSymbol, _BaseTool,
              webMercatorUtils) {
        //
        var drawTool = null;
        var showPt = null;
        //
        var layer = null;
        var layerId = "polygonLayer";
        //
        var closeSymbol = null;
        //
        var unitScale = 5000000;
        var largeUnitLabel = "平方公里";//公里
        var smallUnitLabel = "平方米";//米

        var largeUnitConversion = 1000000;
        //
        var layerClickHandler = null;
        //
        var lastPoint = null;
        //
        var _map = null;
        //
        var polySelf = null;
        var graphicId = null;
        //
        var textSymbol = null;
        var totalSymbol = null;
        var fillSymbol = null;
        //
        var widgetConfig = {
            "textSymbol": {
                "type": "esriTS",
                "color": [211, 48, 91, 255],
                "backgroundColor": [67, 0, 255, 40],
                "borderLineColor": [67, 0, 255, 40],
                "haloSize": 2,
                "haloColor": [67, 0, 255, 40],
                "verticalAlignment": "bottom",
                "horizontalAlignment": "left",
                "rightToLeft": false,
                "angle": 0,
                "xoffset": 10,
                "yoffset": -10,
                "kerning": true,
                "font": {
                    "family": "Arial",
                    "size": 12,
                    "style": "normal",
                    "weight": "bold",
                    "decoration": "none"
                }
            },
            "totalSymbol": {
                "type": "esriTS",
                "color": [211, 48, 91, 255],
                "backgroundColor": [255, 0, 0, 255],
                "borderLineSize": 2,
                "borderLineColor": [255, 0, 255, 255],
                "haloSize": 2,
                "haloColor": [0, 255, 0, 255],
                "verticalAlignment": "bottom",
                "horizontalAlignment": "left",
                "rightToLeft": false,
                "angle": 0,
                "xoffset": 20,
                "yoffset": 10,
                "kerning": true,
                "font": {
                    "family": "Arial",
                    "size": 12,
                    "style": "normal",
                    "weight": "bold",
                    "decoration": "none"
                }
            },

            "closeSymbol": {
                "type": "esriPMS",
                "url": arcgisPath + "themes/default/img/delete.png",
                "width": 16,
                "height": 16,
                "angle": 0,
                "xoffset": 11,
                "yoffset": 22
            },

            "fillSymbol": {
                "type": "esriSFS",
                "style": "esriSFSSolid",
                "color": [136, 136, 136, 90],
                "outline": {
                    "type": "esriSLS",
                    "style": "esriSLSSolid",
                    "color": [255, 0, 0, 180],
                    "width": 2
                }
            }

        };

        //
        var vertexGras = [];

        var module = declare([_BaseTool], {
            //
            constructor: function (map) {
                //
                drawTool = new Draw(map);
                //
                _map = map;
                //
                polySelf = this;
                drawTool.on("draw-end", lang.hitch(this, this._showMeasureResults));
                //
                this._createMeasureSymbols();
                //
            },
            //
            _showMeasureResultByGraphic: function (symbol, distance, extraLabel) {
                //
                var info = "";
                if (distance > unitScale) {
                    //
                    var convertDis = distance / largeUnitConversion;
                    //
                    info = convertDis.toFixed(3) + largeUnitLabel;
                } else {
                    //
                    info = distance.toFixed(3) + smallUnitLabel;
                }
                //
                //
                symbol.setFont(new Font().setDecoration("none"));
                //
                info = extraLabel + info;
                ////
                symbol.setText(info);
                //
                var attributes = {id: graphicId};
                var graphic = new Graphic(showPt, symbol, attributes);
                //
                layer.add(graphic);
                vertexGras.push(graphic);
            },
            //
            _showMeasureResults: function (event) {
                //
                drawTool.deactivate();
                // polySelf._executeChangeStyle();
                //
                lastPoint = null;
                polySelf._removeEventListeners();
                _map.setMapCursor("default");
                var geometry = event.geometry;
                //
                var attributes = {id: graphicId};

                var graphic = new Graphic(geometry, fillSymbol, attributes);

                layer.add(graphic);

                vertexGras.push(graphic);
                //
                showPt = geometry.getExtent().getCenter();
                //
                var area=polySelf._calculateArea(geometry,109404);

                polySelf._setCloseGraphic(showPt);
                //
                //
                this._showMeasureResultByGraphic(textSymbol, area, "总面积: ");
            },
            //
            _createMeasureSymbols: function () {
                //
                textSymbol = new TextSymbol(widgetConfig.textSymbol);
                totalSymbol = new TextSymbol(widgetConfig.totalSymbol);
                closeSymbol = new PictureMarkerSymbol(widgetConfig.closeSymbol);
                fillSymbol = new SimpleFillSymbol(widgetConfig.fillSymbol);

            },
            /**
             * 计算面积
             * */
            _calculateArea: function (geometry, unit) {
                //
                var wkid = geometry.spatialReference.wkid;
                //
                var area = 0.0;
                //
                if (wkid === 4326 || wkid === 102100 || wkid === 3857) {
                    //
                    area = geometryEngine.geodesicArea(geometry, unit);
                } else if (wkid === 102113) {
                    //
                    var geo = webMercatorUtils.webMercatorToGeographic(geometry);
                    area = geometryEngine.geodesicArea(geo, unit);

                } else {
                    //
                    area = geometryEngine.planarArea(geometry, unit);
                }
                //
                return area;
            },
            //
            _addEventListeners: function () {

                layerClickHandler = on(layer, "click", function (event) {
                    //
                    var gra = event.graphic;

                    if (gra && gra.attributes) {
                        //
                        if (gra.attributes["name"] === "close") {
                            //
                            //layer.remove(gra);
                            polySelf._removeMeasureResult(gra.attributes["id"]);
                        }
                    }
                });

            },
            _setCloseGraphic: function (geometry) {
                var attributes = {id: graphicId, name: "close"};
                var gra = new Graphic(geometry, closeSymbol, attributes);
                //
                layer.add(gra);
                vertexGras.push(gra);
            },
            _removeMeasureResult: function (graphicId) {
                //
                Array.forEach(vertexGras, function (graphic, iindex) {
                    //
                    var attributes = graphic.attributes;
                    if (attributes && attributes["id"] === graphicId) {
                        //
                        layer.remove(graphic);
                    }
                });

            },
            _removeEventListeners: function () {
                //
                /*if(layerClickHandler){
                 layerClickHandler.remove();
                 }*/
                /* if(mapClickHandler){
                 //
                 mapClickHandler.remove();
                 }*/
            },
            //
            isActive: false,

            activate: function () {
                //
                graphicId = "gra" + Math.floor(Math.random() * 500).toFixed(0);
                //
                if (this.isActive) {
                    //
                    this._removeEventListeners();
                }
                drawTool.activate(Draw.POLYGON);
                this._createMeasureLayer(layerId);
                this._addEventListeners();
                this.isActive = true;
            },

            deactivate: function () {
                this._removeEventListeners();
                this.isActive = false;
                drawTool.deactivate();

                if (layer) {
                    //
                    _map.removeLayer(layer);
                }
                vertexGras = [];
            },
            domNode: null,
            _createMeasureLayer: function (layerId) {
                //
                if (layerId) {
                    //
                    layer = _map.getLayer(layerId);
                    if (!layer) {
                        //
                        layer = new GraphicsLayer({id: layerId});
                        _map.addLayer(layer);
                        //
                        this.domNode = layer.getNode();
                    }
                }
            }

        });
        //
        return module;
        //
    });