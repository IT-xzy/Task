package com.jnshu.service;

import com.jnshu.model.Profession;
import com.jnshu.model.StudentCustom;
import com.jnshu.model.StudentQV;
import com.jnshu.model.UserAuth;

import java.util.List;

/**
 * @program: smsdemo
 * @description: Service层
 * @author: Mr.xweiba
 * @create: 2018-05-29 23:29
 **/

public interface ServiceDao {
    // 按条件搜索学员信息
    List<StudentCustom> findListStudent(StudentQV studentQV) throws Exception;
    // 按id查询学员信息
    StudentCustom findStudentCustomById(Integer id) throws Exception;
    // 插入学员信息
    Integer insertStudent(StudentCustom studentCustom) throws Exception;
    // 删除学员信息
    boolean deleteStudent(Integer id) throws Exception;
    // 更新学员信息
    boolean updateStudent(StudentCustom studentCustom) throws Exception;
    // 邮箱验证更新
    boolean updateEmail(StudentCustom studentCustom) throws Exception;
    // 手机号验证更新
    boolean updateTelephone(Integer id, String telePhone) throws Exception;
    // 统计学员人数
    Integer countStudent() throws Exception;
    // 统计工作人数
    Integer countWorkStundet() throws Exception;

    // 输出所有职业信息
    List<Profession> findByListProfession() throws Exception;

    // 验证账号信息 返回用户ID
    Integer userAuth(UserAuth userAuth) throws Exception;

    // 通过id查找账号信息
    Boolean findUserAuthByid(Integer id) throws Exception;
}
