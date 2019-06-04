package com.jnshu.service.impl;

import com.aliyun.oss.OSS;
import com.jnshu.pojo.tool.AliyunOss;
import com.jnshu.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 12:17
 */
public class OssUploadServiceImp implements UploadService {

    @Autowired
    AliyunOss aliyunOss;
    @Override
    public String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {
        return aliyunOss.uploadImage (fileName, multipartFile.getInputStream ());
    }
}
