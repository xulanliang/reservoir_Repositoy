define(["dojo/_base/declare", "dojo/_base/lang",
    "dojo/json"
], function (declare, lang, JSON) {
    //
    //
    var socketUrl = "";
    var websocket = null;
    var displayLayer = null;
    var isFirstData = true;
    //
    return declare(null, {
        //
        constructor: function (options) {
            //
            lang.mixin(this, options);
            socketUrl = options.url;
            //
            displayLayer = options.layer;
        },
        //
        _dataOnMessage: function (event) {
            //
            if (isFirstData) {
                //
                isFirstData = false;
            }
            else {
                //
                //
                var jsonData = JSON.parse(event.data);
                //
                displayLayer.bindCallRefReset(displayLayer);
                displayLayer.loadData(jsonData, false);
            }
        },
        //
        _dataOnError: function () {
            //
            console.log("socket connect error!");
        },
        _socketClose: function () {
            //
            console.log("socket is closed!");
        },
        //
        _socketOnOpen: function () {
            //
            console.log("socket connect successfully!");
        },
        //
        startSync: function () {
            //
            if (socketUrl) {
                //
                //判断当前浏览器是否支持WebSocket
                if ('WebSocket' in window) {
                    websocket = new WebSocket(socketUrl);
                }
                else {
                    alert('当前浏览器 Not support websocket');
                }
                //连接发生错误的回调方法
                websocket.onerror = this._dataOnError;
                //连接成功建立的回调方法
                websocket.onopen = this._socketOnOpen;
                //接收到消息的回调方法
                websocket.onmessage = this._dataOnMessage;
                //连接关闭的回调方法
                websocket.onclose = this._socketClose;
                //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
                window.onbeforeunload = this.stopSync;
            }
        },
        stopSync: function () {
            //
            websocket.close();
            displayLayer.hideTips();
        }
    });
});
//# sourceMappingURL=GraphicSyncService.js.map