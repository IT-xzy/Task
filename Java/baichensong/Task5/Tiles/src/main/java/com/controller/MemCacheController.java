package com.controller;

import com.Xmemcached.MemcacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class MemCacheController {
    private static Logger log = LoggerFactory.getLogger(MemCacheController.class);

    @RequestMapping("Test1")
    public String test(){
        return "Test1";
    }

    @RequestMapping(value = "/findSessionByKey", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object findByKey(){
        //System.out.println(" MemcacheUtils 测试: " + key );
        log.info("MemCacheController.findByKey param:key=");
        MemcacheUtils.set("bai","98765",new Date(30000*60));

        return MemcacheUtils.get("bai");
    }



}
