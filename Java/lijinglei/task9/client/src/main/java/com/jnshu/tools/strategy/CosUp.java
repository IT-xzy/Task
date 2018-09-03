package com.jnshu.tools.strategy;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


public class CosUp implements Strategy {

//    @Autowired
//    COSClient cosClient;

    ApplicationContext build = new ClassPathXmlApplicationContext("spring-until.xml");

    COSClient cosClient = (COSClient) build.getBean("cosClient");




    @Override
    public String doUp(MultipartFile file, String trueFileName){
        String bucketName = "logic-1255663509";
        try {
            InputStream inputStream = file.getInputStream();
            int fileLength = (int) file.getSize();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(fileLength);
            System.out.println(bucketName+"||"+trueFileName+"||"+fileLength+"||"+inputStream+"||"+objectMetadata);

            cosClient.putObject(bucketName, trueFileName, inputStream, objectMetadata);
        } catch (IOException e) {
            return "腾讯云上传失败";
        }
        return "腾讯云上传成功";
    }
}