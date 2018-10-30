package com.suger.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 消息工具类，日志输出或者直接返回对应字符串，包括状态码，和请求信息
 * @author suger
 * @date 2018-10-17
 */
@Component
public class MessageUtils {
    @Autowired
    public  static MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(MessageUtils.class);

    public Map msg(String msg) {
        //args 作为在 properties 文件中的实际值
        //后面的这两个参数是用来配置占位符和国际化的-------现在用不到
        String error = messageSource.getMessage(msg, null, null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(error, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String success(){
        return messageSource.getMessage("success", null, null);
    }
    public static String fail(){
        return messageSource.getMessage("fail", null, null);
    }


}
