package com.iceneet.untils;

import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.ObjectMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class ImgeMoveUtils {
    public static String qiniu2qcloud() throws IOException {
        try {
            List<String> imgList = qiniuUtils.getFileList();
            for (int i = 0; i <imgList.size() ; i++) {
                String key1 = imgList.get(i);
                String url2 = qiniuUtils.getLink()+key1;
                URL urls = new URL(url2);
                URLConnection uc = urls.openConnection();
                int fileSize = uc.getContentLength();
                InputStream inputStream = urls.openStream();
                ObjectMetadata meta = new ObjectMetadata();
                meta.setContentLength(fileSize);
                qcloudcos.UploadStream(key1,inputStream,meta);
            }
            return "success";
        }catch (Exception e){
            return "fail";
        }
    }

    public static String qcloud2qiniiu(){
        try {
            List<COSObjectSummary> objectSummaries = qcloudcos.GetCosObject();
            for (COSObjectSummary cosObjectSummary:objectSummaries) {
                String key = cosObjectSummary.getKey();
                String url = qcloudcos.getLink()+key;
                qiniuUtils.fetch(url,key);
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }

    }
}
