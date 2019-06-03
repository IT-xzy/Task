package com.jnshu.pojo.tool;

import com.jnshu.service.UploadService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 12:03
 */
public class Uploadphoto {
    public static String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UploadService upload=(UploadService) context.getBean ("photoUpload");
        return upload.photoUpload (fileName, multipartFile);
    }
}
