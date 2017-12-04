var _easyuiDseFormPlugin = function ($, win) {
    $(function () {
        // 检测标签，自动补上：，如果标签添加了样式require,则自动添加红色星号
        $(".dseLabel").html(function () {
            var _this = $(this),
                    _t = $.trim(String(_this.text())).replace(/:|：/g, ''),
                    _a = '',
                    _b = '';
            if (_this.hasClass('require') || _this.find('.require').length > 0) {
                _a = '<span style="color:red">*</span> ';
            }
            if (_this.attr("appendColon") != 'false') {
                _b = ' : ';
            }
            return _a + _t + _b;
        });
        // 查询 表单框 添加回车
        $(".dseSearch").submit(function () {
            // 组装回车提交
            return false;
        }).keyup(function (data) {
            if (data.keyCode == 13) {
                var enter = $(this).attr("enter");
                if (typeof window[enter] == 'function') {
                    window[enter]();
                }
            }
        });
    });
    //替代eval的函数
    win.evil = function (fn) {
        var Fn = Function;  //一个变量指向Function，防止有些前端编译工具报错
        return new Fn('return ' + fn)();
    };
    //获取表单数据，返回data对象
    win._getAutoObject = function (obj) {
        var data = {};
        // 找到元素，进行循环
        obj.find('*[id$=_auto],*[name$=_auto]').each(function () {
            var $t = $(this),
                    $t_id = $t.attr('id'),
                    $t_name = $t.attr('name'),
                    $t_class = $t.attr('class'),
                    $key;
            if ($t.attr('type') != 'radio' && $t.attr('type') != 'checkbox') {
                $key = $t_id;
            } else {
                $key = $t_name;
            }
            $key = $key.substring(0, $key.length - 5);
            //判断是否easyui表单组件
            if ($t_class && $t_class.indexOf('-f') != '-1') {
                var c = $t_class.split('-f')[0].split(' '),
                        isVals = '$("#' + $key + '_auto").' + c + '("options").multiple',
                        v = 'getValue';
                c = c[c.length - 1];
                if (c.indexOf('combo') != -1 && evil(isVals)) {
                    v = 'getValues';
                }
                var func = '$("#' + $key + '_auto").' + c + '("' + v + '")';
                data[$key] = evil(func);
            } else {
                //普通表单元素
                if ($t.is('span') || $t.is('div') || $t.is('a') || $t.is('p')) {
                    data[$key] = $t.text();
                } else if ($t.is('img')) {
                    data[$key] = $t.attr('src');
                } else if ($t.is(':input')) {
                    if ($t.attr('type') == 'checkbox') {
                        data[$key] = 0;
                        var c = '*[type="checkbox"][name="' + $key + '_auto"]',
                                $val;
                        if ($(c).length > 1) {
                            $val = [];
                            $(c).each(function (i) {
                                if ($(c).eq(i).is(':checked')) {
                                    $val.push($(c).eq(i).val());
                                }
                            });
                        } else {
                            if ($t.is(':checked')) {
                                if ($val == '' || $val == null || $val == 'on') {
                                    $val = 1;
                                }
                            } else {// 没有选中
                                $val = 0
                            }
                        }
                        data[$key] = $val;
                    } else if ($t.attr('type') == 'radio') {
                        data[$key] = '';
                        var c = '*[type="radio"][name="' + $key + '_auto"]:checked';
                        if ($(c).length > 0) {
                            data[$key] = $(c).val();
                        }
                    } else {
                        data[$key] = $t.val();
                    }
                }
            }
        });
        //console.log(data);
        return data;
    };
    //自动填充表单 编辑|详情
    win._showFormContent = function (data, operType) {
        //console.log(data);
        if (operType == 'detail' || operType == 'print') {
            $('.showHr').css('border-bottom', '1px solid #010101');
        }
        $.each(data, function (n, value) {
            if (operType == 'clear') {
                value = '';
            }
            //console.log('#' + n + '_auto: ' + value);
            var _id = '#' + n + '_auto', //表单需要提交的字段id
                    _name = 'input[name="' + n + '_auto"]',
                    _s_id = '.' + n + '_auto', //新增和编辑时需要默认显示的字段
                    _ori_id = '.' + n + '_ori', //详情和打印时显示的字段
                    $class = $(_id).attr('class'),
                    $type = $(_id).attr('type');
            if ($(_id).length > 0 || $(_name).length > 0 || $(_s_id).length > 0 || $(_ori_id).length > 0) {
                if (typeof value == 'string') {
                    if (value.indexOf('\r') != '-1' || value.indexOf('\n') != '-1') {
                        //后台返回的数据如果有换行符会出现bug，需要转化换行符再执行函数
                        value = value.replace(/(\r\n|\n|\r)/gm, '<br>');
                    }
                }
                value = nullToSpace(value);
                //判断是否easyui表单元素
                if ($(_id).length > 0 && $class && $class.indexOf('-f') != '-1') {
                    var c = $class.split('-f')[0].split(' '),
                            v = 'setValue';
                    c = c[c.length - 1];
                    if (c.indexOf('combo') != -1 && String(value).length > 1 && typeof $.parseJSON(value) == 'object') {
                        v = 'setValues';
                        value = $.parseJSON(value);
                    }
                    var func = '$("#' + n + '_auto" ).' + c + '("' + v + '","' + value + '")';
                    evil(func);
                    if ($class.indexOf('combo-f') != '-1') {
                        var $text = $(_id).combo('getText');
                        $(_s_id).text($text);
                        if (operType == 'detail' || operType == 'print') {
                            $(_ori_id).text($text).show().siblings().remove();
                        }
                    } else {
                        $(_s_id).text(value);
                        if (operType == 'detail' || operType == 'print') {
                            $(_ori_id).text(value).show().siblings().remove();
                        }
                    }
                } else {
                    $(_s_id).text(value);
                    //普通表单元素
                    if ($(_name).length > 0) {
                        $(_name).removeAttr('checked');//初始清空样式
                        if ($(_name).attr('type') == 'checkbox') {
                            if (typeof value != 'object') {
                                if (value == '1') {
                                    $(_name).attr("checked", true).prop('checked', true);
                                }
                            } else {
                                var v = '';
                                $.each(value, function (a, k) {
                                    $(_name + '[value="' + k + '"]').attr("checked", true).prop('checked', true);
                                    if (a == 0) {
                                        v += k;
                                    } else {
                                        v += ',' + k;
                                    }
                                });
                                $(_s_id).text(v);
                                if (operType == 'detail' || operType == 'print') {
                                    $(_ori_id).text(v).show().siblings().remove();
                                }
                            }
                        } else if ($(_name).attr('type') == 'radio') {
                            if (value != '' || value == '0') {
                                $(_name + '[value="' + value + '"]').attr("checked", true).prop('checked', true);
                                $(_s_id).text(value);
                                if (operType == 'detail' || operType == 'print') {
                                    $(_ori_id).text(value).show().siblings().remove();
                                }
                            }
                        }
                        if (operType == 'detail' || operType == 'print') {
                            $(_name).attr('disabled', 'disabled');
                        }
                    } else {
                        if ($(_id).is(':input')) {
                            $(_id).val(value);
                        } else if ($(_id).is('img') && value != '') {
                            $(_id).attr('src', value).show().siblings().hide();
                        } else {
                            $(_id).text(value);
                        }
                        if (operType == 'detail' || operType == 'print') {
                            $(_ori_id).text(value).show().siblings().remove();
                            if ($(_id).is('select')) {
                                $(_id).attr('disabled', 'disabled');
                            }
                        }
                    }
                }
            }
        });
    };
    //填充表单日期
    win.dateToYmd = function (date) {
        if (nullToSpace(date) == '') {
            return '年 月 日';
        }
        date = new Date(date);
        var y = date.getFullYear(),
                m = date.getMonth() + 1,
                d = date.getDate();
        m = m < 10 ? '0' + m : m;
        d = d < 10 ? ('0' + d) : d;
        return y + '年' + m + '月' + d + '日';
    };
};


//jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
    dseDefine(function (require, exports, module) {
        return _easyuiDseFormPlugin(require('jquery'), window);
    });
} else {
    //依赖jquery
    _easyuiDseFormPlugin(jQuery, window);
}