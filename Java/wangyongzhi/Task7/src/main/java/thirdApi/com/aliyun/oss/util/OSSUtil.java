package thirdApi.com.aliyun.oss.util;

import com.aliyun.oss.OSSClient;
import thirdApi.OssService;

import java.io.File;
import java.io.FileInputStream;

/**
 * @Description: 阿里云OSS实现类
 */
public class OSSUtil implements OssService {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private String endpoint;
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private String accessKeyId;
    private String accessKeySecret;
//    // 创建OSSClient实例。
//    private static OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    private String bucketName;

    private String url;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void uploadFile(String name, String localFile) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName, name, new File(localFile));
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    // 上传文件流,传入FileInputStream对象
    public void uploadFile(String name, FileInputStream fileInputStream){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, name, fileInputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public Boolean isExist(String objectName){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 判断文件是否存在。
        boolean found = ossClient.doesObjectExist(bucketName, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return found;
    }

    public void deleteImage(String objectName){
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
