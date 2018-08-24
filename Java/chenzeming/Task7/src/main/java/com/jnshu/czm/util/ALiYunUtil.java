package com.jnshu.czm.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ALiYunUtil {

    private static Logger logger= LoggerFactory.getLogger(ALiYunUtil.class);
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static String accessKeyId ;
    private static String accessKeySecret ;
    private static String bucket;

    public  void setAccessKeyId(String accessKeyId) {
        ALiYunUtil.accessKeyId = accessKeyId;
    }

    public  void setAccessKeySecret(String accessKeySecret) {
        ALiYunUtil.accessKeySecret = accessKeySecret;
    }

    public  void setBucket(String bucket) {
        ALiYunUtil.bucket = bucket;
    }
    /**
     * 文件上传
     * @param fileName
     * @param inputStream
     */
    public static void upLoad(String fileName,InputStream inputStream) {

        try {

            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            logger.info("\nossClient:"+ossClient);
            /*InputStream inputStream = new FileInputStream(filePath);*/
            // 上传文件流。
            ossClient.putObject(bucket, fileName, inputStream/*new File(filePath)*/);
            inputStream.close();
            ossClient.shutdown();
        } catch (OSSException oe) {
            logger.info("\n4.................................");
//            logger.info("Caught an upLoad OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }catch (IOException e) {
            logger.info("\n5.................................");
//            logger.info("File upload problem,throw a IOException");
        }
    }


    /**
     * 文件下载
     * @param fileName
     * @return
     */
    public static InputStream downLoad(String fileName) {


        logger.info("\n进入文件下载");
        try {
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            OSSObject ossObject = ossClient.getObject(bucket, fileName);
            logger.info("\nossObject:    "+ossObject);
            return ossObject.getObjectContent();

        }catch(Exception e){

            return null;
        }
    }

    /**
     * 获取全部文件名
     * @return
     */
    public  static List<String> getAllFileName() {

        logger.info("\n 获取全部文件名");
        try {
            List<String> keys = new ArrayList<>();
            // 创建OSSClient实例。
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
            ObjectListing objectListing = ossClient.listObjects(bucket);
            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                String key = s.getKey();
                keys.add(key);
                System.out.println("\t" + key);
            }
            // 关闭OSSClient。
            ossClient.shutdown();
            return keys;
        }catch (Exception e){
            return null;
        }
    }



}


