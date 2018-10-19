package com.dao;

import com.pojo.OcT;
import com.pojo.Occupation;
import com.pojo.Trainees;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mapper {
    //累计学习人数统计
    int accountTrainees();
    //找到工作人数统计
    int countWork();
    //课程在学人数
    int lessonCount(int number);
    //优秀学员获取类
    List<Trainees> niceTrainees();
    //职业
    List<Occupation> queryAllCareers ();
    //职业和人数
    List<OcT>  queryAllCareersAndLesson();
    //通过账号查找密码
    Trainees checkPwd(String account);
    //注册学员
    int loginTrainees(Trainees trainees);
    //通过id查找账号
    String findAccountById(int id);
    //通过id查找学员
    Trainees findTraineesById(int id);
    //通过id查找图片
    String findPicById (int id);
    //通过账号修改密码
    int updatePwd(@Param("password")String password, @Param("account")String account);
    //通过id更新图片
    int updatePicById(@Param("pic") String pic,@Param("id") int id);

}
