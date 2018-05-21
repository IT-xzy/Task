package lujing.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;

/**
 * @author lujing
 * Create_at 2018/1/17 10:55
 */
public class FileUtils {
    // 1 初始化用户身份信息(secretId, secretKey)
    static COSCredentials cred = new BasicCOSCredentials("AKID1wskR7t8MPI1kNuj9ayDH8nGcophKwHQ", "DID6pMkw9RL8mHepobGm6KPL5i9RvIWY");
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    static ClientConfig clientConfig = new ClientConfig(new Region("ap-chengdu"));
    // 3 生成cos客户端
    static COSClient cosClient = new COSClient(cred, clientConfig);
    // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
    static String bucketName = "lujing0613-1255932852";
    
    public static void uploadxx() {
        File localFile = new File("F:\\1.txt");
        // 指定要上传到 COS 上的路径
        String key = "/upload_single_demo.txt";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(putObjectResult.getETag());
    }
    
//    public static void main(String[] args) {
//        uploadxx();
//    }
}
