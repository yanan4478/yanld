package com.yanld.module.controller;

import com.yanld.module.dal.dataobject.YanldCategoryDO;
import com.yanld.module.dal.dataobject.YanldUserDO;
import com.yanld.module.service.YanldCategoryService;
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
public class IndexController {

    @Resource
    private YanldCategoryService yanldCategoryService;

    @RequestMapping({"/"})
    public String showIndex(Map<String, Object> model) {
        List<YanldCategoryDO> yanldCategoryDOs = yanldCategoryService.selectCategories();
        model.put("categories", yanldCategoryDOs);
        return "index";
    }
}
