DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
	/* *
	 * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
	 * *textbox 必须设置默认值，否则重置按钮不会生效
	 * */
	//设置工程编码
	DSE.app.projcd=$.getParam("projcd");
	$('#projcd_auto').val($.getParam("projcd"));
	DSE.app.ppcd=$.getParam("ppcd");

	//定义查询元件的选择器
	var adcd = '#adcd_auto',
			rb_type_auto = '#rb_type_auto';
	/*
	$(rb_type_auto).combobox({
		data: [
			{id: "0",text: "横断面"},
			{id: "1",text: "纵断面"}
		],
		valueField: 'id',
		textField: 'text',
		width: '90px',
		panelHeight: 'auto',
		panelMaxHeight: '90px',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.app.rb_type =rec;
			var params={
				proj_cd_one: $.getParam("ppcd"),
				proj_cd_two: $.getParam("projcd"),
				st_tp: $.getParam("st_tp"),
				rb_type: DSE.app.rb_type ,
			};
			var adcd_options=$(adcd).combobox('options');
			if(adcd_options!=undefined && adcd_options!=null){
				$(adcd).combobox('reload', params);
			}
		},
		onLoadSuccess: function(){
			var p = $(rb_type_auto).combobox('getData');
			if(p!=null && p!=undefined &&p.length>0) {
				DSE.app.rb_type = p[0].id;

			}
		}
	});
	*/

	$(adcd).combobox({
		/*
		 data: [{
		 id: "1",
		 text: "广东省",
		 children: [
		 { id: "2", text: "广州市" },
		 { id: "3", text: "深圳市" },
		 { id: "4", text: "珠海市" }
		 ]
		 }],
		 */
		url:DSE.baseUrl+'/wrrbmCtrl/getWrrbmListData.do',
		queryParams: {
			proj_cd_one: $.getParam("ppcd"),
			proj_cd_two: $.getParam("projcd"),
			st_tp: $.getParam("st_tp"),
			//rb_type: DSE.app.rb_type ,
		},
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '-请选择-',
		editable: false,
		onChange: function(rec){
			DSE.app.wrrbm_rbcd=rec;
			DSE.app.doReset();
		},
		onLoadSuccess: function(node,data){
			var rbdata = $(adcd).combobox('getData');
			if(rbdata!=undefined && rbdata!=null){
				if(rbdata.length>0){
					$(adcd).combobox('select',rbdata[0].id);
					DSE.app.wrrbm_rbcd=rbdata[0].id;
				}else{
					$(adcd).combobox('select','-请选择-');
					/*
					 $(adcd).combobox('setValue',"");
					 DSE.app.wrrbm_rbcd='';
					 */
				}
			}
			//断面类型默认值
			/*
			if(DSE.app.rb_type!=undefined){
				$(rb_type_auto).combobox('select',DSE.app.rb_type);
			}
			*/
			//断面类型默认值
			//DSE.app.doReset();
		}
	});

	// end


};
