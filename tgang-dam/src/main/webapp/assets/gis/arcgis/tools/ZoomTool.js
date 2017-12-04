/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare",
    "esri/toolbars/navigation"], function (declare, Navigation) {
    //
    var navTool = null;
    var _map = null;
    //
    var zoomLevel = null;
    return declare(null, {
        //
        constructor: function (options) {
            //
            _map = options.map;
            zoomLevel = options.zoomLevel || 4;
        },
        zoomIn: function () {
            //
            if (zoomLevel >= 0) {
                //
                zoomLevel = _map.getLevel() || zoomLevel;
                zoomLevel++;
                _map.setZoom(zoomLevel);
            }
        },
        zoomOut: function () {
            //
            if (zoomLevel > 0) {
                //
                zoomLevel = _map.getLevel() || zoomLevel;
                zoomLevel--;
                _map.setZoom(zoomLevel);
            }

        }

    });
});