package com.fgh.task2.Utils;


import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;

import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;

import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qiniu.storage.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class qiniuOSS {
    @Autowired
    OSSTest ossTest;

    Logger logger=LoggerFactory.getLogger(qiniuOSS.class);

    private String accessKey;
    private String secretKey;
    private String bucketName;

    qiniuOSS(String accessKey,String secretKey,String bucketName){
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucketName = bucketName;
    }

    public boolean streamUpload ( MultipartFile file) {

        Auth auth = Auth.create(accessKey,secretKey);
        String token = auth.uploadToken(bucketName);

        // 构造一个带指定Zone对象的配置类
        Zone zone = Zone.zone1();
        Configuration cfg = new Configuration(zone);
        // ...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        // ...生成上传凭证，然后准备上传
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = file.getOriginalFilename();

        try {
            byte[] uploadBytes =file.getBytes();
            InputStream byteInputStream = new ByteArrayInputStream(uploadBytes);
            try {
                Response response = uploadManager.put(byteInputStream, key, token, null, null);
//                 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                logger.debug("上传成功的结果: "+putRet);
                return true;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    // ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            logger.debug("字符转换错误！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean streamUpload (InputStream inputStream,String filename) {
        logger.debug("进入 InputStream-----------------------");
        // ...生成上传凭证，然后准备上传
        Auth auth = Auth.create(accessKey,secretKey);
        String token = auth.uploadToken(bucketName);

        // 构造一个带指定Zone对象的配置类
        Zone zone = Zone.zone1();
        Configuration cfg = new Configuration(zone);
        // ...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        logger.debug("开始上传。。。");
            try {
                Response response = uploadManager.put(inputStream, filename, token, null, null);
                logger.debug("上传结果：");
//                 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                logger.debug("上传成功的结果: "+putRet);
                return true;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    // ignore
                }
            }
        return false;
    }

    /**
     * 列举文件
     * @param prefix
     *          文件名前缀
     * @param delimiter
     *          指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
     * @param bucketName
     *          存储空间
     */
    public List<String> getFile(String prefix, String delimiter, String bucketName){
        List<String> keys = new ArrayList <>();
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        // 构造一个带指定Zone对象的配置类
        Zone zone = Zone.zone1();
        Configuration cfg = new Configuration(zone);

        // ...生成上传凭证，然后准备上传
        Auth auth = Auth.create(accessKey,secretKey);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        try {
            BucketManager.FileListIterator fileListIterator =
                    bucketManager.createFileListIterator(bucketName,prefix,limit,delimiter);
            while (fileListIterator.hasNext()) {
                FileInfo[] items = fileListIterator.next();
                for (FileInfo item : items) {
                   keys.add(item.key);
//                    System.out.println(item.hash);
//                    System.out.println(item.fsize);
//                    System.out.println(item.mimeType);
//                    System.out.println(item.putTime);
//                    System.out.println(item.endUser);
                }
            }
        }catch (Exception e){
            logger.debug("获取空间文件列表失败！");
            e.printStackTrace();
        }
        return keys;
    }

    public String downLoadUrl(String fileName) throws UnsupportedEncodingException {
        String domainOfBucket = "http://pd4wsj3qw.bkt.clouddn.com/";
        String encodeFileName = URLEncoder.encode(fileName,"utf-8");
        String finalUrl = String.format("%s%s",domainOfBucket,encodeFileName);
        logger.debug("下载链接："+ finalUrl);
        return finalUrl;
    }


    public void alitoqiniu (String prefix) throws IOException {
        // 获取阿里云中文件列表（key 文件名）
        List <String> key = ossTest.getFileName(prefix);
        for (String i : key) {
            //获取阿里云下 InputStream
            logger.debug("阿里云下载-");
            InputStream inputStream = ossTest.updown(i);
            logger.debug(i);
            logger.debug("七牛云上传-");
            this.streamUpload(inputStream, i);
        }
    }

}
