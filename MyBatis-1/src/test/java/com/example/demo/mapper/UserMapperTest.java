package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 9:57
 */

@SpringBootTest   //表示该单元测试运行在 springboot 中
class UserMapperTest {

    @Autowired    //专业版本这里就会报错,但是不影响运行结果
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo userInfo = userMapper.getUserById(1);
        System.out.println("结果："+userInfo);
    }
}