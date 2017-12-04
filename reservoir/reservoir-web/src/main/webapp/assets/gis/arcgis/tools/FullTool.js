/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare", "./_BaseTool",
    "../utils/winDataUtils"], function (declare, _BaseTool, winDataUtils) {
    //
    //
    var FULL_SCREEN = "全屏";
    var EXIT = "退出";
    return declare([_BaseTool], {
        //
        constructor: function (ctx) {
            //
            var app = window.appEvent;
            //
            if (app) {
                //
                var self = this;
                app.addAppEventListener(app.CLICK_KEY_ESC, function (data) {
                    //
                    var info = $(self.domNode).html();
                    if (info) {
                        $(self.domNode).html(info.replace(EXIT, FULL_SCREEN));
                    }
                });
            }
        },
        activate: function (isInFrame) {
            //
            //
            // console.log(window.parent.document.domain);
            // document.domain = "14.118.131.226";
            if (isInFrame) {
                /**
                 * 不嵌入框架时的全屏
                 * */
                //
                this._fullScreenState(window.parent.document);
            }
            else {
                /**
                 * 不嵌入框架时的全屏
                 * */
                this._fullScreenState(window.document);
            }
            //
            /* var doc = winDataUtils.getDataFromParent("document");
             this._fullScreenState(doc);*/
        },
        /**
         * 嵌入框架时的全屏
         * */
        _fullScreenState: function (document) {
            //
            var info = $(this.domNode).html();
            if (!document.fullscreenElement && !document.mozFullScreenElement && !document.webkitFullscreenElement && !document.msFullscreenElement) {
                var elem = document.documentElement;
                if (elem.requestFullscreen) {
                    elem.requestFullscreen();
                }
                else if (elem.msRequestFullscreen) {
                    elem.msRequestFullscreen();
                }
                else if (elem.mozRequestFullScreen) {
                    elem.mozRequestFullScreen();
                }
                else if (elem.webkitRequestFullscreen) {
                    elem.webkitRequestFullscreen();
                }
                //
                if (info) {
                    //
                    $(this.domNode).html(info.replace(FULL_SCREEN, EXIT));
                }
            }
            else {
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
//# sourceMappingURL=FullTool.js.map