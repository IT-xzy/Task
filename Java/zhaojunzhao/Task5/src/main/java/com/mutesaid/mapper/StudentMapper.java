package com.mutesaid.mapper;

import com.mutesaid.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll(@Param("name") String name,
                            @Param("qq") String qq,
                            @Param("onlineId") String onlineId,
                            @Param("id") String id);

    void insert(Student stu);

    Boolean update(@Param("id") Long id,
                   @Param("key") String key,
                   @Param("value") Object value,
                   @Param("updateTime") Long updateTime);

    Boolean delete(Long id);
}
