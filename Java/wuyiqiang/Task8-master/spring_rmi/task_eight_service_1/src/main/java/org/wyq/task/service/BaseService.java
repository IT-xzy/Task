package org.wyq.task.service;

import org.wyq.task.pojo.Profession;
import org.wyq.task.pojo.Salary;
import org.wyq.task.pojo.Students;

import java.util.List;

public interface BaseService {

    List<Students> selectStudentsByEvaluate();

    Integer countStudentsByStatus(Integer status);

    List<Profession> selectProfessionByDirection(String direction);

    Salary selectSalaryByPrimaryKey(Integer id);

    List<Profession> selectProfessionAll();

    List<Salary> selecSalarytAll();

    List<String> directionCategoryList();

    Integer countStudentsByProfession(String profession);

    List<Students> selectStudentsAll();
}
