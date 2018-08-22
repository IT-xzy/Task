package com.jnshu.czm.util;

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
import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QiNiuUtil {

    private static Logger logger= LoggerFactory.getLogger(ALiYunUtil.class);
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    private static String accessKeyId;
    private static String accessKeySecret ;
    private static String bucket;
    private static String domainOfBucket;


    public void setAccessKeyId(String accessKeyId) {
        QiNiuUtil.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        QiNiuUtil.accessKeySecret = accessKeySecret;
    }

    public void setBucket(String bucket) {
        QiNiuUtil.bucket = bucket;
    }

    public void setDomainOfBucket(String domainOfBucket) {
        QiNiuUtil.domainOfBucket = domainOfBucket;
    }

    /**
     * 上传
     * @param fileName
     * @param inputStream
     */
    public static void upLoad(String fileName,InputStream inputStream) {

        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        String key = fileName;

        try {
//            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
//            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);
            Auth auth = Auth.create(accessKeyId, accessKeySecret);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
    }


    /**
     * 下载文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public static InputStream downLoad(String fileName) throws IOException {

        logger.info("\n进入下载文件");
        //解决文件名包含中文的问题
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        logger.info("\nencodedFileName:     "+encodedFileName);
        //获得图片的地址
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        logger.info("\nfinalUrl:   "+finalUrl);
        //将地址转化为流转出去
        System.out.println("................."+new URL(finalUrl).openStream());
        return new URL(finalUrl).openStream();
    }


    /**
     * 获取文件名
     * @return
     */
    public static List<String> getAllFileName() {
        List<String> keys = new ArrayList<>();
        System.out.println("accessKeyId"+accessKeyId);
        System.out.println("accessKeySecret"+accessKeySecret);
        Auth auth = Auth.create(accessKeyId, accessKeySecret);

        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
        //每次迭代的长度限制，最大1000，推荐值 1000

        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";

        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                keys.add(item.key);
//                System.out.println(item.key);
//                System.out.println(item.hash);
//                System.out.println(item.fsize);
//                System.out.println(item.mimeType);
//                System.out.println(item.putTime);
//                System.out.println(item.endUser);
            }
        }
        return keys;
    }
}
