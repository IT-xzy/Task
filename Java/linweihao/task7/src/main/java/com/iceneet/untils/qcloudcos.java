package com.iceneet.untils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Component
public class qcloudcos {
    private static int APPID;
    private static String SecretId;
    private static String SecretKey;
    @Value("${Qcloud.Cos.APPID}")
    private void setAPPID(int appid){
        APPID = appid;
    }

    @Value("${Qcloud.Cos.SecretId}")
    private  void setSecretId(String secretId){
        SecretId = secretId;
    }

    @Value("${Qcloud.Cos.SecretKey}")
    private void getSecretKey(String secretKey){
        SecretKey = secretKey;
    }

    private static final String prefix = "https://test-1252825361.cos.ap-guangzhou.myqcloud.com/";

    public static COSClient init(){
        try{
            // 1 初始化用户身份信息(secretId, secretKey)
            COSCredentials cred = new BasicCOSCredentials(SecretId, SecretKey);
// 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            ClientConfig clientConfig = new ClientConfig(new Region("ap-guangzhou"));
// 3 生成cos客户端
            COSClient cosclient = new COSClient(cred, clientConfig);
// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            return cosclient;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
//文件
    public static PutObjectResult UploadFile(File file,String key){
        COSClient cosClient = init();
        String bucketname ="test-"+APPID;
        try {
            File localfile = file;
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketname,key,localfile);
            PutObjectResult objectResult = cosClient.putObject(putObjectRequest);
            cosClient.shutdown();
            return objectResult;
        }catch (Exception e){
            e.printStackTrace();
            cosClient.shutdown();
            return null;
        }
    }
    //下载文件
    public static ObjectMetadata DownloadFile(File file){
        COSClient cosClient =init();
        String bucketname ="test-"+APPID;
        String key = "upload_test.xml";
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketname, key);
        ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, file);
        cosClient.shutdown();
        return downObjectMeta;
    }

    public static String UploadStream(String key, InputStream input, ObjectMetadata metadata){
        COSClient cosClient = init();
        String bucketname ="test-"+APPID;
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketname,key,input,metadata);
            PutObjectResult objectResult = cosClient.putObject(putObjectRequest);
            cosClient.shutdown();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            cosClient.shutdown();
            return null;
        }
    }

    public static String getLink(){
        return prefix;
    }

        public static List<COSObjectSummary> GetCosObject(){
            COSClient cosClient = init();
            String bucketname ="test-"+APPID;

    // 获取 bucket 下成员（设置 delimiter）
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
            listObjectsRequest.setBucketName(bucketname);
    // 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
            listObjectsRequest.setPrefix("");
    // 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
            listObjectsRequest.setDelimiter("/");
    // 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
            listObjectsRequest.setMarker("");
    // 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
            listObjectsRequest.setMaxKeys(100);

            ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);
    // 获取下次 list 的 marker
            String nextMarker = objectListing.getNextMarker();
    // 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
            boolean isTruncated = objectListing.isTruncated();
            List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            for (COSObjectSummary cosObjectSummary : objectSummaries) {
    // 文件路径
                String key = cosObjectSummary.getKey();
    // 获取文件长度
                long fileSize = cosObjectSummary.getSize();
    // 获取文件ETag
                String eTag = cosObjectSummary.getETag();
    // 获取最后修改时间
                Date lastModified = cosObjectSummary.getLastModified();
    // 获取文件的存储类型
                String StorageClassStr = cosObjectSummary.getStorageClass();
            }

            return objectSummaries;
        }
}
