package com.jnshu.tactics;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.jnshu.utils.OSSUtil;
import com.jnshu.utils.QiNiuUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class migrationQA implements Strategy {
    private Logger logger = Logger.getLogger(migrationQA.class);

    @Override
    public String migration() throws IOException {
        ObjectListing listing = OSSUtil.getall();
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            String key = objectSummary.getKey();
            InputStream in = OSSUtil.down(key);
            QiNiuUtil.up(in, key);
        }
        // 关闭client
        OSSUtil.shutdownClient();
        String name = "阿里云迁移到七牛云完成！";
        return name;
    }

    @Override
    public String fileUpload(String filename, InputStream inputStream) throws IOException {
        QiNiuUtil.up(inputStream, filename);
        return "上传到七牛云成功";
    }

    @Override
    public String filedown(String filename, InputStream inputStream) throws IOException {
        return "";
    }

    @Override
    public String getUrl(String filename) throws IOException {
        String url = QiNiuUtil.getUrl(filename);
        logger.info("七牛云URL" + url);
        if (url != null) {
            return url;
        } else {
            return null;
        }
    }

    @Override
    public Boolean checkFile(String filename) throws IOException {
        logger.info("QiNiuUtil.checkFile(filename):\t" + QiNiuUtil.checkFile(filename));
        return QiNiuUtil.checkFile(filename);
    }
}
