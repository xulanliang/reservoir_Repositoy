require_css('css!pages/app/fxwz/wzcfdxx/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('upload', function(require, exports, module) {

    var _operConfig_ = require('oper_config');
    var _eform = require('eform');
    var _date97 = require('date97');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //DSE.uploadConfig = {
    //    fileToUpload_actionUrl: '/uporDownLoadCtrl/aa.do', //上传请求
    //    fileToUpload_progressUrl: '/uporDownLoadCtrl/getUploadProgress.do?randomId=', //进度条轮询请求, randomId 为后台接收字段名
    //    fileToUpload_deleteUrl: '/uporDownLoadCtrl/deleteFileByPkid.do?pkid=', //文件删除请求, pkid 为后台接收字段名
    //    fileToUpload_FilesListUrl: '/uporDownLoadCtrl/getListFileByBid.do?bid=', //获取已上传文件列表，bid 为后台接收字段名
    //    fileToUpload_downloadUrl: '/uporDownLoadCtrl/download.do?id=', //上传成功后下载请求，id 为后台接收字段名
    //    fileToUpload_rename: {
    //        url: 'uporDownLoadCtrl/renameUpFileById.do', //上传文件重命名请求
    //        id: 'pkid', //pkid 为后台接收字段名
    //        name: 'rename' //rename 为后台接收字段名
    //    }
    //};

    var _fileStyle = require('fileStyle');

    DSE.uploadConfig.fileToUpload_actionUrl= '/uporDownLoadCtrl/uploadExcel.do';//上传请求
    DSE.uploadConfig.fileToUpload_deleteUrl= '/uporDownLoadCtrl/deleteFileByBid.do?pkid='; //文件删除请求, pkid 为后台接收字段名

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
            doCloseWin: function() {
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
            },
            doSave: function() {
                if(DSE.uploadConfig.model==null){
                    $tips.err('请上传Excel文件');
                    return;
                }else {
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + '/dataImportCtrl/readExcel.do?bid='+DSE.uploadConfig.model.newId,
                        async: true,
                        //data: {
                        //    dataStr: JSON.stringify(data)
                        //},
                        type: 'post',
                        success: function(data) {
                            if (data["data"]) {
                                $tips.suc('操作成功', function() {
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

                //获取表单值,easyui.dseForm.js的方法
                //var data = DSE.form.getAutoObject(form);

                //这里可以做一些参数处理动作
                //data["status"] = status;
            }
        }
    }).$mount('#app');
});