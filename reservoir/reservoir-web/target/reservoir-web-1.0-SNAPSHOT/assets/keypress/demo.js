//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {

    var _common = require('common'); //回车enter函数
    var _keypress = require('keypress'); //全局的按键

    DSE.hello = function () {
        $tips.msg('又提交不了，你回车做什么？');
    };

    $('#submit').on('click', function () {
        $('body > .menus').remove();
        $tips.msg('别点提交好吗？');
    });

    $('#delete').on('click', function () {
        $('body > .menus').remove();
        $tips.msg('都提交不了，你还想取消？');
    });

    //鼠标右击事件
    rclick('.u-btn', function (t, c) {
        var txt = t.text();
        $('body > .menus').remove();
        $('body').append('<div class="menus f-dn" style="position:absolute;left:' + c.x + 'px;top:' + c.y + 'px;border:1px solid #d8d8d8;background-color:#fff;width:130px;"><a href="javascript:" style="display:block;padding:8px;">' + txt + '一</a><a href="javascript:" style="display:block;padding:8px;">' + txt + '二</a><a href="javascript:" style="display:block;padding:8px;">' + txt + '三</a><a href="javascript:" style="display:block;padding:8px;">' + txt + '四</a></div>');
        $('body > .menus').fadeIn('fast');
    });

    //监听键盘按键
    key('a', function () {
        $tips.msg('a 你好吗？美女你号码？');
    });

    key('b', function () {
        $tips.msg('这个字母特别喜欢和 2 在一起，你呢？');
    });

    key('c', function () {
        $tips.msg('含义很多，看你怎么理解了！');
    });

    key('d', function () {
        $tips.msg('喜欢这么大吗？');
    });

    key('e', function () {
        $tips.msg('还可以更大吗？');
    });

    key('f', function () {
        $tips.msg('舅扶你？');
    });

    key('g', function () {
        $tips.msg('gg思密达？');
    });

    key('up', function () {
        $tips.msg('上');
    });

    key('down', function () {
        $tips.msg('下');
    });

    key('left', function () {
        $tips.msg('左');
    });

    key('right', function () {
        $tips.msg('右');
    });
    key('enter', function () {
        $tips.msg('使劲按吧，你影响不了什么！');
    });

    key('ctrl+a', function () {
        stopDefault();
        $tips.msg('妹子这么少，你全选了别人怎么办？');
    });

    key('ctrl+s', function () {
        stopDefault();
        $tips.msg('没什么可以保存呀！');
    });

    //设置key.noCopy为true，可以禁止input内复制粘贴内容
    key.noCopy = true;
    key('ctrl+c', function () {
        stopDefault();
        $tips.msg('别想复制！');
    });

    key('ctrl+v', function () {
        stopDefault();
        $tips.msg('不准粘贴！');
    });
});
