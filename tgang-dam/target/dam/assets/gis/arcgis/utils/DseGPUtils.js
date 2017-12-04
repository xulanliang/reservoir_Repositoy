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
    "dojo/_base/array"
    // "esri/layers/GraphicsLayer",

], function (declare, Polygon, Point, Polyline, SpatialReference, dseSymbolUtils, dseGisUtils, Graphic, Geoprocessor,
             dseGuidUtils, xhr, lang, JobInfo, BaseMapUtils, arrayUtils) {
    //

    //
    var _map = null;
    //
    var _gpTool = null;
    //
    // var _gpUrl = "";
    //
    //
    var analystType = "";
    //
    //
    // var gpConfig = null;
    //
    var gpParams = {};
    //
    var dzxGraLayer = null;

    var dzmGraLayer = null;

    var jptGraLayer = null;
    //
    var layerUtils = null;
    //
    var _urls = [];
    /**
     * 当前执行分析的参数.
     * */
    var executeOptions = {};

    //
    var uuid = "";
    //
    var paramType = "";
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
            //
            if (!_gpTool) {
                //
                _gpTool = new Geoprocessor(url);
            } else {
                //
                if (this._lastUrl !== url) {
                    //当URL不同时，重新创建GP工具.
                    _gpTool = new Geoprocessor(url);
                }
            }
            this._lastUrl = url;
            return _gpTool;
        },
        /**
         * 创建线面.
         * */
        createDZXMResults: function (options) {
            //
            // analystType = "dzm";
            //
            paramType = "dzxm";
            executeOptions = options;
            analystType = options.type;
            //
            if(options.isProcess){
                //
                this._executeDZXMAnalyst(executeOptions);
            }else{
                //
                this._handleCompleted(null);
            }
            //
            // this._clearCacheData(options.cacheUrl,options);
        },
        /**
         * 创建距平图
         * */
        createJPTResults: function (options) {
            //
            paramType = "jpt";
            analystType = options.type;
            executeOptions = options;
            // this._executeJPTAnalyst(options);
        },
        //
        _executeDZXMAnalyst: function (options) {
            //
            var info = options;
            //
            uuid = dseGuidUtils.uuid();

            if (info.url) {
                //
                xhr(info.url, {
                    //
                    data: {
                        startTime: options.startTime,
                        endTime: options.endTime,
                        uuid: uuid
                    },
                    // query:info.params,
                    //
                    method: "POST",
                    handleAs: "text"
                }).then(
                    lang.hitch(this, this._handleCompleted),
                    lang.hitch(this, this._handleFxError)
                );
            }

        },
        _executeJPTAnalyst: function (options) {
            //
            var info = options;
            //
            uuid = dseGuidUtils.uuid();

            if (info.url) {
                //
                xhr(info.url, {
                    //
                    method: "POST",
                    handleAs: "text"
                }).then(
                    lang.hitch(this, this._handleCompleted),
                    lang.hitch(this, this._handleFxError)
                );
            }
        },
        //
        _handleCompleted: function (data) {
            //执行分析
            gpParams = this._getGpParamInfo(paramType);
            //
            _gpTool = this._getGpTool(gpParams.url);
            //
            gpParams.params.Expression = "QUERYID='" + uuid + "'";
            //
            _gpTool.submitJob(gpParams.params,
                lang.hitch(this, this._parseGpAnalystResult),
                lang.hitch(this, this._handleGpStatus),
                lang.hitch(this, this._handleGpError));
        },
        //
        _handleGpError: function (error) {
            //
            // debugger;
            console.log(error);
        },
        //
        _handleGpStatus: function (info) {
            //

        },

        _handleFxError: function (err) {
            //
            // debugger;
            console.log("analyst error in GpUtils.\n" + err.toString());
        },
        _parseGpAnalystResult: function (info) {
            //
            var jobId = info.jobId;
            var status = info.jobStatus;

            if (status === JobInfo.STATUS_SUCCEEDED) {
                //成功之后，将其中的结果取出来，当然这也是参数名字。
                //在模型中，想要取出中间结果，需要设置为模型参数
                //获取等值面
                if (analystType === "dzm") {
                    //
                    _gpTool.getResultData(jobId, "RasterT_Reclass2_shp", lang.hitch(this, this._addDZMResults));
                } else if (analystType === "dzx") {
                    //获取等值线
                    _gpTool.getResultData(jobId, "dzxout", lang.hitch(this, this._addDZXResults));
                } else if (analystType === "jpt") {
                    //
                } else {
                    //
                    _gpTool.getResultData(jobId, "RasterT_Reclass2_shp", lang.hitch(this, this._addJPTResults));
                }
                //等值线面生成成功
                // 分析成功后删除等值线面数据，并添加等值线面日志DSE_ST_PPTN_R_DZ_LOG
                if(executeOptions.isClear){
                    //
                    var params = gpParams.params;
                    params.startTime = executeOptions.startTime;
                    params.endTime = executeOptions.endTime;
                    params.uuid = uuid;
                    params.jobId = jobId;
                    //
                    this._clearCacheData({
                        url: executeOptions.logUrl,
                        data: params
                    });
                }

            }
        },

        /**
         * 显示等值线信息
         * */
        _addDZXResults: function (results) {
            //
            dzxGraLayer = layerUtils.addLayer({
                type: "graphic",
                id: "dse_g_dzx_layer",
                index: 1
            });
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
                        var sym=null;
                        if(mySelf.dzxSymbolCallBack){
                            //
                            sym=mySelf.dzxSymbolCallBack(counter);
                        }else {
                            //获取默认符号.
                            sym = dseSymbolUtils.createDzxSymbol(counter);
                        }
                        //
                        feature.setSymbol(sym);
                        dzxGraLayer.add(feature);
                    }
                });
            }
        },
        /**
         * 等值线符号
         * **/
        dzxSymbolCallBack: null,
        /**
         * 等值面符号
         * */
        dzmSymbolCallback: null,

        /**
         * 显示等值面信息
         * */
        _addDZMResults: function (results) {
            //
            dzmGraLayer = layerUtils.addLayer({
                type: "graphic",
                id: "dse_g_dzm_layer",
                index: 0
            });

            dzmGraLayer.clear();

            var features = results.value.features;
            arrayUtils.forEach(features, function (feature) {
                //
                //
                var counter = feature.attributes.GRIDCODE;
                if (counter) {
                    //
                    var sym = null;
                    if (mySelf.dzmSymbolCallback) {
                        //
                        sym = mySelf.dzmSymbolCallback(feature.attributes.GRIDCODE)
                    }else {
                        //获取默认符号.
                        dseSymbolUtils.createDzmSymbol(feature.attributes.GRIDCODE);
                    }
                    // dseSymbolUtils.createDzmSymbol(feature.attributes.GRIDCODE);
                    feature.setSymbol(sym);
                    //
                    dzmGraLayer.add(feature);
                }
            });
        },

        _addJPTResults: function (data) {
            //
            jptGraLayer = layerUtils.addLayer({
                type: "graphic",
                id: "dse_g_jpt_layer"
            });
            jptGraLayer.clear();
            //处理距平图结果.
        },
        //
        _clearCacheData: function (options) {
            //
            if (options.url) {
                //
                xhr(options.url, {
                    //
                    handleAs: "text",
                    method: "POST",
                    data: JSON.stringify(options.data)
                }).then(
                    function (data) {

                    },
                    function (error) {
                        //
                    }
                );
            }
        },

        _getGpParamInfo: function (type) {
            //
            var items = arrayUtils.filter(_urls, function (urlObj) {
                //
                return urlObj.type === type;
            });
            //
            return items[0];
        }

    });

});