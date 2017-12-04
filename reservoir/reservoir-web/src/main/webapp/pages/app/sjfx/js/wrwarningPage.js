/**
 * Created by pc on 2017-5-26.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/sjfx/css/sjfxPage.css');

//执行配置
require.config(DSE.requireConfig);
define('wrwarningPage', function (require, exports, module) {

    var _common = require('common');
    var _ztree = require('ztree');

    var h = $(document).height() - 0;

    $('.g-bd1').height(h);
    $('.g-mn1c').height(h-30);
    $('.myztree').height(h-20);

    var redirectParm  = JSON.parse(localStorage.getItem("redirectParm") || null);

    function zTreeOnClick(event, treeId, treeNode) {
        if(treeNode.isParent){
            return ;
        }
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
        url: DSE.serverPath + 'swqxCtrl/getWrwarningTree.do',
        async: false,
        type: 'post',
        contentType:'application/json;charset=UTF-8',
        dataType:"json",
        success: function(data) {
            $.fn.zTree.init($("#treeDemo"), setting, data);
            var  url = DSE.baseUrl + data[0].MYURL;
            if(redirectParm){
                for (var i = 0 ,len = data.length; i < len ; i++){
                    var obj = data[i];
                    var MyUrl = obj.MYURL;
                    var nodeId = obj.ID;
                    if(MyUrl){
                        var param = GetRequestParam(MyUrl);
                        if(param){
                            if(redirectParm.monTp == param.mon_tp && redirectParm.projCd == param.projcd ){
                                url = DSE.baseUrl + MyUrl ;
                                var zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
                                var node = zTree_Menu.getNodes();
                                if(node){
                                    for (var i= 0 ,len = node.length ; i< len ;i++){
                                        getChildren(zTree_Menu,node[i],nodeId);
                                    }
                                }
                                localStorage.setItem("redirectParm","");
                                break;
                            }
                        }
                    }
                }
            }

            $('#iframe').attr("src",url);
        }
    });

});

function getChildren(treeObj,treeNode,selectNodeId){
    if (treeNode.isParent){
        for(var obj in treeNode.children){
            var node =  treeNode.children[obj] ;
            if(node.ID == selectNodeId ){
                treeObj.selectNode(node,true);
                break;
            }
            getChildren(treeObj,treeNode.children[obj],selectNodeId);
        }
    }
}
