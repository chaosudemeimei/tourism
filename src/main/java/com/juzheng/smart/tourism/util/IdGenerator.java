package com.juzheng.smart.tourism.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {

    /**
     * 用户编码生成
     * @return
     */
    public static String createUserCode(){
        String date = DateUtils.formatDate(new Date(), new SimpleDateFormat("yyyyMMdd"));
        String randomKey = String.valueOf(Integer.parseInt(UUID.randomUUID().toString().substring(0,3),16));
        return date+randomKey;
    }
}
