//执行配置
require.config(DSE.requireConfig);
define('demo', function (require, exports, module) {

    //调用模块
    var _jquery = require('jquery');
    //引入 vue + element
    var Vue = require('vue'),
            vue_component = require('vue_component'),
            ELEMENT = require('ELEMENT');
    Vue.use(ELEMENT);

    //渲染实例
    var app = new Vue({
        data: function () {
            return {
                num1: 0,
                num2: 0,
                num3: 0,
                speed: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100],
                active: 1,
                pickerOptions2: vue_component.pickerOptions2,
                dateVal: ''
            };
        },
        methods: {
            startHacking: function () {
                var t = this;
                if (t.num1 === 0) {
                    var sp1 = setInterval(function () {
                        t.num1++;
                        if (t.num1 == 100) {
                            clearInterval(sp1);
                            setTimeout(function () {
                                t.num1 = 0;
                            }, 2000);
                        }
                    }, t.speed[Math.floor(Math.random() * t.speed.length)]);
                }
                if (t.num2 === 0) {
                    var sp2 = setInterval(function () {
                        t.num2++;
                        if (t.num2 == 100) {
                            clearInterval(sp2);
                            setTimeout(function () {
                                t.num2 = 0;
                            }, 2000);
                        }
                    }, t.speed[Math.floor(Math.random() * t.speed.length)]);
                }
                if (t.num3 === 0) {
                    var sp3 = setInterval(function () {
                        t.num3++;
                        if (t.num3 == 100) {
                            clearInterval(sp3);
                            setTimeout(function () {
                                t.num3 = 0;
                            }, 2000);
                        }
                    }, t.speed[Math.floor(Math.random() * t.speed.length)]);
                }
            },
            next: function () {
                if (this.active++ > 2)
                    this.active = 0;
            },
            open: function () {
                this.$message('这是一条消息提示');
            },
            open2: function () {
                this.$message({
                    message: '恭喜你，这是一条成功消息',
                    type: 'success'
                });
            },
            open3: function () {
                this.$message({
                    message: '警告哦，这是一条警告消息',
                    type: 'warning'
                });
            },
            open4: function () {
                this.$message.error('错了哦，这是一条错误消息');
            },
            open5: function () {
                this.$notify({
                    title: '成功',
                    message: '这是一条成功的提示消息',
                    type: 'success'
                });
            },
            open6: function () {
                this.$notify({
                    title: '警告',
                    message: '这是一条警告的提示消息',
                    type: 'warning'
                });
            },
            open7: function () {
                this.$notify.info({
                    title: '消息',
                    message: '这是一条消息的提示消息'
                });
            },
            open8: function () {
                this.$notify.error({
                    title: '错误',
                    message: '这是一条错误的提示消息'
                });
            }
        }
    }).$mount('#app');
});
