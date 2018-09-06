package com.iceneet.untils;

import com.qcloud.cos.model.ObjectMetadata;

import java.io.InputStream;


public class TransferContext {

    private Transfer transfer;

    public TransferContext(boolean OssSign){
        if(OssSign==true){
            this.transfer = new TransferQcloud();
        }else {
            this.transfer = new TransferQiniu();
        }
    }

    public String UploadStream(String key, InputStream inputStream, ObjectMetadata metadata){
        return transfer.UploadStream(key, inputStream, metadata);
    }

    public String getLink(){
        return transfer.getLink();
    }
}
