package com.longhang.util;

import com.aliyun.oss.OSSClient;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
*
 数据迁移工具
 */
public class UploadOOS {

        private static Logger logger = Logger.getLogger(UploadOOS.class);

        private  String aliyunEndpoint;
        private  String aliyunAccessKeyId;
        private  String aliyunAccessKeySecret;
        private  String aliyunBucketName;
        private  String qiniuyunEndpoint;
        private  String qiniuyunAccessKeyId;
        private  String qiniuyunAccessKeySecret;
        private  String qiniuyunBucketName;
        //数据库的表名
        private  String folderName;
        public UploadOOS() {
        }

    public UploadOOS(String aliyunEndpoint, String aliyunAccessKeyId, String aliyunAccessKeySecret, String aliyunBucketName, String qiniuyunEndpoint, String qiniuyunAccessKeyId, String qiniuyunAccessKeySecret, String qiniuyunBucketName, String folderName) {
        this.aliyunEndpoint = aliyunEndpoint;
        this.aliyunAccessKeyId = aliyunAccessKeyId;
        this.aliyunAccessKeySecret = aliyunAccessKeySecret;
        this.aliyunBucketName = aliyunBucketName;
        this.qiniuyunEndpoint = qiniuyunEndpoint;
        this.qiniuyunAccessKeyId = qiniuyunAccessKeyId;
        this.qiniuyunAccessKeySecret = qiniuyunAccessKeySecret;
        this.qiniuyunBucketName = qiniuyunBucketName;
        this.folderName = folderName;
    }
     /**
    *
    * 阿里云获取文件的url
    */
     public String  getAliyunUrl(String fileName){
            return "http://"+aliyunBucketName+"."+aliyunEndpoint+"/"+fileName;
   }


    /**
    *  阿里云网络流上传  Url:网络文件名  fileName:文件名
     *
     */
     public void  uploadAliyunOSS(String url,String fileName) throws IOException {
        //初始化OSSClient
        OSSClient ossClient=  new OSSClient(aliyunEndpoint,aliyunAccessKeyId, aliyunAccessKeySecret);
        InputStream inputStream = new URL(url).openStream();
        ossClient.putObject(aliyunBucketName, fileName, inputStream);
        ossClient.shutdown();
       }

      /**
       *  七牛下载获取url
       * */
       public String downloadQiniiu(String fileName) throws UnsupportedEncodingException {
        String domainOfBucket = "http://p966blihe.bkt.clouddn.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
          return finalUrl;
          }


      /**
       *  七牛网络抓取  remoteSrcUrl:网络文件 key：文件名
       */
        public void uploadQiniuOnline(String remoteSrcUrl,String key) throws IOException {
           //构造一个带指定Zone对象的配置类
           Configuration cfg = new Configuration(Zone.zone2());
           Auth auth = Auth.create(qiniuyunAccessKeyId, qiniuyunAccessKeySecret);
           BucketManager bucketManager = new BucketManager(auth, cfg);
            //抓取网络资源到空间

            FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl,qiniuyunBucketName, key);
            logger.info("文件名::::"+fetchRet.key);

    }

}



