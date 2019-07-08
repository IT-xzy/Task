package com.jnshu;


import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;

public class TtoA {
    public static void main(String[] args) {

//腾讯
// 1 初始化用户身份信息（secretId, secretKey）。
        String secretId = "AKIDxqTu54KX5R2SdZeix2zhCRUHuIWbi4RZ";
        String secretKey = "0oNgpmWBakeZEaomUvBCxSjohcIE4f18";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);


        try {
            String bucket = "baidongn-1259580823";

//            批量操作
//            进行设置
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
            // 设置 bucket 名称
            listObjectsRequest.setBucketName(bucket);
            // prefix 表示列出的 object 的 key 以 prefix 开始
            listObjectsRequest.setPrefix("");
            // 设置最大遍历出多少个对象, 一次 listobject 最大支持1000
            listObjectsRequest.setMaxKeys(1000);
            listObjectsRequest.setDelimiter("/");


            ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);
            for (COSObjectSummary cosObjectSummary : objectListing.getObjectSummaries()) {
                // 对象的路径 key
                String key = cosObjectSummary.getKey();
//                // 对象的 etag
//                String etag = cosObjectSummary.getETag();
//                // 对象的长度
//                long fileSize = cosObjectSummary.getSize();
//                // 对象的存储类型
//                String storageClass = cosObjectSummary.getStorageClass();
                System.out.println("key:" + key + ";");

                File downFile = new File("D:/picture/task.txt");
                GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, key);
                ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
            }
            cosClient.shutdown();

//            阿里云

            String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";

            String accessKeyId = "LTAI5d3MqgDWxHmX";
            String accessKeySecret = "Il7UEruBHnvCUr7nO4HEqVaEupeSHE";

            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            for (COSObjectSummary cosObjectSummary : objectListing.getObjectSummaries()) {
                // 对象的路径 key
                String key = cosObjectSummary.getKey();
                File file = new File("D:/picture/task.txt");
                ossClient.putObject("baidongn", key, file);

            }
            ossClient.shutdown();
        }catch (CosServiceException serverException){
            serverException.printStackTrace();}catch (CosClientException clientException) {
            clientException.printStackTrace();
        }
    }
}