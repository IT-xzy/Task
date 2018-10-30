import com.aliyun.oss.OSSClient;
import com.jns.entity.Cos;
import com.jns.utils.CosDemo;
import com.jns.utils.OssDemo;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.GetObjectRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class cosToOss {
    public  static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        Cos cos= (Cos) applicationContext.getBean("cos");
        String bucketName=cos.getBucketName();
        COSClient cosClient=CosDemo.getCosClient();
        OSSClient ossClient=OssDemo.getOssClient();
        //获取列表中文件名
        List<String> list=CosDemo.getKey(cosClient);
        COSObjectInputStream cosObjectInputStream;
        InputStream inputStream;
        for(String str:list){
            //通过GetObjectRequest获取Object
            GetObjectRequest getObjectRequest=new GetObjectRequest(bucketName,str);
            COSObject cosObject=cosClient.getObject(getObjectRequest);
            //获取输入流包含该对象的内容。
            cosObjectInputStream=cosObject.getObjectContent();
            inputStream=cosObjectInputStream;
            //上传文件流
            OssDemo.updInputStream(ossClient,inputStream,str);
            inputStream.close();
        }
        cosClient.shutdown();
        OssDemo.closeOosClient(ossClient);
    }
}
