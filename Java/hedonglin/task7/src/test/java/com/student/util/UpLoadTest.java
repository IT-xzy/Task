package com.student.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UpLoadTest {

    @Resource
    private QiNiuUtil qiNiuUtil;

    @Test
    public void upload() {
//        UpLoad.upload();
    }

    @Test
    public void upLoadByInputStream() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream("D:\\百度阿.png");
        Assert.assertNotNull(inputStream);
        try {
            qiNiuUtil.uploadFile(inputStream,"sssaaa");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}