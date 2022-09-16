package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 17:52
 */
@Controller
public class BlogController {

    @Resource
    private BlogService blogService;

    //获取所有的文章信息 和 获取单篇文章 信息
    @ResponseBody
    @RequestMapping(value = "/blog",method = RequestMethod.GET)
    public Object getBlogAll(Integer blogId){

        //2. 调用service的方法
        return blogService.getBlogAllOrOne(blogId);
    }

    //发布博客文章
    @RequestMapping(value = "/blog",method = RequestMethod.POST)
    public String addBlog(Blog blog, @SessionAttribute(value = "user",required = false)User user){
        //检测参数是否为null
        if(blog == null){
            //返回错误提示页面
            return "redirect:/paramError.html";
        }
        //检测文章内容和标题
        if(blog.getTitle()==null || "".equals(blog.getTitle()) || blog.getContent() == null || "".equals(blog.getContent())){
            return "redirect:/paramError.html";
        }
        //校验用户是否登录
        if(user == null){
            //表示用户未登录
            return "redirect:/paramError.html";
        }
        //将 author 放到 blog 对象中
        blog.setUserId(user.getUserId());
        //调用 service 层来添加博客文章
        Integer integer = blogService.addBlog(blog);
        if(integer == 0){
            //表示插入失败了
            return "redirect:/paramError.html";
        }
        return "redirect:/blog_list.html";
    }


    //博客删除
    @RequestMapping(value = "/deleteBlog",method = RequestMethod.GET)
    public String deleteBlog(@SessionAttribute(value = "user",required = false)User user,Integer blogId){
        //1. 再次检测用户是否登录
        if(user == null){
            return "redirect:/paramError.html";
        }
        //2. 检测blogId是否为null
        if(blogId == null || "".equals(blogId.toString())){
            return "redirect:/paramError.html";
        }
        //3. 调用service来进行业务处理
        Integer result = blogService.deleteBlog(user, blogId);
        //4. 检测是否删除成功
        if(result == 0){
            //表示删除失败
            return "redirect:/paramError.html";
        }
        //重定向到 博客 列表页
        return "redirect:/blog_list.html";
    }
}
