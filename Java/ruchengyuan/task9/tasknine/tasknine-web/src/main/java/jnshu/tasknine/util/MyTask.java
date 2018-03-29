package jnshu.tasknine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ListIterator;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017-10-07.
 */
public class MyTask extends TimerTask {
    private static Logger loggerMT = LoggerFactory.getLogger(MyTask.class);


    private List<HttpSession> list;
    // 存储传递过来的锁
    private Object lock;
    // 构造方法
    public MyTask(List<HttpSession> list, Object lock){
        this.list = list;
        this.lock = lock;
    }
    @Override
    public void run() {
        // 考虑到多线程的情况，这里必须要同步
        synchronized (lock){
//            loggerMT.info("定时器开始执行...");

            /**
             * ListIterator只能用于List及其子类型。
             * 在List接口中，有一个方法listIterator(int index)可以得到List的迭代器（ListIterator接口的对象）
             * 迭代器指向的位置是元素之前的位置
             */
            ListIterator<HttpSession> listIterator = list.listIterator();
            //hasNext()：以正向遍历列表时，如果列表迭代器后面还有元素，则返回 true，否则返回false
            while(listIterator.hasNext()){
                HttpSession httpSession = listIterator.next();
                // httpSession.getLastAccessedTime() = session的最后访问时间
                if(System.currentTimeMillis() - httpSession.getLastAccessedTime() > 1000*60*30){
                    // 手动销毁session
                    httpSession.invalidate();
                    // 从集合中移除已经被销毁的session
                    listIterator.remove();
                    loggerMT.info("sessionList数量" + list.size());
                }
            }
        }
    }
}
