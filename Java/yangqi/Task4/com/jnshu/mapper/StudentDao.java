package com.jnshu.mapper;

import java.util.List;

import com.jnshu.entity.profession;
import com.jnshu.entity.student;
import com.jnshu.entity.user;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {



    //获取student全部信息
    List<student> findAll();
    //获取profession全部信息
    List<profession> findAlls();
    int findName();
    profession addlist(profession profession);







    //登录 和 注册
    user login(String name);

    user findUserByname(String name);

    public void register(user user);

    boolean findUserByid(Integer id);

    boolean AuUser(user user);



 /*   public void addUser(user user);

    public void findUserByNameAndPwd(@Param("name")String name,@Param("password")String password);
*/

   /*
    student addlists(student student);


    //student

    //根据id查找
    student findByIdStudent(Integer id);
    //插入
    boolean addStudent(student student);
    //更新
    boolean updateStuent(student student);
    //删除
    boolean deleteStuent(Integer id);


    //profession

    //根据id查找
    profession findByIdProfession(Integer id);
    //插入
    boolean addStudent(profession profession);
    //更新
    boolean updateStuent(profession profession);
    //删除
    boolean deleteProfession(Integer id);
*/






}
