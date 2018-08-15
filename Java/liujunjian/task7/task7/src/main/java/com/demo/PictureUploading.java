package com.demo;

import com.aliyun.oss.OSSClient;

import java.io.FileInputStream;
import java.io.InputStream;

public class PictureUploading {
    private String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    private String accessKeyId = "LTAIKoecwxKxB3xy";
    private String accessKeySecret = "SrMZVPIydG6B6h7sL0lpXgBl4EteMz";

    public void uploading() throws Exception {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = new FileInputStream("D:\\image\\1.jpg");
        ossClient.putObject("my3631017", "乔帮主.jpg", inputStream);
        ossClient.shutdown();
    }

    public static void main(String[] args) throws Exception {
        PictureUploading uploading = new PictureUploading();
        uploading.uploading();
    }
}