package hzw.service;

import hzw.model.Profession;
import hzw.model.Students;
import hzw.model.User;

import javax.swing.plaf.ListUI;
import java.util.List;

public interface ServiceManage {
    // 根据id查找学员信息
    Students findByIdStudents(Long id);
    // 输出所有学员信息
    List<Students> findListStudents();
    // 输出所有职业信息
    List<Profession> findListProfession();

    List<Profession> findListProfession1();

    // 根据用户名查询
    User findNameUser(String userName);
    // 查询全部用户
    List<User> findListUser();
    // 添加用户信息
    void insertUser(User user);
    // 统计学员数
    Integer countStudent();
    // 统计工作数
    Integer countWork();
}
