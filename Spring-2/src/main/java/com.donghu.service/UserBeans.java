package com.donghu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean(name= {"user","userInfo"})
    public User user1(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }
    public void sayHi(){
        System.out.println("hello");
    }
}
