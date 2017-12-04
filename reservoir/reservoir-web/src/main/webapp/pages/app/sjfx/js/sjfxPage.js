/**
 * Created by pc on 2017-5-26.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/css/sjfxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('sjfxPage', function (require, exports, module) {

    var _common = require('common');
    var _ztree = require('ztree');

    var h = $(document).height() - 0;

    $('.g-bd1').height(h);
    $('.g-mn1c').height(h-30);
    $('.myztree').height(h-20);

    //$('.inactive').click(function(){
    //    if($(this).siblings('ul').css('display')=='none'){
    //        $('.inactive').removeClass('inactives');
    //        $('.inactive').siblings('ul').slideUp(100);
    //        $(this).addClass('inactives');
    //        $(this).siblings('ul').slideDown(100).children('li');
    //    }else{
    //        $(this).removeClass('inactives');
    //        $(this).siblings('ul').slideUp(100);
    //    }
    //});
    //
    //$('#szsk').click();
    //
    //$('.alink').click(function(){
    //    $('.alink').removeClass('anow');
    //    $(this).addClass('anow');
    //});
    //
    //window.openlink = function(url){
    //    url = DSE.baseUrl + url;
    //    $('#iframe').attr("src",url);
    //};
    //
    //$('#firstlink').click();

    function zTreeOnClick(event, treeId, treeNode) {
        if(treeNode.NAME!='东改工程'){
            if(treeNode.isParent){
                return;
            }
        }
        var excelPrefix = treeNode.NAME;
        //当前节点名称
        var treeName =  treeNode.NAME ;
        if(!treeNode.isParent){
            var fNode = treeNode.getParentNode();      //获取当前节点的父节点
            var fPID = fNode.PID ;                      //父节点的PID
            var fName = fNode.NAME;                     //父节点名称
            if(fPID){                                   //如果父节点的PID不为空，则取到祖父节点
                var gNode = fNode.getParentNode();          //
                var gName = gNode.NAME;
                excelPrefix = gName +"_"+fName+"_"+treeName ;
            }else {
                excelPrefix =fName + treeName ;          //只有两级节点的情况
            }
        }
        else{
           excelPrefix = treeName ;          //只有两级节点的情况
        }

        localStorage.setItem('excelPrefix', excelPrefix);
        url = DSE.baseUrl + treeNode.MYURL;
        $('#iframe').attr("src",url);
    };

    var setting = {
        data: {
            key : {
                title : "NAME", //鼠标悬停显示的信息
                name : "NAME" //网页上显示出节点的名称
            },
            simpleData: {
                enable: true,
                idKey: "ID", //修改默认的ID为自己的ID
                pIdKey: "PID",//修改默认父级ID为自己数据的父级ID
                rootPId: null     //根节点的ID
            }
        },
        callback: {
            onClick: zTreeOnClick
        }
    };

    $.ajax({
        url: DSE.serverPath + 'swqxCtrl/getTree.do',
        async: false,
        type: 'post',
        contentType:'application/json;charset=UTF-8',
        dataType:"json",
        success: function(data) {
            $.fn.zTree.init($("#treeDemo"), setting, data);
            url = DSE.baseUrl + data[0].MYURL;
            $('#iframe').attr("src",url);
        }
    });

});
