package com.student.util;

import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.student.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class OSSUtilTest {




    @Resource
    private ContextSpringFactory contextSpringFactory;



    private static final Logger log = LoggerFactory.getLogger(OSSUtilTest.class);

    @Test
    public void getOSSClient() {
    }

    @Test
    public void createBucket() {
    }

    @Test
    public void deletBucket() {
    }

    @Test
    public void uploadObject2OSS() {


    }

    @Test
    public void getOSS2InputStream() {
    }

    @Test
    public void deleteFile() {
    }

    @Test
    public void getContentType() {
    }

    @Test
    public void uploadObjectInputStream() {

        File file = new File("D:\\百度阿.png");

        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(String.valueOf(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            contextSpringFactory.uploadFile(fileInputStream, "hahahahahahahaxi.png");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void download() throws IOException {
        InputStream inputStream = contextSpringFactory.download("hahahahahahahaxi.png");
        System.out.println("下载下来的文件"+inputStream);


        FileOutputStream outputStream = new FileOutputStream("D:\\Java练习\\aaaaa.png");

        byte[] b = new byte[1024];
        int hasRead = 0;
        while ((hasRead = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, hasRead);
        }

        inputStream.close();
        outputStream.close();

    }


//    //阿里云迁移到七牛云
//    @Test
//    public void OSSToQiNiuYun() throws IOException {
//        ;
//        List<OSSObjectSummary> fileList= ossUtil.findFiles();
//        log.error("文件列表为{}",ossUtil.findFiles());
//        for (OSSObjectSummary fileName : fileList) {
//            String key=fileName.getKey();
//            System.out.println(key);
//            log.error("文件名为：{}",key);
//            InputStream inputStream= storage.download(key);
//
//
////                QiNiuUtil.uploadFile(inputStream, "hedonglin", key);
//                storage.uploadFile(inputStream,key);
//
//        }





//
////        log.info("文件列表的名称为：{}",list);
//    }

    //七牛云转阿里云
    @Test
    public void QiNiuToOSS() {

    }
}