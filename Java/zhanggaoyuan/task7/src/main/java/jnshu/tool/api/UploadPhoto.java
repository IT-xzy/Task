package jnshu.tool.api;

import jnshu.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class UploadPhoto {

    public static String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext ("springConfig/spring-mybatis.xml");
        StrategyService upload=(StrategyService) context.getBean ("photoUpload");
       return upload.photoUpload (fileName, multipartFile);
    }

}
