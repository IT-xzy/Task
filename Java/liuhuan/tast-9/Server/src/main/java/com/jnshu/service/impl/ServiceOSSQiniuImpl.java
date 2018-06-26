package com.jnshu.service.impl;

import com.jnshu.service.ServiceOSS;
import com.jnshu.tools.OssApiQiNiuYun;
import com.jnshu.tools.SdkTools;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @program: SSM_WEB_SERVER
 * @description: OSS 七牛云实现
 * @author: Mr.xweiba
 * @create: 2018-06-08 23:26
 **/
@Service
@Remotable
public class ServiceOSSQiniuImpl implements ServiceOSS{
    @Autowired
    OssApiQiNiuYun ossapi;

    @Autowired
    SdkTools sdkTools;

    /*@Override
    public Boolean updateFileInputStream(Integer id, MultipartFile multipartFile) {
        return ossapi.updateFileInputStream(id, multipartFile);
    }*/

    @Override
    public Boolean updateFileInputStream(Integer id, InputStream fi, String fileName, String fileType) {
        return ossapi.updateFile(id, fi, fileName, fileType);
    }

    @Override
    public Boolean updateFileByte(Integer id, byte[] bytes, String fileName, String fileType) {
        return ossapi.updateFile(id, bytes, fileName, fileType);
    }

    @Override
    public Boolean deleteFileKey(String keyFile) {
        return ossapi.deleteFile(keyFile);
    }

    @Override
    public Boolean deleteFileBucketname(String bucketname, String keyFile) {
        return ossapi.deleteFile(bucketname, keyFile);
    }

    // 文件迁移
    public Boolean fileRemoval(String bucketName, String fileUrl){
        return sdkTools.qiNiuFileToAliyun(bucketName, fileUrl);
    }
}
