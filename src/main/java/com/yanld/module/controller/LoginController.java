package com.yanld.module.controller;

import com.yanld.module.common.constant.BaseConstant;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.dto.YanldUserDTO;
import com.yanld.module.service.YanldUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by yanan on 16/8/25.
 */
@Controller
public class LoginController {

    @RequestMapping("/welcome")
    public String login() {
        return "welcome";
    }

    @Resource
    private YanldUserService userService;

    @RequestMapping("/login")
    public String login(@Valid @ModelAttribute("userDetail") YanldUserDTO user, BindingResult bindingResult,
                        HttpServletRequest request, HttpServletResponse response,Map<String, Object> model) throws Exception {
        if(bindingResult.hasErrors()) {
            model.put("doLogin", "1");
            return "index";
        }
        YanldUserDO userDO = userService.userLogin(user.getUname(), user.getPwd());
        if (userDO != null) {

            request.getSession().setAttribute("userId", userDO.getId());
            request.getSession().setAttribute("userName", userDO.getUserName());

            String tokenContent = user.getUname() + userDO.getLastLoginTime().getTime() / 1000;

            Cookie token = new Cookie("token", DigestUtils.md5DigestAsHex(tokenContent.getBytes()));
            token.setMaxAge(BaseConstant.COOKIE_LAST_SECONDS);
            token.setHttpOnly(true);
            token.setPath("/");

            Cookie name = new Cookie("user", user.getUname());
            name.setMaxAge(BaseConstant.COOKIE_LAST_SECONDS);
            name.setPath("/");

            response.addCookie(token);
            response.addCookie(name);
            return "redirect:/";
        } else {
            //用户名或密码错误
            return "redirect:/welcome";
        }
    }
}
