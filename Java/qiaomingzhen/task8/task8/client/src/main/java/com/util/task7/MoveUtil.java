//package com.util.task7;
//
//import com.aliyun.oss.OSSClient;
//import com.qiniu.storage.BucketManager;
//import com.qiniu.storage.model.FileInfo;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.InputStream;
//
///*
// * @ClassName:MoveUtil
// * @Description:TODO
// * @Author qiao
// * @Date 2018/9/8 19:42
// **/
//
//public class MoveUtil {
//    private static Logger logger = Logger.getLogger(MoveUtil.class);
//    @Autowired
//    QiNiuUtil qiNiuUtil;
//    @Autowired
//    OSSClient ossClient;
//
//    String bucket = "qiaoxm";
//
//    public boolean moveFile(int limit) {
//        // 获取七牛OSS中文件列表
//        BucketManager.FileListIterator fileListIterator = qiNiuUtil.getList(limit);
//        if (fileListIterator != null) {
//            // 遍历
//            while (fileListIterator.hasNext()) {
//                FileInfo[] items = fileListIterator.next();
//                for (FileInfo item : items) {
//                    logger.debug(item.key);
//                    logger.debug(item.hash);
//                    logger.debug(String.valueOf(item.fsize));
//                    logger.debug(item.mimeType);
//                    logger.debug(String.valueOf(item.putTime));
//                    logger.debug(item.endUser);
//                    String httpString = "http://peo04vwla.bkt.clouddn.com/" + item.key;
//                    logger.debug(httpString);
//                    // 读取七牛OSS文件
//                    InputStream inputStream = HttpDown.httpDownload(httpString);
//                    //上传至阿里云OSS
//                    ossClient.putObject(bucket, item.key, inputStream);
//                }
//            }
//            return true;
//        }
//        logger.debug("fileListIterator 为空");
//        return false;
//    }
//}
//
