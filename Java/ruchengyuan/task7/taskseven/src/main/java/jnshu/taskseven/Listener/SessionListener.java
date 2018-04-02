package jnshu.taskseven.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 对每一个正在访问的用户，J2EE应用服务器会为其建立一个对应的HttpSession对象。
 * 当一个浏览器第一次访问网站的时候，J2EE应用服务器会新建一个HttpSession对象 ，
 * 并触发 HttpSession创建事件 ，如果注册了HttpSessionListener事件监听器，
 * 则会调用HttpSessionListener事件监听器的sessionCreated方法。
 * 相反，当这个浏览器访问结束超时的时候，J2EE应用服务器会销毁相应的HttpSession对象，
 * 触发 HttpSession销毁事件，同时调用所注册HttpSessionListener事件监听器的sessionDestroyed方法。
 * Created by Administrator on 2017-10-06.
 */
public class SessionListener implements HttpSessionListener{

    private static Logger loggerSL = LoggerFactory.getLogger(SessionListener.class);


    /* Session创建事件 */
    //HttpSessionEvent类只包装了一个方法，即getSession()，来获取触发事件的会话对象，在两个方法中可以调用该方法获取Session句柄并进行进一步处理；
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

//        loggerSL.info("Session创建事件");
        /**
         * ServletContext
         * ServletContext,是一个全局的储存信息的空间，服务器开始，其就存在，服务器关闭，其才释放。
         * servletContext，所有用户共用一个。所以，为了节省空间，提高效率，ServletContext中，
         * 要放必须的、重要的、所有用户需要共享的线程又是安全的一些信息。
         */

        /**
         * httpSessionEvent.getSession()
         * 在HttpSession对象初始化或结束前，会分别调用sessionCreated()与session- Destroyed()方法，
         * 可以通过传入的HttpSessionEvent，使用getSession()取得HttpSession，以针对会话对象作出相对应的创建或结束处理操作。
         */

        /*getServletContext() ， 获取HttpSession中的ServletContext对象*/
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
//        loggerSL.info("servletContext："+ servletContext);
        //获取名为TOTAL_ONLINE_USERS共享的数据
        Integer usersNumber = (Integer) servletContext.getAttribute("TOTAL_ONLINE_USERS");
//        loggerSL.info("当前登录用户数量："+ usersNumber);
        // 如果用户登陆，TOTAL_ONLINE_USERS 自增1
        if (usersNumber == null) {
            servletContext.setAttribute("TOTAL_ONLINE_USERS",1);
            loggerSL.info("当前登录用户数量："+ servletContext.getAttribute("TOTAL_ONLINE_USERS"));
        }
        else {
            usersNumber ++;
            loggerSL.info("当前登录用户数量："+ usersNumber);
            servletContext.setAttribute("TOTAL_ONLINE_USERS",usersNumber);
        }
    }



    /* Session失效事件 */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent){

//        loggerSL.info("Session失效事件");
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        loggerSL.info("servletContext："+ servletContext);
        Integer usersNumber = (Integer) servletContext.getAttribute("TOTAL_ONLINE_USERS");
        //如果用户推出，TOTAL_ONLINE_USERS自减1
        if(usersNumber == null ){
            servletContext.setAttribute("TOTAL_ONLINE_USERS",1);
            loggerSL.info("当前登录用户数量："+ servletContext.getAttribute("TOTAL_ONLINE_USERS"));
        }
        else {
            usersNumber --;
            loggerSL.info("当前登录用户数量："+ usersNumber);
            servletContext.setAttribute("TOTAL_ONLINE_USERS",usersNumber);
        }
    }
}
