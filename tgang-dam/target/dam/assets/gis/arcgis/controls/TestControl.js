/**
 * Created by Administrator on 2016/8/4.
 *
 * 组件实例代码.
 *继承自dojo._WidgetBase类，框架中需要扩展的通用控件都继承这个类，可以调用 ../DseGisBase.addMapControl方法，将组件加载到框架中。
 */
define(["dojo/_base/declare",

    "./_BaseWidget",
    "dojo/_base/lang",
    "dojo/text!./templates/TestControlTemplate.html",
    "dojo/dom",
    "dojo/dom-style",
    "dojo/dom-construct",
    "esri/domUtils",
    "dojo/on",
    // "xstyle!./styles/TestControl.css"
], function (declare, _BaseWidget, lang, template, dom, domStyle, domConstruct, domUtils, on) {
    //
    //
    //
    // var domNode=null;
    /**
     * widget events: onmouseenter||onmouseleave
     *
     * */
    var appConfig = null;
    return declare([_BaseWidget], {
        //
        //
        user: "wangsl",
        templateString: template,
        baseClass: "m-tst-ctn",
        constructor: function (options) {
            //
        },
        //
        configDataLoaded: function (data) {

        },
        //
        postMixInProperties: function () {
            //
            this.inherited(arguments);
            //
            this.name = "nihao";
        },
        //
        postCreate: function () {
            //

            this.inherited(arguments);
            // this.domNode.innerHTML="hello the world.";
            console.log(this.map.id);
        },
        //
        btnDangerClick: function (event) {
            //
            // console.log(this.domNode);
            //
            if(this.state){
                //
                domUtils.hide(this.resultNode);
                this.state=false;
            }else {
                //
                this.state=true;
                var data = this.config;
                //
                domConstruct.empty(this.resultNode);
                //
                domUtils.show(this.resultNode);

                var self = this;
                //
                data.forEach(function (d) {
                    //
                    var ing = domConstruct.create("img", {
                        src: arcgisPath + d.img_src,
                        alt: "noData",
                        style: "cursor:pointer;"
                    }, self.resultNode);
                    //
                    on(ing, "mouseenter", function (event) {
                        //
                        domStyle.set(this, {
                            "border": "solid",
                            "border-color": " #00B83F",
                            "border-width": "2px"
                        });
                    });
                    on(ing, "mouseout", function (event) {
                        //
                        domStyle.set(this, {
                            "border": "none"
                        });
                    });
                    //
                    on(ing,"click",function(event){
                        $.each(self.map.layerIds, function (i, lId) {
                            //
                            self.map.getLayer(lId).setVisibility(false);
                        });
                        //
                        var vecLayer = self.map.getLayer(d.id);
                        var labelLayer = self.map.getLayer(d.id + "w");
                        //
                        if (vecLayer) {
                            vecLayer.show();
                        }
                        if (labelLayer) {
                            labelLayer.show();
                        }
                    });
                });
                //
            }

        },
        //
        btnOver: function (event) {
            //
            console.log("test");
            //
            // this.user="wangshanglang";
        },
        //
        btnOutHandler: function (event) {
            //
            // alert("hehe.")
        },
        //
        startup: function () {
            //
        },
        //
        destroy: function () {
            //
            this.inherited(arguments);
        }
    });

});

