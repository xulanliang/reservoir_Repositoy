//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/fxwz/wzjcxx/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');

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
                rowId: parent.DSE.app.rowId,
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
				if(data["WZNAME"] == '') {
					$tips.msg('请填写物资名称', function() {
						$('#WZNAME_auto').focus();
					});
					return false;
				} else if(data["WZDW"] == '') {
					$tips.msg('请填写物资计量单位', function() {
						$('#WZDW_auto').focus();
					});
					return false;
				} else if(data["WZDJ"] == '') {
					$tips.msg('请填写物资参考单价', function() {
						$('#WZDJ_auto').focus();
					});
					return false;
				}  else if(data["WZTYPE"] == '') {
					$tips.msg('请选择物资类型', function() {
						$('#WZTYPE_auto').focus();
					});
					return false;
				} else if(this.flag) {
					this.flag = false;
					//执行保存方法
					$ajax({
						url: DSE.serverPath + '/wzjcxxCtrl/saveOrUpdateInfo.do',
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

	//初始化表单元素
	var wz_type = '#WZTYPE_auto';

	$(wz_type).combobox({
		data: [
			{id: "0", text: "工程抢险机具"},
			{id: "1", text: "工程抢险物料"},
			{id: "2", text: "救生救援器材"},
			{id: "3", text: "应急照明器材"},
			{id: "4", text: "抗旱器具物料"},
			{id: "5", text: "其他"}
		],
		valueField: 'id',
		textField: 'text',
		width: '100%',
		panelHeight: 'auto',
		editable: false,
		prompt: '-请选择-'
	});

	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        var data = $ajax({
        	url: DSE.serverPath + '/wzjcxxCtrl/getInfoById.do?id=' + app.rowId
        }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法
		DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
    parent.DSE.app.loading2 = false;
	
});