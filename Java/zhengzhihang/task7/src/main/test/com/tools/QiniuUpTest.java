package com.tools;

import com.aliyuncs.exceptions.ClientException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class QiniuUpTest {

    @Autowired
    private QiniuUp qiniuUp;
    @Resource
    private AliMessage aliMessage;

    @Resource
    private AliEmail aliEmail;

    @Resource
    private AliUploadFile aliUploadFile;



//    @Test
//    public void uploadFile() {
//        InputStream f = null;
//        try {
//            f=new FileInputStream("/Users/a1/IdeaProjects/myStudent/src/main/webapp/WEB-INF/index.html");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        qiniuUp.uploadFile(f,"111");
//    }

    @Test
    public void sendMessage(){
        try {
            aliMessage.sendSms("13824429757","123");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void senEmail(){
        aliEmail.sample("13824429757@sina.cn","123123");
    }

    @Test
    public void testMap(){
        Map<String,String> map=new HashMap<>();
        map.put("ni", "s");
        System.out.println(map.get("ni"));

    }

    @Test
    public void alitransfer() {
        aliUploadFile.transfer();
    }

    @Test
    public void qiniuTransfer(){
        qiniuUp.transfer();
    }


}