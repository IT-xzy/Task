package com.zyq.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class OSSClientUtil {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    OSSBean ossBean = (OSSBean) applicationContext.getBean("ossBean");
    OSSClient ossClient = new OSSClient(ossBean.getEndpoint(), ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
    private OSSClient oSSClient;

    public OSSClientUtil() {
        oSSClient = new OSSClient(ossBean.getEndpoint(), ossBean.getAccessKeyId(), ossBean.getAccessKeySecret());
    }

    public void destory() {
        oSSClient.shutdown();
    }

    public InputStream getFile(String key) {
        if ("/".equals(key.substring(0, 1))) {
            key = key.substring(1);
        }
        OSSObject ossObject = ossClient.getObject(ossBean.getOssBucketName(), key);
        destory();
        return ossObject.getObjectContent();
    }

    public String uploadFile(String key, File file) {
        String etag = null;
        try {
            UploadFileRequest uploadFileRequest = new UploadFileRequest(ossBean.getOssBucketName(), key);
            // The local file to upload---it must exist.
            uploadFileRequest.setUploadFile(file.getPath());
            // Sets the concurrent upload task number to 5.
            uploadFileRequest.setTaskNum(5);
            // Sets the part size to 1MB.
            uploadFileRequest.setPartSize(1024 * 1024 * 1);
            // Enables the checkpoint file. By default it's off.
            uploadFileRequest.setEnableCheckpoint(true);

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            CompleteMultipartUploadResult multipartUploadResult =
                    uploadResult.getMultipartUploadResult();
            System.out.println(multipartUploadResult.getETag());
            etag = multipartUploadResult.getETag();

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message: " + oe.getErrorCode());
            System.out.println("Error Code:       " + oe.getErrorCode());
            System.out.println("Request ID:      " + oe.getRequestId());
            System.out.println("Host ID:           " + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ce.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return etag;
    }
}
