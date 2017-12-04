当前版本：v1.1
官网：http://laydate.layui.com/
########东深更改	laydate.js 	####
1、修改path支持模块化
2、结尾添加模块化支持
	"function"==typeof dseDefine?dseDefine(function(){return laydate}):"undefined"!=typeof exports?module.exports=laydate:window.laydate=laydate