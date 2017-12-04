dseDefine('page', function(require, exports, module) {
	exports.initForm = function(_) {
		console.log(_.range(-9));
		
		var compiled = _.template('hello <%= user %>!');
		document.getElementById('demo').innerHTML = compiled({ 'user': 'fred' });
	};

});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page', 'lodash' ], function(m,_) {
	module = _;
	m.initForm(_);
});