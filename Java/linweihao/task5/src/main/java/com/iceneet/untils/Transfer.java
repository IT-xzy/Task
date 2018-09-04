package com.iceneet.untils;

import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;

import java.io.InputStream;

public interface Transfer {
    //上传图片
    public String UploadStream(String key, InputStream inputStream, ObjectMetadata metadata);
    public String getLink();
}
