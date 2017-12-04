//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/tab3/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index', function (require, exports, module) {
    var _tab3 = require('tab3'),
            _common = require('common');

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            2: DSE.baseUrl + '/pages/app/demos/basejs/index.html',
            3: DSE.baseUrl + '/pages/app/demos/layer/index.html'
        }
    });

});
