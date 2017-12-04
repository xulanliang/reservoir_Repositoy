/**
 * Created by Administrator on 2016/8/16.
 */

define([], function () {
    //
    var heatData = [];
    for (var i = 0; i < 200; ++i) {
        heatData.push([
            100 + Math.random() * 20,
            24 + Math.random() * 16,
            Math.random()
        ]);
    }
    for (var j = 0; j < 10; ++j) {
        var x = 100 + Math.random() * 16;
        var y = 24 + Math.random() * 12;
        var cnt = 30 * Math.random();
        for (var i = 0; i < cnt; ++i) {
            heatData.push([
                x + Math.random() * 2,
                y + Math.random() * 2,
                Math.random()
            ]);
        }
    }

    var mo = {
        // backgroundColor: '#1b1b1b',
        title: {
            text: '热力图结合地图',
            x: 'center',
            textStyle: {
                color: 'white'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: '{b}'
        },
        toolbox: {
            show: false,
            orient: 'vertical',
            x: 'right',
            y: 'center',
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        series: [
            {
                name: '北京',
                type: 'map',
                mapType: 'none',
                roam: true,
                hoverable: false,
                data: [],
                heatmap: {
                    minAlpha: 0.1,
                    data: heatData
                },
                itemStyle: {
                    normal: {
                        borderColor: 'rgba(100,149,237,0.6)',
                        borderWidth: 0.5,
                        areaStyle: {
                            color: '#1b1b1b'
                        }
                    }
                }
            }
        ]
    };
    return mo;
});