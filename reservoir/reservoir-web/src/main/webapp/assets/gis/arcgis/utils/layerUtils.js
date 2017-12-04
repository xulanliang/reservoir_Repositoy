/**
 * Created by Administrator on 2016/12/21.
 */
define([], function () {
    //
    return {
        /**设置QueryDisplayLayer的图例配置信息*/
        addLayerLegend: function (layer, cfg) {
            if (layer && cfg) {
                layer.setLayerTips(cfg.tips);
                layer.setLayerTemplate(cfg.template);
                layer.setSymbolCallBack(cfg.symbolCallBack);
                layer.setTipsCallBack(cfg.tipsCallBack);
            }
        }
    };
});
//# sourceMappingURL=layerUtils.js.map