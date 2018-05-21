package com.springannotation.dao;


import com.springannotation.model.StudentMod;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 定义了增删改查的接口
 * Created by Administrator on 16/7/2017.
 */
public interface StudentDao {

     @Select("SELECT user_id,name,study_type,qq,entry_data,graduated,url,wish,know_from,create_at,update_at " +
             "FROM student WHERE user_id = #{user_id}")
     StudentMod studySelect(StudentMod studentMod);

     @Insert(" INSERT INTO student (user_id,name,study_type,qq,entry_data,graduated,url,wish,know_from,create_at,update_at)" +
             " VALUES (#{user_id},#{name},#{study_type},#{qq},#{entry_data},#{graduated},#{url},#{wish},#{know_from},#{create_at},#{update_at})")
     int studyInsert(StudentMod studentMod);

     @Update("UPDATE student SET name=#{name} ,update_at=#{update_at} WHERE user_id=#{user_id}")
     int studyUpdate(StudentMod studentMod);

     @Delete("DELETE FROM student WHERE user_id=#{user_id}")
     int studyDelete(String user_id);

     @Select("SELECT (user_id,name,study_type,qq,entry_data,graduated,url,wish,know_from,create_at,update_at)" +
             "FROM student")
     List<StudentMod> studentName();
}
