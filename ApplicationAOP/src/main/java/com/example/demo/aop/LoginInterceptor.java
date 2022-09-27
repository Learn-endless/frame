package com.example.demo.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-27
 * Time: 19:32
 */

@Component
//定义一个用户登录验证的拦截器
public class LoginInterceptor implements HandlerInterceptor {
//    重写这个统一处理的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取session对象
        HttpSession session = request.getSession(false);
        //2.判断用户是否登录过
        if(session != null){
            Object userinfo = session.getAttribute("userinfo");
            //3. 判断 session 里面是否有 userinfo 信息
            if(userinfo != null){
                return true;
            }
        }
        //说明用户没有登录，放回用户登录页面
        response.sendRedirect("/login.html");
        return false;
    }
}
