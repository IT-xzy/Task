package com.jnshu.tools;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;


import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class QnOssUntil {


   static String accessKey;

   static String secretKey;

   static String bucket;

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public  String getAccessKey() {
        return accessKey;
    }

    public  String getSecretKey() {
        return secretKey;
    }

    public  String getBucket() {
        return bucket;
    }

    static   String bucketName ;

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public  String getBucketName() {
        return bucketName;
    }

    public static String upFile(InputStream localFile, String key) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        Auth auth = Auth.create(accessKey, secretKey);


        String upToken = auth.uploadToken(bucket);
        String rs = null;
        try {
            Response response = uploadManager.put(localFile, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            rs = putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return rs;
    }


    public static List qnList() {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
//...其他参数参考类注释
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
//文件名前缀
        String prefix = "";
//每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
//列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        List<String> list = new ArrayList<>();
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                list.add(item.key);
            }
        }
        return list;
    }

}
