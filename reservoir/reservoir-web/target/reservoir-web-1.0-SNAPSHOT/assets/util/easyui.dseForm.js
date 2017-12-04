//easyui表单渲染完成执行
DSE.form.eFormOnComplete = function() {
    $('form').css('visibility', 'visible');
};

/**
 * 获取表单数据，返回 json 格式对象
 * @param  obj              form 选择器，默认为 body
 */
DSE.form.getAutoObject = function(obj) {
    var data = {};
    obj = obj || 'body';
    $(obj).find('*[id$=_auto],*[name$=_auto]').each(function() {
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
        if ($t_class && ($t_class.indexOf('combo-f') != '-1' || $t_class.indexOf('textbox-f') != '-1' || $t_class.indexOf('numberbox-f') != '-1' || $t_class.indexOf('validatebox-f') != '-1' || $t_class.indexOf('datebox-f') != '-1' || $t_class.indexOf('datetimebox-f') != '-1' || $t_class.indexOf('datetimespinner-f') != '-1' || $t_class.indexOf('numberspinner-f') != '-1')) {
            var c = $t_class.split('-f')[0].split(' '),
                v = 'getValue';
            c = c[c.length - 1];
            var _$o = '$("' + obj + '").find("#' + $key + '_auto").' + c;
            if (c.indexOf('combo') != -1) {
                try {
                    if (evil(_$o + '("options").multiple')) {
                        v = 'getValues';
                    }
                } catch (e) {

                }
            }
            var func = _$o + '("' + v + '")';
            try {
                data[$key] = evil(func);
            } catch (e) {

            }
        } else {
            //普通表单元素
            if ($t.is('span') || $t.is('div') || $t.is('a') || $t.is('p')) {
                data[$key] = $t.text();
            } else if ($t.is('img')) {
                data[$key] = $t.attr('src');
            } else if ($t.is(':input')) {
                if ($t.attr('type') == 'checkbox') {
                    data[$key] = 0;
                    var c = '$("' + obj + '").find([type="checkbox"][name="' + $key + '_auto"]',
                        $val;
                    if ($(c).length > 1) {
                        $val = [];
                        $(c).each(function(i) {
                            if ($(c).eq(i).is(':checked')) {
                                $val.push($(c).eq(i).val());
                            }
                        });
                    } else {
                        if ($t.is(':checked')) {
                            if ($val == '' || $val == null || $val == 'on') {
                                $val = 1;
                            }
                        } else { // 没有选中
                            $val = 0
                        }
                    }
                    data[$key] = $val;
                } else if ($t.attr('type') == 'radio') {
                    data[$key] = '';
                    var c = '$("' + obj + '").find([type="radio"][name="' + $key + '_auto"]:checked';
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
/**
 * 自动填充表单 编辑|详情
 * @param  data             json 格式数据
 * @param  operType         当前操作类型
 *             edit         编辑内容，
 *             detail       显示详情，直接移除表单元素
 *             detail2      显示详情，表单元素只隐藏不移除，方便与 edit 状态互相切换
 * @param  obj              form 选择器，默认为 body
 */
DSE.form.showFormContent = function(data, operType, obj) {
    obj = obj || 'body';
    var $t = $(obj).find('*[id$=_auto],*[name$=_auto]');
    $(obj).find(':input').removeAttr('disabled');
    //初始化表单元素
    $t.each(function(i) {
        var $t_class = $t.eq(i).attr('class'),
            $t_id = $t.eq(i).attr('id');
        $t_id = $t_id.substring(0, $t_id.length - 5);
        //判断是否easyui表单组件
        if ($t_class && ($t_class.indexOf('combo-f') != '-1' || $t_class.indexOf('textbox-f') != '-1' || $t_class.indexOf('numberbox-f') != '-1' || $t_class.indexOf('validatebox-f') != '-1' || $t_class.indexOf('datebox-f') != '-1' || $t_class.indexOf('datetimebox-f') != '-1' || $t_class.indexOf('datetimespinner-f') != '-1' || $t_class.indexOf('numberspinner-f') != '-1')) {
            var t_c = $t_class.split('-f')[0].split(' '),
                t_v = 'setValue';
            t_c = t_c[t_c.length - 1];
            try {
                evil('$("' + obj + '").find("#' + $t_id + '_auto").' + t_c + '("' + t_v + '","")');
            } catch (e) {

            }
            if (operType == 'detail' || operType == 'print' || operType == 'detail2') {
                $(obj).find('.' + $t_id + '_ori').show();
                $t.eq(i).next('span').hide();
            } else {
                $(obj).find('.' + $t_id + '_ori').hide();
                $t.eq(i).next('span').show();
            }
        } else {
            if ($t.eq(i).is(':input') && $t.eq(i).attr('type') != 'radio' && $t.eq(i).attr('type') != 'checkbox') {
                $t.eq(i).val('');
            } else {
                $t.eq(i).html('');
            }
            $(obj).find('.' + $t_id + '_ori').html('');
            if (operType == 'detail' || operType == 'print' || operType == 'detail2') {
                $(obj).find(':input').attr('disabled', 'disabled');
                if ($t.eq(i).attr('type') != 'hidden') {
                    $(obj).find('.' + $t_id + '_ori').show().siblings().hide();
                }
                if (operType != 'detail2') {
                    $(obj).find('.' + $t_id + '_ori').siblings().remove();
                }
            } else {
                $(obj).find(':input').removeAttr('disabled');
                if ($t.eq(i).attr('type') != 'hidden') {
                    $(obj).find('.' + $t_id + '_ori').hide().siblings().show();
                }
            }
        }
    });
    var showDetail = function(id, value) {
        if (operType == 'detail' || operType == 'print' || operType == 'detail2') {
            $(obj).find(id).html(value);
        }
    };
    //填充数据
    if (nullToSpace(data) != '') {
        $.each(data, function(n, value) {
            if (operType == 'clear') {
                value = '';
            }
            //          console.log('#' + n + '_auto: ' + typeof value+': '+value);
            var _id = '#' + n + '_auto', //表单需要提交的字段id
                _name = 'input[name="' + n + '_auto"]',
                _s_id = '.' + n + '_auto', //新增和编辑时需要默认显示的字段
                _ori_id = '.' + n + '_ori', //详情和打印时显示的字段
                $class = $(obj).find(_id).attr('class'),
                $type = $(obj).find(_id).attr('type');
            if ($(obj).find(_id).length > 0 || $(obj).find(_name).length > 0 || $(obj).find(_s_id).length > 0 || $(obj).find(_ori_id).length > 0) {
                if (typeof value == 'string') {
                    if (value.indexOf('\r') != '-1' || value.indexOf('\n') != '-1' || value.indexOf('<w:br/>') != '-1') {
                        if (operType == 'detail' || operType == 'print') {
                            //详情换行转换
                            value = value.replace(/(\r\n|\n|\r|<w:br\/>)/gm, '<br>');
                        } else {
                            if ($(obj).find(_id).is('textarea')) {
                                //后台返回的数据如果有换行符时easyui表单控件会出现bug，需要转化换行符再执行函数
                                value = value.replace(/(\r\n|\n|\r|<w:br\/>)/gm, '\r\n');
                            }
                        }
                    }
                }
                value = nullToSpace(value);
                //判断是否easyui表单元素
                if ($(obj).find(_id).length > 0 && $class && ($class.indexOf('combo-f') != '-1' || $class.indexOf('textbox-f') != '-1' || $class.indexOf('numberbox-f') != '-1' || $class.indexOf('validatebox-f') != '-1' || $class.indexOf('datebox-f') != '-1' || $class.indexOf('datetimebox-f') != '-1' || $class.indexOf('datetimespinner-f') != '-1' || $class.indexOf('numberspinner-f') != '-1')) {
                    var c = $class.split('-f')[0].split(' '),
                        v = 'setValue';
                    c = c[c.length - 1];
                    //                      console.log(n + ': ' + value);
                    var func = '';
                    if (c.indexOf('combo') != -1 && String(value).length > 1) {
                        try {
                            if (isArray(value)) {
                                v = 'setValues';
                            }
                        } catch (e) {

                        }
                    }
                    func = '$("' + obj + '").find("#' + n + '_auto" ).' + c + '("' + v + '","' + value + '")';
                    //                        console.log(func);
                    try {
                        evil(func);
                    } catch (e) {

                    }
                    if ($class.indexOf('combo-f') != '-1') {
                        var $text = $(obj).find(_id).combo('getText');
                        $(obj).find(_s_id).html($text);
                        showDetail(_ori_id, $text);
                    } else {
                        $(obj).find(_s_id).html(value);
                        showDetail(_ori_id, value);
                    }
                } else {
                    $(obj).find(_s_id).html(value);
                    //普通表单元素
                    if ($(obj).find(_name).length > 0) {
                        $(obj).find(_name).removeAttr('checked'); //初始清空样式
                        if ($(obj).find(_name).attr('type') == 'checkbox') {
                            if (typeof value != 'object') {
                                if (value == '1') {
                                    $(obj).find(_name).attr("checked", true).prop('checked', true);
                                }
                            } else {
                                var v = '';
                                $.each(value, function(a, k) {
                                    $(obj).find(_name + '[value="' + k + '"]').attr("checked", true).prop('checked', true);
                                    if (a == 0) {
                                        v += k;
                                    } else {
                                        v += ',' + k;
                                    }
                                });
                                $(obj).find(_s_id).html(v);
                                showDetail(_ori_id, v);
                            }
                        } else if ($(obj).find(_name).attr('type') == 'radio') {
                            if (value != '' || value == '0') {
                                $(obj).find(_name + '[value="' + value + '"]').attr("checked", true).prop('checked', true);
                                $(obj).find(_s_id).html(value);
                                showDetail(_ori_id, value);
                            }
                        }
                    } else {
                        if ($(obj).find(_id).is(':input')) {
                            $(obj).find(_id).val(value);
                        } else if ($(obj).find(_id).is('img') && value != '') {
                            $(obj).find(_id).attr('src', value).show().siblings().hide();
                        } else {
                            $(obj).find(_id).html(value);
                        }
                        showDetail(_ori_id, value);
                    }
                }
            }
        });
    }
};
/**
 * input 框输入校验
 * @param  obj          form 选择器
 */
DSE.form.inputLimit = function(obj) {
    var rules = {
        "d": /[^\d]/g, //纯数字
        "en": /[^a-z|A-Z]/g, //字母
        "zh": /[^\u4E00-\u9FA5]/g, //中文
        "bh": /[^a-z|A-Z|\d]/g, //字母或数字
        "w": /[^\w]/g //字母,下划线,横线,数字
    };
    $(obj).on('input propertychange', 'input[type="text"],textarea', function() {
        var $t = $(this),
            $mLen = $t.attr('maxLength') || '',
            $rule = $t.attr('data-rule') || '',
            _rule;
        if ($rule != '') {
            var $v = $t.val(),
                $vLen = String($v).getBytes();
            if ($rule.indexOf('d{') != -1) {
                var str = $rule.replace('d{', '').replace('}', '').split(',');
                $t.attr('maxLength', parseInt(str[0]) + parseInt(str[1]) + 1);
                $v = $v.replace(/[^\d|.]/g, '');
                if (!evil('/^\\d{1,' + str[0] + '}(\\.\\d{1,' + str[1] + '})?$/').test($v)) {
                    if (/\.{2,}/g.test($v) || $v.substring($v.length - 1) != '.') {
                        $v = $v.substring(0, $v.length - 1);
                    }
                }
            } else {
                _rule = rules[$rule] ? rules[$rule] : $rule;
                $v = $v.replace(evil(_rule), '');
            }
            $t.val($v);
        }
    });
    $(obj).on('change', 'input[type="text"],textarea', function() {
        var $t = $(this),
            $v = $t.val(),
            $vLen = String($v).getBytes(),
            $mLen = $t.attr('maxLength') || '1000',
            $valType = $t.attr('data-valType') || 1,
            $rule = $t.attr('data-rule2') || '',
            _rule = rules[$rule] ? rules[$rule] : $rule;
        if (String(_rule).indexOf('u4E00') != -1) {
            $mLen = $mLen * 2;
        }
        if ($rule != '') {
            $v = $v.replace(evil(_rule), '');
            $t.val($v);
        }
        if ($valType == 1 && $rule.indexOf('d{') == -1) {
            while ($vLen > $mLen) {
                $v = $v.substring(0, $v.length - 1);
                $vLen = String($v).getBytes();
            }
            $t.val($v);
        }
    });
};
//easyui 校验输入内容长度
$(document).on('focus', '.textbox-text', function() {
    var $t = $(this),
        $v = $t.val(),
        $p = $t.parent('span').prev('input'),
        $options = {};
    try {
        $options = $p.textbox('options')
    } catch (e) {

    }
    if (nullToSpace($options["validType"]) != '') {
        var $s = $options["validType"];
        if ($s.indexOf('maxLength') != '-1') {
            var maxLength = parseInt(String(String($s).split('maxLength[')[1]).split(']')[0]);
            $t.attr('maxLength', maxLength);
        }
    }
});
/**
 * dseLabel require 样式，自动添加 * 必填
 * dseLabel type2 样式 自动添加英文冒号 :
 */
$(".dseLabel").html(function() {
    var _this = $(this),
        _t = $.trim(String(_this.html())).replace(/:|：/g, ''),
        _a = '<span class="f-ib" style="width:14px;"></span>',
        _b = '<span class="f-ib f-tac" style="width:14px;">:</span>',
        _op = '';
    if (_this.hasClass('require')) {
        _a = '<span class="f-ib f-tac" style="color:red;width:14px;">*</span>';
    }
    if (_this.hasClass('type1')) {
        _op = _t + _b;
    } else if (_this.hasClass('type2')) {
        _op = _a + _t + _b;
    } else {
        _op = _t + _a;
    }
    return _op;
});

try {
    //easyui表单渲染成功后显示
    $.parser.onComplete(DSE.form.eFormOnComplete());
} catch (e) {}

/**
 * 此处是为了解决 年份下拉框 报403错误；
 * 将combobox 的请求方式改为GET请求
 *  @date 2017-9-25
 * @type {string}
 */
$.fn.combobox.defaults.method = "GET";
$.fn.combobox.defaults.mode = "remote";
