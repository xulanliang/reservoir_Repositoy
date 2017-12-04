/**
 * Created by Administrator on 2016/9/26.
 */
//
define([], function () {
    //
    var module = {
        //
        charts: [
            {
                geoCoord: [116.4551, 40.2539],
                animation:false,
                title: {
                    text: '仪表盘',
                    subtext: '测试数据',
                    x: "center"
                },
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}%"
                },
                series: [
                    {
                        name: '业务指标',
                        type: 'gauge',
                        detail: {formatter: '{value}%'},
                        data: [{value: 50, name: '完成率'}]
                    }
                ]
            },
            {
                geoCoord: [121.4648, 31.2891],

                title: {
                    show: true,
                    text: '仪表盘',
                    subtext: '测试数据',
                    x: "center"
                },

                animation:false,
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}%"
                },
                series: [
                    {
                        name: '业务指标',
                        type: 'gauge',
                        detail: {formatter: '{value}%'},
                        data: [{value: 50, name: '完成率'}]
                    }
                ]
            },
            {
                geoCoord: [113.5107, 23.2196],

                animation:false,
                title: {
                    show: true,
                    text: '仪表盘',
                    subtext: '测试数据',
                    x: "center"
                },
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}%"
                },
                series: [
                    {
                        name: '业务指标',
                        type: 'gauge',
                        detail: {formatter: '{value}%'},
                        data: [{value: 50, name: '完成率'}]
                    }
                ]
            },
            {
                geoCoord: [118.8062, 31.9208],
                animation:false,
                title: {
                    text: '仪表盘',
                    subtext: '测试数据',
                    x: "center"
                },
                tooltip: {
                    formatter: "{a} <br/>{b} : {c}%"
                },
                series: [
                    {
                        name: '业务指标',
                        type: 'gauge',
                        detail: {formatter: '{value}%'},
                        data: [{value: 50, name: '完成率'}]
                    }
                ]
            }

        ]


    };
    //
    return module;

});
