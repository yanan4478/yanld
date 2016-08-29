package com.yanld.module.common.annotation;

import com.yanld.module.common.constant.RedisQueryLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yanan on 16/8/29.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisQuery {
    RedisQueryLevel value();
}

