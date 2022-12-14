package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-16
 * Time: 16:01
 */
//用户实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private String password;
}
