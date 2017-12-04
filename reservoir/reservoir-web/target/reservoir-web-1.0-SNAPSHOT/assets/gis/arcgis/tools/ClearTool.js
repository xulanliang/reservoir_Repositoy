/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare", "./_BaseTool"], function (declare, _BaseTool) {
    //
    //
    var _map = null;
    return declare([_BaseTool], {
        //
        constructor: function (map) {
            _map = map;
        },
        activate: function () {
            ///
            var layerIds = _map.graphicsLayerIds;
            //
            if (layerIds) {
                //
                layerIds.forEach(function (layerId) {
                    //
                    var graLayer = _map.getLayer(layerId);
                    graLayer.clear();
                });
            }
            /**
             * 2016-10-20 修改.
             * wangsl.
             * */
            _map.graphics.clear();
            //
            if (_map.infoWindow) {
                //
                _map.infoWindow.hide();
            }
        }
    });
});
//# sourceMappingURL=ClearTool.js.map