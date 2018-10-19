//import com.qiniu.storage.BucketManager;
//import com.qiniu.storage.model.FileInfo;
//import com.qiniu.storage.persistent.FileRecorder;
//
//import org.junit.Test;
//
////七牛云
//import com.google.gson.Gson;
//import com.qiniu.common.QiniuException;
//import com.qiniu.common.Zone;
//import com.qiniu.http.Response;
//import com.qiniu.storage.Configuration;
//import com.qiniu.storage.UploadManager;
//import com.qiniu.storage.model.DefaultPutRet;
//import com.qiniu.util.Auth;
//
//import com.qiniu.util.StringMap;
//
//import jnshu.dao.AccountMapper;
//import jnshu.dao.StudentMapper;
//import jnshu.pojo.Account;
//import jnshu.util.DES;
//import net.rubyeye.xmemcached.MemcachedClient;
//
//
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import redis.clients.jedis.Jedis;
//
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.nio.file.Paths;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations = "classpath:application.xml")
//public class TestConnection {
////    @Autowired
////    @Qualifier("StudentDAOBean")
////    private StudentMapper studentMapper;
//
//
////    @Test
////    public void saveSerialize(){
////        try {
////            System.out.println(studentMapper.listStudent());
////            System.out.println();
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////
////    }
//
//    String accessKey = "sCWkuBt5EutS4SD2Hlhzdx5Hv2vvNJktRiSpE-ik";
//    String secretKey = "vo6AGujA8QJprzzKycoFHAggqOhE0hdUX6vY3TO9";
//    String bucket = "object";
//
//    //构造一个带指定Zone对象的配置类
//    Configuration cfg = new Configuration(Zone.zone0());
//
//    @Test
//    public void Upload() {
//
//
//        //...其他参数参考类注释
//        UploadManager uploadManager = new UploadManager(cfg);
//
//        //...生成上传凭证，然后准备上传
//
//        //如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "C:\\Users\\user\\Desktop\\qzlg.png";
//
//        //默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = "qqImages/qzlg";
//
//        //请求上传凭证
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket);
//
//        try {
//            //uploadManager上传后无论成功与否都返回一些响应信息
//            Response response = uploadManager.put(localFilePath, key, upToken);
//
//            //解析响应信息中上传的结果   //DefaultPutRet默认放置寄存器
//            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            System.out.println(putRet.key);
//            System.out.println(putRet.hash);
//        } catch (QiniuException ex) {
//            Response r = ex.response;
//            System.err.println(r.toString());
//            try {
//                System.err.println(r.bodyString());
//            } catch (QiniuException ex2) {
//                //ignore
//            }
//        }
//    }
//
////    String fileName2 = "七牛/云存储/qiniu.jpg";
////    String domainOfBucket = "http://devtools.qiniu.com";
////    String encodedFileName = URLEncoder.encode(fileName, "utf-8");
////    String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
////    System.out.println(finalUrl);
//
//    @Test
//    public void Download() {
//        try {
//            String fileName = "qqImages/yg";
//            String domainOfBucket = "pg3fp6klo.bkt.clouddn.com/";
//            String encodedFileName = URLEncoder.encode(fileName, "utf-8");
//            String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
//
//            Auth auth = Auth.create(accessKey, secretKey);
//            long expireInSeconds = 120;//1小时，可以自定义链接过期时间
//            String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
//            System.out.println(finalUrl);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void status() {
//        String fileName = "qqImages/qzlg";
//        Auth auth = Auth.create(accessKey, secretKey);
//        BucketManager bucketManager = new BucketManager(auth, cfg);
//        try {
//            FileInfo fileInfo = bucketManager.stat(bucket, fileName);
//            System.out.println(fileInfo.hash);
//            System.out.println(fileInfo.fsize);
//            System.out.println(fileInfo.mimeType);
//            System.out.println(fileInfo.putTime);
//        } catch (QiniuException ex) {
//            System.err.println(ex.response.toString());
//        }
//    }
//
//    @Test
//    public void delete() {
//        //...其他参数参考类注释
//        String bucket = "object";
//        String key = "qqImages/qzlg";
//        Auth auth = Auth.create(accessKey, secretKey);
//        BucketManager bucketManager = new BucketManager(auth, cfg);
//        try {
//            bucketManager.delete(bucket, key);
//        } catch (QiniuException ex) {
//            //如果遇到异常，说明删除失败
//            System.err.println(ex.code());
//            System.err.println(ex.response.toString());
//        }
//    }
//
//    @Test
//    public void list() {
//
//        String bucket = "object";
//        Auth auth = Auth.create(accessKey, secretKey);
//        BucketManager bucketManager = new BucketManager(auth, cfg);
//        //文件名前缀
//        String prefix = "qqImages/";
//        //每次迭代的长度限制，最大1000，推荐值 1000
//        int limit = 1000;
//        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
//        String delimiter = "";
//        //列举空间文件列表
//        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
//        while (fileListIterator.hasNext()) {
//            //处理获取的file list结果
//            FileInfo[] items = fileListIterator.next();
//            for (FileInfo item : items) {
//                System.out.println(item.key);
////                System.out.println(item.hash);
////                System.out.println(item.fsize);
////                System.out.println(item.mimeType);
////                System.out.println(item.putTime);
////                System.out.println(item.endUser);
//            }
//        }
//    }
//}