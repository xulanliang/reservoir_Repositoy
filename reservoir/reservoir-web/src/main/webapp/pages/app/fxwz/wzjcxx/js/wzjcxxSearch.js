DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器
    var wztype = '#wztype_auto';

    $(wztype).combobox({
        data: [
            {id: "0", text: "工程抢险机具"},
            {id: "1", text: "工程抢险物料"},
            {id: "2", text: "救生救援器材"},
            {id: "3", text: "应急照明器材"},
            {id: "4", text: "抗旱器具物料"},
            {id: "5", text: "其他"}
        ],
        valueField: 'id',
        textField: 'text',
        width: '120px',
        panelHeight: 'auto',
        editable: false,
        prompt: '-请选择-',
        onChange: function(rec){
			DSE.form.doSearch();
        }
    });

}
