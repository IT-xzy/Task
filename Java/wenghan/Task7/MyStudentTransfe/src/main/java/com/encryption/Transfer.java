package com.encryption;

import java.io.InputStream;

public interface Transfer {
    //迁移图片
    public void TransferImage();
    //上传图片
    public void uploadImage(InputStream inputStream, String objectName);
    //获得连接
    public String getlLink();
}
