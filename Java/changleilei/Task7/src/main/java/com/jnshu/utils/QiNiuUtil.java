package com.jnshu.utils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@Service
public class QiNiuUtil {
    private static Logger logger = Logger.getLogger(QiNiuUtil.class);
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static final String accessKey = "Xrmm-z7FtV2cZsQCtIBxIvvuv3o1CL7q4pHhSF1p";
    private static final String secretKey = "HRVrr1Z0iaPY5eVUmL3R-VUT7P41fmUTNA3aFsbk";
    //要上传的空间
    private static final String bucket = "ojbk";
    private static final Configuration cfg = new Configuration(Zone.zone2());
    private static final Auth auth = Auth.create(accessKey, secretKey);
    //private static final String upToken = auth.uploadToken(bucket);
    private static final String domainOfBucket = "http://p618xwbnm.bkt.clouddn.com";

    public static String getupToken() {
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    public static String up(InputStream inputStream, String key) throws QiniuException {
        String finalUrl = null;
        UploadManager uploadManager = new UploadManager(cfg);
        Response response = uploadManager.put(inputStream, key, getupToken(), null, null);
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(putRet.key, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        return finalUrl;
    }

    // 首先遍历七牛
    public static FileInfo[] Qniuall() throws IOException {
        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth, cfg);
        FileInfo[] items = null;
        try {
            FileListing fileListing = bucketManager.listFiles(bucket, null, null, 10, null);
            items = fileListing.items;
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
        }
        return items;
    }

    //下载七牛云文件
    public static String getUrl(String fileName) throws IOException {
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        if (finalUrl != null) {
            return finalUrl;
        }
        return null;
    }

    //检查文件是否存在
    public static Boolean checkFile(String filename) throws IOException {
        FileInfo[] info = Qniuall();
        //遍历文件列表，得到各个文件的文件名
        for (FileInfo fileInfo : info) {
            logger.info("(fileInfo.key)文件名：\t" + fileInfo.key);
            if (fileInfo.key == filename) {
                logger.info("(fileInfo.key == filename)" + (fileInfo.key == filename));
                return true;
            }
        }
        return false;
    }
}

