package jnshu.tasksix.Listener;

import jnshu.tasksix.util.MyTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;

/**
 * Created by Administrator on 2017-10-07.
 * 当网站用户量增加时，session占用的内存会越来越大，这时session的管理，将会是一项很大的
 * 系统开销，为了高效的管理session，我们可以写一个监听器，定期清理掉过期的session
 */
public class SessionScanerListener implements HttpSessionListener, ServletContextListener {

    private static Logger loggerSSL = LoggerFactory.getLogger(SessionListener.class);

    // 创建一个线程安全的集合，来存储session
    @SuppressWarnings("unchecked")

    //LinkedList类是双向列表,列表中的每个节点都包含了对前一个和后一个元素的引用.
    // Collections.synchronizedList()  详情：http://www.cnblogs.com/yaowen/p/5983136.html
    private List<HttpSession> sessionList = Collections.synchronizedList(new LinkedList<HttpSession>());

    private Object lock = new Object();

    public void sessionCreated(HttpSessionEvent httpSessionEvent){
        loggerSSL.info("session创建成功");
        HttpSession httpSession = httpSessionEvent.getSession();
        loggerSSL.info("httpSession" + httpSession);
        /**
         * synchronized有两种用法，(this)一种是在方法定义时使用，多线程状态下，这个方法只能同时被同一个线程执行；
         * (lock)另一种就是你问到的这种情况，用于锁定代码段，也就是说，{ }括号中的代码是不会同时被多个线程执行，而是排队执行。
         *
         * synchronized是Java中的关键字，是一种同步锁。它修饰的对象有以下几种：
            1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
            2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
            3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
            4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
         */
        synchronized (lock){
            sessionList.add(httpSession);
            loggerSSL.info("sessionList数量" + sessionList.size());
        }

    }


    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        loggerSSL.info("session 销毁成功...");
        loggerSSL.info("sessionList数量" + sessionList.size());
    }


    /**
     * 1 ： ServletContext 对象是一个为整个 web 应用提供共享的内存，任何请求都可以访问里面的内容
     * 2 ：如何实现在服务启动的时候就动态的加入到里面的内容：我们需要做的有：
     *    1 ） 实现 servletContextListerner 接口 并将要共享的通过 setAttribute （ name,data ）方法提交到内存中去
     *    2 ）应用项目通过 getAttribute(name) 将数据取到 。
     * @param servletContextEvent
     */
    // web应用关闭时触发contextDestroyed事件
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        loggerSSL.info("web应用关闭...");
    }

    // web应用启动时触发contextInitialized事件
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        loggerSSL.info("web应用初始化...");
        // 创建定时器

        //Timer是jdk中提供的一个定时器工具，
        // 使用的时候会在主线程之外起一个单独的线程执行指定的计划任务，可以指定执行一次或者反复执行多次。
        Timer timer = new Timer();
        // 每隔30秒就定时执行任务
        timer.schedule(new MyTask(sessionList,lock), 0, 1000*30);
        // delay为long,period为long：从现在起过delay毫秒以后，每隔period
        // 毫秒执行一次。
    }

}
