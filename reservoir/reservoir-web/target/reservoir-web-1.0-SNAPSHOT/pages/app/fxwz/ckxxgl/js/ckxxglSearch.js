/**
 * Created by pc on 2017-8-2.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */
    var status = '#wh_status_auto';
    var data = getDataInfo(DSE.serverPath + '/ckxxglCtrl/getOrg.do')["data"] || [];

    $("#SSGLDW_auto").combobox({
        data: data,
        valueField: 'ID',
        textField: 'NAME',
        width: '100px',
        panelHeight: 'auto',
        panelMaxHeight: '120px',
        editable: false,
        prompt: '-请选择-',
        onChange: function(rec){
            DSE.form.doSearch();
        }
    });
    //'0','活动','1','暂挂(只出不进)','2','停止使用'
    $(status).combobox({
        data: [
            { id: "0", text: "活动" },
            { id: "1", text: "暂挂" },
            { id: "2", text: "停止使用" }
        ],
        valueField: 'id',
        textField: 'text',
        width: '100px',
        panelHeight: 'auto',
        panelMaxHeight: '120px',
        panelHeight: 'auto',
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.form.doSearch();
        }
    });

}