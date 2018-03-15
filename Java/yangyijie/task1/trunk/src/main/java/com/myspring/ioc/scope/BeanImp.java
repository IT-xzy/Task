package com.myspring.ioc.scope;

/**
 * @author Arike
 * Create_at 2017/11/28 19:42
 */
public class BeanImp implements IBean {
    public BeanImp() {
        System.out.println("构造函数");
    }
    public void init(){
        System.out.println("初始化");
    }
    public void run(){
        System.out.println("手动执行");
    }
    public void close() {
        System.out.println("回收资源");
    }
}
