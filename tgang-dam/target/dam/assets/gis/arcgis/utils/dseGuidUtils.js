/**
 * Created by Administrator on 2016/8/1.
 */

//
define(["dojo/_base/declare"], function (declare) {
    //
    var module = (function () {
        //
        return {
            /**生成唯一ID*/
            uuid: function () {
                //
                return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
                    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
                    return v.toString(16);
                });
            }
        };
    })();
    //
    return module;
});