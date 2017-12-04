/**
 * Created by Administrator on 2016/7/22.
 *
 * 定义组件基类，定义普通的HTML组件基类，不继承dojo._WidgetBase
 */
define([
    "dojo/Evented",
    "dojo/_base/declare",
    "dojo/_base/lang",
    "dojo/request/xhr",
    'dojo/_base/array',
    'dojo/_base/html',
    'dojo/topic',
    "dojo/dom-style",
    "dojo/dom-construct",
    "dojo/_base/window", "dojo/dom-class",
], function (Evented, declare, lang, xhr, arrayUtils, html, topic, domStyle, domConstruct, win, domClass) {
    //
    //
    var baseDomNode = null;
    //
    return declare(null, {
        //uri: String
        //    used in the config.json to locate where the widget is
        uri: undefined,
        /*======
         //left: int
         //top: int
         //right: int
         //bottom: int
         //width: int
         //height: int
         ======*/
        //    preload widget should config position property if it's not in group.
        //    the meaning of the property is the same as of the CSS
        position: {},
        //config: Object|String
        //    config info in config.json, url or json object
        //    if url is configured in the config.json, json file is parsed and stored in this property
        config: undefined,
        //
        //map: esri/Map
        map: null,
        //appConfig: Object
        //    the arcgis's config.json
        appConfig: null,
        //baseClass: String
        //    HTML CSS class name
        baseClass: null,
        id: undefined,
        //组件状态.
        state: false,
        //templateString: String
        //    widget UI part, the content of the file Widget.html will be set to this property
        templateString: '<div></div>',
        //
        CONFIG_LOADED: "configLoaded",
        CONFIG_LOAD_ERROR: "configLoadError",
        //
        configDataLoaded: null,
        configDataLoadError: null,
        //
        constructor: function (node, options) {
            //summary:
            //描述：
            lang.mixin(this, options);
            //
            if (this.uri) {
                //加载配置加载配置文件.
                xhr(this.uri, {
                    method: "GET",
                    handleAs: "json"
                }).then(lang.hitch(this, this.configDataLoaded), lang.hitch(this, this.configDataLoadError));
            }
            //
            //
            // var styleObj=lang.mixin(this.position,this.size);
            //
            if (node) {
                //
                this.domNode = node;
            }
            else {
                this.domNode = domConstruct.create("div", {
                    //
                    id: this.id,
                }, win.body());
            }
            //
            // this.setPosition(this.position, this.size);
            //
            this.appEvent = window.appEvent;
            //
            // this.setPosition(this.position,this.size);
            // this.on(this.CONFIG_LOADED);
            // console.log(this);
        },
        //
        addStyle: function (style) {
            //
            domClass.add(this.domNode, style);
        },
        //
        _setStyle: function (options) {
            //
            var item = "";
            for (var key in options) {
                //
                item += key + ":" + options[key] + "px;";
            }
            return item;
        },
        /**
         * 关闭组件时清除组件所持有的资源.
         * */
        onClose: function () {
            //
            this.state = false;
            //
        },
        /**
         * 打开组件，恢复之前的状态
         * */
        onOpen: function () {
            //
            this.state = true;
            //
        },
        //
        setPosition: function (pos, size) {
            if (pos) {
                domStyle.set(this.domNode, {
                    position: "absolute",
                    left: pos.left + "px",
                    right: pos.right + "px",
                    top: pos.top + "px",
                    bottom: pos.bottom + "px"
                });
            }
            //
            if (size) {
                domStyle.set(this.domNode, {
                    //
                    width: size.width + "px",
                    height: size.height + "px"
                });
            }
        }
    });
});
//# sourceMappingURL=_BaseControl.js.map