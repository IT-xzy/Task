package com.jnshu.service;


import java.io.InputStream;

public interface ServiceOSS {
    // 上传
/*    Boolean updateFileInputStream(Integer id, MultipartFile multipartFile);*/
    Boolean updateFileInputStream(Integer id, InputStream fi, String fileName, String fileType);
    Boolean updateFileByte(Integer id, byte[] bytes, String fileName, String fileType);

    // 删除
    Boolean deleteFileKey(String keyFile);
    Boolean deleteFileBucketname(String bucketname, String keyFile);

    // 文件迁移
    Boolean fileRemoval(String bucketName, String fileUrl);

}
