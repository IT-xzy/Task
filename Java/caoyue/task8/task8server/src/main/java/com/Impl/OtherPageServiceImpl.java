package com.Impl;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 除职业外的其他元素
 * @create: 2018/5/7 下午5:34
 */

import com.POJO.Company;
import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;
import com.mappers.OtherPageMapper;
import com.service.OtherPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task6
 * @description: 除职业和登录之外的其他页面
 * @create: 2018/5/3 下午4:01
 */

@Service
public class OtherPageServiceImpl implements OtherPageService {
    @Autowired
    private OtherPageMapper otherPageMapper;
    /**
     * 查找优秀学员
     * @return
     */
    public List<GreatStudent> findStudentByName() {
        return otherPageMapper.findStudentByName();
    }
    
    /**
     * 合作企业图标
     * @return
     */
    public List<Cooperation> findCooperation()  {
        return otherPageMapper.findCooperation();
    }
    
    /**
     * 首页学习流程
     * @return
     */
    public List<HowToStudy> findStudy()  {
        return otherPageMapper.findStudy();
    }
    
    /**
     * 推荐企业
     * @return
     */
    public List<Company> findCompany() {
        return otherPageMapper.findCompany();
    }
}

