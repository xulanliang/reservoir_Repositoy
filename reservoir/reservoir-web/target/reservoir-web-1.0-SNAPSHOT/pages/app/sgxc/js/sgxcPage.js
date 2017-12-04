/**
 * Created by pc on 2017-7-27.
 */
require_css('css!pages/app/fxwz/css/fxwzPage.css');

//执行配置
require.config(DSE.requireConfig);
define('sgxcPage', function (require, exports, module) {

    var _common = require('common');
    var _ztree = require('ztree');
    var type = '';


    var h = $(document).height() - 0;

    $('.g-bd1').height(h);
    $('.g-mn1c').height(h-20);
    $('.myztree').height(h-20);

    function zTreeOnClick(event, treeId, treeNode) {
        if(treeNode.isParent){
            return ;
        }
        url = DSE.baseUrl + treeNode.MYURL;
        type = treeNode.ID;
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

    var nodes = [
        {ID:1, PID:null, NAME: "巡查标准",open: 'true'},
        {ID:1001, PID:1, NAME: "巡查对象",MYURL: "/pages/app/sgxc/wrchkobject/wrchkobjectPage.html?ck_item=0"},
        {ID:1002, PID:1, NAME: "巡查点",MYURL: "/pages/app/sgxc/wrchkobject/wrchkobjectPage.html?ck_item=1"},
        {ID:1003, PID:1, NAME: "巡查内容",MYURL: "/pages/app/sgxc/xcnr/xcnr.html"},
        {ID:2, PID:null, NAME: "巡查任务",open: 'true',myUrl: "/pages/app/sgxc/wrchktask/wrchktaskPage.html"},
        {ID:2001, PID:2, NAME: "任务管理",MYURL: "/pages/app/sgxc/wrchkrecord/wrchkrecordPage.html"},
        {ID:2002, PID:2, NAME: "计划管理",MYURL: "/pages/app/sgxc/wrchktask/wrchktaskPage.html"},
        {ID:3, PID:null, NAME: "巡查记录",open: 'true'},
        {ID:3001, PID:3, NAME: "记录查询",MYURL: "/pages/app/sgxc/jlcx/jlcx.html"},
        {ID:3003, PID:3, NAME: "巡查上报",MYURL: "/pages/app/sgxc/xcsb/xcsb.html"},
        {ID:4, PID:null, NAME: "巡查统计",MYURL: "/pages/app/sgxc/xctj/xctj.html"},
        /*
        {ID:4, PID:null, NAME: "基础配置",open: 'true'},
        {ID:4001, PID:4, NAME: "巡查终端",myUrl: "/pages/app/sjfx/szsk/swqx/swqxPage.html?projcd=1"},
        {ID:4002, PID:4, NAME: "巡查人员",myUrl: "/pages/app/sjfx/szsk/swqx/swqxPage.html?projcd=1"},
        */
    ];

    $.fn.zTree.init($("#treeDemo"), setting, nodes);
    var url = DSE.baseUrl + nodes[1].MYURL;
    $('#iframe').attr("src",url);

});