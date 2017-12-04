DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器
    var MON_TP = '#MON_TP_auto'
        //IS_AUTO = '#IS_AUTO_auto';

    var nowYear = (new Date()).getFullYear(),
        $dataYears = [];

    var MON_TP_data = [
        {id:"1",text:"渗压"},{id:"2",text:"渗流"},{id:"3",text:"水平位移"},{id:"4",text:"垂直位移"},{id:"5",text:"水位"},
        {id:"6",text:"雨量"},{id:"7",text:"气温"},{id:"8",text:"深层位移"},{id:"9",text:"渡槽沉降"},
    ];

    //var IS_AUTO_data = [
    //    {id:'1',text:'自动化监测'},{id:'2',text:'非自动化监测'}
    //];

    //遍历生成年份列表数据
    for (var i = nowYear; i >= _operConfig["start_year"]; i--) {
        $dataYears.push({id: i, text: i});
    }

    /**
     *  初始化监测类型
     */
    $(MON_TP).combobox({
        data: MON_TP_data,
        valueField: 'id',
        textField: 'text',
        width: 'auto',
        editable: false,
        prompt: '-请选择-',
        onChange: function(rec){
            DSE.form.doSearch();
        }
    });
    /**
     * 初始化监测方式
     */
    //$(IS_AUTO).combobox({
    //    data: IS_AUTO_data,
    //    valueField: 'id',
    //    textField: 'text',
    //    width: 'auto',
    //    editable: false,
    //    prompt: '-请选择-',
    //    onChange: function(rec){
    //        DSE.form.doSearch();
    //    }
    //});

};
