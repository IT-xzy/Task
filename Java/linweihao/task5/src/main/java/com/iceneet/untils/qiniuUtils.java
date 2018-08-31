package com.iceneet.untils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Component
public class qiniuUtils {
    private static String AccessKey;
    private static String SecretKey;

    @Value("${Qiniu.AccessKey}")
    public void setAccessKey(String accessKey){
        AccessKey = accessKey;
    };

    @Value("${Qiniu.SecretKey}")
    public void setSecretKey(String secretKey){
        SecretKey = secretKey;
    }
    //七牛身份配置
//    private static Auth auth = Auth.create(AccessKey, SecretKey);

    //图片链接前缀
    private static final String prefix = "http://pdw60u2xq.bkt.clouddn.com/";

    private static Configuration cfg = new Configuration(Zone.zone2());
    public static String uploadFile(String localFilePath,String key){
        UploadManager uploadManager = new UploadManager(cfg);
        String bucketname = "image";
        Auth auth =Auth.create(AccessKey,SecretKey);
        String upToken = auth.uploadToken(bucketname);
//        String localFilePath = "C:\\Users\\admin\\Desktop\\war\\坑1.png";
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
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
        return upToken;
    }

    public static String UploadStream(String key,InputStream inputStream){
        UploadManager uploadManager = new UploadManager(cfg);
        String bucketname = "image";
        try {
            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
            Auth auth = Auth.create(AccessKey, SecretKey);
            String upToken = auth.uploadToken(bucketname);
            try {
                Response response = uploadManager.put(inputStream,key,upToken,null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return upToken;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        }
        return "";
    }

    public static List<String> getFileList(){
        Auth auth =Auth.create(AccessKey,SecretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefix = "";
    //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        String bucket = "image";
        List<String> imageList = new ArrayList<>();
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                imageList.add(item.key);
            }
        }
        return imageList;
    }

    public static void fetch(String url,String key){
        Auth auth =Auth.create(AccessKey,SecretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        String bucket = "image";
        try {
            FetchRet putRet = bucketManager.fetch(url, bucket, key);
        } catch (QiniuException ex) {
            System.err.println(ex.response.toString());
        }
    }
    public static String getLink(){
        return prefix;
    }
}
