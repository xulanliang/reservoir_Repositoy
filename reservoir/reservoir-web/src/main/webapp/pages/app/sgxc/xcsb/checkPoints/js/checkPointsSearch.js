DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch =function() {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器search_ch_status
	var inp_status_auto = '#search_ch_status_auto';

	var status_data= [
		{ id: "0", text: "未开始" },
		{ id: "1", text: "进行中" },
		{ id: "2", text: "已完成" }
	];
	var problem_data= [
		{ id: "0", text: "不限" },
		{ id: "1", text: "是" },
		{ id: "2", text: "否" },
	];
	if($(inp_status_auto).length>0){
		$(inp_status_auto).combobox({
			data: status_data ,
			valueField: 'id',
			textField: 'text',
			width: '100px',
			panelHeight: 'auto',
			prompt: '-请选择-',
			editable: false,
			onChange: function(rec){
					DSE.form.doSearch();
			}
		});
	}

	//是否异常
	$("#problem_auto").combobox({
		data: problem_data ,
		valueField: 'id',
		textField: 'text',
		width: '100px',
		panelHeight: 'auto',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.form.doSearch();
		}
	});
};
