package com.task.tuscany.server;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Calculator implements ICalculator{
    private ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private IAdd add=ctx.getBean(IAdd.class);
//    @Autowired
//    private IAdd add;
//    public IAdd getAdd() {
//        return add;
//    }
//
//    @Reference
//    public void setAdd(IAdd add) {
//        this.add = add;
//    }
//暂时只使用单组件，而不使用引用
    @Override
    public double add(double a, double b) {
        return this.add.add(a,b);
//        return  a+b;
    }
}
