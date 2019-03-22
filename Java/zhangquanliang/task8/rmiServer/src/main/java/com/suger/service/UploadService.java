package com.suger.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 上传文件到对象存储
 * @author suger
 * @date 2018/12/31 16:48
 */
public interface UploadService {
    /**
     * 上传文件到阿里云对象存储
     * @param file
     * @return
     */
    String aliyunUploadFile(MultipartFile file);

}
