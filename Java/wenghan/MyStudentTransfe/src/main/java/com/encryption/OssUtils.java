package com.encryption;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.auth0.jwt.internal.org.bouncycastle.util.encoders.UrlBase64;

import javax.servlet.ServletOutputStream;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OssUtils {
    private static final String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    private static final String accessKeyId = "LTAIFumOhh6Kvow5";
    private static final String accessKeySecret = "qGPqDbBzKMJvoILXDh5AXzbaeogXFY";
    public static final int VISIT_GRADE = 3;


    //获得ossClient
    public static OSSClient getOSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    //关闭OSSClient
    public static void shutDownOssClient(OSSClient ossClient){
        ossClient.shutdown();
    }

    /**
     * 判断一个存储空间是否存在
     */
    public static boolean doesBucketExits(OSSClient ossClient, String bucketName) {
        return ossClient.doesBucketExist(bucketName);
    }

    /**
     * 创建一个存储空间
     * 并给存储空间对外赋读写权限
     */
    public static boolean createBuckName(OSSClient ossClient, String bucketName, int grade) {
        boolean res;
        if (doesBucketExits(ossClient, bucketName)) {
            return true;
        }
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
        switch (grade) {
            case 1:
                createBucketRequest.setCannedACL(CannedAccessControlList.Private);
                break;
            case 2:
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                break;
            case 3:
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicReadWrite);
                break;
            default:
                createBucketRequest.setCannedACL(CannedAccessControlList.Private);
                break;
        }
        ossClient.createBucket(createBucketRequest);
        res = true;
        return res;
    }

    /**
     * 删除一个存储空间
     */
    public static void deleteBucketName(OSSClient ossClient, String bucketName) {
        if (doesBucketExits(ossClient, bucketName)) {
            ossClient.deleteBucket(bucketName);
        }
    }

    /**
     * 创建一个文件夹
     */
    public static boolean createFolder(OSSClient ossClient, String bucketName, String folder) {
        if (!ossClient.doesObjectExist(bucketName, folder)) {
            ossClient.putObject(bucketName, folder, new ByteArrayInputStream(new byte[0]));
            OSSObject object = ossClient.getObject(bucketName, folder);
            String fileDir = object.getKey();
            return true;
        }
        return false;
    }

    /**
     * 删除一个文件夹
     */
    public static boolean deleteFolder(OSSClient ossClient, String bucketName, String folder) {
        if (ossClient.doesObjectExist(bucketName, folder)) {
            ossClient.deleteObject(bucketName, folder);
            return true;
        }
        return false;
    }

    /**
     * 根据key删除OSS服务器上的文件
     */
    public static void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
    }

    //下载图片
    public static void downloadFile(OSSClient ossClient, String bucket, String objectName, String path) {
        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucket, objectName), new File(path));
    }

    //获得图片的URL
    public static String getUrl(OSSClient ossClient, String bucketName, String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    //根据文件流上传
    public static void setFile(OSSClient ossClient,InputStream inputStream,String bucket,String objectName){
        ossClient.putObject(bucket, objectName, inputStream);
    }

    //获得库中所有的键值
    public static List<String> getFileList(OSSClient ossClient,String bucketName){
        List<String> list=new ArrayList<>();
        // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            list.add(s.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        //获得 OSSClient对象
        OSSClient ossClient = OssUtils.getOSSClient();

        List list=OssUtils.getFileList(ossClient,"wh-test-bucket");

        //关闭连接
        OssUtils.shutDownOssClient(ossClient);
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
