package com.mapper;

import com.model.Excellent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ExcellentMapper {

    @Select(value = "select *from excellent_student order by salary desc limit 4")
    List<Excellent> show();

      @Select(value = "select count(0) from excellent_student where status=#{status}")
      long showNumber(int status);
}
