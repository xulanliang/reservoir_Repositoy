/**
 * 获取当前地图范围.
 * @author wangsl
 * @date 2017-05-15
 */
define(["dojo/_base/declare", "./_BaseTool"], function (declare, _BaseTool) {
    //
    return declare([_BaseTool], {
        //
        //
        constructor: function (map) {
            //
            this.map = map;
            //
        },
        activate: function () {
            //
            var extent = this.map.extent;
            //
            // console.log(JSON.stringify(extent));
            //
            var info = [extent.xmin, extent.ymin, extent.xmax, extent.ymax];
            // alert(info);
            //
            // console.log(info);
            layer.alert(JSON.stringify(info), {
                // icon: 6,
                title: "地图范围"
            });
            //
            // layer.alert(info, {
            //     icon: 1,
            //     skin: 'layer-ext-moon'
            // })
        }
    });
});
//# sourceMappingURL=MapExtentTool.js.map 
//# sourceMappingURL=MapExtentTool.js.map