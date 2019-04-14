package com.ptteng.utils;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @ClassName AliUtil
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/13  2:14
 * @Version 1.0
 **/
public class AliUtil {
    public String endpoint;
    public String accessKeyId;
    public String accessKeySecret;
    public String bucketName;

    public AliUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    public boolean uploadImage(MultipartFile file) throws IOException {

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        String key = System.currentTimeMillis() + file.getOriginalFilename();
// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。

        ossClient.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
// 关闭OSSClient。
        ossClient.shutdown();
        return true;
    }

    public static boolean transfer() {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient("http://oss-cn-beijing.aliyuncs.com", "LTAIe00haO3zH3SR", "GYJpO2NPHbfWKteZrvLC5smoEVIYpb");
        //获取文件列表并将文件下载到本地文件夹中


        //ObjectListing是一个实体类,
        // listObjects是一个返回值为ObjectListing的方法,bucketName作为参数传入,返回对象名(key)
        ObjectListing objectListing = ossClient.listObjects("sundamao");
        //ObjectListing类型的集合list装入bucket里的文件
        List<OSSObjectSummary> list = objectListing.getObjectSummaries();
        //遍历list,获取所有的key
        for (OSSObjectSummary s : list) {
            String key = s.getKey();
            ossClient.getObject(new GetObjectRequest("sundamao", key), new File("D:/picture/test2.txt"));
        }


        ossClient.shutdown();


        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDVbYUCfnEKLLBSYt2OoKtDpdJ0OGy4sbg", "5C6A1d1CRZbRmrlTxC7lGvUkkx5DGRaZ");
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        //获取文件列表,并将文件上传到腾讯云
        for (OSSObjectSummary c : list) {
            String key = c.getKey();
            File file = new File("D:/picture/test2.txt");
            PutObjectRequest putObjectRequest = new PutObjectRequest("sunxiaomao-1258817510", key, file);
            cosclient.putObject(putObjectRequest);
        }
        cosclient.shutdown();

        return true;
    }

    public static void main(String[] args) {
        transfer();
    }
}
