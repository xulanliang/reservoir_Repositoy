/**
 * Created by Administrator on 2016/7/22.
 */
define(["dojo/_base/declare","./_BaseTool"],function(declare,_BaseTool){
    //
    //
    var _map=null;
    return declare([_BaseTool],{
        //
        constructor:function(map){
            _map=map;
        },

        activate:function(){
            ///
            var layerIds=_map.graphicsLayerIds;
            //
            if(layerIds){
                //
                layerIds.forEach(function(layerId){
                    //
                    var graLayer=_map.getLayer(layerId);
                    graLayer.clear();
                });
            }
        }
    });

});