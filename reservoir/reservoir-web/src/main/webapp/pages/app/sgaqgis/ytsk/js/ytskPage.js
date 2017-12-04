/**
 * Created by pc on 2017-7-7.
 */
//执行配置
require.config(DSE.requireConfig);
//
define("ytskPage", function (require, exports, module) {
    var $ = require("jquery");
    var base = require("base");
    var common = require("common");
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    var ytapp = new Vue({
        //
        el: "#app",
        data: function () {
            //
            return {
                activeName: 'gcxx'
            };
        },
        methods: {
            handleClick: function (tab, event) {
                if(tab.name == "cdxx"){
                    $('#cddatagrid').datagrid("reload");
                }else if(tab.name == "gcxx"){
                    $('#gcdatagrid').datagrid("reload");
                }
            }
        }
    });

    var _h = $(document).height()-$('#upper').height()-60;
    var w = ($('#app').width()-20)/2;

    $('#app').height(_h);
    $('.el-tabs__content').height(_h-$('.el-tabs__header').height());

    $('#gcdatagrid').datagrid({
        url: DSE.serverPath + '/shouyeCtrl/getProject.do',
        queryParams: {
            projcd: 2
        },
        height: '100%',
        columns:[[
            {field:'PROJ_NM',title:'工程名称',width:'50%',align: 'center'},
            {field:'PID',title:'所属工程',width:'50%',align: 'center',
                formatter: function(value, row, index){
                    if(value == 2){
                        return "雁田水库"
                    }else{
                        return;
                    }
                },
            }
        ]]
    });

    $('#cddatagrid').datagrid({
        url: DSE.serverPath + '/shouyeCtrl/getPoint.do',
        queryParams: {
            projcd: 2
        },
        height: '100%',
        columns:[[
            {field:'STNM',title:'测点名称',width:w,align: 'center'},
            {field:'PROJ_NM',title:'所属工程',width:w,align: 'center'}
        ]]
    });

});