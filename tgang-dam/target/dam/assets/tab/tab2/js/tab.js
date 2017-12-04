var _tab2Plugin = function($) {

	$.fn.tab2 = function(config, id, value) {
		var tab = this;

		if ("setTitle" == config) {
			tab.find('#hd_' + id).text(value);
			return this;
		}

		var cfg = {
			width : null,
			height : null,
			tabColor : '#f4f4f4',
			success : null,// 实例化完成后加载
			tabChange : null,
			tabHeight : null,
			tabs : [ {

				title : '标题',
				content : '内容',
				// 1:html内容,2:iframe内容
				type : 1,
				id : '',// 容器ID
				// 高度
				height : null
			} ]
		};
		$.extend(cfg, config);
		// 初始化对象
		function init() {
			tab.addClass("tab2");
			// alert(document.documentElement.clientHeight);
			if (cfg.height != null) {
				tabs.height(cfg.height);
			}

			var tabs = cfg.tabs;
			var ul = $("<ul class='tabHead'></ul>");
			var body = $("<div class='tabBody'></div>");
			var bodyItem = null;
			var li = null;
			var iframe = null;
			for ( var i = 0; i < tabs.length; i++) {
				li = $("<li id='" + (tabs[i].id ? tabs[i].id : ('li_' + i)) + "'></li>");
				if (cfg.tabHeight != null) {
					li.height(cfg.tabHeight);
					li.css("line-height", li.height() + 'px');
				}
				if (tabs[i].type == 1) {
					bodyItem = $("<div class='hide'></div>");
					bodyItem.append(tabs[i].content);
					if (tabs[i].id) {
						bodyItem.attr("id", tabs[i].id);
					}
				} else if (tabs[i].type == 2) {
					bodyItem = $("<div class='hide'></div>");
					iframe = $("<iframe  frameborder='no' width='100%' border='0' marginwidth='0' marginheight='0' scrolling='no' allowtransparency='yes'></iframe>");
					if (i == 0) {
						iframe.attr("src", tabs[i].content);
					} else {
						iframe.attr("data-url", tabs[i].content);
					}

					if (tabs[i].id) {
						iframe.attr("id", "bd_" + tabs[i].id);
					}
					if (tabs[i].height) {
						iframe.height(tabs[i].height);
					} else {
						// 装载成功时设置高度
						iframe.on('load', function(o) {
							var _ifr = $(this);
							// 动态设置高度
							var mainheight = _ifr.contents().find("body").height() + 30;
							// / alert("mainheight:"+mainheight);
							_ifr.height(mainheight);
						});
					}

					bodyItem.append(iframe);
				}
				if (i == 0) {
					li.addClass("selected");
					bodyItem.removeClass('hide').addClass('show');
				} else {
					li.addClass("split");
				}
				li.append("<div id='" + (tabs[i].id ? 'hd_' + tabs[i].id : 'hd_' + i) + "'>" + tabs[i].title + "</div>");

				ul.append(li);
				body.append(bodyItem);

				li.click(liClick);
			}
			tab.append(ul).append(body);

			if (cfg.success != null) {
				cfg.success();
			}

			function liClick() {
				var _this = $(this);
				if (!_this.hasClass("selected")) {
					var lis = ul.find(">li");
					lis.removeClass("selected");
					$(this).addClass("selected");
					// body.find(">div").removeClass('show').addClass("hide").eq(lis.index(this)).addClass("show");
					var ind=lis.index(this);
					var showContent = body.find(">div").removeClass('show').addClass("hide").eq(ind).addClass("show");
					if(cfg.tabs[ind].type==2){//如果是iframe
						var iframe=showContent.find("> iframe");
						var url= iframe.attr("data-url");
						if(url){
							iframe.attr("src",url).removeAttr("data-url");
						}
					}
					
					if (cfg.tabChange != null) {
						cfg.tabChange(_this.attr("id"), lis.index(this));
					}
				}
			}
		}

		init();

		return this;
	};
	return $;
};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码

if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		return _tab2Plugin(require('jquery'));
	});
} else {
	// 依赖jquery
	_tab2Plugin(jQuery);
}
