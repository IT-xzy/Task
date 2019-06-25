package cn.wp.utils;

import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/14 19:12 @Version: 1.0 */
public class TengXunUtil {
  public String secretId;
  public String secretKey;
  public String regionName;
  public String bucketName;

  public TengXunUtil(String secretId, String secretKey, String regionName, String bucketName) {
    this.secretId = secretId;
    this.secretKey = secretKey;
    this.regionName = regionName;
    this.bucketName = bucketName;
  }

  /** 将本地文件上传到COS */
  public boolean image(String key, File file) {

    //      初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
    //      设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(regionName));
    //      生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);

    //     key只要是能够作为一个唯一表示就可以了
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);

    //     设置存储类型, 默认是标准(Standard), 低频(standard_ia)
    putObjectRequest.setStorageClass(StorageClass.Standard_IA);
    try {
      PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
      //       putobjectResult会返回文件的etag
      String etag = putObjectResult.getETag();
      System.out.println(etag);
    } catch (CosServiceException e) {
      e.printStackTrace();
    } catch (CosClientException e) {
      e.printStackTrace();
    }

    //     关闭客户端
    cosclient.shutdown();
    return true;
  }

  /**
   * @Author: wp @Description: 腾讯云图片迁移到阿里云 @Param: []
   *
   * @return: boolean @Exception: @Date: 2019/6/16 12:05
   */
  public static boolean transfer() {
    //     初始化用户身份信息(secretId, secretKey)
    COSCredentials cred =
        new BasicCOSCredentials(
            "AKIDzCj02sqq447Thfx4kALZEgtqXUDi40sU", "X5XjfLRM4Wp2f290cynTxHL8fGdkjSwA");
    //     设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
    //     生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);

    //     获取文件列表并将文件下载到本地文件夹中
    ObjectListing objectListing = cosclient.listObjects("wangpeng-1259443846");
    List<COSObjectSummary> list = objectListing.getObjectSummaries();
    for (COSObjectSummary s : list) {
      String key = s.getKey();
      GetObjectRequest getObjectRequest = new GetObjectRequest("wangpeng-1259443846", key);
      //       下载图片到本地,由于图片是字节码传输,所以要放到一个.txt文件里
      ObjectMetadata downObjectMeta =
          cosclient.getObject(getObjectRequest, new File("D:/picture/test.txt"));
    }
    //     关闭客户端(关闭后台线程)
    cosclient.shutdown();

    //     创建OSSClient实例
    OSSClient ossClient =
        new OSSClient(
            "http://oss-cn-beijing.aliyuncs.com",
            "LTAIorqiTz9CaG3E",
            "vG7uSBNuxr5RP8KTN3Anu9SSXz1Z26");
    //      获取文件列表,并将文件上传到阿里云
    for (COSObjectSummary s : list) {
      String key = s.getKey();
      File file = new File("D:/picture/test.txt");
      ossClient.putObject("wangpengwpw", key, file);
    }
    //     关闭OSSClient客户端
    ossClient.shutdown();

    return true;
  }

  public static void main(String[] args) {
    transfer();
  }
}
