package com.ethanzyc.allinone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
