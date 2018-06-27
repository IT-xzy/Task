package com.jnshu.service.impl;

import com.jnshu.service.ServiceOSS;
import com.jnshu.tools.OssApiALiYun;
import org.oasisopen.sca.annotation.Remotable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.InputStream;

/**
 * @program: SSM_WEB_SERVER
 * @description: OSS 阿里云实现
 * @author: Mr.xweiba
 * @create: 2018-06-08 23:11
 **/
@Service
@Remotable
public class ServiceOSSAliyunImpl implements ServiceOSS {

    @Autowired
    OssApiALiYun ossapi;

    // multipartFile格式上传
    /*@Override
    public Boolean updateFileInputStream(Integer id, MultipartFile multipartFile) {
        return ossapi.updateFileInputStream(id, multipartFile);
    }*/

    // InputStream 格式上传 必须填写文件类型
    @Override
    public Boolean updateFileInputStream(Integer id, InputStream inputStream, String fileName, String fileType) {
        return ossapi.updateFile(id, inputStream, fileName, fileType);
    }

    @Override
    public Boolean updateFileByte(Integer id, byte[] bytes, String fileName, String fileType) {
        return null;
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
        return null;
    }
}
