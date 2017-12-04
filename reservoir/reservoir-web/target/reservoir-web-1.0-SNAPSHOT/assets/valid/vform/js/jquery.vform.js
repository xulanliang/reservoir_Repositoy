/*
 * 调用方法
 jQuery(function () {
 $('#vform1').vform();
 //或
 $('#vform2').vform({
 //... ...
 });
 });
 html范例
 data-vform //启用vform验证
 data-req="true"//是否必填,默认可以为data-err1
 data-def="必填项"//默认提示
 data-emp="账号不能为空"//为空时错误提示
 data-err1="请填写正确有效的邮箱"//正则校验错误提示
 data-err2="密码不一致"//与对应输入框不一致时错误提示
 data-rule="mail||date||url&&mail"//验证规则,可以直接写正则,也可以调用正则参数,&&左边是校验,调用的参数rule正则,右边是输入控制,调用的参数keyup正则
 <input id="password_auto" data-onceid="#password2" data-rule="" data-req="true" type="text"/>
 <input id="password2" data-onceid="#password_auto" data-rule="mail||date||url&&mail" data-err1="请填写正确有效的邮箱" type="text"/>
 *
 */
(function ($) {
    $.fn.extend({
        vform: function (options) {
            var defaults = {
                isTips: true, //是否显示提示框,默认显示
                errCss1: '.u-err', //error输入框样式
                errCss2: '.f-err-msg', //error文本样式
                //正则输入控制,不符合规则的输入自动清除
                keyup: {
                    "d": /[^\d]/g, //纯数字
                    "sfz": /[^\d|x|X]/g, //身份证
                    "bh": /[^\d|a-z|A-Z]/g, //数字字母
                    "dh": /[^\d-+]/g, //手机或座机
                    "mm": /[^\w.]/g, //数字,点,下划线,字母
                    "mail": /[^\d._@|a-z|A-Z]/g, //邮箱
                    "zh": /[^\u4e00-\u9fa5]/g, //中文
                    "zh_en": /[^\u4e00-\u9fa5|a-z|A-Z]/g,//中文或英文
                    "code": /[^\w-]/g //组织机构代码
                },
                //正则规则,不符合标准的文本输入自动错误提示
                rule: {
                    "un": /^[a-zA-z]+[\d|a-z|A-Z]{1,16}$/, //账号,字母开头的字符
                    "w": /^\w$/, //数字,字母,下划线
                    "w.": /^\w|.$/, //数字,字母,点,下划线
                    "w-": /^\w|-$/, //数字,字母,横线,下划线
                    "mm": /^\w{6,16}$/, //6~16位密码
                    "tn": /^[\u4e00-\u9fa5|a-zA-z]{2,15}$/, //真实姓名
                    "czdh": /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/, //电话传真
                    "mob": /^[1][3578][0-9]{9}$/, //手机
                    "mail": /^\w+@\w+(\.\w+)+(\,\w+@\w+(\.\w+)+)*$/, //邮箱
                    "date": /^\d{4}\-\d{1,2}-\d{1,2}$/, //日期2016-07-29
                    "url": /^[a-zA-z]+:\/\/[^\s]*$/, //http地址
                    "sf15": /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/, //15位身份证
                    "sf18": /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|x|X)$/, //18位身份证
                    "dh": /(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$///手机或座机
                },
                //提示文本
                msgs: {
                    "suc": '正确',
                    "def": "必填项",
                    "err1": '格式不对',
                    "err2": '密码不一致',
                    "emp": "不能为空"
                }
            };
            var o = $.extend(defaults, options);
            return this.each(function () {
                var _this = this;
                var errCss1 = (o.errCss1).replace(/./, ''),
                        errCss2 = (o.errCss2).replace(/./, '');
                var defFun = function (t, msg) {
                    msg = t.attr('data-dmsg') || msg;
                    t.removeClass(errCss1);
                    t.siblings('.u-msg').removeClass(errCss2).text(msg);
                    t.siblings('.u-msg,.u-arr1,.u-arr2').show();
                };
                var sucFun = function (t, msg) {
                    t.removeClass(errCss1);
                    t.siblings('.u-msg').removeClass(errCss2).text(msg);
                    t.siblings('.u-msg,.u-arr1,.u-arr2').hide();
                };
                var errFun = function (t, msg) {
                    t.addClass(errCss1);
                    t.siblings('.u-msg').addClass(errCss2).text(msg);
                    t.siblings('.u-msg,.u-arr1,.u-arr2').show();
                };
                function v(t) {
                    var _flag = false,
                            $v = t.val(),
                            req = t.attr('data-req') || false, //是否必填，默认false不能为空
                            rules = t.attr('data-rule') || '',
                            keyup,
                            rule,
                            search,
                            suc = t.attr('data-suc') || o.msgs["suc"],
                            err1 = t.attr('data-err1') || o.msgs["err1"],
                            err2 = t.attr('data-err2') || o.msgs["err2"],
                            emp = t.attr('data-emp') || o.msgs["emp"],
                            onceid = t.attr('data-onceid') || '';//对应一致的input id
                    rules = rules.split('&&');
                    if (rules.length == 2) {
                        keyup = o.keyup[rules[1]];
                        t.attr('onkeyup', 'value = value.replace(' + keyup + ',\'\')');//限制输入
                    }
                    if (rules[0].indexOf('||') != -1) {
                        rule = rules[0].split('||');
                        search;
                        $.each(rule, function (k, v) {
                            if (k == 0) {
                                rule = o.rule[v] || evil(v); //获取正则
                                search = $v.search(rule) != -1;
                            } else {
                                rule = o.rule[v] || evil(v); //获取正则
                                search = search || $v.search(rule) != -1;
                            }
                        });
                    } else {
                        rule = o.rule[rules[0]] || evil(rules[0]); //获取正则
                        search = $v.search(rule) != -1;
                    }
                    if (req == 'true' && $v == '') {
                        t.attr('data-flag', false);
                        errFun(t, emp);
                        return false;
                    } else if (req != 'true' && $v == '') {
                        t.attr('data-flag', true);
                        sucFun(t, suc);
                    }
                    if (search) {
                        t.attr('data-flag', true);
                        sucFun(t, suc);
                        if (onceid != '' && $(onceid).val() != '') {
                            if ($v != $(onceid).val()) {
                                t.attr('data-flag', false);
                                errFun(t, err2);
                                return false;
                            } else {
                                t.attr('data-flag', true);
                                sucFun($(onceid), suc);
                            }
                        }
                    } else {
                        if ($v != '') {
                            t.attr('data-flag', false);
                            errFun(t, err1);
                            return false;
                        }
                    }
                }
                $(_this).addClass('vform-box').find('[data-req="true"]').attr('data-flag', false);
                $(_this).on('focus', ':input[data-vform]', function () {
                    var $this = $(this),
                            $v = $this.val(),
                            req = $this.attr('data-req') || false, //是否必填，默认false不能为空
                            pos = $this.attr('data-pos') || 'right',
                            def = $this.attr('data-def') || $this.attr('data-err1') || o.msgs["def"];
                    if (o.isTips == true) {
                        if (!($this.parent('.m-vf').length > 0)) {
                            $this.wrap('<span class="m-vf ' + pos + '"></span>');
                            $this.after('<span class="u-msg"></span><span class="u-arr1"></span><span class="u-arr2"></span>');
                            $this.focus();
                        } else {
                            if ((req == 'true' || def != o.msgs["def"]) && $v == '') {
                                defFun($this, def);
                            }
                        }
                    }
                    return false;
                });
                $(_this).on('blur', ':input[data-vform]', function () {
                    var $this = $(this);
                    if (o.isTips == true) {
                        v($this);
                    }
                    return false;
                });
                $(_this).on('input propertychange', ':input[data-vform]', function () {
                    var $this = $(this),
                            $v = $this.val(),
                            mod = $this.attr('data-mod');
                    if (o.isTips == true) {
                        v($this);
                    }
                    if (mod) {
                        if ($(mod).is(':input')) {
                            $(mod).val($v);
                        } else {
                            $(mod).text($v);
                        }
                    }
                    return false;
                });
            });
        },
        validateVform: function () {
            var _flag = true;
            $(':input[data-vform]').each(function (i) {
                var $this = $(':input[data-vform]').eq(i);
                $this.focus().blur();
                if ($this.attr('data-flag') == 'false') {
                    _flag = false;
                    // 校验失败，此处调用项目的提示控件
					$this.focus();
                    return false;
                }
            });
            return _flag;
        }
    });
})(jQuery);