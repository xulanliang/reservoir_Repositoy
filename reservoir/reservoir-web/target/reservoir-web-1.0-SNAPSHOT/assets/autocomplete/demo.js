//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!assets/autocomplete/demo.css');

//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {
    var _autocomplete = require('autocomplete');

    var countries = [
        {"value": "United Arab Emirates", "data": "AE"},
        {"value": "United Kingdom", "data": "UK"},
        {"value": "United States", "data": "US"}
    ];
    $('#autocomplete').autocomplete({
        lookup: countries,
        onSelect: function (rec) {
            console.log(rec);
        }
    });

});
