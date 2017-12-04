// 获取基础路径，如http://localhost:8080/pro
function getBaseURL() {
	//if (!window._baseUrl) {
	//	var local = window.location;
	//	var contextPath = local.pathname.split("/")[1];
	//	window._baseUrl = local.protocol + "//" + local.host + "/" + contextPath + "/";
	//}
	//window._baseUrl='http://192.168.22.201:8080/dam/';
	window._baseUrl='http://10.100.9.46:8080/dam/';
	return window._baseUrl;
};
if (typeof dseDefine != 'undefined') {
	// 基础配置
	seajs.config({
		base : getBaseURL(),
		alias : {
			/* 第三方依赖 */
			"base_css" : "pages/frame/common/css/base-min.css",
			"button_css" : "assets/button/button2/button.css",

			"jquery" : "assets/jquery/jquery-1.9.1.min.js",/* jquery */

			"foundation": "assets/foundation/js/foundation.min.js",
			"foundation_css": "assets/foundation/css/foundation.min.css",

			'print' : 'assets/print/jquery.PrintArea.js',
			"code" : "assets/code/CommonCode.js",/* code */
			"json" : "assets/json/json2.js",
			"common" : "assets/util/common.js",
			"uuid" : "assets/util/Math.uuid.js",
			"md5" : "assets/security/md5.js",
			"nicescroll" : 'assets/scroll/nicescroll/jquery.nicescroll.min.js',
			"form" : 'assets/form/easyui/DseForm.js',
			"easyui" : "assets/easyui/jquery.easyui.min.js",
			"easyui_lang" : "assets/easyui/locale/easyui-lang-zh_CN.js",
			"easyui_css" : "assets/easyui/themes/default/easyui.css",
		    "easyui_icon_css" : "assets/easyui/themes/icon.css",
			"easyui_valid" : "assets/easyui/plugins/jquery.validtor.rules.js",

			"kindeditor" : "assets/editor/kindeditor/kindeditor-all.js",
			"kindeditor_css" : "assets/editor/kindeditor/themes/default/default.css",

			"layer" : "assets/win/layer/layer.js",
			"layer_page" : "assets/page/laypage/laypage/laypage.js",/* 分页 */
			"layer_template" : "assets/template/laytpl/laytpl/laytpl.js",/* 模板 */
			"layer_datetime" : "assets/datetime/laydate/laydate/laydate.js",/* 日期 */
			"layer_css" : "assets/win/layer/skin/layer.css",

			"lodash" : "assets/lodash/lodash.min.js",/* 工具集，以及模板语言 */
			"underscore" : "assets/underscore/underscore-min.js",/* 工具集，以及模板语言 */


			'bootstrap' : 'assets/bootstrap/dist/js/bootstrap.min.js',/* bootstrap依赖jquery；bsFileinput放大图依赖，且需先引入bsFileinput */
			'bootstrap_css' : 'assets/bootstrap/dist/css/bootstrap.min.css',
			'bsfCanvas' : 'assets/upload/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js',/* bsFileinput图画依赖 */
			'bsfPurify' : 'assets/upload/bootstrap-fileinput/js/plugins/purify.min.js',/* bsFileinput预览图片效果 */
			'bsfSort' : 'assets/upload/bootstrap-fileinput/js/plugins/sortable.min.js',/* bsFileinput排序改编初始化文件则依赖 */
			'bsFileinput' : 'assets/upload/bootstrap-fileinput/js/fileinput.min.js',/* 依赖jquery */
			'bsFileinput_css' : 'assets/upload/bootstrap-fileinput/css/fileinput.min.css',/**/
			'bsfFa' : 'assets/upload/bootstrap-fileinput/js/locales/fa.js',/* bsFileinput字体 */
			'bsFileinputZh' : 'assets/upload/bootstrap-fileinput/js/locales/zh.js',/* bsFileinput语言包 */

			'dropzone' : 'assets/upload/dropzone/dist/min/dropzone.min.js',/* 文件上传 */
			'dropzone_css' : 'assets/upload/dropzone/dist/min/dropzone.min.css',

			'superSlide' : 'assets/picture/SuperSlide/superSlide.js',/* 特效插件 */
			'superSlide_css' : 'assets/picture/SuperSlide/default.css',

			"tab1" : "assets/tab/tab1/js/tab1.js",
			"tab1_css" : "assets/tab/tab1/css/tab1.css",
			
			"tab2" : "assets/tab/tab2/js/tab.js",
			"tab2_css":"assets/tab/tab2/css/tab.css",
			

			'echarts' : 'assets/chart/echarts/src/echarts.js',                       

			'menu2_css' : 'assets/nav/menu2/css/menu.css',
			'menu2' : 'assets/nav/menu2/js/menu.js',
			
			'app-config':'config/app-config.js',
			'act-config':'config/activiti-config.js',
			
			'print':'assets/util/jquery.jqprint.js',
			'highcharts':'assets/chart/js/highcharts.js',
			'highchartsMore':'assets/chart/js/highcharts-more.js',
			'highchartsExp':'assets/chart/js/modules/exporting.src.js',
			'extendDatagrid' : 'assets/easyui/plugins/extendEasyuiDatagrid.js',

			'zTree': 'assets/tree/ztree/js/jquery.ztree.all.min.js',
			'dseCommon': 'assets/dse/main.min-es5.js',
			'formValidate': 'assets/formValidation/js/formValidation.min.js',
			'formBootstrap': 'assets/formValidation/js/framework/bootstrap.js',

			'zTree_css':'assets/tree/ztree/css/zTreeStyle/zTreeStyle.css',

			'poshyTip': 'assets/tip/poshytip/jquery.poshytip.min.js',
			'datagridTip': 'assets/easyui/plugins/datagridTip.js'
		}
	});
}
// 服务端地址
window._serverPath = getBaseURL();