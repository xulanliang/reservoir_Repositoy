/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');
//require_js('wrchkobject_search', 'pages/app/sgxc/wrchkobject/js/wrchkobjectSearch', ['eform']);
//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform');
    var _date97 = require('date97');

    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        //wrchkobject_search = require('wrchkobject_search'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var form = '#m-form';
    $("#CK_CNT_ID_auto").hide();


    //渲染实例
    var app = new Vue({
        data: function() {
            return {
                title: parent.DSE.app.title,
                operType: parent.DSE.app.operType,
                rowId: parent.DSE.app.rowId,
                flag: true, //防止多次保存
                ck_item:$.getParam("ck_item"),//对象分类,
                checkID:parent.DSE.app.checkID, //巡查点id
            }
        },
        methods: {
            doCloseWin: function() {
                parent.DSE.app.loading2 = true;
                parent.DSE.app.operType = '';
            },
            doSave: function() {
                //获取表单值,easyui.dseForm.js的方法
                var data = DSE.form.getAutoObject(form);
                //if(app.operType == 'add'){
                //    data.CK_OBJ_ID=app.checkID;
                //}
                //字段校验
                if (data["CK_ORG"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#CK_ORG_auto').focus();
                    });
                    return false;
                } else if (data["CK_OBJECT"] == '') {
                    $tips.msg('请选择巡查对象', function() {
                        $('#CK_OBJECT_auto').focus();
                    });
                    return false;
                }else if (data["CK_OBJ_ID"] == '') {
                    $tips.msg('请选择巡查点', function() {
                        $('#CK_OBJ_ID_auto').focus();
                    });
                    return false;
                } else if (data["CK_CNT_DESC"] == '') {
                    $tips.msg('请输入巡查内容', function() {
                        $('#CK_CNT_DESC_auto').focus();
                    });
                    return false;
                } else if (data["CK_TAG_DESC"] == '') {
                    $tips.msg('请输入巡查标准', function() {
                        $('#CK_TAG_DESC_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + '/wrchkobjectCtrl/saveOrUpdateXcnrInfo.do?id='+app.checkID,
                        async: true,
                        data: {
                            dataStr: JSON.stringify(data)
                        },
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
            }
        }
    }).$mount('#app');


    var inp_DEP = '#CK_ORG_auto';
    var inp_OBJ = '#CK_OBJECT_auto';
    var inp_Point = '#CK_OBJ_ID_auto';
    //所属部门
    var dep_id='';

    //var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?')["data"] || [];
    //巡查点
    $(inp_Point).combobox({
        //data: data,
        valueField: 'CK_OBJ_ID',
        textField: 'CK_NAME',
        width: '30%',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        editable: false,
        multiple:false,
        prompt: '-请选择-',
        onChange: function (rec) {
            //DSE.form.doSearch();
        },
        loadFilter: function(data){
            return data.data;
        },
        formatter : function(row) {
            // 试卷名称过长时截取前一段，剩余的使用..替代
            if (row.CK_NAME != null) {
                if (row.CK_NAME.length > 10) {
                    var opts = $(this).combobox('options');
                    var CK_NAME = row[opts.textField];
                    row.CK_NAME = CK_NAME.substring(0, 14)+ "...";
                    // 将截取到的内容及全部内容设置到tip提示框中，
                    //title表示提示框的内容，是截取前的值；
                    //li中的value值表示下拉项的值，是截取后的值
                    return '<li title="' + CK_NAME
                        + '" class="tip">'
                        + row[opts.textField] + '</li>';
                }
            }
            return '<li title="' + row.CK_NAME
                + '" class="tip">' + row.CK_NAME
                + '</li>';

        },
    });
    //巡查对象
    $(inp_OBJ).combobox({
        queryParams: {
            code:'XCDX',
        },
        valueField: 'CK_OBJECT',
        textField: 'CK_NAME',
        width: '30%',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(newValue,oldValue){
            var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?depID='+dep_id+'&objID='+newValue) || [];
            //初始化巡查点
            $(inp_Point).combobox("loadData",data);
            $(inp_Point).combobox("setValue",'');
            //DSE.form.doSearch();
        },
        loadFilter: function(data){
            return data.data;
        },
        formatter : function(row) {
            // 试卷名称过长时截取前一段，剩余的使用..替代
            if (row.CK_NAME != null) {
                if (row.CK_NAME.length > 10) {
                    var opts = $(this).combobox('options');
                    var CK_NAME = row[opts.textField];
                    row.CK_NAME = CK_NAME.substring(0, 14)+ "...";
                    // 将截取到的内容及全部内容设置到tip提示框中，
                    //title表示提示框的内容，是截取前的值；
                    //li中的value值表示下拉项的值，是截取后的值
                    return '<li title="' + CK_NAME
                        + '" class="tip">'
                        + row[opts.textField] + '</li>';
                }
            }
            return '<li title="' + row.CK_NAME
                + '" class="tip">' + row.CK_NAME
                + '</li>';
        },
    });
    //管理部门
    $(inp_DEP).combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
        queryParams: {
            code:'SSGLBM',
        },
        valueField: 'ID',
        textField: 'NAME',
        width: '30%',
        panelHeight: 'auto',
        panelMaxHeight: '150px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(newValue,oldValue){
            dep_id = newValue;
            //初始化巡查对象
            var data =getDataInfo(DSE.serverPath + '/sysCommonCtrl/getListCheckObj.do?ck_org='+newValue+"&code=XCDX") || [];
            $(inp_OBJ).combobox("loadData",data);
            $(inp_OBJ).combobox("setValue",'');
            $(inp_Point).combobox("setValue",'');
            //DSE.form.doSearch();
        },
        loadFilter: function(data){
            return data.data;
        }
    });

    var getTime = function (tm) {
        var dt = new Date(tm);
        var year = dt.getFullYear();
        var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
        var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
        var hour = dt.getHours() <10 ? '0'+dt.getHours() : dt.getHours();
        var min = dt.getMinutes() <10 ? '0'+dt.getMinutes() : dt.getMinutes();
        var second = dt.getSeconds() <10 ? '0'+dt.getSeconds(): dt.getSeconds();
        return year+'-'+month+'-'+day+' '+ hour +':'+ min +':'+ second;
    };
    function getDataInfo(url, param, type, contentType) {
        var $data = [];
        $.ajax({
            type: type || 'get',
            url: url,
            async: false,
            data: param || {},
            dataType: 'json',
            contentType: contentType || 'application/x-www-form-urlencoded',
            success: function (data) {
                $data = data;
            }
        });
        return $data;
    }

    if (app.operType == 'add') {
        //表单元素初始化
        //var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?')["data"] || [];
        //$("#CK_OBJ_ID_auto").combobox({
        //    data: data,
        //    valueField: 'CK_OBJ_ID',
        //    textField: 'CK_NAME',
        //    width: '40%',
        //    editable: false,
        //    prompt: '-请选择-',
        //    onChange: function (rec) {
        //    }
        //});

        //设定
        //$('#CK_ITEM_auto').val(app.ck_item);
        //DSE.form.SearchFlag =false;
        //DSE.form.initSearch();

    } else {
        //同步加载请求
        //var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?')["data"] || [];
        //if('edit'==app.operType) {
        //    $("#CK_OBJ_ID_auto").combobox({
        //        data: data,
        //        valueField: 'CK_OBJ_ID',
        //        textField: 'CK_NAME',
        //        width: '40%',
        //        editable: false,
        //        prompt: '-请选择-',
        //        onChange: function (rec) {
        //        }
        //    });
        //}

        var data = $ajax({
                url: DSE.serverPath + '/wrchkobjectCtrl/getXcnrInfoById.do?id=' + app.rowId
            }) || [];

        if('edit'==app.operType){
        }
        //填充数据到表单元素,easyui.dseForm.js里的方法
        data.data[0].TS = getTime(data.data[0].TS);
        DSE.form.showFormContent(data.data[0], app.operType);

        if(app.operType != 'add'){
            //$(inp_ck_obj_id).hide();
            //$('.CK_OBJ_ID_ori').text($(inp_ck_obj_id).val()).show();
        }
    }

    //隐藏加载图片
    parent.DSE.app.loading2 = false;

    // 执行输入校验
    DSE.form.inputLimit(form);

});
