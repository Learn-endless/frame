package com.donghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

//    属性注入
    @Autowired              //Autowired 首先根据 类 来查询。
    @Qualifier(value = "user1")
//    @Resource(name = "user1")
    private User user;           //和 Spring 中的 bean 对象 user1 完全匹配。
//    private User user101;
//    private User user102;
//    private Book book;

//    @Autowired
////    @Qualifier() 不允许在构造方法上使用
//    public UserController(Book book,User user1,User user2){
//        this.user101 = user1;
//        this.user102 = user2;
//        this.book = book;
//    }

//    @Autowired
//    @Qualifier(value = "user1")
//    public void setUser(User user){
//        this.user101 = user;
//    }
//
//    @Autowired
//    @Qualifier(value = "user2")
//    public void setUser102(User user) {
//        this.user102 = user;
//    }
//
//    @Autowired
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public void printUser(){
        System.out.println(user);
//        System.out.println(user101);
//        System.out.println(user102);
//        System.out.println(book);
    }
}
