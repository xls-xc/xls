/*
package com.xls.zc.http.base.statistics;

import net.elshop.common.util.ShopHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

*/
/**
 * @copyright
 * @license    
 * @link       
 *
 * 统计公用类
 * 
 * @author zxy
 * Created 2017/4/13 11:10
 *//*

public class StatHelper {
    */
/**
     * 获取小时数组
     * @return
     *//*

    public static Integer[] getHoursArr() {
        Integer[] hours = new Integer[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        return hours;
    }
    */
/**
     * HashMap转Array并按照key排序
     * @param map
     * @return
     *//*

    public static Object[] getHashMapValuesAndSortByKeys(HashMap<?, ?> map) {
        Object[] keyArr = map.keySet().toArray();
        Arrays.sort(keyArr);
        List<Object> list = new ArrayList<>();
        for  (Object key : keyArr) {
            list.add(map.get(key));
        }
        int size = list.size();
        Object[] arr = list.toArray(new Object[size]);
        return arr;
    }
    */
/**
     * 获取HashMap的key数组并排序
     * @param map
     * @return
     *//*

    public static Object[] getHashMapKeysAndSortByKeys(HashMap<?, ?> map) {
        Object[] keyArr = map.keySet().toArray();
        */
/*Integer[] keyArrInteger = new Integer[keyArr.length];
        for(int k = 0; k < keyArr.length; k++){
            keyArrInteger[k] = Integer.parseInt(keyArr[k].toString());
        }
        Arrays.sort(keyArrInteger);
        return keyArrInteger;*//*

        Arrays.sort(keyArr);
        return keyArr;
    }
    */
/**
     * 同比
     * @param updata
     * @param currentdata
     * @return
     *//*

    public static String getTb(long updata, long currentdata){
        String rate = "-";
        if(updata != 0){
            rate = String.format("%.2f", ((double)currentdata - (double)updata)/(double)updata*100)+'%';
        }
        return rate;
    }
    */
/**
     * 处理搜索参数（天）
     * @param searchDay
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsForDay(Timestamp searchDay){
        if (searchDay==null) {
            searchDay = ShopHelper.getFutureTimestamp(Calendar.DATE, -1);
        }
        Timestamp sTime = ShopHelper.getTimestampOfDayStart(searchDay);
        Timestamp eTime = ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(sTime, Calendar.DATE, 1));
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("sTime", sTime);
        timeMap.put("eTime", eTime);
        return timeMap;
    }
    */
/**
     * 处理搜索参数获取当前和前一天的时间（天）
     * @param searchDay
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsPrevAndCurrForDay(Timestamp searchDay){
        if (searchDay==null) {
            searchDay = ShopHelper.getFutureTimestamp(Calendar.DATE, -1);
        }
        Timestamp currSTime = ShopHelper.getTimestampOfDayStart(searchDay);
        Timestamp currETime = ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(currSTime, Calendar.DATE, 1));
        Timestamp prevSTime = ShopHelper.getFutureTimestamp(currSTime, Calendar.DATE, -1);
        Timestamp prevETime = currSTime;

        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("currSTime", currSTime);
        timeMap.put("currETime", currETime);
        timeMap.put("prevSTime", prevSTime);
        timeMap.put("prevETime", prevETime);
        return timeMap;
    }
    */
/**
     * 处理搜索参数（周）
     * @param searchWeek
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsForWeek(String searchWeek){
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        if (StringUtils.isBlank(searchWeek)) {
            timeMap = StatHelper.getWeekStimeAndEtime(null);
        }else{
            String[] weekArray = searchWeek.split("\\|");
            timeMap.put("sTime", Timestamp.valueOf(weekArray[0] + " 00:00:00"));
            timeMap.put("eTime", Timestamp.valueOf(weekArray[1] + " 00:00:00"));
        }
        timeMap.put("sTime", ShopHelper.getTimestampOfDayStart(timeMap.get("sTime")));
        timeMap.put("eTime", ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(timeMap.get("eTime"), Calendar.DATE, 1)));
        return timeMap;
    }
    */
/**
     * 处理搜索参数获取当前和前一周的时间（周）
     * @param searchWeek
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsPrevAndCurrForWeek(String searchWeek){
        HashMap<String, Timestamp> timeMapTmp = new HashMap<>();
        if (StringUtils.isBlank(searchWeek)) {
            timeMapTmp = StatHelper.getWeekStimeAndEtime(null);
        }else{
            String[] weekArray = searchWeek.split("\\|");
            timeMapTmp.put("sTime", Timestamp.valueOf(weekArray[0] + " 00:00:00"));
            timeMapTmp.put("eTime", Timestamp.valueOf(weekArray[1] + " 00:00:00"));
        }
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("currSTime", ShopHelper.getTimestampOfDayStart(timeMapTmp.get("sTime")));
        timeMap.put("currETime", ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(timeMapTmp.get("eTime"), Calendar.DATE, 1)));
        timeMap.put("prevSTime", ShopHelper.getFutureTimestamp(timeMap.get("currSTime"), Calendar.DATE, -7));
        timeMap.put("prevETime", timeMap.get("currSTime"));
        return timeMap;
    }
    */
/**
     * 处理搜索参数（月）
     * @param searchYear
     * @param searchMonth
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsForMonth(int searchYear, int searchMonth){
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        if (searchYear<=0 || searchMonth<=0) {
            searchYear = ShopHelper.formatTimestampOfYear(null);
            searchMonth = ShopHelper.formatTimestampOfMonth(null);
        }
        Timestamp sTime = getMonthFirstDay(searchYear, searchMonth);
        Timestamp eTime = ShopHelper.getFutureTimestamp(getMonthLastDay(searchYear, searchMonth), Calendar.DATE, 1);
        timeMap.put("sTime", sTime);
        timeMap.put("eTime", eTime);
        return timeMap;
    }
    */
/**
     * 处理搜索参数获取当前和前一个月的时间（月）
     * @param searchYear
     * @param searchMonth
     * @return
     *//*

    public static HashMap<String, Timestamp> getStatParamsPrevAndCurrForMonth(int searchYear, int searchMonth){
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        if (searchYear<=0 || searchMonth<=0) {
            searchYear = ShopHelper.formatTimestampOfYear(null);
            searchMonth = ShopHelper.formatTimestampOfMonth(null);
        }
        timeMap.put("currSTime", getMonthFirstDay(searchYear, searchMonth));
        timeMap.put("currETime", ShopHelper.getFutureTimestamp(getMonthLastDay(searchYear, searchMonth), Calendar.DATE, 1));
        timeMap.put("prevSTime", getPrevMonthFirstDay(searchYear, searchMonth));
        timeMap.put("prevETime", ShopHelper.getFutureTimestamp(getPrevMonthLastDay(searchYear, searchMonth), Calendar.DATE, 1));
        return timeMap;
    }
    */
/**
     * 获取本周的开始时间和结束时间具体到天不计算时分秒
     * @param currentTime
     * @return
     *//*

    public static HashMap<String, Timestamp> getWeekStimeAndEtime(Timestamp currentTime){
        if (currentTime==null) {
            currentTime = ShopHelper.getTimestampOfDayStart(ShopHelper.getCurrentTimestamp());
        }
        Timestamp sTime = ShopHelper.getFutureTimestamp(currentTime, Calendar.DATE, -(getDayForWeek(currentTime) - 1));
        Timestamp eTime = ShopHelper.getFutureTimestamp(currentTime, Calendar.DATE, 7-getDayForWeek(currentTime));
        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("sTime", sTime);
        timeMap.put("eTime", eTime);
        return timeMap;
    }

    */
/**
     * 判断当前日期是星期几
     * @param currentTime
     * @return
     *//*

    public static int getDayForWeek(Timestamp currentTime) {
        if (currentTime==null) {
            currentTime = ShopHelper.getCurrentTimestamp();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(currentTime);
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }
    */
/**
     * 获取本月的第一天
     * @param year
     * @param month
     * @return
     *//*

    public static Timestamp getMonthFirstDay(int year, int month){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Timestamp firstDayMonth = new Timestamp(calendar.getTime().getTime());
        firstDayMonth = ShopHelper.getTimestampOfDayStart(firstDayMonth);
        return firstDayMonth;
    }
    */
/**
     * 获取本月的最后一天
     * @param year
     * @param month
     * @return
     *//*

    public static Timestamp getMonthLastDay(int year, int month){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Timestamp lastDayMonth = new Timestamp(calendar.getTime().getTime());
        lastDayMonth = ShopHelper.getTimestampOfDayStart(lastDayMonth);
        return lastDayMonth;
    }
    */
/**
     * 获取上个月的第一天
     * @param year
     * @param month
     * @return
     *//*

    public static Timestamp getPrevMonthFirstDay(int year, int month){
        Calendar calendar1=Calendar.getInstance();
        calendar1.set(Calendar.YEAR, year);
        calendar1.set(Calendar.MONTH, month-2);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        Timestamp firstDayMonth = new Timestamp(calendar1.getTime().getTime());
        firstDayMonth = ShopHelper.getTimestampOfDayStart(firstDayMonth);
        return firstDayMonth;
    }
    */
/**
     * 获取上个月的最后一天
     * @param year
     * @param month
     * @return
     *//*

    public static Timestamp getPrevMonthLastDay(int year, int month){
        Calendar calendar2=Calendar.getInstance();
        calendar2.set(Calendar.YEAR, year);
        calendar2.set(Calendar.MONTH, month-1);
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        Timestamp lastDayMonth = new Timestamp(calendar2.getTime().getTime());
        lastDayMonth = ShopHelper.getTimestampOfDayStart(lastDayMonth);
        return lastDayMonth;
    }
    */
/**
     * 获得系统某月的周数组
     * @param year
     * @param month
     * @return
     *//*

    public static LinkedHashMap<String,String> getWeekStageForMonth(int year, int month){
        //获取前月的第一天
        Timestamp firstDayMonth = getMonthFirstDay(year, month);
        //获取当前月的最后一天
        Timestamp lastDayMonth = getMonthLastDay(year, month);
        //本月第一周的开始时间
        HashMap<String, Timestamp> firstDayWeek = getWeekStimeAndEtime(firstDayMonth);
        Timestamp firstDay = firstDayWeek.get("sTime");
        //整理周Map
        Timestamp lastWeekStime = firstDay;//最后一周的开始时间
        LinkedHashMap<String,String> weekMap = new LinkedHashMap<>();
        while (lastWeekStime.before(lastDayMonth)){
            HashMap<String, Timestamp> currWeek = getWeekStimeAndEtime(lastWeekStime);
            weekMap.put(ShopHelper.formatTimestamp(currWeek.get("sTime")) + "|" + ShopHelper.formatTimestamp(currWeek.get("eTime")), ShopHelper.formatTimestamp(currWeek.get("sTime")) + "~" + ShopHelper.formatTimestamp(currWeek.get("eTime")));
            lastWeekStime = ShopHelper.getFutureTimestamp(lastWeekStime,Calendar.DATE, 7);
        }
        return weekMap;
    }
    */
/**
     * 获得系统可用年份
     * @return
     *//*

    public static Integer[] getSystemYear(){
        Integer[] year = new Integer[]{2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030};
        return year;
    }
    */
/**
     * 获得系统月份
     * @return
     *//*

    public static HashMap<Integer, String> getSystemMonth(){
        HashMap<Integer,String> months = new HashMap<>();
        months.put(1, "01");
        months.put(2, "02");
        months.put(3, "03");
        months.put(4, "04");
        months.put(5, "05");
        months.put(6, "06");
        months.put(7, "07");
        months.put(8, "08");
        months.put(9, "09");
        months.put(10, "10");
        months.put(11, "11");
        months.put(12, "12");
        return months;
    }
    */
/**
     * 获得系统周
     * @return
     *//*

    public static HashMap<Integer, String> getSystemWeek(){
        HashMap<Integer,String> weeks = new HashMap<>();
        weeks.put(1, "周一");
        weeks.put(2, "周二");
        weeks.put(3, "周三");
        weeks.put(4, "周四");
        weeks.put(5, "周五");
        weeks.put(6, "周六");
        weeks.put(7, "周日");
        return weeks;
    }
    */
/**
     * 根据时间获取对应的月份的天数
     * @param currentTime
     * @return
     *//*

    public static int getDaysOfMonthByTime(Timestamp currentTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    */
/**
     * 获得从昨天开始最近7天时间段开始时间和结束时间
     * @param time
     * @return
     *//*

    public static HashMap<String, Timestamp> getStartTimeAndEndTimeFormYesterdayOfLast7Days(Timestamp time){
        if (time==null) {
            time = ShopHelper.getCurrentTimestamp();
        }
        Timestamp endTime = ShopHelper.getTimestampOfDayStart(time);
        Timestamp startTime = ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(endTime, Calendar.DATE, -7));

        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("startTime", startTime);
        timeMap.put("endTime", endTime);
        return timeMap;
    }

    */
/**
     * 获得从今天开始最近7天时间段开始时间和结束时间
     * @param time
     * @return
     *//*

    public static HashMap<String, Timestamp> getStartTimeAndEndTimeFormTodayOfLast7Days(Timestamp time){
        if (time==null) {
            time = ShopHelper.getCurrentTimestamp();
        }
        Timestamp endTime = ShopHelper.getTimestampOfDayStart(time);
        Timestamp startTime = ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(endTime, Calendar.DATE, -7));

        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("startTime", startTime);
        timeMap.put("endTime", endTime);
        return timeMap;
    }
    */
/**
     * 获得从昨天开始最近30天时间段开始时间和结束时间
     * @param time
     * @return
     *//*

    public static HashMap<String, Timestamp> getStartTimeAndEndTimeFormYesterdayOfLast30Days(Timestamp time){
        if (time==null) {
            time = ShopHelper.getCurrentTimestamp();
        }
        Timestamp endTime = ShopHelper.getTimestampOfDayStart(time);
        Timestamp startTime = ShopHelper.getTimestampOfDayStart(ShopHelper.getFutureTimestamp(endTime, Calendar.DATE, -30));

        HashMap<String, Timestamp> timeMap = new HashMap<>();
        timeMap.put("startTime", startTime);
        timeMap.put("endTime", endTime);
        return timeMap;
    }

    */
/**
     * 获取list集合中的map数据
     *
     * @param list
     * @param dataListMap
     * @return
     *//*

    public static  Map<String,Object> putListMap(List<Map<String,Object>> list,Map<String,Object> dataListMap){
        if(dataListMap==null||dataListMap.isEmpty()){
            dataListMap=new HashMap<>();
        }
        if(!CollectionUtils.isEmpty(list)){
            for(Map<String,Object> sourceMap :list){
                if(!sourceMap.isEmpty()){
                    dataListMap.putAll(sourceMap);
                }
            }
        }
        return dataListMap;
    }

    */
/** 闰年中每月天数 *//*

    private static final int[] DAYS_P_MONTH_LY= {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    */
/** 非闰年中每月天数 *//*

    private static final int[] DAYS_P_MONTH_CY= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    */
/** 代表数组里的年、月、日 *//*

    private static final int Y = 0, M = 1, D = 2;
    */
/**
     * 将代表日期的字符串分割为代表年月日的整形数组
     * @param date
     * @return
     *//*

    public static int[] splitYMD(String date){
        date = date.replace("-", "");
        int[] ymd = {0, 0, 0};
        ymd[Y] = Integer.parseInt(date.substring(0, 4));
        ymd[M] = Integer.parseInt(date.substring(4, 6));
        ymd[D] = Integer.parseInt(date.substring(6, 8));
        return ymd;
    }

    */
/**
     * 检查传入的参数代表的年份是否为闰年
     * @param year
     * @return
     *//*

    public static boolean isLeapYear(int year) {
        return year >= gregorianCutoverYear ?
                ((year%4 == 0) && ((year%100 != 0) || (year%400 == 0))) : (year%4 == 0);
    }

    */
/**
     * 日期加1天
     * @param year
     * @param month
     * @param day
     * @return
     *//*

    private static int[] addOneDay(int year, int month, int day){
        if(isLeapYear( year )){
            day++;
            if( day > DAYS_P_MONTH_LY[month -1 ] ){
                month++;
                if(month > 12){
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }else{
            day++;
            if( day > DAYS_P_MONTH_CY[month -1 ] ){
                month++;
                if(month > 12){
                    year++;
                    month = 1;
                }
                day = 1;
            }
        }
        int[] ymd = {year, month, day};
        return ymd;
    }

    */
/**
     * 将不足两位的月份或日期补足为两位
     * @param decimal
     * @return
     *//*

    public static String formatMonthDay(int decimal){
        DecimalFormat df = new DecimalFormat("00");
        return df.format( decimal );
    }

    */
/**
     * 将不足四位的年份补足为四位
     * @param decimal
     * @return
     *//*

    public static String formatYear(int decimal){
        DecimalFormat df = new DecimalFormat("0000");
        return df.format( decimal );
    }

    */
/**
     * 计算两个日期之间相隔的天数
     * @param begin
     * @param end
     * @return
     * @throws ParseException
     *//*

    public static long countDay(String begin,String end){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate , endDate;
        long day = 0;
        try {
            beginDate= format.parse(begin);
            endDate=  format.parse(end);
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    */
/**
     * 以循环的方式计算日期
     * @param beginDate endDate
     * @param
     * @return
     *//*

    public static List<String> getEveryday(String beginDate , String endDate){
        long days = countDay(beginDate, endDate);
        int[] ymd = splitYMD( beginDate );
        List<String> everyDays = new ArrayList<String>();
        //everyDays.add(beginDate);
        for(int i = 0; i < days; i++){
            ymd = addOneDay(ymd[Y], ymd[M], ymd[D]);
            everyDays.add(formatMonthDay(ymd[M])+"-"+formatMonthDay(ymd[D]));
        }
        return everyDays;
    }
    private static transient int gregorianCutoverYear = 1582;

    public static void main(String[] args) {


        HashMap<String, Timestamp> map=StatHelper.getStartTimeAndEndTimeFormTodayOfLast7Days(null);
        System.out.println(map.get("startTime"));
        System.out.println(map.get("endTime"));
        List<String> list = StatHelper.getEveryday(map.get("startTime").toString(), map.get("endTime").toString());
        for (String result : list) {
            System.out.println(result);
        }
    }
}
*/
