/**
 * Created by pc on 2017-8-3.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器
    var type = '#wztype_auto';

    var data = getDataInfo(DSE.serverPath + '/wzflglCtrl/getfl.do')["data"];

    $(type).combotree({
        data: data,
        parentField: "MA_TYPE_PID",
        idFiled: "MA_TYPE_ID",
        textFiled: "MA_TYPE_NAME",
        width: '200px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        prompt: '-请选择-',
        editable: false,
        onChange: function (rec) {
            DSE.form.doSearch();
        }
    });

};