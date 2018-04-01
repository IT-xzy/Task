package com.ptteng.exception.resolver;

import com.ptteng.exception.StudentException;
import com.ptteng.exception.XSSException;
import org.apache.log4j.Logger;
import org.springframework.core.PriorityOrdered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

//PriorityOrdered实现了优先级属性的设置（越小，优先级越高）
//实际运用中处理的分支肯定更多更丰富，返回的一般也是json对象（Map里code和message肯定是有的）
//我这里就简单写了，统一两个界面，一个预计中异常，一个意料外异常
public class ExceptionResolver implements HandlerExceptionResolver, PriorityOrdered {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //如果抛出的是系统自定义的异常则直接转换
        if (ex instanceof StudentException) {
            logger.info("用户操作错误：" + ex.getMessage());
            ModelAndView modelAndView = new ModelAndView("mistake");
            modelAndView.addObject("message", ex.getMessage());
            return modelAndView;
        } else if (ex instanceof XSSException) {
            if (request.getHeader("x-forwarded-for") == null) {
                logger.warn("该次异常访问IP为" + request.getRemoteAddr());
            } else {
                logger.warn("该次异常访问IP为" + request.getHeader("x-forwarded-for"));
            }
            return new ModelAndView("error");
        } else {
            logger.warn("服务器错误：" + Arrays.toString(ex.getStackTrace()));
            return new ModelAndView("error");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
