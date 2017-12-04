
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/szsk/swqx/css/swqxPage.css');
require_css('css!pages/app/sjfx/css/fixSjfx.css');
//执行配置
require.config(DSE.requireConfig);
define('shenLiuPage', function (require, exports, module) {

    var _tab3 = require('tab3'),
        _common = require('common');

    var h = $(document).height() - 60;

    $('#cont-lists').height(h);

    var projcd = $.getParam("projcd");
    var ppcd = $.getParam("ppcd");

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            h1: h-50,
            1: DSE.baseUrl + '/pages/app/sjfx/szsk/shenLiu/gcx/gcxPage.html?st_tp=2&projcd='+projcd+"&ppcd="+ppcd,
            h2: h-50,
            2: DSE.baseUrl + '/pages/app/sjfx/szsk/shenLiu/gcjlb/gcjlbPage.html?st_tp=2&projcd='+projcd+"&ppcd="+ppcd,
            h3: h-35,
            3: DSE.baseUrl + '/pages/app/sjfx/szsk/shenLiu/jnbb/jnbbPage.html?st_tp=2&projcd='+projcd+"&ppcd="+ppcd

        }
    });

});
