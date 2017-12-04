define(function(require) {
    var foo = {};
    foo.pickerOptions0 = {
        disabledDate: function(time) {
            return time.getTime() < Date.now() - 8.64e7;
        }
    };
    foo.pickerOptions1 = {
        shortcuts: [{
            text: '今天',
            onClick: function(picker) {
                picker.$emit('pick', new Date());
            }
        }, {
            text: '昨天',
            onClick: function(picker) {
                var date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24);
                picker.$emit('pick', date);
            }
        }, {
            text: '一周前',
            onClick: function(picker) {
                var date = new Date();
                date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                picker.$emit('pick', date);
            }
        }]
    };
    foo.pickerOptions2 = {
        shortcuts: [{
            text: '最近一周',
            onClick: function(picker) {
                var end = new Date();
                var start = new Date();
                start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                picker.$emit('pick', [start, end]);
            }
        }, {
            text: '最近一个月',
            onClick: function(picker) {
                var end = new Date();
                var start = new Date();
                start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                picker.$emit('pick', [start, end]);
            }
        }, {
            text: '最近三个月',
            onClick: function(picker) {
                var end = new Date();
                var start = new Date();
                start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                picker.$emit('pick', [start, end]);
            }
        }]
    };
    foo.handleCheckAllChange = function(event) {
        this.checkedCities = event.target.checked ? cityOptions : [];
        this.isIndeterminate = false;
    };
    foo.handleCheckedCitiesChange = function(value) {
        var checkedCount = value.length;
        this.checkAll = checkedCount === this.cities.length;
        this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
    };
    return foo;
});
