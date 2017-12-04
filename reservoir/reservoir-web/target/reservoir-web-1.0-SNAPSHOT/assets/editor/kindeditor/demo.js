//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {
    var _base = require('base');
    var _kindEditor = require('kindeditor');

  	/*
  	 * 注：KindEditor.ready 代码的时候 dom 结构早就完成了，动态插入的 script 代码不会再次触发 DOMContentLoaded 事件，因此 KindEditor.ready 注册的回调永远不会被执行
  	 *
  	 * 不要使用 KinkEditor.ready，直接 KindEditor.create
  	 *
  	 */
    var editor = KindEditor.create('#test_auto', {
        resizeType: 1,
        allowPreviewEmoticons: false,
        allowImageUpload: false,
        items: [
            'print', '|',
            'title', 'fontname', 'fontsize', '|',
            'emoticons', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline', 'strikethrough', 'removeformat', '|',
            'plainpaste', 'wordpaste', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript', 'superscript', '|',
            'advtable', 'hr', 'link', 'unlink'
        ]
    });


});
