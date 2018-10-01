package com.jnshu.czm.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class SwitchStorageUtil {

    private static Logger logger= LoggerFactory.getLogger(SwitchStorageUtil.class);

    private static String storageName;

    public void setStorageName(String storageName) {
        SwitchStorageUtil.storageName = storageName;
    }


    public static void upLoad(InputStream inputStream, String fileName) {
        switch (storageName) {
            case "Ali":
                ALiYunUtil.upLoad(fileName,inputStream);
                logger.info("\nEnter Aliyun");
                break;
            case "QiNiu":
                QiNiuUtil.upLoad(fileName,inputStream);
                logger.info("\nEnter QiNiuyun");
                break;
            default:
                logger.error("\nThe name does not exist");
                break;
        }
    }
}
