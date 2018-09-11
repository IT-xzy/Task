package com.utils;

import com.aliyun.oss.OSSClient;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QiniuUp {

    private String accessKey = "AurBmugKh-bh6pq9YoprSEHmwAOA3e0ldPaA6duj";
    private String secretKey = "xLe6PDzwdmza5zYqCqXSue6xDZ26qeH47xYoXv74";
    private String bucket = "zwposs";
    private String format = ".png";
    private String remoteSrcUrl = "http://pe94m5liz.bkt.clouddn.com";

    public String getRemoteSrcUrl() {
        return remoteSrcUrl;
    }

    /**
     * 上传文件
     *
     * @param file
     * @param objectName
     */
    public void uploadFile(CommonsMultipartFile file, String objectName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket, objectName + format);
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Response response = null;
                try {
                    response = uploadManager.put(inputStream, objectName + format, upToken, null, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //解析上传成功的结果
                assert response != null;
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
        } catch (Exception e) {
            e.getMessage();
        }

    }

    /**
     * 获得文件列表
     */
    public List<String> fileList() {
        List<String> list = new ArrayList<>();
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
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
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                list.add(item.key);
                System.out.println(item.key);
            }
        }
        return list;
    }

    /**
     * 文件迁移：七牛迁移到阿里
     */
   public void transfer() throws IOException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI2TGWKVTWNgdn";
        String accessKeySecret = "wrYXWEhkr8MjnNZ1E2WJHthZvXRfAY";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传网络流。
        List<String> list = fileList();
        //遍历所有文件名
        for (String objectname : list) {
            String url = getRemoteSrcUrl();
            //输出所有文件名
            System.out.println(objectname + "\n");
            //拼接Url
            String lastUrl = String.format("%s/%s", url, objectname);
            System.out.println(lastUrl + "\n");
            InputStream inputStream = new URL(lastUrl).openStream();
            //上传文件流
            ossClient.putObject("aliyunuploadphoto", objectname, inputStream);
        }
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
