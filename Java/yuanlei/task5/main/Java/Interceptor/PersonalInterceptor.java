package Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import utils.EncryUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PersonalInterceptor implements HandlerInterceptor{
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object object) throws Exception{
        //从HttpServletRequest中获取cookies并放入数组中
        Cookie [] cookies = httpServletRequest.getCookies();
        //for加强循坏,循环遍历cookie数组
        for(Cookie ck : cookies){
            if (ck.getName().equals("Token")){
                String tk = ck.getValue();
                String jm = EncryUtil.decrypt(tk);
               //将解密后的字符串用","分离,并放入数组中
                String[] token = jm.split(",");
                String name = token[1];
                String tokenTime = token[0];
               if(!userService.nameTest(name)){
                   System.out.println("完成Token检验");
                   return true;
               }
            }

        }
        System.out.println("Token验证失败");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/task5/login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }
    @Override
    public  void postHandle(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,ModelAndView modelAndView)throws Exception{
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e)throws Exception{

    }
}
