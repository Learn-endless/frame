package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-28
 * Time: 16:02
 */

// 将自定义拦截器加入到系统配置中
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginIdInterceptor userLoginIdInterceptor;

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginIdInterceptor)
                .addPathPatterns("/**")         // 拦截所有 url
                .excludePathPatterns("/user/login")       // 排除登录接口
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/login.html")       // 排除登录页面
                .excludePathPatterns("/**/*.js")          // 排除静态资源
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/*.jpg")
                .excludePathPatterns("/**/*.png");
    }
}
