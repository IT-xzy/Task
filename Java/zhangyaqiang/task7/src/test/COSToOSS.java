import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.zyq.util.COSBean;
import com.zyq.util.OSSBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

public class COSToOSS {
    private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void cosToOSSTest(){
        COSBean cosBean = (COSBean) applicationContext.getBean("cosBean");
        OSSBean ossBean = (OSSBean) applicationContext.getBean("ossBean");
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(cosBean.getSecretId(), cosBean.getSecretKey());
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(cosBean.getReginName()));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        OSSClient ossClient = new OSSClient(ossBean.getEndpoint(),ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        // 设置bucket名称
        listObjectsRequest.setBucketName(cosBean.getCosBucketName());
        // prefix表示列出的object的key以prefix开始
        listObjectsRequest.setPrefix("");
        // deliter表示分隔符, 设置为/表示列出当前目录下的object, 设置为空表示列出所有的object
        listObjectsRequest.setDelimiter("");
        // 设置最大遍历出多少个对象, 一次listobject最大支持1000
        listObjectsRequest.setMaxKeys(1000);
        ObjectListing objectListing = null;
        do {

            try {
                objectListing = cosClient.listObjects(listObjectsRequest);
            } catch (CosServiceException e) {
                e.printStackTrace();
                return;
            } catch (CosClientException e) {
                e.printStackTrace();
                return;
            }
            // common prefix表示表示被delimiter截断的路径, 如delimter设置为/, common prefix则表示所有子目录的路径
            List<String> commonPrefixs = objectListing.getCommonPrefixes();

            // object summary表示所有列出的object列表
            List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
            int i=1;
            for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
                // 文件的路径key
                String key = cosObjectSummary.getKey();
                // 文件的etag
                String etag = cosObjectSummary.getETag();
                // 文件的长度
                long fileSize = cosObjectSummary.getSize();
                // 文件的存储类型
                String storageClasses = cosObjectSummary.getStorageClass();
                System.out.println(key+"(key)..."+etag+"(etag)..."+fileSize+"(fileSize)..."+storageClasses+"(storageClasses)..."+i++);
                GetObjectRequest getObjectRequest = new GetObjectRequest(cosBean.getCosBucketName(), key);
                COSObject cosObject = cosClient.getObject(getObjectRequest);
                COSObjectInputStream cosObjectInput = cosObject.getObjectContent();

                InputStream inputStream = cosObjectInput;
                ossClient.putObject(ossBean.getOssBucketName(), key, inputStream);

            }

            String nextMarker = objectListing.getNextMarker();
            listObjectsRequest.setMarker(nextMarker);
        } while (objectListing.isTruncated());

        cosClient.shutdown();
        ossClient.shutdown();
    }
}
