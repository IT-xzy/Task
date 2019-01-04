package jnshu.tool;

import com.alibaba.fastjson.JSON;
import jnshu.model.RestUser;
import jnshu.tool.RMI.RMIClient;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class RegisterUtis {

    private static Logger logger = Logger.getLogger (String.valueOf (RegisterUtis.class));//引入日志配置

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

    public static Map takMD5(RMIClient rmiClient, RestUser restUser){

        //查询登录角色
        RestUser rs1 = rmiClient.getStudentService ().selectUserByName (restUser.getName ());
//
//        生成加盐的token，用的是假盐......
        String eToken = TokenUtil.makeToken (rs1.getId (), TokenUtil.jSalt ());
        logger.info ("生成加密后的的token是：" + eToken);
        Cookie cookie = new Cookie ("token", eToken);
        String sds = null;
        try {
            sds = URLEncoder.encode (restUser.getName (), "utf-8");
        } catch ( UnsupportedEncodingException ue ) {
            logger.info ("登录名编码出错");
        }
        Cookie cookie1 = new Cookie ("status", sds);
        logger.info ("登录时存进去的status是：" + JSON.toJSONString (cookie1));
        Map map = new HashMap ();
        map.put ("cookie1", cookie1);
        map.put ("cookie", cookie);
        return map;

    }





}
