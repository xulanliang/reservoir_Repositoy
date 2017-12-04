
dseDefine('page', function(require, exports, module) {
	exports.initForm = function(laytpl){
		//测试数据
		var tplData = '<h3>{{ d.title }}</h3>'+
        '<p class="intro">{{ d.intro }}</p>'+
        '<ul>'+
        '{{# for(var i = 0, len = d.list.length; i < len; i++){ }}'+
            '<li>'+
                '<span>{{ d.list[i].name }}</span>'+
                '<span>所在城市：{{ d.list[i].city }}</span>'+
            '</li>'+
        '{{# } }}' +
        '</ul>';
        var data = {
            title: '前端圈',
            intro: '一群码js的骚年，幻想改变世界，却被世界改变。',
            list: [{name: '贤心', city: '杭州'},  {name: '谢亮', city: '北京'}, {name: '浅浅', city: '杭州'}, {name: 'Dem', city: '北京'}]
        };

        //方式一：异步渲染（推荐）
        laytpl(tplData).render(data, function(render){
            document.getElementById('view').innerHTML = render;
        });

        //方式二：同步渲染：
        var render = laytpl(tplData).render(data);
        document.getElementById('view2').innerHTML = render;
	}
	
});

/* ========================程序入口(main)======================== */
var module;// 模块对象
seajs.use([ 'page','layer_template'], function(m,laytpl) {
	m.initForm(laytpl);
});