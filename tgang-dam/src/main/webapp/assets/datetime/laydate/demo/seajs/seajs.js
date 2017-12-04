
dseDefine('page', function(require, exports, module) {
	exports.initForm = function(laydate){
		laydate.skin('molv');
		laydate({
		   elem: '#demo'
		})
	}
	
});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page','layer_datetime'], function(m,laydate) {
	m.initForm(laydate);
	module = laydate;
});