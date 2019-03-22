package com.jnshu.task7.utils;

import com.jnshu.task7.beans.api.Picture;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Component
@Slf4j
public class TengXunCosClientUtil {

    private static TengXunCosClientUtil tengXunCosClientUtil;
    private static String bucketName = Picture.TENGXUNBUCKETNAME;
    private static String domainName = Picture.TENGXUNDOMAINNAME;

    @Resource
    private COSClient cosClient;

    @PostConstruct
    public void init(){
        tengXunCosClientUtil=this;
    }

    @NotNull
    public static String upload(MultipartFile file)throws IOException {
        InputStream inputStream = file.getInputStream();
        log.info("获取文件的流{}",inputStream);
        String key = file.getOriginalFilename();
        log.info("获取文件的名称{}",key);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,key,inputStream,new ObjectMetadata());
        tengXunCosClientUtil.cosClient.putObject(putObjectRequest);
        log.info("请求发送成功");

        tengXunCosClientUtil.cosClient.shutdown();
        String url = domainName + "/" + key;
        log.info("文件路径为 : " + url);
        return url;
    }

    public static void download(String localFlie){

        log.info("准备下载文件{}",localFlie);
        File downFile = new File(localFlie);
        log.info("下载到{}",downFile.getPath());
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName,localFlie);
        ObjectMetadata downOjectMeta = tengXunCosClientUtil.cosClient.getObject(getObjectRequest,downFile);
        tengXunCosClientUtil.cosClient.shutdown();
    }

}
