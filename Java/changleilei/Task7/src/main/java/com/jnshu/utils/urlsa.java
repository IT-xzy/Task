package com.jnshu.utils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class urlsa {

    public static InputStream urldown(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);// 构造URL
        URLConnection con = url.openConnection();// 打开连接
        return con.getInputStream();
    }
}
