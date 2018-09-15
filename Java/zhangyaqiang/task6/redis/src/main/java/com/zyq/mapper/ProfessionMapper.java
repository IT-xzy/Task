package com.zyq.mapper;

import com.zyq.pojo.Profession;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProfessionMapper {
    @Results({@Result(column = "development_direction",property = "developmentDirection"),
            @Result(column = "profession_name",property = "professionName"),
            @Result(column = "limit_condition",property = "limitCondition"),
            @Result(column = "period_one",property = "periodOne"),
            @Result(column = "period_two",property = "periodTwo"),
            @Result(column = "carrer_prospects",property = "carrerProspects"),
            @Result(column = "salary_one",property = "salaryOne"),
            @Result(column = "salary_two",property = "salaryTwo"),
            @Result(column = "salary_three",property = "salaryThree"),
            @Result(column = "salary_four",property = "salaryFour"),
            @Result(column = "create_at",property = "createAt"),
            @Result(column = "update_at",property = "updateAt")})
    @Select("select * from profession")
    List<Profession> selectAll();
}
