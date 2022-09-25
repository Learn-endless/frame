package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 15:59
 */
@Slf4j
@SpringBootTest
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getArticleById() {
        ArticleInfo article = articleMapper.getArticleById(2);
        log.info("文章信息："+article);
    }

    @Test
    void addArticle() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(101);
        articleInfo.setTitle("java后端开发");
//        articleInfo.setContent("hello word!");
        int result = articleMapper.addArticle(articleInfo);
        log.info("影响行数："+result);
    }
}