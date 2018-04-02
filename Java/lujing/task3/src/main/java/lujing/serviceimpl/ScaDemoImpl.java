package lujing.serviceimpl;

import lujing.service.ScaDemo;

/**
 * @author lujing
 * Create_at 2018/1/28 10:18
 */
public class ScaDemoImpl implements ScaDemo {
    @Override
    public String sayHi(String name) {
        
        return "能不能连上呢"+name;
    }
}
