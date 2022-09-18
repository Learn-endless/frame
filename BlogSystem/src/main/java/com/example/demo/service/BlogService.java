package com.example.demo.service;

import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.PageViewMapper;
import com.example.demo.model.Blog;
import com.example.demo.model.PageView;
import com.example.demo.model.User;
import com.example.demo.utils.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jnlp.IntegrationService;
import java.util.HashMap;
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

    @Resource
    private PageViewMapper pageViewMapper;

    //查询 博客（一篇或所有） 文章信息
    public Object getBlogAllOrOne(Integer blogId){
        //分情况进行业务逻辑的处理
        if(blogId == null){
            //表示需要查询所有文章
            List<Blog> list = blogMapper.getAllBlog();
            //处理博客列表页显示前50个字符
            list = utils.dealWithBlog(list);

            //用户须知置顶
            list = utils.userBlogTop(list);

            return list;
        }else{
            //表示需要查询一篇文章
            return blogMapper.getBlogById(blogId);
        }
    }

    //添加一篇博客文章
    public String addBlog(Blog blog){

        Integer integer = blogMapper.addBlog(blog);
        if(integer == 0){
            //表示插入失败了
            return "redirect:/param_error.html";
        }
        //在访问量表中添加相对应的数据
        Integer result = pageViewMapper.addPageView(blog.getBlogId());
        if(result == 0){
            //表示插入失败了
            return "redirect:/param_error.html";
        }
        return "redirect:/blog_list.html";
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

    //获取总访问量
    public HashMap<String,Object> getAllPageView(){
        long result = 0;
        //调用接口获取数据库中的值
        List<PageView> list = pageViewMapper.getAllPageView();
        for (PageView p:list) {
            result += p.getNumber();
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("total",result);
        return map;
    }

    //获取所有文章数
    public HashMap<String,Object> getBlogNumber(){
        List<Blog> list = blogMapper.getAllBlog();
        HashMap<String,Object> map = new HashMap<>();
        map.put("number",list.size());
        return map;
    }

    //通过 blogId 来增加博客的访问量
    public HashMap<String,Object> addBlogPageViewById(Integer blogId){

        HashMap<String,Object> map = new HashMap<>();
        //1. 获取访问量
        PageView pageView = pageViewMapper.getPageViewById(blogId);
//        System.out.println(blogId + "这是一个排查原因的问题：++++++++++++++++++++:"+pageView);
        //2. 增加访问量
        Integer integer = pageViewMapper.addBlogPageViewById(blogId, pageView.getNumber() + 1);
        if(integer.equals(1)){
            map.put("number",pageView.getNumber()+1);
            return map;
        }else{
            return map;
        }
    }

    //通过 blogId 和 userId 获取 文章数 和 单篇访问量
    public HashMap<String,Object> getAuthorMessage(Integer userId,Integer blogId){
        HashMap<String,Object> map = new HashMap<>();
        //1. 获取文章数
        List<Blog> list = blogMapper.getBlogByUserId(userId);
        map.put("art",list.size());
        //2. 获取单篇访问量
        PageView blog = pageViewMapper.getPageViewByBlogId(blogId);
        map.put("page",blog.getNumber());
        return map;
    }
}
