/**
 * 构建菜单插件 jiangfl 2015-7-7
 */

var _menu2Plugin = function($) {

	$.fn.dseMenu = function(config) {
		// json数据
		var cfg = {
			selected : null, // 用户单击时触发 function(url,id,text,nav_info)
			// url:链接地址，id:菜单ID,nav_info 导航信息
			data : [ {
				menuid : null,// 菜单ID
				text : null,// 菜单文本
				href : null,
				img : null
			// 图标
			// 链接地址
			} ]
		};

		var obj = $(this);
		if (typeof config == "string") {
			config = eval("(" + config + ")");
		}
		$.extend(cfg, config);

		init();

		// 单击节点时触发
		function selected() {
			$this = $(this);
			var url = $this.attr("url");
			if (url) {// 如果是菜单
				obj.find('.box').hide();
				var menuid = $this.attr("menuid");
				if ($this.attr("flag")) {
					var text = $this.attr("flag");
				} else {
					var text = $this.text();
				}

				var nav_info = getParentNodeInfo(menuid);
				obj.find(".list a").removeClass("now");
				$this.addClass("now");
				if(cfg.selected){
					cfg.selected(url, menuid, text, nav_info);
				}
			}
		}

		// 找到导航路径
		function getParentNodeInfo(menuid) {
			var list = cfg.data;
			return findNode(menuid, list);
		}

		// 递归，找到最底层的节点，然后往上递归，获取上级节点
		function findNode(menuid, list) {
			var o = null;
			for ( var i in list) {
				o = list[i];
				if (o.menuid == menuid) {// 找到了节点后，返回这个节点的文本
					return o.text;
				}
				var children = o.children;
				if (children && children.length > 0) {// 如果有子节点，则再遍历子节点
					var n = findNode(menuid, children);
					if (n) {
						return o.text + ">" + n;
					}
				}
			}
		}

		function init() {
			// cfg.data 是一个数组，里面保存了json菜单，最多支持3层菜单
			// 第一层容器
			var list = $('<div class="list"></div>');
			// 内容浮动层
			var box = $('<div class="box" style="height: 0px; opacity: 0; overflow: hidden;"></div>');

			var ui = $('<ul style="float:right;"></ul>');
			var children2 = null;
			var children3 = null;
			var boxDiv = null;
			var li = null;
			var a = null;
			list.append(ui);
			var firstA = null;
			var data = cfg.data;
			var itemDiv;
			var href = null;
			for ( var i = 0; i < data.length; i++) {// 循环第一层菜单
				li = $('<li></li>');
				href = data[i].href;
				if (!href) {
					href = data[i].children[0].href;
					itemDiv = $('<div class="firstMenuItem" flag=' + data[i].children[0].text + ' menuid=' + data[i].menuid + ' url="' + href
							+ '"></div>');
				} else {
					itemDiv = $('<div class="firstMenuItem" menuid=' + data[i].menuid + ' url="' + href + '"></div>');
				}

				itemDiv.append('<img src="' + data[i].img + '"  class="img" />');
				li.append(itemDiv);

				a = $('<div class="firstMenuText">' + data[i].text + '</div>');
				itemDiv.append(a);

				if (i == 0 && href) {// 如果第一个菜单是菜单，则默认显示
					firstA = itemDiv;
				}
				itemDiv.click(selected);

				ui.append(li);

				boxDiv = $('<div class="cont" style="display: none;"></div>');
				box.append(boxDiv);
				// 构建浮动层
				children2 = data[i].children;
				var ul2 = $('<ul class="sublist clearfix"></ul>');
				var li2 = null;

				if (children2 && children2.length > 0) {// 第二层菜单
					for ( var j = 0; j < children2.length; j++) {
						li2 = $('<li url="' + children2[j].href + '"></li>');
						li2.click(selected);
						ul2.append(li2);
						boxDiv.append(ul2);
						li2.append('<h3 class="mcate-item-hd"><a href="#">' + children2[j].text + '</a></h3>');
						children3 = children2[j].children;
						if (children3 && children3.length > 0) {// 第三层菜单
							href = children3[j].href;
							if (href == '#') {
								href = 'pages/sys/djz/djz.jsp';
							}
							var p = $('<div class="mcate-item-bd"></div>');
							li2.append(p);
							for ( var n = 0; n < children3.length; n++) {
								a = $('<a href="javascript:void(0)"  menuid=' + children3[n].menuid + ' url="' + href + '">' + children3[n].text
										+ '</a>');
								a.click(selected);
								p.append(a);
								if (i == 0 && !firstA) {
									firstA = a;
								}
							}
						}
					}
				}
			}

			$('.mcate-item-hd').click(function() {
				alert($(this).attr('url'));
			})
			obj.append(list);
			obj.append(box);

			// 表单构建完成，绑定事件

			var time = null;
			var lista = list.find(".firstMenuItem");

			var box_show = function(hei) {
				box.stop().animate({
					height : hei,
					opacity : 1
				}, 400);
			};

			var box_hide = function() {
				box.stop().animate({
					height : 0,
					opacity : 0
				}, 400);
			};

			lista.hover(function() {
				var _this = $(this);
				lista.removeClass('menuHover');
				box.hide();
				_this.addClass("menuHover");
				clearTimeout(time);
				var index = list.find(".firstMenuItem").index(_this);
				$('.box').css({
					'left' : index * 100 + 10
				});
				var floatBox = box.find(".cont").hide().eq(index);
				if (floatBox.children().length > 0) {
					box.show();
					floatBox.show();
					var _height = floatBox.height();
					box.height(0);
					box_show(_height);
				}
			}, function() {
				time = setTimeout(function() {
					box_hide();
					// box.find(".cont").hide();
				}, 50);
			});

			box.find(".cont").hover(function() {
				var _this = $(this);
				clearTimeout(time);
				_this.show();
				var _height = _this.height();
				box_show(_height);
			}, function() {
				time = setTimeout(function() {
					box_hide();
					// $(this).hide();
				}, 50);
			});

			// 默认让第一个单击
			if (firstA) {
				firstA.click();
			}
		}
	};

	return $;
};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码

if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		// require('easyui');
		return _menu2Plugin(require('jquery'), window);
	});
} else {
	// 依赖jquery
	_menu2Plugin(jQuery, window);
}