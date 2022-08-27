package com.donghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//模拟一个用户使用了 book1 对象
@Controller
public class BookController1 {

    //使用属性注入的方式将 Spring 中的 book1 对象注入到 book 中
    @Autowired
    @Qualifier(value = "book1")
    private Book book;

    //调用这个方法可以修改所注入的对象
    public Book controller1(){
        Book bookTest = this.book;
        bookTest.setName("三国演义");
        return bookTest;
    }
}
