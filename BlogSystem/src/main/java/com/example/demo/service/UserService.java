package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 16:10
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private BlogMapper blogMapper;

    //用来处理用户登录业务
    public String userLogin(String username, String password, HttpServletRequest request){
        //1. 先调用接口查找 user 对象
        User user = userMapper.getUserByName(username);
        //2. 校验查找到的数据是否正确
        if(user == null || !password.equals(user.getPassword())){
            return "redirect:/is_error.html";
        }
        //3. 创建一个session,并将用户信息放到里面
        HttpSession session = request.getSession(true);
        //4. 将密码隐藏掉
        user.setPassword("");
        //5. 添加用户信息到 session 中
        session.setAttribute("user",user);
        //6. 重定向到 blog_list.html 页面
        return "redirect:/blog_list.html";
    }


    //通过 blogId 获取 user 对象
    public Object getAuthorByBlogId(Integer blogId){
        //1. 根据 blogId 获取 blog 对象
        Blog blog = blogMapper.getBlogById(blogId);
        //2. 判断对象是否为空
        if(blog == null || blog.getBlogId() == 0){
            //表示  无法查到该博客!
            return new Object();
        }
        //3. 通过 blog 对象,查询 Author 信息
        User user = userMapper.getUserById(blog.getUserId());
        //4. 判断user对象是否存在
        if(user == null || user.getUserId() == 0){
            //表示无法查到该用户信息!
            return new Object();
        }

        //5. 使用HasMap的方式返回自定义数据，方便详情页显示 作者文章数 和 单篇访问量
        HashMap<String,Object> map = new HashMap<>();
        map.put("userId",user.getUserId());
        map.put("username",user.getUsername());
        map.put("blogId",blog.getBlogId());
        return map;
    }

    //用户注册功能
    public Object addUser(HttpServletRequest request,String username,String password){

        //创建一个对象，方便使用
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //调用接口添加用户
        Integer integer = userMapper.addUser(user);
        if(integer.equals(0)){
            //表示添加失败
            return new Object();
        }else{
            //获取session
            HttpSession session = request.getSession(true);
            //清除密码
            user.setPassword("");
            //将用户信息存放到session中
            session.setAttribute("user",user);
            //直接返回user对象
            return user;
        }
    }
}
