package com.example.demo.mapper;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.example.demo.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-24
 * Time: 9:18
 */
@Slf4j
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void getUserById() {
        UserInfo user = userMapper.getUserById(1);
        log.info("用户对象信息："+user);
    }

    @Test
    void testGetUserById() {
        UserInfo admin = userMapper.getUserByName("'or 1 = '1");
        log.info("用户信息："+admin);
    }

    @Test
    void getUserByNameLike() {
        List<UserInfo> users =
                userMapper.getUserByNameLike("m");
        log.info("用户列表信息："+users.get(0));
    }

    @Test
    void getUserById2() {
        UserInfo user = userMapper.getUserById2(1);
        log.info("用户信息："+user);
    }

    @Test
    void getUserById3() {
        UserInfo user = userMapper.getUserById3(1);
        log.info("用户信息："+user);
    }

    @Test
    void addUser() {
        UserInfo user = new UserInfo();
        user.setName("李四");
        user.setPassword("123");
//        user.setPhoto("123.png");
        Integer integer = userMapper.addUser(user);
        log.info("影响行数为："+integer);
    }

    @Test
    void getUserOrAll() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(2);
        userInfo.setName("张三");
        userInfo.setPassword("123");
        List<UserInfo> users = userMapper.getUserOrAll(userInfo);
        log.info("用户查询信息："+users);
    }

    @Test
    void test(){
        RSA rsa = new RSA();
        //获取公钥和私钥
        rsa.getPublicKey();
        String publicKeyBase64 = rsa.getPublicKeyBase64();
        rsa.getPrivateKey();
        String privateKeyBase64 = rsa.getPrivateKeyBase64();
        System.out.println("-----------");
        System.out.println(publicKeyBase64);
        System.out.println("-----------");
        System.out.println(privateKeyBase64);

        String content = "123456";
        //加密
        byte[] encrypt = rsa.encrypt(content, KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

        System.out.println(StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

    }

    @Test
    void updateUserById() {
        UserInfo user = new UserInfo();
        user.setId(3);
        user.setName("王五");
        user.setPassword("888888");
        user.setPhoto("666.jpg");
        Integer integer = userMapper.updateUserById(user);
        log.info("被修改的行数："+integer);


    }

    @Test
    @Transactional
    void delUserById() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Integer integer = userMapper.delUserById(ids);
        log.info("被删除的行数："+integer);
    }
}