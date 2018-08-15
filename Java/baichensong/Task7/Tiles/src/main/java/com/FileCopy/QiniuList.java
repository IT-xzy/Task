package com.FileCopy;

import com.SendimagesTool.Debug;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class QiniuList {
        private static Logger logger = LoggerFactory.getLogger(QiniuList.class);

    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext-DAO.xml");
    private UploadAili uploadAiliOSSAPI = (UploadAili) applicationContext.getBean("aliyunOss");

    // 七牛文件列表获取

        // prefixHttp 需要知道OSS文件外网地址的前缀 必须传 bucketname 进去

        public boolean qiNiuFileToAliyun ( String bucketname,String prefixHttp)throws Exception {
            return qiNiuFileToAliyunReal(bucketname,"",1000,"",prefixHttp);
        }


        public boolean qiNiuFileToAliyun( String bucketname, String prefix, int limit, String delimiter, String prefixHttp) throws IOException{
            return qiNiuFileToAliyunReal(bucketname, prefix, limit, delimiter, prefixHttp);
        }



        private boolean qiNiuFileToAliyunReal( String bucketname,String prefix, int limit, String delimiter, String prefixHttp) throws IOException {
            // 获取七牛OSS中文件列表·
            BucketManager.FileListIterator fileListIterator = new Debug().getObjectList(bucketname,prefix, limit, delimiter);
            logger.info("查看返回列表数据"+ fileListIterator);
            if (fileListIterator != null) {
                // 遍历
                while (fileListIterator.hasNext()) {
                    FileInfo[] items = fileListIterator.next();
                    for (FileInfo item : items) {
                        logger.info("查看key  "+item.key);
                        logger.info("查看哈希  "+item.hash);
                        logger.info("查看大小  "+String.valueOf(item.fsize));
                        logger.info("查看文件类型 "+item.mimeType);
                        logger.info("查看值时间 "+String.valueOf(item.putTime));
                        logger.info("查看值最后操作用户 "+item.endUser);
                        String httpString = prefixHttp + item.key;
                        logger.info("拼好的七牛的各个下载链接" + httpString);



// -------------------------下载七牛OSS文件--------------------------
                        InputStream inputStream = UrlDownload.httpDownload(httpString);
                        logger.info("下载的文件数据流"+inputStream);
                        // 上传到阿里云
                        uploadAiliOSSAPI.updateFile(null,inputStream, item.key, item.mimeType);
                    }
                }
                return true;
            }
            logger.info("fileListIterator 为空");
            return false;
        }
    }


