package org.wyq.task.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.wyq.task.pojo.Salary;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    Salary selectByPrimaryKey(Integer id);

    List<Salary> selectAll();

    int updateByPrimaryKey(Salary record);
}