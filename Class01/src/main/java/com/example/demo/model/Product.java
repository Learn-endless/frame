package com.example.demo.model;

//封装  lombok插件 简化封装

import lombok.Data;

import java.util.Date;

@Data
public class Product {
   private Integer id;
   private String name;
   private Double price;
   private Date date;
   private Integer isHot;
   private String description;
   private Integer typeId;
}
