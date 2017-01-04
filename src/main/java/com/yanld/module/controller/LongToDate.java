package com.yanld.module.controller;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * Created by yanan on 16/9/9.
 */
public class LongToDate implements TemplateMethodModelEx {
    @Override
    public Object exec(List list) throws TemplateModelException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        //ServletWebRequest webRequest = ((ServletWebRequest)RequestContextHolder.getRequestAttributes());
        Locale locale = LocaleContextHolder.getLocale();
        HttpServletRequest request = requestAttributes.getRequest();
        //HttpServletRequest request1 = webRequest.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();
        //HttpServletResponse response1 = webRequest.getResponse();
        return "<img src=\"/image/beian.png\"/>";
    }
}
