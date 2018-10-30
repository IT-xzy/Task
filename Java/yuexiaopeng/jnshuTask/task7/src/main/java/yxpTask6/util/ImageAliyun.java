package yxpTask6.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yxpTask6.pojo.ServicePojo.AliyunAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;

@Component
public class ImageAliyun
{
    @Autowired
    AliyunAccount aliyunAccount;

    private static String endpoint = "oss-cn-beijing.aliyuncs.com";
//    private String accessKeyId = aliyunAccount.getAccessKeyId();
//    private String accessKeySecret = aliyunAccount.getAccessKeySecret();
//    private String bucketName = aliyunAccount.getBucketName();
    static Logger logger=Logger.getLogger(ImageAliyun.class);
    /*
    图片上传方法
    * @Param imageName上传到阿里云的图片名称；imgPath 上传的文件原始位置
    * @Return 上传到阿里oss后的链接名称*/
    public String uploadImg(String imageName,String imgPath)
    {
        String imgUrl=null;
         String endpoint = "oss-cn-beijing.aliyuncs.com";
         String accessKeyId = aliyunAccount.getAccessKeyId();
         String accessKeySecret = aliyunAccount.getAccessKeySecret();
         String bucketName = aliyunAccount.getBucketName();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            File file=new File(imgPath);
            String key=imageName;
            InputStream inputStream=new FileInputStream(file);
            ObjectMetadata meta = new ObjectMetadata();
//            meta.setContentLength(inputStream.available());
            meta.setContentLength(file.length());
            PutObjectResult putResult = ossClient.putObject(bucketName,
                    key, inputStream, meta);
            System.out.println(putResult.getETag());
            imgUrl="https://"+bucketName+"."+endpoint+"/"+key+"?x-oss-process=style/userImg";
            return imgUrl;
        }
        catch (Exception e)
        {
            logger.info("上传图片错误 : "+e);
        }
        return imgUrl;
    }
    /*
从阿里oss上进行图片下载的方法
* @Param imageName下载的图片名称；imgPath 下载的文件存储的具体路径；
* @Return
* */
    public Boolean downloadImg(String imageName,String imgPath)
    {
        Boolean boo=false;
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = aliyunAccount.getAccessKeyId();
        String accessKeySecret = aliyunAccount.getAccessKeySecret();
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String bucketName = aliyunAccount.getBucketName();
        try {
            // 创建OSSClient实例。
//            OSSClient ossClient2 = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
            ossClient.getObject(new GetObjectRequest(bucketName, imageName), new File(imgPath));
            // 关闭OSSClient。
            ossClient.shutdown();
            boo=true;
            return boo;
        }
        catch (Exception e)
        {
            logger.info("下载图片错误 : "+e);
        }
        return boo;
    }
    //列举oss下的所有文件；
    public List imgList(String bucket)
    {
     List fileList=new Vector();
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = aliyunAccount.getAccessKeyId();
        String accessKeySecret = aliyunAccount.getAccessKeySecret();
        String bucketName = aliyunAccount.getBucketName();
        String KeyPrefix = "";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucketName, KeyPrefix);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
//            System.out.println("\t" + s.getKey());
            fileList.add(s.getKey());
        }
        // 关闭OSSClient。
        ossClient.shutdown();
        return fileList;
    }
}
