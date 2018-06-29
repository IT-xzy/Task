package com.ptteng.util.thirdAPI;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class AliyunOSSUtil {
    //endpoint是杭州的公网
     String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    //阿里云主账号的accessKey拥有所有API的AccessKey的访问权限。
     String accessKeyId = "LTAIs5HQAO7GlXZU";
     String accessKeyScret = "pFFL3YTu4Xh8oFtRMDetGuFUs8HfeE";
     String bucketName = "imageuploadbychenxin";

    //创建OSSClient实例
    private OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeyScret);
    /**
     * 删除一个bucket和其中的objects
     * @param bucketName
     * @throws OSSException
     * @throws ClientException
     */
    public  void deleteBucket( String bucketName) throws Exception{

        ObjectListing objectListing = client.listObjects(bucketName);
        List<OSSObjectSummary> listDeletes = objectListing.getObjectSummaries();

        for (int i = 0; i < listDeletes.size(); i++){
            String objectName = listDeletes.get(i).getKey();
            //如果不为空，先删除bucket下的文件
            client.deleteObject(bucketName,objectName );
        }
        client.deleteBucket(bucketName);
    }

    /**
     * 把bucket设置为所有人可读
     * @param bucketName
     * @throws OSSException
     * @throws ClientException
     */
    public  void setBucketPublicReadable( String bucketName) throws OSSException, ClientException{
        //创建bucket
        client.createBucket(bucketName);

        //设置bucket的访问权限，public-read-write权限
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead );
    }

    /**
     * 上传文件
     * @throws OSSException
     * @throws ClientException
     * @throws java.io.FileNotFoundException
     */
    public void uploadFile(String key,byte[] bytes) throws OSSException, ClientException{
        client.putObject(bucketName, key, new ByteArrayInputStream(bytes));
    }

    /**
     * 下载文件
     * @param client
     * @param bucketName
     * @param key
     * @param filename
     * @throws OSSException
     * @throws ClientException
     */
    public static void downloadFile(OSSClient client, String bucketName, String key, String filename) throws OSSException, ClientException{
        client.getObject(new GetObjectRequest(bucketName,key), new File(filename));
    }

    /**
     * @param client
     * @param bucketName
     * @param folderPath
     */
    public static void createFolder(OSSClient client, String bucketName, String  folderPath) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        byte[] buffer = new byte[0];
        ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        objectMetadata.setContentLength(0);
        try{
            client.putObject(bucketName, folderPath, in, objectMetadata);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                in.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除一个OSS对象
     * @param client
     * @param bucketName
     * @param key
     */
    public static void deleteObject(OSSClient client, String bucketName, String key){
        client.deleteObject(bucketName, key);
    }
}
