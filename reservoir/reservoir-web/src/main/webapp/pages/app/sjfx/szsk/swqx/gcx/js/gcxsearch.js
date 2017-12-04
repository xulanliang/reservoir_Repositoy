DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {

	//设置工程编码
	DSE.app.projcd=$.getParam("projcd");
	//console.log(' DSE.app.projcd: '+DSE.app.projcd);
	$('#projcd_auto').val($.getParam("projcd"));

	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	//定义查询元件的选择器
	/*
	var adcd = '#adcd_auto';

	$(adcd).combotree({
		data: [{
			id: "1",
			text: "广东省",
			children: [
				{ id: "2", text: "广州市" },
				{ id: "3", text: "深圳市" },
				{ id: "4", text: "珠海市" }
			]
		}],
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		prompt: '-请选择-',
		editable: false,
		onSelect: function(rec){
			DSE.form.doSearch();
		}
	});
	*/

};
