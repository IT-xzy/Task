package util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import pojo.Sms;

import javax.annotation.Resource;
import java.io.*;
import java.net.URL;

/**
 * 阿里云OSS上传下载文件
 * 阿里云对象存储服务（Object Storage Service，简称OSS）
 */
@Service
public class OssUtil {
    @Resource
    private
    Sms sms;
    private Logger log = Logger.getLogger(OssUtil.class);

    private OSSClient getOssClient(){
        // endpoint以杭州为例，其它region请按实际情况填写。
       String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 创建OSSClient实例，实例必须在中括号内使用
        return new OSSClient(endpoint, sms.getAccessKeyId(), sms.getAccessKeySecret());
    }


    /**
     * 新建存储空间
     * @param bucketName 存储空间名
     * @return bool
     */
    public boolean createBucket(String bucketName){
        boolean bool=false;
        OSSClient ossClient =getOssClient();
        try{
            ossClient.createBucket(bucketName);
            bool = true;
        }catch (Exception e){
            log.info("创建Bucket失败");
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return bool;
    }




    /**
     * 新建文件夹
     * @param bucketName bucket
     * @param dir 文件夹，以"/"结尾 "dir1/dir2/dir3/"
     * @return bool
     */
    public boolean createDirectory(String bucketName,String dir){
        boolean bool =false;
        OSSClient ossClient =getOssClient();
        try {
            ossClient.putObject(bucketName,dir, new ByteArrayInputStream(new byte[0]));
            bool =true;
        }catch (Exception e){
            log.info("创建OSS文件夹异常");
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return bool;
    }

    /**
     * 文件以字节流上传
     * @param bucketName bucket
     * @param objectName objectName
     * @param fileBytes 将文件file 转换成字节数组
     */
    public void uploadBytesStream(String bucketName,String objectName,byte[] fileBytes) throws Exception{
        OSSClient ossClient = getOssClient();
        ossClient.putObject(bucketName,objectName,new ByteArrayInputStream(fileBytes));
        ossClient.shutdown();
    }


    /**
     * 上传文件流（流式上传）
     * @param bucketName 存储空间名
     * @param objectName key文件名（ant.png）
     * @param inputStream value文件本体 （cake.jpg）
     */
    public void uploadFileStream(String bucketName,String objectName,InputStream inputStream) {
        OSSClient ossClient = getOssClient();
        try {
            //上传文件
           ossClient.putObject(bucketName, objectName, inputStream);

        } catch (Exception e) {
            log.info("上传文件流异常");
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
    }


    /**
     * 上传网络流（流式上传）
     * @param bucketName bucket
     * @param objectName objectName
     * @param url url
     * @return  上传后的文件MD5数字唯一签名
     * @throws IOException i/o
     */
    public String uploadUrlStream(String bucketName,String objectName,String url) throws IOException {

        String resultStr ="";
        OSSClient ossClient =getOssClient();
        try{
            InputStream inputStream = new URL(url).openStream();
            //上传文件
            PutObjectResult putObjectResult = ossClient.putObject(bucketName,objectName,inputStream);

            //上传后的文件MD5数字唯一签名
            resultStr = putObjectResult.getETag();
            log.info("上传网络流成功解析成MD5数字唯一签名:"+resultStr);
        }catch (Exception e){
            log.info("上传网络流异常");
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return resultStr;
    }

    /**
     * 上传本地文件
     * @param bucketName bucket
     * @param objectName 文件名
     * @param localFile 本地文件
     * @return
     */
    public String uploadFile(String bucketName,String objectName,String localFile){
            String resultStr ="";
            OSSClient ossClient =getOssClient();
        try{
            //上传文件
            PutObjectResult putObjectResult = ossClient.putObject(bucketName,objectName,new File(localFile));
            //上传后的文件MD5数字唯一签名
            resultStr = putObjectResult.getETag();
            log.info("上传文件成功解析成MD5数字唯一签名:"+resultStr);
        }catch (Exception e){
            log.info("上传文件异常");
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return resultStr;
    }


    /**
     * 断点续传文件
     * @param bucketName bucket
     * @param objectName objectName
     * @param localFile localFile
     * @return bool
     */
    public boolean uploadMultipartFile(String bucketName,String objectName,String localFile){
        boolean bool = false;
        OSSClient ossClient =getOssClient();
        try {
            ObjectMetadata meta = new ObjectMetadata();
            // 指定上传的内容类型。
            meta.setContentType("text/plain");
            // 设置断点续传请求。
            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, objectName);

            // 指定上传的本地文件，必选参数。
            uploadFileRequest.setUploadFile(localFile);
            // 指定上传并发线程数，默认为1。
            uploadFileRequest.setTaskNum(5);
            // 指定上传的分片大小，从100KB到5GB，单位是Byte，默认为100K。
            uploadFileRequest.setPartSize(1024 * 1024);
            // 开启断点续传，默认关闭。
            uploadFileRequest.setEnableCheckpoint(true);
            //本地记录分片上传的结果。开启断点续传时，需要在本地记录分片上传的结果，如果上传过程中某一分片上传失败，
            // 再次上传时会从Checkpoint文件中记录的点继续上传，这要求再次调用时要指定与上次相同的Checkpoint文件。
            // 上传完成后，Checkpoint文件会被删除。默认与待上传的本地文件同目录，为uploadFile.ucp。
            uploadFileRequest.setCheckpointFile("uploadFile.ucp");
            //Object的元数据。
            uploadFileRequest.setObjectMetadata(meta);
            //设置Callback，上传成功后的回调，Callback类型的。
//            uploadFileRequest.setCallback("<yourCallbackEvent>");
            // 断点续传上传。
            ossClient.uploadFile(uploadFileRequest);
            bool =true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return bool;
    }


    /**
     * 流式下载（暂时不知道怎么用）
     * @param bucketName b
     * @param objectName o
     * @return bool
     */
    public boolean downloadFileStream(String bucketName,String objectName){
        boolean bool =false;
        OSSClient ossClient =getOssClient();
        try {
            //ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            // 读取文件内容。
            System.out.println("Object content:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("\n" + line);
            }
            //数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            reader.close();
            bool = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return bool;
    }


    /**
     * 下载到本地
     * @param bucketName bucket
     * @param objectName oname
     * @param localFile localFile
     * @return bool
     */
    public boolean download2Local(String bucketName,String objectName,String localFile){
        boolean bool =false;
        OSSClient ossClient =getOssClient();
        try {
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            ossClient.getObject(new GetObjectRequest(bucketName, objectName),new File(localFile));
            bool =true;
        }catch (Exception e){
            log.info("下载到本地异常："+e.getMessage());
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return bool;
    }




    /**
     * 列举指定存储空间下的文档。默认列举100个文件。
     * @param bucketName 指定存储空间
     */
    public void listObjects(String bucketName){
        OSSClient ossClient =getOssClient();
        //ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        //objectListing.getObjectSummaries获取所有Object的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        // 关闭Client。
        ossClient.shutdown();
    }

    /**
     * 删除文件
     * @param bucketName 指定存储空间
     * @param objectName 指定文件名(ant.png)
     * @return bool
     */
    public boolean deleteObject(String bucketName,String objectName){
        boolean isDelete =false;
        OSSClient ossClient =getOssClient();
        try {
            ossClient.deleteObject(bucketName, objectName);
            isDelete =true;
        }catch (Exception e){
            e.printStackTrace();
        }
        // 关闭Client。
        ossClient.shutdown();
        return isDelete;
    }


}
