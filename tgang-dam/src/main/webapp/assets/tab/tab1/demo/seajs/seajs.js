//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	exports.init = function() {
		
		var tab=require("tab1");
		tab.tab({
			"el" : "#mydiv",
			data : [ {
				title : '新闻',
				content : 'aaaa',
				type : 1,// 内容元素 1 html,2:frame
			}, {
				title : 'IT',
				content : 'bbbb',
				type : 1,
			}, {
				title : '电影',
				content : 'ccc',
				type : 1,
			} ]
		});

		tab.tab({
			"el" : "#mydiv2",
			data : [ {
				title : '百度',
				content : 'http://www.baidu.com',
				type : 2,// 内容元素 1 html,2:frame
			}, {
				title : '开源中国',
				content : 'http://www.oschina.net/',
				type : 2,
			}, {
				title : 'sohu',
				content : 'http://www.sohu.com/',
				type : 2,
			} ]
		});
	};

});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page', 'jquery','superSlide','tab1','tab1_css' ], function(m) {
	module = m;
	m.init();
});