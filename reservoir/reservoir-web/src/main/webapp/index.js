//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
//require_css('css!pages/frame/common/css/animation-min.css');
require_css('css!index.css');
//js引入(__***js文件路径不要加.js后缀名，[]中括号里面的内容就是模块的依赖文件，调用模块时会预先加载***__)
//require_js('progress', 'assets/vue/element/component/progress', ['vue']);
//定义progress模块、路径、依赖关系

//执行配置
require.config(DSE.requireConfig);
define('index', function (require, exports, module) {

    //调用模块
    var _common = require('common');

    //引入 vue
    var Vue = require('vue');

    //获取数据
    var $data = $ajax({
        url: DSE.baseUrl + '/pages/app/data/data_bzwd.json'
    }) || {};

    //构建之前处理 json
    $data["showIndex"] = 1; //默认显示索引值为 1 的标签内容
    $data["msg"] = "前端帮助文档"; //msg 文字

    //渲染实例
    var app = new Vue({
        data: function () {
            return $data;
        },
        methods: {
            handleClick: function (item, index, $event) {
                this.showIndex = index;
            }
        }
    }).$mount('#app');

});
