/**
 * Created by Administrator on 2016/9/26.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../layers/EChartsNormalLayer", "../demo/data/coms"
], function (declare, _BaseTool, ChartsLayer, pieChartData) {
    //
    //
    var _map = null;
    //
    var ecLayer = null;
    return declare([_BaseTool], {
        //
        constructor: function (map) {
            _map = map;
            this._init();
        },
        //
        _init: function () {
            //
            var self = this;
            //
            //
            self.setData = function (data) {
                //
                self._chartData = data;
            };
        },
        activate: function () {
            ///
            //
            if (!ecLayer) {
                //
                ecLayer = new ChartsLayer("", {
                    //
                    id: "ecFiv2",
                    map: _map,
                    charts: echarts
                });
                //
                ecLayer.setPieSize(400, 260);
                //
            }
            if (this._chartData) {
                //
                ecLayer.setOption(this._chartData);
            }
            else {
                //
                ecLayer.setOption(pieChartData);
            }
            //
            ecLayer.on("click", function (event) {
                //
                alert("you click  layer.");
            });
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
//# sourceMappingURL=CompositeChartTool.js.map