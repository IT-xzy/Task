package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 自定义全局异常处理器
 */
public class SupplierHandlerExceptionResolver implements HandlerExceptionResolver {

    // handler就是处理器适配器要执行Handler对象（只有一个method）
    //解析出异常类型
    //如果该异常类型是系统自定义的异常，直接取出异常信息，在错误页面展示
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        SupplierException supplierException=null;
        if(ex instanceof SupplierException){
            supplierException =(SupplierException)ex;
        }else {//如果该异常类型不是系统自定义的异常，构造一个自定义的异常类型（信息为“未知错误”）
            supplierException=new SupplierException("未知错误");
        }

//        错误信息
        String message=supplierException.getMessage();
//        定义ModelAndView,将错入信息传到错误页面
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
