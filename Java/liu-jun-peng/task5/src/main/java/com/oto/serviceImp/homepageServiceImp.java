package com.oto.serviceImp;

import com.oto.dao.homepageDao;
import com.oto.pojo.homepage;
import com.oto.service.homepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/5 下午8:21
 */
@Service
public class homepageServiceImp implements homepageService {
    @Autowired
    private homepageDao homepageDao;
    
    @Override
    public List<homepage> findAll() {
        List<homepage> homepages = homepageDao.findAll();
        return homepages;
    }
}
