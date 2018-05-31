package com.majorjoe.web.exception;

import com.mojorjoe.web.exception.StudentException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentExceptionResolver implements HandlerExceptionResolver {
    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {

        ModelAndView mv =new ModelAndView();

//如果抛出的是我们自定义的异常则直接转换
        if(ex instanceof StudentException) {
            mv.addObject("message", ex.getMessage());
            mv.setViewName("exceptionPage");
            return mv;

        } else {
            log.error("服务器错误：\n" + ex);
            mv.setViewName("errorPage");
            return mv;
        }


          }
}
