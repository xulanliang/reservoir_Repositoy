/***
 *
 * @type {string}
 */

DSE.form.sform = "#search"; //定义form选择器
DSE.form.SearchFlag = true;
DSE.form.statusModelFlag ="wzkzglList";
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    var inp_ck_org_auto = '#org_cd_auto',
        inp_wh_cd_auto = '#wh_cd_auto',
        type = '#wztype_auto',
        id_wa_tp_auto= '#wa_tp_auto',
        id_pa_status_auto= '#pa_status_auto',
        id_wa_status_auto = '#wa_status_auto',
        inp_status_auto = '#ma_status_auto';

    /*
    var data_ck_obj_pid_param = {
        notckobjid: $(id_notckobjid).val(),
        ck_item: '0',
        ck_org: $(inp_ck_org_auto).val(),
        ck_object: $(inp_ck_object_auto).val(),
        ck_type: $(inp_ck_type_auto).val(),
    };
    var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do', data_ck_obj_pid_param)["data"];
    */

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
            onChange: function (newVal,nowVal) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                // console.log(' DSE.form.SearchFlag: ' + DSE.form.SearchFlag);
                //DSE.app.stcds = stcds;
                if (DSE.form.SearchFlag) {
                    //console.log(' rec: '+rec+' displayProp:'+displayProp(rec));
                    DSE.form.doSearch();
                }else{

                }
                var params={
                    org_cd:newVal,
                    wh_status: '',
                };
                $(inp_wh_cd_auto).combobox('reload', params);
                $(inp_wh_cd_auto).combobox("setValue","");
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }


    if($(inp_wh_cd_auto).length>0) {
        $(inp_wh_cd_auto).combobox({
            url: DSE.serverPath + '/ckxxglCtrl/getListDataByParams.do',
            queryParams: {
                org_cd:$(inp_ck_org_auto).val(),
                wh_status: '',
            },
            valueField: 'wh_cd',
            textField: 'wh_nm',
            width: '150px',
            panelHeight: 'auto',
            panelMaxHeight: '350px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                console.log(' DSE.form.SearchFlag: ' + DSE.form.SearchFlag);
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

    //状态(0:不活动 ;   1:启用状态 ; 2:暂停状态)
    if($(inp_status_auto).length>0){
        var status_data;
        if("wzkzglList"==DSE.form.statusModelFlag){
            status_data= [
                { id: "0", text: "活动" },
                { id: "1", text: "暂挂" },
                { id: "2", text: "停止使用" }
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
            onChange: function(newVal,nowVal){
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });
    }

    if($(type).length>0){
        var data = getDataInfo(DSE.serverPath + '/wzflglCtrl/getfl.do')["data"];
        $(type).combotree({
            data: data,
            parentField: "MA_TYPE_PID",
            idFiled: "MA_TYPE_ID",
            textFiled: "MA_TYPE_NAME",
            width: '160px',
            panelHeight: 'auto',
            panelMaxHeight: '220px',
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });

    }


    if($(id_wa_tp_auto).length>0){
        var wa_tp_data;//    报警类型(0:无数据 1:绝对值  2:最大值 3:变幅)
        wa_tp_data= [
            { id: "", text: "全部" },
            { id: "0", text: "小于存储定额" },
            { id: "1", text: "超年限" },
        ];
        $(id_wa_tp_auto).combobox({
            data: wa_tp_data ,
            valueField: 'id',
            textField: 'text',
            width: '150px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(newVal,nowVal){
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });
    }

    if($(id_wa_status_auto).length>0){
        var wa_status_data;//    报警类型(0:未读 1:绝对值  2:最大值 3:变幅)
        wa_status_data= [
            { id: "", text: "全部" },
            { id: "0", text: "未读" },
            { id: "1", text: "已读" },
            { id: "2", text: "已处理"}
        ];
        $(id_wa_status_auto).combobox({
            data: wa_status_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(newVal,nowVal){
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });
    }

    if($(id_pa_status_auto).length>0){
        var status_data;
            status_data= [
                { id: "0", text: "未开始" },
                { id: "1", text: "进行中" },
                { id: "2", text: "已完成" }
            ];
        $(id_pa_status_auto).combobox({
            data: status_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(newVal,nowVal){
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }
            }
        });
    }



}