//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.initForm = function() {
		$("#sex").code({
			code : 'sex',
			constructor : 'html',
			onChange:function(val){
				alert(val);
			}
		});

		$("#easyui_sex").code('sex');

		$("#sex_man").text($.getCodeLabel('sex', 1));
		$("#sex_woman").text($.getCodeLabel('sex', 2));
	};

});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page', 'easyui_css', 'jquery','common', 'easyui', 'easyui_lang','easyui_valid', 'code' ], function(m) {
	module = m;
	m.initForm();
});