package com.student.util;

import com.qiniu.common.QiniuException;
import com.qiniu.storage.model.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class QiNiuUtilTest {
    //    @Resource
//    private QiNiuUtil qiNiuUtil;
    @Resource()
    private ContextSpringFactory contextSpringFactory;
//    @Resource
//    private OSSUtil ossUtil;
    private static final Logger log = LoggerFactory.getLogger(QiNiuUtilTest.class);

    @Test
    public void listBucket() {
    }

    @Test
    public void listFileOfBucket() {
    }

    @Test
    public void uploadFile() {
    }

    @Test
    public void getFileAccessUrl() {
    }

    @Test
    public void uploadFile1() {
        try {
            FileInputStream fileInputStream=new FileInputStream("D:\\student1.sql");
            try {
                contextSpringFactory.uploadFile(fileInputStream,"hahaha");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findFiles() {
    }

    @Test
    public void findFiles1() {

    }

//    @Test
//    public void QiNiuYunToOSS() throws IOException {
//        try {
//            FileInfo[] infos = qiNiuUtil.findFiles();
//            for (FileInfo info : infos) {
//                System.out.println(info.key);
//
//                InputStream inputStream = storage.download(info.key);
//                storage.uploadFile(inputStream, info.key);
//            }
//        } catch (QiniuException e) {
//            e.printStackTrace();
//        }
//
//    }
}