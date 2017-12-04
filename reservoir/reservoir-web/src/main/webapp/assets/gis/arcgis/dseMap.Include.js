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

 var dseGisPath =baseUrl+ "assets/gisdemos/arcgis/";*/
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
     dseGisPath = m[1];
     break;
     }
     }
     }*/
    //
    function inputScript(inc) {
        //var script
        var script;
        if (!isWinRT) {
            script = '<' + 'script type="text/javascript" src="' + inc + '"' + '><' + '/script>';
            document.writeln(script);
        }
        else {
            script = document.createElement("script");
            script.src = inc;
            document.getElementsByTagName("HEAD")[0].appendChild(script);
        }
        //
    }
    function inputCSS(style) {
        if (!isWinRT) {
            var css = '<' + 'link rel="stylesheet" href="' + style + '"' + '><' + '/>';
            document.writeln(css);
        }
        else {
            var link = document.createElement("link");
            link.rel = "stylesheet";
            link.href = style;
            document.getElementsByTagName("HEAD")[0].appendChild(link);
        }
        // console.log(style);
    }
    //
    var resUrl = location.protocol + "//" + __hostnameAndPathAndDojo;
    //加载arcgis 资源
    inputScript(resUrl + '/init.js');
    //加载DSE资源
    inputCSS(window.dseGisPath + window.styleName + '/style.css');
    // inputCSS(dseGisPath + 'dijit/themes/tundra/tundra.css');
    inputCSS(resUrl + '/dijit/themes/soria/soria.css');
    inputCSS(resUrl + '/esri/css/esri.css');
    //
})();
//# sourceMappingURL=dseMap.Include.js.map