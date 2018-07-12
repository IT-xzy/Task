package com.ptt.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.ptt.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * @ClassName: ALiYunOOSUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/13 17:02
 * @Version: 1.0
 */
@Component
public class ALiYunUtil {
    private static Logger logger = LoggerFactory.getLogger(ALiYunUtil.class);
    private static String endPoint;
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;
    private static String folder;

    @Value("${endPoint}")
    public void setEndPoint(String endPoint) {
        ALiYunUtil.endPoint = endPoint;
    }

    @Value("${accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        ALiYunUtil.accessKeyId = accessKeyId;
    }

    @Value("${accessKeySecret}")
    public void setAccessKeySecret(String accessKeySecret) {
        ALiYunUtil.accessKeySecret = accessKeySecret;
    }

    @Value("${bucketName}")
    public void setBucketName(String bucketName) {
        ALiYunUtil.bucketName = bucketName;
    }

    @Value("${folder}")
    public void setFolder(String folder) {
        ALiYunUtil.folder = folder;
    }


    public static OSSClient getOSSClient() {
        OSSClientBuilder clientBuilder = new OSSClientBuilder();
        return (OSSClient) clientBuilder.build(endPoint, accessKeyId, accessKeySecret);
    }

    /**
     * @Description: 上传后返回url
     * @return: java.lang.String
     * @Date: 2018/6/13 17:49
     */
    public static String uploadFile2OOS(OSSClient ossClient, File file, String name) {

        try {
            InputStream is = new FileInputStream(file);
            String fileName = name;//用户名作为存储的文件名
            Long fileSize = file.length();
            //文件描述
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());//is.available()返回值是byte[]，必须设置
            metadata.setContentEncoding("utf-8");//下载时的编码格式
            metadata.setContentType(getContentType(file.getName()));//设置contentType
            metadata.setContentDisposition("filename/fileSize=" + fileName + "/" + fileSize + "Byte.");//被下载时的提示
            //以文件流的形式上传文件
            ossClient.putObject(bucketName, folder + fileName, is, metadata);
            Long exp = new Date().getTime() + 31536000000L;
            Date expiration = new Date(exp);//过期时间一年
            URL url = ossClient.generatePresignedUrl(bucketName, folder + fileName, expiration);//获取url
            ossClient.shutdown();
            if (url != null)
                return url.toString();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return null;
    }

    /**
     * @Description: 通过文件名得到contentType，默认是image/jpeg
     * @return: java.lang.String
     * @Date: 2018/6/13 17:39
     */
    public static String getContentType(String fileName) {

        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)
                || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }

    /**
     * @Description: 发送短信
     * @return: java.lang.Integer
     * @Date: 2018/6/21 14:45
     */
    public static Integer sendShortMessage(Long tel, String message) {
        int result;
        //设置超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        final String product = "Dysmsapi";//短信API产品名称
        final String domain = "dysmsapi.aliyuncs.com";//短信API域名

        //初始化Client
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        try {
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
            //DefaultAcsClient是IAcsClient的实现类，通过DefaultAcsClient的构造方法实例IAcsClient
            IAcsClient acsClient = new DefaultAcsClient(profile);
            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);//请求方法
            request.setPhoneNumbers(tel.toString());//电话号码（String），1000个以下，用“，”分隔
            request.setSignName("晋良金");//短信签名
            request.setTemplateCode("SMS_137740281");//短信模板（验证码）
            request.setTemplateParam("{\"code\":\"" + message + "\"}");
/*            request.setTemplateCode("SMS_137667389");//短信模板（内容）
            request.setTemplateParam("{\"name\":\""+ message +"\",\"date\":\""+
                    TimeTransferUtil.dateFormat(new Date()) +"\"}");*/
            SendSmsResponse response = acsClient.getAcsResponse(request);
            if (response.getCode() != null && response.getCode().equals("OK")) ;
            {
                result = 0;
                logger.info("短信发送成功，{}", response.getMessage());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("发送短信异常：{}", e.getMessage());
        }
        result = 1;
        return result;
    }

    /**
     * @Description: 通过数据库中存储的String URL下载阿里云OSS中相对应的头像。
     * @return: void
     * @Date: 2018/6/21 19:35
     */
    public static void download(Student student) {
        String path = student.getName() + ".jpeg";
        File file = new File(path);
        try {
            URL url = new URL(student.getProfilePhoto());
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream(file);
            int count = 0;
            byte[] bytes = new byte[1024 * 1024];
            while ((count = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, count);
            }
            inputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 使用阿里提供的API进行简单的文件下载，返回值是储存时设置的文件描述信息。
     * @return: com.aliyun.oss.model.ObjectMetadata
     * @Date: 2018/6/22 10:03
     */
    public static ObjectMetadata downloadByOOSClient(Student student, OSSClient ossClient) {
        String objectName = folder + student.getName();
        String path = student.getName() + ".jpeg";
        String bucket = bucketName;
        try {
            File file = new File(path);
            return ossClient.getObject(new GetObjectRequest(bucket, objectName), file);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("下载出错：{}", e.getMessage());
        }
        return null;
    }
}
