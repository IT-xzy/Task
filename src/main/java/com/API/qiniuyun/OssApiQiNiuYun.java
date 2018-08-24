package com.API.qiniuyun;

import com.Pojo.User;
import com.Tool.MD5Util;
import com.Tool.MultFileToIoFile;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.whalin.MemCached.MemCachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OssApiQiNiuYun {
    private static Logger logger = LoggerFactory.getLogger(OssApiQiNiuYun.class);

    private String accessKeyId;
    private String accessKeySecret;
    private String bucketname;    //空间名

    private String fileName = null;    //默认不指定fileName的情况下，以文件内容的hash值作为文件名
    private String fileUrl;

    private Configuration cfg;
    private String zone;
    private String upToken;

    private Auth auth;
    private UploadManager uploadManager;
    private BucketManager bucketManager;
    private User user;



    @Autowired
    MemCachedClient memCachedClient;

    OssApiQiNiuYun(String accessKeyId, String accessKeySecret, String bucketname, String fileUrl, String endpoint) {
        this.bucketname = bucketname;
        this.fileUrl = fileUrl;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        // 七牛封装好的zone
        this.zone = endpoint;
    }


    private Auth getAuth(){
        try {
            return Auth.create(accessKeyId, accessKeySecret);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("七牛 SDK 认证失败");
            return null;
        }
    }


    private Configuration getCfg(){
        // 使用反射获取对应api方法
        Class aClass = Zone.class;
        String className =aClass.getName();
        String methodName = zone;

        try {
            // 实例化对象
            Class<?> clz = Class.forName(className);
            // 获取方法 clz.getMethod(方法名, 方法接收参数类型);
            Method method = clz.getMethod(methodName);
            // 执行方法
            Zone zone = (Zone) method.invoke(null);

            return new Configuration(zone);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.debug("Zone类路径无法找到");
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logger.debug("Zone实例化失败");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.debug("找不到此方法");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            logger.debug("调用方法或构造方法所抛出异常的受检查异常");
        }
        return null;
    }

    private UploadManager getUploadManager(){
        cfg = getCfg();
        if(cfg!=null){
            return new UploadManager(cfg);
        }
        return null;
    }


    private BucketManager getBucketManager(){
        auth = getAuth();
        cfg = getCfg();
        if(auth!=null&&cfg!=null){
            try {
                return new BucketManager(auth, cfg);
            }catch (Exception e){
                e.printStackTrace();
                logger.debug("bucket管理器初始化失败");
            }
        }
        return null;
    }

    public Boolean deleteFile(String keyFile){
        return deleteReal(bucketname, keyFile);
    }
    public Boolean deleteFile(String bucketname, String keyFile){
        return deleteReal(bucketname, keyFile);
    }

    private Boolean deleteReal(String bucketname, String keyFile) {
        bucketManager = getBucketManager();
        if(bucketManager!=null){
            try {
                bucketManager.delete(bucketname, String.valueOf(keyFile));
                return true;
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String updateFile(String id, MultipartFile multipartFile) {
        InputStream fi = null;
        try {
            fi = MultFileToIoFile.multipartToInputStream(multipartFile);
            fileName = MD5Util.getMultipartFileMd5(multipartFile);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件流转换失败");
            return "error";
        }
        return updateFileReal(id, fi, fileName, null);
    }

    public String updateFile(String id, InputStream fi, String fileName, String fileType) {
        return updateFileReal(id, fi, fileName, null);
    }

    public String updateFile(String id, byte[] bytes, String fileName, String fileType) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        return updateFileReal(id, inputStream, fileName, fileType);
    }

    private String updateFileReal(String id, InputStream inputStream, String fileName, String fileType) {
        auth = getAuth();
        if (auth!=null) {
            uploadManager = getUploadManager();
            if(uploadManager!=null){
                try {
                    upToken = auth.uploadToken(bucketname);
                    Response qresponse = uploadManager.put(inputStream, fileName, upToken, null, null);
                    if (qresponse != null) {
                        // 解析上传结果
                        DefaultPutRet putRet = new Gson().fromJson(qresponse.bodyString(), DefaultPutRet.class);
                        logger.debug("上传结果: fileName: " + putRet.key + " hash: " + putRet.hash);
//                        fileName = fileUrl + fileName;
                        fileUrl=fileName+zone;
                        if(id != null){
                            logger.debug("入库文件名: " + fileName);
                            return fileName;
                            }
                        return "error";
                        }
                        return "error";

                } catch (IOException e) {
                    e.printStackTrace();
                    logger.debug("七牛SDK api 连接失败");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.debug("写入数据库失败");
                }finally {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.error("文件流关闭失败");
                    }
                }
            }
        }
        return "error";
    }

    public BucketManager.FileListIterator getObjectList(String bucketname, String prefix, int limit, String delimiter) {
        return getObjectListReal(bucketname, prefix, limit, delimiter);
    }

    public BucketManager.FileListIterator getObjectList(String prefix, int limit, String delimiter) {
        return getObjectListReal(bucketname, prefix, limit, delimiter);
    }

    private BucketManager.FileListIterator getObjectListReal(String bucketname, String prefix, int limit, String delimiter) {
        bucketManager = getBucketManager();
        if (bucketManager != null) {
            return bucketManager.createFileListIterator(bucketname, prefix, limit, delimiter);
        }
        return null;
    }
}