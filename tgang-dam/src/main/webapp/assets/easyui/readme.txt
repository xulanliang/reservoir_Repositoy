Current Version: 1.4.4
======================
This software is allowed to use under freeware license or you need to buy commercial license for better support or other purpose.
Please contact us at info@jeasyui.com


########东深更改####
1、assets/plugins/easyui/themes/metro/easyui.css 皮肤更改了.textbox-focused样式
2、easyui/themes/color.css 按钮都添加了自适应 padding属性,去掉了 必须为a标签的限制
3、assets/plugins/easyui/locale/easyui-lang-zh_CN.js 因为校验时tip长度有点长，默认简化了一下
4、添加了校验器 assets/plugins/easyui/plugins/jquery.validtor.rules.js
5、 jquery.easyui.min.js 异步请求更改（添加支持异步，同步处理）
  1) 搜 $.fn.tree.defaults = { （2936行） ajax 添加 async:opts.async,
  2) 搜 $.fn.panel.defaults = { （4065行） ajax 添加 async:opts.async,
  3) $.fn.datagrid.defaults(13253)  ajax 添加 async:opts.async,
  4) $.fn.treegrid.defaults(15005)  ajax 添加 async:opts.async,
  5) $.fn.combobox.defaults(16204)  ajax 添加 async:opts.async,
  6) function load(_523, data) {(9175)  ajax 添加 async:opts.async,
6、存放了一个《jQuery EasyUI 1.4.3 版 API 中文版 (Made By Richie696).chm》API
7、删除了demo ,可以从官网直接看 http://www.jeasyui.com/demo/main/index.php
8、对easyui（easyui-lang-zh_CN.js,jquery.easyui.min.js）添加了seajs支持

  
  
  


