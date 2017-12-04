/**
 * <description>图层切换工具，可以放置在工具条控件中。</description>
 * @author wangsl
 * @date 2016/9/29
 */
define(["dojo/_base/declare", "./_BaseTool"

], function (declare, _BaseTool) {
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
                //
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
                    self.map.getLayer(lId).setVisibility(false);
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
        },
        /**激活工具*/
        activate: function () {
            ///
            if (this._clickCount === this._layers.length) {
                //
                this._clickCount = 0;
            }
            //
            var cfg = this._layers[this._clickCount];
            //
            this._changeBaseLayer(cfg.id);
            this.domNode.getElementsByTagName("label")[0].innerHTML = cfg.name;
            //
            this._clickCount++;

        },
        deactivate: function () {
            //

        }
    });
    //

});