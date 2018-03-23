package com.ptteng.manager;

import com.ptteng.pojo.exception.ServerException;
import com.ptteng.pojo.exception.UnavailableException;
import com.ptteng.pojo.exception.UnacceptableException;
import com.ptteng.pojo.exception.ForbiddenException;
import com.ptteng.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*PriorityOrdered实现了优先级属性的设置（越小，优先级越高）
 * 本项目json接口统一由taglib提取，包含code和info两条属性
 * code:处理结果状态
 * info:处理结果信息
 * 正常返回 code:"ok" info:"操作成功"
 * 由用户造成的业务性异常UnacceptableException code:"406" 返回详细信息
 * 可能由XSS造成的安全性异常ForbiddenException code:"403" 返回特定信息
 * 由于代码错误，运行环境造成的项目异常UnavailableException code:"503" 返回特定信息
 * 未知错误 服务器内部错误 code:"500" 返回特定信息*/
public class ExceptionResolver implements HandlerExceptionResolver, PriorityOrdered {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView exception = new ModelAndView("exception");
        // TODO 对于一些高频率发生的业务错误，最好别用异常来处理，会导致性能下降，最好分支判断后直接返回json数据，这个项目我就偷下懒
        if (ex instanceof UnacceptableException) {
            if (logger.isInfoEnabled()) {
                logger.info("业务性异常：" + ex.getMessage());
            }
            exception.addObject("code", "406");
            exception.addObject("info", ex.getMessage());
            return exception;
        }

        /*处理可能由XSS造成的异常
         * 这里是采取最简单的处理方式，只是记录IP
         * 可能通过IP比对方式设立黑名单，然后用过滤器等方式实现*/
        if (ex instanceof ForbiddenException) {
            logger.warn("安全性异常：" + ex.getMessage() + "，异常访问IP为：" + IPUtil.getIP(request));
            //TODO 其实这边可以再细分下，某些情况下是可以清空Cookie的
            exception.addObject("code", "403");
            exception.addObject("info", "服务器拒绝访问！");
            return exception;
        }

        if (ex instanceof UnavailableException) {
            logger.warn("项目运行中异常：" + ex.getMessage());
            //打印栈信息到输出台，服务器上的结果可以在catalina.out中查看
            ex.printStackTrace();
            exception.addObject("code", "503");
            exception.addObject("info", "服务器繁忙，请稍后再试");
            return exception;
        }

        if (ex instanceof ServerException) {
            logger.error("RMI服务器异常：" + ex.getMessage());
            exception.addObject("code", "500");
            exception.addObject("info", "服务器正在维护，暂时无法访问");
            return exception;
        }

        if(ex instanceof MaxUploadSizeExceededException){
            if (logger.isInfoEnabled()) {
                logger.info("业务性异常：用户上传文件过大，用户名：" + request.getSession().getAttribute("name"));
            }
            exception.addObject("code", "406");
            exception.addObject("info", "上传文件过大，不得超过5M");
            return exception;
        }

        //其他的异常为意料之外的异常，error级别输出
        logger.error("未知错误：" + ex.getClass().getSimpleName());
        //打印栈信息到输出台，服务器上的结果可以在catalina.out中查看
        ex.printStackTrace();
        exception.addObject("code", "500");
        exception.addObject("info", "服务器异常，请联系开发人员");
        return exception;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
