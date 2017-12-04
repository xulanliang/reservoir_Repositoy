/**
 * Created by Administrator on 2017/3/29.
 */
define(["require", "exports"], function (require, exports) {
    "use strict";
    var soriaStyle = window.baseGisUrl + "/dijit/themes/soria/soria.css";
    var esriStyle = window.baseGisUrl + "/esri/css/esri.css";
    var claroStyle = window.baseGisUrl + "/dijit/themes/claro/claro.css";
    //
    var nihiloStyle = window.baseGisUrl + "/dijit/themes/nihilo/nihilo.css";
    var tundraStyle = window.baseGisUrl + "/dijit/themes/tundra/tundra.css";
    //
    var coreStyle = window.dseGisPath + window.styleName + "/style.css";
    //
    // let superMap: string = window.baseGisUrl + "/libs/SuperMap.Include.js";
    //
    var googleStyle = window.baseGisUrl + "/theme/default/google.css";
    var smStyle = window.baseGisUrl + "/theme/default/style.css";
    function inputScript(inc) {
        //var script
        var script;
        script = document.createElement("script");
        script.src = inc;
        var head = document.head || document.getElementsByTagName("HEAD")[0];
        head.appendChild(script);
    }
    function inputCSS(style) {
        var link = document.createElement("link");
        link.rel = "stylesheet";
        link.href = style;
        //
        var head = document.head || document.getElementsByTagName("HEAD")[0];
        head.appendChild(link);
    }
    var ResLoader = (function () {
        function ResLoader() {
        }
        //
        ResLoader.prototype.loadStyle = function (platform, type) {
            //
            if (platform === "arcgis") {
                //
                if (type === "soria") {
                    //
                    inputCSS(soriaStyle);
                }
                else if (type === "claro") {
                    //
                    inputCSS(claroStyle);
                    //
                }
                else if (type === "nihilo") {
                    //
                    inputCSS(nihiloStyle);
                }
                else if (type === "tundra") {
                    //
                    inputCSS(tundraStyle);
                }
                else {
                    //default.
                }
                inputCSS(esriStyle);
                inputCSS(coreStyle);
            }
            else if (platform == "supermap") {
                //
                inputCSS(googleStyle);
                inputCSS(smStyle);
            }
        };
        return ResLoader;
    }());
    return ResLoader;
});
//# sourceMappingURL=ResLoader.js.map