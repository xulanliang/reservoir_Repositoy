/**
 * Created by pc on 2017-6-1.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/szsk/swqx/css/swqxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('shenyaPage', function (require, exports, module) {

    var _tab3 = require('tab3'),
        _common = require('common');

    var h = $(document).height() - 60;

    $('#cont-lists').height(h);
    //二级工程
    var projcd = $.getParam("projcd");
    //一级工程
    var ppcd = $.getParam("ppcd");
    var st_tp = $.getParam("st_tp");
    if(projcd==1004 && ppcd==1){
        $("#jrxURL").hide();
    }

    $.tab3({
        tab: '#tab-btns a', //选项卡选择器
        cont: '#cont-lists li', //内容选择器
        iframe: {
            h1: h-51,
            1: DSE.baseUrl + '/pages/app/sjfx/szsk/shenya/gcx/gcxPage.html?st_tp=1&projcd='+projcd,
            h2: 1000,
            //2: 'http://192.168.137.208:8018/dam/pages/app/damSafety/infiltrationLine/infiltrationLinePage.html',
            2: 'http://10.100.9.46:8080/dam/pages/app/damSafety/infiltrationLine/infiltrationLinePage.html?projcd='+projcd+"&ppcd="+ppcd,
            h3: h-51,
            3:DSE.baseUrl + '/pages/app/sjfx/szsk/shenya/xgt/xgtPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
            h4: h-35,
            4: DSE.baseUrl + '/pages/app/sjfx/szsk/shenya/gcjlb/gcjlbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
            h5: h-35,
            5: DSE.baseUrl + '/pages/app/sjfx/szsk/shenya/sytzzbb/sytzzbbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
            h6: h-98,
            6: DSE.baseUrl + '/pages/app/sjfx/szsk/shenya/jnbb/jnbbPage.html?st_tp=1&projcd='+projcd+"&ppcd="+ppcd,
        }
    });





});
