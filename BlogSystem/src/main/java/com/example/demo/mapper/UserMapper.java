package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 16:00
 */
//存放有关 user 的接口
@Mapper
public interface UserMapper {

    //通过用户名查找用户
    User getUserByName(String username);

    //通过 用户id 获取 user 对象
    User getUserById(Integer userId);

    //添加用户
    Integer addUser(User user);

}
