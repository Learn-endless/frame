package com.donghu.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Test implements BeanNameAware, BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("前置方法...");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后置方法...");
        return null;
    }

    //通知方法
    @Override
    public void setBeanName(String s) {
        System.out.println("执行了 Aware 方法...");
    }

    //init-method
    public void init(){
        System.out.println("执行了 init 方法...");
    }

    //构造方法(前置方法)
    @PostConstruct
    public void postConstruct(){
        System.out.println("执行 PostConstruct 构造方法...");
    }

    //销毁方法(后置方法)
    @PreDestroy
    public void PreDestroy(){
        System.out.println("销毁方法...");
    }
}
