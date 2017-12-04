/**
 * Created by Administrator on 2017/7/21.
 */


/**
 * WGS84转web墨卡托
 * @param lgtd 经度
 * @returns {Number}
 */
function lonMercator(lgtd) {
    var x = lgtd * 20037508.342789 / 180;
    return x;
}


//

/**
 * WGS84转web墨卡托
 * @param lttd 纬度
 * @returns {Number}
 */
function latMercator(lttd) {
    lttd = parseFloat(lttd);
    var _y = Math.log(Math.tan((90 + lttd) * Math.PI / 360)) / (Math.PI / 180);
    var y = _y * 20037508.34789 / 180;
    return y;
}

//xmin,ymin,xmax,ymax
//东莞影像范围
// var data=[113.528657,22.661484,114.265529,23.149034];
//深圳影像范围
// var data=[113.68352,22.240159,114.658659,22.857826];
//广东范围
// var data=[109.636498,20.065795,117.365721,25.522642];
//
//东改工程f范围
var data=[113.480529785156,22.4199152273486,114.43359375,23.1858131753029];
//
var results=[];
data.forEach(function(d,index){
    //
    if(index%2===0){
        //
        results.push(lonMercator(d));
    }else{
        results.push(latMercator(d));
    }
});
//
//
console.log(results);
