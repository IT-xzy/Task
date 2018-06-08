package com.fangyuyang.service.strategy;

import com.fangyuyang.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;
@Component
public class QiniuOss implements Storage {
    @Autowired
    private StorageService storageService;

    public void operate(InputStream inputStream) {
        storageService.qiniuPictureSend(inputStream);

    }
}
