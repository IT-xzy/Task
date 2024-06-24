package com.jnshu.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.IOException;

public class TengxunUtil {
    public TengxunUtil(String secretId, String secretKey, String region_name, String bucketName) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        this.region_name = region_name;
        this.bucketName = bucketName;
    }

    private String secretId;
    private String secretKey;
    private String region_name;
    private String bucketName;


    public boolean input(File file,String key) throws IOException {

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        Region region = new Region(region_name);
        ClientConfig clientConfig = new ClientConfig(region);

        COSClient cosClient = new COSClient(cred, clientConfig);


        try {

//            String key = file.getOriginalFilename();
//            InputStream a = file.getInputStream();
//            int b = a.available();
//            // 方法2 从输入流上传(需提前告知输入流的长度, 否则可能导致 oom)
//            FileInputStream fileInputStream = (FileInputStream) a;
//            ObjectMetadata objectMetadata = new ObjectMetadata();
//// 设置输入流长度
//            objectMetadata.setContentLength(b);
//// 设置 Content type, 默认是 application/octet-stream
//            objectMetadata.setContentType("application/pdf");
//            PutObjectResult putObjectResult = cosClient.putObject(bucketName, key, fileInputStream, objectMetadata);
//            String etag = putObjectResult.getETag();



            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
        }
        // 关闭客户端(关闭后台线程)
        cosClient.shutdown();
        return true;
    }
}
