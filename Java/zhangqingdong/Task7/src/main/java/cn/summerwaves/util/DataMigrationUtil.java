package cn.summerwaves.util;

import java.util.List;

public class DataMigrationUtil {

    public static void AliToQiNiu() {
        //获取阿里云所有文件名字
        List<String> keys = ALiYunUtil.getAllFileName();
        //逐个下载并上传到七牛云
        for (String key : keys) {
            QiNiuUtil.upLoad(ALiYunUtil.downLoad(key), key);
        }
    }

    public static void QiNiuToALi() {
        //获取七牛云所有文件名字
        List<String> keys = QiNiuUtil.getAllFileName();
        //逐个下载上传到阿里云
        for (String key : keys) {
            ALiYunUtil.upLoad(QiNiuUtil.downLoad(key), key);
        }
    }
}
