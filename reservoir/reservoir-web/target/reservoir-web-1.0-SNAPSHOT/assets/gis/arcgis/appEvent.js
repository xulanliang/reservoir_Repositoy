/**
 * Created by Administrator on 2016/7/4.
 */
//
define(["dojo/topic"], function (topic) {
    //
    //
    var module = {
        /**派发系统事件*/
        dispatchAppEvent: function (eventName, data) {
            //
            topic.publish(eventName, data);
        },
        /**监听系统事件*/
        addAppEventListener: function (eventName, handler) {
            //
            var handle = topic.subscribe(eventName, handler);
            //
            return handle;
        },
    };
    /**
     *图图例状态改变事件
     * */
    module.LEGEND_STATE_CHANGE = "legendStateChange";
    /**
     * 图层添加到图层管理时触发
     * */
    module.LAYER_INTO_MANAGER = "layerIntoManager";
    /**
     * 底图加载完成事件
     * */
    module.BASE_MAP_LAYER_LOADED = "baseMapLayerLoaded";
    /**
     * 释放编辑工具
     * */
    module.DEACTIVATE_EDITOR = "deactivateEditor";
    /**
     * 保存编辑后的图形.
     * */
    module.SAVE_EDIT_GRAPHIC = "saveEditGraphic";
    /**模块图层持有图层状态变化*/
    module.MODULE_LAYER_CHANGE = "moduleLayerStateChange";
    /**图层组状态发生变化.*/
    module.GROUP_LAYER_CHANGE = "groupLayerStateChange";
    /**
     * 点击键盘ESC按钮.
     * */
    module.CLICK_KEY_ESC = "clickKeyEsc";
    return module;
});
//# sourceMappingURL=appEvent.js.map