package com.jnshu.tools;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;

import java.io.*;
import java.net.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-until.xml"})
public class ToolTest {


//    ApplicationContext build = new ClassPathXmlApplicationContext("spring-until.xml");
//
//    QnOssUntil qnOssUntil = (QnOssUntil) build.getBean("qnOssUntil");

    @Autowired
    COSClient cosClient;


    QnOssUntil qnOssUntil;

    /**
     *
     */
    @Test
    public void te() throws IOException {
        String bucketName = "logic-1255663509";
//        File localFile = new File("C:\\Users\\li438\\IdeaProjects\\Water-drop.jpg");
//        InputStream file = new FileInputStream(localFile);
//        String key = localFile.getName();
////        QnOssUntil.upFile(file, key);
//        String fileUrl="http://pdotd3prr.bkt.clouddn.com//0286f06382904beea34962e28a1c6371.png?attname=0286f06382904beea34962e28a1c6371.png";
//
//
//
//        URL url = new URL(fileUrl);
//        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
//        uc.connect();
//        InputStream iputstream = uc.getInputStream();
//        int l =  uc.getContentLength();
//
//        System.out.println("\nHTTP"+l);
//       ObjectMetadata objectMetadata = new  ObjectMetadata();
//        objectMetadata.setContentLength(l);
//        System.out.println(key+iputstream+objectMetadata+l);
//        cosClient.putObject(bucketName,key,iputstream,objectMetadata);
//        System.out.println("\nces");
        /*SendEmailUtil sendEmailUtil = new SendEmailUtil("438903621@qq.com", "验证码", "3415", "55");
         sendEmailUtil.send();
      DataTrans dataTrans = new DataTrans();
    List list = dataTrans.qnList();
    for (Object key:list){
        System.out.println(key);
    }*/

//        DataTrans dataTrans = new DataTrans();
//        dataTrans.tranToCos();


        // 获取 bucket 下成员（设置 delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
// 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
        listObjectsRequest.setPrefix("");
// 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
        listObjectsRequest.setDelimiter("/");
// 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
        listObjectsRequest.setMarker("");
// 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
        listObjectsRequest.setMaxKeys(100);

        ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);
        //// 获取下次 list 的 marker
//        String nextMarker = objectListing.getNextMarker();
//// 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
//        boolean isTruncated = objectListing.isTruncated();
        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();

        String domainOfBucket = "https://logic-1255663509.cos.ap-guangzhou.myqcloud.com";
        for (COSObjectSummary cosObjectSummary : objectSummaries) {
// 文件路径
            String fileName = cosObjectSummary.getKey();
// 获取文件长度
//            long fileSize = cosObjectSummary.getSize();
            String encodedFileName = URLEncoder.encode(fileName, "utf-8");
            String finalUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
            System.out.println(finalUrl);
            URL url = new URL(finalUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.connect();
            InputStream iputstream = uc.getInputStream();
            QnOssUntil.upFile(iputstream, fileName);
            System.out.println(fileName+"转移成功");
        }

    }
}
