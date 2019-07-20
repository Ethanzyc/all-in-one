package com.ethanzyc.allinone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ethan
 * @date 2019/6/12 16:06
 */
public class DateFormatTest {

    public static void main(String[] args) {
        String date = "3月日";
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date1);
    }

    @Test
    public void testDate() {
        String date = "2019-06-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(date1);
        System.out.println(date1.before(new Date()));
    }

    public Date oneYearLater(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);
        return calendar.getTime();
    }

    @Test
    public void testDateFromAfter() {
        String date = "2015-02-29";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date2 = oneYearLater(date1);
        System.out.println(date2);
    }

    @Test
    public void testWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));

        calendar.add(Calendar.DAY_OF_YEAR, 100);
        System.out.println(calendar);
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));

    }

    @Test
    public void testString() {
        String dateKey = "2018";
        int yearStr = Integer.valueOf(dateKey.substring(0, 4));
        dateKey = String.valueOf(yearStr - 1) + dateKey.substring(4);
        System.out.println(dateKey);
    }

    @Test
    public void getDay() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayofweek);

        String end, start;
        if (dayofweek == 1) {
            // 时间是周日，上周就是往前推7天
            end = getDateKey(date, 7);
            start = getDateKey(date, 13);
        } else {
            end = getDateKey(date, dayofweek - 1);
            start = getDateKey(date, dayofweek + 5);
        }
        System.out.println(end + "  " + start);
    }

    @Test
    public void getDayMonth() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = format.parse("20190305");
        int cycle = 2;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        String start;
        if (cycle == 1) {
            cal.add(Calendar.MONTH, -1);
            start = getDateKey(date, dayOfMonth);
        } else {
            cal.add(Calendar.MONTH, -1);
            int maximum = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            start = getDateKey(date, dayOfMonth + maximum);
        }
        System.out.println(start);
    }
//
//    @Test public void testMax() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Date parse = format.parse("20190601");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(parse);
//        System.out.println(cal.getActualMaximum());
//    }

    /**
     * 获取的是昨天
     * 根据日期获取 类似 20190715 格式的 date key
     *
     * @param date
     * @param cycle 间隔周期
     * @return
     */
    public static String getDateKey(Date date, int cycle) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -cycle);

        return format(c.getTime(), DATE_PATTERN.YYYYMMDD);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static final String format(Object date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            return format(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 日期格式
     **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    }


    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static final String format(Object date) {
        return format(date, DATE_PATTERN.YYYY_MM_DD);
    }
}
