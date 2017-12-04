//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.test = function() {
		//直接使用
		alert(window.hex_md5('123456'));
		//对象引用
		var m=require("md5");
		alert(m.hex_md5('123456'));
	};
});

/* ========================程序入口(main)======================== */
var module;//模块对象
seajs.use(['page','md5'], function(m) {
	module=m;
	m.test();
});