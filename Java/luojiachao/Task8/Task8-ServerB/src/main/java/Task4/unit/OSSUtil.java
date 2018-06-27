package Task4.unit;


import Task4.exception.MyException;


public class OSSUtil {

//   private static  OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//
//    @Value("${aliyun.oss.bucket.name}")
//    private  String bucketName;
    public OSSUtil(String endpoint, String accessKeyId, String secretAccessKey) {
    }

    //获得图片在OSS服务器上的key值
    public  String getImgKey(String username, String suffix) throws MyException {
        StringBuffer a = new StringBuffer();
        //下面拼接的相当于是key值，key对应于oss服务器中文件的路径 举个例子：Task7/user1/20180101000000.jpg
        a.append("Task7/");
        a.append(username);
        a.append(".");
//        sb.append(DateUtil.longToString(System.currentTimeMillis(), "yyyyMMddHHmmss"));
        a.append(suffix);
        return a.toString();
    }

    //获得图片的访问地址
    public static String getImgUrl(String key, String bucketName) {
        String endpointt="oss-cn-shanghai.aliyuncs.com";
        StringBuffer a = new StringBuffer();
        a.append("http://");
        a.append(bucketName);
        a.append(".");
        a.append(endpointt);
        a.append("/");
        a.append(key);
        //将图缩略成宽度为200，高度为200，按长边优先,拼接在url后面就行
        a.append("?x-oss-process=image/resize,m_lfit,h_200,w_200");
        return a.toString();
    }

    //通过源字节码的方式上传文件至OSS
//    public  void uploadFileToOSS(MultipartFile file, String key) throws MyException {
//
//
//        try {
//            ossClient.putObject(bucketName, key, new ByteArrayInputStream(file.getBytes()));
//        } catch (IOException e) {
//            throw new MyException("发送时转化为字节码失败");
//        } catch (OSSException oe) {
//            throw new MyException("OSS服务器处理失败，信息：" + oe.getMessage());
//        } catch (ClientException ce) {
//            throw new MyException("ESC连接至OSS失败，信息：" + ce.getMessage());
//        }

//        ossClient.shutdown();
//    }
//    public void close(){
//        ossClient.shutdown();
//    }
}