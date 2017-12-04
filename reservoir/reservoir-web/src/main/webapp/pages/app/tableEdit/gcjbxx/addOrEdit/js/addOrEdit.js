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
				if(data["CREATE_TIME"] == '') {
					$tips.msg('请选择创建时间', function() {
						$('#CREATE_TIME_auto').focus();
					});
					return false;
				} else if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + 'tableEditCtrl/saveOrUpdateGcjbxxInfo.do',
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

	/**
	 *  监测类型
	 * @type {*[]}
	 */
	var MON_TP_data = [
		{id:"1",text:"渗压"},{id:"2",text:"渗流"},{id:"3",text:"水平位移"},{id:"4",text:"垂直位移"},{id:"5",text:"水位"},
		{id:"6",text:"雨量"},{id:"7",text:"气温"},{id:"8",text:"深层位移"},{id:"9",text:"渡槽沉降"},
	];
	/**
	 *  监测方式
	 * @type {*[]}
	 */
	var IS_AUTO_data = [
		{id:'1',text:'自动化监测'},{id:'2',text:'非自动化监测'}
	];
	/**
	 *  多测点
	 * @type {*[]}
	 */
	var ISDISPLAY_data = [
		{id:'0',text:'显示'},{id:'1',text:'不显示'}
	];
	var DEPARTMENTID_data = [
		{id:'1001',text:'深圳部'},{id:'1002',text:'雁田部'},{id:'1003',text:'桥头部'},{id:'1004',text:'塘厦部'}
	];
	var data = [
		{id:'0',text:'没有'},{id:'1',text:'有'}
	];

	$("#ISDISPLAY_auto").combobox({
		data: ISDISPLAY_data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#DEPARTMENTID_auto").combobox({
		data: DEPARTMENTID_data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISSY_auto").combobox({
		data: data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISSW_auto").combobox({
		data: data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISDC_auto").combobox({
		data: data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISSC_auto").combobox({
		data: data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISCZ_auto").combobox({
		data: data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#ISSP_auto").combobox({
		data: data,
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
        	url: DSE.serverPath + 'tableEditCtrl/getGcjbxxlnfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法

		 var dt = data.data[0]['CREATE_TIME'];
		data.data[0]['CREATE_TIME']=parent.getTime(dt);
		DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.DSE.app.loading2 = false;

	// 执行输入校验
	DSE.form.inputLimit(form);
	
});