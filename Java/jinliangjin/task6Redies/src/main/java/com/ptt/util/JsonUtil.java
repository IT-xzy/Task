package com.ptt.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.sun.istack.internal.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName: JsonUtil
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/6/10 22:47
 * @Version: 1.0
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = Logger.getLogger(JsonUtil.class);
    public static String object2Json(Object o){
        try {
            logger.info("调用JsonUtil将Object对象转换为json对象。");
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object json2Object(String jsonString, Object o){
        try {
//            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return objectMapper.readValue(jsonString, o.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
