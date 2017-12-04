var tabHeight;
var menuHeight ;
/** 用户记录弹框标示 */
var index = -1;

var systemId;
var menuID; //此变量用作记录防汛物资的菜单ID


$(document).ready(function () {


    /*页面初始化工作*/
    initPage();

    /*初始化页面easyui选项卡 */
    initTab();

    /*初始化用户，放入sessionStorage*/
    initUser();

    /*发送ajax请求获取当前用户所拥有的所有菜单*/
    initMenu();

    /*初始化事件*/
    initEvent();

    /*地址栏带了参数，直接跳转到那个标签*/
    initRedirect();

});

function initPage() {
    //取菜单栏高度，不能写死，如果写死了不同分辨率下布局可能会乱  2017年10月11日
    menuHeight = $("#myMenu").height();
    tabHeight = $(window).height() - menuHeight ;
    $(".main").css("min-height", $(window).height() + "px");
    $(".main").css("min-width", $(window).width() + "px");
    //$("#contentDiv").css("min-height", tabHeight + "px");
}


function initTab() {
    var tab = $('#content');
    //console.log("复制高度：" + tabHeight);
    tab.tabs({
        border: false,
        plain: true,
        showHeader: false,
        tabHeight: 0,
        height: tabHeight + 'px'
    });

}

function initUser() {
    $.ajax({
        url: $.contextPath() + "sysController/getSessionUser.do",
        type: "get",
        async: false,
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            /*存入sessionStorage*/
            sessionStorage.clear();
            sessionStorage.setItem(Constans.USER_INFO, JSON.stringify(data));

            /*修改用户名称*/
            $('#userName').text(data.name);

            /*修改标题*/
            var divisionName = data.divisionName;
            var organizationShortName = data.organizationShortName;
            if (data.type == 1 || data.type == 9) {
                $('#name').text('');
            } else if (data.type == 4) {
                if (organizationShortName) $('#name').text('-' + organizationShortName.split(',')[0]);
            } else {
                if (divisionName) $('#name').text('-' + divisionName.split(',')[0]);
            }
            if ($('#name').text() == '') {
                $('#name').text('');
            }
            /*提示角色过期*/
            var pastDueRoleName = data.pastDueRoleName;
            if (pastDueRoleName != '') {
                layer.confirm('您当前拥有的' + pastDueRoleName + '角色已经过期', {
                    title: '警告',
                    btn: ['确定'],
                    offset: '35%'
                });
            }
        }
    });
}

function initMenu() {
    $.ajax({
        url: $.contextPath() + "resourceController/listResourceNodeByUser.do",
        type: "post",
        async: false,
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            //console.log(data);
            var cfg = {
                selected: addTab,
                data: data
            };
            $("#myMenu").iMenu(cfg);

        },
        error: function (data) {

        }
    });
}

function refreshTab(url,menuId,text){
    var tab = $('#content');
    //删除原来的
    tab.tabs('close', text);
    //新增一个新的
    tab.tabs('add', {
        id: menuId,
        content: '<iframe name="newReport" class="iframeContent" id = "iframe' + menuId + '" src="' + url
        + '" style="height:' + (tabHeight - 2) + 'px;width:100%" frameborder="no"  border="0" marginwidth="0" marginheight="0"  allowtransparency="yes"></iframe>',
        closable: true
    });

}

function addTab(url, menuId, text, nav_info) {
    /*菜单计数*/
    $.ajax({
        url: $.contextPath() + "moduleCountController/clickModuleCount.do",
        async: false,
        data: {
            moduleId: menuId,
            systemId: systemId
        },
        type: "post",
        complete: function (data) {
            if (!url || url == "#" || url == "null" || url.indexOf("#") > -1 || url.indexOf("null") > -1) {
                url = $.contextPath() + "sysController/notFind.do";
            }
            var nav = nav_info.split('>');
            var position = $('<span>当前位置：'+nav[0]+'>'+nav[1]+'>'+'<a class="refresh-nav" onclick="refreshTab(\''+url+'\',\''+menuId+'\',\''+text+'\')">'+nav[2]+'</a>'+'</span>');
            switch (nav.length){
                case 1 :
                    position = $('<span>当前位置：'+'<a class="refresh-nav" onclick="refreshTab(\''+url+'\',\''+menuId+'\',\''+text+'\')">'+nav[0]+'</a>'+'</span>');
                    break;
                case 2 :
                    position = $('<span>当前位置：'+nav[0]+'>'+'<a class="refresh-nav" onclick="refreshTab(\''+url+'\',\''+menuId+'\',\''+text+'\')">'+nav[1]+'</a>'+'</span>');
                    break;
                default : break;
            }
            $("#position").empty().append(position);
            var tab = $('#content');
            //console.log(tab);
            if (tab.tabs('exists', text)) { // 根据标题判断是否存在，只能通过标题和索引来判断，索引标题名称一定不能重复
                // 存在，直接显示
                tab.tabs('select', text);
            } else {
                /*if (url.indexOf('?') == -1) {
                 url += "?loadType=iframe";
                 } else {
                 url += "&loadType=iframe";
                 }*/

                // 不存在，则新增一个新的选项卡
                tab.tabs('add', {
                    id: menuId,
                    title: text,
                    content: '<iframe name="newReport" class="iframeContent" id = "iframe' + menuId + '" src="' + url
                    + '" style="height:' + (tabHeight - 2) + 'px;width:100%" frameborder="no"  border="0" marginwidth="0" marginheight="0"  allowtransparency="yes"></iframe>',
                    closable: true
                });
            }
        }
    });
}

function initEvent() {
    /*显示隐藏用户下拉框*/
    $('#userName').hover(function () {
        $('.dropDown').show();
    }, function () {
        $('.dropDown').hide();
    });

    $('.dropDown').hover(function () {
        $('.dropDown').show();
    }, function () {
        $('.dropDown').hide();
    });

    /*退出*/
    $("#logout").click(function () {
        window.location.href = $.contextPath()+"logout";
        /*$.ajax({
            url: $.contextPath() + "sysController/logout.do",
            async: false,
            contentType:'application/json',
            success: function (data) {
                if(data.status == '1') {
                    sessionStorage.clear();
                    window.location.href = $.contextPath() + "login.html";
                }
                else {
                    layer.msg('登出失败', {offset: '250px', icon: 4, time: 3000});
                }
            },
            error:function(){
                layer.msg('登出失败', {offset: '250px', icon: 4, time: 3000});
            }
        });*/

    });

    /*修改密码*/
    $("#changePwd").click(function () {
        layer.open({
            type: 2,
            title: '修改密码',
            closeBtn: 1,
            shadeClose: true,
            offset: '50ox',
            area: ['500px', '340px'],
            shift: 0,
            content: $.contextPath() + "pages/frame/main/main1/changePwd.html"
        });
    });

    /*用户信息*/
    $("#userinfo").click(function () {
        layer.open({
            type: 2,
            title: '用户详情',
            //area: ['1000px', '500px'],
            area: ['800px', '350px'],
            shift: 0,
            content: $.contextPath() + "pages/frame/main/main1/userInfo.html"
        });
    });
}

function initRedirect(){
    var menuId = $.getQueryString("menuId");
    if(menuId){
        $('#'+menuId).trigger("click");
    }
}

$.fn.iMenu = function (config) {
    var cfg = {
        selected: null, // 用户单击时触发 function(url,id,text,nav_info)
        // url:链接地址，id:菜单ID,nav_info 导航信息
        data: [{
            checked: null,
            children: null,
            halfCheck: null,
            icon: null,
            iconSkin: null,
            id: null,
            img: null,
            isParent: null,
            name: null,
            nocheck: null,
            orderIndex: null,
            pid: null,
            type: null,
            url: null,
            viewType: null,
            ISMENU: 1

        }]
    };

    var obj = $(this);
    if (typeof config == "string") {
        config = eval("(" + config + ")");
    }
    $.extend(cfg, config);

    init();

    // 单击节点时触发
    function selected() {
        var menu;
        if($(this).attr("class") == 'firstMenuImg'){
            menu = $(this).parent().find('div.firstMenuText');
        }else{
            menu = $(this);
        }
        //console.log(menu);
        var type = menu.attr("type");

        if (type == '3') {// 如果是菜单
            obj.find('.box').hide();
            var id = menu.attr("id");
            var url = menu.attr("url");
            var name = menu.text();
            var viewType = menu.attr("viewType");
            var user = JSON.parse(sessionStorage.getItem(Constans.USER_INFO));
            /*判断是否本系统*/
            if(url.indexOf('szyweb') > -1){
                url = url;
            }
            else if (url.indexOf('http') > -1) {
                if (url.indexOf('?') == -1) url = url + '?userName=' + user.userName;
                else url = url + '&userName=' + user.userName;
            }
            else url = $.contextPath() + url;

            /*弹出页面*/
            if (viewType == 1) {
                window.open(url);
            }
            /*全屏*/
            else if (viewType == 2) {
                var index = layer.open({
                    type: 2,
                    title: false/* ['编辑','font-family:微软雅黑;background-color:#f8f8f8;color:#444;font-weight:450;font-size:15px;'] */,
                    content: url
                    // maxmin: true
                });
                layer.full(index);
            }
            /*在本页面弹出*/
            else {
                var nav_info = getParentNodeInfo(id);
                systemId = getSysMenuId(id).split('>')[0];
                obj.find(".firstMenuItem").removeClass("now");
                obj.find('#item'+systemId).addClass("now");
                //obj.find(".firstMenuItem").removeClass("menuHover");
                cfg.selected(url, id, name, nav_info);
                if(id==="402809025e5a11e5015e5a1c7590000a"){    //特殊处理从首页跳转到报警查询页面
                    var isFirstClick = localStorage.getItem("isFirstClick") || 0;
                    if(isFirstClick && isFirstClick == 1 ){
                        refreshPage();
                    }
                    localStorage.setItem("isFirstClick",0);
                }
            }
        }
        return false;
    }

    //刷新/重载 content的内容
    function refreshPage() {
        var currentTab = $('.tabs-container').tabs('getSelected');
        $('.tabs-container').tabs('update',{
            tab:currentTab,
            options : {
                href : ''
            }
        });
    }

    // 找到导航路径
    function getParentNodeInfo(menuId) {
        var list = cfg.data;
        return findNode(menuId, list);
    }

    // 递归，找到最底层的节点，然后往上递归，获取上级节点
    function findNode(menuId, list) {
        var o = null;
        for (var i in list) {
            o = list[i];
            if (o.id == menuId) {// 找到了节点后，返回这个节点的文本
                return o.name;
            }
            var children = o.children;
            if (children && children.length > 0) {// 如果有子节点，则再遍历子节点
                var n = findNode(menuId, children);
                if(n) {
                    return o.name + ">" + n;
                }
            }
        }
    }

    function getSysMenuId(menuId) {
        var list = cfg.data;
        return findSysMenu(menuId, list);
    }

    // 递归，找到最底层的节点，然后往上递归，获取上级节点
    function findSysMenu(menuId, list) {
        var o = null;
        for (var i in list) {
            o = list[i];
            if (o.id == menuId) {// 找到了节点后，返回这个节点的文本
                return o.id;
            }
            var children = o.children;
            if (children && children.length > 0) {// 如果有子节点，则再遍历子节点
                var n = findSysMenu(menuId, children);
                if (n) {
                    return o.id + ">" + n;
                }
            }
        }
    }

    function init() {
        var screenWidth = window.screen.width;
        // cfg.data 是一个数组，里面保存了json菜单，最多支持3层菜单
        // 第一层容器
        var list = $('<div class="list"></div>');
        // 内容浮动层
        var box = $('<div class="box"></div>');
        var ui = $('<ul></ul>');
        var children2 = null;
        var children3 = null;
        var boxDiv = null;
        var li = null;
        var a = null;
        var img = null;
        list.append(ui);
        var firstA = null;
        var data = cfg.data;
        var itemDiv;

        for (var j = 0; j < data.length; j++) {
            if(data[j].name == '防汛物资'){
                menuID=data[j].id
            }
        }

        for (var i = 0; i < data.length; i++) {// 循环第一层菜单
            li = $('<li></li>');
            /*需要适应1024的分辨率*/
            if (screenWidth < 1366) {
                li.css("width", "60px");//70
                $('.logo').css("width","250px");
            }else if (screenWidth < 1600) {
                li.css("width", "81px");//91
                $('.logo').css("width","400px");
            }else {
                li.css("width", "100px");//112
                $('.logo').css("width","500px");
            }
            itemDiv = $('<div class="firstMenuItem" id="item'+data[i].id+'"></div>');

            li.append(itemDiv);

            if(data[i].name == '首页'){
                img = $('<div class="firstMenuImg"><img src="images/shouye.png" /></div>');
            }else if(data[i].name == '数据分析'){
                img = $('<div class="firstMenuImg"><img src="images/shujufenxi.png" /></div>');
            }else if(data[i].name == '防汛物资'){
                /* 隐藏防汛物资菜单 */
                li.css("display","none");

                img = $('<div class="firstMenuImg"><img src="images/fangxunwuzi.png" /></div>');
            }else if(data[i].name == '水工巡查'){
                img = $('<div class="firstMenuImg"><img src="images/shuigongxuncha.png" /></div>');
            }else if(data[i].name == '资料管理'){
                img = $('<div class="firstMenuImg"><img src="images/ziliaoguanli.png" /></div>');
            }else if(data[i].name == '辅助决策'){
                img = $('<div class="firstMenuImg"><img src="images/fuzhujuece.png" /></div>');
            }else if(data[i].name == '系统管理'){
                img = $('<div class="firstMenuImg"><img src="images/xitongguanli.png" /></div>');
            }else if(data[i].name == '在线监测'){
                img = $('<div class="firstMenuImg"><img src="images/zaixianjiance.png" /></div>');
            }else if(data[i].name == '报警查询'){
                img = $('<div class="firstMenuImg"><img src="images/baojinchaxun.png" /></div>');
            }
            itemDiv.append(img);

            if(data[i].name == '首页'){
                var lurl = data[i].url+'?id='+menuID;
                a = $('<div class="firstMenuText" viewType="' + data[i].viewType + '" type="' + data[i].type + '" id=' + data[i].id + ' url="' + lurl + '">' + data[i].name + '</div>');
            }else{
                a = $('<div class="firstMenuText" viewType="' + data[i].viewType + '" type="' + data[i].type + '" id=' + data[i].id + ' url="' + data[i].url + '">' + data[i].name + '</div>');
            }
            itemDiv.append(a);

            if (data[i].type == '3' && !firstA) {// 如果第一个菜单是菜单，则默认显示
                firstA = data[i].id;
            }

            if(data[i].type == '3') {
                img.click(selected);
                a.click(selected);
            }

            ui.append(li);

            boxDiv = $('<div class="cont"></div>');
            box.append(boxDiv);

            // 构建浮动层
            children2 = data[i].children;
            var ul2 = $('<ul class="submenuList"></ul>');
            var underline = $('<div class="underline"></div>');
            ul2.append(underline);
            var li2 = null;
            var sublist = null;
            var maxmenu2 = -1;
            if (children2 && children2.length > 0) {// 第二层菜单
                // console.log(children2.length);
                /*if(children2.length > 6){
                 console.log((1045+(parseInt(children2.length/6) * 170)) + "px");
                 box.css("width",(1045+(parseInt(children2.length/6) * 170)) + "px");
                 }else{
                 console.log("1045px");
                 box.css("width","1045px");
                 }*/

                for (var j = 0; j < children2.length; j++) {
                    li2 = $('<li></li>');
                    sublist = $('<div class="sublist clearfix"></div>');
                    li2.append(sublist);
                    ul2.append(li2);
                    boxDiv.append(ul2);
                    a = $('<a href="javascript:void(0)" viewType="' + children2[j].viewType + '" type="' + children2[j].type + '"   id=' + children2[j].id + ' url="'
                        + children2[j].url + '">' + children2[j].name + '</a>');
                    children3 = children2[j].children;
                    var h3 = $('<h3 class="secondMenu"></h3>');
                    h3.append(a);
                    sublist.append(h3);
                    if (children3 && children3.length > 0) {// 第三层菜单
                        if (children3.length > maxmenu2) {
                            maxmenu2 = children3.length > 8 ? 8 : children3.length;
                        }

                        //var p = $('<div class="mcate-item-bd clearfix"></div>');
                        var menu3col = parseInt(children3.length / 8.01);
                        for (var m = 0; m <= menu3col; m++) {
                            var p1 = $('<div class="mcate-item-bd"></div>');
                            sublist.append(p1);
                            for (var n = (m * 8); n < ( (m * 8 + 8) < children3.length ? (m * 8 + 8) : children3.length ); n++) {
                                var adiv = $('<div class="mcate-item"></div>');
                                a = $('<a href="javascript:void(0)" viewType="' + children3[n].viewType + '" type="' + children3[n].type + '" id=' + children3[n].id + ' url="'
                                    + children3[n].url + '">' + children3[n].name + '</a>');
                                a.click(selected);
                                adiv.append(a);
                                p1.append(adiv);
                                if (!firstA) {
                                    firstA = children3[n].id;
                                }
                            }
                        }
                    }
                }


            }
            else {
               // a.click(selected);
            }
           // console.log(maxmenu2);
            /*控制左边虚线长度*/

            boxDiv.find(".mcate-item-bd").css("height", (maxmenu2 * 40) + "px");
            boxDiv.find(".mcate-item-bd").css("background-size", "1px "+(maxmenu2 * 40 - 14)+"px");
           // boxDiv.find(".mcate-item-bd").css("background-position", "1px "+(maxmenu2 * 40 - 14)+"px");
        }

        if (screenWidth < 1366) {
            $('#myMenu').css("min-width", "900px");
        }else if (screenWidth < 1600) {
            $('#myMenu').css("min-width", "1200px");
        }else {
            $('#myMenu').css("min-width", "1400px");
        }

        obj.append(list);
        obj.append(box);

        // 表单构建完成，绑定事件
        var timer = null;
        var time = null;
        var lista = list.find(".firstMenuItem");

        var box_show = function (hei) {
            //console.log(hei);
            box.css("height",hei+"px");
            box.stop().slideDown(200);
        };

        var box_hide = function () {
            box.stop().slideUp(200,function(){
                box.css("height",null);
            });
        };

        lista.hover(function () {
            var _this = $(this);
            lista.removeClass('menuHover');
            box.hide();
            _this.addClass("menuHover");
             $('.now').removeClass("now");
            // _this.addClass("now");
            clearTimeout(timer);
            //var thisIndex = list.find(".firstMenuItem").index(_this);
            //box.css("right", "0px");
            ////if (screenWidth < 1366) {
            ////    box.css("right", "0px");
            ////}
            ////else {
            ////    if ((thisIndex + 1) > 9) {
            ////        var left = (thisIndex + 1 - 9) * 112;
            ////        box.css("right", left + "px");
            ////    } else {
            ////        box.css("right", "0px");
            ////    }
            ////}
            //// console.log(thisIndex);
            //
            //var floatBox = box.find(".cont").hide().eq(thisIndex);
            //var mbd = floatBox.find(".mcate-item-bd").eq(0);
            //if (floatBox.children().length > 0) {
            //    // box.show();
            //    var _height = mbd.height() + 52;
            //    timer = setTimeout(function () {
            //       // console.log("listhover");
            //        box_show(_height);
            //        timer = 0;
            //    }, 400);
            //    floatBox.show();
            //}
        }, function () {
            $('.menuHover').removeClass('menuHover');
            $('#item'+systemId).addClass('now');
            if (timer) {
                //console.log("listouttimeer");
                clearTimeout(timer);
                timer = 0;
                return;
            }
            //console.log("listout");
            box_hide();
            /* time = setTimeout(function () {

             }, 50);*/
            // lista.removeClass("now");
            // lista.eq(olda).addClass("now");
        });

        box.find(".cont").hover(function () {
            var _this = $(this);
            var _index = box.find(".cont").index(_this);
            $('.now').removeClass('now');
            lista.eq(_index).addClass("menuHover");
            //$('#'+choosedMenuId).parent('.firstMenuItem').addClass('now');
            // lista.removeClass("now");

            if(timer) {
                clearTimeout(timer);
            }
            var _height = _this.height();
            _this.show();
            //box.show();
            box.css("height", _height + "px");
            box.stop().slideDown(0);

        }, function () {
            timer = setTimeout(function () {
                $(this).hide();
                box_hide();
                timer = 0;
                $('.menuHover').removeClass('menuHover');
                $('#item'+systemId).addClass('now');
            }, 50);
            // lista.removeClass("now");
            // lista.eq(olda).addClass("now");
        });
        box.click(function(){
            box_hide();
        });
        // 默认让第一个单击
        // console.log(firstA);
        var menuId = $.getQueryString("menuId");
        if(!menuId) {
            //8ae4836f5c388dde015c490426cb0036
            $('#' + firstA).trigger("click");
        }
    }
};
