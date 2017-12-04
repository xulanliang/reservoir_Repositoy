/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare","dojo/on","dojo/dom",
    "../utils/dseGisUtils"
],function(declare,on,dom,dseGisUtils){
    //
    var dseMap=null;
    //
    var mapType=null;
    return declare(null,{
        //
        constructor:function(options){
            //
            dseMap=options.map;
            mapType=options.type;
        },
        init:function(){
            //
            $("#" + dseMap.id).append('<div id="maplable" class="m-loc"></div>');
            dseMap.on("mouse-move", function (evt) {
                var mp = evt.mapPoint;
                var mps = dseGisUtils.DqzbToWgs(mp.x, mp.y, mapType);
                $("#maplable").text(
                    "经度：" + Number(mps[0]).toFixed(4) + "   纬度："
                    + Number(mps[1]).toFixed(4));
            });
        }
    });
    //
});