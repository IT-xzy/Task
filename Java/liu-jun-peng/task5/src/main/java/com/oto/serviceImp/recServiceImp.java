package com.oto.serviceImp;

import com.oto.dao.recDao;
import com.oto.pojo.rec;
import com.oto.service.recService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/7 上午10:07
 */
@Service
public class recServiceImp implements recService {
    
    @Autowired
    private recDao recDao;
    
    @Override
    public List<rec> findAll() {
        
        List<rec> recs = recDao.findALL();
        
        return recs;
    }
}
