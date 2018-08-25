package com.task8.util;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Create by SongWu on 2018/8/4
 */
@Component
public class ImageUtil {

    @Value("${endpoint}")
    String endpoint;
    @Value("${accessKeyId}")
    String accessKeyId;
    @Value("${accessKeySecret}")
    String accessKeySecret;


//  static   String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//   static String accessKeyId = "LTAIuCh2DuJng506";
//  static   String accessKeySecret = "cTjirAcjGdvmFoMt3Rk5oRZm9TBvWS";


    // 创建OSSClient实例。
    public  String sendImg() throws IOException {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = new FileInputStream("E:\\ideal-workspace（copy）\\task8\\SpringMVCT（task8）\\src\\main\\webapp\\img\\IT修真院.gif");
        ossClient.putObject("songwu", "测试.gif", inputStream);

        // 设置URL过期时间
        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24*60);
// 获取上传的图片的URL
        URL url = ossClient.generatePresignedUrl("songwu",  "2.gif", expiration);

        // 关闭OSSClient
        ossClient.shutdown();
        return url.toString();
    }

    public String sendImg2(MultipartFile file, String username) throws IOException {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        InputStream inputStream = new ByteArrayInputStream(file.getBytes());

        String fileName = file.getOriginalFilename();

        String prefix = fileName.substring(fileName.lastIndexOf("."));

        ossClient.putObject("songwu", username + prefix, inputStream);

        Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 *60);

        URL url = ossClient.generatePresignedUrl("songwu", username + prefix, expiration);

        ossClient.shutdown();
        return url.toString();
    }


}
