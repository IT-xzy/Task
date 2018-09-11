package com.sample;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
//import com.utils.AliyunPhoteUploadUtil;
//import com.utils.QiniuyunPhoteUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class Test {

    @org.junit.jupiter.api.Test
    public void downLoad() throws IOException {
        String fileName="微信图片_20180831220406.png";
        String domainOfBucket = "http://pe94m5liz.bkt.clouddn.com";
        //解决文件名包含中文的问题
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        System.out.println("encodedFileName:   "+encodedFileName);
        //获得图片的地址
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);
        //转化为流
        InputStream inputStream=new URL(finalUrl).openStream();
        System.out.println(inputStream);
    }
    //
    ////阿里云图片下载
    //@org.junit.jupiter.api.Test
    //public void aliyundownLoad() {
    //    String fileName="12afc6ef-7a82-453a-bf53-be75e428b0bf.jpg";
    //    // Endpoint以杭州为例，其它Region请按实际情况填写。
    //    String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    //    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    //    String accessKeyId = "LTAI2TGWKVTWNgdn";
    //    String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
    //    String bucket="aliyunuploadphoto";
    //
    //    try {
    //        System.out.println("\n进入异常判断");
    //        // 创建OSSClient实例。
    //        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    //        System.out.println("ossClient:      "+ossClient);
    //        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
    //        OSSObject ossObject = ossClient.getObject(bucket, fileName);
    //        System.out.println("ossObject:     "+ossObject);
    //        InputStream inputStream=ossObject.getObjectContent();
    //        System.out.println("inputStream:    "+inputStream);
    //    }catch(Exception e){
    //        System.out.println("\n捕获到有异常，异常输出。。。");
    //    }
    //}

    //查询七牛云所有图片
    @org.junit.jupiter.api.Test
    public  void getAllFileName() {
        String accessKeyId = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
        String accessKeySecret = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
        String bucket="zwposs";

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
        System.out.println("\n--------------------------------"+fileListIterator);
        while (fileListIterator.hasNext()) {
            System.out.println("\n--------------------------------"+fileListIterator.hasNext());
            System.out.println("\n--------------------------------"+fileListIterator.toString());
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            System.out.println("\n--------------------------------"+items);
            for (FileInfo item : items) {
                System.out.println(item.key);

            }
        }
    }

    @org.junit.jupiter.api.Test
    public void getAllFileName3(){
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        String accessKeyId = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
        String accessKeySecret = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
        String bucket="zwposs";
        Auth auth = Auth.create(accessKeyId, accessKeySecret);
        BucketManager bucketManager = new BucketManager(auth, cfg);
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
                System.out.println(item.key);
                System.out.println(item.hash);
                System.out.println(item.fsize);
                System.out.println(item.mimeType);
                System.out.println(item.putTime);
                System.out.println(item.endUser);
            }
        }
    }

    //查询阿里云所有图片
    @org.junit.jupiter.api.Test
    public void getAllFileName2() {

        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI2TGWKVTWNgdn";
        String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
        String bucket="aliyunuploadphoto";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucket);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
// 关闭OSSClient。
        ossClient.shutdown();
    }

    // TODO: 2018/9/7 获取空间文件列表 
@org.junit.jupiter.api.Test
    public void getPhotoList(){
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释

    String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
    String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
    String bucket = "zwposs";

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
    while (fileListIterator.hasNext()) {
        //处理获取的file list结果
        FileInfo[] items = fileListIterator.next();
        for (FileInfo item : items) {
            System.out.println(item.key);
            System.out.println(item.hash);
            System.out.println(item.fsize);
            System.out.println(item.mimeType);
            System.out.println(item.putTime);
            System.out.println(item.endUser);
        }
    }

}

    // TODO: 2018/9/7  抓取网络资源到空间
@org.junit.jupiter.api.Test
    public void geturl(){
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释

    String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
    String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
    String bucket = "zwposs";
    String key = "qiniu.png";
    String remoteSrcUrl = "http://devtools.qiniu.com/qiniu.png";

    Auth auth = Auth.create(accessKey, secretKey);
    BucketManager bucketManager = new BucketManager(auth, cfg);

    //抓取网络资源到空间
    try {
        FetchRet fetchRet = bucketManager.fetch(remoteSrcUrl, bucket, key);
        System.out.println(fetchRet.hash);
        System.out.println(fetchRet.key);
        System.out.println(fetchRet.mimeType);
        System.out.println(fetchRet.fsize);
    } catch (QiniuException ex) {
        System.err.println(ex.response.toString());
    }

}

@org.junit.jupiter.api.Test
    public void getAllPhoto(){
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释
    String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
    String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
    String bucket = "zwposs";

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
    while (fileListIterator.hasNext()) {
        //处理获取的file list结果
        FileInfo[] items = fileListIterator.next();
        for (FileInfo item : items) {
            System.out.println(item.key);
            //System.out.println(item.hash);
            //System.out.println(item.fsize);
            System.out.println(item.mimeType);
            System.out.println(item.putTime);
            System.out.println(item.endUser);
        }
    }
}

    // TODO: 2018/9/7 批量复制文件 
@org.junit.jupiter.api.Test
    public void copyAllPhoto(){
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...其他参数参考类注释
    String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
    String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
    String bucket = "zwposs";

    Auth auth = Auth.create(accessKey, secretKey);
    BucketManager bucketManager = new BucketManager(auth, cfg);

    try {
        //单次批量请求的文件数量不得超过1000
        String[] keyList = new String[]{
                "1.jpg",
                "qiniu.mp4",
                "qiniu.png",
        };
        BucketManager.BatchOperations batchOperations = new BucketManager.BatchOperations();
        for (String key : keyList) {
            batchOperations.addCopyOp(bucket, key
                    , bucket, key + "_copy");
        }

        Response response = bucketManager.batch(batchOperations);
        BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);

        for (int i = 0; i < keyList.length; i++) {
            BatchStatus status = batchStatusList[i];
            String key = keyList[i];
            System.out.print(key + "\t");
            if (status.code == 200) {
                System.out.println("copy success");
            } else {
                System.out.println(status.data.error);
            }
        }
    } catch (QiniuException ex) {
        System.err.println(ex.response.toString());
    }
}

}
