package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlStream {
    public InputStream urlInputstream(String finalUrl){
        URL url;
        InputStream inputStream = null;
        try {
            url=new URL(finalUrl);
            URLConnection uc=url.openConnection();
            uc.connect();
            inputStream= uc.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
