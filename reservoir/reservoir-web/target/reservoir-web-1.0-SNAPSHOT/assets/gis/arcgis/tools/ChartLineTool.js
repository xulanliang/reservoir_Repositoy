/**
 * Created by Administrator on 2016/8/16.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../layers/EChartsLayer", "../demo/data/lineData"
], function (declare, _BaseTool, ChartsLayer, lineData) {
    //
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
                    id: "ecTwo",
                    map: _map,
                    charts: echarts
                });
                //
                var chartsContainer = ecLayer.getEchartsContainer();
                var myChart = ecLayer.initECharts(chartsContainer);
            }
            ecLayer.setOption(lineData);
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
//# sourceMappingURL=ChartLineTool.js.map