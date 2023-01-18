package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    //-----------------------------登录注册功能
    //登录：
    @RequestMapping("/Login")
    public String login(){
        return "Login";
    }
    @GetMapping("/result")
    public String result(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(username);
        user.setPassword(password);

        boolean flag = userService.login(user);

        if(flag==true){
            return "Success";
        }else {
            return "Middle";
        }
    }
    @GetMapping("/middle")
    public String middle(){
        return "Login";
    }
    //注册：
    @GetMapping("/zhuCe")
    public String zhuCe(){
        return "ZhuCe";
    }
    @GetMapping("/end")
    public String end(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(username);
        user.setPassword(password);
        boolean flag = userService.zhuCe(user);
        if(flag==true){
            return "End1";
        }else{
            return "End2";
        }
    }
}

