package com.example.demo.mapper;

import com.example.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-17
 * Time: 10:01
 */

@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    void findAll() {
        List<Product> list = productMapper.findAll();
        list.forEach(x->{
            System.out.println(x);
        });
    }

    @Test
    void findByName() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","o");
        map.put("start",0);
        map.put("end",2);
        List<Product> list = productMapper.findByName(map);
        list.forEach(x->{
            System.out.println(x);
        });
    }
}