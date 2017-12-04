


DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	//定义查询元件的选择器
	var year = '#year_auto',
			month = '#month_auto';


	//子工程编号
	$('#projcd_auto').val($.getParam("projcd"));
	//父工程编号
	$('#ppcd_auto').val($.getParam("ppcd"));

	$(year).combobox({
		url: DSE.serverPath + '/swqxCtrl/getYear.do',               //渗流：查询--基础数据Url
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		method:'GET',
		mode:'remote',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.form.doSearch();
		},
		loadFilter: function(data){
			return data.data;
		},
		onLoadSuccess: function(){
			var d = $(year).combobox('getData');
			$(year).combobox('select',d[0].id);
		}
	});

	$(month).combobox({
		data: [
			{ id: "1", text: "1月" },
			{ id: "2", text: "2月" },
			{ id: "3", text: "3月" },
			{ id: "4", text: "4月" },
			{ id: "5", text: "5月" },
			{ id: "6", text: "6月" },
			{ id: "7", text: "7月" },
			{ id: "8", text: "8月" },
			{ id: "9", text: "9月" },
			{ id: "10", text: "10月" },
			{ id: "11", text: "11月" },
			{ id: "12", text: "12月" }
		],
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
		onLoadSuccess: function(){
			var thisMonth=new Date().getMonth()+1;        //本月
			$(month).combobox("setValue",thisMonth);    //设置默认值为本月
		}
	});
};
