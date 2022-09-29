package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-29
 * Time: 17:42
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public int addUser(User user){
        return userMapper.addUser(user);
    }
}
