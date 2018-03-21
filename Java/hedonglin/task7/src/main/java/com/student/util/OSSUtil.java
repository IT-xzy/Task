package com.student.util;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

public class OSSUtil implements Storage{

    //日志
    private  final Logger log = LoggerFactory.getLogger(OSSUtil.class);

    //阿里云API的内或外网域名
    private  String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private  String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private  String ACCESS_KEY_SECRET;

    private  String bucketName;

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setENDPOINT(String ENDPOINT) {
        this.ENDPOINT = ENDPOINT;
    }

    public void setAccessKeyId(String accessKeyId) {
        ACCESS_KEY_ID = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        ACCESS_KEY_SECRET = accessKeySecret;
    }
//    初始化静态数据
//     {
//        ResourceBundle bundle = PropertyResourceBundle.getBundle("oss.properties");
//        ENDPOINT = bundle.containsKey("endpoint") == false ? "" : bundle.getString("endpoint");
//        ACCESS_KEY_ID = bundle.containsKey("accessKeyId") == false ? "" : bundle.getString("accessKeyId");
//        ACCESS_KEY_SECRET = bundle.containsKey("accessKeySecret") == false ? "" : bundle.getString("accessKeySecret");
//
//
//    }


    /**
     * 获取阿里云OSS客户端对象
     */
    public  final OSSClient getOSSClient() {
        return new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }


    /**
     * 新建Bucket --Bucket权限：私有
     *
     * @param bucketName bucket名称
     * @return true 新建Bucket成功
     */
    public  final boolean createBucket(OSSClient client, String bucketName) {
        Bucket bucket = client.createBucket(bucketName);
        return bucketName.equals(bucket.getName());
    }


    /**
     * 删除Bucket
     *
     * @param bucketName bucket名称
     */
    public  final void deletBucket(OSSClient client, String bucketName) {
        client.deleteBucket(bucketName);
        log.info("删除"+bucketName+"Bucket成功");
    }


    /**
     * 向阿里云的OSS存储中存储文件  --file也可以用InputStream替代
     *
     * @param client     OSS客户端
     * @param file       上传文件
     * @param bucketName bucket名称
     * @param diskName   上传文件的目录  --bucket下文件的路径
     * @return String 唯一MD5数字签名
     */
    public  final String uploadObject2OSS(OSSClient client, File file, String bucketName, String diskName) {
        String resultStr = null;
        try {
            InputStream is = new FileInputStream(file);
            String fileName = file.getName();
            Long fileSize = file.length();
            //创建上传Object的Metadata
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(fileName));
            metadata.setContentDisposition("filename/filesize=" + fileName + "/" + fileSize + "Byte.");
            //上传文件
            PutObjectResult putResult = client.putObject(bucketName, diskName + fileName, is, metadata);
            //解析结果
            resultStr = putResult.getETag();
        } catch (Exception e) {
            log.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        return resultStr;
    }


    /**
     * 根据key获取OSS服务器上的文件输入流
     * @param client OSS客户端
     * @param bucketName bucket名称
     * @param diskName 文件路径
     * @param key Bucket下的文件的路径名+文件名
     */
    public  final InputStream getOSS2InputStream(OSSClient client, String bucketName, String diskName, String key){
        OSSObject ossObj = client.getObject(bucketName, diskName + key);
        return ossObj.getObjectContent();
    }

    /**
     * 根据key删除OSS服务器上的文件
     * @param client OSS客户端
     * @param bucketName bucket名称
     * @param diskName 文件路径
     * @param key Bucket下的文件的路径名+文件名
     */
    public  void deleteFile(OSSClient client, String bucketName, String diskName, String key){
        client.deleteObject(bucketName, diskName + key);
        log.info("删除" + bucketName + "下的文件" + diskName + key + "成功");
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public  final String getContentType(String fileName){
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if("bmp".equalsIgnoreCase(fileExtension)) return "image/bmp";
        if("gif".equalsIgnoreCase(fileExtension)) return "image/gif";
        if("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension)  || "png".equalsIgnoreCase(fileExtension) ) return "image/jpeg";
        if("html".equalsIgnoreCase(fileExtension)) return "text/html";
        if("txt".equalsIgnoreCase(fileExtension)) return "text/plain";
        if("vsd".equalsIgnoreCase(fileExtension)) return "application/vnd.visio";
        if("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) return "application/vnd.ms-powerpoint";
        if("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) return "application/msword";
        if("xml".equalsIgnoreCase(fileExtension)) return "text/xml";
        return "text/html";
    }



//    上传字节流
    public  final void uploadFile(InputStream inputStream, String key) {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
// 上传文件流
//        InputStream inputStream = null;
//        try {
//
//           inputStream = new FileInputStream(String.valueOf(newInputStream));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

        ossClient.putObject(bucketName, key, inputStream);

// 关闭client
        ossClient.shutdown();


    }


    public  final InputStream download(String key) {

//        // 创建OSSClient实例
//        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
//        OSSObject ossObject = ossClient.getObject(bucketName, key);
//// 读Object内容
//        System.out.println("Object content:");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
//        while (true) {
//            String line = null;
//            try {
//                line = reader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (line == null) break;
////            System.out.println("\n" + line);
//        }
////        try {
//////            reader.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//// 关闭client
////        ossClient.shutdown();
//        return ossObject.getObjectContent();
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        OSSObject ossObject = ossClient.getObject(bucketName, key);
// 读Object内容
        System.out.println("Object content:");
        InputStream inputStream =ossObject.getObjectContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        while (true) {
//            String line = null;
//            try {
//                line = reader.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (line == null) break;
////            System.out.println("\n" + line);
//        }
//        try {
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//// 关闭client
//        ossClient.shutdown();
        return inputStream;
    }



    private  void displayTextInputStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("\t" + line);
        }
        System.out.println();

        reader.close();
    }


    public  List<OSSObjectSummary> findFiles() {
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
// 列举Object
        ObjectListing objectListing = ossClient.listObjects(bucketName, "");
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }

// 关闭client
        ossClient.shutdown();
        return sums;
    }

}
