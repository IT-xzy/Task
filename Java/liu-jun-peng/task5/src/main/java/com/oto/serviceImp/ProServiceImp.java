package com.oto.serviceImp;

import com.oto.dao.proDao;
import com.oto.pojo.pro;
import com.oto.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/5 下午2:07
 */
@Service
public class ProServiceImp implements ProService{
    
    @Autowired
    private proDao proDao;
    
    @Override
    public List<pro> query() {
        
        List<pro> pros = proDao.query();
        
        return pros;
    }
}
