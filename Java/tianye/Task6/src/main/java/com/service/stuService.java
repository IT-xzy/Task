package com.service;

import com.pojo.t_information;
import com.pojo.t_student;
import com.pojo.t_studentPro;

import java.util.List;

public interface stuService {
    List<t_student> selectAll();
    List<t_studentPro> selectAlls();
    t_information select(String userId);
    void insert(t_information t_information);
    void update(t_information t_information);

    List<t_studentPro> listUser();
}
