package com.ptteng.service.impl;

import com.ptteng.bean.Graduate;
import com.ptteng.dao.GraduateDao;
import com.ptteng.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GraduateServiceImpl implements GraduateService {
    @Autowired
    private GraduateDao graduateDao;

    public int countGraduate() {
        return graduateDao.selectCount();
    }

    public Graduate findByPrimeKey(Long primekey) throws Exception {
        return graduateDao.findById(primekey);
    }

    @Override
    public List<Graduate> selectManyGraduates(int size) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        int total = graduateDao.selectCount();
        if (total < 10)
            throw new RuntimeException("毕业人数太少，请检查数据库！");
        int start = (int) (total * Math.random());
        map.put("start", start);
        map.put("size", size);
        List<Graduate> list = graduateDao.findGraduates(map);
        for(int i = list.size();i<4;i++){
            list.add(new Graduate("暂缺！","a.png","等你加入！"));
        }
        return list;
    }


}
