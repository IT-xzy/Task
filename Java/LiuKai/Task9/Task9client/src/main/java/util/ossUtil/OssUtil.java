package util.ossUtil;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketReferer;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OssUtil {
    @Autowired
    OssBean ossBean;

    public void upFile(String ObjectName, MultipartFile file) throws IOException {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(ossBean.getEndpoint(), ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
        ossClient.createBucket(ossBean.getBucketName());
        //设置下载时文件类型
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(ossBean.getContentype());

        //设置防盗链
//        List<String> refererlist = new ArrayList<String>();
//        refererlist.add("47.96.95.132");
//        BucketReferer br = new BucketReferer(false, refererlist);
//        ossClient.setBucketReferer(ossBean.getBucketName(), br);
        ossClient.putObject(ossBean.getBucketName(), ObjectName, new ByteArrayInputStream(file.getBytes()), objectMetadata);
        ossClient.shutdown();
    }
}
