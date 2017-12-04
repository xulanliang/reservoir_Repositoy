/**
 * 读取后台字典数据项 version:1.0.0 author:jiangfl date: 2016-7-13
 */

var _codePlugin = function($, win) {
	// alert("$===="+$);
	var dse = {
		 remoteUrl: "/assets/code/demo/data.json",//请求地址
		//remoteUrl : '/jf/CommonCodeCtrl/getCommonCode/',
		_data : {}
	// 保存到本地数据
	};

	$.fn.code = function(config) {
		var cfg = {
			code : '',// code:字典项
			async : false,// async:异步(true)还是同步(false)
			value : (config.appendTip == null&&(typeof config.appendTip!='undefined')) ? null : '-1',
			width : '100%',
			height : 25,
			maxWidth : 300,// 最大宽度
			readonly : false,
			appendTip : {// //默认在第一个位置添加请选择项
				id : '-1',
				text : '-请选择-'
			},
			// reload:重新加载(true),或者已经加载过后，将不再加载(false)
			reload : false,
			constructor : 'easyui',// easyui or html
			success : null,
			onChange : null
		// 成功回调函数 success(data) 返回当前数据对象

		};
		if (typeof (config) == 'string') {
			cfg.code = config;
		} else {
			if (config) {
				$.extend(cfg, config);
			}
		}

		if (cfg.constructor == 'easyui') {

			// 如果采用了seajs 那么加载依赖项
			if (typeof dseDefine === "function" && win.seajs) {
				win.seajs.require('easyui');
			}

			this.combotree({// 如果你采用了seajs 那么请确保注册了 easyui 名称
				width : cfg.width,
				maxWidth : cfg.maxWidth,
				height : cfg.height,
				async : cfg.async,
				readonly : cfg.readonly,
				url : $.contextPath() + dse.remoteUrl,
				queryParams : {
					code : cfg.code
				},
				value : cfg.value,// 默认值
				loadFilter : function(data, parent) {
					if (!dse._data[cfg.code]) {// 本地数据如果没有保存，则保存一份数据
						dse._data[cfg.code] = data;
					}
					if (cfg.appendTip) {
						data.unshift(cfg.appendTip);
					}
					return data;
				},
				onLoadSuccess : function(node, data) {
					if (cfg.success) {
						cfg.success(data);
					}
				},
				onChange : function(newValue, oldValue) {
					if (cfg.onChange != null) {
						cfg.onChange(newValue);
					}
				}
			});
		} else {
			if (!this.is("select")) {
				alert(this.prop("tagName") + " 不是一个select标签!!");
				return;
			}
			if (cfg.onChange != null) {
				this.change(function() {
					cfg.onChange($(this).val());
				});
			}
			// 加载数据
			if (!dse._data[cfg.code]) {// 从后台装载数据
				loadCode(cfg.code);
			}
			var list = dse._data[cfg.code];
			var option = "";
			if (cfg.appendTip) {
				option = "<option value=\"" + cfg.appendTip.id + "\">" + cfg.appendTip.text + "</option>";
			}
			for ( var i = 0; i < list.length; i++) {
				option += "<option value=\"" + list[i].id + "\">" + list[i].text + "</option>";
			}
			this.append(option);
		}
	};

	/** 根据val 值获取对应的 label 标签 */
	$.getCodeLabel = function(_code, val) {
		if (!dse._data[_code]) {// 从后台装载数据
			loadCode(_code);
		}
		var list = dse._data[_code];
		for ( var i = 0; i < list.length; i++) {
			if (list[i].id == val) {
				return list[i].text;
			}
		}
		return '';
	};
	
	$.getCode=function(code){
		var list=dse._data[code];
		if(!list){
			loadCode(code);
			list=dse._data[code];
		}
		return list;
	};
	

	function loadCode(code) {
		$.ajax({
			url : $.contextPath() + dse.remoteUrl,
			data : {
				code : code
			},
			dataType : 'json',// 后台要是非常严格的json格式，如
			// {"code":"sex","lbl":"女","val":0}
			async : false,
			success : function(data) {
				dse._data[code] = data;
			}
		});
	}


	return $;
};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码

if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		// require('easyui');
		return _codePlugin(require('jquery'), window);
	});
} else {
	// 依赖jquery
	_codePlugin(jQuery, window);
}