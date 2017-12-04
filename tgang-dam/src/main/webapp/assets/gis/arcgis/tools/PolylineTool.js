/**
 * Created by Administrator on 2016/6/24.
 */
/**
 * <pre>
 *  用于实现地图测量
 *  @author wangsl
 * </pre>
 * */
define(["dojo/dom", "dojo/on", "dojo/_base/declare",
        "dojo/_base/array",
        "dojo/sniff",
        "esri/toolbars/draw",
        "esri/graphic",
        "esri/geometry/Point",

        "esri/layers/GraphicsLayer",
        "esri/geometry/geometryEngine",
        "esri/geometry/Polyline",
        "esri/symbols/SimpleLineSymbol",
        "esri/symbols/SimpleFillSymbol",
        "esri/symbols/TextSymbol",
        "esri/symbols/PictureMarkerSymbol",
        "esri/symbols/SimpleMarkerSymbol",
        "esri/geometry/webMercatorUtils",
        "./_BaseTool"
    ],
    function (dom, on, declare, Array, sniff, Draw, Graphic, Point, GraphicsLayer,
              geometryEngine, Polyline, SimpleLineSymbol, SimpleFillSymbol, TextSymbol,
              PictureMarkerSymbol, SimpleMarkerSymbol, webMercatorUtils, _BaseTool) {
        //
        var drawTool = null;
        var showPt = null;
        //
        var layer = null;
        var layerId = "lineLayer";
        var unitScale = 5000;
        var largeUnitLabel = "公里";//公里
        var smallUnitLabel = "米";//米

        var largeUnitConversion = 1000;
        //
        var layerClickHandler = null;
        //
        var lastPoint = null;
        var _map = null;
        var mapClickHandler = null;
        //
        var lineSelf = null;
        var mapDoubleClickHandler = null;
        var graphicId = null;
        //symbols
        var textSymbol = null;
        var totalSymbol = null;
        var startSymbol = null;
        var vectorSymbol = null;
        var endSymbol = null;
        var closeSymbol = null;
        //
        var vertexGras = [];
        //设置符号配置信息
        var symbolConfig = (function () {
            return {
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
                    "backgroundColor": [67, 0, 255, 40],
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
                    "url": arcgisPath+styleName+"/img/delete.png",
                    "width": 16,
                    "height": 16,
                    "angle": 0,
                    "xoffset": 11,
                    "yoffset": 22
                },

                "vertexSymbol": {
                    "type": "esriSMS",
                    "style": "esriSMSCircle",
                    "color": [255, 255, 255, 140],
                    "size": 8,
                    "angle": 0,
                    "xoffset": 0,
                    "yoffset": 0,
                    "outline": {
                        "color": [255, 0, 0, 255],
                        "width": 1
                    }
                },
                "lineSymbol": {
                    "type": "esriSLS",
                    "style": "esriSLSSolid ",
                    "color": [255, 0, 0, 255],
                    "width": 2
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
        })();

        function getGeometrySymbol(type) {
            //
            var symbol = null;
            switch (type) {
                case "polyline":
                    symbol = new SimpleLineSymbol(symbolConfig.lineSymbol);
                    break;
                case "polygon":
                    //symbol=symbolUtil.simpleFillSymbol();
                    symbol = new SimpleFillSymbol(symbolConfig.fillSymbol);
                    break;
                default:
                    break;
            }
            return symbol;
        }

        //
        //
        function showMeasureResultByGraphic(symbol, distance, extraLabel) {
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
            info = extraLabel + info;
            //
            symbol.setText(info);
            var attributes = {id: graphicId};
            var graphic = new Graphic(showPt, symbol, attributes);
            layer.add(graphic);
            vertexGras.push(graphic);
        }

        //
        //
        var totalDistance = 0;

        function showMeasureResultInIE(distance, extraLabel) {
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
            info = extraLabel + info;
            //
            return info;
        }

        //
        var module = declare([_BaseTool], {
            //
            constructor: function (map) {
                //
                drawTool = new Draw(map);
                //
                _map = map;
                //
                lineSelf = this;
                drawTool.on("draw-end", this._showMeasureResults);
                //
                this._initSymbols();
            },
            //
            _showMeasureResults: function (event) {
                drawTool.deactivate();
                //
                mapClickHandler.remove();
                lastPoint = null;
                _map.setMapCursor("default");
                var geometry = event.geometry;
                //
                var length = geometry.paths[0].length;
                showPt = new Point(geometry.paths[0][length - 1], _map.spatialReference);
                //
                var distance = lineSelf._calculateLength(geometry, 9001);
                showMeasureResultByGraphic(totalSymbol, distance, "总长度: ");
                //
                var attributes = {id: graphicId};
                var graphic = new Graphic(geometry, getGeometrySymbol(geometry.type), attributes);

                layer.add(graphic);
                vertexGras.push(graphic);
                totalDistance = distance
            },
            //
            _initSymbols: function () {
                //
                textSymbol = new TextSymbol(symbolConfig.textSymbol);
                totalSymbol = new TextSymbol(symbolConfig.totalSymbol);
                startSymbol = new TextSymbol("起点");//new PictureMarkerSymbol(symbolConfig.startSymbol);
                endSymbol = new TextSymbol("终点");
                endSymbol.setOffset(0, 6);//new PictureMarkerSymbol(symbolConfig.endSymbol);
                vectorSymbol = new SimpleMarkerSymbol(symbolConfig.vertexSymbol);
                closeSymbol = new PictureMarkerSymbol(symbolConfig.closeSymbol);
            },
            //
            _setStartGraphic: function (geometry) {
                //
                var attributes = {id: graphicId};
                var gra = new Graphic(geometry, startSymbol, attributes);
                //
                layer.add(gra);
                vertexGras.push(gra);
            },
            //
            _setEndGraphic: function (geometry) {
                var attributes = {id: graphicId, name: "close"};
                var gra = new Graphic(geometry, endSymbol, attributes);
                //
                layer.add(gra);
                vertexGras.push(gra);
            },
            //
            _setVertexGraphic: function (geometry) {
                //
                var attributes = {id: graphicId};

                var gra = new Graphic(geometry, vectorSymbol, attributes);
                layer.add(gra);
                vertexGras.push(gra);
            },
            //
            _addEventListeners: function () {
                //
                mapClickHandler = _map.on("click", function (event) {

                    var current = event.mapPoint;
                    //
                    if (!lastPoint) {
                        // set start
                        lineSelf._setStartGraphic(current);
                    }
                    //
                    if (lastPoint && current) {
                        //
                        var distance = lineSelf._measurePartLength(lastPoint, current);
                        showPt = current;
                        lineSelf._setVertexGraphic(current);
                        //
                        showMeasureResultByGraphic(textSymbol, distance, "");
                    }
                    //
                    lastPoint = current;
                    //
                });
                //
                mapDoubleClickHandler = _map.on("dbl-click", function (event) {
                    //
                    var geometry = event.mapPoint;
                    lineSelf._setEndGraphic(geometry);
                    lineSelf._setCloseGraphic(geometry);
                    //
                    //
                    if (sniff("ie")) {
                        var info = showMeasureResultInIE(totalDistance, "总长度：");
                        alert(info);
                    }
                    mapDoubleClickHandler.remove();
                    //
                });
                layerClickHandler = on(layer, "click", function (event) {
                    //
                    var gra = event.graphic;

                    if (gra && gra.attributes) {
                        //
                        if (gra.attributes["name"] === "close") {
                            //
                            //layer.remove(gra);
                            lineSelf._removeMeasureResult(gra.attributes["id"]);
                        }
                    }
                });

            },
            _setCloseGraphic: function (geometry) {
                //
                var attributes = {id: graphicId, name: "close"};
                var gra = new Graphic(geometry, closeSymbol, attributes);
                //
                layer.add(gra);
                vertexGras.push(gra);
            },

            _removeMeasureResult: function (graphicId) {
                //
                /* var gras=vertexGras;
                 console.log(gras);*/
                Array.forEach(vertexGras, function (graphic, iindex) {
                    //
                    var attributes = graphic.attributes;
                    if (attributes && attributes["id"] === graphicId) {
                        //
                        layer.remove(graphic);
                        //vertexGras.splice(iindex,1);
                    }
                });
            },
            _removeEventListeners: function () {
                if (mapClickHandler) {
                    //
                    mapClickHandler.remove();
                }
                if (layerClickHandler) {
                    //
                    layerClickHandler.remove();
                }
                if (mapDoubleClickHandler) {
                    //
                    mapDoubleClickHandler.remove();
                }
            },
            /**
             * <description>激活测量工具</description>
             * @ author: wangsl
             * @return void
             * */
            activate: function () {
                //
                if (this.isActive) {
                    this._removeEventListeners();
                }
                graphicId = "gra" + Math.floor(Math.random() * 500).toFixed(0);
                drawTool.activate(Draw.POLYLINE);
                this._createMeasureLayer(layerId);
                this._addEventListeners();
                //
                this.isActive = true;
            },
            /**
             * <description>释放测量工具</description>
             * @ author: wangsl
             * @return void
             * */
            deactivate: function () {

                this._removeEventListeners();
                this.isActive = false;
                if (layer) {
                    //
                    _map.removeLayer(layer);
                }
                vertexGras = [];
                drawTool.deactivate();
            },

            _measurePartLength: function (startGeo, endGeo) {

                var line = new Polyline(_map.spatialReference);
                var path = [];
                path.push(startGeo);
                path.push(endGeo);
                //
                line.addPath(path);
                var distance = this._calculateLength(line, 9001);
                return distance;
            },
            /**
             * 计算距离
             * */
            _calculateLength: function (geometry, unit) {
                //
                var distance = 0.0;
                var wkid = geometry.spatialReference.wkid;
                //
                if (wkid === 4326 || wkid === 102100 || wkid === 3857) {
                    //
                    distance = geometryEngine.geodesicLength(geometry, unit);
                } else if (wkid === 102113) {
                    //
                    var line4326 = webMercatorUtils.webMercatorToGeographic(geometry);
                    distance = geometryEngine.geodesicLength(line4326, unit);
                } else {
                    //
                    distance = geometryEngine.planarLength(geometry, unit);
                }
                return distance;
            },

            _createMeasureLayer: function (layerId) {
                //
                if (layerId) {
                    //
//                    debugger;
                    layer = _map.getLayer(layerId);
                    //
                    if (!layer) {
                        //
                        layer = new GraphicsLayer({id: layerId});
                        _map.addLayer(layer);
                    }
                }
            }

        });
        //
        return module;
        //
    });