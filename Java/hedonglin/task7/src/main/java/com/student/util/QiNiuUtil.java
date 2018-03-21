package com.student.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.DefaultPutRet;
import org.apache.commons.io.IOUtils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FetchRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

public class QiNiuUtil  implements Storage {

    private   String ACCESS_KEY /*= "YJAwOgTtsHhFwxO9Y66JI1w2Rxk0QpmRQSzqWR4-"*/;
    private  String SECRET_KEY /*= "gb9oCINeWdx-ZXxmT60skq-B2a1w_7nAFml8PjRQ"*/;
    /**默认上传空间*/
    private   String BUCKET_NAME/* = *//*"hedonglin"*/;
    /**空间默认域名*/
    private   String BUCKET_HOST_NAME = "http://p5o7nv9t5.bkt.clouddn.com";

    private   Configuration cfg = new Configuration(Zone.zone2());

    private  UploadManager uploadManager = new UploadManager(cfg);

    public  void setAccessKey(String accessKey) {
        ACCESS_KEY = accessKey;
    }

    public  void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    public void setBucketName(String bucketName) {
        BUCKET_NAME = bucketName;
    }

    public void setBucketHostName(String bucketHostName) {
        BUCKET_HOST_NAME = bucketHostName;
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    public void setUploadManager(UploadManager uploadManager) {
       this.uploadManager = uploadManager;
    }

    private  int LIMIT_SIZE = 1000;
    /**
     * @Author: Hedonglin(781190082@qq.com)
     * @Title: listBucket
     * @Description: 返回七牛帐号的所有空间
     * @param @return
     * @param @throws QiniuException
     * @return String[]
     * @throws
     */
    public  String[] listBucket() throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        return bucketManager.buckets();
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: listFileOfBucket
     * @Description: 获取指定空间下的文件列表
     * @param bucketName  空间名称
     * @param prefix      文件名前缀
     * @param limit       每次迭代的长度限制，最大1000，推荐值 100[即一个批次从七牛拉多少条]
     * @param @return
     * @return List<FileInfo>
     * @throws
     */
    public  List<FileInfo> listFileOfBucket(String bucketName,String prefix,int limit) {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        BucketManager.FileListIterator it = bucketManager.createFileListIterator(bucketName, prefix, limit, null);
        List<FileInfo> list = new ArrayList<FileInfo>();
        while (it.hasNext()) {
            FileInfo[] items = it.next();
            if (null != items && items.length > 0) {
                list.addAll(Arrays.asList(items));
            }
        }
        return list;
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param @param inputStream    待上传文件输入流
     * @param @param bucketName     空间名称
     * @param @param key            空间内文件的key
     * @param @param mimeType       文件的MIME类型，可选参数，不传入会自动判断
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public  String uploadFile(InputStream inputStream,String bucketName,String key,String mimeType) throws IOException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(bucketName);
        byte[] byteData = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(byteData, key, token, null, mimeType, false);
        inputStream.close();
        return response.bodyString();
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param @param inputStream    待上传文件输入流
     * @param @param bucketName     空间名称
     * @param @param key            空间内文件的key
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public  void uploadFile(InputStream inputStream,String key) throws IOException {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        com.student.util.Auth auth = com.student.util.Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);

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

            }
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: uploadFile
     * @Description: 七牛图片上传
     * @param filePath     待上传文件的硬盘路径
     * @param fileName     待上传文件的文件名
     * @param bucketName   空间名称
     * @param key          空间内文件的key
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public  String uploadFile(String filePath,String fileName,String bucketName,String key) throws IOException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(bucketName);
        InputStream is = new FileInputStream(new File(filePath + fileName));
        byte[] byteData = IOUtils.toByteArray(is);
        Response response = uploadManager.put(byteData, (key == null || "".equals(key))? fileName : key, token);
        is.close();
        return response.bodyString();
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: uploadFile
     * @Description: 七牛图片上传[若没有指定文件的key,则默认将fileName参数作为文件的key]
     * @param filePath     待上传文件的硬盘路径
     * @param fileName     待上传文件的文件名
     * @param bucketName   空间名称
     * @param @return
     * @param @throws IOException
     * @return String
     * @throws
     */
    public  String uploadFile(String filePath,String fileName,String bucketName) throws IOException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String token = auth.uploadToken(bucketName);
        InputStream is = new FileInputStream(new File(filePath + fileName));
        byte[] byteData = IOUtils.toByteArray(is);
        Response response = uploadManager.put(byteData, fileName, token);
        is.close();
        return response.bodyString();
    }

    /**
     * @throws QiniuException
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: fetchToBucket
     * @Description: 提取网络资源并上传到七牛空间里
     * @param url           网络上一个资源文件的URL
     * @param bucketName    空间名称
     * @param key           空间内文件的key[唯一的]
     * @param @return
     * @return String
     * @throws
     */
    public  String fetchToBucket(String url,String bucketName,String key) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FetchRet putret = bucketManager.fetch(url, bucketName, key);
        return putret.key;
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: fetchToBucket
     * @Description: 提取网络资源并上传到七牛空间里,不指定key，则默认使用url作为文件的key
     * @param url
     * @param bucketName
     * @param @return
     * @param @throws QiniuException
     * @return String
     * @throws
     */
    public  String fetchToBucket(String url,String bucketName) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FetchRet putret = bucketManager.fetch(url, bucketName);
        return putret.key;
    }

    /**
     * @throws QiniuException
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: copyFile
     * @Description: 七牛空间内文件复制
     * @param bucket         源空间名称
     * @param key            源空间里文件的key(唯一的)
     * @param targetBucket   目标空间
     * @param targetKey      目标空间里文件的key(唯一的)
     * @return void
     * @throws
     */
    public  void copyFile(String bucket, String key, String targetBucket, String targetKey) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.copy(bucket, key, targetBucket, targetKey);
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: moveFile
     * @Description: 七牛空间内文件剪切
     * @param bucket         源空间名称
     * @param key            源空间里文件的key(唯一的)
     * @param targetBucket   目标空间
     * @param targetKey      目标空间里文件的key(唯一的)
     * @param @throws QiniuException
     * @return void
     * @throws
     */
    public  void moveFile(String bucket, String key, String targetBucket, String targetKey) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.move(bucket, key, targetBucket, targetKey);
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: renameFile
     * @Description: 七牛空间内文件重命名
     * @param bucket
     * @param key
     * @param targetKey
     * @param @throws QiniuException
     * @return void
     * @throws
     */
    public  void renameFile(String bucket, String key, String targetKey) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.rename(bucket, key, targetKey);
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: deleteFile
     * @Description: 七牛空间内文件删除
     * @param bucket    空间名称
     * @param key       空间内文件的key[唯一的]
     * @param @throws QiniuException
     * @return void
     * @throws
     */
    public  void deleteFile(String bucket, String key) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.delete(bucket, key);
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: findFiles
     * @Description: 返回指定空间下的所有文件信息
     * @param @param bucketName   空间名称
     * @param @param prefix       文件key的前缀
     * @param @param limit        批量提取的最大数目
     * @param @return
     * @param @throws QiniuException
     * @return FileInfo[]
     * @throws
     */
    public  FileInfo[] findFiles(String bucketName,String prefix,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing listing = bucketManager.listFiles(bucketName, prefix, null, limit, null);
        if(listing == null || listing.items == null || listing.items.length <= 0) {
            return null;
        }
        return listing.items;
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: findFiles
     * @Description: 返回指定空间下的所有文件信息
     * @param @param bucketName   空间名称
     * @param @param prefix       文件key的前缀
     * @param @return
     * @param @throws QiniuException
     * @return FileInfo[]
     * @throws
     */
    public  FileInfo[] findFiles(String bucketName,String prefix) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing listing = bucketManager.listFiles(bucketName, prefix, null, LIMIT_SIZE, null);
        if(listing == null || listing.items == null || listing.items.length <= 0) {
            return null;
        }
        return listing.items;
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: findFiles
     * @Description: 返回指定空间下的所有文件信息
     * @param @param bucketName
     * @param @param key
     * @param @return
     * @param @throws QiniuException
     * @return FileInfo[]
     * @throws
     */
    public  FileInfo[] findFiles() throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing listing = bucketManager.listFiles(BUCKET_NAME, null, null, LIMIT_SIZE, null);
        if(listing == null || listing.items == null || listing.items.length <= 0) {
            return null;
        }
        return listing.items;
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: findOneFile
     * @Description: 返回指定空间下的某个文件
     * @param @param bucketName
     * @param @param key
     * @param @param limit
     * @param @return
     * @param @throws QiniuException
     * @return FileInfo
     * @throws
     */
    public  FileInfo findOneFile(String bucketName,String key,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing listing = bucketManager.listFiles(bucketName, key, null, limit, null);
        if(listing == null || listing.items == null || listing.items.length <= 0) {
            return null;
        }
        return (listing.items)[0];
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: findOneFile
     * @Description: 返回指定空间下的某个文件(重载)
     * @param @param bucketName
     * @param @param key
     * @param @return
     * @param @throws QiniuException
     * @return FileInfo
     * @throws
     */
    public  FileInfo findOneFile(String bucketName,String key) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        FileListing listing = bucketManager.listFiles(bucketName, key, null, LIMIT_SIZE, null);
        if(listing == null || listing.items == null || listing.items.length <= 0) {
            return null;
        }
        return (listing.items)[0];
    }

    /**
     * @Author: Lanxiaowei(736031305@qq.com)
     * @Title: getFileAccessUrl
     * @Description: 返回七牛空间内指定文件的访问URL
     * @param @param key
     * @param @return
     * @param @throws QiniuException
     * @return String
     * @throws
     */
    public  String getFileAccessUrl(String key) throws QiniuException {
        return BUCKET_HOST_NAME + "/" + key;
    }
//
//    public  void main(String[] args) throws IOException {
//        //uploadFile("C:/test.jpg");
//
//        /*String[] buckets = listBucket();
//        for(String bucket : buckets) {
//            System.out.println(bucket);
//        }*/
//
//        /*List<FileInfo> list = listFileOfBucket(BUCKET_NAME, null, 1000);
//        for(FileInfo fileInfo : list) {
//            System.out.println("key：" + fileInfo.key);
//            System.out.println("hash：" + fileInfo.hash);
//            System.out.println("................");
//        }*/
//
//        //copyFile(BUCKET_NAME, "images-test", BUCKET_NAME, "images-test-1111");
//
//        //renameFile(BUCKET_NAME, "images-test-1111", "images-test-2222.jpg");
//
//        //deleteFile(BUCKET_NAME, "images-test-2222.jpg");
//
//        //fetchToBucket("http://www.nanrenwo.net/uploads/allimg/121026/14-1210261JJD03.jpg", BUCKET_NAME,"1111111111111111.jpg");
//
//        FileInfo[] fileInfos = findFiles(BUCKET_NAME, "10", LIMIT_SIZE);
//        for(FileInfo fileInfo : fileInfos) {
//            System.out.println(fileInfo.key);
//            System.out.println(fileInfo.hash);
//            System.out.println("..............");
//        }
//    }


    public  InputStream download(String key) throws IOException {
        String fileName = key;
        String domainOfBucket = "http://p5o7nv9t5.bkt.clouddn.com/";
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);
        return new URL(finalUrl).openStream();
    }
}