package com.example.demo.utils;

import com.example.demo.model.Blog;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-17
 * Time: 11:33
 */
@SpringBootTest
class UtilsTest {

    @Autowired
    private Utils utils;

    @Test
    void userBlogTop() {
        List<Blog> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JULY,25);
        Blog blog1 = new Blog(1,"三国演义","罗贯中",2,calendar.getTime());
        calendar.set(2022, Calendar.AUGUST,25);
        Blog blog2 = new Blog(2,"水浒传","施耐庵",2,calendar.getTime());
        calendar.set(2022, Calendar.SEPTEMBER,25);
        Blog blog3 = new Blog(3,"红楼梦","曹雪芹",2,calendar.getTime());
        calendar.set(2022, Calendar.OCTOBER,25);
        Blog blog4 = new Blog(4,"西游记","吴承恩",2,calendar.getTime());
        list.add(blog1);
        list.add(blog2);
        list.add(blog3);
        list.add(blog4);

        List<Blog> list1 = utils.userBlogTop(list);
        for (Blog blog:list1) {
            System.out.println(blog);
        }

    }
}