package jnshu.util;


import jnshu.pojo.RegisterAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.alibaba.druid.util.Utils.md5;

public class MD5 {
    public static List<String> getText(String input, RegisterAccount registerAccount){
//      生成盐值
//        String salt =sb.toString();
        String salt="";
        if (registerAccount==null) {
            salt = UUID.randomUUID().toString();
        }else {
            salt = registerAccount.getSalt();
        }

//      加盐加密
        String password = md5(new StringBuilder().append(input).append(salt).toString());

//      MD5算法额外运算将密文整合成48位置
        char[] ciphertext = new char[48];
        for (int i = 0; i < 48; i += 3) {
            ciphertext[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            ciphertext[i + 1] = c;
            ciphertext[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        List<String> lists = new ArrayList<>();
        lists.add(0,salt);
        lists.add(1,new String(ciphertext));

        return lists;
    }
}
