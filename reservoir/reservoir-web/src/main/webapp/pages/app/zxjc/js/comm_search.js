/**
 * Created by pc on 2017-7-14.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    DSE.app.projcd=$.getParam("projcd");
    $('#projcd_auto').val($.getParam("projcd"));
    var type = $.getParam("type");

    var adcd = '#wrrbm_rbcd_auto',
        stcd = '#stcds_auto';

    $(stcd).combobox({
        url: DSE.serverPath + '/shenyaCtrl/getStcd.do',
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
        multiple:true,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            var stcds = $(stcd).combobox('getValues').toString();
            DSE.app.stcds = stcds;
            DSE.form.doSearch();
        },
        loadFilter: function(data){
            return unique(data.data);
        }
    });

    /**
     * 手动去数组重复值
     * @param arr
     * @returns {Array}
     */
    function unique(arr) {
        var res = [];
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


    var proj_cd_one='';
    var proj_cd_two='';
    if(DSE.app.projcd.length<4){
        proj_cd_one=$.getParam("projcd");
    }else{
        proj_cd_two=$.getParam("projcd");
    }
    if(!(DSE.app.projcd.indexOf('3')==0)){
        var $data = $ajax({
                url: DSE.baseUrl + '/wrrbmCtrl/getWrrbmListData.do',
                data:{
                    'proj_cd_one':proj_cd_one ,
                    'proj_cd_two':proj_cd_two ,
                    'st_tp': $.getParam("st_tp"),
                    'rb_type': $.getParam("rb_type"),
                }
            }) || [];
        //$data.unshift({"id":'',"text":'-请选择-'});
        $(adcd).combotree({
            data: $data,
            valueField: 'id',
            textField: 'text',
            width: '150px',
            panelHeight: 'auto',
            panelMaxHeight: '220px',
            prompt: '-请选择-',
            editable: false,
            onSelect: function(rec){
                DSE.app.wrrbm_rbcd = rec.id;
                DSE.form.doSearch();
                var params={
                    projcd: DSE.app.projcd,
                    type: type,
                    rbcd: DSE.app.wrrbm_rbcd
                };
                $(stcd).combobox('reload', params);
            },
            onLoadSuccess: function(node,data){
                if(data!=null && data.length>0){
                    $(adcd).combotree('setValue',data[0].id);
                    DSE.app.wrrbm_rbcd = data[0].id;
                }
                DSE.form.doSearch();
            }
        });

    }

};