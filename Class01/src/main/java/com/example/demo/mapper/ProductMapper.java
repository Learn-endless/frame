package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-17
 * Time: 9:55
 */
@Mapper
public interface ProductMapper {

    //查询所有数据
    List<Product> findAll();

    //通过 name 分页 模糊 查询
    List<Product> findByName(Map<String,Object> map);


}
