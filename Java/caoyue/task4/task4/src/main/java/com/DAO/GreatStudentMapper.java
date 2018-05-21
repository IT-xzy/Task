package com.DAO;

import com.POJO.GreatStudent;
import com.POJO.Cooperation;
import com.POJO.HowToStudy;
import com.POJO.Profession;
import com.POJO.Company;

import java.io.IOException;
import java.util.List;

/**
 * @author: 曹樾
 * @program: task4
 * @description:
 * @create: 2018/4/24 下午4:09
 */

public interface GreatStudentMapper {
    List<GreatStudent> findUserByName();
    List<Cooperation> findCooperation();
    List<HowToStudy> findStudy();
    List<Profession> findFront();
    List<Profession> findAfter();
    List<Profession> findOP();
    List<Profession> findPM();
    List<Company> findCompany();
}

