DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    var   stcd = '#stcds_auto';
    $(stcd).combobox({
        url: DSE.serverPath + '/shenyaCtrl/getStcd.do',
        queryParams: {
            projcd: $.getParam("projcd"),
            type: '2',
            rbcd:""
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

};