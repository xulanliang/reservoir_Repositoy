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

    // 执行输入校验
    DSE.form.inputLimit(form);

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
				adnm : "",
				levOneID:parent.DSE.app.levOneID,
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
				//if(data["CKNAME"] == '') {
				//	$tips.msg('请填写仓库名称', function() {
				//		$('#CKNAME_auto').focus();
				//	});
				//	return false;
				//} else
				if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + 'tableEditCtrl/saveOrUpdateMkjbxxInfo.do',
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
	var data = getDataInfo(DSE.serverPath + '/ckxxglCtrl/getOrg.do')["data"];
	var jclx = getDataInfo(DSE.serverPath + '/ckxxglCtrl/getJclx.do')["data"];
	var skData = [
		{id:1,text:'深圳水库'},{id:2,text:'雁田水库'},{id:3,text:'东改工程'}
	];
	//所属部门
	$("#ALLOWUNIT_auto").combobox({
		width:'100%',
		data:data,
		valueField:'CODE',
		textField:'NAME',
		editable:false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	//监测类型
	$("#TYPE_auto").combobox({
		width:'100%',
		data:jclx,
		valueField:'VALUE',
		textField:'NAME',
		editable:false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	//工程名称
	$("#PROJ_CD_auto").combobox({
		data: skData,
		valueField: 'id',
		textField: 'text',
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

	function getDataInfoExtend(url,val) {
		var $data = [];
		$.ajax({
			url: url,
			async: false,
			type:"POST",
			contentType:'application/json;charset=UTF-8',
			dataType:"json",
			data:{"levOneID":val},
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
        	url: DSE.serverPath + 'tableEditCtrl/getMkjbxxblnfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法

		 var dt = data.data[0]['CREATE_TIME'];
		data.data[0]['CREATE_TIME']=parent.getTime(dt);
		DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.DSE.app.loading2 = false;
	
});