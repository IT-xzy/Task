package com.iceneet.untils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpInputStreamUtils {
    public static InputStream returnInputStream(String url) throws IOException {
       URL urls = new URL(url);
       InputStream inputStream = urls.openStream();
       return inputStream;
    }

}
