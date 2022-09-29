package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-28
 * Time: 9:18
 */

@RestController
@RequestMapping("/user")            //一级路径
public class UserController {

    @Resource
    private UserService userService;

    // post 方法进行登录
    @RequestMapping("/login")
    public Object login(HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password){
        //参数校验
        if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
            //说明参数非法
            return "用户名或密码为null";
        }

        //封装成一个 user 对象,方便 service 层的使用
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //调用 service 中的接口查询 user 对象信息
        return userService.login(request,user);
    }


    // 用户注册
    @RequestMapping("/register")
    public Object register(User user){
        System.out.println(user);
        // 1. 检查参数
        if(user == null || !StringUtils.hasLength(user.getUsername()) || !StringUtils.hasLength(user.getPassword())){
            // 参数有误
            return "用户名或密码为空";
        }
        return userService.register(user);
    }
}
