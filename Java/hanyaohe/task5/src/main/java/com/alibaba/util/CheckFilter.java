package com.alibaba.util;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)arg0;
        HttpServletResponse response=(HttpServletResponse)arg1;
        Cookie[] cookies=request.getCookies();
        String user = "";
        String pass = "";
        if(cookies!=null){
            for(Cookie coo:cookies){
                if(coo.getName().equals("loginInfo")){
                    String[] info=coo.getValue().split(",");
                    user=info[0];
                    pass=info[1];
                }
            }
        }
        //如果在cookie中得到保存的用户名和密码，验证正确后，直接转到success页
        if(new LoginBiz().isValid(user, pass)){
            response.sendRedirect("/WEB-INF/view/CustomerForm.jsp");
        }else{
            arg2.doFilter(request, response);
        }

    }
    public void init(FilterConfig arg0) throws ServletException {

    }


}
