/**
 * Created by Administrator on 2016/9/23.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../layers/EChartsNormalLayer", "../demo/data/pieChartData"

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
                    id: "ecFour",
                    map: _map,
                    charts: echarts
                });
                //
                ecLayer.setPieSize(300, 200);
                //
            }
            if (this._chartData) {
                //
                ecLayer.setOption(this._chartData);
            } else {
                //
                ecLayer.setOption(pieChartData);
            }


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