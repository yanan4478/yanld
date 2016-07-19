package com.yanld.module.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yanan on 16/7/19.
 */
public class DateUtils {
    public static final String FORMAT_STRING_ONE = "yyyy-MM-dd HH:mm:ss";

    public static String convertDateToString(Date date, String formatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }
}
