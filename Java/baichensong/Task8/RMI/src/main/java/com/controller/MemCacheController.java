package com.controller;

import com.memcached.Cached;
import com.memcached.MemcacheTool;
import org.ApplicationAll;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author baich
 */
@Controller

/* 任务六  mamcached*/

public class MemCacheController {
    /**
//    @Autowired
//    public StudentService service;
//
//    ApplicationContext application = new ClassPathXmlApplicationContext("applicationContext-client.xml");
//    StudentService service = (StudentService) application.getBean("client");
*/
    ApplicationAll applicationAll = new ApplicationAll();
    private static Log log = LogFactory.getLog(MemCacheController.class);


    @RequestMapping("zTest1")
    public String test() {
        return "Test1";
    }


    @RequestMapping(value = "/zfindSessionByKey", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object findByKey() {
        /*System.out.println(" MemcacheUtils 测试: " + key );*/
        log.info("MemCacheController.findByKey param:key=");
        MemcacheTool.set("bai", "98765", new Date(30000 * 60));

        return MemcacheTool.get("bai");
    }


    /**通过id查寻数据库  存入缓存*/
    @RequestMapping(value = "ztest11/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public Object finduserById(@RequestBody @PathVariable("id") int id) {

        return applicationAll.service().findUserById(id);
    }

    /**查寻所有数据      memcached的  完整缓存------不被用户修改的数据 （只做查询）*/
    @RequestMapping(value = "zfindAll")
    @ResponseBody
    public List<Cached> findAllId() {
        return applicationAll.service().findAllId();
    }


    /**更新数据库数据*/
    @RequestMapping(value = "zupdate/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void updateById(@PathVariable int id, Cached cached) {
        cached.setId(id);
        cached.setName("baiu");
        cached.setQq("8989");
        cached.setKemu("nihao");
        cached.setCreated_at(Long.valueOf(777));
        cached.setUpdated_at(Long.valueOf(5555));
        applicationAll.service().updateById(cached);
        MemcacheTool.replace("user" + id, cached, new Date(30000 * 60));
    }
}
