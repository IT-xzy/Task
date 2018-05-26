package com.task.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(MyExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception expection) {


        MyException myException=null;
        if (expection instanceof MyException){
            myException=(MyException)expection;
        }else{
            myException=new MyException("未知错误");
        }
        //错误信息
        String message=myException.getMessage();

        ModelAndView mav=new ModelAndView();

        //将错误信息传到页面
        mav.addObject("message",message);
        logger.error(message);
        //指向到错误页面
        mav.setViewName("error");

        return mav;

    }
}
