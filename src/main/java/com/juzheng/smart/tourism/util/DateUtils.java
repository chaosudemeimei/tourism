package com.juzheng.smart.tourism.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDate(Date date, SimpleDateFormat dateFormat){
        return dateFormat.format(date);
    }



}