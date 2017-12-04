DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch =function() {
    /* *
     * *初始化查询控件,这里根据实际查询条件去生成控件,建议统一用 js 方法生成
     * *textbox 必须设置默认值，否则重置按钮不会生效
     * */

    //定义查询元件的选择器search_ch_status

	//
	$('#wr_ma_inventory_id').val($.getParam("wr_ma_inventory_id"));
	//
	$('#wh_cd_auto').val($.getParam("wh_cd"));
	$('#ma_cd_auto').val($.getParam("ma_cd"));



}
