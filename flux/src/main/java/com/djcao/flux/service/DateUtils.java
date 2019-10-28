package com.djcao.flux.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-28
 */
public class DateUtils {
    private static final ThreadLocal<Map<String, SimpleDateFormat>> simpleDateThreadLocal = ThreadLocal.withInitial(
        HashMap::new);

    private static final String STD_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String format(String format, Date date){
        Map<String, SimpleDateFormat> stringSimpleDateFormatMap = simpleDateThreadLocal.get();
        SimpleDateFormat simpleDateFormat = stringSimpleDateFormatMap.get(format);
        if (simpleDateFormat == null){
            simpleDateFormat = new SimpleDateFormat(format);
            stringSimpleDateFormatMap.put(format,simpleDateFormat);
        }
        return simpleDateFormat.format(date);
    }

    public final static String stdFormat(Date date){
        return format(STD_DATE_FORMAT,date);
    }
}
