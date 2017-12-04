DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	DSE.app.projcd= $.getParam("projcd");//工程编码
	DSE.app.ppcd=$.getParam("ppcd");//一级工程编码
	//设定工程编码
	$('#projcd_auto').val(DSE.app.projcd);

 	DSE.app.doReset();


};
