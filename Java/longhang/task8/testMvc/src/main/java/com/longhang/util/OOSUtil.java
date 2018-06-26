package com.longhang.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class OOSUtil {
    private static Logger logger = Logger.getLogger(OOSUtil.class);

    private  String endpoint;
    private  String accessKeyId;
    private  String accessKeySecret;
    private  String bucketName;
    private  String folderName;
    public OOSUtil() {
    }
    public String getEndpoint() {
        return endpoint;
    }
    public String getBucketName() {
        return bucketName;
    }
    public OOSUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName, String folderName) {
        //域名
        this.endpoint = endpoint;
        //钥匙id
        this.accessKeyId = accessKeyId;
        //钥匙密码
        this.accessKeySecret = accessKeySecret;
        //bucket
        this.bucketName = bucketName;
        //文件名
        this.folderName = folderName;
    }
   /**
    *  // 七牛云上传
    *  */
    public String qiniu(InputStream inputStream) throws IOException {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        int random = (int)(Math.random()*900)+10000;
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = folderName+System.currentTimeMillis()+String.valueOf(random)+".jpg";
        Auth auth = Auth.create(accessKeyId, accessKeySecret);
        String upToken = auth.uploadToken(bucketName);

            Response response = uploadManager.put(inputStream, key, upToken,null,null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);

        return key;
    }
   /**
    *  //阿里云上传
    *  */
    public String  uploadOSS(InputStream inputStream) {
        String fileName= null;
//初始化OSSClient
        OSSClient ossClient=  new OSSClient(endpoint,accessKeyId, accessKeySecret);
        int random = (int)(Math.random()*900)+10000;
        try {
//文件名
            fileName= folderName + String.valueOf(System.currentTimeMillis()) + String.valueOf(random) + ".jpg";
//上传文件 (上传文件流的形式)
            PutObjectResult putResult = ossClient.putObject(bucketName, fileName, inputStream);
//解析结果
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传阿里云OSS服务器异常." + e.getMessage(), e);
        }
        ossClient.shutdown();
        return fileName;
    }


}
