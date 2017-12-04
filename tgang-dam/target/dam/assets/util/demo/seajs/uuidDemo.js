//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.test = function() {
		//直接使用
		alert(Math.uuid());
		//对象引用
		var u=require("uuid");
		alert(u.uuid());
	};
});

/* ========================程序入口(main)======================== */
var module;//模块对象
seajs.use(['page','uuid'], function(m) {
	module=m;
	m.test();
});