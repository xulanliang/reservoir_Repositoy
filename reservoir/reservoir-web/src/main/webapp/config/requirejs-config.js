//统一全局变量
var DSE = {};
// 获取基础路径，如http://localhost:8080/pro
var baseUrl = "";
DSE.baseUrl = (function () {
    var local = window.location;
    var contextPath = local.pathname.split("/")[1];
    baseUrl = local.protocol + "//" + local.host;
    return local.protocol + "//" + local.host + "/" + contextPath;
})();
DSE.baseUrl = DSE.baseUrl.replace('/pages', '/').replace('/assets', '/'); //启用 node 服务器时,项目根地址需要处理
document.write('<style>body{visibility:hidden;}[v-cloak]{display:none;}<\/style>'); //解决页面 css 加载在 dom 之后数据还未加载完时出现闪烁的的问题
document.write('<script src="' + DSE.baseUrl + '\/assets\/hack\/html5.min.js"><\/script>'); //html5, css media, json, event 兼容
DSE.serverPath = DSE.baseUrl + "/"; //默认 server 路径为 DSE.baseUrl
/**
 * =================================================================
 * GIS 配置文件
 * =================================================================
 * */
// var baseGisUrl = baseUrl + "/arcgis_js_api/library/3.20";
//var baseGisUrl = "//10.100.9.52:8898/arcgis_js_api/library/3.20";
var baseGisUrl = "//10.100.9.46:8081/arcgis_js_api/library/3.16";
// var baseGisUrl = baseUrl + "/supermap_js_api";
//Gis基础框架存放路径
var dseGisPath = DSE.baseUrl + "/assets/gis/arcgis";
//
// var dseGisPath = window._serverPath + "/assets/gis";
//GIS项目路径.
var projectUrl = DSE.baseUrl + "/pages/app/sgaqgis";
//超图配置
// var projectUrl = window._serverPath + "/pages/app/gisdemos/supermap";
//GIS 基础库样式.
var styleName = "/themes/default";
//
DSE.requireConfig = {
    "baseUrl": DSE.baseUrl,
    "urlArgs": 'v1.0.0',
    "echarts_theme": "infographic", //eacharts皮肤配置,默认为设置default"
    "map": {
        "*": {
            "css": "assets/require/css.min"
        }
    },
    "paths": {
        "autocomplete": "assets/autocomplete/js/jquery.autocomplete.min", // jquery 自动提示插件
        "base": "pages/frame/common/css/base", //用于加载公共 css 和 js
        "bootstrap": "assets/bootstrap/js/bootstrap.min", // bootstrap
        "browserdetect": "assets/hack/browserdetect", //浏览器版本检测
        "common": "assets/util/common", //基础 js 脚本，所有页面都要加载
        "vue_component": "pages/app/components/vueComponent", //Vue + elementUI 组件通用配置
        "date": "assets/datetime/date", //日期计算
        "date97": "assets/datetime/my97datepicker/WdatePicker", //97date
        "drag": "assets/drag/draggabilly/draggabilly.pkgd.min", //drag 拖拽插件
        "datagrid_pager": "pages/app/common/js/datagridPager", //datagrid 分页
        "easyui": "assets/easyui/locale/easyui-lang-zh_CN", //easyui
        "easyui_min": "assets/easyui/jquery.easyui.min",
        "easyui_valid": "assets/easyui/plugins/jquery.validtor.rules",
        "echarts3": "assets/chart/echarts/src/echarts.min", //echarts3.0
        "echarts2": "assets/chart/echarts/src/echarts2.0/echarts2", //echarts2.0
        "eform": "assets/util/easyui.dseForm", //表单业务通用脚本
        "ELEMENT": "assets/vue/element-ui/lib/index", //ElementUI, ELEMENT 必须大写，否则调用不到
        "fileToUpload": "assets/upload/fileToUpload/js/fileToUpload", //jquery 上传插件
        "fileStyle": "assets/upload/fileToUpload/fileUpload1/js/fileStyle", //公用上传业务
        "fileToUpload2": "assets/upload/fileToUpload/js/fileToUpload2", //jquery 上传插件
        "fileStyle2": "assets/upload/fileToUpload/fileUpload2/js/fileStyle", //公用上传业务
        "html2canvas": "assets/canvas/html2canvas/html2canvasSvg.min", //svg 转 canvas
        "icheck": "assets/icheck/icheck.min", //checkbox美化插件
        "jquery": "assets/jquery/jquery.min", // jquery 1.9.1
        "jquery_form": "assets/valid/jqform/jquery.form.min",
        "jqprint": "assets/print/jquery.jqprint.min", //jquery 打印插件
        "jspdf": "assets/media/jspdf/js/jquery.media.min", //jquery 在线预览pdf
        "keypress": "assets/keypress/js/keymaster.min", //js 键盘事件
        "kindeditor": "assets/editor/kindeditor/kindeditor-all-min", //在线编辑器
        "layer": "assets/win/layer/layer", //layer 弹窗
        "laypage": "assets/laypage/laypage", //laypage 分页插件
        "laytpl": "assets/laytpl/laytpl", //laytpl 模板引擎
        "lodash": "assets/lodash/lodash.min", //lodash 工具库
        "md5": "assets/security/md5.min", //md5 加密
        "nicescroll": "assets/scroll/nicescroll/jquery.nicescroll.min", //滚动条美化
        "oper_config": "pages/app/common/js/oper-config", //前端一些参数配置文件
        "range": "assets/range/jquery-range/js/jquery.range.min", //range 范围选择插件
        "stickup": "assets/stickup/stickUp.min", //页面滚动元素固定
        "stylePage": "pages/app/common/js/stylePage", //单表操作通用脚本
        "superslide": "assets/tab/superslide/jquery.superslide.min", //superslide 特效插件
        "tab3": "assets/tab/tab3/js/jquery.tab3", //简单的tab切换插件
        "vform": "assets/valid/vform/js/jquery.vform", //表单验证
        "video": "assets/media/video/js/video", //jquery 视频播放器
        "videojs_ie8": "assets/media/video/js/videojs-ie8.min", //video ie8 兼容
        "viewer": "assets/media/viewer/js/viewer.min", //jquery 图片查看器
        "vue": "assets/vue/vue.min", // MVVM 框架 vuejs
        "vue_router": "assets/vue/vue-router.min", //vue-router
        "ztree": "assets/tree/ztree/js/jquery.ztree.all.min", //ztree
        'extendDatagrid' : 'assets/easyui/plugins/extendEasyuiDatagrid',
        //
        /**
         * =================================================================
         * 以下代码用于配置GIS库依赖库
         * @author wangsl
         * @date 2017-03-27
         * =================================================================
         * */
        //
        config: DSE.baseUrl + "/config",
        dojo: baseGisUrl + "/dojo",//dojo
        esri: baseGisUrl + "/esri",//arcgis-js-api
        dojox: baseGisUrl + "/dojox",//dojox
        dijit: baseGisUrl + "/dijit",//
        util: baseGisUrl + "/util",
        moment: baseGisUrl + "/moment",
        dgrid: baseGisUrl + "/dgrid",
        dgrid1: baseGisUrl + "/dgrid1",
        dstore: baseGisUrl + "/dstore",
        putSelector: baseGisUrl + "/put-selector",
        xstyle: baseGisUrl + "/xstyle",
        //自定义GIS框架库
        dsegis: dseGisPath,
        //项目短路径
        custom: projectUrl,
        /**
         * 配置超图依赖库
         * @author wangsl
         * @date 2017-04-07
         * */
        SuperMap: baseGisUrl + "/libs/SuperMap-8.1.1-14426",
        SuperMapPlot: baseGisUrl + "/libs/SuperMap_Plot-8.1.1-14426",
        zhCn: baseGisUrl + "/libs/Lang/zh-CN",
        smLib: baseGisUrl + "/theme"
    },
    "shim": {
        "autocomplete": {
            "deps": ["jquery"]
        },
        "base": {
            "deps": ["css!pages/frame/common/css/base-min.css", "css!assets/button/button1/buttons.css", "css!assets/font/awesome/css/font-awesome.min.css", "css!pages/app/common/css/common.css", "oper_config"] //基础 css,所有页面都要加载
        },
        "browserdetect": {
            "deps": ["base"]
        },
        "bootstrap": {
            "deps": ["jquery", "css!assets/bootstrap/css/bootstrap.min.css"]
        },
        "common": {
            "deps": ["easyui", "layer"]
        },
        "date": {
            "deps": ["base"]
        },
        "date97": {
            "deps": ["base"]
        },
        "datagrid_pager": {
            "deps": ["common"]
        },
        "drag": {
            "deps": ["jquery"]
        },
        "easyui_min": {
            "deps": ["jquery", "css!assets/easyui/themes/metro/easyui.css"]
        },
        "easyui": {
            "deps": ["easyui_min"]
        },
        "easyui_valid": {
            "deps": ["easyui"]
        },
        "echarts2": {
            "deps": ["base"]
        },
        "echarts3": {
            "deps": ["base"]
        },
        "eform": {
            "deps": ["common"]
        },
        "ELEMENT": {
            "deps": ["vue", "css!assets/vue/element-ui/lib/theme-default/index.css"]
        },
        "fileToUpload": {
            "deps": ["jquery_form", "vue"] //上传控件依赖common.js
        },
        "fileStyle": {
            "deps": ["fileToUpload", "css!assets/upload/fileToUpload/fileUpload1/css/fileStyle.css"] //上传控件依赖common.js
        },
        "icheck": {
            "deps": ["jquery", "css!assets/icheck/skins/all.css"]
        },
        "jqprint": {
            "deps": ["jquery"]
        },
        "jquery": {
            "deps": ["base"]
        },
        "jquery_form": {
            "deps": ["common"]
        },
        "jspdf": {
            "deps": ["common"]
        },
        "kindeditor": {
            "deps": ["base", "css!assets/editor/kindeditor/themes/default/default.css"]
        },
        "keypress": {
            "deps": ["base"]
        },
        "layer": {
            "deps": ["jquery", "css!assets/win/layer/skin/default/layer.css"]
        },
        "nicescroll": {
            "deps": ["jquery"]
        },
        "placeholder": {
            "deps": ["jquery"]
        },
        "range": {
            "deps": ["jquery", "css!assets/range/jquery-range/css/jquery.range.css"]
        },
        "superslide": {
            "deps": ["jquery"]
        },
        "tab3": {
            "deps": ["jquery"]
        },
        "vform": {
            "deps": ["common", "css!assets/valid/vform/css/jquery.vform.css"]
        },
        "video": {
            "deps": ["jquery", "css!assets/media/video/css/video-js.css", "videojs_ie8"]
        },
        "viewer": {
            "deps": ["jquery", "css!assets/media/viewer/css/viewer.min.css"]
        },
        "vue_component": {
            "deps": ["base"]
        },
        "vue": {
            "deps": ["base", "vue_component"]
        },
        "vue_router": {
            "deps": ["vue"]
        },
        "ztree": {
            "deps": ["jquery", "css!assets/tree/ztree/css/zTreeStyle/zTreeStyle.css"]
        },
        // /***/
        "SuperMap": {
            deps: [""],
            exports: "SuperMap"
        }
    }
};

function require_js(name, url, deps) {
    DSE.requireConfig["paths"][name] = url;
    if (deps) {
        DSE.requireConfig["shim"][name] = {
            "deps": deps
        };
    }
}

function require_css(url) {
    DSE.requireConfig["shim"]["base"]["deps"].push(url);
}

function require_shim(name, deps) {
    if (!DSE.requireConfig["shim"][name]) {
        DSE.requireConfig["shim"][name] = {
            "deps": deps
        };
    } else {
        DSE.requireConfig["shim"][name]["deps"] = DSE.requireConfig["shim"][name]["deps"].concat(deps);
    }
}

//添加 eacharts，可统一配置皮肤 DSE.requireConfig.echarts_theme
require_js('echarts', 'assets/chart/echarts/src/theme/' + DSE.requireConfig.echarts_theme, ['echarts3']);


//DSE.serverPath = 'http://10.100.9.22:8088/lhsf-web/'; // 跨域访问 server 时,直接设置路径
