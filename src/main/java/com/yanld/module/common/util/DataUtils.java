package com.yanld.module.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/7/19.
 */
public class DataUtils {
    public static <T> List<String> toStringList(List<T> list) {
        List<String> resultList = new ArrayList<>();
        for(T t : list) {
            resultList.add(String.valueOf(t));
        }
        return resultList;
    }

    public static boolean isBlank(List<?> list) {
        return list == null || list.size() == 0;
    }
}
