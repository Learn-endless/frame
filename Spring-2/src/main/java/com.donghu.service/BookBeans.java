package com.donghu.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BookBeans {

    @Bean(name = "book1")
    public Book getBook1(){
        Book book = new Book();
        book.setId(100);
        book.setName("三国演义");
        return book;
    }
}
