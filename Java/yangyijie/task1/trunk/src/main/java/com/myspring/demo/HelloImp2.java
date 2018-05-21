package com.myspring.demo;

/**
 * @author Arike
 * Create_at 2017/11/28 14:46
 */
public class HelloImp2 implements IHello {
    private int time;
    
    public void setTime(int time) {
        this.time = time;
    }
    
    //用于测试bean初始化的时机.
    {
        System.out.println("bean初始化");
    }
    
    @Override
    public void say() {
        System.out.println("疯狂暴打了你" + time + "次");
    }
}
