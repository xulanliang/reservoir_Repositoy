/**
 * Created by Administrator on 2016/7/22.
 * 所有工具类基类，用于向工具条提供一直的接口
 */
define(["dojo/_base/declare"],function(declare){
    //
    return declare(null,{
        //
        constructor:function(map){
            //
            this.map=map;
            this.configData=window.dseGisConfig;
            this.dseGisUtils=window.dseGisUtils;
        },
        activate:function(){
            //
        },
        deactivate:function(){
            //
        },
        /***/
        setDomNode:function(node){
            //
            this.domNode=node;
        },
        /***/
        setConfig:function(data){
            //
            this.config=data;
        }
    });
});