/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare", "dojo/on", "dojo/dom",
    "../utils/dseGisUtils", "dojo/dom-construct",
], function (declare, on, dom, dseGisUtils, domConstruct) {
    //
    // var dseMap = null;
    //
    // var mapType = null;
    return declare(null, {
        //
        constructor: function (options) {
            //
            this._dseMap = options.map;
            this._mapType = options.type;
            this._init(options);
        },
        _init: function (options) {
            //
            var self = this;
            //
            //
            self.init = function (style) {
                ////
                var mapLabel = domConstruct.create("div", {
                    //
                    class: style
                }, dom.byId(self._dseMap.id));
                //
                //
                self._dseMap.on("mouse-move", function (event) {
                    //
                    var mp = event.mapPoint;
                    var mps = dseGisUtils.DqzbToWgs(mp.x, mp.y, self._mapType);
                    //
                    mapLabel.innerHTML = "经度：" + Number(mps[0]).toFixed(4) + "   纬度：" + Number(mps[1]).toFixed(4);
                });
                //
                /*$("#" + self._dseMap.id).append('<div id="maplable" class="'+style+'"></div>');
                 self._dseMap.on("mouse-move", function (evt) {

                 });*/
            };
            //
        }
    });
    //
});
//# sourceMappingURL=MapLabelControl.js.map