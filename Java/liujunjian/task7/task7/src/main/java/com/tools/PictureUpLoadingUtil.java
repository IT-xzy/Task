package com.tools;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class PictureUpLoadingUtil {
    @Value("${picture.endpoint}")
    private String endpoint;
    @Value("${picture.accessKeyId}")
    private String accessKeyId;
    @Value("${picture.accessKeySecret}")
    private String accessKeySecret;

    public String upLoading(MultipartFile file, String username) throws IOException {
        //生成图片的字节流数组
        InputStream inputStream = new ByteArrayInputStream(file.getBytes());
        //创建上传客户端
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件的后缀名
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        //以用户名+后缀名的方式上传图片到阿里云oss
        ossClient.putObject("my3631017", username + prefix, inputStream);
        // 设置URL过期时间为10年  3600L*1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
        // 获取上传的图片的URL
        URL url = ossClient.generatePresignedUrl("my3631017", username + prefix, expiration);
        //关闭客户端
        ossClient.shutdown();
        return url.toString();
    }

}
