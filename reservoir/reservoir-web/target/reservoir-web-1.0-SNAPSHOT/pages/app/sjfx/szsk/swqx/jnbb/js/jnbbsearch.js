DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */

	//定义查询元件的选择器
	var type = '#type_auto',
			year = '#year_auto',
			season = '#season_auto';

	//设定深圳水库编码
	$('#projcd_auto').val($.getParam("projcd"));

	$(year).combobox({
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
			var d = $(year).combobox('getData');
			$(year).combobox('select',d[0].id);
		}
	});

	$(season).combobox({
		data: [
			{ id: "1", text: "第一季度" },
			{ id: "2", text: "第二季度" },
			{ id: "3", text: "第三季度" },
			{ id: "4", text: "第四季度" }
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
			var data = new Date();
			var m = data.getMonth() + 1;
			if(m >= 1 && m <= 3){
				$(season).combobox('select','1');
			}else if(m >= 4 && m <= 6){
				$(season).combobox('select','2');
			}else if(m >= 7 && m <= 9){
				$(season).combobox('select','3');
			}else if(m >= 10 && m <= 12){
				$(season).combobox('select','4');
			}
		}
	});

	$(type).combobox({
		data: [
			{ id: "1", text: "按季度",selected:true },
			{ id: "2", text: "按年" }
		],
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		editable: false,
		onChange: function(rec){
			if(rec == '1'){
				$(season).next(".combo").show();
			}else{
				$(season).next(".combo").hide();
			}
			DSE.form.doSearch();
		}
	});


};
