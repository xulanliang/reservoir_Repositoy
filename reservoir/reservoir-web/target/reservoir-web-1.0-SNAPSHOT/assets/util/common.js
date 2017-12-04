/**
 * 字符串原型拓展函数
 * @return {[String]}
 */
(function() {
    /** 获取字符串占用的字节数 */
    String.prototype.getBytes = function() {
        var cArr = this.match(/[^x00-xff]/ig);
        return this.length + (cArr == null ? 0 : cArr.length);
    };
    /** 字符串前后去空格 */
    String.prototype.trim = function() {
        return this.replace(/(^\s*)|(\s*$)/g, "");
    };
    /** 截取最大字符串 */
    String.prototype.subMaxStr = function(len) {
        if (this.length > len) {
            return this.substr(0, len) + "..";
        } else {
            return this;
        }
    };
    /** 替换字符串 */
    String.prototype.replaceAll = function(sourceStr, targetStr) {
        if (!targetStr) {
            targetStr = '';
        }
        return this.replace(new RegExp(sourceStr, 'gm'), targetStr);
    };
    /* 字符串是否以 str 开头 */
    String.prototype.startWith = function(str) {
        if (str == null || str == "" || this.length == 0 || str.length > this.length) {
            return false;
        }
        if (this.substr(0, str.length) == str) {
            return true;
        }
        return false;
    };
    /* 字符串是否以 str 结束 */
    String.prototype.endWith = function(str) {
        if (str == null || str == "" || this.length == 0 || str.length > this.length) {
            return false;
        }
        if (this.substring(this.length - str.length) == str) {
            return true;
        }
        return false;
    };
    /**
     * 字符串是否为 url 地址
     * @returns {Boolean}
     */
    String.prototype.isURL = function() {
        var strRegex = '^((https|https2|http|http2|ftp|rtsp|mms)://)' + '(([0-9a-z_!~*\'().&=+$%-]+: )?[0-9a-z_!~*\'().&=+$%-]+@)?' // ftp的user@
            +
            '(([0-9]{1,3}.){3}[0-9]{1,3}' // IP形式的URL- 199.194.52.184
            +
            '|' // 允许IP和DOMAIN（域名）
            +
            '([0-9a-z_!~*\'()-]+.)*' // 域名- www.
            +
            '([0-9a-z][0-9a-z-]{0,61})?[0-9a-z].' // 二级域名
            +
            '[a-z]{2,6})' // first level domain- .com or .museum
            +
            '(:[0-9]{1,4})?' // 端口- :80
            +
            '((/?)|' // a slash isn't required if there is no file name
            +
            '(/[0-9a-z_!~*\'().;?:@&=+$,%#-]+)+/?)$';
        var re = new RegExp(strRegex);
        if (re.test(this)) {
            return (true);
        } else {
            return (false);
        }
    };
})();
/**
 * 数组原型拓展函数
 * @return {[Array]}
 */
(function() {
    /**
     * 数组,是否包含某个值,
     * 返回索引值或 -1，便于删除元素，例如：
        var index = Array.contains(arr);
        //包含则删除
        if(index != -1){
            Array.splice(index, 1);
        }
     */
    Array.prototype.contains = function(arr) {
        var i = this.length;
        while (i--) {
            if (this[i] === arr) {
                return i;
            }
        }
        return -1;
    };
    /** 获取子数组,array 里面应该保存着json数据，然后通过attr属性去匹配 val值，如果相等，则返回
     * 找出数组中包含 attr : val 的元素并返回一个新的数组
     **/
    Array.prototype.getSubArray = function(attr, val) {
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
})();
/**
 * window 自带的函数替代方法
 */
(function(window) {
    //获取当前域的 top 对象替代 top，防止脚本跨域错误
    DSE.window.top = (function() {
        var obj = window.self,
            t_obj = obj;
        try {
            if (window.top.location.host) {
                return window.top;
            }
        } catch (e) {
            while (true) {
                try {
                    if (obj.location.host) {
                        t_obj = obj;
                        obj = obj.window.parent;
                    }
                } catch (e) {
                    return t_obj;
                }
            }
        }
    })();
    //log 替代 console.log
    window.log = function() {
        try {
            // Modern browsers
            if (typeof console != 'undefined' && typeof console.log == 'function') {
                // Opera 11
                if (window.opera) {
                    var i = 0;
                    while (i < arguments.length) {
                        console.log('Item ' + (i + 1) + ': ' + arguments[i]);
                        i++;
                    }
                }
                // All other modern browsers
                else if ((Array.prototype.slice.call(arguments)).length == 1 && typeof Array.prototype.slice.call(arguments)[0] == 'string') {
                    console.log((Array.prototype.slice.call(arguments)).toString());
                } else {
                    console.log.apply(console, Array.prototype.slice.call(arguments));
                }
            }
            // IE8
            else if ((!Function.prototype.bind || treatAsIE8) && typeof console != 'undefined' && typeof console.log == 'object') {
                Function.prototype.call.call(console.log, console, slice.call(arguments));
            }
            // IE7 and lower, and other old browsers
        } catch (ignore) {}
    };
    //替代 eval 的函数
    window.evil = function(fn) {
        var Fn = Function; //一个变量指向Function，防止有些前端编译工具报错
        return new Fn('return ' + fn)();
    };
})(window);
/**
 * 对象类型判断
 */
(function(window) {
    //是否为 window 对象
    window.isWindow = function(obj) {
        return obj != null && obj.window == window;
    };
    //判断对象类型
    window.instanceType = function(obj, type) {
        return Object.prototype.toString.call(obj) == "[object " + type + "]";
    };
    //是否为 json 格式对象
    window.isObject = function(obj) {
        return instanceType(obj, 'Object');
    };
    //是否为函数
    window.isFunction = function(obj) {
        return instanceType(obj, 'Function');
    };
    //是否为数组
    window.isArray = function(obj) {
        return instanceType(obj, 'Array');
    };
    //是否为字符串
    window.isString = function(obj) {
        return instanceType(obj, 'String');
    };
    //是否为 bool 对象
    window.isBoolean = function(obj) {
        return instanceType(obj, 'Boolean');
    };
    //是否为 number
    window.isNumber = function(obj) {
        return instanceType(obj, 'Number');
    };
    //是否为 date 对象
    window.isDate = function(obj) {
        return instanceType(obj, 'Date');
    };
    //是否为 RegExp 正则表达式
    window.isRegExp = function(obj) {
        return instanceType(obj, 'RegExp');
    };
    //是否存在指定变量
    window.isExitsVariable = function(obj) {
        try {
            if (typeof(obj) != "undefined") {
                return true;
            }
        } catch (e) {

        }
        return false;
    };
    //是否存在指定函数
    window.isExitsFunction = function(funcName) {
        try {
            if (typeof(eval(funcName)) == "function") {
                return true;
            }
        } catch (e) {

        }
        return false;
    };
})(window);
/**
 * HTML 标签转义和反转义
 */
(function() {
    //转义 HTML
    DSE.html.encode = function(str) {
        var s = "";
        if (str.length == 0)
            return "";
        s = str.replace(/</g, "&lt;");
        s = s.replace(/>/g, "&gt;");
        s = s.replace(/ /g, "&nbsp;");
        s = s.replace(/\'/g, "&#39;");
        s = s.replace(/\"/g, "&quot;");
        s = s.replace(/\n/g, "<br>");
        return s;
    };
    //反转义 HTML
    DSE.html.decode = function(str) {
        var s = "";
        if (str.length == 0)
            return "";
        s = str.replace(/&lt;/g, "<");
        s = s.replace(/&gt;/g, ">");
        s = s.replace(/&nbsp;/g, " ");
        s = s.replace(/&#39;/g, "\'");
        s = s.replace(/&quot;/g, "\"");
        s = s.replace(/<br>/g, "\n");
        return s;
    };
})();
/**
 * 值判断和内容替换
 */
(function(window) {
    //字符串拼接的时候 json 格式数据需要先转化成字符串，并将双引号替换为单引号才能进行传参
    window.objToParam = function(obj) {
        return JSON.stringify(obj).replace(/\"/g, '\'');
    };
    //值存在则返回自身，不存在返回空字符串
    window.nullToSpace = function(v) {
        return v != '0' && v != 'false' && !v ? '' : v;
    };
    //替换空值
    window.nullToReplace = function(v, reg) {
        reg = reg || '--';
        return v != '0' && v != 'false' && !v ? reg : v;
    };
    //判断值是否为空
    window.isEmpty = function(val) {
        return val == "" || typeof(val) == "undefined" || val == null ? true : false;
    };
    //是否是一个空的对象
    window.isEmptyObject = function(obj) {
        var name;
        for (name in obj) {
            return false;
        }
        return true;
    };
})(window);
/**
 * 鼠标键盘相关函数
 */
(function(window) {
    /**
     * 鼠标右击事件,依赖 jquery
     * @param  id           选择器
     * @param  callback     回调函数
     */
    window.rclick = function(id, callback) {
        $(document).on('contextmenu', id, function(e) {
            e.preventDefault();
        });
        $(document).on('mousedown', id, function(e) {
            var t = $(this),
                c = {};
            c.x = e.pageX + 1;
            c.y = e.pageY + 1;
            if (e.which == 3 && typeof callback == 'function') {
                //执行回调函数
                callback(t, c);
            }
        });
    };
    //禁止浏览器默认事件
    window.stopDefault = function() {
        var e = event || window.event;
        //如果提供了事件对象，则这是一个非IE浏览器
        if (e && e.preventDefault) {
            //阻止默认浏览器动作(W3C)
            e.preventDefault();
        } else {
            //IE中阻止函数器默认动作的方式
            window.event.returnValue = false;
        }
        return false;
    };
    //取消禁止浏览器默认事件
    window.stopBubble = function() {
        var e = event || window.event;
        //如果提供了事件对象，则这是一个非IE浏览器
        if (e && e.stopPropagation) {
            //因此它支持W3C的stopPropagation()方法
            e.stopPropagation();
        } else {
            //否则，我们需要使用IE的方式来取消事件冒泡
            window.event.cancelBubble = true;
        }
        return false;
    };
    /**
     * 回车触发函数或事件
     * @param  target       选择器
     * @param  mode         被触发的事件类型，默认 click
     * @param  callback     回调函数
     */
    window.enter = function(target, mode, callback) {
        target = target || '#submit';
        mode = mode || 'click';
        var e = event || window.event;
        if (e.keyCode == 13) {
            if (typeof window[target] === 'function') {
                window[target]();
            } else {
                $(target).trigger(mode);
            }
            if (typeof callback == 'function') {
                callback();
            }
        }
    };
})(window);
/**
 * 表单相关
 */
(function(window) {
    /**
     * 字符串超出显示title
     * @param  obj          选择器
     * @param  len          限制的字节长度
     * @param  omit         末尾是否自动加上 ... , 默认为是，传 true 则为否
     */
    DSE.form.doShowTip = function(obj, len, omit) {
        var $tips = function($t, $text) {
            len ? $t.addClass('f-wwb') : $t.addClass('f-toe');
            $t.attr('title', $text).tooltip({
                position: 'right',
                trackMouse: true,
                onShow: function() {
                    $t.tooltip('tip').css({
                        borderColor: 'orange',
                        boxShadow: '1px 1px 3px #999'
                    });
                }
            });
        };
        $(obj).show(function() {
            var $t = $(this);
            var $text = String($t.text());
            var $tipsFun = function(len) {
                var $slen = len * 2,
                    $olen = $text.getBytes();
                if ($slen < $olen) {
                    var a = 0,
                        str_cut = new String();
                    for (var i = 0; i < $slen; i++) {
                        var c = $text.charAt(i);
                        a++;
                        if (escape(c).length > 4) {
                            a++; //中文字符的长度经编码之后大于4
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

    /**
     * datagrid 表格加载成功后执行，无数据时自动提示没有数据，文字超出自动显示 tips
     * @param  datagrid         表格对象
     * @param  rScroll          是否启用 nicescroll 优化滚动条
     */
    DSE.form.datagridLoadSuccess = function(datagrid, rScroll) {
        var info = datagrid.data().datagrid,
            data = info.data,
            colLen = info.options.columns[0].length,
            view1 = info.dc.view1,
            view2 = info.dc.view2,
            body2 = info.dc.body2;

        if (data.total == 0 || nullToSpace(data) == '' || data.length == 0) {
            if (!view1.is(':hidden')) {
                view1.hide();
                //修复 datagrid 动态样式 bug
                view2.css({ width: '100%', 'left': 0 }).children().css('width', '100%');
            }
            body2.css('height', '40px').find('table tbody').html('<tr><td width="' + body2.width() + '" style="height: 25px; padding: 0; text-align: center;" colspan="' + colLen + '"><div class="f-no-data">没有数据</div></td></tr>');
        } else {
            if (!view1.is(':hidden')) {
                view2.css({ 'left': '40px' });
            }
            DSE.form.doShowTip('.datagrid-cell');
        }
        //rScroll 来判断是否执行 nicescroll 插件
        if (rScroll && window.doNiceScroll) {
            doNiceScroll(body2);
        }
    };
    /**
     * 返回当前选中的 ids，用于删除
     * @param  _MyDataGrid          表格对象
     * @param  _keyId               主键名
     */
    DSE.form.getSelectId = function(_MyDataGrid, _keyId) {
        var _s = _MyDataGrid.datagrid('getSelections'),
            _ids = '';
        for (var i in _s) {
            var $id = _s[i][_keyId]; //主键ID
            if ($id) {
                _ids == '' ? _ids += $id : _ids += ',' + $id;
            }
        }
        return _ids;
    };
    /**
     * 头部固定table，横向一起滚动js
     * @param  tb_box  [选择器] 表格 box
     * @param  tb_hd   [选择器] 表头 head
     * @param  tb_cont [选择器] 内容 cont
     */
    DSE.form.tabFitScroll = function(tb_box, tb_hd, tb_cont) {
        $(tb_box + ' ' + tb_cont).scroll(function() {
            var $t = $(this);
            $(tb_box + ' ' + tb_hd).css('left', -$t.scrollLeft());
        });
    };
})(window);
/**
 * 获取 ajax 数据,默认同步
 * @param  param    参数与jquery $.ajax 参数相同
 */
function $ajax(param) {
    var $data = [];
    param = param || {};
    if (!param.url) {
        return false;
    }
    $.ajax({
        type: param.type || 'get',
        url: param.url,
        async: param.async || false,
        data: param.data || {},
        dataType: param.dataType || 'json',
        contentType: param.contentType || 'application/x-www-form-urlencoded',
        success: param.async ? param.success : function(data) {
            $data = data;
        },
        error: param.error || function() {
            log('请求出错了！');
        }
    });
    if (!param.async) {
        return $data;
    }
}


function getDataInfo(url, param, type, contentType) {
    var $data = [];
    $.ajax({
        type: type || 'get',
        url: url,
        async: false,
        data: param || {},
        dataType: 'json',
        contentType: contentType || 'application/x-www-form-urlencoded',
        success: function (data) {
            $data = data;
        }
    });
    return $data;
}

/**
 * layer 弹窗相关
 */
(function(window) {
    /**
     * 打开 layer窗口
     * @param  param    参数与 layer.open 使用参数相同
     */
    window.layerOpen = function(o) {
        DSE.window.parent = this;
        DSE.window.top.layer.open({
            type: o.type || 2, // iframe层
            title: o.title || '提示',
            content: o.content || '',
            area: o.area || ['100%', '100%'],
            offset: o.offset || 'auto',
            closeBtn: nullToSpace(o.closeBtn) != '' ? o.closeBtn : 1,
            shade: o.shade || 0.03,
            shadeClose: o.shadeClose || false,
            time: o.time || 0,
            shift: o.shift || 0,
            maxmin: o.maxmin || false,
            moveOut: nullToSpace(o.moveOut) != '' ? o.moveOut : true,
            scrollbar: o.scrollbar || false,
            move: nullToSpace(o.move) != '' ? o.move : '.layui-layer-title',
            moveType: nullToSpace(o.moveType) != '' ? o.moveType : 1,
            success: function(layero, index) {
                if (typeof o.success == 'function') {
                    o.success(layero, index);
                }
            },
            cancel: function(index) {
                if (typeof o.cancel == 'function') {
                    o.cancel(index);
                }
            },
            end: function() {
                if (typeof o.end == 'function') {
                    o.end();
                }
            }
        });
    };
    /** 关闭layer窗口 **/
    window.closeWin = function(index) {
        /*
         * window.name 不存在的情况下，closeWin() 执行失效
         * 通过查找循环遍历 id 选择器来返回当前索引值，然后执行关闭操作
         */
        var i = (function() {
            if (window.parent) {
                var _i = parent.layer.index;
                try {
                    while (true) {
                        if ($(parent.document).find('#layui-layer-iframe' + _i)[0]) {
                            return _i;
                        } else {
                            if (_i > 1) {
                                _i--;
                            } else {
                                return _i;
                            }
                        }
                    }
                } catch (e) {
                    return _i;
                }
            }
        })();
        index ? layer.close(index) : (window.name ? parent.layer.close(parent.layer.getFrameIndex(window.name)) : parent.layer.close(i));
    };
    /**
     * 封装 layer.msg 函数
     * @param  type         提示颜色类型，1 ~ 7
     */
    function $tips_msg(type) {
        return function(msg, handle, title) {
            layer.msg(msg, {
                icon: type,
                title: title || '提示',
                offset: '30%',
                time: 1500 // 1.5秒后自动关闭
            }, function() {
                if (typeof handle == 'function') {
                    handle();
                }
            });
        }
    }
    /**
     * 常用提示
     * @type {Object}
     */
    window.$tips = {
        //确认提示
        confirm: function(msg, handle, title) {
            // 询问框
            layer.confirm(msg, {
                title: title || '确认提示',
                shade: 0.3,
                offset: '30%'
            }, function(index) {
                if (typeof handle == 'function') {
                    handle(index);
                }
            });
        },
        //操作成功
        suc: $tips_msg(1),
        //操作失败
        err: $tips_msg(2),
        //普通提示
        msg: $tips_msg(7)
    };
})(window);

//jquery 插件
(function($, window) {
    /* ajax 全局设置 */
    $.ajaxSetup({
        type: 'POST',
        cache: false,
        complete: function(data, status) {
            // 不管什么情况下都执行这个方法,如果用 error: 方法的话 easyui 好像不能触发
            var m = null;
            switch (data.status) {
                case 404:
                    m = '指定URL不存在';
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
                    DSE.window.top.location.reload();
                } else {
                    layer.msg(m + ', 请联系管理员.<br/> 错误代码：' + data.status);
                }
            }
        }
    });
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
    /**
     * 在某个地址栏中查找参数
     * @param  name     参数名
     * @param  url      指定地址，默认当前页面 url
     */
    $.getParam = (function(name, url) {
        if (name) {
            if (!url) {
                url = decodeURI(window.location.href);
            }
            return $.trim(getURLparam(name, url));
        } else {
            // 有些 地址栏的参数就是 一个网址如
            // http://localhost:8080/boke/aa.sl?url=http://localhost:8080/boke/bb.sl?a=3&b=2&c=1,
            // 如果通过getUrlParam('url') 只能获得http://localhost:8080/boke/bb.sl?a=3
            var param = window.location.search;
            if (param.indexOf("?", 0) == 0) {

                param = param.substring(1, param.length);
            }
            return $.trim(param);
        }
    });
    /**
     * 在当前浏览器最顶层地址栏中查找参数
     * @param  name     参数名
     * @param  url      指定地址，默认当前页面 url
     */
    $.getTopParam = (function(name, url) {
        if (!url) {
            url = decodeURI(DSE.window.top.location.href);
        }
        return getURLparam(name, url);
    });
    //获取IP加端口号
    $.getIpPort = (function() {
        var local = window.location;
        var ipPort = local.protocol + "//" + local.host;
        return ipPort;
    });
    //对象切换显示隐藏效果
    $.fn.visible = (function() {
        var t = $(this);
        if (t.is(':hidden')) {
            // 可见
            t.css('visibility', 'visible');
        } else {
            // 不可见
            t.css('visibility', 'hidden');
        }
    });
    //随机获取主键值,默认 16 位
    $.getId = (function(num) {
        num = num || 16;
        var str = "";
        // 格式化时间类型
        for (var i = 0; i < num; i++) { // 循环产生随机数字串
            str += Math.floor(Math.random() * 10);
        }
        return str;
    });
    //获取文件上传主键,日期至毫秒,用于排序，默认 16 位
    $.getNewId = (function() {
        var str,
            date = new Date(),
            y = date.getFullYear(),
            m = date.getMonth() + 1,
            d = date.getDate(),
            h = date.getHours(),
            min = date.getMinutes(),
            s = date.getSeconds(),
            ms = date.getMilliseconds();
        m = m < 10 ? '0' + m : m;
        d = d < 10 ? '0' + d : d;
        h = h < 10 ? '0' + h : h;
        min = min < 10 ? '0' + min : min;
        s = s < 10 ? '0' + s : s;
        if (ms < 10) {
            ms = '00' + ms;
        } else if (ms >= 10 && ms < 100) {
            ms = '0' + ms;
        }
        ms = String(ms).substring(0, 2);
        str = '' + y + m + d + h + min + s + ms;
        return str;
    });
    //判断 jquery 对象是否存在
    $.fn.exist = (function() {
        return $(this).length >= 1;
    });

})(jQuery, window);


/********************===========初始化全局变量===========********************/
window.rowId = $.getParam("rowId") || ''; //主键id
window.operType = $.getParam("operType") || ''; //操作类型
window.userName = $.getParam("userName") || 'admin'; //用户名
/********************===========end 初始化全局变量===========********************/

/********************===========文件上传参数===========********************/
window.newId = $.getParam("newId") || $.getNewId(); //主键id
window.ids = $.getParam("ids") || ''; //上传返回的ids
window.btype = $.getParam("btype") || '1'; //类型
window.isSingle = $.getParam("isSingle") || ''; //控制单个文件上传
/********************===========end 文件上传参数===========********************/

/********************===========行政区划相关===========********************/
//获取用户信息,行政区划code,行政区划列表
if (!DSE.window.top.userInfo) {
    DSE.window.top.userInfo = getDataInfo(DSE.serverPath  + '/sysCommonCtrl/initUserVo.do?userName=' + userName)["data"];
    if (!isEmpty(DSE.window.top.userInfo)) {
        try {
            if(!isEmpty(DSE.window.top.userInfo["divisionCodes"])){
                DSE.window.top.divisionCodes = String(DSE.window.top.userInfo["divisionCodes"][0]).split(',')[0];
            }else{
                DSE.window.top.divisionCodes = "";
            }
            DSE.window.top.divisionInfo = getDataInfo(DSE.serverPath  + '/sysCommonCtrl/divisionInfo.do?code=' + DSE.window.top.divisionCodes)["data"];
        } catch (e) {
            console.log(e);
            DSE.window.top.divisionCodes = "";
            DSE.window.top.divisionInfo = [];
        }
    }
}
window.userInfo = DSE.window.top.userInfo;
window.divisionCodes = DSE.window.top.divisionCodes;
window.divisionInfo = DSE.window.top.divisionInfo;

//win.divisionCodes = [];
//win.divisionInfo = "";


//自定义loadFilter的实现
var $treeData = ["combotree", "tree"];
try {
    //日期控件添加清空按钮,调整按钮位置
    var datetimeboxBtns = $.extend([], $.fn.datetimebox.defaults.buttons),
        dateboxBtns = $.extend([], $.fn.datebox.defaults.buttons),
        clearBtn = {
            text: '清空',
            handler: function (target) {
                $(target).datebox("setValue", "");
                $(target).datebox("hidePanel");
            }
        },
        newButs1 = [clearBtn, datetimeboxBtns[0], datetimeboxBtns[1]],
        newButs2 = [clearBtn, dateboxBtns[0]];
    $.extend($.fn.datetimebox.defaults, {
        buttons: newButs1
    });
    $.extend($.fn.datebox.defaults, {
        buttons: newButs2
    });
    $.each($treeData, function (i) {
        $.fn[$treeData[i]].defaults.loadFilter = function (data, parent) {
            var opt = $(this).data().tree.options;
            var idFiled,
                textFiled,
                parentField;
            if (opt.parentField) {
                idFiled = opt.idFiled || 'CODE';
                textFiled = opt.textFiled || 'NAME';
                parentField = opt.parentField;
                var treeData = [],
                    tmpMap = [];
                $.each(data, function (i) {
                    tmpMap[data[i][idFiled]] = data[i];
                });
                $.each(data, function (i) {
                    if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
                        if (!tmpMap[data[i][parentField]]['children']) {
                            tmpMap[data[i][parentField]]['children'] = [];
                        }
                        data[i]['id'] = data[i][idFiled];
                        data[i]['text'] = data[i][textFiled];
                        tmpMap[data[i][parentField]]['children'].push(data[i]);
                    } else {
                        data[i]['id'] = data[i][idFiled];
                        data[i]['text'] = data[i][textFiled];
                        treeData.push(data[i]);
                    }
                });
                if(treeData[0] && treeData[0]["children"]){
                    $.each(treeData[0]["children"], function (i) {
                        if (treeData[0]["children"][i]["children"] && treeData[0]["children"][i]["children"].length > 0) {
                            treeData[0]["children"][i]["state"] = "closed";
                        }
                    });
                }
                return treeData;
            }
            return data;
        };
    });
} catch (e) {

}

function treeSetDefVal(opt) {
    $.each(divisionInfo, function (i) {
        if (divisionInfo[i]["CODE"] == divisionCodes) {
            if (!(opt.is('ul') && opt.hasClass('tree'))) {
                var $options = opt.combotree('options');
                if (!$options.multiple) {
                    opt.combotree('setValue', divisionCodes);
                    opt.combotree('setText', divisionInfo[i]["NAME"]);
                }
            } else {
                var node = opt.tree('find', divisionCodes);
                opt.tree('select', node.target);
            }
        }
    });
}

function treeOnSelect(opt, rec) {
    if (!(opt.is('ul') && opt.hasClass('tree'))) {
        var $options = opt.combotree('options');
        if (!$options.multiple) {
            opt.combotree('setValue', rec.CODE);
        }
    }
}
/********************===========end 行政区划相关===========********************/
//获取数组中的最大值和最小值的方法
function getMaximin(arr,maximin)
{
    if(maximin=="max") {
        return Math.max.apply(Math,arr);
    }
    else if(maximin=="min") {
        return Math.min.apply(Math, arr);
    }
}
/***
 * 获取对象的属性，返回字符串
 * @param obj
 * @returns {string}
 */
function displayProp(bean){
    var str="";
    for(var pro in bean){
        str+=pro+": "+bean[pro]+", ";
    }
    return str;
}

vDateToSelect = function (sta_date, end_date, type) {
    var $sta = $(sta_date).datebox('getValue'),
        $end = $(end_date).datebox('getValue');

    if ($end != '') {
        var $sta2 = parseInt($sta.replace(/-/g, '')),
            $end2 = parseInt($end.replace(/-/g, ''));
        if ($sta2 > $end2) {
            if (type == 1) {
                $(sta_date).datebox('setValue', $end);
            } else {
                $(end_date).datebox('setValue', $sta);
            }
        }
    }
};

function GetRequestParam(url) {
    url = url.split("?")[1] || ""; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url) {
        var str = url.substr(0);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
            theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}