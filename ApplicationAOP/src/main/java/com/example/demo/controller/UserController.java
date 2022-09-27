package com.example.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-27
 * Time: 19:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request,String username,String password){
        if(StringUtils.hasLength(username) && StringUtils.hasLength(password)){
            if(username.equals("admin") && password.equals("admin")){
                HttpSession session = request.getSession(true);
                session.setAttribute("userinfo","userinfo");
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/index")
    public String index(){
        int a = 10 / 0;
        return "/user/index";
    }

    @RequestMapping("/index2")
    public String index2(){
        Object obj = null;
        System.out.println(obj.equals("123"));
        return "/user/index2";
    }

    @RequestMapping("/index3")
    public String index3(){
        String str = "hello word";
        Integer integer = Integer.valueOf(str);
        System.out.println(integer);
        return "/user/index3";
    }
}
