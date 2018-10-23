package yxpTask6.util.example;

import com.aliyun.oss.*;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Image process examples.
 *
 */
public class ImageUploadSample {

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
    private static String accessKeyId = "LTAIRCsXBFyzT2Vh";
    private static String accessKeySecret = "8FTutNLsK8qJNu7g3epUyzXLFj3VzE";
    private static String bucketName = "yxp-picture";
    private static String key = "Iverson1.gif";


    public static void main(String[] args) throws Exception {

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            String filePath="c:\\gongzuofile\\james2.gif";
            File file=new File(filePath);
            InputStream inputStream=new FileInputStream(file);
            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentLength(inputStream.available());
            meta.setContentLength(file.length());
            PutObjectResult putResult = ossClient.putObject(bucketName,
                    key, inputStream, meta);
            System.out.println(putResult.getETag());
            String imgString="https://"+bucketName+"."+endpoint+"/"+key+"?x-oss-process=style/userImg";
            System.out.println("生成的图片链接为："+imgString);
            // 创建OSSClient实例。
            OSSClient ossClient2 = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            ossClient2.getObject(new GetObjectRequest(bucketName, "Iverson1.gif"), new File("c:\\gongzuofile\\kobe.gif"));
            // 关闭OSSClient。
            ossClient2.shutdown();
        } catch (Exception e) {
            System.out.println("上传图片异常"+e);
        }  finally {
            ossClient.shutdown();
        }
    }
}
