package com.example.demo.tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-29
 * Time: 9:49
 */
@SpringBootTest
class EncryptionToolTest {

    @Autowired
    private EncryptionTool encryptionTool;

//    @Test
//    void getPrivateKey() {
//        byte[] bytes = new byte[]{97,98,99,100};
//        EncryptionTool encryptionTool = new EncryptionTool();
//        Write write = new Write();
//
//        write.writePrivate(bytes);
//        String privateKey = encryptionTool.getPrivateKey();
//        System.out.println(privateKey);
//    }

}