package com.ptteng.manager;

import com.ptteng.pojo.exception.CacheException;
import com.ptteng.pojo.exception.StudentException;
import com.ptteng.pojo.exception.XSSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*PriorityOrdered实现了优先级属性的设置（越小，优先级越高）
实际运用中处理的分支肯定更多更丰富，返回的一般也是json对象（code和message肯定是有的）
我在这里就简单写一下*/
public class ExceptionManager implements HandlerExceptionResolver, PriorityOrdered {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        /*分支处理
        该类异常是用户可能造成的异常
        真实项目中可以不需要这类对象，在校核失败的地方直接return带状态码的json对象即可
        我还不会熟练使用json对象，所以暂时这样子弄吧*/
        if (ex instanceof StudentException) {
            if (logger.isInfoEnabled()) {
                logger.info("用户操作错误：" + ex.getMessage());
            }
            ModelAndView modelAndView = new ModelAndView("mistake2");
            modelAndView.addObject("message", ex.getMessage());
            return modelAndView;
        }

        /*处理可能由XSS造成的异常
         * 这里是采取最简单的处理方式，只是记录IP
         * 可能通过IP比对方式设立黑名单，然后用过滤器等方式实现*/
        if (ex instanceof XSSException) {
            if (request.getHeader("x-forwarded-for") == null) {
                logger.warn("该次异常访问IP为" + request.getRemoteAddr()
                        + "异常内容：" + ex.getMessage());
            } else {
                logger.warn("该次异常访问IP为" + request.getHeader("x-forwarded-for")
                        + "异常内容：" + ex.getMessage());
            }
            ModelAndView modelAndView = new ModelAndView("mistake");
            modelAndView.addObject("message", "账号信息过期，请重新登录");
            return modelAndView;
        }

        if (ex instanceof CacheException) {
            logger.warn("CacheException:" + ex.getMessage());
            //可以跳到特定的处理页面，这里我就简单的写一下
            ModelAndView modelAndView = new ModelAndView("mistake");
            modelAndView.addObject("message", "服务器繁忙，请稍后再试");
            return modelAndView;
        }

        //其他的异常为意料之外的异常，error级别输出
        ex.printStackTrace();
        logger.error("服务器错误：" + ex.getClass().getSimpleName());
        return new ModelAndView("error");
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
