package com.DES;

////import com.auth0.jwt.interfaces.DecodedJWT;
////
////public class Main {
////
////    public static void main(String[] args) {
////        // 生成token
////        TokenUtil encrypt = new TokenUtil();
////        String token = encrypt.getToken("asong");
////
////        // 打印token
////        System.out.println("生成的token: " + token);
////
////
////
////        // 解密token
////        Decrypt decrypt = new Decrypt();
////        DecodedJWT jwt = decrypt.deToken(token);
////
////       System.out.println("issuer签发者: " + jwt.getIssuer());
////        System.out.println("username: " + jwt.getClaim("username").asString());
////      //  System.out.println("name:     " + jwt.getClaim("name").asString());
////        System.out.println("过期时间：      " + jwt.getExpiresAt());
////
////    }
////
////}

public class Zmain {

    // 测试主函数
    public static void main(String args[]) {
        // 原文
        String plaintext = "baichensong520";
        //  plaintext = "123456";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));

        // 获取加盐后的MD5值
        String ciphertext = MD5Util.generate(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, ciphertext));
//        /**
//         * 其中某次DingSai字符串的MD5值
//         */
//        String[] tempSalt = { "e7008648a31a029962e57a2c08150036c390d15d6c076731", "26438a20040162e50c38c275579278d21b6588312ea2d24c","19e065a89427a26e1d75ef04e2fb58a5a588845c22280a38"};
//
//        for (String temp : tempSalt) {
//            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
//        }

    }
}