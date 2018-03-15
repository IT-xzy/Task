package cn.summerwaves.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ALiYunUtil {
    protected static Logger log = Logger.getLogger(ALiYunUtil.class);
    private static String accessKeyId;
    private static String accessKeySecret;
    private static String bucketName;


    public static void upLoad(InputStream inputStream, String fileName) {
        try {
            String endpoint = "oss-cn-shenzhen.aliyuncs.com";
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        /*InputStream inputStream = new FileInputStream(filePath);*/
            ossClient.putObject(bucketName, fileName, inputStream/*new File(filePath)*/);
            inputStream.close();
            ossClient.shutdown();
        } catch (OSSException oe) {
            log.error("Caught an upLoad OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }catch (IOException e) {
            log.error("File upload problem,throw a IOException");
        }
    }

    public static InputStream downLoad(String fileName){
        try {
            String endpoint = "oss-cn-shenzhen.aliyuncs.com";
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            /*BufferedInputStream stream = new BufferedInputStream();*/
            OSSObject ossObject = ossClient.getObject(bucketName, fileName);
            return ossObject.getObjectContent();
        } catch (OSSException oe) {
            log.error("Caught an downLoad OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }
        return null;
    }

    public static List<String> getAllFileName() {
        try {
            List<String> keys = new ArrayList<>();
            OSSClient ossClient = new OSSClient("oss-cn-shenzhen.aliyuncs.com", accessKeyId, accessKeySecret);
            String nextMarker = null;
            final int maxKeys = 1000;
            // 列举Object
            ObjectListing objectListing;
            do {
                objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).
                        withMarker(nextMarker).withMaxKeys(maxKeys));
                List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
                for (OSSObjectSummary s : sums) {
                    keys.add(s.getKey());
                }
                nextMarker = objectListing.getNextMarker();
            } while (objectListing.isTruncated());

            ossClient.shutdown();
            return keys;
        }catch (OSSException oe) {
            log.error(" Caught an getAllFileName OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }
        return null;
    }

    public static String getThumbFileUrl(String fileName) {
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return String.format("%s/%s", "http://img2.summerwaves.cn", encodedFileName+"!thumb");
    }

    public static void deleteFile(String fileName) {
        try {
            String endpoint = "oss-cn-shenzhen.aliyuncs.com";
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            ossClient.deleteObject(bucketName, fileName);
            ossClient.shutdown();
        }catch (OSSException oe) {
            log.error("Caught an deleteFile OSSException," + "the error code is " + oe.getErrorCode() + "," + "reason is " + oe.getMessage());
        }
    }

    public static void deleteAllFile() {
        List<String> keys = ALiYunUtil.getAllFileName();
        for (String key : keys) {
            deleteFile(key);
        }
    }


    public void setAccessKeyId(String accessKeyId) {
        ALiYunUtil.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        ALiYunUtil.accessKeySecret = accessKeySecret;
    }

    public void setBucketName(String bucketName) {
        ALiYunUtil.bucketName = bucketName;
    }



}
