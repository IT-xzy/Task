package com.FileCopy;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.model.StudentCustom;
import com.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public class UploadAili {
    private static Logger logger = LoggerFactory.getLogger(UploadAili.class);

    private OSSClient ossClient;
    private Boolean flag = false;
    private String bucketname;
    private String fileUrl;
    private String accessKeyId;
    private String accessKeySecret;
    private String endpoint;

    private String fileName;

    private StudentCustom studentCustom;

    @Autowired
    StudentService serviceDao;

    UploadAili(String accessKeyId, String accessKeySecret, String bucketname, String fileUrl, String endpoint) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
        this.bucketname = bucketname;
        this.fileUrl = fileUrl;
    }

//-----     OSS 连接 服务器
    private OSSClient getOssClient() {
        try {
            logger.info("接数据"+endpoint+"accessKeyId         "+accessKeyId+"       accessKeySecret        "+    accessKeySecret);
            return new OSSClient(endpoint, accessKeyId, accessKeySecret);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("OSSClient 初始化认证失败");
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

    // multipartFile格式上传-------------用不到
    public String updateFile(Integer id, MultipartFile multipartFile) {
        InputStream fi = null;
        try {
            fi = multipartFile.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件流转换失败");
        }
        return updateFileReal(id, fi, fileName, multipartFile.getContentType());
    }


    // InputStream 格式上传 必须填写文件类型  输入流方式上传
    public String updateFile(Integer id, InputStream inputStream, String fileName, String fileType) {
        logger.info("进入方法成功");
        return updateFileReal(id, inputStream, fileName, fileType);
    }


    // 上传
    private String updateFileReal(Integer id, InputStream inputStream, String fileName, String fileType) {
        logger.info(id+"借的到值吗？？？？"+ inputStream +"???"+ fileName+"???"+fileType);
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
                            fileName = fileUrl + fileName;
                            logger.info("入库文件名: " + fileName);
                            studentCustom = new StudentCustom();
                            studentCustom.setHeadurl(fileName);
                            studentCustom.setId(id);
                            // 写入数据库
                            if (serviceDao.updateStudent(studentCustom)) {
                                logger.info("写入数据库成功");
                                return "上传成功";
                            }
                            return "上传成功";
                        }
                    }

                    // 解析结果
                    return putObjectResult.getETag();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("上传文件失败");
                    return "上传文件失败";
                } finally {
                    ossClient.shutdown();
                }
            }
        }
        return "认证失败";
    }

    // 下载----用不到
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

    // 删除----用不到
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
    public void test(){
        System.out.println("可以运行吗？？？？？？");
    }
}

