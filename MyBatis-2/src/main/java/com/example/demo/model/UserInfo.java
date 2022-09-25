package com.example.demo.model;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 8:58
 */
@Data
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String photo;
    private String createtime;
    private String updatetime;
    private String state;
    private List<ArticleInfo> articleInfoList;
}
