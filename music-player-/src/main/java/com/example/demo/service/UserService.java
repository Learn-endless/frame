package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.tools.EncryptionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-28
 * Time: 9:41
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private EncryptionTool encryptionTool;

    // 调用用户登录所需要的接口
    public Object login(User user){

        // 调用 mybatis 中的用户查找接口
        return userMapper.login(user);
    }

    // 用户注册
    public Object register(User user){

        //查询该用户名是否被注册
        User userByName = userMapper.getUserByName(user.getUsername());
        if(userByName != null){
            // 该用户已被注册
            return "该账号已被注册！";
        }

        // 获取加密密码
        String encryptPassword = encryptionTool.encrypt(user.getPassword());
        user.setPassword(encryptPassword);
        int register = userMapper.register(user);

        if(register == 1){
            HashMap<String,Object> map = new HashMap<>();
            map.put("result","success");
            map.put("redirect","/login.html");
            return map;
        }else{
            return "注册失败!";
        }

    }
}
