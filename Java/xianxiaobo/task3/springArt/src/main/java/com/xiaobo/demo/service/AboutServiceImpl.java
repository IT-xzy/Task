package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.AboutDao;
import com.xiaobo.demo.pojo.About;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    private AboutDao aboutDao;
    @Override
    public List<About> getList(About about, Map<String,Object> pageData){
        return aboutDao.getList(about,pageData);
    }
    @Override
    public Boolean add(About about){
        return aboutDao.add(about);
    }
    @Override
    public Boolean update(About about){
        return aboutDao.update(about);
    }

    @Override
    public Boolean delete(About about){
        return aboutDao.delete(about);
    }
}
