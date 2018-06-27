package com.jnshu.service.impl;

import com.jnshu.service.ServiceOSS;
import com.jnshu.tools.OssApiQiNiuYun;
import com.jnshu.tools.SdkTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @program: SSM_WEB_SERVER
 * @description: OSS 七牛云实现
 * @author: Mr.xweiba
 * @create: 2018-06-08 23:26
 **/
@Service
public class ServiceOSSQiniuImpl implements ServiceOSS{
    @Autowired
    OssApiQiNiuYun ossapi;

    @Autowired
    SdkTools sdkTools;

    @Override
    public Boolean updateFile(Integer id, MultipartFile multipartFile) {
        return ossapi.updateFile(id, multipartFile);
    }

    @Override
    public Boolean updateFile(Integer id, InputStream fi, String fileName, String fileType) {
        return ossapi.updateFile(id, fi, fileName, fileType);
    }

    @Override
    public Boolean updateFile(Integer id, byte[] bytes, String fileName, String fileType) {
        return ossapi.updateFile(id, bytes, fileName, fileType);
    }

    @Override
    public Boolean deleteFile(String keyFile) {
        return ossapi.deleteFile(keyFile);
    }

    @Override
    public Boolean deleteFile(String bucketname, String keyFile) {
        return ossapi.deleteFile(bucketname, keyFile);
    }

    // 文件迁移
    public Boolean fileRemoval(String bucketName, String fileUrl){
        return sdkTools.qiNiuFileToAliyun(bucketName, fileUrl);
    }
}
