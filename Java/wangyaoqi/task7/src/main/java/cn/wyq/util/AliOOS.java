package cn.wyq.util;

import cn.wyq.pojo.ClientProp;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

public class AliOOS {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    ClientProp clientProp= (ClientProp) applicationContext.getBean("clientProp");

    private Logger logger = Logger.getLogger(AliOOS.class);

    public void upload(String path, String fileName){
        String endpoint = clientProp.getEndpoint();
        String accessKeyId = clientProp.getAccessKeyId();
        String accessKeySecret = clientProp.getAccessKeySecret();
        String bucketName = clientProp.getBucketName();
        System.out.println(bucketName);
//         创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        logger.info("准备执行上传");

        logger.info(path);
//        path = ""
        // 上传文件流。
        PutObjectResult result = ossClient.putObject(bucketName,fileName,new File(path));
        logger.info(result);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public void send(String fileName, InputStream inputStream){
        String endpoint = clientProp.getEndpoint();
        String accessKeyId = clientProp.getAccessKeyId();
        String accessKeySecret = clientProp.getAccessKeySecret();
        String bucketName = clientProp.getBucketName();
        System.out.println(bucketName);
//         创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        ossClient.putObject(bucketName,fileName,inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
