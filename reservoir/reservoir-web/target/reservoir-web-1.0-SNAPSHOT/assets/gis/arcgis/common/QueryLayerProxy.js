/**
 * <description>图层组代理类.</description>
 * @date 2016-12-03
 * @author wangsl
 *
 */
//
define([
    "dojo/_base/declare",
    "dojo/request/xhr",
    "dojo/json",
    "dojo/_base/lang",
    "dojo/dom",
    "dojo/dom-style",
    "dojo/dom-construct",
    "esri/domUtils"
], function (declare, xhr, JSON, lang, dom, domStyle, domConstruct, domUtils) {
    //
    var moClass = declare(null, {
        /**
         * constructor.
         * */
        constructor: function (options) {
            //
            this.__init(options);
            this.cacheLayerData = {};
            //
            this.tempCacheData = {};
            /**
             * {
             *  subGroup:[ids],
             *  subGroup:[ids]
             * }
             * */
            this.subGroupIds = {};
            this.tipsCacheData = {};
            // proxy layer config. example .hdConfig.
            // this.layerConfig = {};
        },
        //
        setKeyField: function (field /**Required*/) {
            //
            this.keyField = field;
        },
        /**添加数据*/
        addCacheData: function (dataArray, groupKey, keyField) {
            //
            if (dataArray && dataArray.length > 0) {
                var cacheData = this.cacheLayerData;
                var subGroups = this.subGroupIds;
                //
                if (!subGroups.hasOwnProperty(groupKey)) {
                    //
                    subGroups[groupKey] = [];
                }
                dataArray.forEach(function (d) {
                    //
                    var dataKey = d[keyField];
                    //
                    if (cacheData.hasOwnProperty(dataKey)) {
                        // exits.
                        d.isShared = true;
                        if (!d.shareGroup) {
                            d.shareGroup = {};
                            d.shareGroup[groupKey] = "share";
                        }
                    }
                    cacheData[dataKey] = d;
                    subGroups[groupKey].push(dataKey);
                });
                //
                this.tempCacheData[groupKey] = dataArray;
            }
        },
        /**删除数据.*/
        removeCacheData: function (cacheKey) {
            var subGroups = this.subGroupIds[cacheKey];
            var self = this;
            //
            if (subGroups && subGroups.length > 0) {
                //
                subGroups.forEach(function (subKey) {
                    //
                    var da = self.cacheLayerData[subKey];
                    if (!da.isShared) {
                        delete self.cacheLayerData[subKey];
                    }
                    else {
                        //
                        delete da.shareGroup[cacheKey];
                        if (self.isEmptyObject(da.shareGroup)) {
                            delete self.cacheLayerData[cacheKey];
                        }
                    }
                });
                //
                delete this.subGroupIds[cacheKey];
            }
        },
        //
        addTipsData: function (tipsKey, data) {
            //
            if (!this.hasOwnProperty(tipsKey)) {
                this.tipsCacheData[tipsKey] = data;
            }
        },
        /**清除临时数据.*/
        clearTempCache: function (cachekey) {
            //
            delete this.tempCacheData[cachekey];
        },
        //
        isEmptyObject: function (data) {
            var state = true;
            for (var key in data) {
                state = false;
                break;
            }
            return state;
        },
        /**获取数据.*/
        createMergedData: function () {
            var result = [];
            var cacheData = this.cacheLayerData;
            for (var dk in cacheData) {
                //
                result.push(cacheData[dk]);
            }
            return result;
        },
        //
        //
        changeShareDataState: function (data) {
            //
        },
        __init: function (options) {
            var _self = this;
            var proxyLayer = null;
            //
            lang.mixin(this, options);
            //
            var appEvent = this.appEvent;
            //
            if (appEvent) {
                //
                appEvent.addAppEventListener(appEvent.GROUP_LAYER_CHANGE, function (data) {
                    //
                    var groupId = data.group.groupId;
                    //
                    proxyLayer = data.layer;
                    //
                    proxyLayer.clear();
                    if (data.layerItem.checked) {
                        // layer visible
                        //
                        var tempData = _self.tempCacheData[groupId];
                        _self.addCacheData(tempData, groupId, _self.keyField);
                    }
                    else {
                        // layer hide.
                        _self.removeCacheData(groupId);
                    }
                    //
                    //
                    var dataArray = _self.createMergedData();
                    var layerOpt = {};
                    _self.addGroupLayerData(dataArray, layerOpt);
                });
            }
            _self.setProxyLayer = function (layer) {
                //
                proxyLayer = layer;
                //
                /*proxyLayer._layerClickHandler = function (event) {
                 //
                 var groupId = event.graphic.attributes["groupId"];
                 //
                 alert(groupId);

                 };
                 proxyLayer._layerMouseOverHandler = function (event) {
                 //
                 };
                 proxyLayer._layerMouseOverHandler = function (event) {
                 //
                 };*/
            };
            /**添加图层组图例信息.*/
            _self.addLayerLegend = function (uiData, cfg) {
                /*cfg.layerItem = uiData.layerItem;
                 cfg.isCanLoaded = uiData.isCanLoaded;*/
                //
                // uiData.layerItem.checked = !cfg.initShow;
                //
                if (uiData) {
                    //
                    appEvent.dispatchAppEvent(appEvent.LEGEND_STATE_CHANGE, {
                        layer: cfg,
                        layerItem: uiData.layerItem,
                        isCanLoaded: uiData.isCanLoaded
                    });
                }
                //
                // this.layerConfig = cfg;
                if (proxyLayer) {
                    //
                    proxyLayer.setLayerTips(cfg.tips);
                    proxyLayer.setLayerTemplate(cfg.template);
                    proxyLayer.setSymbolCallBack(cfg.symbolCallBack);
                    proxyLayer.setTipsCallBack(cfg.tipsCallBack);
                    //
                    proxyLayer.setLayerLabels(cfg.labels);
                    //
                    this.addTipsData(cfg.keyField, cfg.tips);
                    //
                    cfg.mergedTips = this.tipsCacheData;
                }
            };
            /**
             * <p>设置查询图层主要属性.向图层中附加配置信息</p>
             * @author wangsl
             * @date 2017-03-23
             * */
            _self.addLayerConfig = function (cfg) {
                //
                if (proxyLayer) {
                    //set layer properties.
                    proxyLayer.setLayerTips(cfg.tips);
                    proxyLayer.setLayerTemplate(cfg.template);
                    proxyLayer.setLayerLabels(cfg.labels);
                    // set call backs.
                    proxyLayer.setSymbolCallBack(cfg.symbolCallBack);
                    proxyLayer.setTipsCallBack(cfg.tipsCallBack);
                    proxyLayer.setTemplateCallBack(cfg.templateCallBack);
                    proxyLayer.setLabelsCallBack(cfg.labelsCallBack);
                }
            };
            //
            _self._convertArrayToObject = function (sources, keyField) {
                //
                var mapData = {};
                if (sources && sources.length > 0) {
                    //
                    var sc = sources.length;
                    for (var i = 0; i < sc; i++) {
                        //
                        var g = sources[i];
                        var attributes = g.attributes;
                        var mapKey = attributes[keyField];
                        mapData[mapKey] = g;
                    }
                }
                //
                return mapData;
            };
            //
            _self.saveCacheData = function () {
                //
                var results = [];
                var gs = _self.graphics;
                if (gs && gs.length > 0) {
                    //
                    gs.forEach(function (g) {
                        //
                        results.push(g);
                    });
                }
                return results;
            };
            _self.restoreCacheData = function (gs) {
                //
                _self.clear();
                if (gs && gs.length > 0) {
                    gs.forEach(function (g) {
                        _self.add(g);
                    });
                }
            };
            /** cache data.*/
            _self._cacheData = {};
            //
            _self.groupStates = {};
            //
            /**
             *
             * 子图层缓存.
             * {
             *   "PP":[],
             *   "SS":[],
             *   "ZQ":[]
             * }
             * */
            _self._groupCacheData = {};
            //
            _self.clearCacheDataById = function (graphics, keyField) {
                //
                // for
                var cacheData = this._cacheData;
                var graphics = graphics || [];
                //
                if (graphics.length > 0) {
                    //
                    graphics.forEach(function (gra) {
                        //
                        var attributes = gra.attributes;
                        var keyValue = attributes[keyField];
                        if (keyValue in cacheData) {
                            //
                            delete cacheData[keyValue];
                        }
                    });
                }
            };
            //
            _self.queryGroupGraphics = function (keyValue, keyField) {
                //
                var sources = [].concat(this.graphics);
                return sources.filter(function (source) {
                    //
                    return source.attributes[keyField] === keyValue;
                });
            };
            /**hide group graphics in one layer.*/
            _self.hideGroupGraphics = function (groupId, keyField) {
                //
                var sources = [].concat(this.graphics);
                //
                if (sources.length > 0) {
                    //
                    sources.forEach(function (source) {
                        //
                        var attributes = source.attributes;
                        //
                        var keyValue = attributes[keyField];
                        //
                        if (groupId === keyValue) {
                            //
                            _self.remove(source);
                        }
                    });
                    //remove layer tips key field.
                    delete _self.groupStates[groupId];
                }
            };
            //
            _self.showGroupData = function (options) {
                //
                var dataArray = this.createMergedData();
                //
                proxyLayer.loadData(dataArray, false);
            };
            //
            _self.addGroupLayerData = function (data, options) {
                //
                proxyLayer.loadData(data, false);
            };
            //
        },
        //
        /**show group graphics in one layer.*/
        showGroupGraphics: function (group) {
            //
        },
        //
        clearData: function (cacheKey) {
            //
            this.removeCacheData(cacheKey);
            this.clearTempCache(cacheKey);
        },
    });
    //
    return moClass;
});
//# sourceMappingURL=QueryLayerProxy.js.map