DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch =function() {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器
    var sY = '#YEAR_auto';

    var nowYear = (new Date()).getFullYear(),
        $dataYears = [];

    //遍历生成年份列表数据
    for (var i = nowYear; i >= _operConfig["start_year"]; i--) {
        $dataYears.push({id: i, text: i});
    }


    $(sY).combobox({
        data: $dataYears,
        valueField: 'id',
        textField: 'text',
        width: '90px',
        editable: false,
        prompt: '-请选择-',
        onChange: function(rec){
			DSE.form.doSearch();
        }
    });

}
