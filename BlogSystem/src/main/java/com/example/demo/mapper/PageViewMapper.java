package com.example.demo.mapper;

import com.example.demo.model.PageView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-18
 * Time: 10:31
 */
@Mapper
public interface PageViewMapper {

    //查询总访问量
    List<PageView> getAllPageView();

    //通过 博客ID 查询单篇博客访问量
    PageView getPageViewById(Integer blogId);

    //通过 博客ID 修改博客访问量(将原访问量变大)
    Integer addBlogPageViewById(Integer blogId, Long number);

    //通过 blogId 查询单篇博客访问量
    PageView getPageViewByBlogId(Integer blogId);

    //给新博客添加访问量数据
    Integer addPageView(Integer blogId);
}
