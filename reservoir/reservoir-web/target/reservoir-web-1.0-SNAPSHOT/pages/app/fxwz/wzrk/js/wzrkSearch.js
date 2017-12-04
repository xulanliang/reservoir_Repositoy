/**
 * Created by pc on 2017-8-1.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    var inp_dep_name = '#dep_name_auto';
    var inp_ck_name = '#ck_auto';
    var statu_auto_Data = [
        {id:0,text:'创建'},
        {id:1,text:'审批中'},
        {id:2,text:'代收发料'},
        {id:3,text:'已完成'},
        {id:4,text:'取消'},
    ];

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
            DSE.form.doSearch();
            var params={
                org_cd:newVal,
                wh_status: '',
            };
            $(inp_ck_name).combobox('reload', params);
            $(inp_ck_name).combobox("setValue","");
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
            DSE.form.doSearch();
        },
        loadFilter: function (data) {
            return data.data;
        }
    });

    /**
     *  状态
     */
    $("#statu_auto").combobox({
        data:statu_auto_Data,
        valueField: 'id',
        textField: 'text',
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '150px',
        multiple: false,
        prompt: '-请选择-',
        editable: false,
        onChange: function (newVal,nowVal) {
            DSE.form.doSearch();
        }
    });


};