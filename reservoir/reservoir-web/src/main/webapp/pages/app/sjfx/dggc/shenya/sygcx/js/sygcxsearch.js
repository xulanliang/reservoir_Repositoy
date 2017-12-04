DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	//定义查询元件的选择器
	var wrprojb_proj_cd = '#wrprojb_proj_cd';

	//设定深圳水库编码
	$('#projcd_auto').val($.getParam("projcd"));

	$(wrprojb_proj_cd).combobox({
		url: DSE.serverPath + '/shenyaCtrl/getProject.do',
		queryParams: {
			projcd: $('#projcd_auto').val()
		},
		valueField: 'PROJ_CD',
		textField: 'PROJ_NM',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.app.wrprojb_proj_cd = rec;
			DSE.app.doReset();
		},
		loadFilter: function(data){
			return data.data;
		},
		onLoadSuccess: function(){
			var p = $(wrprojb_proj_cd).combobox('getData');
			if(p.length > 0) {
				DSE.app.wrprojb_proj_cd = p[0].PROJ_CD;
				$(wrprojb_proj_cd).combobox('select',p[0].PROJ_CD);
			}
		}
	});


};
