package com.dao;

import com.pojo.Profession;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PttDao {
    @Select("select * from ptt where profession=#{profession}")
    Profession findProfession(String profession)throws Exception;

    @Select("select stu_number,gra_number from ptt")
    List<Profession> findAll()throws Exception;
}
