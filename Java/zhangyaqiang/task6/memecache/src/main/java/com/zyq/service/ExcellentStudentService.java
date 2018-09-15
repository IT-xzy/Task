package com.zyq.service;

import com.zyq.pojo.ExcellentStudent;

import java.util.List;

public interface ExcellentStudentService {
    List<ExcellentStudent> selectByOrder();
    List<ExcellentStudent> selectByOrder2();
}
