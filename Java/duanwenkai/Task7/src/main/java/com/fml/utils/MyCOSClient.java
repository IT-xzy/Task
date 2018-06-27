package com.fml.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class MyCOSClient {
    @Autowired
    BasicCOSCredentials basicCOSCredentials;
    @Autowired
    ClientConfig clientConfig;
    @Autowired
    COSClient cosClient;
    @Autowired
    ObjectMetadata objectMetadata;

    @Value("${qclound.cos.bucket.name}")
    private String bucketName;

    public void upload(String key, InputStream input){
        cosClient.putObject(bucketName, key, input, objectMetadata);
    }
    public void close(){
        cosClient.shutdown();
    }
}
