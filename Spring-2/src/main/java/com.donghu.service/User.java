package com.donghu.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
public class User {
    private int id;
    private String name;
    public User(){
        System.out.println("Spring管理了 User 类 ...");
    }
    public void hello(){
        System.out.println("hello Spring!"+name+id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
