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
        Object graduateNumber;
        if((graduateNumber=cacheManager.get("graduate","number"))!=null){
            return graduateNumber;
        } else {
            graduateNumber = graduateDao.selectCount();
            cacheManager.put("graduate","number",graduateNumber,0L);
            return graduateNumber;
        }
    }

    @Override
    public Object countStudentsByCache() {
        Object studentNumber;
        if((studentNumber=cacheManager.get("student","number"))!=null){
            return studentNumber;
        } else {
            studentNumber = studentDao.selectCount();
            cacheManager.put("student","number",studentNumber,0L);
            return studentNumber;
        }
    }

    @Override
    public Graduate findByPrimeKey(Long primekey) throws Exception {
        return graduateDao.findById(primekey);
    }

    @Override
    public Object getGraduatesByCache(int size) throws Exception {
        Object graduateList;
        if((graduateList=cacheManager.get("graduate","list"))!=null){
            return graduateList;
        } else {
            graduateList = getGraduates(size);
            cacheManager.put("graduate","list",graduateList,0L);
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
