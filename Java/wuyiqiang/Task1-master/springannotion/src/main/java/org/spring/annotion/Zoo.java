package org.spring.annotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("zoo")
@Scope("prototype")
public class Zoo {

    /*
    @Autowired(required = false)
    @Qualifier("tiger2")
    private Tiger tiger;
    @Resource(name = "monkey1", type = Monkey.class)
    private Monkey monkey;
*/
    @Autowired(required = false)
    private Tiger tiger;
    @Resource
    //@Autowired
    //@Qualifier("monkey1")
    private Monkey monkey;
/*
    public Tiger getTiger(){
        return tiger;
    }

    public void setTiger(Tiger tiger){
        this.tiger = tiger;
    }

    public Monkey getMonkey() {
        return monkey;
    }

    public void setMonkey(Monkey monkey) {
        this.monkey = monkey;
    }
*/
    public String toString(){
        return tiger + "\n" + monkey;
    }
}
