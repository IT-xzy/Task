package com.ptteng.service.impl;

import com.ptteng.dao.UserDAO;
import com.ptteng.manager.Redis;
import com.ptteng.pojo.model.Graduate;
import com.ptteng.dao.GraduateDAO;
import com.ptteng.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("homeService")
public class HomeServiceImpl implements HomeService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GraduateDAO graduateDAO;
    @Autowired
    private Redis cacheManager;


    @Override
    public Object countGraduatesByCache() {
        Object graNum;
        if ((graNum = cacheManager.get("graduate", "number")) != null) {
            return graNum;
        } else {
            graNum = graduateDAO.selectCount();
            cacheManager.put("graduate", "number", graNum, 3600L);
            return graNum;
        }
    }

    @Override
    public Object countStudentsByCache() {
        Object stuNum;
        if ((stuNum = cacheManager.get("student", "number")) != null) {
            return stuNum;
        } else {
            stuNum = userDAO.selectCount();
            cacheManager.put("student", "number", stuNum, 3600L);
            return stuNum;
        }
    }

    @Override
    public Graduate findByPrimeKey(Long primekey) throws Exception {
        return graduateDAO.findById(primekey);
    }

    @Override
    public Object getGraduatesByCache(int size) throws Exception {
        Object graduateList;
        if ((graduateList = cacheManager.get("graduate", "list")) != null) {
            return graduateList;
        } else {
            graduateList = getGraduates(size);
            cacheManager.put("graduate", "list", graduateList, 3600L);
            return graduateList;
        }
    }

    private List<Graduate> getGraduates(int size) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        int total = graduateDAO.selectCount();
        int start = (int) (total * Math.random());
        map.put("start", start);
        map.put("size", size);
        List<Graduate> list = graduateDAO.findGraduates(map);
        for (int i = list.size(); i < size; i++) {
            list.add(new Graduate("暂缺！", "a.png", "等你加入！"));
        }
        return list;
    }

}
