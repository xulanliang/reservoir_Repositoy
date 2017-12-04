//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.test = function() {
		var jsonObj=require("json");
		var jsonStr='{"a":1,"b":2}';
		var json=jsonObj.parse(jsonStr);
		//转换成json对象
		alert(json.a);
		//转化成string
		alert(jsonObj.stringify(json));
	};
});

/* ========================程序入口(main)======================== */
var module;//模块对象
seajs.use(['page','json'], function(m) {
	module=m;
	m.test();
});