package com.jnshu.mapper;

import com.jnshu.entity.Student4;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface Student4Mapper extends Mapper<Student4> {
    Student4 findById(Long id);
    long batchSave(List<Student4> student4List);
    List<Student4> getStudent4ByPage(int startRow, int endRow);
}