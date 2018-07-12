package utils.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mav = new ModelAndView();
        if (e instanceof LoginException){
            mav.addObject("message",e.getMessage());
            mav.setViewName("error");
        }else{
            mav.addObject("message","出现未知异常！");
            mav.setViewName("error");
        }
        return mav;
    }
}
