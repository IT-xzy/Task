package com.service;

import com.aliyun.oss.OSSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class OSS {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String path;
    private Logger logger = (Logger) LoggerFactory.getLogger(OSS.class);

    public void setEndpoint(String endpoint) {this.endpoint = endpoint;}

    public void setAccessKeyId(String accessKeyId) {this.accessKeyId =accessKeyId;}

    public void setAccessKeySecret(String accessKeySecret) {this.accessKeySecret = accessKeySecret; }

    public void setBucketName(String bucketName) { this.bucketName = bucketName;}

    public void setPath(String path) {this.path = path; }

    public void uppictrue(String pictureName){
        OSSClient ossClient = null;
        try {
            // 创建OSSClient实例
             ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 上传图片
            //path = "C:\\Users\\Blue\\Desktop\\task3gai-3\\src\\main\\webapp\\files\\niutao12.png"
            ossClient.putObject(bucketName, pictureName, new File(path + pictureName));
        }catch (Exception e){
            logger.info("上传图片失败");
        }finally {
            // 关闭client
            ossClient.shutdown();
        }
    }

}
