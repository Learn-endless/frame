package com.example.demo.mapper;

import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-15
 * Time: 22:36
 */
@Mapper     //这个注解表示这个接口时 mybatis 的接口
public interface UserMapper {

    public UserInfo getUserById(@Param("id")Integer id);
}
