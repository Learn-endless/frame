package com.example.demo.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-28
 * Time: 18:35
 */
@Component
public class EncryptionTool {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public EncryptionTool(){
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String privateKey = getPrivateKey();
//        String publicKey = getPublicKey();
    }

//    // 字符流读取 私钥
//    private String getPrivateKey(){
//        StringBuilder s1 = new StringBuilder();
//        try(
//                Reader readerPri = new FileReader(Constant.PRIVATE_KEY_URL)
//        ){
//            while(true){
//                char[] bytes = new char[1024];
//                int read = readerPri.read(bytes);
//                if(read == -1){
//                    break;
//                }
//                String str = new String(bytes,0,read);
//                s1.append(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return s1.toString();
//    }
//
//    // 字符流读取 公钥
//    private String getPublicKey(){
//        StringBuilder s2 = new StringBuilder();
//        try(
//                Reader readerPub = new FileReader(Constant.PUBLIC_KEY_URL)
//        ){
//            while(true){
//                char[] bytes = new char[1024];
//                int read = readerPub.read(bytes);
//                if(read == -1){
//                    break;
//                }
//                String str = new String(bytes,0,read);
//                s2.append(str);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return s2.toString();
//    }

    // 非对称加密 加密
    public String encrypt(String password){
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    // 非对称加密 解密
    public boolean decrypt(String nowPassword,String oldPassword){
        return bCryptPasswordEncoder.matches(nowPassword,oldPassword);
    }
}
