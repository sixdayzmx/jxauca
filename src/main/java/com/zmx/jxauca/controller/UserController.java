package com.zmx.jxauca.controller;


import com.alibaba.fastjson.JSONObject;
import com.zmx.jxauca.entity.User;
import com.zmx.jxauca.service.UserService;
import com.zmx.jxauca.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String userLogin(String username, String pwd, HttpServletResponse response){
        boolean flag=false;
        flag = userService.userLogin(username, pwd);
        if(flag){
            Cookie cookie = new Cookie("userName",username);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/user/main";
        }
        return "index";
    }

    @RequestMapping("/main")
    public String main(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("userList",users);
        System.out.println(users);
        return "main";

    }
}
