//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/fxwz/wzcfdxx/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');
	var _date97 = require('date97');

	//引入 Vue + ElementUI
	var Vue = require('vue'),
		vue_component = require('vue_component'),
		ELEMENT = require('ELEMENT');
	Vue.use(ELEMENT);

	var form = '#m-form';

	//渲染实例
	var app = new Vue({
		data: function() {
			return {
				title: parent.DSE.app.title,
				operType: parent.DSE.app.operType,
				rowId : parent.DSE.app.rowId,//主键 id
				tm:parent.DSE.app.tm,	//采集时间
				batch:false, //判断显示隐藏
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
				/*if(data["CKNAME"] == '') {
					$tips.msg('请填写仓库名称', function() {
						$('#CKNAME_auto').focus();
					});
					return false;
				} else*/ if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + 'tableEditCtrl/saveOrUpdateCdjcxxbInfo.do',
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
	//模块名称
	$("#MDCD_auto").combobox({
		valueField: 'MDCD',
		textField: 'MDNAME',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});

	//监测方式
	var typeData = getDataInfo(DSE.serverPath + 'ckxxglCtrl/getGetType.do')["data"];
	//测点测量状态
	var cdclzt = getDataInfo(DSE.serverPath + 'ckxxglCtrl/getCdclzt.do')["data"];
	//获取一级工程名称
	var projectName = getDataInfo(DSE.serverPath + 'ckxxglCtrl/getProject.do')["data"];

	//监测方式
	$("#TYPEID_auto").combobox({
		data: typeData,
		valueField: 'VALUE',
		textField: 'NAME',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	//一级工程
	$("#PROJ_CD_auto").combobox({
		data: projectName,
		valueField: 'PROJ_CD',
		textField: 'PROJ_NM',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(newValue,oldValue){
			// DSE.form.doSearch();
			var MDNAME = getDataInfo(DSE.serverPath + 'ckxxglCtrl/getMDNAME.do?PROJ_CD='+newValue)["data"];
			$("#MDCD_auto").combobox("loadData",MDNAME);
		}
	});
	$("#ONMEA_auto").combobox({
		data: cdclzt,
		valueField: 'VALUE',
		textField: 'NAME',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISJIDIAN_auto").combobox({
		data: [{"VALUE":1,"NAME":"基点"},{"VALUE":0,"NAME":"测点"}],
		valueField: 'VALUE',
		textField: 'NAME',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});

	//获取信息
	function getDataInfo(url) {
		var $data = [];
		$.ajax({
			url: url,
			async: false,
			contentType:'application/json;charset=UTF-8',
			success: function (data) {
				$data = data;
			}
		});
		return $data;
	}

	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        var data = $ajax({
        	url: DSE.serverPath + 'tableEditCtrl/getCdjcxxbInfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法

		 var dt = data.data[0]['TS'];
		data.data[0]['TS']=parent.getTime(dt);
		DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.DSE.app.loading2 = false;

	// 执行输入校验
	DSE.form.inputLimit(form);
	
});