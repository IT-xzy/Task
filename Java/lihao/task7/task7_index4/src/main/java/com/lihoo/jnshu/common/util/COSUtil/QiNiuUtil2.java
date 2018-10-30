package com.lihoo.jnshu.common.util.COSUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * #Title: QiNiuUtil2
 * #ProjectName task7_index4
 * #Description: TODO
 * #author lihoo
 * #date 2018/10/5-9:48
 */

/**
 * 七牛工具类
 * @author speedhao
 * @date 2016.03.03
 */
public class QiNiuUtil2 {
    private static Logger logger = LoggerFactory.getLogger(QiNiuUtil2.class);
    /**
     * 七牛空间名
     */
    private static final String BLOCKNAME = "my-test-001";
    /**
     * 返回内容
     */
    private static final String RETURNBODY =
            "{\"name\": $(fname),\"size\": $(fsize),\"w\": $(imageInfo.width),"+
            "\"h\": $(imageInfo.height),\"hash\": $(etag)}";
    /**
     * AK
     */
    private static final String ACCESSKEY = "K4TAdLO3lavKxOHm-SQ_7VOh5ya0CzjA6EzR2ue_";
    /**
     * SK
     */
    private static final String SECRETKEY = "U6pwAQ_-lPosXG6K8xHj1nFyxv28Z5GYhEQUy66M";

    /**
     * token有效期，1800s
     */
    private static final long EXPIRES = 1800;
    /**
     * 获取token
     * @param fileName 包含后缀的文件名：123.jpg
     * @return
     */
    public static String getToken(String fileName){
        //过期时间，10位时间戳
        long deadline = (new Date()).getTime()/1000 + EXPIRES;
        //空间名和文件名的封装
        String scope = BLOCKNAME+":"+fileName;
        //上传后需要返回内容
        String returnBody = RETURNBODY;

        //参数封装
        Map<String, Object> putPolicyMap = new HashMap<String, Object>();
        putPolicyMap.put("returnBody", returnBody);
        putPolicyMap.put("deadline", deadline);
        putPolicyMap.put("scope", scope);

        //转换成json数据
        String putPolicy = JSON.toJSON(putPolicyMap).toString();

        //AK
        String accessKey = ACCESSKEY;
        //对参数进行url安全的base64编码
        String encodedPutPolicy = urlsafeBase64Encode(putPolicy.getBytes());
        //hmac_sha1加密
        String encodedSign = hmacSha1(encodedPutPolicy, SECRETKEY);

        //封装成token
        String uploadToken = accessKey+":"+encodedSign+":"+encodedPutPolicy;
        logger.info("打印token：" + uploadToken);

        return uploadToken;
    }

    /**
     * url安全的64位编码
     * @param str 需要加密的字节码
     * @return
     */
    private static String urlsafeBase64Encode(byte[] str){
        String returnStr = Base64.encode(str).toString();
        returnStr = returnStr.replace("+", "-");
        returnStr = returnStr.replace("/", "_");
        return returnStr;
    }

    /**
     * hmac_sha1加密
     * @param str 加密字符串
     * @param key SK
     * @return
     */
    private static String hmacSha1(String str, String key){
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(),"HmacSHA1");
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
        }catch (Exception e) {
            e.printStackTrace();
        }
        byte[] rawHmac = mac.doFinal(str.getBytes());
        return urlsafeBase64Encode(rawHmac);
    }

}
