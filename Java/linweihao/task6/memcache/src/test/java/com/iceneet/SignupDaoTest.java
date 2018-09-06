package com.iceneet;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iceneet.entity.Signup;
import com.iceneet.service.Signupservice;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import java.io.NotSerializableException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SignupDaoTest {
    @Autowired
    private Signupservice signupservice;

    @Test
    public void Test() throws InterruptedException, MemcachedException, TimeoutException {
        PageHelper.startPage(1,1);
        List<Signup> l = signupservice.getSignAll();
        PageInfo<Signup> s = new PageInfo<>(l);
        System.out.println(signupservice.GetSignupById(1));
        System.out.println(s);
    }

}
