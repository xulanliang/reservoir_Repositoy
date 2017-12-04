//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/common/css/style.css');
require_css('css!pages/app/zlgl/css/style.css');

require_js('wdgl_search', 'pages/app/zlgl/js/wdglSearch', ['eform']);
require_js('wdgl_datagrid', 'pages/app/zlgl/js/wdglDatagrid', ['wdgl_search', 'datagrid_pager']);
require_shim('stylePage', ['wdgl_datagrid']);

//执行配置
require.config(DSE.requireConfig);
define('zlglMain', function (require, exports, module) {
    var _stylePage = require('stylePage');
    var _date = require('date');
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
                pickerOptions2: vue_component.pickerOptions2, //使用日期范围组件
                dateVal: getAddDate(-180, new Date().dseDateFormat("yyyy-MM-dd")) + " - " + new Date().dseDateFormat("yyyy-MM-dd"), //日期范围初始化
                minDate: getAddDate(-180, new Date().dseDateFormat("yyyy-MM-dd")), //起始日期
                maxDate: new Date().dseDateFormat("yyyy-MM-dd"), //结束日期
                title: '', //表单页显示的标题
                adcd: '',   //组织机构ID
                ttype: '',  //文档类别
                code:'',
                loading2: true,//loading 状态显示隐藏,
                pageTitle:'',   //页面标题
            }
        },
        methods: {
            //日期 change
            changeDateVal: function (value) {
                //this.minDate = value.substring(0, 10);
                //this.maxDate = value.substring(value.length - 10, value.length);
                DSE.form.doSearch();
            },

            //模拟数据
            /*addSearchData: function (_data) {
             return _data = $ajax({
             url: _serverPath + 'pages/app/data/data_datagrid.json'
             })["rows"];
             },*/
            //添加 param 数据
            addSearchParam: function(_param){
                _param["strDate"] = this.minDate;
                _param["endDate"] = this.maxDate;
                return _param;
            },
            //新增
            doOpenWin: function () {
                /*
                 *根据业务需求修改
                 * */
                this.operType = 'add';
                this.title = '新增文档管理';
                DSE.pageConfig.operType = 'add';
                DSE.user.userName = window.userName;
                this.rowId = $.getId();
                DSE.pageConfig.rowId = this.rowId;
                if (this.url === '') {
                    this.url = './addOrEdit/addOrEdit.html';
                }
            },
            //关闭
            doCloseWin: function () {
                this.operType = '';
            },
            //批量操作
            doBatch: function () {
                $('.top-btns-box').removeClass('f-dn');
                this.batch = true;
                DSE.form.doBatchDatagrid(_datagrid, this.batch);
            },
            //退出批量
            doEscBatch: function () {
                this.batch = false;
                DSE.form.doBatchDatagrid(_datagrid, this.batch);
            },
            //删除
            doBatchDelete: function () {
                //deleteDatagridRow可以传两个参数,title和url
                //注：因为通用删除时可以批量删除的,请求默认传参数名为ids
                //然后删除时一些提交上报后的数据是不能删除的,所以会有默认一个status字段判断选中的数据是否能够删除,constraint为判断条件
                //如：状态名为datastatus,同时判断条件为'0||1||5',表示选中的数据中包含有datastatus状态值为'2,3,4,6'的时候不能删除
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:'datastatus',constraint: '2,3,4,6'});
                //如不需要此判断可以添加参数
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{status:false});
                //如参数名不同可以加上第三个参数,如：deleteId为后台所需接收的参数名,
                //deleteDatagridRow('所选数据','jf/FxzbCtrl/deleteData',{deleteId:'deleteId'});
                // deleteDatagridRow('所选数据', 'yaglCtrl/deleteInfoByIds.do', {status: false});
            },
            //查询
            doSearch: function () {
                DSE.form.doSearch();
            },
            //恢复为默认
            doReset: function () {
                this.dateVal = '';
                DSE.form.doReset();

            }
        }
    }).$mount('#app');


    $('.left-sublist').height($(document).height() - 30);
    $('#sublis-tree').height($(document).height() - 57);


    var adcd = '.adcd-box';
    $(adcd).tree({
        // // data: divisionInfo,
        url:DSE.serverPath+'/organizationController/listUserChildrenById.do',
        width: '100%',
        height: 'auto',
        checkbox: false,
        lines: false,
        dnd: true,          //是否启用拖拽功能。
        enable: true,
        queryParams: {"id":-1,"level":0},
        prompt: '-选择组织机构-',
        onLoadSuccess: function (node, data) {
            /**
             * 默认选中第一个
             */
            if (data.length > 0) {
                //找到第一个元素
                var n = $(adcd).tree('find', data[0].id);
                //调用选中事件
                var wd = n.children;
                if(wd.length > 0){
                    var nCD = $(adcd).tree('find', wd[0].id);
                    $(adcd).tree('select', nCD.target);
                }
            }
        },
        loadFilter: function(data){
            for(var i = 0 ; i <data.length; i++){
                data[i]['text'] = data[i]['name'];
                if(i != 0){
                    data[i]["state"]='closed';
                }
                if(data[i]['isParent'] == 'false'){
                    data[i]['isParent'] = true;
                    data[i]['children'] = [];
                }
                //添加文档资料类型
                var result=window.wdlxData;
                var result2=[];
                for(var j=0;j<result.length;j++){
                    result2.push({
                        PID:data[i]['id'],
                        text:result[j]['NAME'],
                        id:result[j]['CODE']
                    });
                }
                data[i]['children']=result2;
            }
            return data;
        },
        onSelect: function (rec) {
            if(rec.isParent){
                //点击组织机构
            }else {
                //点击文档类型
                //获取父节点
                var parNode = $(adcd).tree('getParent',rec.target);
                DSE.app.adcd = parNode.id;
                DSE.app.ttype = rec.id;
                DSE.app.dateVal = '';
                //更改页面标题
                DSE.app.pageTitle = rec.text;
                setTimeout(function(){DSE.form.doReset()},100);
            }
        }
    });

    //重新加载所有数据
    // function reload() {
    //     doSearch();
    // }

    window.wdlxData = getDataInfo(DSE.serverPath + '/sysCommonCtrl/getListBycode.do?code=wdlb')["data"] || [];
    var _li = '';
    $.each(wdlxData, function (i) {
        _li += '<li class="f-fl">\
                    <a href="javascript:" class="folder" data-btype="' + wdlxData[i]["CODE"] + '" data-code="' + wdlxData[i]["CODE"] + '">\
                        <i class="fa fa-folder-open"></i><br>\
                        <span class="txt">' + wdlxData[i]["NAME"] + '</span>\
                    </a>\
                </li>';
    });
    $('.wdbox').html(_li);

    /**
     * 单击文件夹
     */
    $('.wdbox .folder').click(function () {
        var $t = $(this);
        DSE.app.ttype = $t.attr('data-btype');
        DSE.app.code='';
        $('.g-cont1').hide();
        $('.g-cont2').show();
        $('.g-cont2 .m-tit1').html($t.text()+'<span class="reply"><i class="fa fa-reply"></i>返回</span>');
        setTimeout(function(){DSE.form.doReset()},100);
    });

    //$('.g-cont2').delegate('.reply','click',function(){
    //    $('.g-cont2').hide();
    //    $('.g-cont1').show();
    //});

    //获取信息
    function getDataInfo(url) {
        var $data = [];
        $.ajax({
            url: url,
            async: false,
            contentType:'application/json;charset=UTF-8',
            success: function (data) {
                $data = data;
            }
        });
        return $data;
    }

});