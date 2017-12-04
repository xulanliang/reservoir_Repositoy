//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sfxx/jbxx/yagl/addOrEdit/css/addOrEdit.css');
require_css('css!pages/app/sfxx/jbxx/yagl/css/style.css');

//执行配置
require.config(_requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');
	var _fileStyle = require('fileStyle');

	//引入 Vue + ElementUI
	var Vue = require('vue'),
		vue_component = require('vue_component'),
		ELEMENT = require('ELEMENT');
	Vue.use(ELEMENT);

	var form = '#m-form',
		adcd = '#ADCD_auto',
		wdlx = '#TTYPE_auto';
	//渲染实例
	var app = new Vue({
		data: function() {
			return {
				title: parent.app.title,
				operType: parent.app.operType,
				rowId : parent.app.rowId,
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
				parent.app.loading2 = true;
				parent.app.operType = '';
			},
			doSave: function() {
				//获取表单值,easyui.dseForm.js的方法
				var data = _getAutoObject(form);

				//这里可以做一些参数处理动作
				data["status"] = status;
				var pkid = $("#fileListTable tr.file_tr").data("pkid");
				//字段校验
				if (data["ADCD"] == '') {
					$tips.msg('请选择行政区划', function () {
						$('#ADCD_auto').siblings('.textbox').addClass('textbox-focused');
					});
					return false;
				} else if (data["TTYPE"] == '') {
					$tips.msg('请选择预案类型', function () {
						$('#TTYPE_auto').siblings('.textbox').addClass('textbox-focused');
					});
					return false;
				} else if (data["BZDW"] == '') {
					$tips.msg('请填写编制单位', function () {
						$('#BZDW_auto').focus();
					});
					return false;
				} else if (data["PTITLE"] == '') {
					$tips.msg('请填写预案名称', function () {
						$('#PTITLE_auto').focus();
					});
					return false;
				} else if(isEmpty(pkid)){
					$tips.msg('请上传预案文档');
					return false;
				} else if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: _serverPath + 'yaglCtrl/saveOrUpdateInfo.do',
						async: true,
						data: {
							dataStr: JSON.stringify(data)
						},
						type: 'post',
						success: function(data) {
							if(data["data"]) {
								$tips.suc('操作成功',function() {
									// 父窗口调用方法刷新
									if(parent.refreshDatagrid) {
										parent.refreshDatagrid();
									}
									parent.app.loading2 = true;
									parent.app.operType = '';
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

	$(adcd).combotree({
		data: divisionInfo,
		width: '100%',
		editable: false,
		parentField: "PID",
		idFiled: "ID",
		textFiled: "NAME",
		//panelWidth: '100%',
		panelHeight: 'auto',
		//panelMaxHeight: '180px',
		prompt: '-请选择-',
		onLoadSuccess: function () {
			treeSetDefVal($(adcd));
		},
		onSelect: function (rec) {
			treeOnSelect($(adcd), rec);
		}
	});

	$(wdlx).combobox({
		data: parent.yalxData,
		editable: false,
		valueField: 'VALUE',
		textField: 'NAME',
		width: '100%',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '-请选择-',
		onLoadSuccess: function () {
			$(wdlx).combobox('setValue', parent.app.ttype);
		}
	});

	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        var data = $ajax({
        	url: _serverPath + 'yaglCtrl/getInfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法
		_showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.app.loading2 = false;
	
});