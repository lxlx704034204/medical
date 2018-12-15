package com.bben.infusion.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {
    public static final SimpleDateFormat SDF_STANDARD_HS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);
    public static final SimpleDateFormat SDF_STANDARD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    public static final SimpleDateFormat SDF_STANDARD_DAY = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    public static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DTF_MONTH_DAY = DateTimeFormatter.ofPattern("MM-dd");
    public static String getWeek(int num) {
        String week = "0";
        switch (num){
            case 1: {week = "周一";break;}
            case 2: {week = "周二";break;}
            case 3: {week = "周三";break;}
            case 4: {week = "周四";break;}
            case 5: {week = "周五";break;}
            case 6: {week = "周六";break;}
            case 7: {week = "周日";break;}
            default:
                break;
        }
        return week;
    }

    /**
     * 间隔分钟 保留两位小数
     * @param end
     * @param begin
     * @return
     */
    public static double timeIntervalMin(Date end, Date begin)
    {
        return new BigDecimal((double) (end.getTime() - begin.getTime())/(1000 * 60)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 时间间隔时间戳
     * @param end
     * @param begin
     * @return
     */
    public static Double timeInterval(Date end, Date begin)//剩余天数
    {
        return ((end.getTime() - begin.getTime())/ 86400000d);
    }

    /**
     * unix时间戳转String
     * @param unixTime
     * @return
     */
    public static String UnixToStringDate(long unixTime){
        return SDF_STANDARD.format(new Date(unixTime));
    }

    /**
     * date转10位unix时间戳
     * @param date
     * @return
     */
    public static Long dateToUnix(Date date){
        return date.getTime();
    }

    /**
     * 获取minute分钟之前的时间
     * @param thisTime
     * @param minute
     * @return
     */
    public static Date getBeformMinuteTime(Date thisTime,int minute){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -minute);// minute分钟之前的时间
        return  calendar.getTime();
    }

    /**
     * 获取day天之前的时间
     * @param thisTime
     * @param day
     * @return
     */
    public static Date getBeforeDayTime(Date thisTime,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -day);// day天之前的时间
        return  calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {
//        double a = (double) 4/6;
//        double c= new BigDecimal((double) 4/6).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
//        System.out.println(c);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d = new Date();
//        d = sdf.parse("2016-10-24 21:59:06");
//        System.out.println(d);

//        getBeformMinuteTime(new Date(),20);
        getBeforeDayTime(new Date(),12);
    }

}
