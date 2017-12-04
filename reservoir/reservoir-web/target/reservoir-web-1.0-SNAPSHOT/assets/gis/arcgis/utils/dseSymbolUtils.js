/**
 * Created by Administrator on 2016/7/25.
 */
define(["esri/symbols/SimpleFillSymbol",
    "esri/symbols/SimpleLineSymbol",
    "esri/symbols/SimpleMarkerSymbol",
    "esri/symbols/TextSymbol",
    "esri/symbols/PictureMarkerSymbol",
    "esri/symbols/Font",
    "dojo/_base/Color",
    "esri/Color"
], function (SimpleFillSymbol, SimpleLineSymbol, SimpleMarkerSymbol, TextSymbol, PictureMarkerSymbol, Font, Color, EsriColor) {
    //
    var module = (function () {
        //
        return {
            //
            /**
             * mark样式配置
             * @param {Object} sttp  类型
             * @param {Object} flag      当为雨量时 为降雨强度    水闸  开关状态
             * 类型为取水户时(qsh):正常（1）、数据异常（2）、预警（3）、报警（4）
             * @return path:图片资源路径、width:宽度，heigth:高度
             */
            getMarkImg: function (sttp, flag) {
                var path = "";
                var width = 16;
                var height = 16;
                if (!flag && flag != '0') {
                    flag = 1;
                }
                switch (sttp) {
                    case "PP":
                        path = styleName + "/img/pp/pp-" + flag + ".png";
                        break;
                    case "ZZ":
                        path = "";
                        break;
                    case "ZQ":
                        path = "";
                        break;
                    case "QSH":
                        path = styleName + "/img/qsh/A034-" + flag + ".png";
                        width = 24;
                        height = 24;
                        break;
                    default:
                        path = "";
                        break;
                }
                return {
                    path: dseGisPath + path,
                    width: width,
                    height: height
                };
            },
            /**
             * 创建线样式方法(线风格：数值类型,颜色rgb数组如：[255,255,255]，线宽:数值类型）
             * 线风格包含的值：STYLE_DASH:1    实-虚线；STYLE_DASHDOT:2 实-点-虚线；STYLE_DASHDOTDOT:3 实-点-点-虚线；STYLE_DOT 点-虚线:4
             * STYLE_LONGDASH:5    长实-虚；STYLE_LONGDASHDOT:6    长实-点-虚；STYLE_NULL:7    空样式；STYLE_SHORTDASH:8    长实-虚（间隔小）
             * STYLE_SHORTDASHDOT:9    长实-点-虚（间隔小）；STYLE_SHORTDASHDOTDOT:10    长实-点-虚（间隔小）；STYLE_SHORTDOT:11    点-虚（间隔小）；STYLE_SOLID:12 实线
             * @return PictureMarkerSymbol
             *
             */
            SLineSymbol: function (Ltype, Colors, width) {
                var SSymboltype;
                Ltype = parseInt(Ltype);
                switch (Ltype) {
                    case 1:
                        SSymboltype = SimpleLineSymbol.STYLE_DASH;
                        break;
                    case 2:
                        SSymboltype = SimpleLineSymbol.STYLE_DASHDOT;
                        break;
                    case 3:
                        SSymboltype = SimpleLineSymbol.STYLE_DASHDOTDOT;
                        break;
                    case 4:
                        SSymboltype = SimpleLineSymbol.STYLE_DOT;
                        break;
                    case 5:
                        SSymboltype = SimpleLineSymbol.STYLE_LONGDASH;
                        break;
                    case 6:
                        SSymboltype = SimpleLineSymbol.STYLE_LONGDASHDOT;
                        break;
                    case 7:
                        SSymboltype = SimpleLineSymbol.STYLE_NULL;
                        break;
                    case 8:
                        SSymboltype = SimpleLineSymbol.STYLE_SHORTDASH;
                        break;
                    case 9:
                        SSymboltype = SimpleLineSymbol.STYLE_SHORTDASHDOT;
                        break;
                    case 10:
                        SSymboltype = SimpleLineSymbol.STYLE_SHORTDASHDOTDOT;
                        break;
                    case 11:
                        SSymboltype = SimpleLineSymbol.STYLE_SHORTDOT;
                        break;
                    case 12:
                        SSymboltype = SimpleLineSymbol.STYLE_SOLID;
                        break;
                    default:
                        SSymboltype = SimpleLineSymbol.STYLE_SOLID;
                }
                if (!width && width <= 0) {
                    width = 1;
                }
                return new SimpleLineSymbol(SSymboltype, new Color(Colors), width);
            },
            /**
             * 创建面样式方法(面填充风格(目前常用的为1，实体填充)：数值类型,线样式,颜色rgb+透明度 数组如：[255,255,255,0.5])
             */
            SFillSymbol: function (Ptype, SLineSymbol, Colors) {
                var SFSymboltype;
                Ptype = parseInt(Ptype);
                switch (Ptype) {
                    case 1:
                        SFSymboltype = SimpleFillSymbol.STYLE_SOLID;
                        break;
                    case 2:
                        SFSymboltype = SimpleFillSymbol.STYLE_BACKWARD_DIAGONAL;
                        break;
                    case 3:
                        SFSymboltype = SimpleFillSymbol.STYLE_CROSS;
                        break;
                    case 4:
                        SFSymboltype = SimpleFillSymbol.STYLE_DIAGONAL_CROSS;
                        break;
                    case 5:
                        SFSymboltype = SimpleFillSymbol.STYLE_FORWARD_DIAGONAL;
                        break;
                    case 6:
                        SFSymboltype = SimpleFillSymbol.STYLE_HORIZONTAL;
                        break;
                    case 7:
                        SFSymboltype = SimpleFillSymbol.STYLE_NULL;
                        break;
                    case 8:
                        SFSymboltype = SimpleFillSymbol.STYLE_VERTICAL;
                        break;
                    default:
                        SFSymboltype = SimpleFillSymbol.STYLE_SOLID;
                }
                return new SimpleFillSymbol(SFSymboltype, SLineSymbol, new Color(Colors));
            },
            /**
             * 创建点样式方法(图片样式,宽度，高度）
             * @return PictureMarkerSymbol
             *
             */
            PMS: function (path, width, heigth) {
                if (!width) {
                    width = 16;
                }
                if (!heigth) {
                    heigth = 16;
                }
                var pms = new PictureMarkerSymbol(path, width, heigth);
                //
                return pms;
            },
            //
            // "ExpressionDzx":"CONTOUR =5 OR CONTOUR=10 OR CONTOUR=25 OR CONTOUR=50 OR CONTOUR=100 OR CONTOUR=250 OR CONTOUR>250",
            //等值线返回对应的颜色
            getColorDzx: function (dValue) {
                var color;
                var alpha = 0.5;
                if (dValue == 0) {
                    color = new EsriColor([0, 0, 0, alpha]);
                }
                else if (dValue == 5) {
                    color = new EsriColor([165, 243, 141, alpha]);
                }
                else if (dValue == 10) {
                    color = new EsriColor([58, 182, 58, alpha]);
                }
                else if (dValue == 25) {
                    color = new EsriColor([91, 180, 248, alpha]);
                }
                else if (dValue == 50) {
                    color = new EsriColor([2, 2, 250, alpha]);
                }
                else if (dValue == 100) {
                    color = new EsriColor([253, 0, 249, alpha]);
                }
                else if (dValue == 250) {
                    color = new EsriColor([254, 46, 73, alpha]);
                }
                else {
                    color = new EsriColor([254, 46, 73, alpha]);
                }
                return color;
            },
            //等值面返回对应的颜色
            getColorDzm: function (dValue) {
                var color;
                var alpha = 0.5;
                if (dValue == 0) {
                    color = new EsriColor([255, 255, 255, 0]);
                }
                else if (dValue == 1) {
                    color = new EsriColor([165, 243, 141, alpha]);
                }
                else if (dValue == 2) {
                    color = new EsriColor([58, 182, 58, alpha]);
                }
                else if (dValue == 3) {
                    color = new EsriColor([91, 180, 248, alpha]);
                }
                else if (dValue == 4) {
                    color = new EsriColor([2, 2, 250, alpha]);
                }
                else if (dValue == 5) {
                    color = new EsriColor([253, 0, 249, alpha]);
                }
                else if (dValue == 6) {
                    color = new EsriColor([254, 46, 73, alpha]);
                }
                else {
                    color = new EsriColor([254, 46, 73, 0]);
                }
                return color;
            },
            /**
             * 创建等值面符号
             * */
            createDzmSymbol: function (counter) {
                //
                var sym = new SimpleFillSymbol(); //new esri.symbol.SimpleFillSymbol();
                var color = new EsriColor([0, 0, 0, 0.5]);
                if (counter) {
                    //
                    color = this.getColorDzm(counter); // getColorDzxm(feature.attributes.GRIDCODE);//设置不同的颜色
                    //
                    var outLineSym = new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, color, 1);
                    sym.setOutline(outLineSym);
                    sym.setColor(color);
                }
                //
                return sym;
            },
            /**
             * 创建等值线符号
             * */
            createDzxSymbol: function (counter) {
                //
                var color = new EsriColor([0, 0, 0, 0.5]);
                //
                if (counter) {
                    color = this.getColorDzx(counter);
                }
                return new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, color, 1);
            },
            /**
             * 创建文本符号
             * */
            createTextSymbol: function (options) {
                //options:
                //content: String
                //text color: [r,g,b,a]
                //font angle: number default is 45
                //font size: string default is "12pt"
                var content = options.content;
                //
                var textColor = options.textColor || [128, 0, 0, 0.8];
                //
                var fontAngle = options.angle || 45;
                var fontSize = options.fontSize || "12pt";
                var offsetX = options.offsetX || 0;
                var offsetY = options.offsetY || 0;
                var textSymbol = new TextSymbol(content).setColor(new Color(textColor)).setAlign(Font.ALIGN_START).setAngle(fontAngle).setFont(new Font(fontSize).setWeight(Font.WEIGHT_BOLD));
                //
                /**
                 * xoffset    Number    The offset on the x-axis in pixels from the point.
                 yoffset
                 * */
                textSymbol.xoffset = offsetX;
                textSymbol.yoffset = offsetY;
                return textSymbol;
            },
            //
            createTextSymbolFrom: function (json) {
                //
                return new TextSymbol(json);
            },
            /**
             * 创建简单点符号
             * */
            createSimpleMakerSymbol: function (options) {
                //option:
                // size: default 12
                // fill color: [r,g,b,a]
                // border color: [r,g,b,a]
                //border width: number default is 1
                var size = options.size || 12;
                var borderWidth = options.width || 1;
                var fillColor = options.fillColor || [207, 34, 171, 0.5];
                var borderColor = options.borderColor || [247, 34, 101, 0.9];
                var symbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CIRCLE, size, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, new Color(borderColor), borderWidth), new Color(fillColor));
                //
                return symbol;
            },
            /**
             * 创建简单线符号
             * */
            createSimpleLineSymbol: function (options) {
                //options:
                // width: default 2
                //border color: [r,g,b,a]
                var lineWidth = options.width || 2;
                var fillColor = options.fillColor || [255, 0, 0, 0.8];
                //
                if (typeof fillColor === "string") {
                    fillColor = Color.fromHex(fillColor);
                    fillColor.a = options.alpha;
                }
                //
                var style = options.style || SimpleLineSymbol.STYLE_DASH;
                var symbol = new SimpleLineSymbol(style, new Color(fillColor), lineWidth);
                return symbol;
            },
            /**
             *创建箭头
             * */
            createSimpleArrowSymbol: function (color, angle) {
                //
                // var arrow = "M 0 0 L 10 5 L 0 10 Z";
                var arrow = "M2,2 L10,6 L2,10 L6,6 L2,2";
                //
                var fillColor = color || new Color([207, 34, 171, 0.5]);
                var angle = angle || 45;
                var markerSymbol = new SimpleMarkerSymbol();
                markerSymbol.setPath(arrow);
                markerSymbol.setAngle(angle);
                markerSymbol.setColor(fillColor);
                markerSymbol.setOutline(null);
                return markerSymbol;
            },
            /**
             * 创建简单面符号
             * */
            createSimpleFillSymbol: function (options) {
                //options
                //border color: [r,g,b,a]
                // fill color: [r,g,b,a]
                //border width: number default is 2
                var borderColor = options.borderColor || [255, 0, 0, 0.8];
                var fillColor = options.fillColor || [136, 136, 136, 0.5];
                //
                if (typeof fillColor === "string") {
                    fillColor = Color.fromHex(fillColor);
                    fillColor.a = options.alpha;
                }
                if (typeof borderColor === "string") {
                    borderColor = Color.a = options.borderAlpha;
                }
                // )
                var borderWidth = options.width || 2;
                var sfs = new SimpleFillSymbol(SimpleFillSymbol.STYLE_SOLID, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID, new Color(borderColor), borderWidth), new Color(fillColor));
                //
                return sfs;
            },
            /**
             * 创建图片符号.
             * */
            createPictureMarkerSymbol: function (options) {
                //options:
                //width :number default is 24
                //height:number default is 24
                //url : String
                // var info = this.PMS("/img/arrow.png", 25, 41);
                var width = options.width;
                var height = options.height;
                var url = options.url; //? dseGisPath + styleName + options.url : dseGisPath + styleName + "/img/arrow.png";
                //
                var symbol = new PictureMarkerSymbol(url, width, height);
                return symbol;
            },
            /**
             * STYLE_DASH    The line is made of dashes.
             STYLE_DASHDOT    The line is made of a dash-dot pattern.
             STYLE_DASHDOTDOT    The line is made of a dash-dot-dot pattern.
             STYLE_DOT    The line is made of dots.
             STYLE_LONGDASH    Line is constructed of a series of dashes.
             STYLE_LONGDASHDOT    Line is constructed of a series of short dashes.
             STYLE_NULL    The line has no symbol.
             STYLE_SHORTDASH    Line is constructed of a series of short dashes.
             STYLE_SHORTDASHDOT    Line is constructed of a dash followed by a dot.
             STYLE_SHORTDASHDOTDOT    Line is constructed of a series of a dash and two dots.
             STYLE_SHORTDOT    Line is constructed of a series of short dots.
             STYLE_SOLID    The line is solid.
             */
            lineStyle: {
                STYLE_DASH: SimpleLineSymbol.STYLE_DASH,
                STYLE_DASHDOT: SimpleLineSymbol.STYLE_DASHDOT,
                STYLE_DASHDOTDOT: SimpleLineSymbol.STYLE_DASHDOTDOT,
                STYLE_DOT: SimpleLineSymbol.STYLE_DOT,
                STYLE_LONGDASH: SimpleLineSymbol.STYLE_LONGDASH,
                STYLE_LONGDASHDOT: SimpleLineSymbol.STYLE_LONGDASHDOT,
                STYLE_NULL: SimpleLineSymbol.STYLE_NULL,
                STYLE_SHORTDASH: SimpleLineSymbol.STYLE_SHORTDASH,
                STYLE_SHORTDASHDOT: SimpleLineSymbol.STYLE_SHORTDASHDOT,
                STYLE_SHORTDASHDOTDOT: SimpleLineSymbol.STYLE_SHORTDASHDOTDOT,
                STYLE_SHORTDOT: SimpleLineSymbol.STYLE_SHORTDOT,
                STYLE_SOLID: SimpleLineSymbol.STYLE_SOLID,
            }
        };
    })();
    return module;
});
//# sourceMappingURL=dseSymbolUtils.js.map