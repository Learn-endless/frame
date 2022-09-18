package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-18
 * Time: 10:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageView {
    private Integer blogId;
    private Long  number;
}
