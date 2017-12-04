/**
 * Created by pc on 2017-6-20.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/szsk/swqx/css/swqxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('shenyaPage', function (require, exports, module) {

    var _tab3 = require('tab3'),
        _common = require('common');

    var h = $(document).height() - 100;

    $('#cont-lists').height(h);

    var projcd = $.getParam("projcd");
    var ppcd = $.getParam("ppcd");

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            h1: 1200,
            1: DSE.baseUrl + '/pages/app/sjfx/dggc/shenya/sygcx/sygcxPage.html?st_tp=1&projcd='+projcd,
            h2: h-50,
            2: DSE.baseUrl + '/pages/app/sjfx/dggc/shenya/gcjlb/gcjlbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
            h3: h-35,
            3: DSE.baseUrl + '/pages/app/sjfx/dggc/shenya/jnbb/jnbbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
            h4: h-35,
            4: DSE.baseUrl + '/pages/app/sjfx/dggc/shenya/sytzzbb/sytzzbbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd
        }
    });

});
