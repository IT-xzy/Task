/*
package com.fml.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.net.URISyntaxException;


@Component
public class MyOSSClient{

    @Autowired
    OSSClient ossClient;

    @Value("${aliyun.oss.bucket.name}")
    private String bucketName;

    public void upload(String photoKey, MultipartFile photo) throws IOException, URISyntaxException {
        ossClient.putObject(bucketName, photoKey, new ByteArrayInputStream(photo.getBytes()));
        */
/*ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpeg");
        ossClient.putObject(bucketName, photoKey, photo.getInputStream(), metadata);*//*

        */
/*URL url = generateUrl(photoKey);
        URI uri = url.toURI();
        // 使用自己的域名替代阿里云提供的访问域名
        HttpHost httpHost = new HttpHost(mappingDomain);
        // 这个工具类是HttpClient里的，OSS-SDK本身就依赖这个jar包发送请求
        // 这里就可以拿这个工具类来用了
        URI mappingURI = URIUtils.rewriteURI(uri, httpHost);*//*


    }

    public void close(){
        ossClient.shutdown();
    }
}
*/
