package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class SelectOOS {

    private Integer i;
    @Autowired
    UploadHead uploadHead;
    @Autowired
    OSS oss;
    @Autowired
    Migration migration;
    Logger logger = (Logger) LoggerFactory.getLogger(SelectOOS.class);

    public void setI(int i) {
        this.i = i;
    }
    //迁移选择
    public void doSelect() throws IOException {
        //七牛云
        if(this.i==0){
            logger.info("开始迁移至七牛云");
            migration.doalitoqiniu();
            logger.info("迁移七牛云成功");
            //uploadHead.UploadAndGetName(name);
        }
        //阿里云
        if(this.i==1){
            logger.info("开始迁移至阿里云");
            migration.doqiniutoali();
            logger.info("迁移阿里云成功");
            //oss.uppictrue(name);
        }
    }

    //上传选择
    public void doSelect(String name){
        //七牛云
        if(this.i==0){
            uploadHead.UploadAndGetName(name);
        }
        //阿里云
        if(this.i==1){
            oss.uppictrue(name);
        }
    }

    //url选择
    public String geturl() {
        //七牛云
        if (this.i == 0) {
            return "http://p376820e8.bkt.clouddn.com/";
        }else{
            //阿里云
            return "http://pictureok.oss-cn-shenzhen.aliyuncs.com/";
        }
    }
}
