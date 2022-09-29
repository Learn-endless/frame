package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-29
 * Time: 17:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/add")
    public int addUser(User user){
        if(user == null || !StringUtils.hasLength(user.getName())
        || !StringUtils.hasLength(user.getPassword())){
            return 0;
        }

        // 获取事务（开启事务）
        TransactionStatus transaction = dataSourceTransactionManager.getTransaction(transactionDefinition);

        // 执行数据库操作
        int result = userService.addUser(user);
        System.out.println("受影响的行数："+result);

        // 提交或回滚事务
        dataSourceTransactionManager.commit(transaction);

//        dataSourceTransactionManager.rollback(transaction);

        return result;
    }
}
