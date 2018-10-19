package com.service.thirdParty;
/*
 * @ClassName:OSSClientServiceImpl
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/13 13:05
 **/

import com.aliyun.oss.OSSClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class OSSClientServiceImpl implements OSSClientService {
    private static Logger logger = Logger.getLogger(OSSClientServiceImpl.class);
    private String bucketName = "qiaoxm";

    // 创建OSSClient实例。
    @Autowired
    private OSSClient ossClient;

    public URL uploadPicture(String key, File file) {

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName, key, file);
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365);// 生成 URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }

    public URL uploadInputStream(String key, byte[] file) {
        InputStream inputStream = new ByteArrayInputStream(file);
        ossClient.putObject(bucketName, key, inputStream);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365);// 生成 URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }

    @Override
    public void checkService() {

    }
}
