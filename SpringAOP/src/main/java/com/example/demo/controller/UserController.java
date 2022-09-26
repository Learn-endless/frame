package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-26
 * Time: 16:31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/add")
    public String addUser(){
        System.out.println("Controller 执行完毕》》》");
//        int a = 10 / 0;
        return "Controller 层的功能执行完毕...";
    }
}
