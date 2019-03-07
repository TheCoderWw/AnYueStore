package com.springmvc.contorller;


import com.springmvc.service.UserService;
import com.springmvc.util.JWTUtils;
import com.springmvc.util.TokenUserIdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/homePage")
public class HomePageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getLoginerName")
    @ResponseBody
    public Map<String, Object> getLoginerName(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            //根据Token查找当前登录
            map.put("userName", userService
                    .getUserById(TokenUserIdUtil.getLoginerId(request)).getUserName());
        } catch (Exception e) {
            map.put("status", 401);
        }
        return map;
    }
}
