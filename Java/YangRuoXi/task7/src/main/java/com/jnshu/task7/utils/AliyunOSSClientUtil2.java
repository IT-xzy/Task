package com.jnshu.task7.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.jnshu.task7.beans.api.Picture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
@Slf4j
public class AliyunOSSClientUtil2 {

    /**
     * 阿里云所需配置
     */
    private static String endpoint = Picture.ENDPOINT;
    // accessKey
    /**
     * 阿里云所需配置
     */
    private static String accessKeyId = Picture.ACCESS_KEY_ID;
    //accessKeySecret
    /**
     * 阿里云所需配置
     */
    private static String accessKeySecret = Picture.ACCESS_KEY_SECRET;
    // Bucket名称
    /**
     * 阿里云所需配置
     */
    private static String bucketName = Picture.BACKET_NAME;
    // 文件存储目录
    /**
     * 阿里云所需配置
     */
    private static String filedir = Picture.FOLDER;

    /**
     * 获取阿里客户端对象
     * @return
     */
    public static OSSClient getOssClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     *
     * @param ossClient 阿里云存储的客户端对象
     * @param file 上传的文件
     * @return
     */
    public static String uploadObject(OSSClient ossClient, MultipartFile file){
        String resultStr = null;
        try {

            //获取流文件
            InputStream is = new FileInputStream(String.valueOf(file.getInputStream()));
            //文件名
            String fileName = file.getName();
            //文件的大小
            Long fileSize = file.getSize();
            //创建上传文件的metadata
            ObjectMetadata metadata = new ObjectMetadata();
            //设置长度
            metadata.setContentLength(is.available());
            //设置缓存行为
            metadata.setCacheControl("no-cache");
            //设置头信息
            metadata.setHeader("Pragma","no-cache");
            //设置字符编码
            metadata.setContentEncoding("utf-8");
            //设置上传文件的格式,即文件的格式
            metadata.setContentType(getContentType(fileName));
            //设置下载时的名称
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //流形式上传文件
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, filedir + fileName , is , metadata);
            resultStr = putObjectResult.getETag();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("上传图片出现异常" + e);
        }
        return resultStr;
    }

    public static String getContentType(String fileName){
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";

    }

    //测试
//    public static void main(String[] args) {
//        //初始化OSSClient
//        OSSClient ossClient = AliyunOSSClientUtil2.getOssClient();
//        //上传文件
//        String files = "D:\\Miku.jpg";
//        String[] file = files.split(",");
//        for (String filename : file) {
//            //System.out.println("filename:"+filename);
//            File filess = new File(filename);
//            String md5key = AliyunOSSClientUtil2.uploadObject(ossClient, filess, filedir);
//            log.info("上传后的文件MD5数字唯一签名:" + md5key);
//            //上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A
//        }


//    }

}
