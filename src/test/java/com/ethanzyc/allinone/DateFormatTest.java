package com.ethanzyc.allinone;

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
}
