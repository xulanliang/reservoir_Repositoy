/**
 * Created by Administrator on 2016/11/14.
 */
define([], function () {
    //
    var module = (function () {
        //
        // var offset = 106; not in frame.
        var offset = 106; // in frame.;
        //
        return {
            RES_1024_768: {
                width: 1024,
                height: 768
            },
            //high resolution.
            RES_1440_1050: {
                width: 1440,
                height: 1050 //$(window).height()// - offset
            },
            RES_1440_900: {
                width: 1440,
                height: 900 //$(window).height()// - offset
            },
            RES_1600_900: {
                width: 1600,
                height: 900 // $(window).height()// - offset
            },
            RES_1680_1050: {
                width: 1680,
                height: 1050 //$(window).height() //- offset
            },
            RES_1920_1080: {
                width: 1920,
                height: 1080 //$(window).height() //- offset
            },
            RES_1280_1024: {
                width: 1280,
                height: 1024 //$(window).height() - offset
            },
            RES_1360_768: {
                width: 1360,
                height: 768 // - offset
            },
            offset: offset
        };
    })();
    //
    return module;
});
//# sourceMappingURL=resolution.js.map