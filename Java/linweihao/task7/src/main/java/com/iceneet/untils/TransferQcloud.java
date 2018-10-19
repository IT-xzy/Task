package com.iceneet.untils;

import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
@Service
public class TransferQcloud implements Transfer{

    private static TransferQcloud transferQcloud;


    @Override
    public String UploadStream(String key, InputStream inputStream, ObjectMetadata metadata) {
        return qcloudcos.UploadStream(key, inputStream, metadata);
    }

    @Override
    public String getLink() {
        return qcloudcos.getLink();
    }

}
