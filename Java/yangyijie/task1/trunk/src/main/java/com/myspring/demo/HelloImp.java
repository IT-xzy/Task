package com.myspring.demo;

/**
 * @author Arike
 * Create_at 2017/11/28 10:06
 */
public class HelloImp implements IHello {
    private String name;
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void say() {
        System.out.println("师姐,一顿暴打" + name);
        
    }
    
}
