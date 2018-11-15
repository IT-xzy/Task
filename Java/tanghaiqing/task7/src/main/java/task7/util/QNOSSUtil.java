package task7.util;

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
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class QNOSSUtil {
    private static Logger logger = Logger.getLogger(QNOSSUtil.class);
    //...生成上传凭证，然后准备上传
    private static String accessKey = "fcfuCi9ouHWcAGLTzIhfgJEotyfUHysTymBKTMuo";
    private static String secretKey = "iJpN8bFOToGmktnQmjuJSpLhm7BMWSxktIl3fwkz";
    private static String bucket = "task7";
    private static BucketManager bucketManager;
    private static UploadManager uploadManager;
    private static Configuration cfg;
    private static Auth auth;
    private static String uotoken;
    private static String domainOfBucket = "http://phswsdp1x.bkt.clouddn.com";

    //获取上传凭证token
    static {
        if (uotoken == null) {
            auth = Auth.create(accessKey, secretKey);
            uotoken = auth.uploadToken(bucket);
            logger.info(uotoken);
        }
    }

    //初始化UploadManager
    static {
        if (uploadManager == null) {
            logger.info("初始化uploadManager");
            //构造一个带指定Zone对象的配置类
            cfg = new Configuration(Zone.huanan());
            //...其他参数参考类注释
            uploadManager = new UploadManager(cfg);
        }
    }

    //初始化BucketManager
    static {
        if (bucketManager == null) {
            logger.info("初始化BucketManager");
            bucketManager = new BucketManager(auth, cfg);
        }
    }

    /**
     * 利用流上传至七牛云上
     *
     * @param file 图片输入流
     * @return 返回的是上传后的key值
     */
    public static String uploadImage(MultipartFile file) {
        String name = null;
        try {
            name = getName(file);
            InputStream in = file.getInputStream();
            Response response = uploadManager.put(in, name, uotoken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            name = putRet.key;
            logger.info("上传成功后的key：" + name);
        } catch (IOException e) {
            logger.error("工具类：QNOSSUtil.uploadImage执行错误！");
            e.printStackTrace();
        }
        return name;
    }

    /**
     * 获取七牛云的资源链接
     *
     * @param key 七牛云上的资源名
     * @return url
     */
    public static String getUrl(String key) {
        logger.info("进入工具类：QNOSSUtil.getUrl");
        // 生成URL
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(key, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("进入工具类：QNOSSUtil.getUrl：生成Url错误");
            e.printStackTrace();
        }
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        logger.info(finalUrl);
        return finalUrl;
    }

    /**
     * 本地文件上传
     *
     * @param file 本地文件目录
     * @return 文件的url
     */
    public static String uploadUrl(String file) {
        logger.info("进入工具类：QNOSSUtil.uploadUrl");
        String key = file.substring(file.lastIndexOf("."));
        logger.info(key);
        String Url = null;
        try {
            Response response = uploadManager.put(file, key, uotoken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            file = getUrl(putRet.key);
        } catch (QiniuException e) {
            logger.error("工具类：QNOSSUtil.uploadUrl:错误");
            e.printStackTrace();
        }
        return file;
    }

    /**
     * 根据流获取文件格式，然后生成一个随机名字
     *
     * @param file 流文件
     * @return 随机名字
     */
    public synchronized static String getName(MultipartFile file) {
        String name = null;
        String originalFilename = file.getOriginalFilename();
        String substring = null;
        if (originalFilename != null) {
            substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            Random random = new Random();
            name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        }
        return name;
    }

    /**
     * 根据链接抓取网路资源
     * @param url 网络资源的url
     */
    public static void captureResource(String url) {
        String key = url.substring(url.lastIndexOf("/")+1);
        try {
            FetchRet fetchRet = bucketManager.fetch(url, bucket, key);
            System.out.println(fetchRet.key);
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
    // 首先遍历七牛
    public static List<String> Qniuall() {
       logger.info("进入Qniuall");
       List<String> keys=new ArrayList<>();
        FileInfo[] items = null;
        try {
            FileListing fileListing = bucketManager.listFiles(bucket, null, null, 10, null);
            items = fileListing.items;
            for (FileInfo fileInfo:items){
                keys.add(fileInfo.key);
            }
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
        }
        logger.info(keys.toString());
        return keys;
    }



    public static void main(String[] args) {
        //System.out.println(uploadUrl("http://tas7haiqing.oss-cn-beijing.aliyuncs.com/data/1541766041895.jpg"));
        //captureResource("http://tas7haiqing.oss-cn-beijing.aliyuncs.com/data/1541766041895.jpg");
        List<String> list =Qniuall();
        for (String key:list){
            System.out.println(key);
        }
    }
}
