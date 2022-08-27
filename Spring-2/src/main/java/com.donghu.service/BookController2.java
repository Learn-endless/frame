package com.donghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

//模拟另一用户也使用了 book1 对象
@Controller
public class BookController2 {

    //同样是属性注入的方式将 book1 注入到 book 中
    @Autowired
    @Qualifier(value = "book1")
    private Book book;

    //这里就不进行修改，而是直接获取对象
    public Book controller2(){
        return book;
    }
}
