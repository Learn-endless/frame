package com.example.demo.mapper;

import com.example.demo.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 21:59
 */
@SpringBootTest
class BlogMapperTest {

    @Resource
    private BlogMapper blogMapper;

    @Test
    void getBlogById() {
        Blog blog = blogMapper.getBlogById(2);
        System.out.println(blog);
    }


}