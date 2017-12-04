var _tab1Plugin = function($, win) {

	var $tab1 = {
		tab : function(config) {
			var cfg = {
				el : '',// 渲染的元素
				data : [ {
					title : '标题',
					content : '内容',
					type : 1,// 内容元素 1 html,2:frame
				} ]
			};
			$.extend(cfg, config);

			var el = $(cfg.el);
			el.addClass("slideTxtBox");

			var head_str = '';
			var body_str = '';
			var data = cfg.data;

			for ( var i = 0; i < data.length; i++) {
				head_str += '<li>' + data[i].title + '</li>';
				if (data[i].type == 2) {
					body_str += '<div class="slideBox"><iframe id="dbsxIframe" src="'
							+ data[i].content
							+ '" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe></div>';
				} else {
					body_str += '<div class="slideBox">' + data[i].content + '</div>';
				}
			}
			head_str = '<div class="hd"><ul>' + head_str + '</ul></div>';
			body_str = '<div class="bd">' + body_str + '</div>';

			el.append(head_str);
			el.append(body_str);
			//依赖jquery.SuperSlide.js
			el.slide({});
		}
	};
	win.$tab1 = $tab1;
	return $tab1;
};

if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		return _tab1Plugin(require('jquery'), window);
	});
} else {
	// 依赖jquery
	_tab1Plugin(jQuery, window);
}