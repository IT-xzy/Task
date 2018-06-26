package com.jnshu.mapper;

import com.jnshu.model.StudentCustom;
import com.jnshu.model.StudentQV;

import java.util.List;

/**
 * @program: smsdemo
 * @description: 学生数据接口
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:15
 **/

public interface StudentDao {
    //为空时查找所有用户
    List<StudentCustom> findStudentCustomMore(StudentQV studentQV) throws Exception;

    // 根据ID查找用户
    StudentCustom findStudentCustomById(Integer id) throws Exception;

    //返回影响行数 0即代表false true 非 0
    Integer insertStudentCustom(StudentCustom StudentCustom) throws Exception;

    //返回返回影响行数 0即代表false true 非 0
    boolean deleteStudentCustom(Integer id) throws Exception;

    //返回返回影响行数 0即代表false true 非 0
    boolean updateStudentCustom(StudentCustom studentCustom) throws Exception;

    // 邮箱验证
    boolean updateEmail(StudentCustom studentCustom) throws Exception;

    // 手机号验证更新
    boolean updateTelephone(Integer id, String telePhone) throws Exception;

    // 统计学生数
    Integer countStudent() throws Exception;

    // 统计工作数
    Integer countWork() throws Exception;
}
