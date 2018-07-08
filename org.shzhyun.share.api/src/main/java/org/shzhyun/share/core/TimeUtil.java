package org.shzhyun.share.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
public class TimeUtil {
    public static String getCurrentTime(){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
}
