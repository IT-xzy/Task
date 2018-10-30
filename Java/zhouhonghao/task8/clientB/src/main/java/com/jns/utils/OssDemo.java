package com.jns.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.jns.entity.Oss;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.*;

public class OssDemo {
    static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    static Oss oss= (Oss) applicationContext.getBean("oss");
    static String endpoint =oss.getEndpoint();//访问地域
    static String accessKeyId = oss.getAccessKeyId();//访问秘钥id
    static String accessKeySecret = oss.getAccessKeySecret();//访问秘钥值
    static String folder=oss.getFolder();   //存在imgage文件夹下
    static String bucketName=oss.getBucketName();  //存储空间


    //oss初始化
    public  static OSSClient getOssClient(){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return ossClient;
    }


    //直接就图片上传至第三方,用来进行单一测试
    public void upload(OSSClient ossClient,String bucketName,String key,File file){
        // 上传文件。由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName,key,file);
        closeOosClient(ossClient);
    }


    //oss关闭
    public  static void closeOosClient(OSSClient ossClient){
        ossClient.shutdown();
    }


    //上传文件流
    public static String updInputStream(OSSClient ossClient,InputStream inputStream,String fileName) throws FileNotFoundException {
        // 上传文件流。
        PutObjectResult result = ossClient.putObject(bucketName, fileName, inputStream);
        String MD5Key = result.getETag();
        return MD5Key;
    }



    //图片上传至服务器
    public static String sendServer(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        System.out.println("getOriginalFilename:"+multipartFile.getOriginalFilename());
        System.out.println("getName:"+multipartFile.getName());

        //获取文件的原始名
        String fileName=multipartFile.getOriginalFilename();
        String newName=new Date().getTime()+ String.valueOf(fileName);
        //获取项目webapps所在的路径
        String pathRoot= request.getSession().getServletContext().getRealPath("");
        String path="/upload/pictures/"+newName;
        File file=new File(pathRoot+path);
        if(!file.getParentFile().exists()){
            //文件父目录不存在，则创建
            file.getParentFile().mkdirs();
        }
        if(!file.exists()){
            //文件不存在，则创建
            file.mkdirs();
        }
        //写入服务器
        multipartFile.transferTo(file);
        //返回图片的服务器路径
        return  pathRoot+path;
    }



    //获取图片的格式类型
    public static String getcontentType(String fileName) {
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



    //服务器上传到第三方API
    public static Map uploadFile2OSS(OSSClient ossClient, File file) {
        String ret ;
        Map map=new HashMap();
        try {
            String fileName=file.getName();
            InputStream inputStream=new FileInputStream(file);
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inputStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, folder + fileName,inputStream, objectMetadata);
            //放回一个唯一标签
            ret = putResult.getETag();
            map.put("md5Key",ret);
            map.put("key",folder+fileName);
        } catch (IOException e) {
            System.out.println("上传异常");
        }
        return map;
    }


    //获取第三方API图片路径
    public static String getUrl(OSSClient ossClient,String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);

        if (url != null) {
            return url.toString();
        }
        return null;
    }


    //获取bucketName所有文件
    public static ObjectListing getFileList(OSSClient ossClient){
        //获取bucket下成员
        ListObjectsRequest listObjectsRequest=new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        String nextMarker=null;
        ObjectListing objectListing;
        do {
            //文件列表
            objectListing = ossClient.listObjects(listObjectsRequest.withMarker(nextMarker).withMaxKeys(200));
            //文件信息
            List<OSSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
            for (OSSObjectSummary ossObjectSummary : objectSummaries) {
                //获取文件路径
                String key = ossObjectSummary.getKey();
                //获取文件大小
                long fileSize = ossObjectSummary.getSize();
                //获取文件的md5Key,唯一标签名
                String eTag = ossObjectSummary.getETag();
            }
            //标记使用在未来为了listObjects请求 看到下一个页面的结果截断对象清单
            nextMarker = objectListing.getNextMarker();
            //列表是否结束
        }while(objectListing.isTruncated());

        return  objectListing;
    }


    //获取列表文件中的key集合，即路径集合
    public static List<String> getKey(OSSClient ossClient){
        ObjectListing objectListing=getFileList(ossClient);
        List<OSSObjectSummary> objectSummaries=objectListing.getObjectSummaries();
        List<String> keys=new ArrayList<>();
        for(OSSObjectSummary ossObjectSummary:objectSummaries){
            keys.add(ossObjectSummary.getKey());
            System.out.println("key值:"+ossObjectSummary.getKey());
        }
        return keys;
    }
}
