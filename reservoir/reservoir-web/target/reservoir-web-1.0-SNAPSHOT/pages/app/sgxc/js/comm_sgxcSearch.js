/***
 *
 * @type {string}
 */

DSE.form.sform = "#search"; //定义form选择器
DSE.form.SearchFlag = true;
DSE.form.statusModelFlag ="wrchktask";
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    var inp_ck_org_auto = '#CK_ORG_auto',
        inp_ck_object_auto = '#CK_OBJECT_auto',
        inp_ck_object_pid_auto = '#CK_OBJECT_PID_auto',
        inp_ck_type_auto = '#CK_TYPE_auto',
        inp_ck_cycle_auto = '#CK_CYCLE_auto',
        inp_status_auto = '#STATUS_auto';

    if($(inp_ck_org_auto).length>0) {
        $(inp_ck_org_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'SSGLBM',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '100px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (rec) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                //DSE.app.stcds = stcds;
                if (DSE.form.SearchFlag) {
                    //console.log(' rec: '+rec+' displayProp:'+displayProp(rec));
                    DSE.form.doSearch();
                }else{

                }
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }
    if($(inp_ck_object_auto).length>0) {
        $(inp_ck_object_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'XCDXX',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '120px',
            panelHeight: 'auto',
            panelMaxHeight: '300px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (rec) {
                if (DSE.form.SearchFlag) {
                    //console.log(' rec: '+rec+' displayProp:'+displayProp(rec)  );
                    DSE.form.doSearch();
                }else{

                }
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }

    $(inp_ck_object_pid_auto).combobox({
        url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
        queryParams: {
            code: 'XCDX',
        },
        valueField: 'ID',
        textField: 'NAME',
        width: '120px',
        panelHeight: 'auto',
        panelMaxHeight: '300px',
        multiple: false,
        prompt: '-请选择-',
        editable: false,
        onChange: function (rec) {
            if (DSE.form.SearchFlag) {
                //console.log(' rec: '+rec+' displayProp:'+displayProp(rec)  );
                DSE.form.doSearch();
            }else{

            }
        },
        loadFilter: function (data) {
            return data.data;
        }
    });

    if($(inp_ck_type_auto).length>0) {
        $(inp_ck_type_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'XCLX',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '100px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (rec) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                if (DSE.form.SearchFlag) {
                    //console.log(' rec: '+rec+' displayProp:'+displayProp(rec)  );
                    DSE.form.doSearch();
                }else{

                }
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }

    if($(inp_ck_cycle_auto).length>0) {
        $(inp_ck_cycle_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'XC_CYCLE',
            },
            valueField: 'CODE',
            textField: 'NAME',
            width: '100px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (rec) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
               // console.log(' DSE.form.SearchFlag: ' + DSE.form.SearchFlag);
                //DSE.app.stcds = stcds;
               // if (DSE.form.SearchFlag) {
                    //console.log(' rec: '+rec+' displayProp:'+displayProp(rec));
                   // DSE.form.doSearch();
               // }
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }

    //状态(0:不活动 ;   1:启用状态 ; 2:暂停状态)
    //状态(0:未开始;   1:进行中 ; 2:已完成)
    if("wrchkredchild"==DSE.form.statusModelFlag){
        inp_status_auto="#CH_STATUS_auto";
    }
    if($(inp_status_auto).length>0){
        var status_data;
        if("wrchktask"==DSE.form.statusModelFlag){
            status_data= [
                { id: "0", text: "不活动" },
                { id: "1", text: "启用状态" },
                { id: "2", text: "暂停状态" }
            ];
        }else if("wrchkrecord"==DSE.form.statusModelFlag || "wrchkredchild"==DSE.form.statusModelFlag ){
            status_data= [
                { id: "0", text: "未开始" },
                { id: "1", text: "进行中" },
                { id: "2", text: "已完成" }
            ];
        }
        $(inp_status_auto).combobox({
            data: status_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(rec){
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });
    }

}