package com.fangyuyang.service.serviceImpl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.fangyuyang.model.ALiYunKey;
import com.fangyuyang.model.QiNiuKey;
import com.fangyuyang.service.StorageService;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import  java.util.List;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

@Service
public class StorageServiceImpl implements StorageService,Serializable {
    int pictureName = 0;
    Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Autowired
    private QiNiuKey qiNiuKey;
    @Autowired
    private ALiYunKey aLiYunKey;

    public String qiniuPictureSend(ObjectInputStream inputStream) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = qiNiuKey.getAccessKeyId();//"your access key"
        String secretKey = qiNiuKey.getAccessKeySecret();
        String bucket = "picture";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        //    String localFilePath = picturePath;
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key =  String.valueOf(pictureName);
        pictureName++;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            //     Response response = uploadManager.put(localFilePath, key, upToken);
            Response response = uploadManager.put(inputStream, key, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.hash);//还得改
            logger.info("hash : {}", putRet.hash);
            key = putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                System.err.println(ex2.error());
                //ignore
            }
        }
        return key;
    }

    public void qiniuPictureMove(){
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String aliAccessKeyId = aLiYunKey.getAccessKeyId();
        String aliAccessKeySecret = aLiYunKey.getAccessKeySecret();
        String aliBucket = "test-picture-123456";
        //
        /////
        List<String> pictureName = new ArrayList<>();
        List<String> urlName = new ArrayList<>();
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = qiNiuKey.getAccessKeyId();//"your access key"
        String secretKey = qiNiuKey.getAccessKeySecret();
        String bucket = "picture";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        ///每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 999;
        String prefix = "";
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
//列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        int i = 0;
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                System.out.println(item.key);
                urlName.add(item.key);
                if (item.key.contains(".")) {
                    System.out.println("存在");
                    item.key = item.key.substring(0, item.key.length() - 4);
                }
                pictureName.add(item.key);
                System.out.println(pictureName);
            }
        }
        i = 0 ;
        OSSClient ossClient = new OSSClient(endpoint, aliAccessKeyId, aliAccessKeySecret);
//阿里云建立连接
        for(String picture : pictureName) {
            String urlString = "http://p9ffg65uy.bkt.clouddn.com/" + urlName.get(i) ;

            try {
                URL url = new URL(urlString);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String imageName = "E:\\JAVA_TEST\\task7_test3\\src\\main\\webapp\\storage/"
                        + picture + ".jpg";
                FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));

                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                dataInputStream.close();
                fileOutputStream.close();
                bucketManager.delete(bucket,urlName.get(i) );//删除七牛云
                ossClient.putObject(aliBucket, picture, new File(imageName));
                File file=new File(imageName);
                if(file.exists()&&file.isFile())
                    file.delete();
                i++;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println();
                e.printStackTrace();
            }
        }
// 关闭Client。
        ossClient.shutdown();
    }

    public List<String> qiniuPictureShow() {
        List<String> pictureList = new ArrayList<String>();

        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = qiNiuKey.getAccessKeyId();//"your access key"
        String secretKey = qiNiuKey.getAccessKeySecret();
        String bucket = "picture";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        ///每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        String prefix = "";
//指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
//列举空间文件列表

        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                System.out.println(item.key);
                pictureList.add(item.key);//item.min..
            }
        }
        return pictureList;
    }

    public String aliYunPictureSend(String path, String objectName) {
        String state = "";
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = aLiYunKey.getAccessKeyId();
        String accessKeySecret = aLiYunKey.getAccessKeySecret();
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件。

        ossClient.putObject("test-picture-123456", objectName, new File(path));
// 关闭Client。
        ossClient.shutdown();
        return state;
    }

    public  void aliyunPictureSend(ObjectInputStream inputStream) {
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = aLiYunKey.getAccessKeyId();
        String accessKeySecret = aLiYunKey.getAccessKeySecret();
        String bucket = "test-picture-123456";
        String objectName = String.valueOf(pictureName);
        pictureName++;
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 上传文件流。
        ossClient.putObject(bucket, objectName, inputStream);
// 关闭Client。
        ossClient.shutdown();
    }
    public  void aliyunPictureMove(){
        Configuration cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String qiniuAccessKey = qiNiuKey.getAccessKeyId();//"your access key"
        String qiniuSecretKey = qiNiuKey.getAccessKeySecret();
        String bucket = "picture";
        Auth auth = Auth.create(qiniuAccessKey, qiniuSecretKey);
        //////
        ////////////
        String pictureName[] = new String[20] ;
        String path[] = new  String[20];
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String aliAccessKeyId = aLiYunKey.getAccessKeyId();
        String aliAccessKeySecret = aLiYunKey.getAccessKeySecret();
        String bucketName = "test-picture-123456";
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, aliAccessKeyId, aliAccessKeySecret);
// 列举Object。 如KeyPrifex参数为空，则列举Bucket下所有的Object。如KeyPrifex参数不为空，则列举包含指定前缀的Object。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();

        int i = 0;
        String realPath = "E:\\JAVA_TEST\\task7_test3\\src\\main\\webapp\\storage\\";
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
            pictureName[i] = s.getKey();
            path[i] = realPath + s.getKey() ;
            System.out.println("\t" + path[i]);
            ossClient.getObject(new GetObjectRequest(bucketName, s.getKey()),
                    new File(path[i]));
            if(pictureName[i].contains(".")) {
                pictureName[i] = pictureName[i].substring(0, pictureName[i].length() - 4);
            }
            System.out.println("截断后："+pictureName[i]);
            // 删除Object。
            ossClient.deleteObject(bucketName, s.getKey());
            i++;
        }
// 关闭Client。
        ossClient.shutdown();
        i = 0;

        for(String picturePath : path) {
            if(picturePath == null){
                System.out.println("shuju"+i);
                break;
            }
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(picturePath,pictureName[i], upToken);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
            } catch (QiniuException e) {
                Response r = e.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    System.out.println();
                }
            }
            File file=new File(picturePath);
            if(file.exists()&&file.isFile())
                file.delete();
            i++;
        }
    }


    public List<String> aliyunPictureShow() {
        List<String> pictureList = new ArrayList<>();
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = aLiYunKey.getAccessKeyId();
        String accessKeySecret = aLiYunKey.getAccessKeySecret();
        String bucketName = "test-picture-123456";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 列举Object。 如KeyPrifex参数为空，则列举Bucket下所有的Object。如KeyPrifex参数不为空，则列举包含指定前缀的Object。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        String[] path = new String[10];
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
            pictureList.add(s.getKey());
        }

// 关闭Client。
        ossClient.shutdown();
        return pictureList;
    }
}


