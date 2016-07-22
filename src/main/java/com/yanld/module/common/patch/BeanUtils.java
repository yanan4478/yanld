package com.yanld.module.common.patch;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.*;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by yanan on 16/7/21.
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
    public static Map describe(Object bean)
            throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
        DateConverter converter = getDateConverter();
        beanUtilsBean.getConvertUtils().register(new ConverterFacade(converter), java.util.Date.class);
        return beanUtilsBean.describe(bean);
    }

    public static void populate(Object bean, Map properties)
            throws IllegalAccessException, InvocationTargetException {
        DateConverter converter = getDateConverter();
        ConvertUtils.register(new ConverterFacade(converter), java.util.Date.class);
        org.apache.commons.beanutils.BeanUtilsBean.getInstance().populate(bean, properties);
    }

    private static DateConverter getDateConverter() {
        org.apache.commons.beanutils.converters.DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd HH:mm:ss");
        return converter;
    }
}

class BeanUtilsBean extends org.apache.commons.beanutils.BeanUtilsBean {
    public BeanUtilsBean() {
        super(new ConvertUtilsBean());
    }
}

class ConvertUtilsBean extends org.apache.commons.beanutils.ConvertUtilsBean {
    @Override
    public String convert(Object value) {

        if (value == null) {
            return null;
        } else if (value.getClass().isArray()) {
            if (Array.getLength(value) < 1) {
                return (null);
            }
            value = Array.get(value, 0);
            if (value == null) {
                return null;
            } else {
                Converter converter = lookup(String.class);
                return ((String) converter.convert(String.class, value));
            }
        } else {
            Converter converter;
            if (value instanceof Date) {
                converter = lookup(Date.class);
            } else {
                converter = lookup(String.class);
            }
            return ((String) converter.convert(String.class, value));
        }
    }
}