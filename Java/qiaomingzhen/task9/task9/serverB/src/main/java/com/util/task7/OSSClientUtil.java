package com.util.task7;
/*
 * @ClassName:OSSClientUtil
 * @Description:TODO
 * @Author qiao
 * @Date 2018/8/26 18:02
 **/


import com.aliyun.oss.OSSClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;


public class OSSClientUtil {

    private static Logger logger = Logger.getLogger(OSSClientUtil.class);
    private String bucketName = "qiaoxm";

    // 创建OSSClient实例。
    @Autowired
    private OSSClient ossClient;

    public URL uploadPicture(String key, File file) {

        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName, key, file);
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365);// 生成 URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }

    public URL uploadInputStream(String key, byte[] file) throws FileNotFoundException {
        InputStream inputStream = new ByteArrayInputStream(file);
        ossClient.putObject(bucketName, key, inputStream);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        Date expiration = new Date(new Date().getTime() + 3600 * 1000 * 24 * 365);// 生成 URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }

    private boolean isImage(InputStream imageFile) {
        Image img = null;
        try {
            img = ImageIO.read(imageFile);
            if (img == null || img.getWidth(null) <= 0 || img.getHeight(null) <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            img = null;
        }
    }

}