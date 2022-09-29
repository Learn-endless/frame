package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-29
 * Time: 17:41
 */
@Mapper
public interface UserMapper {

    //增加用户
    int addUser(User name);
}
