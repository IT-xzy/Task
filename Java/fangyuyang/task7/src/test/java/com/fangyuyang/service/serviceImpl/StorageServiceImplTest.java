package com.fangyuyang.service.serviceImpl;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.fangyuyang.model.ALiYunKey;
import com.fangyuyang.model.QiNiuKey;
import com.fangyuyang.subsidiary.LoginInterceptor;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.StreamUploader;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.fangyuyang.service.StorageService;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StorageServiceImplTest {

    @Autowired
    private StorageService storageService;
    @Autowired
    private QiNiuKey qiNiuKey;
    @Autowired
    private ALiYunKey aLiYunKey;

    @Test
    public void qiniu(){
        storageService.qiniuPictureMove();
    }

    @Test
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
    @Test
    public void pictureList(){
      //  System.out.println(storageService.aliyunPictureShow());
        System.out.println(storageService.qiniuPictureShow());
    }
    @Test
    public void qiniuPictureSend() throws UnsupportedEncodingException {
        //    storageService.PictureSend("E:\\JAVA_TEST\\task7_test2\\src\\main\\webapp\\t10\\images\\14.png");
//构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = qiNiuKey.getAccessKeyId();//"your access key"
        String secretKey = qiNiuKey.getAccessKeySecret();
        String bucket = "picture";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = "5";
        String localFilePath = "E:\\学习资料\\JAVA工作\\小课堂\\1.jpg";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
            }
        }

//        try {
//            bucketManager.delete(bucket, "1");
//        } catch (QiniuException e) {
//            //如果遇到异常，说明删除失败
//            System.err.println(e.code());
//            System.err.println(e.response.toString());
//        }
    }

    @Test
    public void qiniuPictureList(){
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
            }
        }
    }
    @Test
    public void qiniuPictureDownload() {
        int imageNumber = 1;
        String urlString = "http://p9ffg65uy.bkt.clouddn.com/2";
        try {
            URL url = new URL(urlString);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String imageName = "E:\\JAVA_TEST\\task7_test3\\src\\main\\webapp\\storage/"
                    +imageNumber + ".jpg";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void aliYunSend() throws FileNotFoundException {
        InputStream inputStream  = new FileInputStream("E:\\JAVA_TEST\\task7_test3\\src\\main\\webapp\\pic\\1hb3.jpeg") ;
        storageService.aliyunPictureSend(inputStream);
    }
    @Test
    public void aliYun(){
//        storageService.aliYunPictureSend("E:\\学习资料\\JAVA工作\\小课堂\\2.jpg",
//                "pic1");

        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = aLiYunKey.getAccessKeyId();
        String accessKeySecret = aLiYunKey.getAccessKeySecret();
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String objectName = "pic1";
        String bucketName = "test-picture-123456";
// 下载Object到文件。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName),
                new File("E:\\学习资料\\JAVA工作\\小课堂\\99.jpg"));
// 关闭Client。
        ossClient.shutdown();
    }
@Test
    public void aliyunTest() throws InterruptedException {
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
    String pictureName[] = new String[10] ;
    String path[] = new  String[10];
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

        pictureName[i] = pictureName[i].substring(0,pictureName[i].length()-4);
        System.out.println("截断："+pictureName[i]);
        ossClient.deleteObject(bucketName, s.getKey());
        i++;
    }
// 关闭Client。
    ossClient.shutdown();
    i = 0;

    for(String picturePath : path) {
        if(picturePath == null){

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

            }
        }
        File file=new File(picturePath);
        if(file.exists()&&file.isFile())
            file.delete();

        i++;
    }
}
}
