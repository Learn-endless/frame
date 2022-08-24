package com.beans;

public class User {

    public User(){
        System.out.println("user已经注入到Spring...");
    }

    public void Hello(String name){
        System.out.println("hello "+name);
    }
}
