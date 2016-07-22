package com.yanld.module.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.commons.io.IOUtils;

/**
 * Created by yanan on 16/7/20.
 */
public class StackTraceUtils {
    public static String getStackTrance(Throwable exception) {
        PrintWriter pw = null;
        StringWriter sw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            return sw.toString();
        } finally {
            IOUtils.closeQuietly(sw);
            IOUtils.closeQuietly(pw);
        }
    }
}
