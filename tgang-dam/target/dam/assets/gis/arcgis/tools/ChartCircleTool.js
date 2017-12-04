/**
 * Created by Administrator on 2016/8/16.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../layers/EChartsLayer", "../demo/data/circleData"

], function (declare, _BaseTool, ChartsLayer, circleData) {
    //
    var _map = null;
    //
    var ecLayer = null;
    return declare([_BaseTool], {
        //
        constructor: function (map) {
            _map = map;
        },

        activate: function () {
            ///
            //
            if (!ecLayer) {
                //
                ecLayer = new ChartsLayer("", {
                    //
                    id: "ecOne",
                    map: _map,
                    charts: echarts
                });
                //
                var chartsContainer = ecLayer.getEchartsContainer();
                var myChart = ecLayer.initECharts(chartsContainer);
            }
            ecLayer.setOption(circleData);

        },
        deactivate: function () {
            //
            if (ecLayer) {
                //
                ecLayer.remove();
            }
            ecLayer = null;
        }
    });
    //

});