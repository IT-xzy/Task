package com.jnshu.tools;

import com.google.gson.Gson;
import com.jnshu.model.StudentCustom;
import com.jnshu.service.ServiceDao;
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

/**
 * @program: SSM_WEB
 * @description: 头像上传SDK
 * @author: Mr.xweiba
 * @create: 2018-06-04 00:03
 **/

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
    private StudentCustom studentCustom;


    @Autowired
    ServiceDao serviceDao;
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

    /**
     * @description 七牛SDK认证对象
     * @param: []
     * @return: com.qiniu.util.Auth
     * @author: Mr.xweiba
     * @date: 2018/6/6 2:43
     * @since: 1.0.0
     */
    private Auth getAuth(){
        try {
            return Auth.create(accessKeyId, accessKeySecret);
        }catch (Exception e){
            e.printStackTrace();
            logger.debug("七牛 SDK 认证失败");
            return null;
        }
    }

    /**
     * @description 获取OSS指定地区节点配置
     * @param: []
     * @return: com.qiniu.storage.Configuration
     * @author: Mr.xweiba
     * @date: 2018/6/6 3:21
     * @since: 1.0.0
     */
    private Configuration getCfg(){
        // 使用反射获取对应api方法
        String className = "com.qiniu.common.Zone";
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

    /**
     * @description 获取bucket管理器对象
     * @param: []
     * @return: com.qiniu.storage.BucketManager
     * @author: Mr.xweiba
     * @date: 2018/6/6 2:47
     * @since: 1.0.0
     */
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

    public Boolean updateFile(Integer id, MultipartFile multipartFile) {
        InputStream fi = null;
        try {
            fi = MultFileToIoFile.multipartToInputStream(multipartFile);
            fileName = MD5Util.getMultipartFileMd5(multipartFile);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件流转换失败");
            return false;
        }
        return updateFileReal(id, fi, fileName, null);
    }

    public Boolean updateFile(Integer id, InputStream fi, String fileName, String fileType) {
        return updateFileReal(id, fi, fileName, null);
    }

    public Boolean updateFile(Integer id, byte[] bytes, String fileName, String fileType) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        return updateFileReal(id, inputStream, fileName, fileType);
    }

    private Boolean updateFileReal(Integer id, InputStream inputStream, String fileName, String fileType) {
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
                        fileName = fileUrl + fileName;
                        if(id != null){
                            logger.debug("入库文件名: " + fileName);
                            studentCustom = new StudentCustom();
                            studentCustom.setHeadurl(fileName);
                            studentCustom.setId(id);
                            // 写入数据库
                            if (serviceDao.updateStudent(studentCustom)) {
                                logger.debug("写入数据库成功");
                                return true;
                            }
                        }
                        return true;
                    }
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
        return false;
    }

    /**
     * @description 获取文件列表
     * @param: [bucketname] OSS名
     * @param: [prefix] 文件前缀
     * @param: [limit] 每次迭代的长度限制，最大1000，推荐值 1000
     * @param: [delimiter] 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
     * @return: com.qiniu.storage.BucketManager.FileListIterator
     * @author: Mr.xweiba
     * @date: 2018/6/5 22:29
     * @since: 1.0.0
     */
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