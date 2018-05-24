package com.task.service.Impl;

import com.task.cache.SpyMemcachedManager;
import com.task.dao.ProfessionDao;
import com.task.models.Profession;
import com.task.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl implements ProfessionService{
    @Autowired
    private  ProfessionDao professionDao;
    private ApplicationContext app=new ClassPathXmlApplicationContext("app-context-spymemcached.xml");;
    private SpyMemcachedManager memcachedManager=(SpyMemcachedManager) app.getBean("memcachedManager");;
    private Logger logger = Logger.getLogger(ProfessionServiceImpl.class);
    private static int exp=60*1000;
    @Override
    public int justAdd(Profession profession) throws Exception {
      professionDao.addPro(profession);
        return profession.getId();
    }

    @Override
    public Boolean justDelete(int id) throws Exception {
        return professionDao.deletePro(id);
    }

    @Override
    public Boolean justUpdate(Profession profession) throws Exception {
        return professionDao.updatePro(profession);
    }

    @Override
    public Profession justListByName(String name) throws Exception {
        Profession profession;
        if(memcachedManager.get("profession"+name)!=null){
            profession=(Profession) memcachedManager.get("profession"+name);
            logger.info("获取缓存"+name);
        }else{
            profession=professionDao.getProByName(name);
            memcachedManager.set("profession"+name,profession,exp);
            logger.info("存入缓存"+name);
        }
        return profession;
    }
}
