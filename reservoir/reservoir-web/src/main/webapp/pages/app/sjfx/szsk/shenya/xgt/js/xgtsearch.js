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
			stcd = '#stcds_auto';

	$(adcd).combotree({
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
			rb_type: $.getParam("rb_type"),
		},
		valueField: 'id',
		textField: 'text',
		width: '180px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		prompt: '-请选择-',
		editable: false,
		onSelect: function(rec){
			//console.log($(adcd).combotree('getValue').id);
			DSE.app.wrrbm_rbcd = rec.id;
			//DSE.app.doReset();
			var params={
				projcd: DSE.app.projcd,
				type: '1',
				rbcd: DSE.app.wrrbm_rbcd,
			};
			$(stcd).combobox('reload', params);

			//console.log(rec);
		},
		onLoadSuccess: function(node,data){
			if(data!=null && data.length>0){
				$(adcd).combotree('setValue',data[0].id);
				DSE.app.wrrbm_rbcd=data[0].id;
				//var params={
				//	projcd: DSE.app.projcd,
				//	type: '',
				//	rbcd: DSE.app.wrrbm_rbcd,
				//};
				//$(stcd).combobox('reload', params);

				// begin 2017-08-01 getStcd
				$(stcd).combobox({
					url: DSE.serverPath + '/shenyaCtrl/getStcd.do',
					queryParams: {
						projcd: $.getParam("projcd"),
						type: '1',
						rbcd: DSE.app.wrrbm_rbcd,
					},
					valueField: 'STCD',
					textField: 'STNM',
					width: '200px',
					panelHeight: 'auto',
					panelMaxHeight: '220px',
					multiple:false,
					prompt: '-请选择-',
					editable: false,
					onSelect: function(rec){
						//var stcds = $(stcd).combobox('getValues').toString();
						//console.log(stcds);
						DSE.app.stcd = rec.STCD;
						DSE.app.stnm=rec.STNM;
						//console.log('rec: STCD:'+rec.STCD+' STNM:'+rec.STNM+' DSE.app.stcd: '+DSE.app.stcd+' DSE.app.stnm: '+DSE.app.stnm);
						DSE.app.doReset();
					},
					loadFilter: function(data){
						return data.data;
					},
					onLoadSuccess: function(){
						var p = $(stcd).combobox('getData');
						if(p.length > 0) {
							$(stcd).combobox('select',p[0].STCD);
							DSE.app.stcd = p[0].STCD;
							DSE.app.stnm=p[0].STNM;
							//DSE.app.doReset();
						}
					}
				});

				// begin 2017-08-01 getStcd
			}
			//DSE.app.doReset();
		}
	});

};
