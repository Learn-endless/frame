package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 15:53
 */
@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //用来完成用户登录逻辑
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLoginPost(String username, String password, HttpServletRequest request){
        //校验所接收的参数是否合法
        if(username == null || password == null || "".equals(username) || "".equals(password)){
            return "redirect:/is_empty.html";
        }
        //交给service层来进行业务的拼接处理
        return userService.userLogin(username,password,request);
    }

    //用来校验用户是否登录
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User userLoginGet(@SessionAttribute(value = "user",required = false) User user){
        //直接返回 user
        //值为 null 表示没有用户登录
        //值不为 null 表示有用户登录
        return user;
    }

    //通过 blogId 所对应的 author 信息
    @ResponseBody
    @RequestMapping("/getauthor")
    public Object getAuthorByBlogId(Integer blogId){
        //校验参数的正确性
        if(blogId == null || blogId == 0){
            //返回一个空对象，表示 博客id非法
            return new Object();
        }
        //交给service层来处理
        return userService.getAuthorByBlogId(blogId);
    }

    //用户注销
    @RequestMapping(value = "/cancel",method = RequestMethod.GET)
    public String cancelUser(HttpServletRequest request){
        //1. 检测用户是否登录
        HttpSession session = request.getSession(false);
        if(session == null){
            return "redirect:/user_error.html";
        }
        User user = (User) session.getAttribute("user");
        if(user == null || user.getUserId() == 0){
            return "redirect:/user_error.html";
        }

        //2.删除用户信息，并重定向当登录页面
        session.removeAttribute("user");
        return "redirect:/blog_login.html";
    }


    //用户注册逻辑
    @RequestMapping("/register")
    @ResponseBody
    public Object userRegister(HttpServletRequest request, String username,String password1,String password2,String userYzm,String yzm){
        //1. 检测username是否为null和空字符串
        if(username == null || password1 == null || password2 == null || userYzm == null || yzm == null
        || "".equals(username) || "".equals(password1) || "".equals(password2) || "".equals(userYzm) || "".equals(yzm)){
            return new Object();
        }

//        打印一下日志
        log.info(userYzm);
        log.info(yzm);
        //全转换为小写
        userYzm = userYzm.toLowerCase();
        yzm = yzm.toLowerCase();
        log.info(userYzm);
        log.info(yzm);

        //2. 检测密码两次输入是否相等 和 验证码是否相等
        if(!password1.equals(password2) || !userYzm.equals(yzm)){
            return new Object();
        }

        //3. 交给service层来处理添加业务
        return userService.addUser(request,username,password1);
    }
}
