package com.tools;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.annotation.Resource;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AliUploadFile {
    @Resource
    private QiniuUp qiniuUp;
    @Resource
    private UrlStream urlStream;

    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static Logger logger=Logger.getLogger(AliUploadFile.class);
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private String endpoint ;//= "oss-cn-shenzhen.aliyuncs.com";
    private String accessKeyId ;//= "LTAIFC5CQPjC7oGp";
    private String accessKeySecret ;// = "0uN3YRhGjyALDiM5yKxMIzlgVNfRnw";
    private String bucketName;//"arnold-cheng"
    private String format; //".png"
    private String remoteSrcUrl;
    public String getRemoteSrcUrl() {
        return remoteSrcUrl;
    }

    public void setRemoteSrcUrl(String remoteSrcUrl) {
        this.remoteSrcUrl = remoteSrcUrl;
    }



    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public  void  upFile(CommonsMultipartFile file, String objectName){
        logger.info("com.Tools.UploadFile.upFile的入参是 file"+file+" \n objectName"+objectName);
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流。
        InputStream inputStream = null;
        try {
            inputStream =file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.putObject(bucketName,objectName+format, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 获取文件列表
     * @return
     */
    public List<String> fileList(){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 构造ListObjectsRequest请求。
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
// 列出文件。
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
// 遍历所有文件。
        System.out.println("Objects:");
        List<String> list=new ArrayList<>();
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            list.add(objectSummary.getKey());
            System.out.println(objectSummary.getKey());
        }
// 遍历所有commonPrefix。
        System.out.println("CommonPrefixes:");
        for (String commonPrefix : listing.getCommonPrefixes()) {
            System.out.println(commonPrefix);
        }
// 关闭OSSClient。
        ossClient.shutdown();
        return list;

    }

    /**
     * 图片转移
     */
    public void transfer(){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        List<String> list=qiniuUp.fileList();
        for (String aList : list) {
            String encodedFileName = null;
            try {
                encodedFileName = URLEncoder.encode(aList, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String finalUrl = String.format("%s/%s", qiniuUp.getRemoteSrcUrl(), encodedFileName);
            ossClient.putObject(bucketName,aList, urlStream.urlInputstream(finalUrl));
        }
// 关闭OSSClient。
        ossClient.shutdown();
    }



}
