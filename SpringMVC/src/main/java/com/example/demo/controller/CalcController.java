package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-13
 * Time: 20:46
 */
@RestController    //这是一个组合注解：相当于 ResponseBody 和 Controller 一起使用
public class CalcController {

    //直接使用一级路径
    @RequestMapping("/calc")
    //参数名要和前端的一样
    public String calc(Integer num1, Integer num2){
        if(num1 == null || num2 == null){
            //这个 a 标签表示返回上一次访问的地址
            return "<h1>参数错误!</h1>"+"<a href='javascript:history.go(-1)'>返回</a>";
        }
        return "<h1>"+(num1+num2)+"</h1>"+"<a href='javascript:history.go(-1)'>返回</a>";
    }
}
