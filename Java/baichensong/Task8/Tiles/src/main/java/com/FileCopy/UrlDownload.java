package com.FileCopy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlDownload {
    private static Logger logger = LoggerFactory.getLogger(UrlDownload.class);
    public static InputStream httpDownload (String httpUrl)throws IOException {
        int bytesum = 0;
        int byteread = 0;
        String tmpFile = "tmpFile";
        try {
            URL url = new URL(httpUrl);

            // 建立连接
            URLConnection connection = url.openConnection();
            // connection.setConnectTimeout(6*1000);
            //防止屏蔽程序抓取而返回403错误
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            // 读取文件流
            InputStream inputStream = connection.getInputStream();
            FileOutputStream fs = new FileOutputStream(tmpFile);

            byte[] buffer = new byte[1204];
            while ((byteread = inputStream.read(buffer)) != -1) {
                bytesum += byteread;
                System.out.println(bytesum);
                fs.write(buffer, 0, byteread);
            }
            // 关闭资源
            inputStream.close();
            fs.close();
            // 无法直接转发 先存到文件再读吧..
            logger.info("下载成功");
            return new FileInputStream(tmpFile);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            logger.debug("传入链接读取失败");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("连接建立失败");
            return null;
        }
    }
}


