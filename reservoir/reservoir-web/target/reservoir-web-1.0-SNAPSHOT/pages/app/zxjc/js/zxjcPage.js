/**
 * Created by pc on 2017-7-13.
 */
//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/zxjc/css/zxjcPage.css');

//执行配置
require.config(DSE.requireConfig);
define('zxjcPage', function (require, exports, module) {

    var _common = require('common');
    var _ztree = require('ztree');

    var h = $(document).height() - 0;

    $('.g-bd1').height(h);
    // $('.g-mn1c').height(h-30);

    //让右边区块跟左边的树高度一致
    $('.g-mn1c').height(h-20);
    
    $('.myztree').height(h-20);

    function zTreeOnClick(event, treeId, treeNode) {
        //if(treeNode.isParent){
        //    return ;
        //}
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
        url: DSE.serverPath + '/zxjcCtrl/getTree.do',
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
