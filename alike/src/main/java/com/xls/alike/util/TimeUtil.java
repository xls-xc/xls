package com.xls.alike.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: xls (星辰)
 * @PackageName: com.xls.alike.util
 * @ClassName: TimeUtil
 * @Description: 时间工具
 * @Author: SkyChen
 * @Create: 2020-04-25 11:29
 * @Version: v1.0
 **/
public class TimeUtil {

    /**
     * 时间格式化类型
     */
    private static final String TYPE1 ="yyyy-MM-dd HH:mm:ss";


    /**
     * 求时间差  第二个时间减第一个时间的差值
     * @param date1
     * @param date2
     * @return
     */
    public static Long getTimeDifference(Date date1,Date date2) {
        return dateToLong(date2)-dateToLong(date1);
    }

    /**
     * 比较时间第一个时间是否早于或等于第二个时间
     * @param timeString1 yyyy-MM-dd HH:mm:ss
     * @param timeString2 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Boolean compareTimes(String timeString1,String timeString2){
            Date date1 = stringToDate(timeString1);
            Date date2 = stringToDate(timeString2);
            return dateToLong(date1) <= dateToLong(date2);
    }
    /**
     * 比较时间第一个时间是否早于或等于第二个时间
     * @param date1 Date
     * @param date2 Date
     * @return
     */
    public static Boolean compareTimes(Date date1,Date date2) {
            return dateToLong(date1) <= dateToLong(date2);
    }

    /**
     * 比较时间第一个时间是否早于或等于第二个时间
     * @param timestamp1 Timestamp
     * @param timestamp2 Timestamp
     * @return
     */
    public static Boolean compareTimes(Timestamp timestamp1,Timestamp timestamp2) {
        Long aLong = timestampToLong(timestamp1);
        Long bLong = timestampToLong(timestamp2);
        if(aLong<=bLong) {
            return true;
        }
        return false;
    }



    /**
     * 时间字符串转时间戳
     * @param timeString yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Long stringToLong(String timeString){
        Date date = stringToDate(timeString);
        return dateToLong(date);
    }

    /**
     * 时间字符串转 Date
     * @param timeString yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date stringToDate(String timeString) {
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE1);
        try {
            date = sdf.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 日期转时间毫秒数
     * @param date
     * @return
     */
    public static Long dateToLong(Date date) {
        return date.getTime();
    }

    /**
     * 时间戳转毫秒数
     * @param timestamp
     * @return
     */
    public static Long timestampToLong(Timestamp timestamp) {
        return timestamp.getTime();
    }

    /**
     * JAVA日期转字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TYPE1);
        return simpleDateFormat.format(date);
    }

    /**
     * 时间戳转JAVA日期
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(Timestamp timestamp) {
        Long aLong = timestampToLong(timestamp);
        return new Date(aLong);
    }

    /**
     * 时间戳转JAVA日期
     * @param timestamp
     * @return
     */
    public static String timestampToString(Timestamp timestamp) {
        Date date = timestampToDate(timestamp);
        return dateToString(date);
    }

    /**
     * 获取当前时间戳
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当前日期
     * @return
     */
    public static Date getCurrentDate() {
        return timestampToDate(getCurrentTimestamp());
    }


    /**
     * 获取当前字符串日期
     * @return
     */
    public static String getCurrentDateString() {
        return timestampToString(getCurrentTimestamp());
    }
}
