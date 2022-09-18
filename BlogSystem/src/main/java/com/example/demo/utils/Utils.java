package com.example.demo.utils;

import com.example.demo.model.Blog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 18:29
 */

@Component
public class Utils {

    //处理博客列表显示前50个字符
    public List<Blog> dealWithBlog(List<Blog> list){
        List<Blog> res = new ArrayList<>();

        //遍历真个 博客 集合
        list.forEach(x->{
            //取出正文
            String str = x.getContent();
            //创建一个新的 Blog 对象
            Blog blog = new Blog();
            //判断正文是否只有50个字符
            if(str.length() >= 50){
                blog.setContent(str.substring(0,50)+"......");
            }else{
                blog.setContent(x.getContent());
            }
            //添加其他的属性
            blog.setBlogId(x.getBlogId());
            blog.setPostTime(x.getPostTime());
            blog.setTitle(x.getTitle());
            blog.setUserId(x.getUserId());
            //将博客对象添加到新的链表中
            res.add(blog);
        });

        return res;
    }


    //用户须知 置顶
    public List<Blog> userBlogTop(List<Blog> list){
        List<Blog> res = new ArrayList<>();
        for(Blog blog : list){
            if(blog.getBlogId() == 4){
                res.add(0,blog);
            }else{
                res.add(blog);
            }
        }
        return res;
    }
}
