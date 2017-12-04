//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/basejs/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index', function (require, exports, module) {
    var _common = require('common');

    $('#doLayerOpen,#doParentWindow,#doParentContents').on('click', function () {
        var type = $(this).attr('data-type') || '';
        layerOpen({
            title: 'layer弹窗',
            area: ['80%', '80%'],
            content: DSE.serverPath + 'pages/app/demos/basejs/index.html?type=' + type
        });
    });

    $('#doTipsMsg').on('click', function () {
        $tips.confirm('你弹出了一个confirm框，要关闭它吗？', function () {
            $tips.msg('请让我再弹一次吧', '', '弹弹弹');
        });
    });

});
