package com.dse.reservoir.api.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2017/8/15.
 */

public class DateUtil {

    /***
     *
     */
    public static final  String  DATE_MASK = "yyyy-MM-dd HH:mm:ss";
    /***
     *
     */
    public static final  String  DATE_MONTH = "month";
    /***
     *
     */
    public static final  String  DATE_DAY = "day";
    /***
     *
     */
    public static final  String  DATE_HOUR = "hour";
    /***
     *
     */
    public static final  String  DATE_YEAR = "year";

    public static final String yyyy_MM_dd = "yyyy-MM-dd";


    /**
     * 将timestamp转换成String
     *
     * @param timestamp
     * @return
     */
    public static String timestampToStr(Timestamp timestamp) {
        return DateUtil.timestampToStr(timestamp, null);
    }

    /**
     * 将timestamp转换成String
     *
     * @param timestamp
     * @return
     */
    public static String timestampToStr(Timestamp timestamp, String aMask) {
        String ret = null;
        String mask = aMask;
        if (mask == null || "".equals(mask)) {
            mask = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        ret = sdf.format(timestamp);
        return ret;
    }

    /**
     * 将date转换成String
     *
     * @return
     */
    public static String dateToStr(Date date) {
        return DateUtil.dateToStr(date, null);
    }

    /**
     * 将date转换成String
     *
     * @return
     */
    public static String dateToStr(Date date, String aMask) {
        String ret = null;
        String mask = aMask;
        if (mask == null || "".equals(mask))
            mask = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        ret = sdf.format(date);
        return ret;
    }

    /**
     * 将String转换成Date
     *
     * @return
     */
    public static java.util.Date strToDate(String date) {
        return DateUtil.strToDate(date, null);
    }

    /**
     * 将String转换成Date
     *
     * @return
     */
    public static java.util.Date strToDate(String date, String aMask) {
        java.util.Date ret = null;
        String mask = aMask;
        if (mask == null || "".equals(mask))
            mask = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        try {
            ret = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String lpadnum(int num, int length) {
        int len = String.valueOf(num).length();
        StringBuffer str = new StringBuffer("");
        if (len < length) {
            for (int i = 0; i < length - len; i++) {
                str.append("0");
            }
            return str.append(num).toString();
        } else {
            return String.valueOf(num);
        }
    }

    /**
     * 返回当前的GregorianCalendar
     *
     * @return
     */
    public static Calendar getToday() {
        return new GregorianCalendar();
    }

    /**
     * 返回当前日期的年
     *
     * @return
     */
    public static String getYear() {
        Calendar calendar = DateUtil.getToday();
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    /**
     * 返回当前日期的月
     *
     * @return
     */
    public static String getMonth() {
        Calendar calendar = DateUtil.getToday();
        int month = calendar.get(Calendar.MONTH) + 1;
        return DateUtil.lpadnum(month, 2);
    }

    /**
     * 返回当前日期的天
     *
     * @return
     */
    public static String getDay() {
        Calendar calendar = DateUtil.getToday();
        return DateUtil.lpadnum(calendar.get(Calendar.DAY_OF_MONTH), 2);
    }

    /**
     * 返回当前日期的小时数
     *
     * @return
     */
    public static String getHour() {
        Calendar calendar = DateUtil.getToday();
        return DateUtil.lpadnum(calendar.get(Calendar.HOUR_OF_DAY), 2);
    }

    /**
     * 返回当前日期的分钟
     *
     * @return
     */
    public static String getMinute() {
        Calendar calendar = DateUtil.getToday();
        return DateUtil.lpadnum(calendar.get(Calendar.MINUTE), 2);
    }

    /**
     * 返回当前日期的秒钟
     *
     * @return
     */
    public static String getSecond() {
        Calendar calendar = DateUtil.getToday();
        return DateUtil.lpadnum(calendar.get(Calendar.SECOND), 2);
    }

    /**
     * 返回当前日期
     *
     * @return
     */
    public static String getDate() {
        return DateUtil.getYear() + "-" + DateUtil.getMonth() + "-"
                + DateUtil.getDay();
    }

    /**
     * 返回带时间的日期
     *
     * @return
     */
    public static String getDateWithTime() {
        return DateUtil.getDate() + " " + DateUtil.getHour() + ":"
                + DateUtil.getMinute() + ":" + DateUtil.getSecond();
    }

    /**
     *
     * @param date
     * @return
     */
    public static String get(java.util.Date date, int mode) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        return String.valueOf(DateUtil.lpadnum(calendar.get(mode), 2));
    }

    /**
     * 将一个日期增加多少天
     *
     * @param date
     * @param day
     * @return
     */
    public static String addDay(java.util.Date date, int day) {
        return DateUtil.add(date, day, "day");
    }

    /**
     * 将一个日期增加多少天
     *
     * @param date
     * @param day
     * @return
     */
    public static String addDay(String date, int day) {
        return DateUtil.addDay(DateUtil.strToDate(date), day);
    }

    /**
     * 将一个日期增加多少天
     *
     * @param date
     * @param hour
     * @return
     */
    public static String addHour(java.util.Date date, int hour) {
        //return DateUtil.add(date, hour,"hour");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        Date nowdate = calendar.getTime();
        return DateUtil.dateToStr(nowdate,DateUtil.DATE_MASK);
    }

    /**
     * 将一个日期增加多少天
     *
     * @param date
     * @param hour
     * @return Date
     */
    public static Date addHour2Date(java.util.Date date, int hour) {
        //return DateUtil.add(date, hour,"hour");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        Date nowdate = calendar.getTime();
        return nowdate;
    }
    /**
     * 将一个日期增加多少天
     *
     * @param date
     * @param hour
     * @return
     */
    public static String addHour(String date, int hour) {
        //return DateUtil.add(DateUtil.strToDate(date), hour,"hour");
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(DateUtil.strToDate(date));
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        Date nowdate = calendar.getTime();
        return DateUtil.dateToStr(nowdate,DateUtil.DATE_MASK);
    }

    /**
     * @将一个日期增加多少天,并根据aMask格式返回String
     * @param date
     * @param day
     * @param aMask
     * @Return:String
     * @Author:
     */
    public static String addDay(Date date,int day,String aMask) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(ca.DAY_OF_MONTH, day);
        String result = dateToStr(ca.getTime(),aMask);
        return result;
    }

    /**
     * @将一个日期增加多少天,并根据aMask格式返回String
     * @param date
     * @param day
     * @Return:Date
     * @Author:
     */
    public static Date addDay2Date(Date date,int day) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(ca.DAY_OF_MONTH, day);
        Date result = ca.getTime();
        return result;
    }
    /**
     * 将一个日期增加多少个月
     *
     * @param date
     * @param month
     * @return
     */
    public static String addMonth(java.util.Date date, int month) {
        return DateUtil.add(date, month, "month");
    }

    /**
     * 将一个日期增加多少个月
     *
     * @param date
     * @param month
     * @return
     */
    public static String addMonth(String date, int month) {
        return DateUtil.addMonth(DateUtil.strToDate(date), month);
    }

    public static boolean equalsDate(java.util.Date atime, java.util.Date btime) {
        GregorianCalendar acalc = (GregorianCalendar) getToday();
        GregorianCalendar bcalc = (GregorianCalendar) getToday();
        acalc.setTime(atime);
        bcalc.setTime(btime);
        if (acalc.after(bcalc)) {
            return true;
        } else {
            if (!acalc.before(bcalc)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean equalsDate(String atime, String btime) {
        return equalsDate(strToDate(atime), strToDate(btime));
    }

    public static String add(java.util.Date date, int num, String mode) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        if ("month".equalsIgnoreCase(mode)) {
            calendar.add(Calendar.MONTH, num);
        }else if("hour".equalsIgnoreCase(mode)){
            calendar.add(Calendar.HOUR_OF_DAY, num);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, num);
        }

        return String.valueOf(calendar.get(Calendar.YEAR)) + "-"
                + DateUtil.lpadnum(calendar.get(Calendar.MONTH) + 1, 2) + "-"
                + DateUtil.lpadnum(calendar.get(Calendar.DAY_OF_MONTH), 2);
    }

    /***
     *
     * @param date
     * @param num
     * @param mode
     * @return
     */
    public static Date add2Date(java.util.Date date, int num, String mode) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        if (DATE_YEAR.equalsIgnoreCase(mode)) {
            calendar.add(Calendar.YEAR, num);
        }else if (DATE_MONTH.equalsIgnoreCase(mode)) {
            calendar.add(Calendar.MONTH, num);
        }else if(DATE_HOUR.equalsIgnoreCase(mode)){
            calendar.add(Calendar.HOUR_OF_DAY, num);
        } else {
            calendar.add(Calendar.DAY_OF_MONTH, num);
        }
        Date result = calendar.getTime();
        return result;
    }

    /**
     * 返回当前时间
     *  dominic
     * @return 返回当前时间
     */
    public static Date getCurrentDateTime() {
        java.util.Calendar calNow = java.util.Calendar.getInstance();
        java.util.Date dtNow = calNow.getTime();

        return dtNow;
    }

    public static Timestamp stringToTimestamp(String dateStr) {
        Timestamp ts = null;
        try {
            ts = Timestamp.valueOf(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    public static Timestamp stringToTimestamp(String dateStr, String pattern){
        if(Utility.isEmpty(dateStr)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 时间差
     * dominic
     * @return 返回两个时间差几秒
     */
    public static int diffTime(Date date1, Date date2) {
        GregorianCalendar c1 = new GregorianCalendar();
        c1.setTime(date1);
        GregorianCalendar c2 = new GregorianCalendar();
        c2.setTime(date2);
        double timeLong = c2.getTimeInMillis() - c1.getTimeInMillis();
        return (int) timeLong / 1000;
    }

    /**
     * 两个日期相差的天数  返回值取正数 抛出异常则返回-1
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String startDate,String endDate)  {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(startDate));
            long time1 = cal.getTimeInMillis();
            cal.setTime(sdf.parse(endDate));
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Math.abs(Integer.parseInt(String.valueOf(between_days)));
        }catch (ParseException e){
            e.printStackTrace();
            return  -1 ;
        }
    }

    /**
     * 计算两个日期之间相差的天数 返回值取正数 抛出异常则返回-1
     * @param startDate 较小的时间
     * @param endDate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date startDate,Date endDate)   {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            startDate = sdf.parse(sdf.format(startDate));
            endDate = sdf.parse(sdf.format(endDate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(endDate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);

            return Math.abs(Integer.parseInt(String.valueOf(between_days)));
        }catch (ParseException e){
            e.printStackTrace();
            return  -1 ;
        }
    }

    public static int compareDate(String startDate, String endDate) {
        DateFormat df = new SimpleDateFormat(yyyy_MM_dd);
        try {
            Date dt1 = df.parse(startDate);
            Date dt2 = df.parse(endDate);
            if (dt1.getTime() > dt2.getTime()) {

                return -1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {

        // System.out.println(DateUtil.equalsDate("2007-02-17", "2007-02-17"));

        //System.out.println(DateUtil.addHour(new Date(),2));

//        System.out.println("%:"+10%3+"/:"+10/3);

//        System.out.println(DateUtil.addDay("2017-10-27",-30));
//        System.out.println(DateUtil.addDay("2017-10-27",-16));

        System.out.println(DateUtil.compareDate("2017-01-","2017-01-01"));
        System.out.println(DateUtil.strToDate("2017-01-01 00:05:05",yyyy_MM_dd));
    }

}
