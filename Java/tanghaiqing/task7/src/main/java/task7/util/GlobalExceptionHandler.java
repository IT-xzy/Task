package task7.util;


import org.apache.log4j.Logger;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public void exHandle(Exception ex, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("看一下是不是你处理了");
        logger.info(ex.getMessage());
        if (ex instanceof ApplicationException) {
            logger.error("应用错误");
            ex.printStackTrace();
            request.getSession().setAttribute("errorMessage", ex.getMessage());
            response.sendRedirect("error");
            return;
        }
        if (ex instanceof MethodArgumentNotValidException) {
            logger.error("参数验证错误！");
            ex.printStackTrace();
            request.getSession().setAttribute("errorMessage", ex.getMessage());
            response.sendRedirect("error");
            return;
        }
        logger.error("未知错误");
        ex.printStackTrace();
        request.getSession().setAttribute("errorMessage", ex.getMessage());
        response.sendRedirect("error");
    }
}
