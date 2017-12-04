//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.test = function() {
		var j=require("jquery");
		alert("123".getBytes());
		alert("aa_bb_cc".replaceAll("_",""));
		alert("param:"+ j.getParam("a"));
	};
});

/* ========================程序入口(main)======================== */
var module;//模块对象
seajs.use(['page','common','jquery'], function(m) {
	module=m;
	m.test();
});