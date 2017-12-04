//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/zlgl/addOrEdit/css/addOrEdit.css');
require_css('css!pages/app/zlgl/css/style.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
	var _eform = require('eform');
	var _fileStyle = require('fileStyle');
	var _date97 = require('date97');

	//引入 Vue + ElementUI
	var Vue = require('vue'),
		vue_component = require('vue_component'),
		ELEMENT = require('ELEMENT');
	Vue.use(ELEMENT);

	var form = '#m-form',
		adcd = '#ADCD_auto',
		wdlx = '#INFO_TP_auto';
		// IN_DT = '#IN_DT_auto';

	DSE.uploadConfig.fileToUpload_actionUrl= '/uporDownLoadCtrl/upload.do';//上传请求
	DSE.uploadConfig.fileToUpload_deleteUrl= '/uporDownLoadCtrl/deleteFileByPkid.do?pkid='; //文件删除请求, pkid 为后台接收字段名

	var rowsLengh = document.getElementById("queTable").rows.length;
	var showOrNot = false;
	if(rowsLengh-2>1){
		showOrNot = true;
	}

	//渲染实例
	var app = new Vue({
		data: function() {
			return {
				title: parent.DSE.app.title,
				operType: parent.DSE.app.operType,
				rowId : parent.DSE.app.rowId,
				pickerOptions0: vue_component.pickerOptions0, //使用日期范围组件
				ttype :parent.DSE.app.ttype,
				flag: true, //防止多次保存
				value1 : "",
				adnm : "",
				showOrNot:showOrNot,	//删除行按钮
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
				var pkid = $("#fileListTable tr.file_tr").data("pkid");
				//字段校验
				if (data["INFO_CD"] == '') {
					$tips.msg('请输入资料编号', function () {
						$('#INFO_CD_auto').focus();
					});
					return false;
				} else if (data["INFO_TP"] == '') {
					$tips.msg('请选择文档类型', function () {
						$('#INFO_TP_auto').siblings('.textbox').addClass('textbox-focused');
					});
					return false;
				} else if (data["INFO_TITLE"] == '') {
					$tips.msg('请输入文档标题', function () {
						$('#INFO_TITLE_auto').focus();
					});
					return false;
				} else if (data["UPDATE_DT"] == '') {
					$tips.msg('请选择时间', function () {
						$('#UPDATE_DT_auto').focus();
					});
					return false;
				}else if (data["ADCD"] == '') {
					$tips.msg('请选择组织机构', function () {
						$('#ADCD_auto').siblings('.textbox').addClass('textbox-focused');
					});
					return false;
				}else if(isEmpty(pkid)){
					$tips.msg('请上传文档资料');
					return false;
				} else if(this.flag) {
					this.flag = false;
					var _newData = [];
					var $tr = $('#queTable tbody tr');
					$tr.each(function(i){
						_newData[i] = {
							"Q_TYPE":$tr.eq(i).find('input[data-id="Q_TYPE"]').combobox("getValue"),
							"Q_DEPT":$tr.eq(i).find('input[data-id="Q_DEPT"]').val(),
							"Q_QUESTION":$tr.eq(i).find('input[data-id="Q_QUESTION"]').val(),
							"Q_ADDVICE":$tr.eq(i).find('input[data-id="Q_ADDVICE"]').val(),
							"Q_DEAL":$tr.eq(i).find('input[data-id="Q_DEAL"]').val(),
							"Q_FINISH":$tr.eq(i).find('input[data-id="Q_FINISH"]').val(),
							"Q_PEOPLE":$tr.eq(i).find('input[data-id="Q_PEOPLE"]').val(),
						};
					});

					//执行保存方法
					$ajax({
						/**
						 * 保存文档基本信息
						 */
						url: DSE.serverPath + '/wdglCtrl/saveOrUpdateInfo.do',
						async: true,
						data: {
							dataStr: JSON.stringify(data),
							tabData : ""
						},
						type: 'post',
						success: function(data) {
							if(data["data"]) {
								$ajax({
										/**
									 * 保存问题清单
									 */
									url: DSE.serverPath + '/wdglCtrl/saveOrUpdateQuestion.do',
									async: true,
									data: {
										dataStr: JSON.stringify(_newData),
										tabData : ""
									},
									type: 'post',
									success: function(data) {
										if(data["data"]) {
											$tips.suc('操作成功',function() {
												// 父窗口调用方法刷新
												if(parent.DSE.form.refreshDatagrid) {
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
							} else {
								//操作失败
								$tips.err('操作失败');
							}
						},
					});
				}
			},
            doDel: function (line) {
               var rowLengh = document.getElementById("queTable").rows.length;
                // if (rowLengh==3){
                 //    $tips.err('操作失败');
				// }else{
				$("#queTable").find("tr:last").remove();
				app.getRowLen();
				//}




            },

			getRowLen:function(){
				var len = document.getElementById("queTable").rows.length;
				if(len-2>1){
					app.showOrNot=true;
				}else {
					app.showOrNot=false;
				}
			},

			/**
			 * 动态添加表格行
			 */
			doAdd: function () {
				var rowLengh = document.getElementById("queTable").rows.length;
				var combData = [{name:"安全鉴定",value:1},{name:"安全评估",value:2},{name:"巡视检查",value:3}];
				// id="Q_TYPE'+(rowLengh-1)+'_auto"
				$("#queTable").append('<tr>' +
										'<td align="center">'+(rowLengh-1) +'</td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_TYPE" id="Q_TYPE'+(rowLengh-1)+'" valType="2"/>' +
				'						 </td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_DEPT" valType="2" maxlength="30" />' +
				'						 </td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_QUESTION" valType="2" maxlength="200" />' +
				'						 </td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_ADDVICE" valType="2" maxlength="200" />' +
				'						 </td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_DEAL" valType="2" maxlength="200" />' +
				'						 </td>' +
				'						 <td>' +  //valType="2" class="Wdate" onmouseenter="WdatePicker({dateFmt:'yyyy-MM-dd'});"
					'						<input type="text" data-id="Q_FINISH" valType="2" class="Wdate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" />' +
				'						 </td>' +
				'						 <td>' +
					'						<input type="text" data-id="Q_PEOPLE" maxlength="20" valType="2" />' +
				'						 </td>' +
					'					</tr>');

				$('#Q_TYPE'+(rowLengh-1)).combobox({
					data: [{"name":"安全鉴定","value":"1"},{"name":"安全评估","value":"2"},{"name":"巡视检查","value":"3"}],
					editable: false,
					valueField: 'value',
					textField: 'name',
					width: '100%',
					panelHeight: 'auto',
					panelMaxHeight: '180px',
					prompt: '---请选择---',
					onLoadSuccess: function () {
						// $(wdlx).combobox('setValue', parent.app.ttype);
					}
				});
				app.getRowLen();
			}

		}
	}).$mount('#app');

	/**
	 *  初始化组织机构
	 */
	$(adcd).combotree({
		// data: divisionInfo,
		// url:DSE.serverPath+'/organizationController/listUserChildrenById.do',
		width: '100%',
		editable: false,
		parentField: "pid",
		idFiled: "id",
		textFiled: "name",
		queryParams: {"id":-1,"level":0},
		panelMaxHeight: '180px',
		prompt: '-请选择-',
		onLoadSuccess: function () {
			$(adcd).combotree('setValue', parent.DSE.app.adcd);
		},
		onSelect: function (rec) {
			// treeOnSelect($(adcd), rec);
		}
	});

	 $.ajax({
		url:DSE.serverPath+'/organizationController/listUserChildrenById.do',
		data:{"id":-1,"level":0},
		type:'post',
		success:function(data, textStatus){
			for(var i = 0 ; i <data.length; i++){
				data[i]['text'] = data[i]['name'];
				if(data[i]['isParent'] == 'false'){
					data[i]['children'] = [];
				}
			}
			$(adcd).combotree('loadData',data);
		}
	});


	$(wdlx).combobox({
		data: parent.wdlxData,
		editable: false,
		valueField: 'CODE',
		textField: 'NAME',
		width: '100%',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '-请选择-',
		onLoadSuccess: function () {
			$(wdlx).combobox('setValue', parent.DSE.app.ttype);
			var data_type='';
            switch (parent.DSE.app.ttype){
                case 'skdb':data_type='注册时间';
                    break;
                case 'jzwaq':data_type='鉴定通过时间';
                    break;
                case 'aqpg':data_type='评估通过时间';
                    break;
                default   :data_type='发生时间';
                    break;
            }
            $("#data_type").html(data_type);

                },
		onChange:function(newValue,oldValue){
			app.ttype=newValue;
		}
	});


	$('#Q_TYPE').combobox({
		data: [{"name":"安全鉴定","value":"1"},{"name":"安全评估","value":"2"},{"name":"巡视检查","value":"3"}],
		editable: false,
		valueField: 'value',
		textField: 'name',
		width: '100%',
		panelHeight: 'auto',
		panelMaxHeight: '180px',
		prompt: '---请选择---',
		onLoadSuccess: function () {
			// $(wdlx).combobox('setValue', parent.app.ttype);
		}
	});

	if(app.operType == 'add'){
		//表单元素初始化
		
	}else{
        //同步加载请求
        // var data = $ajax({
        // 	url: DSE.serverPath + '/yaglCtrl/getInfoById.do?id=' + app.rowId
        // }) || [];
        
        //填充数据到表单元素,easyui.dseForm.js里的方法
        // DSE.form.showFormContent(data.data[0], app.operType);
	}
	//隐藏加载图片
	parent.app.loading2 = false;

	// 执行输入校验
	DSE.form.inputLimit(form);
	
});