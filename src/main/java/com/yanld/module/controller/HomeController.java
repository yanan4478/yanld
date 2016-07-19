package com.yanld.module.controller;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
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

    @RequestMapping({"/h","/home"})
    public String showHomePage(Map<String, Object> model) {
        List<YanldUserDO> yanldUserDOList = yanldUserService.selectUsers();
        model.put("users", yanldUserDOList);
        return "demo";
    }
}
