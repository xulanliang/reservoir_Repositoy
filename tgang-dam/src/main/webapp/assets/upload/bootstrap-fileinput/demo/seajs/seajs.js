
dseDefine('page', function(require, exports, module) {
	exports.initForm = function() {
		$("#input-id").fileinput({'showUpload':false, 'previewFileType':'any',language:'zh'});
	};

});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page', 'bootstrap_css', 'bsFileinput_css', 'jquery', 'bsfCanvas', 'bsfPurify','bsfSort','bsFileinput','bootstrap','bsfFa','bsFileinputZh'], function(m) {
	module = m;
	m.initForm();
});