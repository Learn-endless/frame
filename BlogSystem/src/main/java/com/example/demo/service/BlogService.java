package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 17:52
 */
@Service
public class BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private Utils utils;

    //查询 博客（一篇或所有） 文章信息
    public Object getBlogAllOrOne(Integer blogId){
        //分情况进行业务逻辑的处理
        if(blogId == null){
            //表示需要查询所有文章
            List<Blog> list = blogMapper.getAllBlog();
            //处理博客列表页显示前50个字符
            list = utils.dealWithBlog(list);

            return list;
        }else{
            //表示需要查询一篇文章
            return blogMapper.getBlogById(blogId);
        }
    }

    //添加一篇博客文章
    public Integer addBlog(Blog blog){
        return blogMapper.addBlog(blog);
    }

    //博客删除
    public Integer deleteBlog(User user, Integer blogId){
        //1. 通过blogId获取blog对象
        Blog blog = blogMapper.getBlogById(blogId);
        //2. 判断blog是否是空对象
        if(blog == null){

            //0表示删除失败
            return 0;
        }
        //2. 检测文章作者和用户是否是同一个人
        if(!blog.getUserId().equals(user.getUserId())){

            //说明不是一个人，没有权限删除这篇博客
            return 0;
        }
        //3. 删除博客
        return blogMapper.deleteBlog(blogId);
    }
}
