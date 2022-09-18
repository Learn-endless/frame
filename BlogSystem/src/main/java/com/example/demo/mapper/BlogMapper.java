package com.example.demo.mapper;

import com.example.demo.model.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 17:29
 */
@Mapper
public interface BlogMapper {

    //通过 blogId 获取 blog 对象
    Blog getBlogById(Integer blogId);

    //查询所有文章信息
    List<Blog> getAllBlog();

    //添加一篇博客文章
    Integer addBlog(Blog blog);

    //删除博客
    Integer deleteBlog(Integer blogId);

    //通过 userId 查询博客文章
    List<Blog> getBlogByUserId(Integer userId);

}
