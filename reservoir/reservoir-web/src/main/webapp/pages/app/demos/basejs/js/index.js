//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/basejs/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index', function (require, exports, module) {
    var _common = require('common');

    $('#doEvil').on('click', function () {
        evil("alert('hello evil !')");
    });

    $('#doNullToSpace1').on('click', function () {
        alert(nullToSpace(false));
    });

    $('#doNullToSpace2').on('click', function () {
        alert(nullToSpace(0));
    });

    $('#doNullToSpace3').on('click', function () {
        alert(nullToSpace(null));
    });

    $('#doNullToSpace4').on('click', function () {
        alert(nullToSpace(undefined));
    });

    $('#doNullToSpace5').on('click', function () {
        alert(nullToSpace("hello world !"));
    });

    $('#doTopWindow1').on('click', function () {
        alert(topWindow);
    });

    $('#doTopWindow2').on('click', function () {
        alert(topWindow.nullToSpace("hello world !"));
    });

    $('#doGetId1').on('click', function () {
        alert($.getId());
    });

    $('#doGetId2').on('click', function () {
        alert($.getId(8));
    });

    $('#do_serverPath').on('click', function () {
        alert(DSE.serverPath);
    });

    $('#doGetParam1').on('click', function () {
        var a = $.getParam('a') || '';
        alert(a);
    });

    $('#doGetParam2').on('click', function () {
        var b = $.getParam('b') || '';
        alert(b);
    });

    $('#doGetDataInfo').on('click', function () {
        var $data = $ajax({url: DSE.serverPath + 'pages/app/data/data_bzwd.json'}) || [];
        alert(JSON.stringify($data));
    });

    if (window.$parentWindow && $parentWindow.layerOpen) {
        var type = $.getParam('type') || '';
        if (type == 1) {
            alert(typeof $parentWindow.layerOpen);
        } else if (type == 2) {
            alert($parentContents.find('body').html());
        }
    }

});
