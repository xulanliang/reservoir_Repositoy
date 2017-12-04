//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/basejs/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index', function (require, exports, module) {
    var _eform = require('eform');
    DSE.form.inputLimit("body");
});
