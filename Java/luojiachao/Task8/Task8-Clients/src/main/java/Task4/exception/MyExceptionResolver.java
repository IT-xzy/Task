package Task4.exception;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(MyExceptionResolver.class);
    //    系统遇到异常，在程序中手动抛出，dao抛给service、service给controller、controller抛给前端控制器，前端控制器调用全局异常处理器。
//
//    全局异常处理器处理思路：
//    解析出异常类型。
//    如果该 异常类型是系统 自定义的异常，直接取出异常信息，在错误页面展示。
//    如果该 异常类型不是系统 自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）。

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception expection) {
        MyException myException=null;
        if (expection instanceof MyException){
            myException=(MyException)expection;
        }else{
            System.out.println("11---------");

            expection.printStackTrace();
            System.out.println("11---------");
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




