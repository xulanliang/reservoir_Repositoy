//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/fxwz/wzcfxx/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');
	var _operConfig_ = require('oper_config');

	//引入 Vue + ElementUI
	var Vue = require('vue'),
		vue_component = require('vue_component'),
		ELEMENT = require('ELEMENT');
	Vue.use(ELEMENT);

	var form = '#m-form',
		sY = '#YEAR_auto',
		wz_name = '#WZID_auto',
		ck_name = '#CKID_auto';
	
	if($.getParam('id')){
		$('.top-title').remove();
	}
	// 执行输入校验
	DSE.form.inputLimit(form);
	//渲染实例
	var app = new Vue({
		data: function() {
			return {
				title: parent.DSE.app && parent.DSE.app.title ? parent.DSE.app.title : '',
				operType: parent.DSE.app && parent.DSE.app.operType ? parent.DSE.app.operType : '',
				rowId : parent.DSE.app && parent.DSE.app.rowId ? parent.DSE.app.rowId : '',
				pickerOptions0: vue_component.pickerOptions0, //使用日期范围组件
				flag: true, //防止多次保存
				value1 : "",
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
				if(data["WZID"] == '') {
					$tips.msg('请选择物资名称', function() {
						$('#WZID_auto').focus();
					});
					return false;
				} else if(data["CKID"] == '') {
					$tips.msg('请选择仓库名称', function() {
						$('#CKID_auto').focus();
					});
					return false;
				} else if(data["YEAR"] == '') {
					$tips.msg('请选择年份', function() {
						$('#YEAR_auto').focus();
					});
					return false;
				} else if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + '/wzcfxxCtrl/saveOrUpdateInfo.do',
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

	var $wzData = getDataInfo(DSE.serverPath + '/wzcfxxCtrl/getWzListInfo.do')["rows"] || [],
			$ckData = getDataInfo(DSE.serverPath + '/wzcfxxCtrl/getCkListInfo.do')["rows"] || [];
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

	app.rowId = $.getParam('id') || app.rowId;
	app.operType = $.getParam('type') || app.operType;
	
	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        var data = $ajax({
        	url: DSE.serverPath + '/wzcfxxCtrl/getInfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(data[0], app.operType);
	}
	//隐藏加载图片
	if(parent.DSE.app && parent.DSE.app.loading2){
		parent.DSE.app.loading2 = false;
	}
	
});