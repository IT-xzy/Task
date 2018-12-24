package jnshu.tool;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GetStatus {

    private static Logger logger = Logger.getLogger (GetStatus.class);

    //    判断status状态
    public static String status(Cookie[] cookies) {
        String sds = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName ().equals ("status")) {
                    try {
                        sds = URLDecoder.decode (cookie.getValue (), "utf-8");
                    } catch ( UnsupportedEncodingException ue ) {
                        logger.info ("登录名解码出错");
                    }
                    break;
                }
            }
        }
        return sds;
    }


}
