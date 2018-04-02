package com.springmybatis.Mapper;


import com.springmybatis.model.StudentMod;

import java.util.List;

/**
 * 定义了增删改查的接口
 * Created by Administrator on 16/7/2017.
 */
public interface StudentMapper {
     StudentMod studySelect(StudentMod studentMod);
     int studyInsert(StudentMod studentMod);
     int studyUpdate(StudentMod studentMod);
     int studyDelete(String user_id);
     List<StudentMod> studentName();
}
