package com.util.task7;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * @ClassName:HttpDown
 * @Description:TODO
 * @Author qiao
 * @Date 2018/9/8 19:43
 **/

public class HttpDown {

    private static Logger logger = Logger.getLogger(HttpDown.class);

    public static InputStream httpDownload(String httpUrl) {
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
