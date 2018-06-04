package dao;

import pojo.Career;

import java.util.List;

/**
 * 职业方向
 */
public interface CareerMapper {
    Career getCareerById(int id);
    List<Career> getAllCareer();
}
