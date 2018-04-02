package lujing.util;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Arike
 * Create_at 2017/12/29 15:11
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    //前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常，进行异常处理
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //输出异常
        ex.printStackTrace();
        
        String message = null;
        CustomException customException = null;
        
        if (ex instanceof CustomException) {
            customException = (CustomException) ex;
        } else {
             customException = new CustomException("未知错误");
        }
        message = customException.getMessage();
        
        request.setAttribute("message",message);
        
        
        //异常处理的代码
        
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return new ModelAndView();
    }
}
