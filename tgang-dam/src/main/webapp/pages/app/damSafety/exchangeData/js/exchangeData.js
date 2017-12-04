/**
 * Created by gaoq on 2017-4-27.
 */
dseDefine('../js/exchangeData', ['jquery', 'layer','easyui', 'easyui_lang', 'common'],
    function(require, exports, module) {

        require('jquery');
        require('easyui');
        require('easyui_lang');
        require('common');
        var layer = require('layer');
        layer.config({
            path: window._baseUrl + 'assets/win/layer/'
        });

        var myModule = {

            init: function() {
                $('#days').numberbox({
                    width: '150px',
                    height: '33',
                    min: 1
                });
            },

            listen: function () {
                $('#sync').click(function() {
                    $.ajax({
                        url: window._baseUrl + 'BasicFeatureCtl/exchangeData.do',
                        type: "post",
                        data: JSON.stringify({
                            days : $('#days').numberbox('getValue')
                        }),
                        contentType: 'application/json',
                        success: function (result) {
                            layer.msg(result.msg, {
                                icon: 4,
                                time: 3000,
                                offset: '10%'
                            });
                        }
                    });
                });
            }
        };
        module.exports = myModule;

        $(function() {
            myModule.init();
            myModule.listen();
        });
    });

var page;
seajs.use(['../js/exchangeData'],
    function(m) {
        page = m;
    });