package com.dao;

import com.pojo.t_information;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StuInformation {
    //用户名查找
    @Select({"select * from t_information where userId = #{userId}"})
    t_information findById(String userId);
    //插入数据到表格中
    @Insert("insert into t_information(userId,userName,userPassword,create_at,update_at) values (#{userId},#{userName},#{userPassword},#{create_at},#{update_at})")
    void doInsert(t_information t_information);
    @Update("update t_information set userPassword= #{userPassword} where userId=#{userId}")
    void doUpdate(t_information t_information);
}