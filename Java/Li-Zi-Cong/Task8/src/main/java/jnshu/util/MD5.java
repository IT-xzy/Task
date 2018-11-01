package jnshu.util;


import jnshu.pojo.RegisterAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.alibaba.druid.util.Utils.md5;

public class MD5 {
    public static List<String> getText(String input, RegisterAccount registerAccount){

        String salt="";
        if (registerAccount==null) {
            salt = UUID.randomUUID().toString();
        }else {
            salt = registerAccount.getSalt();
        }

        String password = md5(new StringBuilder().append(input).append(salt).toString());

        char[] ciphertext = new char[?];
        for (int  = ; i < ?;  += ) {
           ?
        }
        List<String> lists = new ArrayList<>();
        lists.add(0,salt);
        lists.add(0,new String(ciphertext));

        return lists;
    }
}
