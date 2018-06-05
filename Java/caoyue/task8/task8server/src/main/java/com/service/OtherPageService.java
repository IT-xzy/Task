package com.service;

import com.POJO.Company;
import com.POJO.Cooperation;
import com.POJO.GreatStudent;
import com.POJO.HowToStudy;

import java.util.List;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 除开职业的其他元素操作实现接口
 * @create: 2018/5/7 下午5:39
 */

public interface OtherPageService {
    List<GreatStudent> findStudentByName();
    List<Cooperation> findCooperation();
    List<HowToStudy> findStudy();
    List<Company> findCompany();
}
