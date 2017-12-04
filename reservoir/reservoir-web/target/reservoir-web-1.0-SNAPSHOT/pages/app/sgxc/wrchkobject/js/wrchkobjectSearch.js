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
    var inp_ck_org_auto = '#CK_ORG_auto',
        inp_ck_object_auto = '#CK_OBJECT_auto',
        inp_ck_type_auto='#CK_TYPE_auto';

    $(inp_ck_org_auto).combobox({
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
        onChange: function(rec){
            //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
            console.log(' DSE.form.SearchFlag: '+DSE.form.SearchFlag);
            //DSE.app.stcds = stcds;
            if(DSE.form.SearchFlag){
                //console.log(' rec: '+rec+' displayProp:'+displayProp(rec));
                DSE.form.doSearch();
            }
        },
        loadFilter: function(data){
            return data.data;
        }
    });

    $(inp_ck_object_auto).combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
        queryParams: {
            code:'XCDX',
        },
        valueField: 'ID',
        textField: 'NAME',
        width: '120px',
        panelHeight: 'auto',
        panelMaxHeight: '150px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
            //DSE.app.stcds = stcds;
            console.log(' DSE.form.SearchFlag: '+DSE.form.SearchFlag);
            if(DSE.form.SearchFlag){
                //console.log(' rec: '+rec+' displayProp:'+displayProp(rec)  );
                DSE.form.doSearch();
            }
        },
        loadFilter: function(data){
            return data.data;
        }
    });

    $(inp_ck_type_auto).combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
        queryParams: {
            code:'XCLX',
        },
        valueField: 'ID',
        textField: 'NAME',
        width: '120px',
        panelHeight: 'auto',
        panelMaxHeight: '150px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
             //DSE.app.stcds = stcds;
            console.log(' DSE.form.SearchFlag: '+DSE.form.SearchFlag);
            if(DSE.form.SearchFlag){
                //console.log(' rec: '+rec+' displayProp:'+displayProp(rec)  );
                DSE.form.doSearch();
            }
        },
        loadFilter: function(data){
             return data.data;
        }
    });

}