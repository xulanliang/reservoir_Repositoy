/**
 * Created by pc on 2017-7-7.
 */
// require_css('css!pages/app/common/css/style.css');

/*require_js('bjxx_search', 'pages/app/bjxx/js/bjxxSearch', ['eform']);
require_js('bjxx_datagrid', 'pages/app/bjxx/js/bjxxDatagrid', ['bjxx_search', 'datagrid_pager']);
require_shim('stylePage', ['bjxx_datagrid']);*/

//执行配置
require.config(DSE.requireConfig);
//
define("warnIndex", function (require, exports, module) {
    //var _stylePage = require('stylePage');

    //var $ = require("jquery");
    var base = require("base");
    var _ztree = require('ztree');
    var common = require("common");
    var _data = require("datagrid_pager");
    var main = require("pages/frame/main/main1/js/main")
    //引入 Vue + ElementUI
    var Vue = require('vue'),
        vue_component = require('vue_component'),
        ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //渲染实例
    DSE.app = new Vue({
        data: function () {
            return {
               url: '', //默认 iframe 不加载 url
                operType: '', //表单状态：add | edit | detail
                rowId: '', //主键 id
                batch: false, //判断显示隐藏
                title: '', //表单页显示的标题
                loading2: true,//loading 状态显示隐藏
                projcd:$.getParam("projcd"),//
                projcd_real:$.getParam("projcd_real"),//
                mon_tp:$.getParam("mon_tp"),
                wa_status: '0',
            }
        },
        methods: {

        }
    }).$mount('#app');
    //初始化查询

    var _keyId = 'WA_ID', //主键ID,根据业务修改,删除也是用的此字段
        _url = DSE.serverPath + 'shouyeCtrl/getWarnListByProjCd.do', //数据请求地址

        //可以删除或注释
        //因为模拟数据时,分页处理时需要用到初始所有数据,所以需要定义变量存储初始数据
        _oldData = _data,
        _h = $(document).height() , //计算列表的高度,根据页面内容调整此处数值

        _pageSize = parseInt((_h - 31) / 31), //列表高度,不用修改 ;滚动分页=_h + 31;普通分页=_h - 31
        _pageList = [10, 20, 30, _pageSize, 50].sort(function (a, b) {
            return a - b; //对_pageSize排序
        });

    //根据_data是否存在选择表格生成方式
    if (nullToSpace(_data) != '' && _data.length > 0) {
        //本地数据方式
        _url = null;
        _data = _oldData.slice(0, _pageSize); //用于本地数据分页
    } else {
        //ajax请求数据方式
        _data = null;
    }


    $('#datagrid').datagrid({
        url: _url,
        idField: _keyId, // 项目ID
        data: _data,
        queryParams: {
            projcd:DSE.app.projcd,
            projcd_real:DSE.app.projcd_real
        },
        pageSize: _pageSize,
        pageList: _pageList,
        height: '100%',
        pagination:true ,
        rownumbers : false,
        fitColumns : true ,
        //scrollbarSize:0,
        height:_h,
        columns:[
        [
        {
            field: 'MON_TP_NAME',
            title: '测点类型',
            width: '23%',
            fixed :true ,
            align: 'center'
        }, {
            field: 'STNM',
            title: '测点名称',
            fixed :true ,
            width: '23%',
            // formatter:function (value, rowData, rowIndex) {
            //     return '<a href="javascript:" class="f-link3" onclick="DSE.form.showEditOrDetail(\'' + rowData[_keyId] + '\',\'巡查任务信息\',\'detail\',\'./addOrEdit/addOrEdit.html?ck_re_id='+ rowData[_keyId]+'\')">' + nullToSpace(value) + '</a>';
            // }
        },{
            field: 'WA_TP_NAME',
            title: '报警类型',
            width: '23%',
            fixed :true ,
            align: 'center'
        }
        ,{
            field: 'REAL_VALUE',
            title: '测值',
            width: '23%',
            align: 'center'
        }
        ]],
        onDblClickRow:function (rowIndex,rowData) {
            //var  url=DSE.baseUrl + "/pages/app/sjfx/wrwarningPage.html";
            var  menu = parent.parent.$("#myMenu");
            var img = menu.find("#item402809025e5a11e5015e5a1c7590000a .firstMenuImg"); //找到查询那个菜单
            var url  = menu.find("#item402809025e5a11e5015e5a1c7590000a .firstMenuText").attr("url");
            var redirectParm = {} ;
            redirectParm.monTp = rowData.MON_TP ;
            redirectParm.projCd = rowData.PROJ_CD.substr(0,1) ;
            localStorage.setItem("redirectParm",JSON.stringify(redirectParm));
            localStorage.setItem("isFirstClick",parseFloat(localStorage.getItem("isFirstClick") || 0)+1);
            img.click();
            //menu.trigger('click');          //注册点击事件
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);             //关闭当前的
        }

    });
/*
    DSE.form.datagridPager(DSE.form.datagrid, _oldData);
    if(DSE.app.projcd_real){
        $('#datagrid').datagrid('showColumn', 'WA_VALUE');
       // $('#datagrid').datagrid('resize');
    }*/

});