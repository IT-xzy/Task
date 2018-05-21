package utils;


import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pojo.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;


@Component
public class Ossutils {
    @Autowired
    OSSClient ossClient;

    private static String bucketName = "eriri";

    private Logger logger = LoggerFactory.getLogger(Ossutils.class);

    public boolean uploadimage(MultipartFile multipartFile, User user,String fileName) {
        try {
            String result = null;
            InputStream inputStream = multipartFile.getInputStream();
            Long filesize = multipartFile.getSize();
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Prgma", "no-cache");
            objectMetadata.setContentEncoding("utf-8");
            objectMetadata.setContentType(getContentType(fileName));
            objectMetadata.setContentDisposition("filename/filesize=" + fileName + "/" + filesize + "Byte.");
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, inputStream, objectMetadata);
            result = putObjectResult.getETag();
            return true;
        }
        catch (Exception e){
            logger.error("图片上传失败"+e.getMessage(),e);
            return false;
        }
    }

    private static String getContentType(String fileName){
        //文件的后缀名
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

    //获得普通url
    public String getUrl(String key){
        Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
        URL url = ossClient.generatePresignedUrl(bucketName,key,expiration);
        if (url != null){
            logger.info("获取图片url成功"+url.toString());
            return url.toString();
        }
        return null;
    }

    //获得图片处理url（缩放）
    public String getCutUrl(String key){
        String style = "image/resize,m_fixed,w_100,h_100";
        Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethod.GET);
        req.setExpiration(expiration);
        req.setProcess(style);
        URL url = ossClient.generatePresignedUrl(req);;
        if (url != null){
            logger.info("获取裁剪图片url成功"+url.toString());
            return url.toString();
        }
        return null;
    }
}
