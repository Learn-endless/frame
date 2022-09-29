package com.example.demo.tools;


import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-28
 * Time: 18:35
 */
@Component
@Slf4j
public class EncryptionTool {

    @Value("${private.key.url}")
    private String privateKeyUrl;

    @Value("${public.key.url}")
    private String publicKeyUrl;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    private RSA rsa;


    // 字符流读取 密钥
    public String[] getKey(){
        String[] strings = new String[2];
        try(
                BufferedReader readerPri = new BufferedReader(new FileReader(privateKeyUrl));
                BufferedReader readerPub = new BufferedReader(new FileReader(publicKeyUrl))
           ){

            String readLine = null;
            StringBuilder sb = new StringBuilder();
            while ((readLine = readerPri.readLine()) != null) {
                sb.append(readLine);
            }
            strings[0] = sb.toString();

            sb.delete(0,sb.length());
            while ((readLine = readerPub.readLine()) != null) {
                sb.append(readLine);
            }
            strings[1] = sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    // 非对称加密 加密
    public String encrypt(String password){
        String[] key = getKey();

        log.info(key[0]);
        log.info(key[1]);


        rsa = new RSA(key[0],key[1]);
        String encode = bCryptPasswordEncoder.encode(password);
        byte[] decrypt = rsa.encrypt(encode, KeyType.PublicKey);
        String newEncode = Base64.encode(decrypt);
        return newEncode;
    }

    // 非对称加密 解密
    public boolean decrypt(String nowPassword,String oldPassword){
        String[] key = getKey();

        log.info(key[0]);
        log.info(key[1]);


        rsa = new RSA(key[0],key[1]);
        String result = rsa.decryptStr(oldPassword, KeyType.PrivateKey);
        boolean matches = bCryptPasswordEncoder.matches(nowPassword, result);
        return matches;
    }
}
