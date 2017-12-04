//自己扩展的js  如 
//seajs.data.alias.jquery='assets/jquery/jquery-1.9.1.min.js';

dseDefine('page', function(require, exports, module) {
	var $=require("jquery");
	
	exports.initForm = function() {
		var form = $("#myForm");
		
		
		
		form.find("#dname_auto").textbox({
			required : true,
			width : '100%',
			height : '25px',
			validType : 'maxLength[6]'
		});

		form.find("#shorttitle_auto").textbox({
			required : true,
			width : '100%',
			height : '25px',
			validType : 'maxLength[6]'
		});
		form.find("#birthday_auto").datebox({
			required : true,
			width : '100%',
			height : '25px'
		});

		form.find("#question_auto").combobox({
			required : true,
			width : '100%',
			height : '25px',
			valueField : 'lbl',
			textField : 'txt',
			data : [ {
				lbl : 'java',
				txt : 'Java语言'
			}, {
				lbl : 'perl',
				txt : 'Perl语言'
			}, {
				lbl : 'ruby',
				txt : 'Ruby语言'
			} ]
		});

	};
	
	exports.save = function() {
		if(!$("#myForm").dseValidate()){
			return;
		}
		var _json=require("json");
		var data = $("#myForm").autoFillObject();
		$("#values").text(_json.stringify(data));
	};
});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page','base_css','button_css', 'jquery', 'easyui', 'easyui_lang','easyui_valid', 'easyui_css', 'common', 'json', 'form' ], function(m) {
	module = m;
	m.initForm();
});