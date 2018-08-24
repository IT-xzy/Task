package com.jnshu.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.jnshu.tools.Msg;
import com.qcloud.cos.COS;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: Tiles
 * @description: 图片迁移
 * @author: Mr.Lee
 * @create: 2018-08-06 15:50
 **/

@Controller
public class MoveController {

    @Autowired
    OSSClient ossClient;
    @Autowired
    BasicCOSCredentials basicCOSCredentials;
    @Autowired
    ClientConfig clientConfig;
    @Autowired
    COSClient cosClient;
    @Autowired
    ObjectMetadata objectMetadata;

    @RequestMapping("/move")
    public Msg move(){
        List<String > keys = new ArrayList<>();

        String bucketName="willming";
        String nextMarker = null;
        final int maxKeys = 1000;
        ObjectListing objectListing;
        do {
            objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).
                    withMarker(nextMarker).withMaxKeys(maxKeys));
            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                keys.add(s.getKey());
            }
            nextMarker = objectListing.getNextMarker();
        }while (objectListing.isTruncated());


        for (String key :keys){
            InputStream input = ossClient.getObject(bucketName,key).getObjectContent();
            try {
                objectMetadata.setContentLength(input.available());
            } catch (IOException e) {
                e.printStackTrace();
            }
            cosClient.putObject("bucket1-1256780031",key,input,objectMetadata);
        }
        ossClient.shutdown();
        cosClient.shutdown();
        return Msg.success();
    }
}
