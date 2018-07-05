package com.fangyuyang.service;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public interface StorageService {
    String qiniuPictureSend(ObjectInputStream inputStream);
    void qiniuPictureMove();

   List<String> qiniuPictureShow();
    void aliyunPictureSend(ObjectInputStream inputStream);
    void aliyunPictureMove();
    List<String> aliyunPictureShow();

}
