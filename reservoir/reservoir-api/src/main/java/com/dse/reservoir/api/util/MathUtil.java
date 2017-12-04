package com.dse.reservoir.api.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @date 2017-10-16
 */
public class MathUtil {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    //这个类不能实例化
    private MathUtil(){

    }


    /**
     * 计算 协方差
     * @param xList
     * @param yList
     * @return
     */
    public static double calcuteCovariation(List<Object> xList,List<Object> yList){
        double result =0.0;
        double xAverage = 0.0;
        double temp = 0.0;

        int xSize = xList.size();
        for(int x=0;x<xSize;x++){
            temp += Double.parseDouble(String.valueOf(Utility.isNotEmpty(xList.get(x)) ? xList.get(x) :"0"  ));
        }
        xAverage = xSize !=0 ? temp/xSize : 0;

        double yAverage = 0.0;
        temp = 0.0;
        int ySize = yList.size();
        for(int x=0;x<ySize;x++){
            temp += Double.parseDouble(String.valueOf(Utility.isNotEmpty(yList.get(x)) ? yList.get(x) : "0" ) );
        }
        yAverage = ySize != 0 ? temp/ySize : 0;

        //double sum = 0.0;
        for(int x=0;x<xSize;x++){
            for( int y = 0 ; y < ySize ;y++){
                if(x== y) {
                    result += (Double.parseDouble(String.valueOf(Utility.isNotEmpty(xList.get(x)) ?  xList.get(x) :"0" )) - xAverage)
                            * (Double.parseDouble(String.valueOf(Utility.isNotEmpty(yList.get(x)) ? yList.get(x) :"0"  )) - yAverage) / xSize;
                    break;
                }
            }

        }
        return result;
    }

    /**
     * 计算 标准差
     * @param xList
     * @param yList
     * @return
     */
    public static double calculateStandardDeviation(List<Object> xList,List<Object> yList){
        double standardDifference ;
        int size = xList.size();
        int ySize  = yList.size();
        double xAverage ;
        double yAverage ;
        double xException = 0.0;
        double yException = 0.0;
        double temp = 0.0;
        for(int i=0;i<size;i++){
            temp += Double.parseDouble(String.valueOf(Utility.isNotEmpty(xList.get(i)) ? xList.get(i) :"0" ));
        }
        xAverage = size != 0 ? temp/size : 0;

        temp = 0.0 ;
        for(int i=0;i<ySize;i++){
            temp += Double.parseDouble(String.valueOf(Utility.isNotEmpty(yList.get(i)) ? yList.get(i) : "0"));
        }
        yAverage = ySize!= 0 ? temp/ySize : 0;

        for(int i=0;i<size;i++){
            for (int x = 0 ;x <ySize ;x++){
                if(x == i){
                    xException += Math.pow(Double.parseDouble(String.valueOf(Utility.isNotEmpty(xList.get(i)) ? xList.get(i) : "0"))-xAverage,2);
                    yException += Math.pow(Double.parseDouble(String.valueOf(Utility.isNotEmpty(yList.get(x)) ? yList.get(x) : "0"))-yAverage, 2);
                }
            }
        }
        xException = size != 0 ? xException/size : 0 - Math.pow(xAverage,2);
        yException = ySize!= 0 ? yException/ySize : 0 - Math.pow(yAverage,2);
        //calculate denominator of
        standardDifference = Math.sqrt(xException*yException);
        return standardDifference;
    }

    /**
     * 计算平均值
     * @param list
     * @return
     */
    public static  Double calcAvgValueForList(List<Object> list,String calcType){
        if(Utility.isEmpty(list) || list.size() < 1 || Utility.isEmpty(calcType)){
            return 0d;
        }
        Double sum= 0d;
        int size = list.size();
        for (int i = 0; i< size ;i ++){
            Double val = Double.valueOf((Utility.isNotEmpty(list.get(i))  ? list.get(i).toString() : "0" ));
            sum = Utility.doubleAdd(sum,val);
        }

        if(CONSTANT.CALC_TYPE_AVG.equals(calcType)){
            return sum/size;
        }else if (CONSTANT.CALC_TYPE_SUM.equals(calcType)){
            return sum;
        }else {
            return 0d;
        }

    }

    /**
     * 计算累计值
     * @param list
     * @return
     */
    public static  Double calcAccValueForList(List<Object> list){
        if(Utility.isEmpty(list) || list.size() < 1){
            return 0d;
        }
        Double sum= 0d;
        int size = list.size();
        for (int i = 0; i< size ;i ++){
            Double val = Double.valueOf((Utility.isNotEmpty(list.get(i))  ? list.get(i).toString() : "0" ));
            sum = Utility.doubleAdd(sum,val);
        }
        return sum;
    }

    public static Double round(Double doubleValue, int scale){
        Double flag=null;
        String text=doubleValue.toString();
        BigDecimal bd=new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP);
        flag=bd.doubleValue();
        return flag;
    }

    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2){
        return div(v1,v2,DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v,int scale){
        if(scale<0){
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        List<Object> xList = new ArrayList<>();
        xList.add("1.1111");
        xList.add("1.959");
        xList.add("3");
        List<Object> yList  = new ArrayList<>();
        yList.add("5");
        yList.add("10.4");
        yList.add("14.6");
        double i = calcuteCovariation(xList,yList);
        double x = calculateStandardDeviation(xList,yList);
//        System.out.println(i);
//        System.out.println(x );
//        System.out.println(i/x );
       double s = Math.sqrt(3);
        double ss = Math.sqrt(15);
        double sss = Math.sqrt(3*15);

//        System.out.println(calcAvgValueForList(xList));
        int r=13/2 ;
        System.out.println(59/365);
        System.out.println(r);

        int a = 59;
        int b = 365;
        System.out.println((double) a/b);
        System.out.println(a/(float)b);
        System.out.println((float)a/(float)b);
    }

}
