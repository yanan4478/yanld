package com.yanld.module.common.util;

import java.util.Collection;
import java.util.List;

/**
 * Created by yanan on 16/7/19.
 */
public class DataUtils {

    public static boolean isBlank(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isValueAllNull(List<?> list) {
        for(Object o : list) {
            if(o != null) {
                return false;
            }
        }
        return true;
    }
}
