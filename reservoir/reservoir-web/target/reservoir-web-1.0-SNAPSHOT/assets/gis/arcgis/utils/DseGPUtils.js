/**
 * Created by Administrator on 2016/8/1.
 */
define([
    "dojo/_base/declare",
    "esri/geometry/Polygon",
    "esri/geometry/Point",
    "esri/geometry/Polyline",
    "esri/SpatialReference",
    "./dseSymbolUtils",
    "./dseGisUtils",
    "esri/graphic",
    "esri/tasks/Geoprocessor",
    "./dseGuidUtils",
    "dojo/request/xhr",
    "dojo/_base/lang",
    "esri/tasks/JobInfo",
    "./BaseMapUtils",
    "dojo/_base/array",
], function (declare, Polygon, Point, Polyline, SpatialReference, dseSymbolUtils, dseGisUtils, Graphic, Geoprocessor, dseGuidUtils, xhr, lang, JobInfo, BaseMapUtils, arrayUtils) {
    var _map = null;
    //
    var _gpTool = null;
    //
    var gpParams = {};
    //
    //
    var layerUtils = null;
    //
    var _urls = [];
    var _infoTask = null;
    /**
     * 当前执行分析的参数.
     * */
    var executeOptions = {};
    //
    var uuid = "";
    //
    // var paramType = "";
    //
    var mySelf = null;
    //
    return declare(null, {
        //
        constructor: function (options) {
            //
            _map = options.map;
            mySelf = this;
            this.mapType = options.mapType;
            //
            layerUtils = new BaseMapUtils(_map);
            //
            _urls = options.urls;
        },
        //
        _lastUrl: "",
        _getGpTool: function (url) {
            //
            if (!_gpTool) {
                //
                _gpTool = new Geoprocessor(url);
            }
            else {
                //
                if (this._lastUrl !== url) {
                    //当URL不同时，重新创建GP工具.
                    _gpTool = new Geoprocessor(url);
                    //
                }
            }
            this._lastUrl = url;
            //
            _gpTool.outSpatialReference = _map.spatialReference;
            return _gpTool;
        },
        /**
         * 创建线面.
         * */
        createDZXMResults: function (options) {
            // analystType = "dzm";
            //
            // paramType = "dzxm";
            executeOptions = options;
            // analystType = options.type;
            //
            //
            if (options.isProcess) {
                //
                this._executeDZXMAnalyst(executeOptions);
            }
            else {
                //
                this._handleCompleted(null);
            }
            //
        },
        //
        _executeDZXMAnalyst: function (options) {
            //
            var info = options;
            if (info.url) {
                //
                xhr(info.url, {
                    //
                    data: {
                        startTime: options.startTime,
                        endTime: options.endTime,
                        uuid: options.UUID
                    },
                    // query:info.params,
                    //
                    method: "POST",
                    handleAs: "json",
                    method: this.method,
                    headers: {
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    },
                }).then(lang.hitch(this, this._handleCompleted), lang.hitch(this, this._handleFxError));
            }
        },
        //删除当前等值线面分析数据
        _lastDelUrl: "",
        _delDzxmfxData: function (url) {
            if (!_infoTask) {
                //
                _infoTask = new QueryInfoTask(url, {
                    pieDataParser: function (data) {
                        return data;
                    },
                    columnDataParser: function (data) {
                        return data;
                    }
                });
            }
            else {
                //
                if (this._lastDelUrl !== url) {
                    //当URL不同时，重新创建GP工具.
                    //在框架中不允许存在业务代码.
                    // _infoTask  = new QueryInfoTask(baseUrl + "sysCommonCtrl/getStationInfo.do", {
                    //     pieDataParser: function (data) {
                    //         return data;
                    //     },
                    //     columnDataParser: function (data) {
                    //         return data;
                    //     }
                    // });
                }
            }
            this._lastDelUrl = url;
            //
            return _infoTask;
            //执行分析
        },
        //
        _handleCompleted: function (data) {
            //执行分析
            gpParams = this._getGpParamInfo(executeOptions.type);
            if (gpParams) {
                //
                _gpTool = this._getGpTool(gpParams.url);
                //
                _gpTool.submitJob(executeOptions.params, lang.hitch(this, this._parseGpAnalystResult), lang.hitch(this, this._handleGpStatus), lang.hitch(this, this._handleGpError));
            }
        },
        //
        _handleGpError: function (error) {
            //
            //
            console.log(error);
        },
        //
        _handleGpStatus: function (info) {
            //
        },
        _handleFxError: function (err) {
            //
            //
            console.log("analyst error in GpUtils.\n" + err.toString());
        },
        _parseGpAnalystResult: function (info) {
            console.log(info);
            //
            var jobId = info.jobId;
            var status = info.jobStatus;
            if (status === JobInfo.STATUS_SUCCEEDED) {
                if (executeOptions.result && executeOptions.result.length > 0) {
                    for (var i = 0; i < executeOptions.result.length; i++) {
                        if (executeOptions.result[i].resultType == 'image') {
                            this._displayResultAsLayer(jobId, executeOptions.result[i]);
                        }
                        else if (executeOptions.result[i].resultType === "vector") {
                            this._displayResultAsGeometries(jobId, executeOptions.result[i]);
                        }
                    }
                }
                // if (this._resultType === "image") {
                //     //返回图片
                //     this._displayResultAsLayer(jobId);
                // } else if (this._resultType === "vector") {
                //     //返回矢量
                //     this._displayResultAsGeometries(jobId);
                // }
            }
            // 分析完成后删除当前等值线面数据
            if (executeOptions.isClear) {
                //
                var params = {};
                // params.startTime = executeOptions.startTime;
                // params.endTime = executeOptions.endTime;
                params.uuid = executeOptions.params.UUID;
                params.jobId = jobId;
                //
                this._clearCacheData({
                    url: executeOptions.logUrl,
                    data: params
                });
            }
        },
        /**
         * 以矢量方式显示分析结果
         * */
        _displayResultAsGeometries: function (jobId, obj) {
            //
            // var ids = executeOptions.ids;
            // if (ids && ids.length > 0) {
            //     //
            //     var count = ids.length;
            //     //
            //     for (var i = 0; i < count; i++) {
            //         //
            var layerId = obj.id;
            _gpTool.getResultData(jobId, layerId, function (results) {
                //
                //
                var dzxGraLayer = layerUtils.addLayer({
                    type: "graphic",
                    id: layerId,
                    index: 1
                });
                //
                dzxGraLayer.isInLayerCtrl = true;
                dzxGraLayer.name = obj.layerName || layerId;
                dzxGraLayer.clear();
                var features = results.value.features;
                //
                if (features) {
                    //
                    features.forEach(function (feature) {
                        //
                        var counter = feature.attributes.CONTOUR;
                        if (counter) {
                            //
                            var sym = null;
                            if (mySelf.dzxSymbolCallBack) {
                                //
                                sym = mySelf.dzxSymbolCallBack(counter);
                            }
                            else {
                                //获取默认符号.
                                sym = dseSymbolUtils.createDzxSymbol(counter);
                            }
                            //
                            feature.setSymbol(sym);
                            dzxGraLayer.add(feature);
                        }
                    });
                }
            });
            //     }
            // }
        },
        /**以图片方式显示分析结果*/
        _displayResultAsLayer: function (jobId, obj) {
            //
            // var ids = executeOptions.ids;
            // if (ids && ids.length > 0) {
            //
            // var count = ids.length;
            // for (var i = 0; i < count; i++) {
            //
            // var layerId = ids[i];
            var layerId = obj.id;
            _gpTool.getResultImageLayer(jobId, undefined, null, function (gpLayer) {
                //
                var temp = _map.getLayer(layerId);
                if (temp) {
                    //
                    _map.removeLayer(temp);
                }
                //
                gpLayer.setOpacity(0.8);
                gpLayer.id = layerId;
                gpLayer.isInLayerCtrl = true;
                gpLayer.name = obj.layerName || layerId;
                _map.addLayer(gpLayer);
                // console.log(new Date().toString());
            });
            //     }
            // }
        },
        /**
         * 等值线符号
         * **/
        dzxSymbolCallBack: null,
        /**
         * 等值面符号
         * */
        dzmSymbolCallback: null,
        //
        _clearCacheData: function (options) {
            //
            if (options.url) {
                _infoTask = this._delDzxmfxData(options.url);
                _infoTask.loadAjaxData({
                    uuid: options.data.uuid
                }, function (pieData) {
                    //拼图数据
                }, function (columnData) {
                });
            }
        },
        _getGpParamInfo: function (type) {
            //
            var items = arrayUtils.filter(_urls, function (urlObj) {
                //
                return urlObj.type === type;
            });
            //
            return (items && items.length > 0) ? items[0] : null;
        }
    });
});
//# sourceMappingURL=DseGPUtils.js.map