package com.iceneet;

import com.iceneet.service.Service;
import com.iceneet.untils.RmiUtils;
import org.junit.Test;

import java.util.Random;

public class AopTest {
    @Test
    public void Test1(){
        Service service = new RmiUtils().getService();
        System.out.println(service.getSignupByPage(0,10));
    }
}
