/**
 * Created by Administrator on 2016/9/23.
 */
//
define([], function () {
    //
    var module = {
        //
        charts: [
            //

            {
                geoCoord: [116.4551, 40.2539],
                title: {
                    show: true,
                    text: '北京市行业产值百分比',
                    subtext: '测试数据',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            {value: 335, name: '直接访问'},
                            {value: 310, name: '邮件营销'},
                            {value: 234, name: '联盟广告'},
                            {value: 135, name: '视频广告'},
                            {value: 1548, name: '搜索引擎'}
                        ]
                    }
                ]
            },

            {
                geoCoord: [121.4648, 31.2891],

                title: {
                    show: true,
                    text: '上海市行业产值百分比',
                    subtext: '测试数据',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    show: false,
                    orient: 'vertical',
                    x: 'left',
                    data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
                },
                toolbox: {
                    show: false,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            {value: 335, name: '直接访问'},
                            {value: 310, name: '邮件营销'},
                            {value: 234, name: '联盟广告'},
                            {value: 135, name: '视频广告'},
                            {value: 1548, name: '搜索引擎'}
                        ]
                    }
                ]
            },
            {
                geoCoord: [113.5107, 23.2196],

                title: {
                    show: true,
                    text: '广州市行业产值百分比',
                    subtext: '测试数据',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    show: false,
                    orient: 'vertical',
                    x: 'left',
                    data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
                },
                toolbox: {
                    show: false,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            {value: 335, name: '直接访问'},
                            {value: 310, name: '邮件营销'},
                            {value: 234, name: '联盟广告'},
                            {value: 135, name: '视频广告'},
                            {value: 1548, name: '搜索引擎'}
                        ]
                    }
                ]
            },
            {
                geoCoord:  [118.8062, 31.9208],

                title: {
                    show: true,
                    text: '南京市行业产值百分比',
                    subtext: '测试数据',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    show: false,
                    orient: 'vertical',
                    x: 'left',
                    data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
                },
                toolbox: {
                    show: false,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {
                            show: true,
                            type: ['pie', 'funnel'],
                            option: {
                                funnel: {
                                    x: '25%',
                                    width: '50%',
                                    funnelAlign: 'left',
                                    max: 1548
                                }
                            }
                        },
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            {value: 335, name: '直接访问'},
                            {value: 310, name: '邮件营销'},
                            {value: 234, name: '联盟广告'},
                            {value: 135, name: '视频广告'},
                            {value: 1548, name: '搜索引擎'}
                        ]
                    }
                ]
            }
        ]

    };
    //
    return module;
});

/*var module = {
 //
 charts: [
 //
 {
 geoCoord: [100, 23.5],
 tooltip: {
 trigger: 'item',
 formatter: "{a} <br/>{b} : {c} ({d}%)"
 },
 calculable: true,
 series: [
 {
 name: '访问来源',
 type: 'pie',
 radius: '55%',
 center: ['50%', '60%'],
 data: [
 {value: 335, name: '直接访问'},
 {value: 310, name: '邮件营销'},
 {value: 234, name: '联盟广告'},
 {value: 135, name: '视频广告'},
 {value: 1548, name: '搜索引擎'}
 ]
 }
 ]
 },
 {
 geoCoord: [112, 24.33],
 title: {
 text: '某站点用户访问来源',
 subtext: '纯属虚构',
 x: 'center'
 },
 tooltip: {
 trigger: 'item',
 formatter: "{a} <br/>{b} : {c} ({d}%)"
 },
 legend: {
 show: false,
 orient: 'vertical',
 x: 'left',
 data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
 },
 toolbox: {
 show: true,
 feature: {
 mark: {show: true},
 dataView: {show: true, readOnly: false},
 magicType: {
 show: true,
 type: ['pie', 'funnel'],
 option: {
 funnel: {
 x: '25%',
 width: '50%',
 funnelAlign: 'left',
 max: 1548
 }
 }
 },
 restore: {show: true},
 saveAsImage: {show: true}
 }
 },
 calculable: true,
 series: [
 {
 name: '访问来源',
 type: 'pie',
 radius: '55%',
 center: ['50%', '60%'],
 data: [
 {value: 335, name: '直接访问'},
 {value: 310, name: '邮件营销'},
 {value: 234, name: '联盟广告'},
 {value: 135, name: '视频广告'},
 {value: 1548, name: '搜索引擎'}
 ]
 }
 ]
 }
 ]

 };*/
