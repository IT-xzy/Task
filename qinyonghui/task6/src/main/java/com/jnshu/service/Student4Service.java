package com.jnshu.service;

import com.jnshu.entity.Student4;

import java.util.List;

public interface Student4Service {
        long CountSelective(String job, boolean state);
        long SelectCountByState(boolean state);
        List<Student4> getOrderByKeyWords(Student4 student4);
        List<Student4> findAll();
        Student4  findStudent4ById(Long id);
        Boolean batchSave(List<Student4> student4List);
        public long addStudent4(Student4 student4);
        public int updateStudent4(Student4 student4);
        public int deleteStudent4(Student4 student4);

        public List<Student4> getStudent4ByPage(int pageIndex, int pageSize);
}
