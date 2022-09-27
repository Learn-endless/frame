package com.example.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-27
 * Time: 19:39
 */

// 将自定义的拦截器注册到系统配置文件中
@Configuration
public class Register implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        //用户登录验证拦截器
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")                 // 拦截所有的 url
//                .excludePathPatterns("/user/login")     // 不拦截 url 为 /user/login 的登录接口
//                .excludePathPatterns("/user/reg")       // 不拦截 url 为 /user/reg 的注册接口
//                .excludePathPatterns("/login.html")     // 不拦截 登录页面
//                .excludePathPatterns("/reg.html")       // 不拦截 注册页面
//                .excludePathPatterns("/**/*.css")       // 不拦截所有的 css
//                .excludePathPatterns("/**/*.js")        // 不拦截所有的 js
//                .excludePathPatterns("/**/*.png")       // 不拦截 png 图片
//                .excludePathPatterns("/**/*.jpg");      // 不拦截 jpg 图片

    }

    //给所有的 controller 类都加上 前缀。
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        configurer.addPathPrefix("api",c->true);
//    }
}
