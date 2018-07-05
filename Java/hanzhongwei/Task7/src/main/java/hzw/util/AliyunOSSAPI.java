package hzw.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.whalin.MemCached.MemCachedClient;
import hzw.model.User;
import hzw.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * @program: SSM_WEB
 * @description: 阿里云OSS API
 * @author: Mr.xweiba
 * @create: 2018-06-05 17:40
 **/

public class AliyunOSSAPI {
    private static Logger logger = LoggerFactory.getLogger(AliyunOSSAPI.class);

    private OSSClient ossClient;
    private Boolean flag = false;
    private String bucketname = "jimo621";
    private String accessKeyId = "LTAIw8a285xdQ9ge";
    private String accessKeySecret = "mddtauRgDZd0BeW2f6DGQi8fQB3Epv";
    private String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private String endpoint1 = "oss-cn-beijing.aliyuncs.com";

    @Autowired
    StudentService studentService;

   /* private AliyunOSSAPI(String endpoint,String accessKeyId,String accessKeySecret,String bucketname){

    }*/

    private OSSClient getOssClient() {
        try {
            return new OSSClient(endpoint, accessKeyId, accessKeySecret);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("OSSClient 初始化认证失败");
            return null;
        }
    }

    public boolean createBucket(String bucketName) {
        ossClient = getOssClient();
        if (ossClient != null) {
            try {
                Bucket bucket = ossClient.createBucket(bucketName);
                flag = bucketName.equals(bucket.getName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ossClient.shutdown();
            }
        }
        return flag;
    }

    public boolean deleteBucket(String bucketName) {
        ossClient = getOssClient();
        if (ossClient != null) {
            try {
                ossClient.deleteBucket(bucketName);
                flag = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ossClient.shutdown();
            }
        }
        return flag;
    }

    // multipartFile格式上传
    public Boolean updateFile(Long id, MultipartFile multipartFile, String fileName) {
        InputStream fi = null;
        try {
            fi = MultFileToIoFile.multipartToInputStream(multipartFile);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件流转换失败");
        }
        return updateFileReal(id, fi, fileName, multipartFile.getContentType());
    }

    // InputStream 格式上传 必须填写文件类型
    public Boolean updateFile(Long id, InputStream inputStream, String fileName, String fileType) {
        return updateFileReal(id, inputStream, fileName, fileType);
    }

    // 上传
    private Boolean updateFileReal(Long id, InputStream inputStream, String fileName, String fileType) {
        ossClient = getOssClient();
        if (ossClient != null) {
            if (inputStream != null) {
                try {
                    int fileSize = inputStream.available();
                    logger.info("fileName/fileSize: " + fileName + "/" + fileSize);
                    // ObjectMetadate 是对该上传对象的描述
                    ObjectMetadata metadata = new ObjectMetadata();
                    // 设置文件长度 就这一个必选参数
                    metadata.setContentLength(fileSize);
                    // 可选参数
                    metadata.setCacheControl("no-cache");
                    metadata.setHeader("Pragma", "no-cache");
                    metadata.setContentEncoding("UTF-8");
                    // 文件类型
                    metadata.setContentType(fileType);
                    metadata.setContentDisposition("fileName/filesize" + fileName + "/" + fileSize + "byte");
                    // 上传文件
                    PutObjectResult putObjectResult = ossClient.putObject(bucketname, fileName, inputStream, metadata);
                    // id 等于null 为文件复制, 暂时不入库, 准备改造为入库只存放文件名, 不存放oss地址, 前端接收图片地址再作拼接. 后期切换更加方便. 无需修改数据库.
                    if (id != null) {
                        if (putObjectResult != null) {
//                            fileName = fileUrl + fileName;
                            logger.info("入库文件名: " + fileName);
                            User user = new User(Long.valueOf(id),fileName);
                            //user.setUserPhoto(fileName);
                            //user.setUserId(Long.valueOf(id));
                            // 写入数据库
                            studentService.updateUser1(user);
                            logger.info("写入数据库成功");
                            return true;
                        }
                    }
                     //解析结果
                    logger.info(putObjectResult.getETag());
                    return false;
//                    return "上传成功";
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("上传文件失败");
                    return false;
                } finally {
                    ossClient.shutdown();
                }
            }
        }
        return false;
    }

    // 下载
    public InputStream getFile(String fileName) {
        ossClient = getOssClient();
        if (ossClient != null) {
            try {
                OSSObject ossObject = ossClient.getObject(bucketname, fileName);
                return ossObject.getObjectContent();
            } catch (Exception e) {
                e.printStackTrace();
                logger.debug("下载错误");
            } finally {
                ossClient.shutdown();
            }
        }
        return null;
    }

    // 删除
    public boolean deleteFile(String fileName) {
        ossClient = getOssClient();
        try {
            ossClient.deleteObject(bucketname, fileName);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除错误");
        } finally {
            ossClient.shutdown();
        }
        return false;
    }

    //获取连接
    public String getUrl(String fileName){
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(bucketname);
        sb.append(".");
        sb.append(endpoint1);
        sb.append("/");
        sb.append(fileName);
        //将图缩略成宽度为200，高度为200，按长边优先,拼接在url后面就行
        sb.append("?x-oss-process=image/resize,m_lfit,h_200,w_200");
        return sb.toString();
    }

    //获取连接1
    //用与获取带签名的url
    public String geturl1(String fileName) {
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + 3600 * 1000);
        // 生成URL。
        URL url = ossClient.generatePresignedUrl(bucketname, fileName, expiration);
        return url.toString();
    }
}
