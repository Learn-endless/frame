package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-15
 * Time: 22:59
 */
@RestController
@RequestMapping("/user")
public class UserController {

    //属性注入
    @Autowired
    private UserService userService;

    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id){
        //判空
        if(id == null) return null;
        return userService.getUserById(id);
    }
}
