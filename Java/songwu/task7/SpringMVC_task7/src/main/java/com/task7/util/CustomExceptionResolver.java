package com.task7.util;

import com.task7.pojo.MessageException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by SongWu on 2018/8/10
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object obj,
                                         Exception e) {
        // obj：包名+类名+方法名（形参） 字符串， 将这些字符串信息记录在日志文件中，方便以后查看，可以使用log4j记录日志文件
        ModelAndView mav = new ModelAndView();
        //判断异常为类型
        if(e instanceof MessageException){
            //预期异常
            MessageException me = (MessageException)e;
            mav.addObject("error", me.getMessage());
        }else{
            mav.addObject("error", "其他未知异常");
        }
        mav.setViewName("error");
        return mav;
    }

}
