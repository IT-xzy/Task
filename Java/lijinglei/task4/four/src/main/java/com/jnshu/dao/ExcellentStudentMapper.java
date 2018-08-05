package com.jnshu.dao;

import com.jnshu.model.ExcellentStudent;
import java.util.List;

public interface ExcellentStudentMapper {
    ExcellentStudent selectByPrimaryKey(Integer id);
    List<ExcellentStudent> listAll();
}