package com.suger.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.suger.pojo.OssBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * 阿里云OSS工具
 * @author suger
 * @date 2018/12/25 1:25
 */
public class AliyunOSSClientUtil {
  /*  @Autowired
    OssBean ossBean;*/
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");

    OssBean  ossBean= (OssBean) applicationContext.getBean(OssBean.class);

    private OSSClient oSSClient;

    public AliyunOSSClientUtil() {
        oSSClient = new OSSClient(ossBean.getEndpoint(),ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
    }

    /**
     * aliyun 简易上传工具
     * @param uploadFile 待上传的本地文件路径
     * @param savePathname 保存到对象存储的路径
     * @return 图片的url
     */
    public String uploadFile(String uploadFile,String savePathname){
        OSSClient ossClient = new OSSClient(ossBean.getEndpoint(), ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(ossBean.getBucketName(), savePathname);
            // 待上传的本地文件
            uploadFileRequest.setUploadFile(uploadFile);
            // 设置并发下载量，默认1
            uploadFileRequest.setTaskNum(5);
            // 设置分片大小，默认1000Kb
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // 开启断点续传，默认关闭
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
            System.out.println(multipartUploadResult.getLocation());
            return  multipartUploadResult.getLocation();

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return null;
    }
}
