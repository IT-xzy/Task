package com.jnshu.mapper;

import com.jnshu.beans.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    boolean batchUpdate (Map<String ,Object> map);

    void addStu(Student student);

    boolean updateStuTypeById(@Param("id")Integer id,
                          @Param("type")String type,
                          @Param("updateAt")Long updateAt);

    Student selectStuById(Integer id);

    boolean delStuById(Integer id);

    Student selectStuAll();

    Student selectStuByName(String name);

    Student selectStuByOnlineNumber(Integer onlineNumber);

}
