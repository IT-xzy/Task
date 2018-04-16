package org.wyq.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wyq.task.mapper.ProfessionMapper;
import org.wyq.task.mapper.SalaryMapper;
import org.wyq.task.mapper.StudentsMapper;
import org.wyq.task.pojo.Profession;
import org.wyq.task.pojo.Salary;
import org.wyq.task.pojo.Students;

import java.util.ArrayList;
import java.util.List;

@Service("schoolService")
public class SchoolService implements BaseService {

    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private ProfessionMapper professionMapper;

    @Autowired
    private SalaryMapper salaryMapper;

    public List<Students> selectStudentsByEvaluate() {
        List<Students> list = studentsMapper.selectByEvaluate();
        return list;
    }

    public Integer countStudentsByStatus(Integer status) {
        Integer num = studentsMapper.countByStatus(status);
        return num;
    }

    public List<Profession> selectProfessionByDirection(String direction) {
        List<Profession> list = professionMapper.selectByDirection(direction);
        return list;
    }

    public Salary selectSalaryByPrimaryKey(Integer id) {
        Salary salary = salaryMapper.selectByPrimaryKey(id);
        return salary;
    }

    public List<Profession> selectProfessionAll() {
        List<Profession> list = professionMapper.selectAll();
        return list;
    }

    public List<Salary> selecSalarytAll() {
        List<Salary> list = salaryMapper.selectAll();
        return list;
    }

    public List<String> directionCategoryList() {
        List<String> list = professionMapper.directionCategoryList();
        return list;
    }

    public Integer countStudentsByProfession(String profession) {
        System.out.println("rmi test");
        Integer count = studentsMapper.countByProfession(profession);
        return count;
    }

    public List<Students> selectStudentsAll() {
        List<Students> list = studentsMapper.selectAll();
        return list;
    }
}
