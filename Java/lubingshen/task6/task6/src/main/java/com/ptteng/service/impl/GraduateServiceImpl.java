package com.ptteng.service.impl;

import com.ptteng.dao.StudentDao;
import com.ptteng.manager.CacheManager;
import com.ptteng.pojo.model.Graduate;
import com.ptteng.dao.GraduateDao;
import com.ptteng.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GraduateServiceImpl implements GraduateService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private GraduateDao graduateDao;
    @Autowired
    private CacheManager cacheManager;


    @Override
    public Object countGraduatesByCache() {
        Object graNum;
        if((graNum=cacheManager.getDataByCache("graNum"))!=null){
            return graNum;
        } else {
            graNum = graduateDao.selectCount();
            cacheManager.addDataIntoCache("graNum",graNum);
            return graNum;
        }
    }

    @Override
    public Object countStudentsByCache() {
        Object stuNum;
        if((stuNum=cacheManager.getDataByCache("stuNum"))!=null){
            return stuNum;
        } else {
            stuNum = studentDao.selectCount();
            cacheManager.addDataIntoCache("stuNum",stuNum);
            return stuNum;
        }
    }

    @Override
    public Graduate findByPrimeKey(Long primekey) throws Exception {
        return graduateDao.findById(primekey);
    }

    @Override
    public Object getGraduatesByCache(int size) throws Exception {
        Object graduateList;
        if((graduateList=cacheManager.getDataByCache("Graduate"))!=null){
            return graduateList;
        } else {
            graduateList = getGraduates(size);
            cacheManager.addDataIntoCache("Graduate",graduateList);
            return graduateList;
        }
    }

    private List<Graduate> getGraduates(int size) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        int total = graduateDao.selectCount();
        int start = (int) (total * Math.random());
        map.put("start", start);
        map.put("size", size);
        List<Graduate> list = graduateDao.findGraduates(map);
        for (int i = list.size(); i < size; i++) {
            list.add(new Graduate("暂缺！", "a.png", "等你加入！"));
        }
        return list;
    }

}
