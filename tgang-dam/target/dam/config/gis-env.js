/**
 * Created by Administrator on 2016/9/6.
 */
var baseUrl = (function () {
    //
    var local = window.location;
    var contextPath = local.pathname.split("/")[1];
    return local.protocol + "//" + local.host + "/" + contextPath + "/";
})();
//
var __hostnameAndPathAndDojo = location.host+"/arcgis_js_api/library/3.16";
//
var styleName = "themes/default";

var arcgisPath = baseUrl + "WebContent/assets/gis/arcgis/";

var projectUrl = baseUrl + "page/app/slgcgis/";


//
