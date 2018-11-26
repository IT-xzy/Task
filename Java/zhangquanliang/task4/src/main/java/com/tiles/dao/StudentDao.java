package com.tiles.dao;

import com.tiles.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 22:31
 * 学员的dao 接口
 */
@Repository
public interface StudentDao {

    /**
     * 查询全部学员
     */
     public List<Student> listStudent();

    /**
     * 查询工作或者在学的学员总数  tag=1,在学，tag=0 工作
     */
    public  int  getStudentType(Boolean tag);

}
