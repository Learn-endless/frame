package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 15:53
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用来完成用户登录逻辑
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String userLoginPost(String username, String password, HttpServletRequest request){
        //校验所接收的参数是否合法
        if(username == null || password == null || "".equals(username) || "".equals(password)){
            return "redirect:/isEmpty.html";
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
            return "redirect:/userError.html";
        }
        User user = (User) session.getAttribute("user");
        if(user == null || user.getUserId() == 0){
            return "redirect:/userError.html";
        }

        //2.删除用户信息，并重定向当登录页面
        session.removeAttribute("user");
        return "redirect:/blog_login.html";
    }
}
