import com.aliyun.oss.OSSClient;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.COSObjectInputStream;
import com.qcloud.cos.model.GetObjectRequest;
import com.task5.until.AliyunOSSClientUntil;
import com.task5.until.CosUntil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class CosToOss {
    Logger logger = Logger.getLogger("CosToOss");
    @Test
    public void to()throws IOException{
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Cos cos = (Cos) applicationContext.getBean("cos");
        String bucketName= "zx520-1257733330";
        COSClient cosClient= CosUntil.getCosClient();
        OSSClient ossClient= AliyunOSSClientUntil.getOSSClient();
        //获取列表中文件名
        List<String> list=CosUntil.getKey(cosClient);
        COSObjectInputStream cosObjectInputStream;
        InputStream inputStream;
        for(String string:list){
            //通过GetObjectRequest获取Object
            GetObjectRequest getObjectRequest=new GetObjectRequest(bucketName,string);
            COSObject cosObject=cosClient.getObject(getObjectRequest);
            //获取输入流包含该对象的内容。
            cosObjectInputStream=cosObject.getObjectContent();
            inputStream=cosObjectInputStream;
            //上传文件流
            AliyunOSSClientUntil.updInputStream(ossClient,inputStream,string);
            inputStream.close();
        }
        cosClient.shutdown();
        AliyunOSSClientUntil.destory(ossClient);
    }
    }
