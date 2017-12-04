/**
 * Created by Administrator on 2017/7/18.
 */

require_css("css!pages/app/demo/index.css");
require_js("test","pages/app/demo/test");

require.config(DSE.requireConfig);

define("index",function(require,exports,module){
    //
    var $=require("jquery");
    //
    var test=require("test");
    //
    //
    $(document).ready(function(){
        //

    });

    test.say();

});