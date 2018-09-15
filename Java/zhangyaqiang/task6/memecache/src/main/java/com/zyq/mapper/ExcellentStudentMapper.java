package com.zyq.mapper;

import com.zyq.pojo.ExcellentStudent;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExcellentStudentMapper {
    @Results({ @Result(column = "create_at",property = "createAt"),
            @Result(column = "update_at",property = "updateAt")})
    @Select("select * from excellent_student order by salary desc limit #{0},#{1}")
    List<ExcellentStudent> selectByOrder(Integer startNum, Integer endNum);
    @Select("select * from excellent_student order by salary desc limit #{0},#{1}")
    List<ExcellentStudent> selectByOrder2(Integer startNum, Integer endNum);
}
