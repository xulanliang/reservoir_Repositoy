/**
 * Created by pc on 2017-7-27.
 */
require_css('css!pages/app/fxwz/css/fxwzPage.css');

//执行配置
require.config(DSE.requireConfig);
define('fxwzPage', function (require, exports, module) {

    var _common = require('common');
    var _ztree = require('ztree');

    var h = $(document).height() - 0;

    $('.g-bd1').height(h);
    $('.g-mn1c').height(h-30);
    $('.myztree').height(h-20);

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

    var nodes = [
        //{ID:0, PID:null, NAME: "首页",open: 'true',MYURL: "/"},
        {ID:1, PID:null, NAME: "系统维护",open: 'true'},
        {ID:1001, PID:1, NAME: "仓库管理",MYURL: "/pages/app/fxwz/ckxxgl/ckxxglPage.html"},
        {ID:1002, PID:1, NAME: "物资分类",MYURL: "/pages/app/fxwz/wzflgl/wzflglPage.html"},
        {ID:1003, PID:1, NAME: "物资信息",MYURL: "/pages/app/fxwz/wzxxgl/wzxxglPage.html"},
        // {ID:1006, PID:1, NAME: "物资仓库查询",MYURL: "/pages/app/fxwz/wzxxglquery/wzxxglqueryPage.html"},
        // {ID:1004, PID:1, NAME: "物资存储定额",MYURL: "/pages/app/fxwz/wzkzgl/wzkzglList.html"},//物资库存
        {ID:2, PID:null, NAME: "物资使用",open: 'true'},
        {ID:2001, PID:2, NAME: "物资出库",MYURL: "/pages/app/fxwz/wzck/wzck.html"},
        {ID:2002, PID:2, NAME: "物资入库",MYURL: "/pages/app/fxwz/wzrk/wzrk.html"},
        {ID:3, PID:null, NAME: "物资统计",open: 'true'},
        {ID:3001, PID:3, NAME: "物资查询",MYURL: "/pages/app/fxwz/wzxxglsearch/wzxxglsearchPage.html"},
        {ID:3002, PID:3, NAME: "物资盘点",MYURL: "/pages/app/fxwz/wzxxglquery/wzxxglqueryPage.html"},
        {ID:3003, PID:1, NAME: "物资报警",MYURL: "/pages/app/fxwz/wrmawarningb/wrmawarningbPage.html"},
        {ID:4, PID:null, NAME: "维护保养",open: 'true'},
        {ID:4001, PID:4, NAME: "日常巡查",MYURL: "/pages/app/fxwz/wrmapatrolb/wrmapatrolbPage.html?is_flood=0"},
        {ID:4002, PID:4, NAME: "汛前查询及养护",MYURL: "/pages/app/fxwz/wrmapatrolb/wrmapatrolbPage.html?is_flood=1"},
        {ID:4003, PID:4, NAME: "汛后检查及养护",MYURL: "/pages/app/fxwz/wrmapatrolb/wrmapatrolbPage.html?is_flood=2"},
    ];

    $.fn.zTree.init($("#treeDemo"), setting, nodes);
    var url = DSE.baseUrl + nodes[2].MYURL;
    $('#iframe').attr("src",url);
});