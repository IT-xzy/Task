package com.fangyuyang.service;

import java.io.InputStream;
import java.util.List;

public interface StorageService {
    String qiniuPictureSend(InputStream inputStream);
    void qiniuPictureMove();

   List<String> qiniuPictureShow();
    void aliyunPictureSend(InputStream inputStream);
    void aliyunPictureMove();
    List<String> aliyunPictureShow();

}
