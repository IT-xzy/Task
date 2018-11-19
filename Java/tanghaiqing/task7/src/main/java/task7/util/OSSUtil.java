package task7.util;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OSSUtil {
    private static Logger logger=Logger.getLogger(OSSUtil.class);
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIYJkbrR5aHKIX";
    private static String accessKeySecret = "NPfctvHtPjIfS0f3Z5F1YgM3lHK4ut";
    private static String bucketName = "tas7haiqing";
    //初始化OSSClient实例。
    private static OSSClient ossClient;
    static {
        if (ossClient==null){
             ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
    }

    /**
     * 创建存储空间方法
     * @param str 入参为存储空间名字。
      * @return 是否成功字符串
     */
    public static String createBucket(String str){
        logger.info("进入createBucket；");
        if (!ossClient.doesBucketExist(str)){
            logger.info("创建存储空间"+str);
            ossClient.createBucket(str);
            return "创建存储空间"+str+"成功";
        }
        return "创建失败！"+str+"已存在或者被占用";
    }

    /**
     * 上传字符串
     * @param fileName 上传后的文件名
     * @param content 存入的字符串
     */
    public static void putString(String fileName,String content){
        logger.info("进入putString");
        InputStream bytes= new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
        ossClient.putObject(bucketName,fileName,bytes);
        ossClient.shutdown();
    }

    /**
     * 上传文件流
     * @param fileName 上传后的文件名
     * @param input 传入的流
     */
    public static void putFile(String fileName,InputStream input){
        ossClient.putObject(bucketName,fileName,input);
        ossClient.shutdown();
    }
    //文件流形式下载文件
    public static void downFile(String filename){
        ossClient.getObject(new GetObjectRequest(bucketName, filename), new File(filename));
    }

    /**
     * 下载文件
     * @param fileName 文件名
     * @return 流对象
     */
    public static InputStream down(String fileName){
        logger.info("进入downFile()");
       OSSObject ossObject= ossClient.getObject(bucketName,fileName);
       InputStream input =ossObject.getObjectContent();
        try {
            ossObject.close();
        } catch (IOException e) {
            logger.info("下载文件异常!");
            e.printStackTrace();
        }
        return input;
    }

    //遍历阿里云所有文件
    public static ObjectListing getall() {
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);
        // 列出Object
        return ossClient.listObjects(listObjectsRequest);
    }

    //查找阿里云是否存在文件
    public static Boolean checkFile(String filename) {
        return ossClient.getObject(bucketName, filename).getKey().equals(filename);
    }

    public static void main(String[] args) {
        //System.out.println(createBucket("haiqing2828"));
        //putString("haiqing","");
        ObjectListing objectListing =OSSUtil.getall();


    }
}
