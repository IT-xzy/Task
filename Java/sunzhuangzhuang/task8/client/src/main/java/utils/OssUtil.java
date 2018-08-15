package utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


public class OssUtil {
    private Logger logger = Logger.getLogger(OssUtil.class);
    private String endpoint = "oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "LTAIu27Mmc4ZHFcK";
    private String accessKeySecret = "pxcJIxV43HSmQFi7pDmMTe9JwkCID6";
    private String bucketName = "imageku";

    public void upImage(MultipartFile file,String name) throws IOException {
// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);
//// 上传Byte数组。
        byte[] content = file.getBytes();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpeg");
        ossClient.putObject(bucketName,name, new ByteArrayInputStream(content),objectMetadata);
// 关闭OSSClient。
        ossClient.shutdown();
    }

    //判断OSS服务文件上传时文件是contentType
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }



//    public String uploadFile20SS(InputStream inStream, String fileName) {
//        String ret = "";
//        try {
//
//            //创建上传Object的Metadata
//            ObjectMetadata objectMetadata = new ObjectMetadata();
//            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
//            objectMetadata.setContentDisposition("inline;filename=" + fileName);
//            //上传文件
//            PutObjectResult putResult = ossClient.putObject(bucketName, fileName, inStream, objectMetadata);
//            ret = putResult.getETag();
//        } catch (IOException e) {
//            logger.error(e.getMessage(), e);
//        } finally {
//            try {
//                if (inStream != null) {
//                    inStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return ret;
//    }


//
//    //获得过期时间
//    public String getUrl(String key) {
//        // 设置URL过期时间为10年  3600l* 1000*24*365*10
//        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
//        // 生成URL
//        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
//        if (url != null) {
//            return url.toString();
//        }
//        return null;
//    }
//

    //    public void upLoadByString(){
//// Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAIu27Mmc4ZHFcK";
//        String accessKeySecret = "pxcJIxV43HSmQFi7pDmMTe9JwkCID6";
//        String bucketName = "imageku";
//        String objectName = "hell";
//// 创建OSSClient实例。
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//// 上传文件。
//        String content = "";
//        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
//// 关闭OSSClient。
//        ossClient.shutdown();
//    }
//
//    public void downloadByString() {
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAIu27Mmc4ZHFcK";
//        String accessKeySecret = "pxcJIxV43HSmQFi7pDmMTe9JwkCID6";
//        String bucketName = "imageku";
//        String objectName = "hello";
//// 创建OSSClient实例。
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
//        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
//// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
//        InputStream content = ossObject.getObjectContent();
//        if (content != null) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//            while (true) {
//                String line = null;
//                try {
//                    line = reader.readLine();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                if (line == null) break;
//                System.out.println("\n" + line);
//            }
//            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
//            try {
//                content.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
// 关闭OSSClient。
//        ossClient.shutdown();
//    }
//
//    public void downloadByByte(){
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//        String accessKeyId = "LTAIu27Mmc4ZHFcK";
//        String accessKeySecret = "pxcJIxV43HSmQFi7pDmMTe9JwkCID6";
//// 创建OSSClient实例。
//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);
//// 上传Byte数组。
//        byte[] content = "Hello OSS".getBytes();
//        ossClient.putObject("imageku", "image1", new ByteArrayInputStream(content));
//// 关闭OSSClient。
//        ossClient.shutdown();
//    }


}
