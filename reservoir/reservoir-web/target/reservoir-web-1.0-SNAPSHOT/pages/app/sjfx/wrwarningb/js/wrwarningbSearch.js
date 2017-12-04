/**
 * Created by pc on 2017-8-1.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    var id_st_tp_auto = '#st_tp_auto',
        id_wa_tp_auto= '#wa_tp_auto',
        id_wa_status_auto = '#wa_status_auto';

    if($(id_st_tp_auto).length>0){
        var st_tp_data;
        if((!(DSE.app.projcd.indexOf('3')==0))){
            st_tp_data= [
                { id: "", text: "全部" },
                { id: "0", text: "环境量" },
                { id: "3", text: "水平位移" },
                { id: "4", text: "垂直位移" },
                { id: "1", text: "渗压" },
                { id: "2", text: "渗流" },
            ];
        }else {
            st_tp_data= [
                { id: "", text: "全部" },
                { id: "3", text: "水平位移" },
                { id: "4", text: "垂直位移" },
                { id: "1", text: "渗压" },
                { id: "8", text: "深层位移" },
                { id: "9", text: "渡槽沉降" },
            ];
        }
        $(id_st_tp_auto).combobox({
            data: st_tp_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(rec){
                    DSE.form.doSearch();
            }
        });
    }

    if($(id_wa_tp_auto).length>0){
        var wa_tp_data;//    报警类型(0:无数据 1:绝对值  2:最大值 3:变幅)
        wa_tp_data= [
            { id: "", text: "全部" },
            { id: "1", text: "绝对值" },
            { id: "2", text: "最大值" },
            { id: "3", text: "变幅" },
            { id: "0", text: "无数据" },
        ];
        $(id_wa_tp_auto).combobox({
            data: wa_tp_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(rec){
                DSE.form.doSearch();
            }
        });
    }

    if($(id_wa_status_auto).length>0){
        var wa_status_data;//    报警类型(0:未读 1:绝对值  2:最大值 3:变幅)
        wa_status_data= [
            { id: "", text: "全部" },
            { id: "0", text: "未处理" },
            { id: "1", text: "已处理" },
        ];
        $(id_wa_status_auto).combobox({
            data: wa_status_data ,
            valueField: 'id',
            textField: 'text',
            width: '100px',
            panelHeight: 'auto',
            prompt: '-请选择-',
            editable: false,
            onChange: function(rec){
                DSE.form.doSearch();
            }
        });
    }


}