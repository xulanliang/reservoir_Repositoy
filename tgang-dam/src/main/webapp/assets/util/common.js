/**扩展原型,提供一些公共的方法，统一写在一个文件中，不写在各个文件中的原因是提高性能，浏览器不用去加载多个文件*/
var _commonPlugin = function ($, win) {
    /* ajax 全局设置 */
    $.ajaxSetup({
        type: 'POST',
        cache: false,
        complete: function (data, status) {// 不管什么情况下都执行这个方法,如果用error:方法的话easyui好像不能触发
            var m = null;
            switch (data.status) {
                case 404:
                    if(data.responseText=='timeout'){
                        m = '3000';
                    }else{
                        m = '指定URL不存在';
                    }
                    break;
                case 400:
                    m = "请求出错,请求URL可能不存在!";
                    break;
                case 500:
                    m = '服务器出现内部错误';
                    break;
                case 403:
                    m = '禁止访问';
                    break;
                case 3000:
                    m = '3000';
                    break;
            }
            if (m) {
                if (m == '3000') {
                    //刷新当前页面，会自动进行拦截进入登录
                    window.top.location.reload();

                    /*
                     if (!window.top._layerWinIndex) {
                     window.top._layerWinIndex = layer
                     .open({
                     type : 2,
                     title : [
                     ' 登 录',
                     'font-weight: bold;padding-left:30px;font-size:14px;height:33px; line-height:33px;color:#ffffff;font-family:宋体;background-image: url(sys/login/login1/img/login_title_bg.gif);' ],
                     offset : '20px',
                     shadeClose : false,
                     shade : 0.03,
                     area : [ '362px', '200px' ],
                     // skin: 'layer-login-win', //样式类名
                     content : 'sys/login/login1/loginWin.jsp?toUrl=closeWin',
                     end : function() {
                     window.top._layerWinIndex = null;
                     }
                     });
                     }
                     */

                } else {
                    layer.msg(m + ', 请联系管理员.<br/> 错误代码：' + data.status);
                }
            }
        }
    });

    String.prototype.getBytes = function () {
        var cArr = this.match(/[^x00-xff]/ig);
        return this.length + (cArr == null ? 0 : cArr.length);
    };

    win.nullToSpace = function (v) {
        return !v && v != '0' ? '' : v;
    };

    win.getFlashMovieObject = function (movieName) {
        if (window.document[movieName]) {
            return window.document[movieName];
        } else if (navigator.appName.indexOf("Microsoft") == -1) {
            if (document.embeds && document.embeds[movieName])
                return document.embeds[movieName];
        } else {
            return document.getElementById(movieName);
        }
    };

    /** ******************通用的js方法************* */
    /**
     * 截取字符串空格
     */
    String.prototype.trim = function () {
        return this.replace(/(^\s*)|(\s*$)/g, "");
    };

    /** 数组,是否包含某个值 */
    Array.prototype.contains = function (arr) {
        for (var i = 0; i < this.length; i++) {// this指向真正调用这个方法的对象
            if (this[i] == arr) {
                return true;
            }
        }
        return false;
    };
    /** 截取最大字符串 */
    String.prototype.subMaxStr = function (len) {
        if (this.length > len) {
            return this.substr(0, len) + "..";
        } else {
            return this;
        }
    };
    /** 截取后缀后的字符 */
    String.prototype.lastStr = function (split) {
        if (!split) {
            split = "/";
        }
        if (this.length > 0) {
            return this.substring(this.lastIndexOf(split), this.length);
        } else {
            return this;
        }
    };
    /** 截取后缀前的字符串 */
    String.prototype.preStrWidhSubfix = function (split) {
        if (!split) {
            split = "/";
        }
        if (this.length > 0) {
            return this.substring(0, this.lastIndexOf(split));
        } else {
            return this;
        }
    };
    /** 替换字符串 */
    String.prototype.replaceAll = function (sourceStr, targetStr) {
        if (!targetStr) {
            targetStr = '';
        }
        return this.replace(new RegExp(sourceStr, 'gm'), targetStr);
    };

    String.prototype.startWith = function (str) {
        if (str == null || str == "" || this.length == 0 || str.length > this.length) {
            return false;
        }
        if (this.substr(0, str.length) == str) {
            return true;
        }
        return false;
    };
    String.prototype.endWith = function (str) {
        if (str == null || str == "" || this.length == 0 || str.length > this.length) {
            return false;
        }
        if (this.substring(this.length - str.length) == str) {
            return true;
        }
        return false;
    };

    /*******************************************************************************
     * 检测当前字符串是否是url地址
     *
     * @returns {Boolean}
     */
    String.prototype.isURL = function () {
        var strRegex = '^((https|https2|http|http2|ftp|rtsp|mms)://)' + '(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' // ftp的user@
            + '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
            + '|' // 允许IP和DOMAIN（域名）
            + '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
            + '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
            + '[a-z]{2,6})' // first level domain- .com or .museum
            + '(:[0-9]{1,4})?' // 端口- :80
            + '((/?)|' // a slash isn't required if there is no file name
            + '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
        var re = new RegExp(strRegex);
        if (re.test(this)) {
            return (true);
        } else {
            return (false);
        }
    };

    // 日期工具类
    timeStampFormatDate = function(timeStamp) {
        if (timeStamp != null && timeStamp != '') {
            var date = new Date(parseFloat(timeStamp));
            var year = date.getFullYear();
            var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
            var day = date.getDate() < 10 ? '0' + (date.getDate()) : (date.getDate());
            return year + '-' + month + '-' + day;
        } else
            return '';
    };
    timeStampFormatDateString = function(timeStamp) {
        if (timeStamp != null && timeStamp != '') {
            var date = new Date(parseFloat(timeStamp));
            var year = date.getFullYear();
            var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
            var day = date.getDate() < 10 ? '0' + (date.getDate()) : (date.getDate());
            return year + '' + month + '' + day;
        } else
            return '';
    };
    timeStampFormatDateTime = function(timeStamp) {
        if (timeStamp != null && timeStamp != '') {
            var date = new Date(parseFloat(timeStamp));
            var year = date.getFullYear();
            var month = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
            var day = date.getDate() < 10 ? "0" + date.getDate() : (date.getDate());
            var hour = date.getHours() < 10 ? "0" + date.getHours() : (date.getHours());
            var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : (date.getMinutes());
            var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : (date.getSeconds());
            return year + '-' + month + '-' + day + " " + hour + ":" + minute + ":" + second;
        } else
            return '';
    };
    dateTimeFormatTimeStamp = function (dateTime) {
        var timeStamp = new Date((''+dateTime).replace(new RegExp("-","gm"),"/")).getTime();
        if(timeStamp){
            return timeStamp;
        }
        return '';
    };

    /**
     * 提供一些公共的方法，统一写在一个文件中，不写在各个文件中的原因是提高性能，浏览器不用去加载多个文件
     */
        // 日期格式化
    Date.prototype.format = function (format) {
        var o = {
            "M+": this.getMonth() + 1, // month
            "d+": this.getDate(), // day
            "h+": this.getHours(), // hour
            "m+": this.getMinutes(), // minute
            "s+": this.getSeconds(), // second
            "q+": Math.floor((this.getMonth() + 3) / 3), // quarter
            "S": this.getMilliseconds()
            // millisecond
        };
        if (/(y+)/.test(format))
            format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(format))
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        return format;
    };

    /** 获取子数组,array 里面应该保存着json数据，然后通过attr属性去匹配 val值，如果相等，则返回 */
    Array.prototype.getSubArray = function (attr, val) {
        var newList = new Array();
        var list = this;
        if (list == null || list.length == 0) {
            return newList;
        } else {
            for (var i = 0; i < list.length; i++) {
                if (list[i][attr] == val) {
                    newList.push(list[i]);
                }
            }
            return newList;
        }
    };

    // 是否存在指定函数
    win.isFunction = function (funcName) {
        try {
            if (typeof (eval(funcName)) == "function") {
                return true;
            }
        } catch (e) {

        }
        return false;
    };
// 是否存在指定变量
    win.isVariable = function (variableName) {
        try {
            if (typeof (variableName) == "undefined") {
                return false;
            } else {
                return true;
            }
        } catch (e) {

        }
        return false;
    };
//注：请不要删掉这个方法
//判断是否为空    
    win.isEmpty = function (val) {
        if (val == "" || typeof (val) == "undefined" || val == null || val == '-1') {
            return true;
        }
        return false;
    };

// 参数插件
    (function ($) {
        // 在某个地址栏中查找参数
        $.getParam = function (name, url) {
            if (name) {
                if (!url) {
                    url = decodeURI(window.location.href);
                }
                return getURLparam(name, url);
            } else {
                // 有些 地址栏的参数就是 一个网址如
                // http://localhost:8080/boke/aa.sl?url=http://localhost:8080/boke/bb.sl?a=3&b=2&c=1,
                // 如果通过getUrlParam('url') 只能获得http://localhost:8080/boke/bb.sl?a=3
                var param = window.location.search;
                if (param.indexOf("?", 0) == 0) {

                    param = param.substring(1, param.length);
                }
                return param;
            }
        };
        // 在当前浏览器最顶层地址栏中查找参数
        $.getTopParam = function (name, url) {
            if (!url) {
                url = decodeURI(window.top.location.href);
            }
            return getURLparam(name, url);
        };

        // 获取参数核心
        function getURLparam(name, search) {
            var reg = new RegExp("(^|[&|?])" + name + "=([^&]*)(&|$)");
            var r = search.substr(1).match(reg);
            if (r != null) {
                var val = unescape(r[2]);
                return val == '' ? null : val;
            }
            return null;
        }
        // 获取基础路径，如http://localhost:8080/pro
        $.baseUrl = function () {
            if (!window._baseUrl) {
                var local = window.location;
                var contextPath = local.pathname.split("/")[1];
                window._baseUrl = local.protocol + "//" + local.host + "/" + contextPath;
            }
            return window._baseUrl;
        };

        // 获取IP加端口号
        $.getIpPort = function () {
            if (!window._ipPort) {
                var local = window.location;
                window._ipPort = local.protocol + "//" + local.host;
            }
            return window._ipPort;
        };


        // 获取上下文
        $.contextPath = function () {
            if (!window._contextPath) {
                var local = window.location;
                var contextPath = local.pathname.split("/")[1];
                window._contextPath = "/" + contextPath;
            }
            return window._contextPath;
        };

        // 获取内容
        $.getObjAttr = function (val) {
            return (val != null && val != undefined) ? val : '';
        };

        $.fn.visible = function (val) {
            if (val || val == undefined) {// 可见
                $(this).css('visibility', 'visible');
            } else {// 不可见
                $(this).css('visibility', 'hidden');
            }
        };
        // 水机获取主键值
        $.getId = function () {
            var str = "";
            // 格式化时间类型
            for (var i = 0; i < 15; i++) {// 循环产生随机数字串
                str += Math.floor(Math.random() * 10);
            }
            return str;
        };

        // 获取用户会话信息
        $.userInfo = function () {
            if (!window._userInfo) {
                $.ajax({
                    url: window._baseUrl + "UserCtl/currentUser.ds",
                    async: false,
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {
                        window._userInfo = data;
                    }
                });
            }
            return window._userInfo;
        };

        // 加载权限，然后存放到jquery对象中
        $.hasRule = function (optype) {
            var moduleid = $.getParam('moduleid');
            // 如果用户对象还没加载出来，或者没有传递模块ID，则返回false,表示没权限
            if (!$.userinfo || !moduleid) {
                return false;
            }
            var flag = false;
            // 是一个json对象
            var umap = $.userinfo.userPermission;
            if (umap[moduleid]) {
                var valm = umap[moduleid];
                if (valm[optype]) {
                    flag = true;
                }
            }
            return flag;
        };

    })(jQuery);

    /** 关闭窗口，layer 关闭frame窗口模式，目前写在这个公共类里面 */
    win.closeWin = function() {
        var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
        parent.layer.close(index);
    };
    /** 重新设置窗口高度 */
    win.setWinSize = function (size, win) {
        if (!win) {
            win = this;
        }
        var doc = $(win.parent.document);

        var iframe = doc.find("#" + win.name.replace("-iframe", ""));
        // 高度
        iframe.height(size);
        // 高度自适应
        iframe.css("top", (iframe.parent().height() - iframe.height()) / 2);
        doc.find("#" + win.name).height(iframe.height());
        layer.iframeAuto(parent.layer.getFrameIndex(win.name));
    };

    win.getExplorer = function() {
        var explorer = window.navigator.userAgent ;
        //ie  
        if (!!window.ActiveXObject || "ActiveXObject" in window) {
            return 'ie';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if(explorer.indexOf("Chrome") >= 0){
            return 'Chrome';
        }
        //Opera
        else if(explorer.indexOf("Opera") >= 0){
            return 'Opera';
        }
        //Safari
        else if(explorer.indexOf("Safari") >= 0){
            return 'Safari';
        }
    };

// 表格没有数据时自动显示一个没有数据提示 datagrid:datagrid表格对象
    win.datagridNoData = function (datagrid) {
        var data = datagrid.datagrid("getData");
        if (data.total == 0) {
            var ops = datagrid.datagrid("options");
            var body = datagrid.data().datagrid.dc.body2;
            var colLen = 0;// 合并的列，及时大于表格的列，也不会出现问题
            for (var i = 0; i < ops.columns.length; i++) {
                colLen += ops.columns[i].length;
            }
            body.css('height', '40px').find('table tbody').html('<tr><td width="' + body.width() + '" style="height: 25px; padding: 0; text-align: center;" colspan="' + colLen + '">' +
                '<div class="datagridNoData">没有数据</div></td></tr>');
        }
    };
    win.dataGridNoRowsRender = function(id,spanNum,info){
        $('#' + id).prev().children().next().children().children().children()
            .after('<tr><td align="center" style="border:none;" colspan="'+spanNum+'">'+(info || '没有相关记录')+'</td></tr>');
    };
//字符串超出显示title
    win.doShowTip = function (obj, len, omit) {
        var $tips = function ($t, $text) {
            len ? $t.addClass('f-wwb') : $t.addClass('f-toe');
            $t.attr('title', $text).tooltip({
                position: 'right',
                trackMouse: true,
                onShow: function () {
                    $t.tooltip('tip').css({
                        borderColor: 'orange',
                        boxShadow: '1px 1px 3px #999'
                    });
                }
            });
        };
        $(obj).show(function () {
            var $t = $(this),
                $text = String($t.text()),
                $tipsFun = function (len) {
                    var $slen = len * 2,
                        $olen = $text.getBytes();
                    if ($slen < $olen) {
                        var a = 0,
                            str_cut = new String();
                        for (var i = 0; i < $slen; i++) {
                            var c = $text.charAt(i);
                            a++;
                            if (escape(c).length > 4) {
                                a++;//中文字符的长度经编码之后大于4
                            }
                            str_cut = str_cut.concat(c);
                            //判断是否超出限制字数
                            if ($slen <= a) {
                                $tips($t, $text);
                                omit ? $text = str_cut : $text = str_cut.substring(0, str_cut.length - 1).concat("...");
                                $t.text($text);
                                return false;
                            }
                        }
                    }
                };
            //判断是否有子标签
            if ($(obj).find('h1,h2,h3,h4,h5,h6,a,div,span,p,b,i,label,em,strong').length == 0 && len) {
                $tipsFun(len);
            } else {
                var $sWidth = $t[0].scrollWidth,
                    $oWidth = $t[0].offsetWidth;
                //判断文本是否溢出
                if ($sWidth != $oWidth) {
                    $tips($t, $text);
                } else {
                    if (len) {
                        $tipsFun(len);
                    }
                }
            }
        });
    };

    //获取选中的ids
    win.getSelectId = function (_MyDataGrid, _keyId) {
        var _s = _MyDataGrid.datagrid('getSelections'), _ids = '';
        for (var i in _s) {
            var $sta = String(nullToSpace(_s[i]["status"])),
                $id = _s[i][_keyId]; //主键ID

            //if ($sta == '0' || $sta == '1' || $sta == '5' || $sta == '') {
            if ($id) {
                _ids == '' ? _ids += $id : _ids += ',' + $id;
            }
//        }
        }
        return _ids;
    };
    //打开 layer窗口
    win.openWin = function (tit, url, offset, area, closeBtn) {
        offset = offset || 0;
        area = area || ['100%', '100%'];
        closeBtn = closeBtn || 1;
        layer.open({
            type: 2, // iframe层
            title: tit,
            content: String(url),
            offset: offset,
            shadeClose: false,
            closeBtn: closeBtn,
            moveOut: true,
            shade: 0.03,
            area: area // IE，火狐，chrome 1024*768 兼容
        });
    };
    //同步获取ajax数据
    win.getDataInfo = function (url, param) {
        var $data = [],
            $param = param ? param : {};
        $.ajax({
            type: 'post',
            url: url,
            async: false,
            data: $param,
            dataType: 'json',
            success: function (data) {
                $data = data;
            }
        });
        return $data;
    };
    //查询表单选择起始日期
    win.vDateToSelect = function ($sta_date, $end_date, type) {
        var $sta = $sta_date.datebox('getValue'),
            $end = $end_date.datebox('getValue');

        if ($end != '') {
            var $sta2 = parseInt($sta.replace(/-/g, '')),
                $end2 = parseInt($end.replace(/-/g, ''));
            if ($sta2 > $end2) {
                if (type == 1) {
                    $sta_date.datebox('setValue', $end);
                } else {
                    $end_date.datebox('setValue', $sta);
                }
            }
        }
    };

    win.createFormPage = function(strPrintName, printDatagrid) {
        // strPrintName 打印任务名
        // printDatagrid 要打印的datagrid
        var tableString = '<table cellspacing="0" class="pb">';
        var frozenColumns = printDatagrid.datagrid("options").frozenColumns; // 得到frozenColumns对象
        var columns = printDatagrid.datagrid("options").columns; // 得到columns对象
        var nameList = '';

        // 载入title
        if (typeof columns != 'undefined' && columns != '') {
            $(columns).each(function(index) {
                tableString += '\n<tr>';
                if (typeof frozenColumns != 'undefined' && typeof frozenColumns[index] != 'undefined') {
                    for (var i = 0; i < frozenColumns[index].length; ++i) {
                        if (!frozenColumns[index][i].hidden) {
                            tableString += '\n<th width="' + frozenColumns[index][i].width + '"';
                            if (typeof frozenColumns[index][i].rowspan != 'undefined' && frozenColumns[index][i].rowspan > 1) {
                                tableString += ' rowspan="' + frozenColumns[index][i].rowspan + '"';
                            }
                            if (typeof frozenColumns[index][i].colspan != 'undefined' && frozenColumns[index][i].colspan > 1) {
                                tableString += ' colspan="' + frozenColumns[index][i].colspan + '"';
                            }
                            if (typeof frozenColumns[index][i].field != 'undefined' && frozenColumns[index][i].field != '') {
                                nameList += ',{"f":"' + frozenColumns[index][i].field + '", "a":"' + frozenColumns[index][i].align + '"}';
                            }
                            tableString += '>' + frozenColumns[0][i].title + '</th>';
                        }
                    }
                }
                for (var i = 0; i < columns[index].length; ++i) {
                    if (!columns[index][i].hidden) {
                        tableString += '\n<th width="' + columns[index][i].width + '"';
                        if (typeof columns[index][i].rowspan != 'undefined' && columns[index][i].rowspan > 1) {
                            tableString += ' rowspan="' + columns[index][i].rowspan + '"';
                        }
                        if (typeof columns[index][i].colspan != 'undefined' && columns[index][i].colspan > 1) {
                            tableString += ' colspan="' + columns[index][i].colspan + '"';
                        }
                        if (typeof columns[index][i].field != 'undefined' && columns[index][i].field != '') {
                            nameList += ',{"f":"' + columns[index][i].field + '", "a":"' + columns[index][i].align + '"}';
                        }
                        tableString += '>' + columns[index][i].title + '</th>';
                    }
                }
                tableString += '\n</tr>';
            });
        }
        // 载入内容
        var rows = printDatagrid.datagrid("getRows"); // 这段代码是获取当前页的所有行
        var nl = eval('([' + nameList.substring(1) + '])');
        for (var i = 0; i < rows.length; ++i) {
            tableString += '\n<tr>';
            $(nl).each(function(j) {
                var e = nl[j].f.lastIndexOf('_0');

                tableString += '\n<td';
                if (nl[j].a != 'undefined' && nl[j].a != '') {
                    tableString += ' style="text-align:' + nl[j].a + ';"';
                }
                tableString += '>';
                if (e + 2 == nl[j].f.length) {
                    var fieldName = nl[j].f.substring(0, e);
                    if (fieldName == '') {
                        fieldName = 't';
                    }
                    var value = rows[i][fieldName];
                    tableString += value;
                } else tableString += rows[i][nl[j].f];
                tableString += '</td>';
            });
            tableString += '\n</tr>';
        }
        tableString += '\n</table>';
        tableString = tableString.replaceAll('null', ' ').replaceAll('undefined', '');
        return tableString;
    };

    //报表导出
    win.exportReport = function (tableid, fileName) {
        tableToExcel(tableid, null, fileName);
        // if(getExplorer()=='ie') {
        //     var iframe = document.getElementById('report');
        //     var curTbl = iframe.contentWindow.document.getElementById(tableid);
        //     var oXL = new ActiveXObject("Excel.Application");
        //     var oWB = oXL.Workbooks.Add();
        //     var xlsheet = oWB.Worksheets(1);
        //     var sel = document.body.createTextRange();
        //     sel.moveToElementText(curTbl);
        //     sel.select();
        //     sel.execCommand("Copy");
        //     xlsheet.Paste();
        //     oXL.Visible = true;
        //     try {
        //         var fname = oXL.Application.GetSaveAsFilename("Excel.xls", "Excel Spreadsheets (*.xls), *.xls");
        //     } catch (e) {
        //         print("Nested catch caught " + e);
        //     } finally {
        //         oWB.SaveAs(fname);
        //         oWB.Close(savechanges = false);
        //         oXL.Quit();
        //         oXL = null;
        //         idTmr = window.setInterval("Cleanup();", 1);
        //     }
        // }
        // else{
        //     tableToExcel(tableid, null, fileName);
        // }
    };

    function Cleanup() {
        window.clearInterval(idTmr);
        CollectGarbage();
    }
    var tableToExcel = (function() {

        var /*uri = 'data:application/vnd.ms-excel;base64,',*/
            template = '<html><head><meta charset="UTF-8"></head><body><table>{table}</table></body></html>',
            base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))); },
            format = function(s, c) {
                return s.replace(/{(\w+)}/g,
                    function(m, p) { return c[p]; }); };
        return function(table, name, fileName) {
            if (!table.nodeType) {
                var iframe = document.getElementById('report');
                table = iframe.contentWindow.document.getElementById(table);
            }
            var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML};
            var url = window._serverPath + 'dse/HelperCtl/downloadRequest.ds';
            $.ajax({
                url: url,
                method: 'POST',
                contentType:'application/json',
                async: false,
                data: JSON.stringify({body:base64(format(template, ctx))}),
                success: function(data){
                    window.location.href = encodeURI(window._serverPath + '/dse/HelperCtl/down.ds?filePath=' + data + '&fileName=' + fileName);
                }
            });
        };
    })();

    $.fn.getFormData = function() {
        var _this = $(this);
        var _elements = _this.find('[name]');
        var _formObj = {};
        for ( var i = 0; i < _elements.length; i++) {
            _formObj[_elements[i].name] = _elements[i].value;
        }
        return _formObj;
    };

    $.fn.reset = function(data) {
        var _this = $(this);
        var _elements = _this.find('[name]');
        for ( var i = 0; i < _elements.length; i++) {
            var flag = true;
            for ( var j in data) {
                if (_elements[i].name == data[j]) {
                    flag = false;
                }
            }
            if (flag) {
                if (_elements[i].tagName.toLowerCase() == 'select') {
                    _elements[i].value = _this.find('[name="' + _elements[i].name + '"]').find('option').eq(0).attr('value');
                } else
                    _elements[i].value = '';
            }
        }
    };

    win.dateboxInit = function (objId,v) {
        if (!v) {
            var d = new Date();
            var a = parseInt(d.getMonth()) < parseInt('9') ? '0' + parseInt(d.getMonth()) : d.getMonth();
            v = d.getFullYear() + '-' + a;
        }
        $('#' + objId).val(v);
        $('#' + objId).datebox({
            editable: false,
            onShowPanel: function() { // 显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
                span.trigger('click'); // 触发click事件弹出月份层
                if (!tds) setTimeout(function() { // 延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
                        tds = p.find('div.calendar-menu-month-inner td');
                        tds.click(function(e) {
                            e.stopPropagation(); // 禁止冒泡执行easyui给月份绑定的事件
                            var year = /\d{4}/.exec(span.html())[0] // 得到年份
                                ,
                                month = parseInt($(this).attr('abbr'), 10); // 月份，这里不需要+1
                            $('#' + objId).datebox('hidePanel')
                                // 隐藏日期对象
                                .datebox('setValue', year + '-' + month); // 设置日期的值
                        });
                    },
                    0);
                yearIpt.unbind(); // 解绑年份输入框中任何事件
            },
            parser: function(s) {
                if (!s) return new Date();
                var arr = s.split('-');
                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
            },
            formatter: function(d) {
                var a = parseInt(d.getMonth()) < parseInt('9') ? '0' + parseInt(d.getMonth() + 1) : d.getMonth() + 1;
                return d.getFullYear() + '-' + a;
            }
        });
        var p = $('#' + objId).datebox('panel'),
        // 日期选择对象
            tds = false,
        // 日期选择对象中月份
            yearIpt = p.find('input.calendar-menu-year'),
        // 年份输入框
            span = p.find('span.calendar-text'); // 显示月份层的触发控件
    }

    //常用提示
    win.$tips = {
        success: function (handle) {
            layer.msg('操作成功', {
                icon: 1,
                time: 1000 // 1秒关闭（如果不配置，默认是3秒）
            }, function () {
                if (handle) {
                    handle();
                }
            });

        },
        fail: function (handle) {
            layer.msg('操作失败', {
                icon: 5,
                time: 1000 // 1秒后自动关闭
            }, function () {
                if (handle) {
                    handle();
                }
            });
        },
        del: function (title, handle) {
            // 询问框
            layer.confirm(title, {
                title: '确认提示',
                shade: 0.3
            }, function () {
                if (handle) {
                    handle();
                }
            });
        }, info: function (info, handle) {
            if (!info) {
                info = "操作失败";
            }
            layer.msg(info, {
                icon: 5,
                time: 1000 // 1秒后自动关闭
            }, function () {
                if (handle) {
                    handle();
                }
            });
        }
    };
};

//jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
    dseDefine(function (require, exports, module) {
        return _commonPlugin(require('jquery'), window);
    });
} else {
    //依赖jquery
    _commonPlugin(jQuery, window);
}