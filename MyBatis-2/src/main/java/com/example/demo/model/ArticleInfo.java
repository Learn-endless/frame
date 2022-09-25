package com.example.demo.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 8:59
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private String createtime;
    private String updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
    private UserInfo userInfo;
}
