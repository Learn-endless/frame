package com.donghu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    //通过 bean注解在 Spring 中存放了一个 user对象 user1
    @Bean(name= "user1")
    public User getUser1(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    //通过 bean注解在 Spring 中存放了一个 user对象 user1
    @Bean(name= "user2")
    public User getUser2(){
        User user = new User();
        user.setId(2);
        user.setName("李四");
        return user;
    }

//    public void sayHi(){
//        System.out.println("hello");
//    }
}
