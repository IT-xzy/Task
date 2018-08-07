package com.encryption;

import java.io.InputStream;

public class TransferContext  {
    private Transfer transfer;

    //构造函数
    public TransferContext(boolean OssSign) {
        if(OssSign==true){
            this.transfer=new TransferALI();
        }else {
            this.transfer=new TransferQiNiu();
        }
    }

    //迁移图片
    public void TransferImage(){
        transfer.TransferImage();
    }
    //上传图片
    public void uploadImage(InputStream inputStream,String objectName){
        transfer.uploadImage(inputStream,objectName);
    }
    //获得连接
    public String getlLink(){
       return transfer.getlLink();
    }
}
