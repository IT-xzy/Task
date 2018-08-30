package com.iceneet.web;

import com.iceneet.entity.Signup;
import com.iceneet.service.Signupservice;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.NotSerializableException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Signupservice signupservice;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String JsonTest(ModelMap modelMap) throws InterruptedException, MemcachedException, TimeoutException, NotSerializableException {
        List<Signup> Signups = signupservice.getSignupByPage(1,10);
        modelMap.put("List",Signups);
        System.out.println(Signups.size());
        return "Test";
    }
}
