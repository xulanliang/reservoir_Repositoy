DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch =function() {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器search_ch_status
	var ques_status_auto = '#ques_status_auto';

	var status_data= [
		{ id: "0", text: "新建" },
		{ id: "1", text: "解决中" },
		{ id: "2", text: "已解决" },
		{ id: "3", text: "未解决" }
	];
	if($(ques_status_auto).length>0){
		$(ques_status_auto).combobox({
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
};
