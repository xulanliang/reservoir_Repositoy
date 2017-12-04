//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/fxwz/wzkzgl/addOrEdit/css/addOrEdit.css');


require_js('wzkzyl_common', 'pages/app/fxwz/js/comm_addOrEdit', ['datagrid_pager']);
require_js('wzkzyl_datagrid', 'pages/app/fxwz/wzkzgl/addOrEdit/js/wzkzylDatagrid', ['datagrid_pager']);
require_shim('stylePage', ['wzkzyl_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');
	var _operConfig_ = require('oper_config');
	var _stylePage = require('stylePage');



	//引入 Vue + ElementUI
	var Vue = require('vue'),
		vue_component = require('vue_component'),
		ELEMENT = require('ELEMENT');
	Vue.use(ELEMENT);

	var form = '#m-form';
		//var sY = '#YEAR_auto',
		//wz_name = '#WZID_auto',
		//ck_name = '#CKID_auto';

	/*
	console.log(' id :'+$.getParam('id'));
	if($.getParam('id')){
		$('.top-title').remove();
	}*/


	//渲染实例
	var app = new Vue({
		data: function() {
			return {
				title: parent.DSE.app && parent.DSE.app.title ? parent.DSE.app.title : '',
				operType: parent.DSE.app && parent.DSE.app.operType ? parent.DSE.app.operType : '',
				rowId : parent.DSE.app && parent.DSE.app.rowId ? parent.DSE.app.rowId : '',
				pickerOptions0: vue_component.pickerOptions0, //使用日期范围组件
				flag: true, //防止多次保存
				wr_ma_inventory_id : "",
				adnm : ""
			}
		},
		methods: {
			changeDateVal:function(value){
				this.tm=value;
			},
			doCloseWin: function() {
				parent.DSE.app.loading2 = true;
				parent.DSE.app.operType = '';
			},
			doSave: function() {
				//获取表单值,easyui.dseForm.js的方法
				var data = DSE.form.getAutoObject(form);

				//这里可以做一些参数处理动作
				data["status"] = status;

				//字段校验
				if(data["ORG_CD"] == '') {
					$tips.msg('请选择管理部门', function() {
						$('#ORG_CD_auto').focus();
					});
					return false;
				} else if(data["WH_CD"] == '') {
					$tips.msg('请选择仓库', function() {
						$('#WH_CD_auto').focus();
					});
					return false;
				} else if(data["MA_CD"] == '') {
					$tips.msg('请选择物资', function() {
						$('#MA_CD_auto').focus();
					});
					return false;
				} else if(data["REAL_QUAN"] == '') {
					$tips.msg('请输入物资数量', function() {
						$('#REAL_QUAN_auto').focus();
					});
					return false;
				} else if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + '/wzkzglCtrl/saveOrUpdateInfo.do',
						async: true,
						data: {
							dataStr: JSON.stringify(data)
						},
						type: 'post',
						success: function(data) {
							if(data["data"]) {
								$tips.suc('操作成功',function() {
									// 父窗口调用方法刷新
									if (parent.DSE.form.refreshDatagrid) {
										parent.DSE.form.refreshDatagrid();
									}
									parent.DSE.app.loading2 = true;
									parent.DSE.app.operType = '';
								});
							} else {
								//操作失败
								$tips.err('操作失败');
							}
						},
					});
				}
			}
		}
	}).$mount('#app');

	/*
	var nowYear = (new Date()).getFullYear(),
			$dataYears = [];

	//遍历生成年份列表数据
	for (var i = nowYear; i >= _operConfig["start_year"]; i--) {
		$dataYears.push({id: i, text: i});
	}

	$(sY).combobox({
		data: $dataYears,
		editable: false,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		prompt: '-请选择-',
		panelMaxHeight: '180px',
		onLoadSuccess: function () {
			$(sY).combobox('setValue', nowYear);
		}
	});
	*/
	/*
	var $wzData = getDataInfo(DSE.serverPath + '/wzkzglCtrl/getWzListInfo.do')["rows"] || [],
			$ckData = getDataInfo(DSE.serverPath + '/wzkzglCtrl/getCkListInfo.do')["rows"] || [];
	$(wz_name).combobox({
		data: $wzData,
		valueField: 'WZID',
		textField: 'WZNAME',
		editable: false,
		width: '100%',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '-请选择-'
	});

	$(ck_name).combobox({
		data: $ckData,
		valueField: 'CKID',
		textField: 'CKNAME',
		editable: false,
		width: '100%',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '-请选择-'
	});
	*/
	app.rowId = $.getParam('id') || app.rowId;
	app.operType = $.getParam('type') || app.operType;

	$("#search_wr_ma_inventory_id").val(app.rowId);
	
	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        var data = $ajax({
        	url: DSE.serverPath + '/wzkzglCtrl/getInfoById.do?id=' + app.rowId
        }) || [];
        //console.log(' data:'+displayProp(data)+' data.data[0]:'+displayProp(data.data[0]))
        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data.data[0], app.operType);

		//初始化查询
		//DSE.form.doSearch();
	}


	var _param2={
		search_wr_ma_inventory_id:$.getParam("id"),
		search_wh_cd:'',
		search_ma_cd:'',
		search_page:'wzkzglList',
	};
	$("#search_wr_ma_inventory_id_auto").val($.getParam("id"));
	$("#search_page").val('wzkzglList');
	//console.log(' ck_re_id: '+$.getParam("ck_re_id"));
	var _data2=[];
	//console.log('_param2:'+_param2+' : '+displayProp(_param2)+'_param2.search_ck_re_id:'+_param2.search_ck_re_id);
	//生成 datagrid
	DSE.form.initDatagrid(_param2, _data2);

	//隐藏加载图片
	if(parent.DSE.app && parent.DSE.app.loading2){
		parent.DSE.app.loading2 = false;
	}

	// 执行输入校验
	DSE.form.inputLimit(form);
	
});