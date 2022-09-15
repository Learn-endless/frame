package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-15
 * Time: 22:56
 */

@Service
public class UserService {

    //进行属性装配
    @Resource
    private UserMapper userMapper;

    //调用 UserMapper 中的 getUserById() 方法
    public UserInfo getUserById(Integer id){
        return userMapper.getUserById(id);
    }
}
