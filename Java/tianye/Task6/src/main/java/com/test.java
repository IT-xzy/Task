package com;

import com.pojo.t_student;
import com.pojo.t_studentPro;
import org.junit.Before;
import com.DES.DESUtil;
import com.DES.MD5Util;
import com.token.Token;
import com.whalin.MemCached.MemCachedClient;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.testng.annotations.Test;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        MemCachedClient memCachedClient;
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-memcache.xml");
        memCachedClient = (MemCachedClient) context.getBean("memCachedClient");

        memCachedClient.set("name", "han");
        System.out.println(memCachedClient.get("name"));
    }
   public void listByName() throws Exception{
       DESUtil desUtil=new DESUtil();
       long loginTime=System.currentTimeMillis();
       String str1=desUtil.encryptFromLong(loginTime);
       System.out.println(str1);
       long str2=desUtil.decryptToLong(str1);
       System.out.println("l"+str2);
       System.out.println(desUtil.encrypt("shiaolin"));
       Token token =new Token();
       String tokenSrcData = loginTime +"/"+ "shiaolin";
       System.out.println(tokenSrcData);
       String str3 = desUtil.encrypt(tokenSrcData);
       System.out.println(str3);
       System.out.println(desUtil.decrypt(str3));
       String str4 = "shiaolin222" + "!!!!!!!!";
       System.out.println(MD5Util.stringToMD5(str4));
       System.out.println(MD5Util.stringToMD5("wanan"+"!!!abc"));
   }
    MemCachedClient memCachedClient;

    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:test.xml");
        memCachedClient = (MemCachedClient) context.getBean("memCachedClient");
    }

    public void TestMem() {
            memCachedClient.set("name", "han");
            System.out.println(memCachedClient.get("name"));


    }


}
