package com.task.interceptor;

import com.task.models.UserToken;
import com.task.service.UserService;
import com.task.utils.DESUtil;
import com.task.utils.JWTHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter{
  @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        boolean flag=isExist(request);//判断是否存在username和token
        if (flag){
        String str[]=getCookie(request);//将username和token取出来
            UserToken userToken= JWTHelper.unsign(str[1],UserToken.class);
//            String username=userToken.getUsername();
//            long loginTime1=userService.listByName(username).getLoginTime();
            //因为在解密的方法中以及判断过时间是否还有效，所以这里只需要判断username和loginTimeshi否是正确的就行了
            if(userToken!=null){
                return true;
            }
            else{
                response.sendRedirect("../login.jsp");
                //这里需要注意如果不过不加../就会重定向到localhost:8080/u/login.jsp
                return false;
            }
        }
        else{
            response.sendRedirect("../login.jsp");
            return false;
        }
    }



    /**
     * 获取cookie中的值
     * @param request
     * @return
     */
    public String[] getCookie(HttpServletRequest request) {
        String[] strs = new String[2];
        Cookie[] cs = request.getCookies();
        if (cs != null) {
            for (Cookie c : cs) {
                if (c.getName().equals("username")) {
                    // 获取加密过的用户名uid
                    strs[0] = c.getValue();
                }
                if (c.getName().equals("token")) {
                    // 获取加密过的登录时间lid
                    strs[1] = c.getValue();
                }
            }
        }
        return strs;
    }

    /**
     * 判断要求携带的两个cookie是否存在
     * @param request
     * @return
     */
    public boolean isExist(HttpServletRequest request)throws Exception {
         // 不存在的
        boolean flag = false;
        Cookie[] cs = request.getCookies();
        int count = 0;// 记录比较次数

        for (Cookie c : cs) {
            if (c.getName().equals("username")) {
                count++;
            }
            if (c.getName().equals("token")) {
                count++;
            }
        }
        if (count == 2) {
            flag = true;
        }
        return flag;
    }
}
