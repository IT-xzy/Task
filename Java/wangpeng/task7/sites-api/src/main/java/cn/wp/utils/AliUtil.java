package cn.wp.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/14 19:12 @Version: 1.0 */
public class AliUtil {
  public String endpoint;
  public String accessKeyId;
  public String accessKeySecret;
  public String bucketName;

  public AliUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
    this.endpoint = endpoint;
    this.accessKeyId = accessKeyId;
    this.accessKeySecret = accessKeySecret;
    this.bucketName = bucketName;
  }

  public boolean uploadImage(MultipartFile file) throws IOException {

    // 创建OSSClient实例。
    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

    String key = System.currentTimeMillis() + file.getOriginalFilename();
    // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。

    ossClient.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
    // 关闭OSSClient。
    ossClient.shutdown();
    return true;
  }
  /**
   * @Author: wp @Description: 阿里云图片迁移到腾讯云 @Param: []
   *
   * @return: boolean @Exception: @Date: 2019/6/16 12:00
   */
  public static boolean transfer() {
    //     创建OSSClient实例
    OSSClient ossClient =
        new OSSClient(
            "http://oss-cn-beijing.aliyuncs.com",
            "LTAIorqiTz9CaG3E",
            "vG7uSBNuxr5RP8KTN3Anu9SSXz1Z26");
    //     获取文件列表并将文件下载到本地文件夹中
    //
    //     ObjectListing是一个实体类,
    //     listObjects是一个返回值为ObjectListing的方法,bucketName作为参数传入,返回对象名(key)
    ObjectListing objectListing = ossClient.listObjects("wangpengwpw");
    //     ObjectListing类型的集合list装入bucket里的文件
    List<OSSObjectSummary> list = objectListing.getObjectSummaries();
    //     遍历list,获取所有的key
    for (OSSObjectSummary s : list) {
      String key = s.getKey();
      ossClient.getObject(
          new GetObjectRequest("wangpengwpw", key), new File("D:/picture/test2.txt"));
    }
    //    关闭客户端
    ossClient.shutdown();

    //     初始化用户身份信息(secretId, secretKey)
    COSCredentials cred =
        new BasicCOSCredentials(
            "AKIDzCj02sqq447Thfx4kALZEgtqXUDi40sU", "X5XjfLRM4Wp2f290cynTxHL8fGdkjSwA");
    //     设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
    //     生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);
    //     获取文件列表,并将文件上传到腾讯云
    for (OSSObjectSummary c : list) {
      String key = c.getKey();
      File file = new File("D:/picture/test2.txt");
      PutObjectRequest putObjectRequest = new PutObjectRequest("wangpeng-1259443846", key, file);
      cosclient.putObject(putObjectRequest);
    }
    //     关闭客户端
    cosclient.shutdown();

    return true;
  }

  public static void main(String[] args) {
    transfer();
  }
}
