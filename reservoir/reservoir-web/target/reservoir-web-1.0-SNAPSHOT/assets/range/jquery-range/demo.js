//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {
    var _range = require('range');
    /**
     * 修改透明度
     */
    $(".range-slider1").jRange({
        from: 0,
        to: 100,
        step: 10,
        format: '%s',
        width: 110,
        showLabels: true,
        showScale: true,
        onstatechange: function (val) {
            $('#value1').html(val);
        }
    });
    $('.range-slider2').jRange({
        from: 0,
        to: 100,
        step: 1,
        scale: [0, 25, 50, 75, 100],
        format: '%s',
        width: 300,
        showLabels: true,
        isRange: true,
        onstatechange: function (val) {
            $('#value2').html(val);
        }
    });

});
