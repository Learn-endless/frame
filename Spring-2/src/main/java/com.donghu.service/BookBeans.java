package com.donghu.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BookBeans {

    //使用方法注解在 Spring 中存放一个 book1 对象
    @Bean(name = "book1")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book getBook1(){
        Book book = new Book();
        // id : 100
        // name : java
        book.setId(100);
        book.setName("java");
        return book;
    }
}
