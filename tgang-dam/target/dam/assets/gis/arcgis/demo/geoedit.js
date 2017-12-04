/**
 * Created by Administrator on 2016/8/26.
 */
//几何图形编辑内容保存界面.

require(["dojo/on", "dojo/dom", "dojo/domReady!"], function (on, dom) {
    //
    var graphic = window.dseGisData.graphic;
    //
    var appEvent = window.appEvent;
    //
    //
    on(dom.byId("geo-save"), "click", function (event) {
        //
        // console.log("test");
        alert("功能正在完善中...");
        //释放编辑按钮.
        /* appEvent.dispatchAppEvent(appEvent.DEACTIVATE_EDITOR, {
         //
         info: "释放工具条按钮."
         });*/
        //======================================
        // 编辑几何图形的属性信息.
        //=====================================
        var attributes={};
        //
        attributes["STNM"]=$("#title").val();
        attributes["STCD"]=$("#num").val();
        //
        graphic.setAttributes(attributes);
        //

        //保存图形.
        appEvent.dispatchAppEvent(appEvent.SAVE_EDIT_GRAPHIC, graphic);
    });
    //
    //

    on(dom.byId("geo-cancel"), "click", function (event) {
        //
        window.dseMap.infoWindow.hide();
        //
    });
    //
});
//