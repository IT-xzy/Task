package com.jnshu;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.IOException;

public class AtoT {

    public static void main(String[] args) throws IOException {

        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI5d3MqgDWxHmX";
        String accessKeySecret = "Il7UEruBHnvCUr7nO4HEqVaEupeSHE";

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String bucketName = "baidongn";


        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        // 设置 bucket 名称
        listObjectsRequest.setBucketName(bucketName);
        // prefix 表示列出的 object 的 key 以 prefix 开始
        listObjectsRequest.setPrefix("");
        // 设置最大遍历出多少个对象, 一次 listobject 最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        listObjectsRequest.setDelimiter("/");


        ObjectListing objectListing = ossClient.listObjects(listObjectsRequest);

        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            String key = objectSummary.getKey();

            ossClient.getObject(new GetObjectRequest(bucketName, key), new File("D:/picture/task1.txt"));
        }

// 关闭OSSClient。
        ossClient.shutdown();


        String secretId = "AKIDxqTu54KX5R2SdZeix2zhCRUHuIWbi4RZ";
        String secretKey = "0oNgpmWBakeZEaomUvBCxSjohcIE4f18";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);

        COSClient cosClient = new COSClient(cred, clientConfig);


        File localFile = new File("D:/picture/task1.txt");
        String bucketNam = "baidongn-1259580823";
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            String key = objectSummary.getKey();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketNam, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        }

        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();


    }
}
