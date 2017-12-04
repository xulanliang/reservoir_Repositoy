(function($) {
	$.extend({
		tab3: function(options) {
			var defaults = {
				tab: '#tab-btns .tag', //选项卡选择器
				cont: '#cont-lists li', //内容选择器
				oTab: 'on', //当前选项卡选中样式
				defOn: 1, //默认选中第几个
				mt: 'click', //切换方式,click或mouseover
				mode: 1, //1为fade,2为slide
				tm: 300, //切换时间
				//默认为空,如有加载iframe,直接添加如下的属性值,左边的数值表示第几个tab内容,右边表示iframe的src路径
				title: {
					//                        "1": "成员单位",
					//                        "2": "区镇",
					//                        "3": "其他"
				},
				iframe: {
					//                        "h1": 300,
					//                        "1": DSE.serverPath + "pages/app/xxx/xxx.html",
					//                        "3": DSE.serverPath + "pages/app/xxx/xxx.html"
				},
				//tab每次切换时的回调,返回3个参数,t为选项卡dom对象,c为内容dom对象,i为索引值
				cFunc: function(t, c, i) {

				}
			};
			var o = $.extend(defaults, options);
			var loadIframe = function($i) {
				var j = $i + 1;
				if(o.iframe[j] && !$(o.cont).eq($i).find('iframe[src="' + o.iframe[j] + '"]')[0]) {
					var _defH = o.iframe["h" + j] ? ' height="' + o.iframe["h" + j] + '"' : '',
						_defW = o.iframe["w" + j] ? o.iframe["w" + j] : '100%';
					$(o.cont).eq($i).prepend('<iframe class="cont-iframe-' + j + '" width="' + _defW + '"' + _defH + ' frameborder="no" scrolling="no"></iframe>');
					$(o.cont + ' .cont-iframe-' + j).attr('src', o.iframe[j]).load(function() {
						var $f = $(this),
							iH = $f.contents().find("body").height() + 30;
						$f.height(iH);
					});
				}
			};
			$(document).delegate(o.tab, o.mt, function() {
				var $t = $(this),
					$i = $t.index();
				if(!$t.hasClass(o.oTab)) {
					$(o.tab).removeClass(o.oTab);
					$t.addClass(o.oTab);
					loadIframe($i);
					if(o.mode == 1) {
						$(o.cont).hide().eq($i).fadeIn(o.tm);
					} else {
						$(o.cont).hide().eq($i).slideDown(o.tm);
					}
				}
				if(typeof o.cFunc == 'function') {
					o.cFunc($t, $(o.cont).eq($i), $i);
				}
				return false;
			});
			$.each(o.title, function(i) {
				$(o.tab).eq(i - 1).text(o.title[i]);
			});
			$(o.cont).hide();
			loadIframe(o.defOn - 1);
			$(o.tab).eq(o.defOn - 1).trigger(o.mt);
		}
	});
})(jQuery);
