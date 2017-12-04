define(['dojo/_base/declare'], function (declare) {
    //

    var mo = (function () {
        //
        /*************以下是wgs84与百度坐标系的转换（请直接调用bd09_To_Gps84，Gps84_To_bd09）******************/
        /**
         * wgs84 to 火星坐标系 (GCJ-02)
         * @param lat 经度
         * @param lon 纬度
         * @returns {Array}
         */
            //
        var pi = Math.PI;

        var ee = 0.00669342162296594323, a = 6378245.0;

        function gps84_To_Gcj02(lat, lon) {
            lat = parseFloat(lat);
            lat = parseFloat(lon);
            var dLat = transformLat(lon - 105.0, lat - 35.0);
            var dLon = transformLon(lon - 105.0, lat - 35.0);
            var radLat = lat / 180.0 * Math.PI;
            var magic = Math.sin(radLat);
            magic = 1 - ee * magic * magic;
            var sqrtMagic = Math.sqrt(magic);
            dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
            dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
            var mgLat = lat + dLat;
            var mgLon = lon + dLon;
            return [mgLat, mgLon];
        }

        /**
         * * 火星坐标系 (GCJ-02) to 84
         *  @param 纬度
         *  @param 经度
         *  @return
         * */
        function gcj_To_Gps84(lat, lon) {
            var Wgs = transform(lat, lon);
            var lontitude = lon * 2 - Wgs[1];
            var latitude = lat * 2 - Wgs[0];
            return [latitude, lontitude];
        }

        /**
         * 火星坐标系 (GCJ-02) 转百度坐标系 (BD-09) 的转换算法
         * @param 纬度
         * @param 经度
         */
        function gcj02_To_Bd09(gg_lat, gg_lon) {
            var x = gg_lon;
            var y = gg_lat;
            var z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
            var theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
            var bd_lon = z * Math.cos(theta) + 0.0065;
            var bd_lat = z * Math.sin(theta) + 0.006;
            return [bd_lat, bd_lon];
        }

        /**
         * 将 BD-09 坐标转换成GCJ-02 坐标
         * @param bd_lat
         * @param bd_lon
         * @return
         */
        function bd09_To_Gcj02(bd_lat, bd_lon) {
            bd_lat = parseFloat(bd_lat);
            bd_lon = parseFloat(bd_lon);
            var x = bd_lon - 0.0065;
            var y = bd_lat - 0.006;
            var z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
            var theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);
            var gg_lon = z * Math.cos(theta);
            var gg_lat = z * Math.sin(theta);
            return [gg_lat, gg_lon];
        }

        function transformLat(x, y) {
            var ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
            ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
            ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
            ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
            return ret;
        }

        function transformLon(x, y) {
            x = parseFloat(x);
            y = parseFloat(y);
            var ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
            ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
            ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
            ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
            return ret;
        }

        function transform(lat, lon) {
            lat = parseFloat(lat);
            lon = parseFloat(lon);
            var dLat = transformLat(lon - 105.0, lat - 35.0);
            var dLon = transformLon(lon - 105.0, lat - 35.0);
            var radLat = lat / 180.0 * pi;
            var magic = Math.sin(radLat);
            magic = 1 - ee * magic * magic;
            var sqrtMagic = Math.sqrt(magic);
            dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
            dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
            var mgLat = lat + dLat;
            var mgLon = lon + dLon;
            return [mgLat, mgLon];
        }

        /*************是wgs84与百度坐标系的转换（请直接调用bd09_To_Gps84，Gps84_To_bd09）end***************/

        return {
            /**
             * 根据面的x,y;x,y....返回创建线,面的数组
             * maptype:投影参数（1：经度坐标系；2：平面坐标系，3：百度坐标系）
             */
            getLineDate: function (xy, maptype) {
                if (xy) {
                    var arrP;
                    var arrPALL = new Array();
                    var arr = xy.split("/"); //开始解析坐标点
                    for (var n = 0; n < arr.length; n++) {
                        if (arr[n] != null && arr[n] != "") {
                            arrP = new Array();
                            var arr2 = arr[n].toString().split(";");
                            for (var k = 0; k < arr2.length; k++) //分别读取坐标组
                            {
                                if (arr2[k] != null && arr2[k] != null) {
                                    var arr3 = arr2[k].toString().split(",");
                                    if (arr3[0] != null && arr3[0] != "" && arr3[1] != null && arr3[1] != "") {
                                        arr3 = this.WgsToDqzb(arr3[0], arr3[1], maptype);//将经纬度转换成当前使用的坐标系
                                        arrP.push(arr3);
                                    }
                                }
                            }
                            arrPALL.push(arrP);
                        }
                    }
                    //Rings.rings=arrPALL;
                    return arrPALL;
                }
            },
            /**
             * WGS84转web墨卡托
             * @param lgtd 经度
             * @returns {Number}
             */
            lonMercator: function (lgtd) {
                var x = lgtd * 20037508.342789 / 180;
                return x;
            },
            /**
             * WGS84转web墨卡托
             * @param lttd 纬度
             * @returns {Number}
             */
            LatMercator: function (lttd) {
                lttd = parseFloat(lttd);
                var _y = Math.log(Math.tan((90 + lttd) * Math.PI / 360)) / (Math.PI / 180);
                var y = _y * 20037508.34789 / 180;
                return y;
            },
            /**
             * web墨卡托转WGS84
             * @param x
             */
            Mercatorlon: function (x) {
                var _x = x / 20037508.34 * 180;
                return _x;
            },
            /**
             * web墨卡托转WGS84
             * @param y
             * @returns {Number}
             */
            MercatorLat: function (y) {
                var _y = y / 20037508.34 * 180;
                _y = 180 / Math.PI * (2 * Math.atan(Math.exp(_y * Math.PI / 180)) - Math.PI / 2);
                return _y;
            },
            /**
             * 百度坐标系(BD-09)-->wgs84
             * @param 纬度
             * @param 经度
             * @return
             */
            bd09_To_Gps84: function (bd_lat, bd_lon) {
                var gcj02 = bd09_To_Gcj02(bd_lat, bd_lon);//百度转火星坐标系
                return gcj_To_Gps84(gcj02[0], gcj02[1]);//火星转wgs84

            },
            /**
             * wgs84-->百度坐标系(BD-09)
             * @param 纬度
             * @param 经度
             * @return
             */
            Gps84_To_bd09: function (lat, lon) {
                var gcj02 = gps84_To_Gcj02(lat, lon);//wgs84转火星坐标系
                return gcj02_To_Bd09(gcj02[0], gcj02[1]);//火星转百度坐标系

            },
            /**
             * 坐标转换,wgs84转当前投影坐标系（1：经度坐标系；2：平面坐标系，3：百度坐标系）
             * maptype:gis_config配置文件里的常量
             * @param x,y,maptype
             */
            WgsToDqzb: function (x, y, maptype) {
                var xys = [];
                maptype = parseInt(maptype);
                switch (maptype) {
                    case 1:
                        xys = [x, y];
                        break;
                    case 2:
                        x = this.lonMercator(x);
                        y = this.LatMercator(y);
                        xys = [x, y];
                        break;
                    case 3:
                        xys = this.Gps84_To_bd09(x, y);
                        break;
                }
                return xys;
            },
            /**
             * 坐标转换,当前投影坐标系转wgs84（1：经度坐标系；2：平面坐标系，3：百度坐标系）
             * maptype:gis_config配置文件里的常量
             * @param x,y,maptype
             */
            DqzbToWgs: function (x, y, maptype) {
                var xys = [];
                maptype = parseInt(maptype);
                switch (maptype) {
                    case 1:
                        xys = [x, y];
                        break;
                    case 2:
                        x = this.Mercatorlon(x);
                        y = this.MercatorLat(y);
                        xys = [x, y];
                        break;
                    case 3:
                        xys = this.bd09_To_Gps84(x, y);
                        break;
                }
                return xys;
            },
            /**
             * 坐标转换,Mercator转当前投影坐标系（1：经度坐标系；2：平面坐标系，3：百度坐标系）
             * maptype:gis_config配置文件里的常量 ;
             * @param x,y,maptype
             */
            MctToDqzb: function (x, y, maptype) {
                var xys = [];
                maptype = parseInt(maptype);
                switch (maptype) {
                    case 1:
                        x = this.Mercatorlon(x);
                        y = this.MercatorLat(y);
                        xys = [x, y];
                        break;
                    case 2:
                        xys = [x, y];
                        break;
                    case 3:
                        x = this.Mercatorlon(x);
                        y = this.MercatorLat(y);
                        xys = this.Gps84_To_bd09(x, y);
                        break;
                }
                return xys;
            },
            /**
             * 坐标转换,当前投影坐标系转Mercator（1：经度坐标系；2：平面坐标系，3：百度坐标系）
             * maptype:gis_config配置文件里的常量
             * @param x,y,maptype
             */
            DqzbToMct: function (x, y, maptype) {
                var xys = [];
                maptype = parseInt(maptype);
                switch (maptype) {
                    case 1:
                        x = this.lonMercator(x);
                        y = this.LatMercator(y);
                        xys = [x, y];
                        break;
                    case 2:
                        xys = [x, y];
                        break;
                    case 3:
                        xys = this.bd09_To_Gps84(x, y);
                        x = this.lonMercator(xys[0]);
                        y = this.LatMercator(xys[1]);
                        xys = [x, y];
                        break;
                }
                return xys;
            },
            nullToSpace: function (v) {
                if (v != 0 && (v == null || v == "" || v == 'null')) {
                    return "";
                }
                return v;
            },
            /**
             * 求图形中心
             **/
            getGeomCenter: function (graphic) {
                if (graphic) {
                    var point = "";
                    switch (graphic.geometry.type) {
                        case "point":
                            point = graphic.geometry;
                            break;
                        case "polyline":
                            var pl = graphic.geometry;
                            var pathCount = pl.paths.length;
                            var pathIndex = Math.ceil(pathCount / 2) - 1;
                            var midPath = pl.paths[pathIndex];
                            var ptCount = midPath.length;
                            var ptIndex = Math.ceil(ptCount / 2) - 1;
                            point = pl.getPoint(pathIndex, ptIndex);
                            break;
                        case "polygon":
                            var poly = graphic.geometry;
                            point = poly.getExtent().getCenter();
                            break;
                    }
                    return point;
                }
            }
        };
    })();
    //
    return mo;
});