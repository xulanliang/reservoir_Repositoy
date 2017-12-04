var _formPlugin = function($, win) {

	$(function() {
		// 检测标签，自动补上：，如果标签添加了样式require,则自动添加红色星号
		$(".u-lbl").each(function() {
			var _this = $(this), t = '';
			if (_this.attr("appendColon") != 'false') {
				t = '：';
			}
			t=_this.text()+t;
			
			if (_this.hasClass("require")) {
				t = '<span style="color:red">* </span>'  + t;
				_this.html(t);
			}else {
				_this.text(t);
			}
		});
		//先默认禁止校验
		$('.validatebox-text').validatebox('disableValidation');
	});
	//表单校验
	$.fn.dseValidate=function(){
		//启用校验
		$('.validatebox-text').validatebox('enableValidation');
		var valid=this.form('validate');
		if(!valid){
			// 正上方提示，1.5秒后自动关闭
			layer.msg('校验失败', {
				offset : 10,// 最顶端
				shift : 0,// 渐变动画
				time : 1500,
				icon : 5
			});
			return false;
		}else{
			return true;
		}
	};

	/** 将对象data自动填充到容器中 data:数据对象,op:detail,true 都表示需要将表单转化为详情表单 */
	$.fn.autoFillForm = function(data, op) {

		var _this = $(this);
		var el = null;
		var val;
		var text;
		if (op) {// 删除需要移除的对象
			$("*[detailRemove=true]").remove();
		}

		for ( var key in data) {// 遍历对象
			el = _this.find("#" + key + "_auto,*[name=" + key + "_auto]");
			val = data[key];
			if (el.hasClass('combotree-f')) {// 下拉框树
				if (val instanceof Array) {
					el.combotree('setValues', val);
				} else {
					if (val == null) {// easyui不支持null的值设置,在表单中的下拉值也不能设置为null
						val = '';
					}
					el.combotree('setValue', val);
				}
				if (op) {// 转化为详情
					text = el.combotree("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.combotree("destroy");
				}
			} else if (el.hasClass('combogrid-f')) {// 下拉框表格
				if (val instanceof Array) {
					el.combogrid('setValues', val);
				} else {
					if (val == null) {// easyui不支持null的值设置,在表单中的下拉值也不能设置为null
						val = '';
					}
					el.combogrid('setValue', val);
				}
				if (op) {// 转化为详情
					var text = el.combogrid("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.combogrid("destroy");
				}
			} else if (el.hasClass('combobox-f')) {
				// 下拉框,顺序不能随意更改,至少不能放在 combogrid-f，combotree-f 前面
				if (val instanceof Array) {
					el.combobox('setValues', val);
				} else {
					if (val == null) {// easyui不支持null的值设置,在表单中的下拉值也不能设置为null
						val = '';
					}
					el.combobox('setValue', val);
				}
				if (op) {// 转化为详情
					var text = el.combobox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.combobox("destroy");
				}
			} else if (el.hasClass('datebox-f')) {// 日期文本
				el.datebox('setValue', val);
				if (op) {// 转化为详情
					var text = el.datebox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.datebox("destroy");
				}
			} else if (el.hasClass('datetimebox-f')) {// 日期文本
				el.datetimebox('setValue', val);
				if (op) {// 转化为详情
					var text = el.datetimebox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.datetimebox("destroy");
				}
			} else if (el.hasClass('combo-f')) {
				// 下拉框,顺序不能随意更改,至少不能放在 combogrid-f，combotree-f,combobox-f 前面
				if (val instanceof Array) {
					el.combo('setValues', val);
				} else {
					if (val == null) {// easyui不支持null的值设置,在表单中的下拉值也不能设置为null
						val = '';
					}
					el.combo('setValue', val);
				}
				if (op) {// 转化为详情
					var text = el.combo("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.combo("destroy");
				}

			} else if (el.hasClass('datetimespinner-f')) {// 日期文本
				el.datetimespinner('setValue', val);
				if (op) {// 转化为详情
					var text = el.datetimespinner("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.datetimespinner("destroy");
				}
			} else if (el.hasClass('timespinner-f')) {// 时间微调
				el.timespinner('setValue', val);
				if (op) {// 转化为详情
					var text = el.timespinner("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.timespinner("destroy");
				}
			} else if (el.hasClass('calendar-f')) {// 日期文本
				el.calendar('setValue', val);
				el.timespinner('setValue', val);
			} else if (el.hasClass('numberspinner-f')) {// 数字微调
				el.numberspinner('setValue', val);
				if (op) {// 转化为详情
					var text = el.numberspinner("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.numberspinner("destroy");
				}
			} else if (el.hasClass('numberbox-f')) {// 数字文本
				el.numberbox('setValue', val);
				if (op) {// 转化为详情
					var text = el.numberbox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.numberbox("destroy");
				}
			} else if (el.hasClass('filebox-f')) {// 文件框
				el.filebox('setValue', val);
				if (op) {// 转化为详情
					var text = el.filebox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.filebox("destroy");
				}
			} else if (el.hasClass('textbox-f')) {// 文本框
				el.textbox('setValue', val);
				if (op) {// 转化为详情
					var text = el.textbox("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.textbox("destroy");
				}
			} else if (el.hasClass('slider-f')) {// 时间微调
				el.slider('setValue', val);
				if (op) {// 转化为详情
					var text = el.slider("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.slider("destroy");
				}
			} else if (el.hasClass('spinner-f')) {// 时间微调
				el.spinner('setValue', val);
				if (op) {// 转化为详情
					var text = el.spinner("getText");
					if (text != '-请选择-') {
						el.after("<div>" + text + "</div>");
					}
					el.spinner("destroy");
				}
			} else if (el.is('img')) {
				el.attr("src", data[key]);
			} else if (el.is(":radio")) {
				el.filter("[value=" + val + "]").prop("checked", "checked");
				if (op) {
					el.attr("disabled", true);
				}
			} else if (el.is(":checkbox")) {
				var _val;
				el.each(function(i, item) {
					item = $(item);
					if (val instanceof Array) {
						_val = val[i];
					} else {
						_val = val;
					}
					if (_val == 0) {
						item.removeAttr("checked");
					} else {
						item.prop("checked", "checked");
					}
					if (op) {
						item.attr("disabled", true);
					}
				});

			} else {
				// 默认采用jquery设置值
				if (op) {// 转化为详情
					if (val != '-请选择-') {
						//el.after("<div>" + val + "</div>");
						if(val==null){
							//填充一个空格后，在某些元素上才能保证高度正常，比如 div设置了下边框后才能对齐
							el.html("&nbsp;");
						}else{
							el.text(val);
						}
						
					}
					//el.remove();
				} else {
					el.val(val);
				}
			}
		}

	};

	/** 将表单的值自动填充到对象中并返回 */
	$.fn.autoFillObject = function() {
		var ctn = $(this);
		var data = {};
		var key = null;
		var el = null;
		// 找到元素，进行循环
		ctn.find('*[id$=_auto],*[name$=_auto]').each(function() {
			el = $(this);
			key = el.attr('id');
			if (key == null || key == '' || !key.endWith('_auto')) {
				key = el.attr("name");
			}
			key = key.substring(0, key.length - 5);

			if (el.hasClass('combotree-f')) {// 下拉框树
				if (el.combotree("options").multiple) {
					data[key] = el.combotree('getValues');
				} else {
					data[key] = el.combotree('getValue');
				}
			} else if (el.hasClass('combogrid-f')) {// 下拉框表格
				if (el.combogrid("options").multiple) {
					data[key] = el.combogrid('getValues');
				} else {
					data[key] = el.combogrid('getValue');
				}
			} else if (el.hasClass('combobox-f')) {
				// 下拉框,顺序不能随意更改,至少不能放在 combogrid-f，combotree-f 前面
				if (el.combobox("options").multiple) {
					data[key] = el.combobox('getValues');
				} else {
					data[key] = el.combobox('getValue');
				}
			} else if (el.hasClass('datebox-f')) {// 日期文本
				data[key] = el.datebox('getValue');
			} else if (el.hasClass('datetimebox-f')) {// 日期文本
				data[key] = el.datetimebox('getValue');
			} else if (el.hasClass('combo-f')) {
				// 下拉框,顺序不能随意更改,至少不能放在 combogrid-f，combotree-f,combobox-f 前面
				if (el.combo("options").multiple) {
					data[key] = el.combo('getValues');
				} else {
					data[key] = el.combo('getValue');
				}

			} else if (el.hasClass('datetimespinner-f')) {// 日期文本
				data[key] = el.datetimespinner('getValue');
			} else if (el.hasClass('timespinner-f')) {// 时间微调
				data[key] = el.timespinner('getValue');
			} else if (el.hasClass('calendar-f')) {// 日期文本
				data[key] = el.calendar('getValue');
			} else if (el.hasClass('numberspinner-f')) {// 数字微调
				data[key] = el.numberspinner('getValue');
			} else if (el.hasClass('numberbox-f')) {// 数字文本
				data[key] = el.numberbox('getValue');
			} else if (el.hasClass('filebox-f')) {// 文件框
				data[key] = el.filebox('getValue');
			} else if (el.hasClass('textbox-f')) {// 文本框
				data[key] = el.textbox('getValue');
			} else if (el.hasClass('slider-f')) {// 时间微调
				data[key] = el.slider('getValue');
			} else if (el.hasClass('spinner-f')) {// 时间微调
				data[key] = el.spinner('getValue');
			} else if (el.is('img')) {
				data[key] = el.attr("src");
			} else if (el.is('span') || el.is('div') || el.is('a')) {
				data[key] = el.text();
			} else if (el.attr('type') == 'hidden') {
				data[key] = el.val();
			} else if (el.attr('type') == 'radio') {
				if(!data.hasOwnProperty(key)){//如果没有该属性,则设置一个空
					data[key]='';
				}
				if (el.is(":checked")) {
					var val = el.attr('value');
					if (val == '' || val == null || val == 'on') {
						val = '1';
					}
					data[key] = val;
				}
			} else if (el.attr('type') == 'checkbox') {
				var array;
				if(!data.hasOwnProperty(key)){//如果没有该属性,则设置一个空
					array=new Array();
				}else{
					array=data[key];
				}
				var val = el.val();
				if (el.is(":checked")) {
					if (val == '' || val == null || val == 'on') {
						val = '1';
					}
					array.push(val);
				} 
				data[key]=array;
			} else {
				// 默认采用jquery设置值
				data[key] = el.val();
			}
		});
		return data;

	};

};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		return _formPlugin(require('jquery'), window);
	});
} else {
	// 依赖jquery
	_formPlugin(jQuery, window);
}