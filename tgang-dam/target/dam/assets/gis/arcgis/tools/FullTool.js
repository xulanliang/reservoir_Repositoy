/**
 * Created by Administrator on 2016/7/22.
 */

define(["dojo/_base/declare", "./_BaseTool"], function (declare, _BaseTool) {
    //
    //
    var FULL_SCREEN = "全屏";
    var EXIT = "退出";
    return declare([_BaseTool], {
        //
        constructor: function (ctx) {
            //
        },
        activate: function (isInFrame) {
            //
            if (isInFrame) {
                /**
                 * 不嵌入框架时的全屏
                 * */
                this._fullScreenState(window.parent.document);

            } else {
                /**
                 * 不嵌入框架时的全屏
                 * */
                this._fullScreenState(window.document);
            }
        },
        /**
         * 嵌入框架时的全屏
         * */
        _fullScreenState: function (document) {
            //
            var info = $(this.domNode).html();
            if (!document.fullscreenElement && !document.mozFullScreenElement && !document.webkitFullscreenElement && !document.msFullscreenElement) {  // current working methods
                var elem = document.documentElement;
                if (elem.requestFullscreen) {//W3C
                    elem.requestFullscreen();
                } else if (elem.msRequestFullscreen) {//IE11
                    elem.msRequestFullscreen();
                } else if (elem.mozRequestFullScreen) {//FireFox
                    elem.mozRequestFullScreen();
                } else if (elem.webkitRequestFullscreen) {//Chrome等
                    elem.webkitRequestFullscreen();
                }
                //
                if (info) {
                    //
                    $(this.domNode).html(info.replace(FULL_SCREEN, EXIT));
                }
            } else {
                if (document.exitFullscreen) {
                    document.exitFullscreen();
                }
                else if (document.mozCancelFullScreen) {
                    document.mozCancelFullScreen();
                }
                else if (document.webkitCancelFullScreen) {
                    document.webkitCancelFullScreen();
                }
                else if (document.msExitFullscreen) {
                    document.msExitFullscreen();
                }
                //
                if (info) {
                    $(this.domNode).html(info.replace(EXIT, FULL_SCREEN));
                }
            }
        }
    });
});