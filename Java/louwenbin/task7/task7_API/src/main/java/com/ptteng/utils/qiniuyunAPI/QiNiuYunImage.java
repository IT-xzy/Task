package com.ptteng.utils.qiniuyunAPI;

import com.google.gson.Gson;
import com.ptteng.utils.aliyunAPI.HelloOSS;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QiNiuYunImage {
    @Resource
    private HelloOSS helloOSS;
    @Resource
    private QiNiuYunImage qiNiuYunImage;
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone2());
    //...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String accessKey;
    private String secretKey;
    private String bucket;

    public QiNiuYunImage() {
    }

    public QiNiuYunImage(String accessKey, String secretKey, String bucket) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
    }

    //上传图片到七牛云
    public void upload(String name, InputStream file) {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(file, name, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
            }
        }
    }

    //获取图片链接
    public String urlImage(String name) throws UnsupportedEncodingException {
        String fileName = name;
        String domainOfBucket = "http://p99jjrabl.bkt.clouddn.com/";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        return finalUrl;
    }

    //将七牛云图片迁移到阿里云
    public void corsQiNiu() throws IOException {
        //通过AK,SK创建Auth 对象, 密钥配置
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        String key;
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                //单次批量请求的文件数量不得超过1000
                String[] keyList = new String[]{
                        item.key,
                };
                BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
                batchOperations.addStatOps(bucket, keyList);
                for (int i = 0; i < keyList.length; i++) {
                    key = keyList[i];
                    helloOSS.httpUrl(key, qiNiuYunImage.urlImage(key));
                }
            }
        }
    }
}
