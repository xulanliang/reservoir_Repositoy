/**
 * Created by zhoujc on 2016-2-22.
 */
// html5页面缓存,常用全局数据存入
var sessionStorage = window.sessionStorage;

var BaseUtil = {
	// 日期工具类
	timeStampFormatDate : function(timeStamp) {
		if (timeStamp != null && timeStamp != '') {
			var date = new Date(parseFloat(timeStamp));
			var year = date.getFullYear();
			var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
			var day = date.getDate() < 10 ? '0' + (date.getDate()) : (date.getDate());
			return year + '-' + month + '-' + day;
		} else
			return '';
	},
	timeStampFormatDateTime : function(timeStamp) {
		if (timeStamp != null && timeStamp != '') {
			var date = new Date(parseFloat(timeStamp));
			var year = date.getFullYear();
			var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
			var day = date.getDate() < 10 ? "0" + date.getDate() : (date.getDate());
			var hour = date.getHours() < 10 ? "0" + date.getHours() : (date.getHours());
			var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : (date.getMinutes());
			var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : (date.getSeconds());
			return year + '-' + month + '-' + day + " " + hour + ":" + minute + ":" + second;
		} else
			return '';
	},
	dateTimeFormatTimeStamp: function (dateTime) {
		var timeStamp = new Date((''+dateTime).replace(new RegExp("-","gm"),"/")).getTime();
		if(timeStamp){
			return timeStamp;
		}
		return '';
	},

	isContain : function(strArr, string) {
		var flag = false;
		for ( var i in strArr) {
			if (strArr[i] == string) {
				flag = true;
			}
		}
		return flag;
	}
}

var Constans = {
	// 文件上传最大个数
	MAX_UPLOAD_FILE : 5,
	ROOT_TREE_ID : -1,
	USER_INFO : 'user_info'
};


$(function() {


	/**
	 * 自动填充表单，加上格式转化
	 *
	 * @param data
	 */
	$.fn.autoFillForm = function(data) {
		var _this = $(this);
		var _element = null;
		var _value = null;

		for ( var key in data) {// 遍历对象
			// 找到表单中name与之对应的元素
			_element = _this.find('[name="' + key + '"]');
			// 该元素对应的值
			_value = $.trim(data[key]);
			// 如果对象存在
			console.log(_element.attr('class'));
			if (_element.length > 0) {
				// 如果是下拉框
				if (_element[0].tagName.toLowerCase() == 'select') {
					_element.val(_value);
				}
				// 如果是input
				else if (_element[0].tagName.toLowerCase() == 'input') {
					// date类型调整格式
					if ((_element.attr('class') + "").indexOf("form_datetime") > -1) {
						if((_element.attr('class') + "").indexOf("date_time") > -1){
							_element.val(BaseUtil.timeStampFormatDateTime(_value));
						}else {
							_element.val(BaseUtil.timeStampFormatDate(_value));
						}
					} else {
						_element.val(_value);
					}
				}
				// 其他
				else {
					_element.val(_value);
				}
			} else
				_element.val(_value);

		}
	};

	/**
	 * 自动填充name 的text
	 *
	 * @param data
	 */
	$.fn.autoFillName = function(data) {
		var _this = $(this);


		for ( var key in data) {// 遍历对象
			var _element = null;
			var _value = null;
			// 找到表单中name与之对应的元素
			_element = _this.find('[name="' + key + '"]');
			// 该元素对应的值
			_value = $.trim(data[key]);
			console.log((_element.attr('class') + "").indexOf("date"));
			if ((_element.attr('class') + "").indexOf("date") > -1) {
				_element.text(BaseUtil.timeStampFormatDate(_value));
			}else {
				_element.text(_value);
			}
		}
	};

	$.fn.getFormData = function() {
		var _this = $(this);
		var _elements = _this.find('[name]');
		var _formObj = {};
		for ( var i = 0; i < _elements.length; i++) {
			if(($(_elements[i]).attr('class') + "").indexOf("form_datetime") > -1){
				_formObj[_elements[i].name] = BaseUtil.dateTimeFormatTimeStamp(_elements[i].value) + '';
			}
			else
				_formObj[_elements[i].name] = _elements[i].value;

		}
		return _formObj;
	};

	$.fn.reset = function(data) {
		var _this = $(this);
		var _elements = _this.find('[name]');
		for ( var i = 0; i < _elements.length; i++) {
			var flag = true;
			for ( var j in data) {
				if (_elements[i].name == data[j]) {
					flag = false;
				}
			}
			if (flag) {
				if (_elements[i].tagName.toLowerCase() == 'select') {
					_elements[i].value = _this.find('[name="' + _elements[i].name + '"]').find('option').eq(0).attr('value');
				} else
					_elements[i].value = '';
			}
		}
	};

	Array.prototype.indexOf = function(val) {
		for ( var i = 0; i < this.length; i++) {
			if (this[i] == val)
				return i;
		}
		return -1;
	};

	Array.prototype.remove = function(val) {
		var index = this.indexOf(val);
		if (index > -1) {
			this.splice(index, 1);
		}
	};


});


/* 常用方法 */
$.extend({
	closeWin : function() {
		var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
		parent.layer.close(index);
	},
	contextPath : function() {
		var local = window.location;
		var contextPath = local.pathname.split("/")[1];
		if(contextPath != 'pages'){
			return "/" + contextPath + "/";
		}else{
			return "/"
		}
	},
	getQueryString : function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]); return null;
	}
});

