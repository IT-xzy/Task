package com.jnshu.service.impl;

import com.jnshu.pojo.tool.Cos;
import com.jnshu.pojo.tool.Uploadphoto;
import com.jnshu.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author pipiretrak
 * @date 2019/6/2 - 12:06
 */
public class CosUploadServiceImp implements UploadService {
    @Autowired
    Cos cos;
    @Override
    public String photoUpload(String fileName, MultipartFile multipartFile) throws IOException {
        return cos.upload(fileName, multipartFile.getInputStream ());
    }
}
