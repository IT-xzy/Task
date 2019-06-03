package com.jnshu.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 12:04
 */
public interface UploadService {
    String photoUpload(String fileName, MultipartFile multipartFile) throws IOException;
}
