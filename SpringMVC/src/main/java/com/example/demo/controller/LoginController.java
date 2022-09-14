package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-14
 * Time: 9:06
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public HashMap<String,Object> login1(String username,String password){
        //1. 用来存放返回的数据
        HashMap<String,Object> map = new HashMap<>();

        //2. 设置一些用于返回的状态码
        int state = 200;                  //200表示成功访问到了 /user/login 接口
        String message = "未知错误！";      //存放错误信息
        int data = 0;                     //1表示返回数据正确无误

        //3. 判空,通过 StringUtils.hasLength 可以直接判 null 和 空字符串
        if(StringUtils.hasLength(username) && StringUtils.hasLength(password)){

            //4. 判断用户名和密码是否正确
            if(username.equals("admin") && password.equals("admin")){

                //设置返回数据
                data = 1;
                message = "";
                map.put("username",username);
                map.put("password",password);

            }else{
                message = "用户名或密码不正确!";
            }

        }else{
            message = "用户名或密码不能为空!";
        }

        map.put("state",state);
        map.put("data",data);
        map.put("message",message);

        return map;
    }

    //后端使用 json 的类型接收前端所传来的数据
    @RequestMapping("/login2")
    public HashMap<String,Object> login2(@RequestBody User user){
        // 1. 用来存放返回的数据
        HashMap<String,Object> map = new HashMap<>();
        // 2. 设置一些状态码
        int state = 200;
        String message = "未知错误!";
        int data = 0;
        // 3. 判空
        if(StringUtils.hasLength(user.getUsername()) && StringUtils.hasLength(user.getPassword())){

            // 4. 判断用户名和密码的正确性
            if("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())){

                message = "";
                data = 1;
                map.put("username",user.getUsername());
                map.put("password",user.getPassword());

            }else{
                message = "用户名或密码有误！";
            }
        }else{
            message = "用户名或密码不能为空";
        }

        map.put("state",state);
        map.put("data",data);
        map.put("message",message);

        return map;
    }
}
