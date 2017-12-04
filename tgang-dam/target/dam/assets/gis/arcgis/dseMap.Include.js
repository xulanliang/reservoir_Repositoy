//
/*var baseUrl = (function () {
    //
    var local = window.location;
    var contextPath = local.pathname.split("/")[1];
    return local.protocol + "//" + local.host + "/" + contextPath + "/";
})();
//
var __hostnameAndPathAndDojo ="localhost:8080/arcgis_js_api/library/3.16";
//
var styleName = "themes/default";

var arcgisPath =baseUrl+ "assets/gis/arcgis/";*/

var dojoConfig = (function () {
    //
    return {
        //
        isDebug: false,
        packages: [
            {
                name: "dse_gis",
                location: arcgisPath
            },
            {
                name: "config",
                location: baseUrl + "WebContent/config"
            }, {
                name: "plugin",
                location: baseUrl + "WebContent/assets"
            }
        ]
    };
})();
//

(function () {
    var isWinRT = (typeof Windows === "undefined") ? false : true;
   /* var r = new RegExp("(^|(.*?\\/))(dse_gis/dseMap.Include\.js)(\\?|$)"),
        s = document.getElementsByTagName('script'),
        src, m;
    //

    for (var i = 0, len = s.length; i < len; i++) {
        src = s[i].getAttribute('src');
        if (src) {
            var m = src.match(r);
            if (m) {
                arcgisPath = m[1];
                break;
            }
        }
    }*/
    //
    function inputScript(inc) {
        if (!isWinRT) {
            var script = '<' + 'script type="text/javascript" src="' + inc + '"' + '><' + '/script>';
            document.writeln(script);
        } else {
            var script = document.createElement("script");
            script.src = inc;
            document.getElementsByTagName("HEAD")[0].appendChild(script);
        }
        //
    }

    function inputCSS(style) {
        if (!isWinRT) {
            var css = '<' + 'link rel="stylesheet" href="' + style + '"' + '><' + '/>';
            document.writeln(css);
        } else {
            var link = document.createElement("link");
            link.rel = "stylesheet";
            link.href = style;
            document.getElementsByTagName("HEAD")[0].appendChild(link);
        }
        // console.log(style);
    }
    //
    var resUrl=location.protocol+"//"+__hostnameAndPathAndDojo;


    //加载arcgis 资源
    inputScript(resUrl + '/init.js');

    //加载DSE资源
    inputCSS(arcgisPath + styleName + '/style.css');

    // inputCSS(arcgisPath + 'dijit/themes/tundra/tundra.css');
    inputCSS(resUrl + '/dijit/themes/soria/soria.css');
    inputCSS(resUrl + '/esri/css/esri.css');
    //
})();
