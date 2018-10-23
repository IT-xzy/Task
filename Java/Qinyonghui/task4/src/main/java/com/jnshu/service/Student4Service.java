package com.jnshu.service;

import com.jnshu.entity.Student4;

import java.util.List;

public interface Student4Service {
        long CountSelective(String job, boolean state);
        long SelectCountByState(boolean state);
        List<Student4> getOrderByKeyWords(Student4 student4);
}
