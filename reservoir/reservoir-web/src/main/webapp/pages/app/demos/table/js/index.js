//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/table/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index',function(require,exports,module) {
	var _common = require('common');

   	DSE.form.tabFitScroll('.g-tb-fit', '.m-tb-fit.hd', '.g-tb-cont');

});
