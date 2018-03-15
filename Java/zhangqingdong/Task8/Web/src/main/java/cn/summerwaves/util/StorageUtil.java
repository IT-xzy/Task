package cn.summerwaves.util;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.List;

public class StorageUtil {
    private static String storageName;
    private static Logger logger = Logger.getLogger(StorageUtil.class);

    public static void upLoad(InputStream inputStream, String fileName) {
        switch (storageName) {
            case "Ali":
                ALiYunUtil.upLoad(inputStream, fileName);
                break;
            case "QiNiu":
                QiNiuUtil.upLoad(inputStream, fileName);
                break;
            default:
                logger.error("Wrong name of Storage in the execution of upLoad");
                break;
        }
    }

    public static InputStream downLoad(String fileName){
        switch (storageName) {
            case "Ali":
                return ALiYunUtil.downLoad(fileName);
            case "QiNiu":
                return QiNiuUtil.downLoad(fileName);
            default:
                logger.error("Wrong name of Storage in the execution of downLoad");
                return null;
        }
    }

    public static List<String> getAllFileName() {
        switch (storageName) {
            case "ALi":
                return ALiYunUtil.getAllFileName();
            case "QiNiu":
                return QiNiuUtil.getAllFileName();
            default:
                logger.error("Wrong name of Storage in the execution of getAllFileName");
                return null;
        }
    }

    public static String getFileUrl(String fileName) {
        switch (storageName) {
            case "ALi":
                return ALiYunUtil.getThumbFileUrl(fileName);
            case "QiNiu":
                return QiNiuUtil.getThumbFileUrl(fileName);
            default:
                logger.error("Wrong name of Storage in the execution of getFileUrl");
                return null;
        }
    }


    public void setStorageName(String storageName) {
        StorageUtil.storageName = storageName;
    }


}
