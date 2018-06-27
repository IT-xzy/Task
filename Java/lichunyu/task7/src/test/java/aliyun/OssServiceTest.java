package aliyun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.impl.OssService;

import java.io.IOException;

/**
 * 文件上传下载
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class OssServiceTest {

    @Autowired
    OssService ossService;
    @Test
    public void test1() throws IOException {
        String bucketName = "lichunyu1234";
        String localFile = "E:\\images\\shinto.png";
//        ossDemo.putObject("lichunyu-data","ant",content);
//        ossDemo.createBucket(content);
//        System.out.println(ossDemo.putObject(content,"ant.png",object));
//        System.out.println(ossDemo.deleteObject(content,"ant"));
//        ossDemo.download2Local(content,"ant.png","D:");
        System.out.println(ossService.uploadFile(bucketName,"dir/shinto.png",localFile));
//        System.out.println(ossDemo.uploadFileStream(bucketName,"email.png",localFile));

//        ossDemo.createDirectory(bucketName,"dir/");
//        ossDemo.uploadMultipartFile(bucketName,"dir/ant.png",localFile);
//        System.out.println(ossDemo.download2Local(bucketName,"ant.png","E:/images/ant.png"));
//        System.out.println(ossDemo.downloadFileStream(bucketName,"ant.png"));

        ossService.listObjects(bucketName);
    }

}