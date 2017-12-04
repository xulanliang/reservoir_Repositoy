/**
 * 监测设备数据
 * @date 2017-07-19
 * @author wangsl
 */

define(function (require, exports, module) {
    //
    var jcSbData = {
        "displayFieldName": "NAME",
        "fieldAliases": {
            "NAME": "NAME"
        },
        "geometryType": "esriGeometryPoint",
        "spatialReference": {
            "wkid": 102113,
            "latestWkid": 3785
        },
        "fields": [
            {
                "name": "NAME",
                "type": "esriFieldTypeString",
                "alias": "NAME",
                "length": 50
            }
        ],
        "features": [

            {
                "attributes": {
                    "NAME": "东改工程"
                    ,"PROJ_CD" : "3"
                },
                "geometry": {
                    "x": 12702646.670200001,
                    "y": 2607620.1807999983
                }
            },
            {
                "attributes": {
                    "NAME": "雁田水库"
                    ,"PROJ_CD" : "2"
                },
                "geometry": {
                    "x": 12709241.6611,
                    "y": 2591656.598099999
                }
            },
            {
                "attributes": {
                    "NAME": "深圳水库"
                    ,"PROJ_CD" : "1"
                },
                "geometry": {
                    "x": 12707619.761999998,
                    "y": 2580921.7870000005
                }
            },
            {
                "attributes": {
                    "NAME": "金湖泵站"
                    ,"PROJ_CD" : "3017"
                },
                "geometry": {
                    "x": 12702646.670200001,
                    "y": 2607620.1807999983
                }
            },
            {
                "attributes": {
                    "NAME": "旗岭泵站"
                    ,"PROJ_CD" : "3004"
                },
                "geometry": {
                    "x": 12697651.1703,
                    "y": 2625015.233600002
                }
            },
            {
                "attributes": {
                    "NAME": "莲湖泵站"
                    ,"PROJ_CD" : "3002"
                },
                "geometry": {
                    "x": 12701287.3455,
                    "y": 2632049.720400002
                }
            },
            {
                "attributes": {
                    "NAME": "太园泵站"
                    ,"PROJ_CD" : "3001"
                },
                "geometry": {
                    "x": 12703017.2757,
                    "y": 2637335.2358999997
                }
            }
        ]
    };
    //
    return jcSbData;
});
