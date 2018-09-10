package com.mutesaid.mapper;

import com.mutesaid.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Long insert(Student record);

    List<Student> getStudent(@Param("key") String key, @Param("value") Object value);

    void delete(String onlineId);

    void update(@Param("onlineId") String onlineId, @Param("key") String key,
                @Param("value") Object value, @Param("currentTime") long currentTime);
}