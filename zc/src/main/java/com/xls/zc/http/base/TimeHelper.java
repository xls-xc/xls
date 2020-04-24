/**
 * Copyright (C), 2018-2019,
 * FileName: TimeHelper
 * Author:   zhuzhenzhen
 * Date:     2019/4/3 下午3:39
 * Description: 时间工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xls.zc.http.base;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈时间工具类〉
 *
 * @author zhuzhenzhen
 * @create 2019/4/3
 * @since 1.0.0
 */
public class TimeHelper {

    public static Timestamp addDaysTime(Timestamp timestamp,int addDay){
        Calendar cc = Calendar.getInstance();
        cc.setTime(timestamp);
        cc.add(Calendar.DAY_OF_YEAR,addDay);

       return  new Timestamp(cc.getTime().getTime());
    }
    public static Boolean compareTimes(String time1,String time2){
        String pattern ="yyyy-MM-dd HH:mm:ss";//格式化日期格式
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        Date d1 = null;//把时间格式化
        try {
            d1 = sf.parse(time1);
            Date d2 = sf.parse(time2);//把时间格式化
            return d1.getTime() >= d2.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Boolean compareNowTimes(String time1){
        String pattern ="yyyy-MM-dd hh:mm:ss";//格式化日期格式
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        Date d1 = null;//把时间格式化
        try {
            d1 = sf.parse(time1);
            Date d2 = new Date();//把时间格式化
            return d1.getTime() >= d2.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }
    public  static void main(String args[]){
//        Timestamp timestamp=new Timestamp(new Date().getTime());
//        System.out.println(TimeHelper.addDaysTime(timestamp,10));
        System.out.println(TimeHelper.compareNowTimes("2020-01-06 13:00:00"));
    }
}
