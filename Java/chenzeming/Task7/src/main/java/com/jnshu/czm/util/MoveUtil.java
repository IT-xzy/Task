package com.jnshu.czm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

import java.util.List;


public class MoveUtil {

    private static Logger logger= LoggerFactory.getLogger(MoveUtil.class);



    /**
     * 阿里云迁移到七牛云
     */
    public static void AliToNiu(){
        logger.info("\n阿里云迁移到七牛云 ");
        List<String> fileName= ALiYunUtil.getAllFileName();
        for (String filename:fileName){
            QiNiuUtil.upLoad(filename, ALiYunUtil.downLoad(filename));
        }
    }

    /**
     * 七牛云迁移到阿里云
     * @throws Exception
     */
    public static void NiuToAli() throws IOException {

        logger.info("\n七牛云迁移到阿里云 ");
        List<String> filenames= QiNiuUtil.getAllFileName();
        for (String filename:filenames){
            System.out.println("filename"+filename);
            ALiYunUtil.upLoad(filename, QiNiuUtil.downLoad(filename));
        }

    }

}
