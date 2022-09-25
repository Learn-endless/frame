package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 15:49
 */
@Mapper
public interface ArticleMapper {
    //多表联查：一对一情况,一篇文章只对应一个用户信息
    public ArticleInfo getArticleById(@Param("id")Integer id);

    //使用动态 sql 来添加一条数据（if标签）
    public int addArticle(ArticleInfo articleInfo);

}
