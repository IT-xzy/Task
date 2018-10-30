package com.task5.until;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.util.*;

public class AliyunOSSClientUntil {
    //log日志
    private static Logger logger = Logger.getLogger(AliyunOSSClientUntil.class);
    //阿里云API的内或外网域名
    private static String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET;
    //阿里云API的bucket名称
    private static String BACKET_NAME;
    //阿里云API的文件夹名称
    private static String FOLDER;

    private OSSClient ossClient;

    //初始化属性
    static {
        ENDPOINT = OSSClientConstants.ENDPOINT;
        ACCESS_KEY_ID = OSSClientConstants.ACCESS_KEY_ID;
        ACCESS_KEY_SECRET = OSSClientConstants.ACCESS_KEY_SECRET;
        BACKET_NAME = OSSClientConstants.BACKET_NAME;
        FOLDER = OSSClientConstants.FOLDER;
    }

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    public static OSSClient getOSSClient() {
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        return ossClient;
    }

    public static void destory(OSSClient ossClient){
        ossClient.shutdown();
    }
    //直接就图片上传至第三方,用来进行单一测试
    public void upload(OSSClient ossClient,String bucketName,String key,File file){
        // 上传文件。由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName,key,file);
        destory(ossClient);
    }
    //上传文件流
    public static String updInputStream(OSSClient ossClient,InputStream inputStream,String fileName) throws FileNotFoundException {
        // 上传文件流。
        PutObjectResult result = ossClient.putObject(BACKET_NAME, fileName, inputStream);
        String MD5Key = result.getETag();
        return MD5Key;
    }

//    /**
//     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
//     *
//     * @param fileName 文件名
//     * @return 文件的contentType
//     */
    public static String getContentType(String fileName) {
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
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

    //上传到本地
    public static String sendServer(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        logger.info("getOriginalFilename:"+multipartFile.getOriginalFilename());
        logger.info("getName:"+multipartFile.getName());

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

    //    上传到OSS服务器 如果同名文件会覆盖服务器上的
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
            objectMetadata.setContentType(getContentType(fileName));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 上传文件
            PutObjectResult putResult = ossClient.putObject(BACKET_NAME, FOLDER + fileName,inputStream, objectMetadata);
            //放回一个唯一标签
            ret = putResult.getETag();
            map.put("md5Key",ret);
            map.put("key",FOLDER+fileName);
        } catch (IOException e) {
            System.out.println("上传异常");
        }
        return map;
    }

    public static String getUrl(OSSClient ossClient,String key) {
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(BACKET_NAME, key, expiration);

        if (url != null) {
            return url.toString();
        }
        return null;
    }

    //获取bucketName所有文件
    public static ObjectListing getFileList(OSSClient ossClient){
        //获取bucket下成员
        ListObjectsRequest listObjectsRequest=new ListObjectsRequest();
        listObjectsRequest.setBucketName(BACKET_NAME);
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


//
//    //测试
//    public static void main(String[] args) {
//        //初始化OSSClient
//        OSSClient ossClient=AliyunOSSClientUntil.getOSSClient();
//        //上传文件
//        String files="E:\\3.jpg,E:\\4.jpg";
//        String[] file=files.split(",");
//        for(String filename:file){
//            System.out.println("filename:"+filename);
//            File filess=new File(filename);
//            String md5key = AliyunOSSClientUntil.uploadObject2OSS(ossClient, filess, BACKET_NAME, FOLDER);
//            logger.info("上传后的文件MD5数字唯一签名:" + md5key);
//            //上传后的文件MD5数字唯一签名:40F4131427068E08451D37F02021473A
//        }
//    }
}
