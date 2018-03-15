package com.myspring.ioc.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arike
 * Create_at 2017/11/28 19:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/myspring/ioc/scope/IBeanSpring.xml")
public class IBeanTest {
    @Autowired
    ApplicationContext ctx;
    
    @Test
    //单例作用域只会初始化一次,得到的三个实例都指向同一个对象
    public void sigletonBean() throws Exception {
        System.out.println(ctx.getBean("imp1", IBean.class));
        System.out.println(ctx.getBean("imp1", IBean.class));
        ctx.getBean("imp1", BeanImp.class).run();
        
    }
    
    @Test
    //多例作用域每次获取bean类都会初始化一次,每次的对象都不相同
    public void prototypeBean() throws Exception {
        ctx.getBean("imp1more", BeanImp.class).run();
        System.out.println(ctx.getBean("imp1more", IBean.class));
        System.out.println(ctx.getBean("imp1more", IBean.class));
        System.out.println(ctx.getBean("imp1more", IBean.class));
        System.out.println(ctx.getBean("imp1more", IBean.class));
      
        
    }
    
    @Test
    //单例模式:自动运行初始化方法以及销毁(资源回收方法)
    public void autoMethod() {
        //在获取bean实例的时候就会执行初始化以及init方法,然后执行自定义的method方法,最后才会执行close回收资源.
        ctx.getBean("imp1", BeanImp.class).run();
    }
    
    @Test
    //多例模式:自动运行初始化方法,不会自动执行销毁
    public void halfAuto() {
        BeanImp bi = ctx.getBean("imp1more", BeanImp.class);
        bi.run();
        //需要手动执行资源回收方法
        bi.close();
    }
}