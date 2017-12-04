/**
 * Created by Administrator on 2016/7/28.
 */
define(["dojo/_base/declare",
        //
        "dojo/string",
        "esri/layers/TiledMapServiceLayer", "esri/SpatialReference",
        "esri/geometry/Extent", "esri/layers/TileInfo"],
    function (declare, string, TiledMapServiceLayer, SpatialReference, Extent, TileInfo) {
        //
        var baseUrl = "";
        //
        var _lodInfos = [];
        //
        var _self = null;
        //
        var _initInfo = [];
        var _fullInfo = [];
        return declare([TiledMapServiceLayer], {
            constructor: function (url, options) {
                //
                baseUrl = url;
                _self = this;
                //
                this.id = options.id || (Math.random() * 10000).toFixed(0);
                this.visible = options.visible;
                _initInfo = options.initExtent || [];
                _fullInfo = options.fullExtent || [];
                // _extentInfos=options.extent||[10597843.136,2392038.998,11982199.192,3429912.309];
                //
                if (baseUrl) {
                    //
                    this._parseConfigData(baseUrl + "/conf.xml");
                }

            },
            //
            _parseConfigData: function (configUrl) {
                //
                $.get(configUrl, function (data) {
                    //获取Tile Cache Info.
                    // get dpi
                    $(data).find("LODInfo").each(function () {
                        // 2
                        var field = $(this);
                        var level = field.find("LevelID").text();//读取子节点的值
                        var scale = field.find("Scale").text();
                        var resolution = field.find("Resolution").text();

                        _lodInfos.push({
                            "level": parseInt(level),
                            "resolution": parseFloat(resolution),
                            "scale": parseFloat(scale)
                        });
                    });
                    var rows = $(data).find("TileRows").text();
                    var cols = $(data).find("TileCols").text();
                    var dpi = $(data).find("DPI").text();
                    //
                    var tileX = $(data).find("X").text();
                    var tileY = $(data).find("Y").text();
                    var wkid = $(data).find("WKID").text();
                    //
                    var wkt = $(data).find("WKT").text();
                    if (wkid) {
                        //
                        _self.spatialReference = new SpatialReference({
                            wkid: parseInt(wkid)
                        });
                    } else {
                        // 如果不存在wkid，则使用wkt
                        if (wkt) {
                            //
                            _self.spatialReference = new SpatialReference({
                                wkt: wkt
                            });
                        }
                    }
                    // _self.initialExtent = _self.fullExtent = null;
                    //
                    _self.initialExtent = _self._createExtent(_initInfo);
                    _self.fullExtent = _self._createExtent(_fullInfo);
                    //
                    _self.tileInfo = new TileInfo({
                        "rows": parseInt(rows),
                        "cols": parseInt(cols),
                        "compressionQuality": parseInt(dpi),
                        "origin": {
                            "x": parseFloat(tileX),
                            "y": parseFloat(tileY)
                        },
                        "spatialReference": _self.spatialReference,
                        "lods": _lodInfos
                    });
                    _self.loaded = true;
                    _self.onLoad(_self);
                    //
                });
            },
            //
            getTileUrl: function (level, row, col) {
                //
                var url = baseUrl + "/_alllayers"
                    + "/L" + string.pad(level.toString(), 2, "0")
                    + "/R" + string.pad(row.toString(16), 8, "0")
                    + "/C" + string.pad(col.toString(16), 8, "0") + ".png";
                return url;
            },
            //
            _createExtent: function (infos) {
                //
                var extent = null;
                if (infos.length >= 4) {
                    //
                    extent = new Extent(infos[0], infos[1], infos[2], infos[3], _self.spatialReference);
                }
                return extent;
            }
        });
    });