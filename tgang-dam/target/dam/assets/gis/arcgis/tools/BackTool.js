/**
 * Created by Administrator on 2016/7/22.
 */

define(["dojo/_base/declare", "./_BaseTool","esri/geometry/Extent"], function (declare, _BaseTool,Extent) {
    //
    //
    var _map=null;
    //
    var _map=null;
    return declare([_BaseTool],{
        //
        //
        constructor:function(map){
            //
            _map=map;
            //
        },
        activate:function(){
            //
            var extent=this.configData.fullExtent;
            this._showExtent(extent)

        },
        _showExtent:function(arrExtent){
            //
            if (arrExtent && arrExtent.length > 3) {
                //
                var minEx = this.dseGisUtils.WgsToDqzb(arrExtent[0], arrExtent[1], this.configData.mapType);
                var maxEx = this.dseGisUtils.WgsToDqzb(arrExtent[2], arrExtent[3], this.configData.mapType);

                var extent = new Extent(Number(minEx[0]),
                    Number(minEx[1]), Number(maxEx[0]),
                    Number(maxEx[1]), _map.spatialReference);
                _map.setExtent(extent);
            }
        }
    });
});
