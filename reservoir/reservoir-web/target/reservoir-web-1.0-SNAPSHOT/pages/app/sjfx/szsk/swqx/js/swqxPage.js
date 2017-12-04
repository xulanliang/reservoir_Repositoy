/**
 * Created by pc on 2017-6-1.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/szsk/swqx/css/swqxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('swqxPage', function (require, exports, module) {

    var _tab3 = require('tab3'),
        _common = require('common');

    // var h = $(document).height() - 60;

    var h = $(document).height()-76;

    var projcd = $.getParam("projcd")

    $('#cont-lists').height(h);

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            // h1: 700,
            h1: h,
            1: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/gcx/gcxPage.html?projcd='+projcd,
            h2: h-50,
            2: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/gcjlb/gcjlbPage.html?projcd='+projcd,
            h3: h-35,
            3: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/jnbb/jnbbPage.html?projcd='+projcd,
            h4: h-35,
            4: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/swtzzbb/swtzzbbPage.html?projcd='+projcd,
            h5: h-35,
            5: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/yltzzbb/yltzzbbPage.html?projcd='+projcd,
            h6: h-35,
            6: DSE.baseUrl + '/pages/app/sjfx/szsk/swqx/qwtzzbb/qwtzzbbPage.html?projcd='+projcd
        }
    });

});
