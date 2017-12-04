DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
   /* /!* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * *!/
    DSE.app.projcd=$.getParam("projcd");
    DSE.app.ppcd = $.getParam("ppcd");
    $('#projcd_auto').val($.getParam("projcd"));
    $('#ppcd').val($.getParam("ppcd"));
    var type = $.getParam("type");

    var adcd = '#adcd_auto',
        stcd = '#stcds_auto';

    $(stcd).combobox({
        url: DSE.serverPath + '/fzjcCtrl/getPointsByRb.do',
        queryParams: {
            projcd: DSE.app.projcd,
            type: encodeURI(type),          // 解决中文出现乱码的问题 为中文时此处需转码 接收的时候再转一次
            rbcd: DSE.app.wrrbm_rbcd
        },
        valueField: 'STCD',
        textField: 'STNM',
        width: '200px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        multiple:false,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            var stcds = $(stcd).combobox('getValues').toString();
            console.info(rec);
            console.info(stcds);
            DSE.app.stcds = stcds;
            DSE.app.doSearch();
        },
        loadFilter: function(data){
            return unique(data.data);
        }
    });

    /!**
     * 手动去数组重复值
     * @param arr
     * @returns {Array}
     *!/
    function unique(arr) {
        var res = [];
        if(!arr){
            return res;
        }
        for(var i = 0; i < arr.length; i++){
            var repeat = false;
            for(var j = 0; j < res.length; j++){
                if(arr[i]['STNM'] == res[j]['STNM'] && res.length>0 ){
                    repeat = true;
                    break;
                }
            }
            if(!repeat){
                res.push(arr[i]);
            }
        }
        return res;
    }

    $(adcd).combobox({
        url:DSE.baseUrl+'/wrrbmCtrl/getWrrbmListData.do',
        queryParams: {
            proj_cd_one: $.getParam("ppcd"),
            proj_cd_two: $.getParam("projcd"),
            st_tp: $.getParam("st_tp"),
            //rb_type: DSE.app.rb_type ,
        },
        valueField: 'id',
        textField: 'text',
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '180px',
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.app.wrrbm_rbcd=rec;
            var params={
                projcd: DSE.app.projcd,
                type: encodeURI(type),
                rbcd: rec
            };
            debugger
            $(stcd).combobox('reload',params);
            DSE.app.doReset();
        },
        onLoadSuccess: function(node,data){
            var rbdata = $(adcd).combobox('getData');
            if(rbdata!=undefined && rbdata!=null){
                if(rbdata.length>0){
                    $(adcd).combobox('select',rbdata[0].id);
                    DSE.app.wrrbm_rbcd=rbdata[0].id;

                }else{
                    $(adcd).combobox('select','-请选择-');
                }
            }
        }
    });
*/

    DSE.app.projcd=$.getParam("projcd");
    $('#projcd_auto').val($.getParam("projcd"));
    DSE.app.ppcd=$.getParam("ppcd");

    //定义查询元件的选择器

    var adcd = '#adcd_auto',
        stcd = '#stcds_auto';

    $(adcd).combotree({
        url:DSE.baseUrl+'/wrrbmCtrl/getWrrbmListData.do',
        queryParams: {
            proj_cd_one: $.getParam("ppcd"),
            proj_cd_two: $.getParam("projcd"),
            st_tp: $.getParam("st_tp"),
            rb_type: $.getParam("rb_type"),
        },
        valueField: 'id',
        textField: 'text',
        width: '180px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        prompt: '-请选择-',
        editable: false,
        onSelect: function(rec){
            //console.log($(adcd).combotree('getValue').id);
            DSE.app.wrrbm_rbcd = rec.id;
            //DSE.app.doReset();
            var params={
                projcd: DSE.app.projcd,
                type: '1',
                rbcd: DSE.app.wrrbm_rbcd,
            };

            $(stcd).combobox('reload', params);

        },
        onLoadSuccess: function(node,data){
            if(data!=null && data.length>0){
                $(adcd).combotree('setValue',data[0].id);
                DSE.app.wrrbm_rbcd=data[0].id;
                $(stcd).combobox({
                    url: DSE.serverPath + '/shenyaCtrl/getStcd.do',
                    queryParams: {
                        projcd: $.getParam("projcd"),
                        type: '1',
                        rbcd: DSE.app.wrrbm_rbcd,
                    },
                    valueField: 'STCD',
                    textField: 'STNM',
                    width: '200px',
                    panelHeight: 'auto',
                    panelMaxHeight: '220px',
                    multiple:false,
                    prompt: '-请选择-',
                    editable: false,
                    onSelect: function(rec){
                        DSE.app.stcd = rec.STCD;
                        DSE.app.doReset();
                    },
                    loadFilter: function(data){
                        return data.data;
                    },
                    onLoadSuccess: function(){
                        var p = $(stcd).combobox('getData');
                        if(p.length > 0) {
                            $(stcd).combobox('select',p[0].STCD);
                            DSE.app.stcd = p[0].STCD;
                        }else {
                            $(stcd).combobox('clear');
                        }
                    }
                });

                // begin 2017-08-01 getStcd
            }
            //DSE.app.doReset();
        }
    });

};