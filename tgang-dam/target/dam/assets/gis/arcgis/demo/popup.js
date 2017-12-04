/**
 * Created by Administrator on 2016/7/25.
 */
require(["dojo/on", "dojo/dom","dojo/domReady!"], function (on, dom) {
    //
    //
    var graphic = window.dseGisData.graphic;
    //
    console.log("popup.js is loaded.");

    console.log(document.getElementById("test").innerHTML);
    //
    on(dom.byId("test"), "click", function (event) {
        //
        // console.log("test");
        //
        // alert("test")
        alert("haha " + graphic.data["STNM"]);
    });
});
//
//
/*
 $(function(){
 //
 //
 console.log("pooup.js loaded.");
 var graphic=window.parent.dseGisData.graphic;
 //
 $("#test").click(function(){
 //
 alert("test");
 });
 });
 */

