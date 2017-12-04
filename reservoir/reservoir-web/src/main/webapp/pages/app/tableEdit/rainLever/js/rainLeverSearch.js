DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器
    var adcd = '#adcd_auto',
        sY = '#year_auto',
        sk = "#PROJ_NM_auto";

    var nowYear = (new Date()).getFullYear(),
        $dataYears = [];

    //遍历生成年份列表数据
    for (var i = nowYear; i >= _operConfig["start_year"]; i--) {
        $dataYears.push({id: i, text: i});
    }
    // console.log(' divisionInfo> '+divisionInfo);
    $(adcd).combotree({
        data: divisionInfo,
        parentField: "PID",
        idFiled: "ID",
        textFiled: "NAME",
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.form.doSearch();
        }
    });

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
    window.wdlxData = getDataInfo(DSE.serverPath + '/initBaseInfoCtel/initReservoirInfo.do')["data"] || [];
    $(sk).combobox({
        data: window.wdlxData,
        // url:DSE.baseUrl + '/initBaseInfoCtel/initReservoirInfo.do',
        valueField: 'PROJ_CD',
        textField: 'PROJ_NM',
        width: 'auto',
        editable: false,
        prompt: '-请选择-',
        success:function (data) {
            alert("l");
        },
        onChange: function(rec){
            DSE.form.doSearch();
        }
    });
    //获取信息
    function getDataInfo(url) {
        var $data = [];
        $.ajax({
            url: url,
            async: false,
            contentType:'application/json;charset=UTF-8',
            success: function (data) {
                $data = data;
            }
        });
        return $data;
    }

}
