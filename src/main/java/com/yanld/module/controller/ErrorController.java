package com.yanld.module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yanan on 16/8/9.
 */
@Controller
public class ErrorController {
    @RequestMapping({"/error"})
    public String error() {
        return "error";
    }
}
