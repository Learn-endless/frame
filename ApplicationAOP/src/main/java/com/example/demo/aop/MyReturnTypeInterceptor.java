package com.example.demo.aop;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-27
 * Time: 23:43
 */
@ControllerAdvice
public class MyReturnTypeInterceptor implements ResponseBodyAdvice {
    /**
     * 返回 true ，表示会统一处理返回结果，然后将结果交给前端
     * 返回 false，表示不统一除了返回结果
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
//        在这里可以控制返回 true 和 false 来决定哪些方法需要做 统一的结果 处理。
        return true;
    }

//    缺点就是 status 和 msg 基本上就被固定了
    @Override
    public HashMap<String,Object> beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("status",1);
        map.put("data",body);
        map.put("msg","");
        return map;
    }
}
