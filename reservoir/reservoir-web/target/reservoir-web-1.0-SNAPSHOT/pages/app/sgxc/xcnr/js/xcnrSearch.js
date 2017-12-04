/**
 * Created by pc on 2017-8-1.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.SearchFlag = true;
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    var inp_DEP = '#depID_auto';
    var inp_OBJ = '#objID_auto';
    var inp_Point = '#CK_OBJ_ID_auto';
    //所属部门
    var dep_id='';

    //var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?')["data"] || [];
    //巡查点
    $(inp_Point).combobox({
        //data: data,
        valueField: 'CK_OBJ_ID',
        textField: 'CK_NAME',
        width: 'auto',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        editable: false,
        multiple:false,
        prompt: '-请选择-',
        formatter : function(row) {
            // 试卷名称过长时截取前一段，剩余的使用..替代
            if (row.CK_NAME != null) {
                if (row.CK_NAME.length > 10) {
                    var opts = $(this).combobox('options');
                    var CK_NAME = row[opts.textField];
                    row.CK_NAME = CK_NAME.substring(0, 10)+ "...";
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
        onChange: function (rec) {
            DSE.form.doSearch();
        },
        loadFilter: function(data){
            return data.data;
        }
    });
    //巡查对象
    $(inp_OBJ).combobox({
        queryParams: {
            code:'XCDX',
        },
        valueField: 'CK_OBJECT',
        textField: 'CK_NAME',
        width: 'auto',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        formatter : function(row) {
            // 试卷名称过长时截取前一段，剩余的使用..替代
            if (row.CK_NAME != null) {
                if (row.CK_NAME.length > 10) {
                    var opts = $(this).combobox('options');
                    var CK_NAME = row[opts.textField];
                    row.CK_NAME = CK_NAME.substring(0, 10)+ "...";
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
        onChange: function(newValue,oldValue){
            if(DSE.form.SearchFlag){
                var data =getDataInfo(DSE.serverPath + '/ckxxglCtrl/getXcdListBycode.do?depID='+dep_id+'&objID='+newValue) || [];
                console.log(data);
                //初始化巡查点
                $(inp_Point).combobox("loadData",data);
                $(inp_Point).combobox("setValue",'');
                DSE.form.doSearch();
            }
        },
        loadFilter: function(data){
            return data.data;
        }
    });
    //管理部门
    $(inp_DEP).combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
        queryParams: {
            code:'SSGLBM',
        },
        valueField: 'ID',
        textField: 'NAME',
        width: '120px',
        panelHeight: 'auto',
        panelMaxHeight: '150px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(newValue,oldValue){
            dep_id = newValue;
            if(DSE.form.SearchFlag){
                //初始化巡查对象
                var data =getDataInfo(DSE.serverPath + '/sysCommonCtrl/getListCheckObj.do?ck_org='+newValue+"&code=XCDX") || [];
                $(inp_OBJ).combobox("loadData",data);
                var arr =[];
                $(inp_Point).combobox('clear');
                $(inp_OBJ).combobox("setValue",'');
                // $(inp_Point).combobox("setValue",'');
                DSE.form.doSearch();
            }
        },
        loadFilter: function(data){
            return data.data;
        }
    });

};