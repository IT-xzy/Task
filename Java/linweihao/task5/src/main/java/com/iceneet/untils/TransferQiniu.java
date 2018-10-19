package com.iceneet.untils;

import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

public class TransferQiniu implements Transfer{

    @Autowired
    private qiniuUtils qiniuUtils;

    @Override
    public String UploadStream(String key, InputStream inputStream, ObjectMetadata metadata) {
        return qiniuUtils.UploadStream(key, inputStream);
    }


    @Override
    public String getLink() {
        return qiniuUtils.getLink();
    }
}
