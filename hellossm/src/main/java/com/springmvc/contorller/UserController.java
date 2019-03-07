package com.springmvc.contorller;

import com.springmvc.dao.MyException;
import com.springmvc.pojo.User;
import com.springmvc.service.UserService;
import com.springmvc.util.JWTUtils;
import com.springmvc.util.TokenUserIdUtil;
import com.springmvc.util.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/isNameExist")
    @ResponseBody
    public Map<String, Object> isNameExist(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.isNameExist(user.getUserName());
            map.put("status", 200);

        } catch (MyException e) {
            map.put("status", 201);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();

        try {
            if (userService.register(user) == 1) {
                map.put("message", "true");  //注册成功
                map.put("mes", "请在10分钟内激活账号,该账号只保留至23:59:59");
            } else {
                map.put("message", "false");     //注册失败
            }
        } catch (MyException e) {
            map.put("status", 202);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 登录验证
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            User loginer = userService.login(user);

            map.put("status", 200);
            map.put("token", JWTUtils.getToken(loginer));

        } catch (MyException e) {
            map.put("status", 202);
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 验证激活码是否正确
     *
     * @param servletResponse
     * @param servletRequest
     * @param uuid
     * @return
     */
    @RequestMapping(value = "/verify/{uuid}")
    @ResponseBody
    public Map<String, Object> verify(HttpServletResponse servletResponse, HttpServletRequest servletRequest, @PathVariable String uuid) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (userService.verifyAuthCode(uuid) == 1) {
                map.put("status", 200);
                map.put("message", "true");
                servletResponse.sendRedirect(servletRequest.getContextPath() + "/index.jsp");
            } else {
                map.put("status", 201);
                map.put("message", "false");
            }
        } catch (MyException e) {
            map.put("status", 202);
            map.put("message", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @CrossOrigin
    @RequestMapping(value = "/showAllInfo")
    @ResponseBody
    public Map<String, Object> showAll(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("userInfo", userService.showAllInfo(TokenUserIdUtil.getLoginerId(request)));
        map.put("status", 200);
        return map;
    }

    @CrossOrigin
    @RequestMapping(value = "/updateAllInfo")
    @ResponseBody
    public Map<String, Object> updateAll(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        if (userService.updateAllInfo(user) == 1) {
            map.put("status", 200);
        }
        return map;
    }

//    public Map<String,Object> modifyPwd()
}
