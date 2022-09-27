package com.example.demo.aop;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-27
 * Time: 23:36
 */
@RestControllerAdvice    //表示这是一个异常通知类
public class MyExceptionInterceptor {

    //会先匹配 NullPointerException 异常处理器，没有就会找 Exception 异常处理器
    @ExceptionHandler(NullPointerException.class)
    public HashMap<String,Object> nullPointerException(NullPointerException e){
        HashMap<String,Object> map = new HashMap<>();
        map.put("status",0);
        map.put("success",false);
        map.put("msg",e.getMessage());
        return map;
    }

    @ExceptionHandler(Exception.class)       //这是具体的异常处理器
    public HashMap<String,Object> exceptionInterceptor(Exception e){
        HashMap<String,Object> map = new HashMap<>();
        map.put("status",0);
        map.put("success",false);
        map.put("msg",e.getMessage());
        return map;
    }
}
