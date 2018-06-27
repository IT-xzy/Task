package com.jnshu.utils;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class OSSUtil {
    private static Logger logger = Logger.getLogger(OSSUtil.class);
    // endpoint是访问OSS的域名。
    private static String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    // accessKeyId和accessKeySecret是OSS的访问密钥。
    private static String accessKeyId = "LTAIOpAzzQ9Rrkk3";
    private static String accessKeySecret = "SbxZy7hDyKNWxBEhG1fqMUpQy5tmry";
    // Bucket用来管理所存储Object的存储空间。
    private static String bucketName = "aes65";
    // Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件。
    //private static String firstKey = null;

    public static OSSClient getossClient() {
        OSSClient ossClient = null;
        if (ossClient == null) {
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        return ossClient;
    }

    // 把字符串存入OSS，Object的名称为firstKey。
    public static void putZF(String filename, String content) {
        InputStream is = new ByteArrayInputStream(content.getBytes());
        getossClient().putObject(bucketName, filename, is);
    }

    //文件流形式上传文件
    public static void putFiles(String filename, InputStream inputStream) throws IOException {
        getossClient().putObject(bucketName, filename, inputStream);
    }

    //文件流形式下载文件
    public static void downFile(String filename) throws IOException {
        getossClient().getObject(new GetObjectRequest(bucketName, filename), new File(filename));
    }

    //下载文件
    public static InputStream down(String filename) throws IOException {
        // 创建OSSClient实例
        OSSObject ossObject = getossClient().getObject(bucketName, filename);
        // 读Object内容
        InputStream in = ossObject.getObjectContent();
        return in;
    }

    //文件流形式上传文件
    public static void shutdownClient() throws IOException {
        getossClient().shutdown();
    }

    //遍历阿里云所有文件
    public static ObjectListing getall() {
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // 列出Object
        ObjectListing listing = getossClient().listObjects(listObjectsRequest);
        return listing;
    }

    //查找阿里云是否存在文件
    public static Boolean checkFile(String filename) {
        if (getossClient().getObject(bucketName, filename).getKey().equals(filename)) {
            return true;
        }
        return false;
    }
}
