package com.jnshu.tactics;
import com.jnshu.utils.OSSUtil;
import com.jnshu.utils.QiNiuUtil;
import com.jnshu.utils.urlsa;
import com.qiniu.storage.model.FileInfo;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class migrationAQ implements Strategy {
    private Logger logger = Logger.getLogger(migrationAQ.class);

    @Override
    public String migration() throws IOException {
        FileInfo[] info = QiNiuUtil.Qniuall();
        //遍历文件列表，得到各个文件的文件名
        for (FileInfo fileInfo : info) {
            //通过文件名去获取到七牛云的下载链接
            String url = QiNiuUtil.getUrl(fileInfo.key);
            //将链接转化成输入流
            InputStream in = urlsa.urldown(url);
            //将流传递给阿里云上传方法，实现文件的上传。
            OSSUtil.putFiles(fileInfo.key, in);
            in.close();
        }
        //关闭客户端
        OSSUtil.shutdownClient();
        String name = "七牛云迁移到阿里云完成！";
        return name;
    }

    @Override
    public String fileUpload(String filename, InputStream inputStream) throws IOException {
        OSSUtil.putFiles(filename, inputStream);
        return "上传到阿里云成功！";
    }

    @Override
    public String filedown(String filename, InputStream inputStream) throws IOException {
        return "";
    }

    @Override
    public String getUrl(String filename) throws IOException {
        String url = "https://aes65.oss-cn-shenzhen.aliyuncs.com/" + filename;
        logger.info("阿里云url:\t" + url);
        return url;
    }

    @Override
    public Boolean checkFile(String filename) throws IOException {
        return OSSUtil.checkFile(filename);
    }
}
