package com.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class AliUploadFile {

    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static Logger logger = Logger.getLogger(AliUploadFile.class);
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static  String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    private static  String accessKeyId = "LTAI2TGWKVTWNgdn";
    private static  String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
    private static  String bucketName = "aliyunuploadphoto";
    private static  String remoteSrcUrl = "http://aliyunuploadphoto.oss-cn-shenzhen.aliyuncs.com";
    public static  String getRemoteSrcUrl() {
        return remoteSrcUrl;
    }

    ///**
    // * 文件上传
    // * @param FileName
    // * @param inputStream
    // */
    //public void upLoad(String FileName,InputStream inputStream) {
    //    try {
    //        // 创建OSSClient实例。
    //        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    //        logger.info("\nossClient:"+ossClient);
    //        // 上传文件流。
    //        ossClient.putObject(bucketName, FileName, inputStream);
    //        inputStream.close();
    //        ossClient.shutdown();
    //    } catch (OSSException oe) {
    //        logger.info("\noe" +oe);
    //    }catch (IOException e) {
    //        logger.info("\ne"+e);
    //    }
    //}
    //
    /**
     * 获取文件列表
     *
     * @return
     */
    public static List<String> fileList() {

        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // 列出文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        // 遍历所有文件。
        //System.out.println("Objects:");

        List<String> list = new ArrayList<>();

        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            list.add(objectSummary.getKey());
            System.out.println(objectSummary.getKey());
        }
        //System.out.println("\n上面打印的是objectSummary.getKey()的集合\n");
        // //遍历所有commonPrefix。
        //System.out.println("CommonPrefixes:");
        for (String commonPrefix : listing.getCommonPrefixes()) {
            //System.out.println(commonPrefix);
        }
         //关闭OSSClient。
        ossClient.shutdown();
        return list;
    }


    /**
     * 阿里迁移到七牛
     */
    public static void transfer() {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
        String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
        String bucket = "zwposs";
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        List<String> filelist = fileList();
        for (String s : filelist) {
            System.out.println("\n" + s);
            String remoteSrcUrl = getRemoteSrcUrl() + "/" + s;
            System.out.println(remoteSrcUrl);
            //抓取网络资源到空间
            try {
                FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl, bucket, s);
                logger.info(fetchRet);
            } catch (QiniuException ex) {
                System.err.println(ex.response.toString());
            }
        }
    }
}



