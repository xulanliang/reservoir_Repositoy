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
        inp_ck_type_auto = '#CK_TYPE_auto',
        id_ck_obj_pid = '#CK_OBJ_PID_auto',
        id_notckobjid = '#CK_OBJ_ID_auto',
        inp_ck_cycle_auto = '#CK_CYCLE_auto',
        inp_status_auto = '#STATUS_auto';

    if("wrchktask"==DSE.form.statusModelFlag || "wrchkrecord"==DSE.form.statusModelFlag){
        id_ck_obj_pid="#CK_OBJ_ID_auto";
        id_notckobjid="#null";
    }

    var data_ck_obj_pid_param = {
        notckobjid: $(id_notckobjid).val(),
        ck_item: '0',
        ck_org: $(inp_ck_org_auto).val(),
        ck_object: $(inp_ck_object_auto).val(),
        ck_type: $(inp_ck_type_auto).val(),
    };

    var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do', data_ck_obj_pid_param)["data"];
    if($(id_ck_obj_pid).length>0) {
        $(id_ck_obj_pid).combotree({
            data: data,
            parentField: "CK_OBJ_PID",
            idFiled: "CK_OBJ_ID",
            textFiled: "CK_NAME",
            width: '33%',
            editable: false,
            panelHeight: 'auto',
            prompt: '-请选择-',
            //formatter : function(row) {
            //    // 试卷名称过长时截取前一段，剩余的使用..替代
            //    if (row.CK_NAME != null) {
            //        if (row.CK_NAME.length > 10) {
            //            var opts = $(this).combobox('options');
            //            var CK_NAME = row[opts.textField];
            //            row.CK_NAME = CK_NAME.substring(0, 10)+ "...";
            //            // 将截取到的内容及全部内容设置到tip提示框中，
            //            //title表示提示框的内容，是截取前的值；
            //            //li中的value值表示下拉项的值，是截取后的值
            //            return '<li title="' + CK_NAME
            //                + '" class="tip">'
            //                + row[opts.textField] + '</li>';
            //        }
            //    }
            //    return '<li title="' + row.CK_NAME
            //        + '" class="tip">' + row.CK_NAME
            //        + '</li>';
            //
            //},
            /*
             loadFilter: function (data) {
             return data.data;
             }
             */
        });
    }

    if($(inp_ck_org_auto).length>0) {
        $(inp_ck_org_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'SSGLBM',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '120px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }else{
                    if("wrchkobject"==DSE.form.statusModelFlag || "wrchktask"==DSE.form.statusModelFlag
                        || "wrchkrecord"==DSE.form.statusModelFlag ){
                        if($(id_ck_obj_pid).length>0) {
                            data_ck_obj_pid_param = {
                                notckobjid: $(id_notckobjid).val(),
                                ck_item: '0',
                                ck_org: $(inp_ck_org_auto).val(),
                                ck_object: $(inp_ck_object_auto).val(),
                                ck_type: $(inp_ck_type_auto).val(),
                            };
                            data_ck_obj_pid_param.ck_org=newVal;
                            var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do',data_ck_obj_pid_param)["data"];
                            console.log(' data_param: '+displayProp(data_ck_obj_pid_param)+' data :'+data);
                            $(id_ck_obj_pid).combotree('loadData', data);
                            $(id_ck_obj_pid).combotree("setValue",'');
                        }
                    }

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
            onChange: function (newVal,nowVal) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                console.log(' DSE.form.SearchFlag: ' + DSE.form.SearchFlag);
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }else{
                    if("wrchkobject"==DSE.form.statusModelFlag|| "wrchktask"==DSE.form.statusModelFlag
                        || "wrchkrecord"==DSE.form.statusModelFlag ){
                        if($(id_ck_obj_pid).length>0) {
                            console.log('newVal:'+newVal);
                            data_ck_obj_pid_param = {
                                notckobjid: $(id_notckobjid).val(),
                                ck_item: '0',
                                ck_org: $(inp_ck_org_auto).val(),
                                ck_object: $(inp_ck_object_auto).val(),
                                //ck_type: $(inp_ck_type_auto).val(),
                            };
                            data_ck_obj_pid_param.ck_object=newVal;
                            var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do',data_ck_obj_pid_param)["data"];
                            console.log(' data_param: '+displayProp(data_ck_obj_pid_param)+' data :'+data);
                            $(id_ck_obj_pid).combotree('loadData', data);
                            $(id_ck_obj_pid).combotree("setValue",'');
                        }
                    }
                }
            },
            loadFilter: function (data) {
                return data.data;
            }
        });
    }

    if($(inp_ck_type_auto).length>0) {
        $(inp_ck_type_auto).combobox({
            url: DSE.serverPath + '/sysCommonCtrl/getListBycode2.do',
            queryParams: {
                code: 'XCLX',
            },
            valueField: 'ID',
            textField: 'NAME',
            width: '120px',
            panelHeight: 'auto',
            panelMaxHeight: '120px',
            multiple: false,
            prompt: '-请选择-',
            editable: false,
            onChange: function (newVal,nowVal) {
                //var stcds = $(inp_ck_org_auto).combobox('getValues').toString();
                if (DSE.form.SearchFlag) {
                    DSE.form.doSearch();
                }else{
                    if("wrchkobject"==DSE.form.statusModelFlag|| "wrchktask"==DSE.form.statusModelFlag
                        || "wrchkrecord"==DSE.form.statusModelFlag ){
                        if($(id_ck_obj_pid).length>0) {
                            data_ck_obj_pid_param = {
                                notckobjid: $(id_notckobjid).val(),
                                ck_item: '0',
                                ck_org: $(inp_ck_org_auto).val(),
                                ck_object: $(inp_ck_object_auto).val(),
                                //ck_type: $(inp_ck_type_auto).val(),
                            };
                            data_ck_obj_pid_param.ck_type=newVal;
                            var data = getDataInfo(DSE.serverPath + '/wrchkobjectCtrl/getWrChkObjectList.do',data_ck_obj_pid_param)["data"];
                            console.log(' data_param: '+displayProp(data_ck_obj_pid_param)+' data :'+data);
                            $(id_ck_obj_pid).combotree('loadData', data);
                            $(id_ck_obj_pid).combotree("setValue",'');
                        }
                    }
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
            width: '120px',
            panelHeight: 'auto',
            panelMaxHeight: '300px',
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
            width: '120px',
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