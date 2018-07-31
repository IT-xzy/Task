package test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class AuthorityFilter implements Filter {
    private FilterConfig filterConfig;

    //初始化方法
//    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println ( "--AuthorityFilter初始化成功" );
        this.filterConfig = filterConfig;
    }

    //    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //设置filter的配置参数
        String encoding = filterConfig.getInitParameter ( "encoding" );
        String login = filterConfig.getInitParameter ( "login" );

        request.setCharacterEncoding ( encoding );
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpSession session = hrequest.getSession ( );
        //获取客户的请求的路径
        String requestPath = hrequest.getServletPath ( );
        System.out.println ( "session =====" + session.getAttribute ( "user" ) );
        if (session.getAttribute ( "user" ) == null && !requestPath.endsWith ( login )) {
            //forward到登录界面
            request.setAttribute ( "tip", "你还没登录" );
            request.getRequestDispatcher ( login ).forward ( request, response );
        } else {
            chain.doFilter ( request, response );
        }


//    public void destroy(){
//            this.filterConfig = null;
//        }
//

    }

    /**
     * Check if a given log record should be published.
     *
     * @param record a LogRecord
     * @return true if the log record should be published.
     */
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }

//    public static void main(String[] args) {
//        AuthorityFilter n = new AuthorityFilter ();
//    }
}
