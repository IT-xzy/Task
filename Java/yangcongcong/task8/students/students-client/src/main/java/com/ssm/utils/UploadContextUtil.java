package com.ssm.utils;

import java.io.InputStream;

//环境类
public class UploadContextUtil {

    private UploadStrategyDao uploadStrategyDao;

    public UploadContextUtil() {
    }

    public UploadContextUtil(UploadStrategyDao uploadStrategyDao) {
        this.uploadStrategyDao = uploadStrategyDao;
    }

    public int executeStrategy(String fileName, InputStream stream) throws Exception {
        return uploadStrategyDao.upload(fileName,stream);
    }
}
