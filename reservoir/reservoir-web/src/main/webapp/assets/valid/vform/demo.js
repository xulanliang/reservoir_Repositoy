//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {

    var _eform = require('eform');
    var _vform = require('vform');

    $('#vform').vform();
    $('#submit').on('click', function () {
        if ($('#vform').validateVform()) {
            $tips.msg('校验成功');
        } else {
            $tips.msg('校验失败');
        }
    });

});
