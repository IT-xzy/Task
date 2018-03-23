package com.ptteng.dao;

import com.ptteng.pojo.model.Student;

public interface StudentDAO {
    //通过学生id查找
    String findById(Long id) throws Exception;
    //通过学生id修改用户头像
    boolean updateAvatarById(Student student) throws Exception;
    //通过技能树用户系统插入一条学员信息
    boolean insertStudent(Student student) throws Exception;
}
