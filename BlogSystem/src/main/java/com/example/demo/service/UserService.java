package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            return "redirect:/isError.html";
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

        //5. 隐藏用户的 password ,并返回 用户信息
        user.setPassword("");

        return user;
    }
}
