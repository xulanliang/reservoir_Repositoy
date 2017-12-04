/**
 * <description>图层切换工具，可以放置在工具条控件中。</description>
 * @author wangsl
 * @date 2016/9/29
 */
define(["dojo/_base/declare", "./_BaseTool",
    "dojo/dom-construct",
    "dojo/_base/array",
    "dojo/string", "dojo/on", "dojo/dom",
    "dojo/_base/event"
], function (declare, _BaseTool, domConstruct, arrayUtils, string, on, dom, dojoEvent) {
    //
    return declare([_BaseTool], {
        //
        constructor: function (map) {
            this._init(map);
        },
        //
        _init: function (data) {
            //
            var self = this;
            //
            var layers = this.configData.baseMapLayers;
            //
            self._getVisibleLayerIndex = function () {
                ///
                var clickCount = 0;
                layers.forEach(function (cfg, iindex) {
                    //
                    if (cfg.initShow) {
                        //
                        clickCount = iindex + 1;
                    }
                });
                //
                return clickCount;
            };
            /**切换底图*/
            self._changeBaseLayer = function (type) {
                //
                $.each(self.map.layerIds, function (i, lId) {
                    //
                    if (self._isBaseLayer(lId)) {
                        //
                        // self.map.getLayer(lId).setVisibility(false);
                        self.map.getLayer(lId).hide();
                        /**
                         * 修复底图切换时，标签图层显示不正常
                         * @author wangsl
                         * @date 2017-05-24
                         * */
                        var lblLayer = self.map.getLayer(lId + "w");
                        //hide label layer.
                        if (lblLayer) {
                            // lblLayer.setVisibility(false);
                            lblLayer.hide();
                        }
                    }
                });
                //
                var vecLayer = this.map.getLayer(type);
                var labelLayer = this.map.getLayer(type + "w");
                //
                if (vecLayer) {
                    vecLayer.show();
                }
                if (labelLayer) {
                    labelLayer.show();
                }
            };
            //
            self._clickCount = self._getVisibleLayerIndex();
            //
            self._layers = layers;
            //
            self._createDropDownMenu = function (infos, domNode) {
                var panel = domConstruct.create("ul", {}, domNode);
                //
                var infoTemplate = "<label class='u-tool-img'  style='background: url(${icon}" + ") no-repeat left center;'>" + "${name}</label>";
                var self = this;
                arrayUtils.forEach(infos, function (cfg) {
                    /**
                     * <ul>
                     <li><label>栏目1->菜单1</label><span></span></li>
                     </ul>
                     * */
                    var info = string.substitute(infoTemplate, {
                        //
                        name: cfg.name,
                        icon: window.dseGisPath + cfg.img_src
                    });
                    var liNode = domConstruct.create("li", {
                        //
                        innerHTML: info
                    }, panel);
                    //
                    on(liNode, "click", function (event) {
                        //
                        //show drop down list panel.
                        if (self.delayTime) {
                            clearTimeout(self.delayTime);
                        }
                        // self.activate();
                        self._changeBaseLayer(cfg.id);
                        //change this dom node sate.
                        var newInfo = string.substitute(infoTemplate, {
                            name: cfg.name,
                            icon: window.dseGisPath + cfg.img_src
                        });
                        //
                        self.domNode.innerHTML = newInfo;
                        // console.log(cfg);
                        self.domNode.appendChild(panel);
                        //hide dropdown list.
                        $(panel).hide();
                    });
                    //
                });
                //show dropdown menu list.
                $(domNode).mouseover(function () {
                    self._isPanelVisible = true;
                    $(panel).show();
                });
                $(domNode).mouseout(function () {
                    $(panel).hide();
                    self._isPanelVisible = false;
                });
                return panel;
            };
        },
        //
        _isBaseLayer: function (layerId) {
            //
            var items = this._layers.filter(function (layer) {
                //
                return layer.id === layerId;
            });
            return items.length > 0 ? items[0] : null;
        },
        //
        _isFirstLoaded: true,
        _isPanelVisible: false,
        //
        setDomNode: function (domNode) {
            //
            this.inherited(arguments);
            if (this._isFirstLoaded) {
                //
                var panel = this._createDropDownMenu(this._layers, domNode);
                $(panel).show();
                this._isFirstLoaded = false;
                this.panel = panel;
            }
        },
        /**激活工具*/
        activate: function () {
            var panel = this.panel;
            if (this._isPanelVisible) {
                $(panel).hide();
                this._isPanelVisible = false;
            }
            else {
                $(panel).show();
                this._isPanelVisible = true;
            }
        },
        deactivate: function () {
            //
        }
    });
    //
});
//# sourceMappingURL=LayerSwitchTool.js.map