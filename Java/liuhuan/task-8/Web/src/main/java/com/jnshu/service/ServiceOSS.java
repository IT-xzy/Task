package com.jnshu.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ServiceOSS {
    // 上传
    Boolean updateFile(Integer id, MultipartFile multipartFile);
    Boolean updateFile(Integer id, InputStream fi, String fileName, String fileType);
    Boolean updateFile(Integer id, byte[] bytes, String fileName, String fileType);

    // 删除
    Boolean deleteFile(String keyFile);
    Boolean deleteFile(String bucketName, String keyFile);

    // 文件迁移
    Boolean fileRemoval(String bucketName, String fileUrl);
}
