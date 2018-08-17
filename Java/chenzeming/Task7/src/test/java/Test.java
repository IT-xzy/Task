import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.jnshu.czm.util.ALiYunUtil;
import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Test {
    @org.junit.Test
    public void add() throws Exception {
//        String num="陈泽铭";
//        System.out.println("原文："+num);
//        DES str =new DES();
//        String asc=str.encrypt(num);
//        str.decrypt(asc);
//        System.out.println("这是："+UUID.randomUUID());
//        String salt=UUID.randomUUID().toString();
//        String salt1=String.valueOf(UUID.randomUUID());
//        System.out.println(".........."+salt1);
//        System.out.println("盐值:"+salt);
//        System.out.println("..:"+UUID.randomUUID().toString().replace("-", ""));
//        double abc=Math.random();
//        System.out.println("random:"+abc);
//        System.out.println("时间："+LocalDate.now());
//        System.out.println("1..................");
//        String email="396154482@qq.com";
//        int code = (int) ((Math.random() * 9 + 1) * 100000);
//        EmailDemo emailDemo=new EmailDemo().sample(email,String.valueOf(code));
//        System.out.println(UUID.randomUUID());
//        String s = String.format("Hello %s%s%s", "jerry-", "li", ",welcome!");
//        System.out.println(s);
        int a=1;
        //System.out.println("a++:   "+a++);
        System.out.println("++a:     "+ ++a);

    }
    @org.junit.Test
    public void downLoad() throws IOException {
        String fileName="1c81ec35-a477-45d3-8192-2ddb418c430d.png";
        String domainOfBucket = "http://pdawol65w.bkt.clouddn.com";

        //解决文件名包含中文的问题
        String encodedFileName = URLEncoder.encode(fileName, "utf-8");
        System.out.println("encodedFileName:   "+encodedFileName);
        //获得图片的地址
        String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        System.out.println(finalUrl);
        //转化为流
        InputStream inputStream=new URL(finalUrl).openStream();
        System.out.println(inputStream);
    }

//@org.junit.Test
//    public void downLoad1() {
//
//
//        String fileName="16dd9c9e-6646-4536-b8ab-0089f4bca8bf.png";
//        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "LTAI0UdKXzl583bl";
//        String accessKeySecret = "R2wy6xcg1fXazqoRVOJiWaINbskMGS";
//        String bucket="jnshuczm";
//
//        try {
//            // 创建OSSClient实例。
//            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//            System.out.println("ossClient:      "+ossClient);
//            // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
//            OSSObject ossObject = ossClient.getObject(bucket, fileName);
//            System.out.println("ossObject:     "+ossObject);
//            InputStream inputStream=ossObject.getObjectContent();
//            System.out.println("inputStream:    "+inputStream);
//        }catch(Exception e){
//            System.out.println("1111111111111111111111111111111111");
//        }
//    }

//    @org.junit.Test
//    public  void getAllFileName() {
//
//        String accessKeyId = "dujg3aIotWuKYFKKu_9EWjskk0JT7ADnEiITifV0";
//        String accessKeySecret = "z_-gBbsfr0Yo8N67wjhhqrQlbxQbbT45DMdZUJMN";
//        String bucket="jnshuczm";
//
//        Auth auth = Auth.create(accessKeyId, accessKeySecret);
//        Configuration cfg = new Configuration(Zone.zone0());
//        BucketManager bucketManager = new BucketManager(auth, cfg);
//
//
//        //文件名前缀
//        String prefix = "";
//        //每次迭代的长度限制，最大1000，推荐值 1000
//        int limit = 1000;
//        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
//        String delimiter = "";
//
//        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
//        while (fileListIterator.hasNext()) {
//            //处理获取的file list结果
//            FileInfo[] items = fileListIterator.next();
//            for (FileInfo item : items) {
//                System.out.println(item.key);
//
//            }
//        }
//    }

    @org.junit.Test
    public void getAllFileName() {

        Logger logger= LoggerFactory.getLogger(ALiYunUtil.class);
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI0UdKXzl583bl";
        String accessKeySecret = "R2wy6xcg1fXazqoRVOJiWaINbskMGS";
        String bucket="jnshuczm";

// 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
// 列举文件。 如果不设置KeyPrefix，则列举存储空间下所有的文件。KeyPrefix，则列举包含指定前缀的文件。
        ObjectListing objectListing = ossClient.listObjects(bucket);
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        for (OSSObjectSummary s : sums) {
            System.out.println("\t" + s.getKey());
        }
// 关闭OSSClient。
        ossClient.shutdown();
    }





}
