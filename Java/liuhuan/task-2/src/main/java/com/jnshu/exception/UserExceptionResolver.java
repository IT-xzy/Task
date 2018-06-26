package com.jnshu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Currency;
/*
 * 系统遇到异常，在程序中手动抛出，dao抛给service、service给controller、controller抛给前端控制器，前端控制器调用全局异常处理器。
 * 全局异常处理器处理思路：
 *  解析出异常类型。
 *  如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示。
 *  如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
 * */

//全局异常处理器
public class UserExceptionResolver implements HandlerExceptionResolver {
    //系统抛出的异常
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        //handler就是处理器适配器执行的handler对象(只有method)
        //解析出异常类型

        //如果该异常类型时系统自定义异常,直接取出异常信息,再错误页面显示
        UserException userException = null;
        if (ex instanceof UserException) {
            userException = (UserException) ex;
        } else {
            //如果该异常类型不是系统自定义异常,构造一个自定义的异常类型(信息为: 未知异常)
            userException = new UserException("未知异常");
        }

        //错误信息
        String message = userException.getMessage();

        //将错误信息传到页面
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);

        //指向错误页面
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
