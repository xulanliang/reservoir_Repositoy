//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/tableEdit/shenyaSatatsParamInfo/addOrEdit/css/addOrEdit.css');

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
                loading2 : false ,
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
				// data["status"] = status;

				if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + 'tableEditCtrl/saveOrUpdateShenyaStatsParamInfo.do',
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
	var NOT_SINGLE_data = [
		{id:'1',text:'多测点'},{id:'0',text:'无多测点'}
	];

	$("#MON_TP_auto").combobox({
		data: MON_TP_data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#IS_AUTO_auto").combobox({
		data: IS_AUTO_data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});
	$("#NOT_SINGLE_auto").combobox({
		data: NOT_SINGLE_data,
		valueField: 'id',
		textField: 'text',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});

	//二级工程名称
	$("#PROJ_CD_TWO_auto").combobox({
		url:DSE.serverPath + '/initBaseInfoCtel/initSectionExtendInfo.do',
		valueField: 'PROJ_CD',
		textField: 'PROJ_NM',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(newValue,oldValue){
			// DSE.form.doSearch();
		},
		loadFilter:function (data) {
			return data.data;
		}
	});

	//监测项目编号
	$("#ITEM_CD_auto").combobox({
		valueField: 'ITEM_CD',
		textField: 'ITEM_NM',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(rec){
			// DSE.form.doSearch();
		}
	});


	var data = getDataInfo(DSE.serverPath + '/initBaseInfoCtel/initSectionInfo.do')["data"] || [];
	//一级工程名称
	$("#PROJ_CD_ONE_auto").combobox({
		data:data,
		valueField: 'PROJ_CD',
		textField: 'PROJ_NM',
		width: '100%',
		editable: false,
		prompt: '-请选择-',
		onChange: function(newValue,oldValue){
			var levOneID = $("#PROJ_CD_ONE_auto").combobox("getValue");
			var vv = getDataInfoExtend(DSE.serverPath + '/initBaseInfoCtel/initSectionExtendInfo.do',levOneID) || [];
			var da = getDataInfoExtend2(DSE.serverPath + '/initBaseInfoCtel/initCcxmInfo.do')["data"] || [];
			$("#PROJ_CD_TWO_auto").combobox("loadData",vv);
			$("#ITEM_CD_auto").combobox("loadData",da);
			var datVal =$("#PROJ_CD_TWO_auto").combobox("getValue");
			var datVal2 =$("#PROJ_CD_ONE_auto").combobox("getValue");
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

	function getDataInfoExtend2(url,val) {
		var $data = [];
		$.ajax({
			url: url,
			async: false,
			type:"POST",
			contentType:'application/json;charset=UTF-8',
			dataType:"json",
			// data:{"	RB_CD":val},
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
        	url: DSE.serverPath + 'tableEditCtrl/getShenyaStatsInfoById.do?id=' + app.rowId
        }) || [];

        // debugger;
		//  var dt = data.data[0]['TS'];
		// data.data[0]['TS']=parent.getTime(dt);
		DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.DSE.app.loading2 = false;
	
});