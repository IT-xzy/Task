package com;

import com.osi.util.safe.COSClientCredentials;
import com.osi.util.thirdparty.AliyunOSSClientUtil;
import com.osi.util.thirdparty.COSClientUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.*;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class Action {

    @Test
    public void cosToOss() throws IOException {

//        COS Object
        COSObject cosObject;
        COSClient cosClient = COSClientUtil.getConClient();
        COSObjectInputStream cosObjectInput = null;
        InputStream inputStream = null;
        List<String> keys =  COSClientUtil.getObjectListingKey();

//        OSS CLinet

        for(String key : keys){

            GetObjectRequest getObjectRequest = new GetObjectRequest(COSClientCredentials.BUCKET_NAME, key);
            cosObject = cosClient.getObject(getObjectRequest);
            cosObjectInput = cosObject.getObjectContent();
            inputStream = cosObjectInput;

            AliyunOSSClientUtil.updInputStream(inputStream,key);

            inputStream.close();
        }

        try {

            cosObjectInput.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
