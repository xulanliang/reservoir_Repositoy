/**
 * Created by Administrator on 2016/12/21.
 */
define([], function () {
    //
    return {
        /**<description>获取应用程序数据</description>
         * @param dataKey Required.
         * @author wangsl
         * @date 2016-12-22
         * */
        getAppData: function (datakey) {
            //
            return window[datakey] || window.parent[datakey] || window.parent.parent[datakey];
        }
    };
});
//# sourceMappingURL=winDataUtils.js.map