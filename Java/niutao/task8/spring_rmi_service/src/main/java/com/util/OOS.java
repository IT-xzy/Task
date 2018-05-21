package com.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OOS {

    @Autowired
    UploadHead uploadHead;
    @Autowired
    AliOss aliOss;
    @Autowired
    Migration migration;

    public static final Logger logger = (Logger) LoggerFactory.getLogger(OOS.class);

    private Integer i;
    //通过xml中bean的配置，设置服务商。
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
            //aliOss.uppictrue(name);
        }
    }
    //上传选择
    public void doUp(String name){
        //七牛云
        if(this.i==0){
            uploadHead.UploadAndGetName(name);
        }
        //阿里云
        if(this.i==1){
            aliOss.uppictrue(name);
        }
    }
    //url选择
    public String geturl() {
        //七牛云
        if (this.i == 0) {
            return "http://p376820e8.bkt.clouddn.com/";
        }else{
            //阿里云
            return "http://pictureok.aliOss-cn-shenzhen.aliyuncs.com/";
        }
    }
}
