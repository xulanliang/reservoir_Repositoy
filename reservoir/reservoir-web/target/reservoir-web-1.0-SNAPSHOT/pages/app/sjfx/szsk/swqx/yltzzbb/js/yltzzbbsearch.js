DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	//定义查询元件的选择器
	var syear = '#syear_auto',
			eyear = '#eyear_auto';

	//设定深圳水库编码
	$('#projcd_auto').val($.getParam("projcd"));

	$(syear).combobox({
		url: DSE.serverPath + '/swqxCtrl/getYear.do',
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.form.doSearch();
		},
		loadFilter: function(data){
			return data.data;
		},
		onLoadSuccess: function(){
			var d = $(syear).combobox('getData');
			$(syear).combobox('select',d[0].id);
		}
	});

	$(eyear).combobox({
		url: DSE.serverPath + '/swqxCtrl/getYear.do',
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.form.doSearch();
		},
		loadFilter: function(data){
			return data.data;
		},
		onLoadSuccess: function(){
			var d = $(eyear).combobox('getData');
			$(eyear).combobox('select',d[0].id);
		}
	});


};
