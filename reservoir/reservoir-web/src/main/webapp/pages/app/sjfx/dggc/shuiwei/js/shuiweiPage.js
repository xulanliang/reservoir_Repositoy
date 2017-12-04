/**
 * Created by pc on 2017-6-19.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/szsk/swqx/css/swqxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('shuiweiPage', function (require, exports, module) {

    var _tab3 = require('tab3'),
        _common = require('common');

    var h = $(document).height() - 100;

    var projcd = $.getParam("projcd");
    var ppcd = $.getParam("ppcd");

    $('#cont-lists').height(h);

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            h1: h-35,
            1: DSE.baseUrl + '/pages/app/sjfx/dggc/shuiwei/swgcx/swgcxPage.html?projcd='+projcd,
            h2: h-50,
            2: DSE.baseUrl + '/pages/app/sjfx/dggc/shuiwei/gcjlb/gcjlbPage.html?projcd='+projcd+"&ppcd="+ppcd,
            h3: h-35,
            3: DSE.baseUrl + '/pages/app/sjfx/dggc/shuiwei/jnbb/jnbbPage.html?projcd='+projcd+"&ppcd="+ppcd,
            h4: h-35,
            4: DSE.baseUrl + '/pages/app/sjfx/dggc/shuiwei/dnpjtzz/dnpjtzzPage.html?projcd='+projcd+"&ppcd="+ppcd
        }
    });

});