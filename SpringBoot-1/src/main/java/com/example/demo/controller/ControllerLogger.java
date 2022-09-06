package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-03
 * Time: 21:29
 */

@Controller
@ResponseBody          //表示返回的不是一个 静态页面。而是一个数据
public class ControllerLogger {

    // 拿到日志对象（来自slf4j）             设置当前类的类型（方便在显示日志时,能看到是哪个类中的日志信息）
    private final static Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

    // 设置路由
    @RequestMapping("/hello")
    public void hello(){
        //打印日志
        logger.trace("这是一条 trace 级别的日志");
        logger.debug("这是一条 debug 级别的日志");
        logger.info("这是一条 info 级别的日志");
        logger.warn("这是一条 warn 级别的日志");
        logger.error("这是一条 error 级别的日志");
    }
}
