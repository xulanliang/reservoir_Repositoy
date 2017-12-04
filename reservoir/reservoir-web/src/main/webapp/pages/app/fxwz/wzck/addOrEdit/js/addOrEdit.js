/**
 * Created by pc on 2017-8-1.
 */
require_css('css!pages/app/demos/singletable/addOrEdit/css/addOrEdit.css');

//执行配置
require.config(DSE.requireConfig);
define('addOrEdit', function(require, exports, module) {
    var _eform = require('eform'),
        date97 = require('date97');

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
                rowId: parent.DSE.app.rowId,
                flag: true //防止多次保存
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
                console.log(data);
                //字段校验
                if (data["ORG_CD"] == '') {
                    $tips.msg('请选择管理部门', function() {
                        $('#ORG_CD_auto').focus();
                    });
                    return false;
                }else if (data["WH_CD"] == '') {
                    $tips.msg('请选择仓库', function() {
                        $('#WH_CD_auto').focus();
                    });
                    return false;
                } else if (data["MA_CD"] == '') {
                    $tips.msg('请选择物资', function() {
                        $('#MA_CD_auto').focus();
                    });
                    return false;
                }else if (data["BINNUM"] == '') {
                    $tips.msg('请输入货柜', function() {
                        $('#BINNUM_auto').focus();
                    });
                    return false;
                }else if (data["MA_PC"] == '') {
                    $tips.msg('请输入物资批次', function() {
                        $('#MA_PC_auto').focus();
                    });
                    return false;
                }else if (data["INOUT_QUAN"] == '') {
                    $tips.msg('请输入出库数量', function() {
                        $('#INOUT_QUAN_auto').focus();
                    });
                    return false;
                }else if (data["INOUT_DATE"] == '') {
                    $tips.msg('请选择出库时间', function() {
                        $('#INOUT_DATE_auto').focus();
                    });
                    return false;
                } else if (data["INPUT_USER"] == '') {
                    $tips.msg('请输入登记人', function() {
                        $('#INPUT_USER_auto').focus();
                    });
                    return false;
                } else if (this.flag) {
                    this.flag = false;
                    //执行保存方法
                    $ajax({
                        url: DSE.serverPath + 'wzkzglCtrl/saveCrkInfo.do',
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
    $("#ORG_CD_auto").hide();
    $("#WH_CD_auto").hide();
    $("#MA_CD_auto").hide();



    if (app.operType == 'add') {
        //表单元素初始化
    } else {
        //同步加载请求
        var data = $ajax({
                url: DSE.serverPath + 'wzkzglCtrl/getCrkInfoById.do?id=' + app.rowId
            }) || [];
        var value = data.data;
        value[0].INOUT_DATE = getTime(value[0].INOUT_DATE);
        value[0].CHECK_TIME = value[0].CHECK_TIME != null ? getTime(value[0].CHECK_TIME) : null;
        //填充数据到表单元素,easyui.dseForm.js里的方法
        DSE.form.showFormContent(value[0], app.operType);
        if(app.operType != 'add'){
            $('#ma_type_id_auto').hide();
            $('.ma_type_id_ori').text($('#ma_type_id_auto').val()).show();
        }
    }

    //初始化表单元素
    var type = '#ma_type_pid_auto';

    var id = $('#ma_type_id_auto').val();


    var inp_dep_name = '#ORG_CD_auto';
    var inp_ck_name = '#WH_CD_auto';
    var inp_wz_name = '#MA_CD_auto';
    $("#MA_PC_auto").val(getPC());

    if (app.operType != 'detail'){
        $(inp_dep_name).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'SSGLBM',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '150px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                var params={
                    org_cd:newVal,
                    wh_status: '',
                };
                $(inp_ck_name).combobox('reload', params);
                $(inp_ck_name).combobox("setValue","");
                $("#MODEL_auto").val("");
                $("#MU_auto").val("");

            },
            formatter: function(row){
                var opts = $(this).combobox('options');
                return '<span class="ellipsis" title="' + row[opts.textField] + '">' + row[opts.textField] + '</span>';


            },
            loadFilter: function (data) {
                return data.data;
            }
        });

        $(inp_ck_name).combobox({
            url: DSE.serverPath + '/ckxxglCtrl/getListDataByParams.do',
            queryParams: {
                org_cd:$(inp_dep_name).val(),
                wh_status: '',
            },
            valueField: 'wh_cd',
            textField: 'wh_nm',
            width: '150px',
            panelHeight: 'auto',
            panelMaxHeight: '150px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                var params={
                    code:newVal,
                    ids:$(inp_dep_name).combobox('getValue')+','+newVal,
                    state:''
                };
                var data=getDataInfo(DSE.serverPath + '/sysCommonCtrl/getListBycode2.do', params);
                $(inp_wz_name).combobox('loadData', data);
                $(inp_wz_name).combobox("setValue","");
                $("#MODEL_auto").val("");
                $("#MU_auto").val("");
            },
            formatter: function(row){
                var opts = $(this).combobox('options');
                return '<span class="ellipsis" title="' + row[opts.textField] + '">' + row[opts.textField] + '</span>';


            },
            loadFilter: function (data) {
                return data.data;
            }
        });

        $(inp_wz_name).combobox({
            //url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            //queryParams: {
            //    state:'wzmc',
            //    code:'WZMC'
            //},
            valueField: 'MA_CD',
            textField: 'MA_NM',
            width: '150px',
            panelHeight: 'auto',
            panelMaxHeight: '150px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                var depID = $(inp_dep_name).combobox('getValue');
                var ckID = $(inp_ck_name).combobox('getValue');
                var params={
                    ids:depID+','+ckID+','+newVal,
                };
                var data=getDataInfo(DSE.serverPath + '/sysCommonCtrl/getWzInfoBycode2.do', params)['data'];
                if(data != null && data.length>0){
                    $("#MODEL_auto").val(data[0].MODEL);
                    $("#MU_auto").val(data[0].MU);
                    $("#REAL_QUAN_auto").val(data[0].REAL_QUAN);
                }
            },
            formatter: function(row){
                var opts = $(this).combobox('options');
                return '<span class="ellipsis" title="' + row[opts.textField] + '">' + row[opts.textField] + '</span>';


            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }
    function getPC(){
        var dt = new Date();
        var year = dt.getFullYear();
        var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
        var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
        return year+''+month+''+day;
    }
    function getTime(value){
        var dt = new Date(value);
        var year = dt.getFullYear();
        var month = (dt.getMonth()+1)< 10 ? '0'+(dt.getMonth()+1) : dt.getMonth()+1;
        var day = dt.getDate() < 10 ? '0'+ dt.getDate() : dt.getDate();
        var hour = dt.getHours() <10 ? '0'+dt.getHours() : dt.getHours();
        var min = dt.getMinutes() <10 ? '0'+dt.getMinutes() : dt.getMinutes();
        var second = dt.getSeconds() <10 ? '0'+dt.getSeconds(): dt.getSeconds();
        return year+'-'+month+'-'+day+' '+ hour +':'+ min +':'+ second;
    }


    //隐藏加载图片
    parent.DSE.app.loading2 = false;
    if (app.operType == 'detail') {
        //影藏元素
        $("#ORG_CD_auto").hide();
    }

    // 执行输入校验
    DSE.form.inputLimit(form);

});
