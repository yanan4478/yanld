package com.yanld.module.controller;

import com.yanld.module.dal.dataobject.YanldUser;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/6/20.
 */
@Controller
public class HomeController {

    @Resource
    private YanldUserService yanldUserService;

    @RequestMapping({"/","/home"})
    public String showHomePage(Map<String, Object> model) {
        List<YanldUser> yanldUserList = yanldUserService.queryAllYanldUser();
        model.put("users", yanldUserList);
        return "home";
    }
}
