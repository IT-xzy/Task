package com.fgh.task2.tool;

import com.fgh.task2.controller.mailController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UrlParam {
    Logger logger=LoggerFactory.getLogger(mailController.class);

    public  String getParam (HttpServletRequest request){
        String realURL= String.valueOf(request.getRequestURL());
        logger.debug("网页URL："+realURL);
        String requestURL=realURL.split("\\?")[1];
        logger.debug("键值对："+requestURL);
        String param = requestURL.split("=")[1];
        logger.debug("Param: "+param);
        return param;
    }
}
