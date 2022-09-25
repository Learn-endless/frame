package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import com.example.demo.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 9:04
 */
@Mapper
public interface UserMapper {

    //通过 id 查询用户对象
    public UserInfo getUserById(@Param("id") Integer id);

    //通过 username 来查询用户对象
    public UserInfo getUserByName(@Param("name") String username);

    //通过 name 来查询用户对象（模糊查询）
    public List<UserInfo> getUserByNameLike(@Param("name") String username);

    //通过 id 来查询用户对象（解决字段名和属性名不一致的问题）
    public UserInfo getUserById2(@Param("id")Integer id);

    //通过 id 来查询用户对象所包含的文章信息
    public UserInfo getUserById3(@Param("id")Integer id);

    //添加用户信息（动态sql中的trim标签的使用）
    public Integer addUser(UserInfo userInfo);

    //根据所传的参数查询一条或多条用户信息(动态标签中的 where 使用)
    public List<UserInfo> getUserOrAll(UserInfo userInfo);

    //根据所传参数修改用户信息（动态标签中的 set 使用）
    public Integer updateUserById(UserInfo userInfo);

    //根据所传参数批量删除用户信息（动态标签中的 foreach 使用）
    public Integer delUserById(List<Integer> ids);

}
